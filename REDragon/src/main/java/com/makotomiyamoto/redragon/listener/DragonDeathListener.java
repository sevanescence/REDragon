package com.makotomiyamoto.redragon.listener;

import com.makotomiyamoto.redragon.REDragon;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public final class DragonDeathListener implements Listener {

    private REDragon plugin;

    public DragonDeathListener(REDragon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    @SuppressWarnings("all")
    public void onMobDeath(EntityDeathEvent event) {

        if (!(event.getEntity() instanceof EnderDragon)) {
            return;
        }

        Location coords = event.getEntity().getLocation();

        while (coords.getBlockY() > 0) {

            if (coords.getBlockY() == 1) {
                coords.setY(coords.getBlockY() - 1);
                if (coords.getBlock().getType().equals(Material.AIR)) {
                    coords.getBlock().setType(Material.OBSIDIAN);
                    coords.setY(coords.getBlockY() + 1);
                    coords.getBlock().setType(Material.DRAGON_EGG);
                    break;
                }
            }

            if (!coords.getBlock().getType().equals(Material.AIR)) {
                coords.setY(coords.getBlockY() - 1);
                continue;
            }

            coords.setY(coords.getBlockY() - 1);
            if (coords.getBlock().getType().equals(Material.AIR)) {
                continue;
            }

            coords.setY(coords.getBlockY() + 1);
            coords.getBlock().setType(Material.DRAGON_EGG);
            break;

        }

        if (plugin.getConfig().getString("egg-drop-message").equals("null")) {
            return;
        }

        String message = plugin.getConfig().getString("egg-drop-message");

        if (plugin.getConfig().getString("egg-drop-message").contains("%drop-location%")) {

            String locFormat = plugin.getConfig().getString("drop-location-format");
            if (locFormat == null) {
                locFormat = "&b%x%&7X, &b%y%&7Y, &b%y%&7Z";
                plugin.getConfig().set("drop-location-format", "&bX:%x%&7, &bY:%y%&7, &bZ:%y%");
                plugin.saveConfig();
            }

            locFormat = locFormat.replaceAll("%x%", String.valueOf(coords.getBlockX()));
            locFormat = locFormat.replaceAll("%y%", String.valueOf(coords.getBlockY()));
            locFormat = locFormat.replaceAll("%z%", String.valueOf(coords.getBlockZ()));

            message = message.replaceAll("%drop-location%", locFormat);

        }

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));

    }

}
