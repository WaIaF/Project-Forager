package me.waiaf.pforager.Listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class WoodBreak implements Listener {

    @EventHandler
    public void WoodBreakEvent(BlockBreakEvent event){

        if (!event.getBlock().getType().equals(Material.ACACIA_LOG) ||
                !event.getBlock().getType().equals(Material.BIRCH_LOG) ||
                !event.getBlock().getType().equals(Material.DARK_OAK_LOG) ||
                !event.getBlock().getType().equals(Material.JUNGLE_LOG) ||
                !event.getBlock().getType().equals(Material.OAK_LOG) ||
                !event.getBlock().getType().equals(Material.SPRUCE_LOG)) return;

        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        String itemName = itemMeta.getDisplayName();
        event.setCancelled(true);
        event.getBlock().setType(Material.AIR);

        if (itemName.equalsIgnoreCase(ChatColor.of("#F5FEFD") + "Rìu sắt")){

            Random random = new Random();
            int rng = random.nextInt(100) + 1;

            switch (itemStack.getType()){

                case ACACIA_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_WOOD));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_WOOD));

                    if (rng >= 60){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_WOOD));

                    }

                    if (rng >= 90){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_WOOD));

                    }

                    break;

                case BIRCH_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_WOOD));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_WOOD));

                    if (rng >= 60){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_WOOD));

                    }

                    if (rng >= 90){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_WOOD));

                    }

                    break;

                case DARK_OAK_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_WOOD));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_WOOD));

                    if (rng >= 60){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_WOOD));

                    }

                    if (rng >= 90){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_WOOD));

                    }

                    break;

                case OAK_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_WOOD));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_WOOD));

                    if (rng >= 60){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_WOOD));

                    }

                    if (rng >= 90){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_WOOD));

                    }

                    break;

                case JUNGLE_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_WOOD));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_WOOD));

                    if (rng >= 60){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_WOOD));

                    }

                    if (rng >= 90){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_WOOD));

                    }

                    break;

                case SPRUCE_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_WOOD));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_WOOD));

                    if (rng >= 60){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_WOOD));

                    }

                    if (rng >= 90){

                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_WOOD));

                    }

                    break;
            }


        } else {

            switch (itemStack.getType()){

                case ACACIA_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_WOOD));
                    break;

                case BIRCH_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_WOOD));
                    break;

                case DARK_OAK_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_WOOD));
                    break;

                case OAK_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_WOOD));
                    break;

                case JUNGLE_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_WOOD));
                    break;

                case SPRUCE_LOG:

                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_WOOD));
                    break;
            }

        }

    }
}
