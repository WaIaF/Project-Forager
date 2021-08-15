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

        switch (material) {
            case OAK_LOG, COAL_ORE -> plugin.playerDataManager.setPlayerXP(player, (plugin.playerDataManager.getPlayerXP(player) + 2));
            case STONE -> plugin.playerDataManager.setPlayerXP(player, (plugin.playerDataManager.getPlayerXP(player) + 1));
            case IRON_ORE -> plugin.playerDataManager.setPlayerXP(player, (plugin.playerDataManager.getPlayerXP(player) + 4));
            case GOLD_ORE -> plugin.playerDataManager.setPlayerXP(player, (plugin.playerDataManager.getPlayerXP(player) + 5));
            case DIAMOND_ORE -> plugin.playerDataManager.setPlayerXP(player, (plugin.playerDataManager.getPlayerXP(player) + 6));
            case ANCIENT_DEBRIS -> plugin.playerDataManager.setPlayerXP(player, (plugin.playerDataManager.getPlayerXP(player) + 7));
        }

        if (plugin.playerDataManager.getPlayerXP(player) >= plugin.getPlayerXPReq(player)){

            plugin.playerDataManager.setPlayerXP(player, 0);
            plugin.playerDataManager.setPlayerLevel(player, plugin.playerDataManager.getPlayerLevel(player) + 1);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);
            player.sendTitle(ChatColor.YELLOW + "Bạn đã lên cấp!", null, 0, 1, 0);

        }

    }
}
