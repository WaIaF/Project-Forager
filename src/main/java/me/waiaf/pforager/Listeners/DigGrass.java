package me.waiaf.pforager.Listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class DigGrass implements Listener {

    @EventHandler
    public void DigGrassEvent(PlayerInteractEvent event){

        Block block = event.getClickedBlock();
        assert block != null;
        Material material = block.getType();
        if (!material.equals(Material.GRASS_BLOCK)) return;
        ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        String itemName = itemMeta.getDisplayName();
        if (itemName.equalsIgnoreCase(ChatColor.of("#5DBB63") + "Xẻng sắt")){

            Location location = block.getLocation();
            location.setY(location.getBlockY() + 0.6575);
            Random random = new Random();
            int rng = random.nextInt(100) + 1;

            if (rng >= 80){

                if (rng > 80 && rng <= 95){

                    block.getWorld().dropItemNaturally(location, new ItemStack(Material.SAND, 1));

                } else {

                    block.getWorld().dropItemNaturally(location, new ItemStack(Material.IRON_ORE, 1));

                }

            }

        }


    }
}
