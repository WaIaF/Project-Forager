package me.waiaf.pforager;

import me.waiaf.pforager.Commands.GetItem;
import me.waiaf.pforager.Listeners.*;
import me.waiaf.pforager.Listeners.FishTrap.FishTrapInteract;
import me.waiaf.pforager.Listeners.FishTrap.FishTrapPlace;
import me.waiaf.pforager.MenuListeners.CraftingBlockInteract;
import me.waiaf.pforager.MenuListeners.CraftingGUIListener;
import me.waiaf.pforager.MenuListeners.FurnaceGUIListener;
import me.waiaf.pforager.Utils.MenuManager;
import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {

    public HashMap<Location, String> CustomBlocks = new HashMap<>();
    public HashMap<Location, Boolean> FishTrapCaughtStatus = new HashMap<>();

    PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable(){

        ItemManager.init();
        MenuManager.init();
        registerEvents();
        setExecutors();

    }

    private void registerEvents(){

        pluginManager.registerEvents(new PlayerFirstJoin(), this);
        pluginManager.registerEvents(new StoneBreak(), this);
        pluginManager.registerEvents(new DigGrass(), this);
        pluginManager.registerEvents(new CraftingGUIListener(), this);
        pluginManager.registerEvents(new WoodBreak(), this);
        pluginManager.registerEvents(new LogScripCanceller(), this);
        pluginManager.registerEvents(new FurnaceGUIListener(), this);
        pluginManager.registerEvents(new OreBreak(), this);
        pluginManager.registerEvents(new CraftingBlockInteract(), this);
        pluginManager.registerEvents(new FishTrapPlace(this), this);
        pluginManager.registerEvents(new FishTrapInteract(this), this);

    }

    private void setExecutors(){

        this.getCommand("getitem").setExecutor(new GetItem());

    }

}
