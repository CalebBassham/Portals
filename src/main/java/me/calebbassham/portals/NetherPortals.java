package me.calebbassham.portals;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class NetherPortals implements Listener {

    @EventHandler
    public void onNetherPortal(PlayerPortalEvent e) {
        if (e.getCause() != PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) return;

        Player player = e.getPlayer();
        World current = player.getWorld();

        if (current.getEnvironment() == World.Environment.NORMAL) {
            World nether = Util.getNether(current);
            if (nether == null) {
                e.setCancelled(true);
                return;
            }

            Location to = e.getTo();
            to.setWorld(nether);
            e.setTo(to);
        }

        if (current.getEnvironment() == World.Environment.NETHER) {
            World overworld = Util.getOverworld(current);
            if (overworld == null) {
                e.setCancelled(true);
                return;
            }

            Location to = e.getTo();
            to.setWorld(overworld);
            e.setTo(to);
        }
    }

}
