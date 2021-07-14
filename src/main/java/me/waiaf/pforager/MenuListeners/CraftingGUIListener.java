package me.waiaf.pforager.MenuListeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftingGUIListener implements Listener {

    @EventHandler
    public void CraftingGUIInteractEvent(InventoryClickEvent event){

        if (!event.getView().getTitle().equalsIgnoreCase("Bàn chế tạo")) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (!clickedItem.getType().equals(Material.AIR)){

            ItemMeta clickedItemMeta = clickedItem.getItemMeta();
            assert clickedItemMeta != null;
            String itemName = clickedItemMeta.getDisplayName();

            if (itemName.equalsIgnoreCase(ChatColor.GRAY + "Một cái lò nung bình thường")){

                if (player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 20)){

                    player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 20));

                } else {

                    player.sendMessage(ChatColor.RED + "Bạn không có đủ nguyên liệu để chế tạo vật phẩm này");

                }

            }

        }

    }
}
