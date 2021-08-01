package me.waiaf.pforager.Listeners.FishTrap;

import me.waiaf.pforager.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class FishTrapInteract implements Listener {

    Main plugin;
    public FishTrapInteract(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void FishTrapInteractEvent(PlayerInteractEvent event){

        // Later

    }
}
