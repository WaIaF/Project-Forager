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

        if (event.getClickedBlock() == null) return;
        Block block = event.getClickedBlock();
        assert block != null;
        Material material = block.getType();
        if (!material.equals(Material.GRASS_BLOCK)) return;
        ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();
        if (itemStack.hasItemMeta()){

            ItemMeta itemMeta = itemStack.getItemMeta();
            String itemName = itemMeta.getDisplayName();

            if (itemName.equalsIgnoreCase(ChatColor.of("#F5FEFD") + "Xẻng sắt")){

                Location location = block.getLocation();
                location.setY(location.getBlockY() + 0.6575);
                Random random = new Random();
                int rng = random.nextInt(100) + 1;

                /*
                 *   Iron Shovel Chances:
                 *       90% Nothing
                 *       8% Sand
                 *       2% Iron Ore
                 */

                if (rng >= 90){

                    if (rng > 90 && rng <= 98){

                        block.getWorld().dropItemNaturally(location, new ItemStack(Material.SAND, 1));

                    } else {

                        block.getWorld().dropItemNaturally(location, new ItemStack(Material.IRON_ORE, 1));

                    }

                }

            }


        }

    }
}
