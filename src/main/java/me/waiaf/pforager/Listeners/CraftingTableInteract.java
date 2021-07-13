package me.waiaf.pforager.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CraftingTableInteract implements Listener {

    public void CraftingTableInteractEvent(PlayerInteractEvent event){

        if (!event.getClickedBlock().getType().equals(Material.CRAFTING_TABLE)) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        Player player = event.getPlayer();
        player.sendMessage(ChatColor.WHITE + "DEBUG: CRAFTING TABLE RIGHT CLICKED");

        // Soon TM

    }

}
