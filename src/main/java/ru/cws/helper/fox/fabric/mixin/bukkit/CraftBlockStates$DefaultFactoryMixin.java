package ru.cws.helper.fox.fabric.mixin.bukkit;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "org.bukkit.craftbukkit.block.CraftBlockStates$1", remap = false)
public class CraftBlockStates$DefaultFactoryMixin {
    @Redirect(method = "createBlockState", at = @At(value = "INVOKE", target = "Lcom/google/common/base/Preconditions;checkState(ZLjava/lang/String;Ljava/lang/Object;)V"), remap = false)
    public void noCheckState(boolean expression, String errorMessageTemplate, Object p1) {
    }
}
