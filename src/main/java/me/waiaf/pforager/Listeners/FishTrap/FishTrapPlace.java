package me.waiaf.pforager.Listeners.FishTrap;

import me.waiaf.pforager.Main;
import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.TrapDoor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FishTrapPlace implements Listener {

    Main plugin;
    public FishTrapPlace(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void FishTrapPlaceEvent(BlockPlaceEvent event){

        if (!event.getItemInHand().isSimilar(ItemManager.FishTrap)) return;
        if (!event.getBlockReplacedState().getBlock().getType().equals(Material.WATER)) return;

        event.setCancelled(true);
        event.getBlock().setType(Material.BIRCH_TRAPDOOR);
        TrapDoor FishTrap = (TrapDoor) event.getBlock();
        FishTrap.setWaterlogged(true);
        event.getPlayer().sendMessage("Debug: Fish trap placed");

        plugin.CustomBlocks.put(event.getBlock().getLocation(), "FishTrap");
        plugin.FishTrapCaughtStatus.put(event.getBlock().getLocation(), false);
        ArmorStand hologram = (ArmorStand) event.getBlock().getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.ARMOR_STAND);
        plugin.FishTrapHolograms.put(event.getBlock().getLocation(), hologram);
        hologram.setVisible(false);
        hologram.setCustomNameVisible(false);
        StartFishTrap(event.getBlock(), hologram, event.getPlayer());

    }

    private void StartFishTrap(Block block, ArmorStand hologram, Player debugPlayer){

        new BukkitRunnable(){

            @Override
            public void run(){


                if (!plugin.CustomBlocks.containsKey(block.getLocation())) return;
                if (!plugin.CustomBlocks.get(block.getLocation()).equals("FishTrap")) return;
                if (!plugin.FishTrapCaughtStatus.get(block.getLocation()).equals(true)) return;
                if (!block.getType().equals(Material.BIRCH_TRAPDOOR)){

                    this.cancel();
                    return;

                }

                plugin.FishTrapCaughtStatus.put(block.getLocation(), true);
                hologram.setCustomNameVisible(true);
                hologram.setCustomName(ChatColor.GREEN + "" + ChatColor.BOLD + "!!!");
                debugPlayer.sendMessage("Debug: Fish trap usuable");


            }

        }.runTaskLater(Main.getPlugin(Main.class), 20*20);

    }
}
