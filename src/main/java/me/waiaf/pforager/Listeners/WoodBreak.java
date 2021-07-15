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

        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack.hasItemMeta()){

            ItemMeta itemMeta = itemStack.getItemMeta();
            assert itemMeta != null;
            String itemName = itemMeta.getDisplayName();

            if (itemName.equalsIgnoreCase(ChatColor.of("#F5FEFD") + "Rìu sắt")){

                Random random = new Random();
                int rng = random.nextInt(100) + 1;

                switch (event.getBlock().getType()){

                    case ACACIA_LOG:

                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_PLANKS, 3));

                        if (rng >= 60){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_PLANKS));

                        }

                        if (rng >= 90){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_PLANKS));

                        }

                        break;

                    case BIRCH_LOG:

                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_PLANKS, 3));

                        if (rng >= 60){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_PLANKS));

                        }

                        if (rng >= 90){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_PLANKS));

                        }

                        break;

                    case DARK_OAK_LOG:

                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_PLANKS, 3));

                        if (rng >= 60){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_PLANKS));

                        }

                        if (rng >= 90){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_PLANKS));

                        }

                        break;

                    case OAK_LOG:

                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_PLANKS, 3));

                        if (rng >= 60){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_PLANKS));

                        }

                        if (rng >= 90){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_PLANKS));

                        }

                        break;

                    case JUNGLE_LOG:

                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_PLANKS, 3));

                        if (rng >= 60){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_PLANKS));

                        }

                        if (rng >= 90){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_PLANKS));

                        }

                        break;

                    case SPRUCE_LOG:

                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_PLANKS, 3));

                        if (rng >= 60){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_PLANKS));

                        }

                        if (rng >= 90){

                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_PLANKS));

                        }

                        break;
                }


            }

        } else {

            switch (event.getBlock().getType()){

                case ACACIA_LOG:

                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_PLANKS));
                    break;

                case BIRCH_LOG:

                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_PLANKS));
                    break;

                case DARK_OAK_LOG:

                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_PLANKS));
                    break;

                case OAK_LOG:

                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_PLANKS));
                    break;

                case JUNGLE_LOG:

                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_PLANKS));
                    break;

                case SPRUCE_LOG:

                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_PLANKS));
                    break;
            }

        }

    }
}
