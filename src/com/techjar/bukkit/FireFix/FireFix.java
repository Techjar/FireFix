/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @date Apr 22, 2011
 * @author Techjar
 * @version 
 */


package com.techjar.bukkit.FireFix;

import java.util.logging.Logger;
import java.util.logging.Level;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;

public class FireFix extends JavaPlugin {
    static final Logger logger = Logger.getLogger("Minecraft.FireFix");
    private final LPlayer playerListener = new LPlayer(this);
    
    @Override
    public void onEnable() {
        try {
            PluginManager pm = getServer().getPluginManager();
            pm.registerEvent(Type.PLAYER_INTERACT, playerListener, Priority.Highest, this);
            logger.log(Level.INFO, getDescription().getName() + " version " + getDescription().getVersion() + " enabled.");
        }
        catch (Throwable e) {
            logger.log(Level.SEVERE, "Error loading " + getDescription().getName() + ". Disabling plugin!");
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        logger.log(Level.INFO, getDescription().getName() + " version " + getDescription().getVersion() + " disabled.");
    }
}
