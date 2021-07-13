package me.waiaf.pforager;

import me.waiaf.pforager.Commands.GetItem;
import me.waiaf.pforager.Listeners.CraftingTableInteract;
import me.waiaf.pforager.Listeners.DigGrass;
import me.waiaf.pforager.Listeners.PlayerFirstJoin;
import me.waiaf.pforager.Listeners.StoneBreak;
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

    }

    private void setExecutors(){

        this.getCommand("getitem").setExecutor(new GetItem());

    }

}
