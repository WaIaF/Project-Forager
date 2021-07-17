package me.waiaf.pforager.Utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemManager{

    public static HashMap<Integer, ItemStack> ItemIDs = new HashMap<>();
    public static ItemStack IronPickaxe;
    public static ItemStack IronShovel;
    public static ItemStack IronAxe;

    public static void init(){

        createIronPickaxe();
        createIronShovel();
        createIronAxe();

    }

    private static void createIronPickaxe(){

        ItemStack item = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.of("#F5FEFD") + "Cúp sắt");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Một cây cúp bình thường được làm từ sắt");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        IronPickaxe = item;
        ItemIDs.put(1, IronPickaxe);

    }

    private static void createIronShovel(){

        ItemStack item = new ItemStack(Material.IRON_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.of("#F5FEFD") + "Xẻng sắt");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Một cây xẻng bình thường được làm từ sắt");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        IronShovel = item;
        ItemIDs.put(2, IronShovel);

    }

    private static void createIronAxe(){

        ItemStack item = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.of("#F5FEFD") + "Rìu sắt");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Một cây rìu bình thường được làm từ sắt");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        IronAxe = item;
        ItemIDs.put(3, IronAxe);

    }

}
