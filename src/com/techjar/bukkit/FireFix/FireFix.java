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

//import java.io.File;
import java.util.logging.Logger;
import java.util.logging.Level;
//import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
//import org.bukkit.util.config.Configuration;

public class FireFix extends JavaPlugin {
    static final Logger logger = Logger.getLogger("Minecraft.FireFix");
    //private final LBlock blockListener = new LBlock(this);
    private final LPlayer playerListener = new LPlayer(this);
    //private Configuration config;
    
    @Override
    public void onEnable() {
        try {
            //loadConfig();
            PluginManager pm = getServer().getPluginManager();
            //if(config.getBoolean("firefix.rainfire", true)){pm.registerEvent(Type.BLOCK_IGNITE, blockListener, Priority.Highest, this);}
            //pm.registerEvent(Type.PLAYER_ANIMATION, playerListener, Priority.Highest, this);
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

    /* private void loadConfig() {
        File dataDirectory = new File("plugins" + File.separator + "FireFix" + File.separator);
        dataDirectory.mkdirs();
        File file = new File("plugins" + File.separator + "FireFix", "config.yml");
        config = new Configuration(file);
        config.load();
        if(!file.exists()) {
            logger.log(Level.INFO, getDescription().getName() + " config.yml not found, creating default configuration...");
            config.setProperty("firefix.punchfire", true);
            config.setProperty("firefix.rainfire", true);
            config.save();
        }
        logger.log(Level.INFO, getDescription().getName() + " configuration loaded.");
    } */
}
