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

        if (event.getClickedBlock() == null) return;
        if (!event.getClickedBlock().getType().equals(Material.CRAFTING_TABLE)) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        Player player = event.getPlayer();
        event.setCancelled(true);

        Inventory inventory = Bukkit.createInventory(player, 45, "Bàn chế tạo");

        List<String> FurnaceLore = new ArrayList<>();
        FurnaceLore.add("");
        FurnaceLore.add(ChatColor.GRAY + "Một cái lò nung bình thường");
        FurnaceLore.add("");
        FurnaceLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        FurnaceLore.add("");
        FurnaceLore.add(ChatColor.WHITE + "   20x Đá cuội");

        AddItem(inventory, new ItemStack(Material.FURNACE, 1), FurnaceLore, 10);

        List<String> AnvilLore = new ArrayList<>();
        AnvilLore.add("");
        AnvilLore.add(ChatColor.GRAY + "Dùng để chế tạo công cụ");
        AnvilLore.add("");
        AnvilLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        AnvilLore.add("");
        AnvilLore.add(ChatColor.WHITE + "   10x Viên gạch");
        AnvilLore.add(ChatColor.WHITE + "   10x Sắt");

        AddItem(inventory, new ItemStack(Material.ANVIL, 1), AnvilLore, 11);

        player.openInventory(inventory);

    }

    private void AddItem(Inventory inventory, ItemStack itemStack, List<String> Lore, int index){

        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setLore(Lore);
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(index, itemStack);

    }

}
