package com.makotomiyamoto.redragon.listener;

import com.makotomiyamoto.redragon.REDragon;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public final class WorldChangeListener implements Listener {

    private REDragon plugin;

    public WorldChangeListener(REDragon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    @SuppressWarnings("all")
    public void onWorldChange(PlayerChangedWorldEvent event) {

        if (!event.getPlayer().getWorld().getBiome(0, 0).equals(Biome.THE_END) ||
                plugin.getConfig().getBoolean("default-dragon-dead")) {
            return;
        }

        Location loc = new Location(event.getPlayer().getWorld(), 0, 0, 0);

        for (int i = 0; i < 256; i++) {

            if (loc.add(0, i, 0).getBlock().getType().equals(Material.BEDROCK) &&
                    loc.add(1, 0, 1).getBlock().getType().equals(Material.END_PORTAL)) {
                plugin.getConfig().set("default-dragon-dead", true);
                plugin.saveConfig();
                event.getHandlerList().unregister(this);
                break;
            }

        }

    }

}
