package me.waiaf.pforager.MenuListeners;

import me.waiaf.pforager.Utils.MenuManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FurnaceInteract implements Listener {

    @EventHandler
    public void FurnaceInteractEvent(PlayerInteractEvent event){

        if (event.getClickedBlock() == null) return;
        if (!event.getClickedBlock().getType().equals(Material.FURNACE)) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        Player player = event.getPlayer();
        event.setCancelled(true);

        player.openInventory(MenuManager.FurnaceGUIMain);

    }


}
