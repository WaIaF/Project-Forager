package me.waiaf.pforager.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    public static Inventory CraftGUIMain;
    public static Inventory CraftGUIMachines;
    public static Inventory CraftGUITools;

    public static void init(){

        createCraftGUIMain();
        createCraftGUIMachines();
        createCraftGUITools();

    }

    private static void createCraftGUIMain(){

        CraftGUIMain = Bukkit.createInventory(null, 27, "Bàn chế tạo | Hãy chọn danh mục");

        AddCategory(CraftGUIMain, new ItemStack(Material.FURNACE, 1), ChatColor.WHITE + "Máy móc",10);
        AddCategory(CraftGUIMain, new ItemStack(Material.BIRCH_TRAPDOOR, 1), ChatColor.WHITE + "Công cụ",11);

    }

    private static void createCraftGUITools(){

        CraftGUITools = Bukkit.createInventory(null, 45, "Bàn chế tạo | Công cụ");

        ItemStack FishTrap = new ItemStack(Material.BIRCH_TRAPDOOR);
        ItemMeta FishTrapMeta = FishTrap.getItemMeta();
        assert FishTrapMeta != null;
        FishTrapMeta.setDisplayName("Bẩy cá");
        FishTrap.setItemMeta(FishTrapMeta);
        List<String> FishTrapLore = new ArrayList<>();
        FishTrapLore.add("");
        FishTrapLore.add(ChatColor.GRAY + "Dùng để bẩy cá");
        FishTrapLore.add("");
        FishTrapLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        FishTrapLore.add("");
        FishTrapLore.add(ChatColor.WHITE + "   10x Gỗ sồi");
        FishTrapLore.add(ChatColor.WHITE + "   5x Quả mọng");

        AddItem(CraftGUITools, FishTrap, FishTrapLore, 10);
        AddReturnFeather(CraftGUITools, 40);

    }

    private static void createCraftGUIMachines(){

        CraftGUIMachines = Bukkit.createInventory(null, 45, "Bàn chế tạo | Máy móc");

        List<String> FurnaceLore = new ArrayList<>();
        FurnaceLore.add("");
        FurnaceLore.add(ChatColor.GRAY + "Một cái lò nung bình thường");
        FurnaceLore.add("");
        FurnaceLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        FurnaceLore.add("");
        FurnaceLore.add(ChatColor.WHITE + "   20x Đá cuội");

        AddItem(CraftGUIMachines, new ItemStack(Material.FURNACE, 1), FurnaceLore, 10);

        List<String> AnvilLore = new ArrayList<>();
        AnvilLore.add("");
        AnvilLore.add(ChatColor.GRAY + "Dùng để chế tạo công cụ");
        AnvilLore.add("");
        AnvilLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        AnvilLore.add("");
        AnvilLore.add(ChatColor.WHITE + "   10x Viên gạch");
        AnvilLore.add(ChatColor.WHITE + "   10x Sắt");

        AddItem(CraftGUIMachines, new ItemStack(Material.ANVIL, 1), AnvilLore, 11);
        AddReturnFeather(CraftGUIMachines, 44);

    }

    private static void AddCategory(Inventory inventory, ItemStack itemStack, String name, int index){

        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(index, itemStack);

    }

    private static void AddItem(Inventory inventory, ItemStack itemStack, List<String> Lore, int index){

        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setLore(Lore);
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(index, itemStack);

    }

    private static void AddReturnFeather(Inventory inventory, int index){

        ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert  itemMeta != null;
        itemMeta.setDisplayName(ChatColor.WHITE + "Quay về");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(index, itemStack);

    }
}
