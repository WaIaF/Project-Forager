package me.waiaf.pforager;

import me.waiaf.pforager.Commands.GetItem;
import me.waiaf.pforager.Listeners.*;
import me.waiaf.pforager.MenuListeners.CraftingGUIListener;
import me.waiaf.pforager.MenuListeners.FurnaceGUIListener;
import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable(){

        ItemManager.init();
        registerEvents();
        setExecutors();

    }

    private void registerEvents(){

        pluginManager.registerEvents(new PlayerFirstJoin(), this);
        pluginManager.registerEvents(new StoneBreak(), this);
        pluginManager.registerEvents(new DigGrass(), this);
        pluginManager.registerEvents(new CraftingTableInteract(), this);
        pluginManager.registerEvents(new CraftingGUIListener(), this);
        pluginManager.registerEvents(new WoodBreak(), this);
        pluginManager.registerEvents(new LogScripCanceller(), this);
        pluginManager.registerEvents(new FurnaceInteract(), this);
        pluginManager.registerEvents(new FurnaceGUIListener(), this);
        pluginManager.registerEvents(new OreBreak(), this);

    }

    private void setExecutors(){

        this.getCommand("getitem").setExecutor(new GetItem());

    }

}
