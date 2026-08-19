package ru.cws.helper.fox.fabric;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

import static org.objectweb.asm.Opcodes.*;

public class MixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return "";
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return List.of();
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        if (mixinClassName.equals("ru.cws.helper.fox.fabric.mixin.minecraft.ChatDecoratorMixin")) {
            MethodNode method = targetClass.methods.stream().filter(it -> it.name.equals("decorate") && it.desc.equals("(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/Component;)Ljava/util/concurrent/CompletableFuture;")).findFirst().orElseThrow();
            targetClass.methods.remove(method);
            return;
        }
        if (mixinClassName.equals("ru.cws.helper.fox.fabric.mixin.paper.ImprovedChatDecoratorMixin")) {
            MethodNode method = targetClass.methods.stream().filter(it -> it.name.equals("decorate") && it.desc.equals("(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/Component;)Ljava/util/concurrent/CompletableFuture;")).findFirst().orElseThrow();
            targetClass.methods.remove(method);
        }
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
