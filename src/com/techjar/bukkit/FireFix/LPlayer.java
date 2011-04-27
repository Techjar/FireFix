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

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.Material;

public class LPlayer extends PlayerListener {
    public LPlayer(FireFix plugin) {
    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getAction() == Action.LEFT_CLICK_BLOCK) {
            Block block = event.getClickedBlock().getFace(event.getBlockFace());
            if(block.getType() == Material.FIRE) {
                block.setTypeId(0);
            }
        }
    }
}
