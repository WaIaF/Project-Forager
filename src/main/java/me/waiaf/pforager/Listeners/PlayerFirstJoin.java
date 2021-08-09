package me.waiaf.pforager.Listeners;

import me.waiaf.pforager.Main;
import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerFirstJoin implements Listener {

    Main plugin;
    public PlayerFirstJoin(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerFirstJoinEvent(PlayerJoinEvent event){

        Player player = event.getPlayer();

        plugin.scoreboard.createBoard(player);

        if (!player.hasPlayedBefore()){

            plugin.PlayerCoins.put(player, 0);

            player.getInventory().addItem(ItemManager.IronPickaxe);
            player.getInventory().addItem(ItemManager.IronAxe);

        } else {

            if (plugin.coinManager.getConfig().contains("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Coins"))

                plugin.PlayerCoins.put(player, plugin.coinManager.getConfig().getInt("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Coins"));


        }

    }

}
