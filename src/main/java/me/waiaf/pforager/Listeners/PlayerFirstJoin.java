package me.waiaf.pforager.Listeners;

import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerFirstJoin implements Listener {

    @EventHandler
    public void PlayerFirstJoinEvent(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()){

            player.getInventory().addItem(ItemManager.IronPickaxe);
            player.getInventory().addItem(ItemManager.IronShovel);

        }

    }

}
