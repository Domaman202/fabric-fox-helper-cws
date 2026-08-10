package ru.cws.helper.fox.fabric.mixin;

import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.cws.helper.fox.fabric.command.ModsCommand;

@Mixin(SimpleCommandMap.class)
public abstract class MixinSimpleCommandMap {
	@Shadow
	public abstract boolean register(String fallbackPrefix, Command command);

	@Inject(method = "setDefaultCommands()V", at = @At("TAIL"), remap = false)
	public void registerOwnCommands(CallbackInfo callback) {
		this.register("bukkit", new ModsCommand());
	}
}