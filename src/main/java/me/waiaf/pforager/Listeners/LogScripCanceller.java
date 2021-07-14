package me.waiaf.pforager.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class LogScripCanceller implements Listener {

    @EventHandler
    public void LogScripEvent(PlayerInteractEvent event){

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.STONE_AXE) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.WOODEN_AXE) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.IRON_AXE) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_AXE) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_AXE) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_AXE)){

                if (event.getClickedBlock() != null){

                    if (event.getClickedBlock().getType().equals(Material.SPRUCE_LOG) ||
                            event.getClickedBlock().getType().equals(Material.OAK_LOG) ||
                            event.getClickedBlock().getType().equals(Material.DARK_OAK_LOG) ||
                            event.getClickedBlock().getType().equals(Material.ACACIA_LOG) ||
                            event.getClickedBlock().getType().equals(Material.BIRCH_LOG) ||
                            event.getClickedBlock().getType().equals(Material.JUNGLE_LOG)){

                            event.setCancelled(true);

                    }

                }


            }

        }

    }
}
