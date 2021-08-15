package me.waiaf.pforager.Listeners;

import me.waiaf.pforager.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    Main plugin;
    public BlockBreak(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void BlockBreakEventForXP(BlockBreakEvent event){

        Block block = event.getBlock();
        Material material = block.getType();
        Player player = event.getPlayer();
        int xp = plugin.playerDataManager.getPlayerXP(player);

        switch (material) {
            case OAK_LOG, COAL_ORE -> {

                xp = xp + 2;
                plugin.playerDataManager.setPlayerXP(player, xp);

            } case STONE -> {

                xp = xp + 1;
                plugin.playerDataManager.setPlayerXP(player, xp);

            } case IRON_ORE -> {

                xp = xp + 4;
                plugin.playerDataManager.setPlayerXP(player, xp);

            } case GOLD_ORE -> {

                xp = xp + 5;
                plugin.playerDataManager.setPlayerXP(player, xp);

            } case DIAMOND_ORE -> {

                xp = xp + 6;
                plugin.playerDataManager.setPlayerXP(player, xp);

            } case ANCIENT_DEBRIS -> {

                xp = xp + 12;
                plugin.playerDataManager.setPlayerXP(player, xp);

            }
        }

        if (plugin.playerDataManager.getPlayerXP(player) >= plugin.getPlayerXPReq(player)){

            plugin.playerDataManager.setPlayerXP(player, 0);
            plugin.playerDataManager.setPlayerLevel(player, plugin.playerDataManager.getPlayerLevel(player) + 1);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);
            player.sendTitle(ChatColor.YELLOW + "Bạn đã lên cấp!", null, 0, 10, 0);

        }

    }
}
