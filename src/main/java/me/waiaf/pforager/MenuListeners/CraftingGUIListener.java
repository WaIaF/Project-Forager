package me.waiaf.pforager.MenuListeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingGUIListener implements Listener {

    @EventHandler
    public void CraftingGUIInteractEvent(InventoryClickEvent event){

        if (!event.getView().getTitle().equalsIgnoreCase("Bàn chế tạo")) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null) return;

        Material clickedItemMaterial = clickedItem.getType();

        if (clickedItemMaterial.equals(Material.FURNACE)){

            if (player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 20)){

                player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 20));
                player.getInventory().addItem(new ItemStack(Material.FURNACE, 1));
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);

            } else {

                player.sendMessage(ChatColor.RED + "Bạn không có đủ nguyên liệu để chế tạo vật phẩm này");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1f, 1f);

            }

        }

    }
}
