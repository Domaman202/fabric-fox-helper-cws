package ru.cws.helper.fox.fabric.command;

import java.util.Collections;
import java.util.List;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class ModsCommand extends BukkitCommand {
    public ModsCommand() {
        super("mods-fabric");
        this.description = "Gets a list of fabric mods running on the server";
        this.usageMessage = "/bukkit:mods-fabric";
        this.setPermission("bukkit.command.plugins");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String currentAlias, @NotNull String @NonNull [] args) {
        if (!testPermission(sender)) return true;

        sender.sendMessage("Mods " + getPluginList());
        return true;
    }

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String @NonNull [] args) throws IllegalArgumentException {
        return Collections.emptyList();
    }

    @NotNull
    private String getPluginList() {
        StringBuilder modList = new StringBuilder();
        ModContainer[] mods = FabricLoader.getInstance().getAllMods().toArray(ModContainer[]::new);

        modList.append(ChatColor.WHITE);
        for (int i = 0; i < mods.length; i++) {
            ModContainer mod = mods[i];

            modList.append(mod.getMetadata().getName()).append(" (").append(ChatColor.ITALIC).append(mod.getMetadata().getVersion()).append(ChatColor.RESET).append(ChatColor.WHITE).append(")");

            if (mod.getMetadata().getDescription() != null) {
                modList.append(" (").append(String.join(", ", mod.getMetadata().getDescription())).append(")");
            }

            if (i + 1 < mods.length) {
                modList.append(", ");
            }
        }

        return "(" + mods.length + "): " + modList;
    }
}
