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

        Player player = event.getPlayer();

        if (event.getItemInHand().isSimilar(ItemManager.FishTrap)) {


            if (event.getBlockReplacedState().getType().equals(Material.WATER)){

                TrapDoor FishTrap = (TrapDoor) event.getBlock().getBlockData();
                FishTrap.setWaterlogged(true);

                plugin.CustomBlocks.put(event.getBlock().getLocation(), "FishTrap");
                plugin.FishTrapCaughtStatus.put(event.getBlock().getLocation(), false);
                ArmorStand hologram = (ArmorStand) event.getBlock().getWorld().spawnEntity(event.getBlock().getLocation().add(0.5D, -0.5D, 0.5D), EntityType.ARMOR_STAND);
                hologram.setVisible(false);
                hologram.setCustomNameVisible(false);
                plugin.FishTrapHolograms.put(event.getBlock().getLocation(), hologram);
                StartFishTrap(event.getBlock(), hologram);

            }

        }
    }

    private void StartFishTrap(Block block, ArmorStand hologram){

        new BukkitRunnable(){

            @Override
            public void run(){


                if (plugin.CustomBlocks.containsKey(block.getLocation())){

                    if (plugin.CustomBlocks.get(block.getLocation()).equals("FishTrap")){

                        if (plugin.FishTrapCaughtStatus.get(block.getLocation()).equals(false)){

                            if (!block.getType().equals(Material.BIRCH_TRAPDOOR)){

                                this.cancel();
                                return;

                            }

                            plugin.FishTrapCaughtStatus.put(block.getLocation(), true);
                            hologram.setCustomNameVisible(true);
                            hologram.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "!!!");

                        }
                    }
                }
            }

        }.runTaskLater(Main.getPlugin(Main.class), 10*20);

    }
}
