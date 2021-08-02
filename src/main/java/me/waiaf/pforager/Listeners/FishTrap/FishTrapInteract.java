package me.waiaf.pforager.Listeners.FishTrap;

import me.waiaf.pforager.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class FishTrapInteract implements Listener {

    Main plugin;
    public FishTrapInteract(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void FishTrapInteractEvent(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if (block == null) return;
        player.sendMessage("Debug: Block is not null");
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        player.sendMessage("Debug: Right clicked block");
        if (block.getType().equals(Material.BIRCH_TRAPDOOR)){

            player.sendMessage("Debug: Block is a trapdoor");

            if (plugin.CustomBlocks.containsKey(block.getLocation())){

                player.sendMessage("Debug: Contains key");

                if (plugin.CustomBlocks.get(event.getClickedBlock().getLocation()).equalsIgnoreCase("FishTrap")){

                    player.sendMessage("Debug: Is A Fish Trap");

                    event.setCancelled(true);

                    if (plugin.FishTrapCaughtStatus.get(event.getClickedBlock().getLocation())){

                        player.sendMessage("Is Done");
                        ArmorStand hologram = plugin.FishTrapHolograms.get(event.getClickedBlock().getLocation());
                        hologram.setCustomNameVisible(false);
                        plugin.FishTrapCaughtStatus.put(block.getLocation(), false);
                        RNGJesus(player);
                        StartFishTrap(block, hologram, player);

                    }

                }

            }

        }
    }

    private void RNGJesus(Player player){

        Random random = new Random();
        int rng = random.nextInt(100) + 1;

        /*
         *       60% Cod
         *       20% Kelp
         *       20% Sand
         */

        if (rng < 20) {

            player.getInventory().addItem(new ItemStack(Material.SAND, 1));

        } else if (rng <= 40 && rng > 20){

            player.getInventory().addItem(new ItemStack(Material.KELP, 1));

        } else {

            player.getInventory().addItem(new ItemStack(Material.COD, 1));

        }

    }

    private void StartFishTrap(Block block, ArmorStand hologram, Player debugPlayer){

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
                            hologram.setCustomName(ChatColor.GREEN + "!!!");
                            debugPlayer.sendMessage("Debug: Fish trap usuable");


                        }
                    }
                }
            }

        }.runTaskLater(Main.getPlugin(Main.class), 10*20);

    }

}
