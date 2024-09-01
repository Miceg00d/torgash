package me.micegood.torgash;

import me.micegood.torgash.command.SpawnVillagerCMD;
import me.micegood.torgash.menu.MenuEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Torgash extends JavaPlugin {

    public static Plugin instance;


    @Override
    public void onEnable() {

        instance = this;

        getCommand("spawnVillager").setExecutor(new SpawnVillagerCMD());

        getServer().getPluginManager().registerEvents(new MenuEvent(), this);
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
