package me.waiaf.pforager.MenuListeners;

import me.waiaf.pforager.Utils.ItemManager;
import me.waiaf.pforager.Utils.MenuManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingGUIListener implements Listener {

    @EventHandler
    public void CraftingGUIInteractEvent(InventoryClickEvent event){

        if (!event.getView().getTitle().contains("Bàn chế tạo")) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null) return;

        Material clickedItemMaterial = clickedItem.getType();

        switch (event.getView().getTitle()){

            case "Bàn chế tạo | Hãy chọn danh mục":

                switch (clickedItemMaterial){

                    case FURNACE:

                        player.openInventory(MenuManager.CraftGUIMachines);
                        break;

                    case BIRCH_TRAPDOOR:

                        player.openInventory(MenuManager.CraftGUITools);
                        break;
                }

                break;

            case "Bàn chế tạo | Máy móc":

                switch (clickedItemMaterial){

                    case FURNACE:

                        if (player.getInventory().containsAtLeast(new ItemStack(Material.COBBLESTONE), 20)){

                            player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 20));
                            craftingSuccess(player, new ItemStack(Material.FURNACE, 1));

                        } else {

                            craftingFailed(player);

                        }

                        break;

                    case ANVIL:

                        if (player.getInventory().containsAtLeast(new ItemStack(Material.BRICK), 10) && player.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 10)){

                            player.getInventory().removeItem(new ItemStack(Material.BRICK, 10));
                            player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 10));
                            craftingSuccess(player, new ItemStack(Material.ANVIL, 1));

                        } else {

                            craftingFailed(player);

                        }

                        break;

                    case FEATHER:

                        player.openInventory(MenuManager.CraftGUIMain);
                        break;

                }

                break;

            case "Bàn chế tạo | Công cụ":

                switch (clickedItemMaterial){

                    case BIRCH_TRAPDOOR:

                        if (player.getInventory().containsAtLeast(new ItemStack(Material.OAK_PLANKS), 10) && player.getInventory().containsAtLeast(new ItemStack(Material.SWEET_BERRIES), 5)){

                            player.getInventory().removeItem(new ItemStack(Material.OAK_PLANKS, 10));
                            player.getInventory().removeItem(new ItemStack(Material.SWEET_BERRIES, 5));
                            craftingSuccess(player, ItemManager.FishTrap);

                        } else {

                            craftingFailed(player);

                        }

                        break;

                    case FEATHER:

                        player.openInventory(MenuManager.CraftGUIMain);
                        break;

                }

                break;
        }
    }

    private void craftingFailed(Player player){

        player.sendMessage(ChatColor.RED + "Bạn không có đủ nguyên liệu để chế tạo vật phẩm này");
        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1f, 1f);

    }

    private void craftingSuccess(Player player, ItemStack itemStack){

        player.getInventory().addItem(itemStack);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);

    }
}
