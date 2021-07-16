package me.waiaf.pforager.MenuListeners;

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

        switch (clickedItemMaterial){

            case COAL:

                SmeltOre(player, Material.OAK_PLANKS, 8, Material.COAL, 1, 0);

                break;

            case IRON_INGOT:

                SmeltOre(player, Material.RAW_IRON, 1, Material.IRON_INGOT, 1, 1);

                break;

            case GOLD_INGOT:

                SmeltOre(player, Material.RAW_GOLD, 1, Material.GOLD_INGOT, 1, 1);

                break;

            case NETHERITE_SCRAP:

                SmeltOre(player, Material.ANCIENT_DEBRIS, 1, Material.NETHERITE_SCRAP, 1, 1);

                break;

            case BRICK:

                SmeltOre(player, Material.COBBLESTONE, 5, Material.BRICK, 2, 1);

                break;
        }

    }

    private void SmeltOre(Player player, Material material,  int materialcost, Material result, int resultamount, int coalcost){

        if (coalcost == 0){

            if (player.getInventory().containsAtLeast(new ItemStack(material), materialcost)){

                player.getInventory().removeItem(new ItemStack(material, materialcost));
                player.getInventory().removeItem(new ItemStack(Material.COAL, coalcost));
                player.getInventory().addItem(new ItemStack(result, resultamount));
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);

            } else {

                player.sendMessage(ChatColor.RED + "Bạn không có đủ nguyên liệu để chế tạo vật phẩm này");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1f, 1f);

            }

        } else {

            if (player.getInventory().containsAtLeast(new ItemStack(material), materialcost) && player.getInventory().containsAtLeast(new ItemStack(Material.COAL), coalcost)){

                player.getInventory().removeItem(new ItemStack(material, materialcost));
                player.getInventory().removeItem(new ItemStack(Material.COAL, coalcost));
                player.getInventory().addItem(new ItemStack(result, resultamount));
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);

            } else {

                player.sendMessage(ChatColor.RED + "Bạn không có đủ nguyên liệu để chế tạo vật phẩm này");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1f, 1f);

            }

        }

    }

}
