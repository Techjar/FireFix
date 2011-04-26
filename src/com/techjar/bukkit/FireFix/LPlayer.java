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
import org.bukkit.entity.Player;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import java.util.HashSet;

public class LPlayer extends PlayerListener {
    private HashSet<Byte> transparent = new HashSet<Byte>();

    public LPlayer(FireFix plugin) {
        setupTransparent();
    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            Block block = player.getTargetBlock(transparent, 4);
            if(block.getType() == Material.FIRE) {
                block.setTypeId(0);
            }
        }
    }

    private void setupTransparent() {
        transparent.add(new Integer(0).byteValue());
        transparent.add(new Integer(26).byteValue());
        transparent.add(new Integer(27).byteValue());
        transparent.add(new Integer(28).byteValue());
        transparent.add(new Integer(37).byteValue());
        transparent.add(new Integer(38).byteValue());
        transparent.add(new Integer(39).byteValue());
        transparent.add(new Integer(40).byteValue());
        transparent.add(new Integer(44).byteValue());
        transparent.add(new Integer(50).byteValue());
        transparent.add(new Integer(55).byteValue());
        transparent.add(new Integer(59).byteValue());
        transparent.add(new Integer(63).byteValue());
        transparent.add(new Integer(65).byteValue());
        transparent.add(new Integer(66).byteValue());
        transparent.add(new Integer(68).byteValue());
        transparent.add(new Integer(69).byteValue());
        transparent.add(new Integer(70).byteValue());
        transparent.add(new Integer(72).byteValue());
        transparent.add(new Integer(75).byteValue());
        transparent.add(new Integer(76).byteValue());
        transparent.add(new Integer(77).byteValue());
        transparent.add(new Integer(78).byteValue());
        transparent.add(new Integer(93).byteValue());
        transparent.add(new Integer(94).byteValue());
    }
}
