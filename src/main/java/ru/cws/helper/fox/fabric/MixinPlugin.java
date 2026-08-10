package ru.cws.helper.fox.fabric;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
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

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        if (mixinClassName.equals("ru.cws.helper.fox.fabric.mixin.BlockEntityTypeMixin")) {
            {
                MethodVisitor methodVisitor;
                methodVisitor = targetClass.visitMethod(ACC_PUBLIC, "<init>", "(Lnet/minecraft/world/level/block/entity/BlockEntityType$BlockEntitySupplier;Ljava/util/Set;)V", "(Lnet/minecraft/world/level/block/entity/BlockEntityType$BlockEntitySupplier<+TT;>;Ljava/util/Set<Lnet/minecraft/world/level/block/Block;>;Ljava/lang/String;)V", null);
                methodVisitor.visitCode();
                Label label0 = new Label();
                methodVisitor.visitLabel(label0);
                methodVisitor.visitLineNumber(297, label0);
                methodVisitor.visitVarInsn(ALOAD, 0);
                methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
                Label label1 = new Label();
                methodVisitor.visitLabel(label1);
                methodVisitor.visitLineNumber(278, label1);
                methodVisitor.visitVarInsn(ALOAD, 0);
                methodVisitor.visitFieldInsn(GETSTATIC, "net/minecraft/core/registries/BuiltInRegistries", "BLOCK_ENTITY_TYPE", "Lnet/minecraft/core/Registry;");
                methodVisitor.visitVarInsn(ALOAD, 0);
                methodVisitor.visitMethodInsn(INVOKEINTERFACE, "net/minecraft/core/Registry", "createIntrusiveHolder", "(Ljava/lang/Object;)Lnet/minecraft/core/Holder$Reference;", true);
                methodVisitor.visitFieldInsn(PUTFIELD, "net/minecraft/world/level/block/entity/BlockEntityType", "builtInRegistryHolder", "Lnet/minecraft/core/Holder$Reference;");
                Label label2 = new Label();
                methodVisitor.visitLabel(label2);
                methodVisitor.visitLineNumber(298, label2);
                methodVisitor.visitVarInsn(ALOAD, 0);
                methodVisitor.visitFieldInsn(GETSTATIC, "ca/spottedleaf/leafprofiler/LProfilerRegistry", "GLOBAL_REGISTRY", "Lca/spottedleaf/leafprofiler/LProfilerRegistry;");
                methodVisitor.visitLdcInsn("<fabric-defined>");
                methodVisitor.visitInvokeDynamicInsn("makeConcatWithConstants", "(Ljava/lang/String;)Ljava/lang/String;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), new Object[]{"Tile Entity Tick: \u0001"});
                methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "ca/spottedleaf/leafprofiler/LProfilerRegistry", "getOrCreateTimer", "(Ljava/lang/String;)I", false);
                methodVisitor.visitFieldInsn(PUTFIELD, "net/minecraft/world/level/block/entity/BlockEntityType", "tileEntityTimingId", "I");
                Label label3 = new Label();
                methodVisitor.visitLabel(label3);
                methodVisitor.visitLineNumber(300, label3);
                methodVisitor.visitVarInsn(ALOAD, 0);
                methodVisitor.visitVarInsn(ALOAD, 1);
                methodVisitor.visitFieldInsn(PUTFIELD, "net/minecraft/world/level/block/entity/BlockEntityType", "factory", "Lnet/minecraft/world/level/block/entity/BlockEntityType$BlockEntitySupplier;");
                Label label4 = new Label();
                methodVisitor.visitLabel(label4);
                methodVisitor.visitLineNumber(301, label4);
                methodVisitor.visitVarInsn(ALOAD, 0);
                methodVisitor.visitVarInsn(ALOAD, 2);
                methodVisitor.visitFieldInsn(PUTFIELD, "net/minecraft/world/level/block/entity/BlockEntityType", "validBlocks", "Ljava/util/Set;");
                Label label5 = new Label();
                methodVisitor.visitLabel(label5);
                methodVisitor.visitLineNumber(302, label5);
                methodVisitor.visitInsn(RETURN);
                Label label6 = new Label();
                methodVisitor.visitLabel(label6);
                methodVisitor.visitLocalVariable("this", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "Lnet/minecraft/world/level/block/entity/BlockEntityType<TT;>;", label0, label6, 0);
                methodVisitor.visitLocalVariable("factory", "Lnet/minecraft/world/level/block/entity/BlockEntityType$BlockEntitySupplier;", "Lnet/minecraft/world/level/block/entity/BlockEntityType$BlockEntitySupplier<+TT;>;", label0, label6, 1);
                methodVisitor.visitLocalVariable("validBlocks", "Ljava/util/Set;", "Ljava/util/Set<Lnet/minecraft/world/level/block/Block;>;", label0, label6, 2);
                methodVisitor.visitMaxs(3, 3);
                methodVisitor.visitEnd();
            }
        }
    }
}
