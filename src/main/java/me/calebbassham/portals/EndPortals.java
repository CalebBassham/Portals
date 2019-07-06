package me.calebbassham.portals;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EndPortals implements Listener {

    @EventHandler
    public void onEndPortal(PlayerPortalEvent e) {
        if (e.getCause() != PlayerTeleportEvent.TeleportCause.END_PORTAL) return;

        Player player = e.getPlayer();
        World current = player.getWorld();

        if (current.getEnvironment() == World.Environment.NORMAL) {
            World end = Util.getTheEnd(current);
            if (end == null) {
                e.setCancelled(true);
                return;
            }

            Location to = e.getTo();
            to.setWorld(end);
            e.setTo(to);
        }

        if (current.getEnvironment() == World.Environment.THE_END) {
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
