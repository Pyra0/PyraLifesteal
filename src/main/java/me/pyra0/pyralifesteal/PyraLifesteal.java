package me.pyra0.pyralifesteal;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;

public final class PyraLifesteal extends JavaPlugin {

    private static PyraLifesteal instance;
    private static final HashSet<Listener> listeners = new HashSet<>();

    @Override
    public void onEnable() {
        reloadListeners();
    }

    @Override
    public void onDisable() {

    }

    public static PyraLifesteal getInstance() {
        return instance;
    }

    static void reloadListeners() {
        HandlerList.unregisterAll(instance);
        PluginManager pm = Bukkit.getPluginManager();

    }
}
