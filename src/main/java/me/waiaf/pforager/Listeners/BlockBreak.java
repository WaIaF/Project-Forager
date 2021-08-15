package me.waiaf.pforager.Listeners;

import me.waiaf.pforager.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
    public void BlockBreakEventForLV(BlockBreakEvent event){

        Block block = event.getBlock();
        Material material = block.getType();
        Player player = event.getPlayer();

        if (plugin.playerDataManager.getPlayerXP(player) >= plugin.getPlayerXPReq(player)){

            plugin.playerDataManager.setPlayerXP(player, 0);
            plugin.playerDataManager.setPlayerLevel(player, plugin.playerDataManager.getPlayerLevel(player) + 1);
            player.sendTitle(ChatColor.YELLOW + "Bạn đã lên cấp!", null, 0, 10, 0);

        }

    }
}
