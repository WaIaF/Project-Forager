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

    public static Inventory FurnaceGUIMain;
    public static Inventory FurnaceGUIMaterial;
    public static Inventory FurnaceGUIDitto;


    public static void init(){

        createCraftGUIMain();
        createCraftGUIMachines();
        createCraftGUITools();

        createFurnaceGUIMain();
        createFurnaceGUIMaterials();
        createFurnaceGUIDitto();

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
        AddReturnFeather(CraftGUITools);

    }

    private static void createCraftGUIMachines(){

        CraftGUIMachines = Bukkit.createInventory(null, 45, "Bàn chế tạo | Xây dựng");

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
        AddReturnFeather(CraftGUIMachines);

    }

    private static void createFurnaceGUIMain(){

        FurnaceGUIMain = Bukkit.createInventory(null, 27, "Lò nung | Hãy chọn danh mục");

        AddCategory(FurnaceGUIMain, new ItemStack(Material.IRON_INGOT, 1), ChatColor.WHITE + "Vật liệu",10);
        AddCategory(FurnaceGUIMain, new ItemStack(Material.BEDROCK, 1), ChatColor.WHITE + "Ditto",11);

    }

    private static void createFurnaceGUIMaterials(){

        FurnaceGUIMaterial = Bukkit.createInventory(null, 45, "Lò nung | Vật liệu");

        List<String> CoalLore = new ArrayList<>();
        CoalLore.add("");
        CoalLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        CoalLore.add("");
        CoalLore.add(ChatColor.WHITE + "   8x Gỗ sồi");

        AddItem(FurnaceGUIMaterial, new ItemStack(Material.COAL, 1), CoalLore, 10);

        List<String> IronLore = new ArrayList<>();
        IronLore.add("");
        IronLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        IronLore.add("");
        IronLore.add(ChatColor.WHITE + "   1x Sắt thô");
        IronLore.add(ChatColor.WHITE + "   1x Than");

        AddItem(FurnaceGUIMaterial, new ItemStack(Material.IRON_INGOT, 1), IronLore, 11);

        List<String> GoldLore = new ArrayList<>();
        GoldLore.add("");
        GoldLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        GoldLore.add("");
        GoldLore.add(ChatColor.WHITE + "   1x Vàng thô");
        GoldLore.add(ChatColor.WHITE + "   1x Than");

        AddItem(FurnaceGUIMaterial, new ItemStack(Material.GOLD_INGOT, 1), GoldLore, 12);

        List<String> NetheriteScrapLore = new ArrayList<>();
        NetheriteScrapLore.add("");
        NetheriteScrapLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        NetheriteScrapLore.add("");
        NetheriteScrapLore.add(ChatColor.WHITE + "   1x Mảnh vỡ cổ đại");
        NetheriteScrapLore.add(ChatColor.WHITE + "   1x Than");

        AddItem(FurnaceGUIMaterial, new ItemStack(Material.NETHERITE_SCRAP, 1), NetheriteScrapLore, 13);

        List<String> BrickLore = new ArrayList<>();
        BrickLore.add("");
        BrickLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        BrickLore.add("");
        BrickLore.add(ChatColor.WHITE + "   5x Đá cuội");
        BrickLore.add(ChatColor.WHITE + "   1x Than");

        AddItem(FurnaceGUIMaterial, new ItemStack(Material.BRICK, 2), BrickLore, 14);


        AddReturnFeather(FurnaceGUIMaterial);

    }

    private static void createFurnaceGUIDitto(){

        FurnaceGUIDitto = Bukkit.createInventory(null, 45, "Lò nung | Ditto");

        List<String> CoalLore = new ArrayList<>();
        CoalLore.add("");
        CoalLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        CoalLore.add("");
        CoalLore.add(ChatColor.WHITE + "   8x Gỗ sồi");

        AddItem(FurnaceGUIDitto, new ItemStack(Material.COAL, 1), CoalLore, 10);

        List<String> IronLore = new ArrayList<>();
        IronLore.add("");
        IronLore.add(ChatColor.GREEN + "Vật liệu cần để chế tạo:");
        IronLore.add("");
        IronLore.add(ChatColor.WHITE + "   1x Sắt thô");
        IronLore.add(ChatColor.WHITE + "   1x Than");

        AddItem(FurnaceGUIDitto, new ItemStack(Material.IRON_INGOT, 1), IronLore, 11);

        AddReturnFeather(FurnaceGUIDitto);

    }



    // Functions


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

    private static void AddReturnFeather(Inventory inventory){

        ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert  itemMeta != null;
        itemMeta.setDisplayName(ChatColor.WHITE + "Quay về");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(40, itemStack);

    }
}
