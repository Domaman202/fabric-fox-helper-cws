package ru.cws.helper.fox.fabric.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.craftbukkit.inventory.CraftInventory;
import org.bukkit.inventory.InventoryView;
import org.cardboardpowered.impl.inventory.CustomInventoryView;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerMenu.class)
public class AbstractContainerMenuMixin {
    /**
     * @author DomamaN202
     * @reason Z
     */
    @Dynamic
    @Overwrite
    public InventoryView getBukkitView() {
        CraftInventory cbi = new CraftInventory(new SimpleContainer(((AbstractContainerMenu) (Object)this).getItems().toArray(ItemStack[]::new)));
        return new CustomInventoryView(null, cbi, ((AbstractContainerMenu) (Object)this));
    }

    @Inject(method = "transferTo(Lnet/minecraft/world/inventory/AbstractContainerMenu;Lorg/bukkit/craftbukkit/entity/CraftHumanEntity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/Container;onClose(Lorg/bukkit/craftbukkit/entity/CraftHumanEntity;)V", ordinal = 0), cancellable = true)
    public void transferTo(AbstractContainerMenu other, CraftHumanEntity player, CallbackInfo ci, @Local(ordinal = 0) InventoryView source, @Local(ordinal = 1) InventoryView destination) {
       if (source instanceof CustomInventoryView || destination instanceof CustomInventoryView) {
            ci.cancel();
        }
    }
}
