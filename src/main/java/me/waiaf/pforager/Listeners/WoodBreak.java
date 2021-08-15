package me.waiaf.pforager.Listeners;

import me.waiaf.pforager.Main;
import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class WoodBreak implements Listener {

    Main plugin;
    public WoodBreak(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void WoodBreakEvent(BlockBreakEvent event){

        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        int xp = plugin.playerDataManager.getPlayerXP(player);
        if (itemStack.isSimilar(ItemManager.IronAxe)){

            Random random = new Random();
            int rng = random.nextInt(100) + 1;

            switch (event.getBlock().getType()) {
                case ACACIA_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_PLANKS));
                    RNGBonus(new ItemStack(Material.ACACIA_PLANKS), event.getBlock());
                }
                case BIRCH_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_PLANKS));
                    RNGBonus(new ItemStack(Material.BIRCH_PLANKS), event.getBlock());
                }
                case DARK_OAK_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_PLANKS));
                    RNGBonus(new ItemStack(Material.DARK_OAK_PLANKS), event.getBlock());
                }
                case OAK_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_PLANKS));
                    RNGBonus(new ItemStack(Material.OAK_PLANKS), event.getBlock());
                }
                case JUNGLE_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_PLANKS));
                    RNGBonus(new ItemStack(Material.JUNGLE_PLANKS), event.getBlock());
                }
                case SPRUCE_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_PLANKS));
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_PLANKS));
                    RNGBonus(new ItemStack(Material.SPRUCE_PLANKS), event.getBlock());
                }
            }

        } else {

            switch (event.getBlock().getType()) {
                case ACACIA_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ACACIA_PLANKS));
                }
                case BIRCH_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.BIRCH_PLANKS));
                }
                case DARK_OAK_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DARK_OAK_PLANKS));
                }
                case OAK_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OAK_PLANKS));
                }
                case JUNGLE_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.JUNGLE_PLANKS));
                }
                case SPRUCE_LOG -> {
                    event.setCancelled(true);
                    event.getBlock().setType(Material.AIR);
                    event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.SPRUCE_PLANKS));
                }
            }

            xp = xp + 2;
            plugin.playerDataManager.setPlayerXP(player, xp);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);
            player.sendMessage(ChatColor.YELLOW + "+2 XP");

        }

    }

    private void RNGBonus(ItemStack itemStack, Block block){

        Random random = new Random();
        int rng = random.nextInt(100) + 1;

        if (rng >= 60){

            block.getWorld().dropItemNaturally(block.getLocation(), itemStack);

        }

        if (rng >= 90){

            block.getWorld().dropItemNaturally(block.getLocation(), itemStack);

        }

    }

}
