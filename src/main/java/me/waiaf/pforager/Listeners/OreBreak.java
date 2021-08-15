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

public class OreBreak implements Listener {

    Main plugin;

    public OreBreak(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void OreBreakEvent(BlockBreakEvent event){

        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        Block block = event.getBlock();
        int xp = plugin.playerDataManager.getPlayerXP(player);
        Random random = new Random();
        int rng = random.nextInt(100) + 1;

        if (itemStack.isSimilar(ItemManager.IronPickaxe)){

            switch (block.getType()) {
                case COAL_ORE -> {

                    CancelAndSetAir(event, block);
                    DropWithCobble(new ItemStack(Material.COAL), block);
                    RNGBonus(new ItemStack(Material.COAL), block);
                    xp = xp + 2;
                    plugin.playerDataManager.setPlayerXP(player, xp);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);
                    player.sendMessage(ChatColor.YELLOW + "+2 XP");

                }
                case IRON_ORE -> {

                    CancelAndSetAir(event, block);
                    DropWithCobble(new ItemStack(Material.RAW_IRON), block);
                    RNGBonus(new ItemStack(Material.RAW_IRON), block);
                    xp = xp + 4;
                    plugin.playerDataManager.setPlayerXP(player, xp);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);
                    player.sendMessage(ChatColor.YELLOW + "+4 XP");

                }
                case GOLD_ORE -> {

                    CancelAndSetAir(event, block);
                    DropWithCobble(new ItemStack(Material.RAW_GOLD), block);
                    RNGBonus(new ItemStack(Material.RAW_GOLD), block);
                    xp = xp + 5;
                    plugin.playerDataManager.setPlayerXP(player, xp);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);
                    player.sendMessage(ChatColor.YELLOW + "+5 XP");

                }
                case DIAMOND_ORE -> {

                    CancelAndSetAir(event, block);
                    DropWithCobble(new ItemStack(Material.DIAMOND), block);
                    RNGBonus(new ItemStack(Material.DIAMOND), block);
                    xp = xp + 6;
                    plugin.playerDataManager.setPlayerXP(player, xp);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);
                    player.sendMessage(ChatColor.YELLOW + "+6 XP");

                }
                case ANCIENT_DEBRIS -> {

                    CancelAndSetAir(event, event.getBlock());
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.ANCIENT_DEBRIS));
                    RNGBonus(new ItemStack(Material.ANCIENT_DEBRIS), event.getBlock());
                    xp = xp + 12;
                    plugin.playerDataManager.setPlayerXP(player, xp);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);
                    player.sendMessage(ChatColor.YELLOW + "+12 XP");

                }
            }

        }
    }

    private void CancelAndSetAir(BlockBreakEvent event, Block block){

        event.setCancelled(true);
        block.setType(Material.AIR);

    }

    private void DropWithCobble(ItemStack itemStack, Block block){

        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE));
        block.getWorld().dropItemNaturally(block.getLocation(), itemStack);

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
