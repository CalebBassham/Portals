package me.calebbassham.portals;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class Util {

    private static String getBaseWorldName(World world) {
        return world.getName().replace("_nether", "").replace("_the_end", "");
    }

    static World getNether(World world) {
        return Bukkit.getWorld(getBaseWorldName(world) + "_nether");
    }

    static World getOverworld(World world) {
        return Bukkit.getWorld(getBaseWorldName(world));
    }

    static World getTheEnd(World world) {
        return Bukkit.getWorld(getBaseWorldName(world) + "_the_end");
    }

}
