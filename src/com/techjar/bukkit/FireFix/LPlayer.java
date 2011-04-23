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
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import java.util.HashSet;

public class LPlayer extends PlayerListener {
    private boolean litBlock = false;
    private HashSet<Byte> transparent = new HashSet<Byte>();

    public LPlayer(FireFix plugin) {
        setupTransparent();
    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        //Player player = event.getPlayer();
        /* if(event.hasItem() || event.hasBlock() || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(canLightBlock(event.getClickedBlock().getTypeId()) && (event.getItem().getType() == Material.FLINT_AND_STEEL || event.getItem().getType() == Material.FIRE)) {
                System.out.println("Woo!");
            }
        } */
        //System.out.println("Woo!");
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            //System.out.println("Woo!");
            //System.out.println(transparent.toString());
            Player player = event.getPlayer();
            //World world = player.getWorld();
            Block block = player.getTargetBlock(transparent, 4);
            //System.out.println(block.getTypeId());
            if(block.getType() == Material.FIRE) {
                //System.out.println("Woo!");
                block.setTypeId(0);
            }
        }
    }

    /* @Override
    public void onPlayerAnimation(PlayerAnimationEvent event) {
        if(event.getAnimationType() == PlayerAnimationType.ARM_SWING) {
            //System.out.println("Woo!");
            if(litBlock) {
                litBlock = false;
                return;
            }
            Player player = event.getPlayer();
            //World world = player.getWorld();
            Block block = player.getTargetBlock(null, 4);
            if(block.getType() == Material.FIRE) {
                block.setTypeId(0);
            }
        }
    } */

    private boolean canLightBlock(int id) {
        switch(id) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 22:
            case 24:
            case 35:
            case 41:
            case 42:
            case 43:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 56:
            case 57:
            case 73:
            case 74:
            case 80:
            case 82:
            case 86:
            case 87:
            case 88:
            case 89:
            case 91:
                return true;
            default:
                return false;
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
