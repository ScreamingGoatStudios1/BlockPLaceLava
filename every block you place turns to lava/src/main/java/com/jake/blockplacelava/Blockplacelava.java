package com.jake.blockplacelava;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Blockplacelava extends JavaPlugin implements Listener {
    public static Blockplacelava plugin;

    public static boolean isStarted = false;

    @Override
    public void onEnable() {
        getCommand("blockplacelava").setExecutor(new StartCommand());
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
    }

}
