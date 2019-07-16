package com.makotomiyamoto.redragon;

import com.makotomiyamoto.redragon.listener.DragonDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class REDragon extends JavaPlugin {

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new DragonDeathListener(this), this);

        System.out.println("[RE:Dragon v1.0.0] Plugin enabled successfully!");

    }

}
