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

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Biome;
import org.bukkit.Material;
//import org.bukkit.event.block.BlockBurnEvent;
//import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;

public class LBlock extends BlockListener {
    public LBlock(FireFix plugin) {
    }

    @Override
    public void onBlockIgnite(BlockIgniteEvent event) {
        World world = event.getBlock().getWorld();
        if(world.hasStorm()) {
            boolean center = false, top = false, bottom = false, left = false, right = false;
            //Location oldLoc = event.getBlock().getLocation();
            //Block block = world.getBlockAt(oldLoc.getBlockX(), oldLoc.getBlockY() + 1, oldLoc.getBlockZ());
            Block block = event.getBlock();
            Location loc = block.getLocation();
            /* if(!isBlockSolid(world.getBlockAt(loc.getBlockX() + 1, loc.getBlockY(), loc.getBlockZ()).getTypeId()) || !isBlockSolid(world.getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ() + 1).getTypeId()) || !isBlockSolid(world.getBlockAt(loc.getBlockX() - 1, loc.getBlockY(), loc.getBlockZ()).getTypeId()) || !isBlockSolid(world.getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ() - 1).getTypeId())) {
                event.setCancelled(true);
                return;
            } */
            //System.out.println(loc.getBlockY());
            //System.out.println(block.getTypeId());
            if(world.getBlockAt(loc.getBlockX(), loc.getBlockY() - 1, loc.getBlockZ()).getType() == Material.NETHERRACK) {
                return;
            }
            if(block.getBiome() == Biome.DESERT || block.getBiome() == Biome.ICE_DESERT || block.getBiome() == Biome.TAIGA || block.getBiome() == Biome.TUNDRA) {
                return;
            }
            for(int i = loc.getBlockY(); i < 128; i++) {
                Block block2 = world.getBlockAt(loc.getBlockX(), i, loc.getBlockZ());
                //System.out.println(block2.getTypeId());
                if(isBlockSolid(block2.getTypeId())) {
                    center = true;
                }
            }
            for(int i = loc.getBlockY(); i < 128; i++) {
                Block block2 = world.getBlockAt(loc.getBlockX() + 1, i, loc.getBlockZ());
                if(isBlockSolid(block2.getTypeId())) {
                    top = true;
                }
            }
            for(int i = loc.getBlockY(); i < 128; i++) {
                Block block2 = world.getBlockAt(loc.getBlockX() - 1, i, loc.getBlockZ());
                if(isBlockSolid(block2.getTypeId())) {
                    bottom = true;
                }
            }
            for(int i = loc.getBlockY(); i < 128; i++) {
                Block block2 = world.getBlockAt(loc.getBlockX(), i, loc.getBlockZ() - 1);
                if(isBlockSolid(block2.getTypeId())) {
                    left = true;
                }
            }
            for(int i = loc.getBlockY(); i < 128; i++) {
                Block block2 = world.getBlockAt(loc.getBlockX(), i, loc.getBlockZ() + 1);
                if(isBlockSolid(block2.getTypeId())) {
                    right = true;
                }
            }
            /* System.out.println(center);
            System.out.println(top);
            System.out.println(bottom);
            System.out.println(left);
            System.out.println(right); */
            if(!center || !top || !bottom || !left || !right) {
                event.setCancelled(true);
            }
        }
    }

    private boolean isBlockSolid(int id) {
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
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 35:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 52:
            case 53:
            case 54:
            case 56:
            case 57:
            case 58:
            case 60:
            case 61:
            case 62:
            case 64:
            case 67:
            case 71:
            case 73:
            case 74:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 91:
            case 92:
            case 95:
                return true;
            default:
                return false;
        }
    }
}
