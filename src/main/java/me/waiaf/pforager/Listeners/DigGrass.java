package me.waiaf.pforager.Listeners;

import me.waiaf.pforager.Main;
import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class DigGrass implements Listener {

    @EventHandler
    public void DigGrassEvent(PlayerInteractEvent event){

        Block block = event.getClickedBlock();
        if (block == null) return;
        Material material = block.getType();
        if (!material.equals(Material.GRASS_BLOCK)) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();

        if (itemStack.isSimilar(ItemManager.IronShovel)){

            Location location = block.getLocation();
            location.setY(location.getBlockY() + 0.6575);
            Random random = new Random();
            int rng = random.nextInt(100) + 1;

            /*
             *   Iron Shovel Chances:
             *       95% Nothing
             *       4% Sand
             *       1% Iron Ore
             */

            if (rng >= 96){

                if (rng <= 99){

                    block.getWorld().dropItemNaturally(location, new ItemStack(Material.SAND, 1));

                } else {

                    block.getWorld().dropItemNaturally(location, new ItemStack(Material.IRON_ORE, 1));

                }

            }

            TurnPathBackToDirt(block);

        }

    }

    private void TurnPathBackToDirt(Block block){

        new BukkitRunnable(){

            @Override
            public void run(){

                if (!block.getType().equals(Material.DIRT_PATH)) return;

                block.setType(Material.GRASS_BLOCK);

            }

        }.runTaskLater(Main.getPlugin(Main.class), 200);

    }
}
