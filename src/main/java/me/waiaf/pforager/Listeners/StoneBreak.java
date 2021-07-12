package me.waiaf.pforager.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StoneBreak implements Listener {
    
    @EventHandler
    public void StoneBreakEvent(BlockBreakEvent event){
        
        if (!event.getBlock().getType().equals(Material.STONE)) return;
        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        String ItemName = meta.getDisplayName();
        if (ItemName.contains("Cúp")){

            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBBLESTONE, 1));

        }
    }
}
