package me.waiaf.pforager.Listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class OreBreak implements Listener {

    @EventHandler
    public void OreBreakEvent(BlockBreakEvent event){

        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        String ItemName = meta.getDisplayName();
        Random random = new Random();
        int rng = random.nextInt(100) + 1;

        if (ItemName.equalsIgnoreCase(ChatColor.of("#F5FEFD") + "Cúp sắt")){

            switch (event.getBlock().getType()){

                case COAL_ORE:

                    CancelAndSetAir(event, event.getBlock());
                    DropWithCobble(new ItemStack(Material.COAL), event.getBlock());
                    RNGBonus(new ItemStack(Material.COAL), event.getBlock());

                    break;

                case IRON_ORE:

                    CancelAndSetAir(event, event.getBlock());
                    DropWithCobble(new ItemStack(Material.RAW_IRON), event.getBlock());
                    RNGBonus(new ItemStack(Material.RAW_IRON), event.getBlock());

                    break;

                case GOLD_ORE:

                    CancelAndSetAir(event, event.getBlock());
                    DropWithCobble(new ItemStack(Material.RAW_GOLD), event.getBlock());
                    RNGBonus(new ItemStack(Material.RAW_GOLD), event.getBlock());

                    break;
            }

        }
    }

    private void CancelAndSetAir(BlockBreakEvent event, Block block){

        event.setCancelled(true);
        block.setType(Material.AIR);

    }

    private void DropWithCobble(ItemStack itemStack, Block block){

        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE));
        block.getWorld().dropItemNaturally(block.getLocation(), itemStack);

    }

    private void RNGBonus(ItemStack itemStack, Block block){

        Random random = new Random();
        int rng = random.nextInt(100) + 1;

        if (rng >= 60){

            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE));
            block.getWorld().dropItemNaturally(block.getLocation(), itemStack);

        }

        if (rng >= 90){

            block.getWorld().dropItemNaturally(block.getLocation(), itemStack);

        }

    }
}
