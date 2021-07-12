package me.waiaf.pforager;

import me.waiaf.pforager.Listeners.PlayerFirstJoin;
import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable(){

        ItemManager.init();
        registerEvents();

    }

    @Override
    public void onDisable(){

    }

    private void registerEvents(){

        pluginManager.registerEvents(new PlayerFirstJoin(), this);

    }

}
