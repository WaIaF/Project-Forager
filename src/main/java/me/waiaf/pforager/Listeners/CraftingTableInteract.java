package me.waiaf.pforager.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CraftingTableInteract implements Listener {

    @EventHandler
    public void CraftingTableInteractEvent(PlayerInteractEvent event){

        if (!event.getClickedBlock().getType().equals(Material.CRAFTING_TABLE)) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        Player player = event.getPlayer();
        event.setCancelled(true);

        Inventory inventory = Bukkit.createInventory(player, 36, "Bàn chế tạo");

        ItemStack Furnace = new ItemStack(Material.FURNACE, 1);
        ItemMeta FurnaceMeta = Furnace.getItemMeta();
        List<String> FurnaceLore = new ArrayList<>();
        FurnaceLore.add("");
        FurnaceLore.add(ChatColor.GRAY + "Một cái lò nung bình thường");
        FurnaceLore.add("");
        FurnaceLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        FurnaceLore.add(ChatColor.WHITE + "   20x Đá cuội");
        assert FurnaceMeta != null;
        FurnaceMeta.setLore(FurnaceLore);
        Furnace.setItemMeta(FurnaceMeta);

        inventory.setItem(10, Furnace);

        player.sendMessage(ChatColor.WHITE + "DEBUG: CRAFTING TABLE RIGHT CLICKED");

    }

}
