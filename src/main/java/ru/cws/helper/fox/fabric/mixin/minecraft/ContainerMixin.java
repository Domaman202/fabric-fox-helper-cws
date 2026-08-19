package ru.cws.helper.fox.fabric.mixin.minecraft;

import net.minecraft.world.Container;
import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Container.class)
public interface ContainerMixin {
    /**
     * @author DomamaN202
     * @reason Z
     */
    @Overwrite
    default void onOpen(CraftHumanEntity var1) {

    }

    /**
     * @author DomamaN202
     * @reason Z
     */
    @Overwrite
    default void onClose(CraftHumanEntity var1) {

    }
}
