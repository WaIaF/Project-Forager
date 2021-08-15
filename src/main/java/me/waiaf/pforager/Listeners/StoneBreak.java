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

public class StoneBreak implements Listener {

    Main plugin;
    public StoneBreak(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void StoneBreakEvent(BlockBreakEvent event){
        
        if (!event.getBlock().getType().equals(Material.STONE)) return;
        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        int xp = plugin.playerDataManager.getPlayerXP(player);

        if (itemStack.isSimilar(ItemManager.IronPickaxe)){

            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBBLESTONE));
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBBLESTONE));
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBBLESTONE));
            RNGBonus(event.getBlock());

        }

        xp = xp + 2;
        plugin.playerDataManager.setPlayerXP(player, xp);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);
        player.sendMessage(ChatColor.YELLOW + "+2 XP");

    }

    private void RNGBonus(Block block){

        Random random = new Random();
        int rng = random.nextInt(100) + 1;

        if (rng >= 60){

            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE));

        }

        if (rng >= 90){

            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE));

        }

    }
}
