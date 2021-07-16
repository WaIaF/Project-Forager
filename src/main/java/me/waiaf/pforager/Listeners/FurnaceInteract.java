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
        CoalLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        CoalLore.add("");
        CoalLore.add(ChatColor.WHITE + "   8x Gỗ sồi");
        assert CoalMeta != null;
        CoalMeta.setLore(CoalLore);
        Coal.setItemMeta(CoalMeta);

        ItemStack Iron = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta IronMeta = Iron.getItemMeta();
        List<String> IronLore = new ArrayList<>();
        IronLore.add("");
        IronLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        IronLore.add("");
        IronLore.add(ChatColor.WHITE + "   1x Sắt thô");
        IronLore.add(ChatColor.WHITE + "   1x Than");
        assert IronMeta != null;
        IronMeta.setLore(IronLore);
        Iron.setItemMeta(IronMeta);

        ItemStack Gold = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta GoldMeta = Gold.getItemMeta();
        List<String> GoldLore = new ArrayList<>();
        GoldLore.add("");
        GoldLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        GoldLore.add("");
        GoldLore.add(ChatColor.WHITE + "   1x Vàng thô");
        GoldLore.add(ChatColor.WHITE + "   1x Than");
        assert GoldMeta != null;
        GoldMeta.setLore(GoldLore);
        Gold.setItemMeta(GoldMeta);

        ItemStack NetheriteScrap = new ItemStack(Material.NETHERITE_SCRAP, 1);
        ItemMeta NetheriteScrapMeta = NetheriteScrap.getItemMeta();
        List<String> NetheriteScrapLore = new ArrayList<>();
        NetheriteScrapLore.add("");
        NetheriteScrapLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        NetheriteScrapLore.add("");
        NetheriteScrapLore.add(ChatColor.WHITE + "   1x Mảnh vỡ cổ đại");
        NetheriteScrapLore.add(ChatColor.WHITE + "   1x Than");
        assert NetheriteScrapMeta != null;
        NetheriteScrapMeta.setLore(NetheriteScrapLore);
        NetheriteScrap.setItemMeta(NetheriteScrapMeta);

        ItemStack Brick = new ItemStack(Material.BRICK, 2);
        ItemMeta BrickMeta = Brick.getItemMeta();
        List<String> BrickLore = new ArrayList<>();
        BrickLore.add("");
        BrickLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        BrickLore.add("");
        BrickLore.add(ChatColor.WHITE + "   5x Đá cuội");
        BrickLore.add(ChatColor.WHITE + "   1x Than");
        assert BrickMeta != null;
        BrickMeta.setLore(BrickLore);
        Brick.setItemMeta(BrickMeta);

        inventory.setItem(10, Coal);
        inventory.setItem(11, Iron);
        inventory.setItem(12, Gold);
        inventory.setItem(13, NetheriteScrap);
        inventory.setItem(14, Brick);

        player.openInventory(inventory);

    }
}
