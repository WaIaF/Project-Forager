package me.waiaf.pforager.Utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager{

    public static ItemStack IronPickaxe;
    public static ItemStack IronShovel;

    public static void init(){

        createIronPickaxe();
        createIronShovel();

    }

    private static void createIronPickaxe(){

        ItemStack item = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.of("#5DBB63") + "Cúp sắt");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Một cây cúp bình thường được làm từ sắt");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        IronPickaxe = item;

    }

    private static void createIronShovel(){

        ItemStack item = new ItemStack(Material.IRON_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.of("#5DBB63") + "Xẻng sắt");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "Một cây xẻng bình thường được làm từ sắt");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        IronShovel = item;

    }
}
