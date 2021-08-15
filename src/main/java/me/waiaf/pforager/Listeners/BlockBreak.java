package me.waiaf.pforager.Listeners;

import me.waiaf.pforager.Main;
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
    public void BlockBreakEventForXP(BlockBreakEvent event){

        Block block = event.getBlock();
        Material material = block.getType();
        Player player = event.getPlayer();

        switch (material){

            case OAK_LOG, COAL_ORE:

                plugin.playerDataManager.increasePlayerXP(player, 2);

                if (plugin.playerDataManager.getPlayerXP(player) >= plugin.getPlayerXPReq(player)){

                    plugin.playerDataManager.setPlayerXP(player, 0);
                    plugin.playerDataManager.setPlayerLevel(player, plugin.playerDataManager.getPlayerLevel(player) + 1);

                }
                break;

            case STONE:

                plugin.playerDataManager.increasePlayerXP(player, 1);

                if (plugin.playerDataManager.getPlayerXP(player) >= plugin.getPlayerXPReq(player)){

                    plugin.playerDataManager.setPlayerXP(player, 0);
                    plugin.playerDataManager.setPlayerLevel(player, plugin.playerDataManager.getPlayerLevel(player) + 1);

                }
                break;

            case IRON_ORE:

                plugin.playerDataManager.increasePlayerXP(player, 4);

                if (plugin.playerDataManager.getPlayerXP(player) >= plugin.getPlayerXPReq(player)){

                    plugin.playerDataManager.setPlayerXP(player, 0);
                    plugin.playerDataManager.setPlayerLevel(player, plugin.playerDataManager.getPlayerLevel(player) + 1);

                }
                break;

            case GOLD_ORE:

                plugin.playerDataManager.increasePlayerXP(player, 5);

                if (plugin.playerDataManager.getPlayerXP(player) >= plugin.getPlayerXPReq(player)){

                    plugin.playerDataManager.setPlayerXP(player, 0);
                    plugin.playerDataManager.setPlayerLevel(player, plugin.playerDataManager.getPlayerLevel(player) + 1);

                }
                break;

            case DIAMOND_ORE:

                plugin.playerDataManager.increasePlayerXP(player, 7);

                if (plugin.playerDataManager.getPlayerXP(player) >= plugin.getPlayerXPReq(player)){

                    plugin.playerDataManager.setPlayerXP(player, 0);
                    plugin.playerDataManager.setPlayerLevel(player, plugin.playerDataManager.getPlayerLevel(player) + 1);

                }

            case ANCIENT_DEBRIS:

                plugin.playerDataManager.increasePlayerXP(player, 12);

                if (plugin.playerDataManager.getPlayerXP(player) >= plugin.getPlayerXPReq(player)){

                    plugin.playerDataManager.setPlayerXP(player, 0);
                    plugin.playerDataManager.setPlayerLevel(player, plugin.playerDataManager.getPlayerLevel(player) + 1);

                }
                break;
        }

    }
}
