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

public class FurnaceInteract implements Listener {

    @EventHandler
    public void FurnaceInteractEvent(PlayerInteractEvent event){

        if (event.getClickedBlock() == null) return;
        if (!event.getClickedBlock().getType().equals(Material.FURNACE)) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        Player player = event.getPlayer();
        event.setCancelled(true);

        Inventory inventory = Bukkit.createInventory(player, 45, "Lò nung");

        ItemStack Coal = new ItemStack(Material.COAL, 1);
        ItemMeta CoalMeta = Coal.getItemMeta();
        List<String> CoalLore = new ArrayList<>();
        CoalLore.add("");
        CoalLore.add(ChatColor.GRAY + "Một cục thang bình thường");
        CoalLore.add("");
        CoalLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        CoalLore.add("");
        CoalLore.add(ChatColor.WHITE + "   8x Gỗ sồi");
        assert CoalMeta != null;
        CoalMeta.setLore(CoalLore);
        Coal.setItemMeta(CoalMeta);

        inventory.setItem(10, Coal);

        player.openInventory(inventory);

    }
}
