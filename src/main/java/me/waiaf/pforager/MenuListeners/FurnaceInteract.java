package me.waiaf.pforager.MenuListeners;

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

        List<String> CoalLore = new ArrayList<>();
        CoalLore.add("");
        CoalLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        CoalLore.add("");
        CoalLore.add(ChatColor.WHITE + "   8x Gỗ sồi");

        AddItem(inventory, new ItemStack(Material.COAL, 1), CoalLore, 10);

        List<String> IronLore = new ArrayList<>();
        IronLore.add("");
        IronLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        IronLore.add("");
        IronLore.add(ChatColor.WHITE + "   1x Sắt thô");
        IronLore.add(ChatColor.WHITE + "   1x Than");

        AddItem(inventory, new ItemStack(Material.IRON_INGOT, 1), IronLore, 11);

        List<String> GoldLore = new ArrayList<>();
        GoldLore.add("");
        GoldLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        GoldLore.add("");
        GoldLore.add(ChatColor.WHITE + "   1x Vàng thô");
        GoldLore.add(ChatColor.WHITE + "   1x Than");

        AddItem(inventory, new ItemStack(Material.GOLD_INGOT, 1), GoldLore, 12);

        List<String> NetheriteScrapLore = new ArrayList<>();
        NetheriteScrapLore.add("");
        NetheriteScrapLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        NetheriteScrapLore.add("");
        NetheriteScrapLore.add(ChatColor.WHITE + "   1x Mảnh vỡ cổ đại");
        NetheriteScrapLore.add(ChatColor.WHITE + "   1x Than");

        AddItem(inventory, new ItemStack(Material.NETHERITE_SCRAP, 1), NetheriteScrapLore, 13);

        List<String> BrickLore = new ArrayList<>();
        BrickLore.add("");
        BrickLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        BrickLore.add("");
        BrickLore.add(ChatColor.WHITE + "   5x Đá cuội");
        BrickLore.add(ChatColor.WHITE + "   1x Than");

        AddItem(inventory, new ItemStack(Material.BRICK, 2), BrickLore, 14);

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
