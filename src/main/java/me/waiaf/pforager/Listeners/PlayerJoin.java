package me.waiaf.pforager.Listeners;

import me.waiaf.pforager.Main;
import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    Main plugin;
    public PlayerJoin(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()){

            player.getInventory().addItem(ItemManager.IronPickaxe);
            player.getInventory().addItem(ItemManager.IronAxe);

        }

        if (plugin.playerDataManager.playerHasCoin(player)){

            plugin.PlayerCoins.put(player, plugin.playerDataManager.getPlayerCoin(player));

        } else {

            plugin.playerDataManager.setPlayerCoin(player, 0);

        }

        if (plugin.playerDataManager.playerHasLevel(player)){

            plugin.PlayerLevel.put(player, plugin.playerDataManager.getPlayerLevel(player));

        } else {

            plugin.playerDataManager.setPlayerLevel(player, 1);

        }

        if (plugin.playerDataManager.playerHasXP(player)){

            plugin.PlayerXP.put(player, plugin.playerDataManager.getPlayerXP(player));

        } else {

            plugin.playerDataManager.setPlayerXP(player, 0);

        }

        plugin.scoreboard.createBoard(player);

    }

}
