package ru.cws.helper.fox.fabric.mixin.minecraft;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.ChatDecorator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import ru.cws.helper.fox.fabric.chat.IChatDecorator;

import java.util.concurrent.CompletableFuture;

@Mixin(ChatDecorator.class)
public interface ChatDecoratorMixin extends IChatDecorator {
    @Override
    Component decorate(ServerPlayer par1, Component par2);

    /**
     * @author DomamaN202
     * @reason Z
     */
    @Override
    @Overwrite
    default CompletableFuture<Component> decorate(@Nullable ServerPlayer sender, @Nullable CommandSourceStack commandSourceStack, Component message) {
        return CompletableFuture.completedFuture(this.decorate(sender, message));
    }
}
