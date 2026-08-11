package ru.cws.helper.fox.fabric.chat;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public interface IChatDecorator {
    Component decorate(ServerPlayer par1, Component par2);
    CompletableFuture<Component> decorate(@Nullable ServerPlayer sender, @Nullable CommandSourceStack commandSourceStack, Component message);
}
