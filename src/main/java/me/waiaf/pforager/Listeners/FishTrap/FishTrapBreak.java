package me.waiaf.pforager.Listeners.FishTrap;

import me.waiaf.pforager.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class FishTrapBreak implements Listener {

    Main plugin;
    public FishTrapBreak(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void FishTrapBreakEvent(BlockBreakEvent event){

        Block block = event.getBlock();

        if (block.getType().equals(Material.BIRCH_TRAPDOOR)){

            if (plugin.CustomBlocks.containsKey(block.getLocation())){

                if (plugin.CustomBlocks.get(block.getLocation()).equalsIgnoreCase("FishTrap")){

                    event.setCancelled(true);
                    block.setType(Material.WATER);
                    ArmorStand hologram = plugin.FishTrapHolograms.get(block.getLocation());
                    hologram.remove();
                    plugin.FishTrapHolograms.remove(block.getLocation());
                    plugin.FishTrapCaughtStatus.remove(block.getLocation());
                    plugin.CustomBlocks.remove(block.getLocation());
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.OAK_PLANKS));
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.OAK_PLANKS));
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.OAK_PLANKS));
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.OAK_PLANKS));
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.OAK_PLANKS));
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SWEET_BERRIES));
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SWEET_BERRIES));
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SWEET_BERRIES));

                }

            }

        }

    }
}
