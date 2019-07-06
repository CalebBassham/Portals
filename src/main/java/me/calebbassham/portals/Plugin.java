package me.calebbassham.portals;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new NetherPortals(), this);
        Bukkit.getPluginManager().registerEvents(new EndPortals(), this);
    }

}
