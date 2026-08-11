package ru.cws.helper.fox.fabric.mixin.paper;

import io.papermc.paper.adventure.ImprovedChatDecorator;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import ru.cws.helper.fox.fabric.chat.IChatDecorator;

import java.util.concurrent.CompletableFuture;

@Mixin(ImprovedChatDecorator.class)
public abstract class ImprovedChatDecoratorMixin implements IChatDecorator {
    @Shadow
    private static CompletableFuture<Component> decorate(MinecraftServer server, @Nullable ServerPlayer player, @Nullable CommandSourceStack commandSourceStack, Component originalMessage) {
        throw new UnsupportedOperationException("Implemented via mixin");
    }

    @Shadow
    @Final
    private MinecraftServer server;

    @Override
    public Component decorate(ServerPlayer sender, Component message) {
        return decorate(this.server, sender, null, message).join();
    }
}
