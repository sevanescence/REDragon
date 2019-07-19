package com.makotomiyamoto.redragon;

import com.makotomiyamoto.redragon.listener.DragonDeathListener;
import com.makotomiyamoto.redragon.listener.WorldChangeListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class REDragon extends JavaPlugin {

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new DragonDeathListener(this), this);

        if (!this.getConfig().getBoolean("default-dragon-dead")) {

            this.getServer().getPluginManager().registerEvents(new WorldChangeListener(this), this);

            System.out.println("[RE:Dragon v1.1.1] Default dragon not presumed dead. Activating portal check.");

        }

        System.out.println("[RE:Dragon v1.0.0] Plugin enabled successfully!");

    }

}
