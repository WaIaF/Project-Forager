package me.waiaf.pforager.MenuListeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class FurnaceGUIListener implements Listener {

    @EventHandler
    public void FurnaceGUIInteractEvent(InventoryClickEvent event){

        if (!event.getView().getTitle().equalsIgnoreCase("Lò nung")) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null) return;

        Material clickedItemMaterial = clickedItem.getType();

        if (clickedItemMaterial.equals(Material.COAL)){

            if (player.getInventory().containsAtLeast(new ItemStack(Material.OAK_PLANKS), 8)){

                player.getInventory().removeItem(new ItemStack(Material.OAK_PLANKS, 8));
                player.getInventory().addItem(new ItemStack(Material.COAL, 1));
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);

            } else {

                player.sendMessage(ChatColor.RED + "Bạn không có đủ nguyên liệu để chế tạo vật phẩm này");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1f, 1f);

            }

        }


    }
}
