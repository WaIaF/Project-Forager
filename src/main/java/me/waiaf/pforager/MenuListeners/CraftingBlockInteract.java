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

        if (!event.getClickedBlock().getType().equals(Material.CRAFTING_TABLE)) return;
        if (!event.getClickedBlock().getType().equals(Material.FURNACE)) return;

        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        Player player = event.getPlayer();

        event.setCancelled(true);

        switch (event.getClickedBlock().getType()){

            case CRAFTING_TABLE:

                player.openInventory(MenuManager.CraftGUIMain);
                break;

            case FURNACE:

                player.openInventory(MenuManager.FurnaceGUIMain);
                break;

            case ANVIL:

                player.openInventory(MenuManager.AnvilGUIMain);
                break;
        }
    }

}
