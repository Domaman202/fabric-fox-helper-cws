package ru.cws.helper.fox.fabric.mixin.bukkit;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.cardboardpowered.bridge.bukkit.entity.BukkitEntityTypeBridge;
import org.jetbrains.annotations.ApiStatus;
import org.spongepowered.asm.mixin.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author cardboard
 */
@Mixin(EntityType.class)
public class BukkitEntityTypeMixin implements BukkitEntityTypeBridge {
    @Shadow
    private static final Map<String, EntityType> NAME_MAP = new HashMap<>();

    @Shadow
    private static final Map<Short, EntityType> ID_MAP = new HashMap<>();

    @Shadow
    @Final
    @Mutable
    private NamespacedKey key;

    @Override
    public void cardboard$setKey(NamespacedKey newKey) {
        this.key = newKey;
    }

    @Override
    public void cardboard$addToMaps(String key1, int key2) {
        EntityType type = (EntityType) (Object) this;
        NAME_MAP.put(key1.toLowerCase(), type);
        ID_MAP.put((short) key2, type);
    }

    /**
     * @author cardboard
     * @reason Z
     */
    @ApiStatus.Internal
    @Overwrite(remap = false)
    public static EntityType fromName(String name) {
        if (name == null) {
            return null;
        }
        return NAME_MAP.get(name.toLowerCase(Locale.ROOT));
    }

    /**
     * @author cardboard
     * @reason Z
     */
    @Overwrite(remap = false)
    public static EntityType fromId(int id) {
        if (id > Short.MAX_VALUE) {
            return null;
        }
        return ID_MAP.get((short) id);
    }
}
