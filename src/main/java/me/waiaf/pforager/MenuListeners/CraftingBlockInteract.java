package me.waiaf.pforager.MenuListeners;

import me.waiaf.pforager.Utils.MenuManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CraftingBlockInteract implements Listener {

    @EventHandler
    public void CraftingBlockInteractEvent(PlayerInteractEvent event){

        if (event.getClickedBlock() == null) return;

        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        if (event.getClickedBlock().getType().equals(Material.CRAFTING_TABLE)){

            event.setCancelled(true);
            event.getPlayer().openInventory(MenuManager.CraftGUIMain);

        } else if (event.getClickedBlock().getType().equals(Material.FURNACE)){

            event.setCancelled(true);
            event.getPlayer().openInventory(MenuManager.FurnaceGUIMain);

        } else if (event.getClickedBlock().getType().equals(Material.ANVIL)){

            event.setCancelled(true);
            event.getPlayer().openInventory(MenuManager.AnvilGUIMain);

        }
    }

}
