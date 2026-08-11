package ru.cws.helper.fox.fabric.mixin.minecraft;

import net.minecraft.core.registries.BuiltInRegistries;
import org.cardboardpowered.RegistryUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltInRegistries.class)
public class BuiltInRegistriesMixin {
    @Inject(method = "freeze", at = @At("HEAD"))
    private static void freeze(CallbackInfo ci) {
        RegistryUtil.inject_into_bukkit_registry();
    }
}
