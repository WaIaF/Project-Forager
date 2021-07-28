package me.waiaf.pforager.MenuListeners;

import me.waiaf.pforager.Utils.MenuManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class FurnaceGUIListener implements Listener {

    @EventHandler
    public void FurnaceGUIInteractEvent(InventoryClickEvent event){

        if (!event.getView().getTitle().equalsIgnoreCase("Lò nung")) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null) return;

        Material clickedItemMaterial = clickedItem.getType();

        switch (event.getView().getTitle()){

            case "Lò nung | Hãy chọn danh mục":

                switch (clickedItemMaterial){

                    case IRON_INGOT:

                        player.openInventory(MenuManager.FurnaceGUIMaterial);
                        break;

                    case BEDROCK:

                        player.openInventory(MenuManager.FurnaceGUIDitto);
                        break;
                }

                break;

            case "Lò nung | Vật liệu":

                switch (clickedItemMaterial){

                    case COAL:

                        Smelt(player, Material.OAK_PLANKS, 8, Material.COAL, 1, 0);

                        break;

                    case IRON_INGOT:

                        Smelt(player, Material.RAW_IRON, 1, Material.IRON_INGOT, 1, 1);

                        break;

                    case GOLD_INGOT:

                        Smelt(player, Material.RAW_GOLD, 1, Material.GOLD_INGOT, 1, 1);

                        break;

                    case NETHERITE_SCRAP:

                        Smelt(player, Material.ANCIENT_DEBRIS, 1, Material.NETHERITE_SCRAP, 1, 1);

                        break;

                    case BRICK:

                        Smelt(player, Material.COBBLESTONE, 5, Material.BRICK, 2, 1);

                        break;
                }

                break;

            case "Lò nung | Ditto":

                switch (clickedItemMaterial){

                    case COAL:

                        Smelt(player, Material.OAK_PLANKS, 4, Material.COAL, 1, 0);

                        break;

                    case IRON_INGOT:

                        Smelt(player, Material.RAW_IRON, 1, Material.IRON_INGOT, 2, 1);

                        break;

                }

            break;
        }

    }

    private void SmeltingFailed(Player player){


        player.sendMessage(ChatColor.RED + "Bạn không có đủ nguyên liệu để chế tạo vật phẩm này");
        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1f, 1f);

    }

    private void SmeltingSuccess(Player player, ItemStack itemStack, int CoalCost){

        if (CoalCost != 0){

            player.getInventory().removeItem(new ItemStack(Material.COAL, CoalCost));

        }

        player.getInventory().addItem(itemStack);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);

    }

    private void Smelt(Player player, Material material,  int materialcost, Material result, int resultamount, int coalcost){

        if (player.getInventory().containsAtLeast(new ItemStack(material), materialcost)){

            player.getInventory().removeItem(new ItemStack(material, materialcost));
            SmeltingSuccess(player, new ItemStack(result, resultamount), coalcost);

        } else {

            SmeltingFailed(player);

        }

    }

}
