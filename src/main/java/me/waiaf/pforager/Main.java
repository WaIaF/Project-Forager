package me.waiaf.pforager;

import me.waiaf.pforager.Commands.GetItem;
import me.waiaf.pforager.Commands.SetCoin;
import me.waiaf.pforager.Files.PlayerDataManager;
import me.waiaf.pforager.Listeners.*;
import me.waiaf.pforager.Listeners.FishTrap.FishTrapBreak;
import me.waiaf.pforager.Listeners.FishTrap.FishTrapInteract;
import me.waiaf.pforager.Listeners.FishTrap.FishTrapPlace;
import me.waiaf.pforager.MenuListeners.CraftingBlockInteract;
import me.waiaf.pforager.MenuListeners.CraftingGUIListener;
import me.waiaf.pforager.MenuListeners.FurnaceGUIListener;
import me.waiaf.pforager.Utils.MenuManager;
import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Main extends JavaPlugin {

    public PlayerDataManager playerDataManager;

    public HashMap<Player, Integer> PlayerCoins = new HashMap<>();

    public HashMap<Location, String> CustomBlocks = new HashMap<>();

    public HashMap<Location, Boolean> FishTrapCaughtStatus = new HashMap<>();
    public HashMap<Location, ArmorStand> FishTrapHolograms = new HashMap<>();

    public Scoreboard scoreboard;

    PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable(){

        this.playerDataManager = new PlayerDataManager(this);
        this.scoreboard = new Scoreboard(this);

        ItemManager.init();
        MenuManager.init();
        registerEvents();
        setExecutors();

        if (!Bukkit.getOnlinePlayers().isEmpty())
            for (Player online : Bukkit.getOnlinePlayers()){

                if (playerDataManager.getConfig().contains("Players." + online.getName() + "." + online.getUniqueId().toString() + ".Coins")){

                    PlayerCoins.put(online, playerDataManager.getConfig().getInt("Players." + online.getName() + "." + online.getUniqueId().toString() + ".Coins"));

                } else {

                    PlayerCoins.put(online, 0);
                    playerDataManager.getConfig().set("Players." + online.getName() + "." + online.getUniqueId().toString() + ".Coins", 0);
                    playerDataManager.saveConfig();

                }

                scoreboard.createBoard(online);

            }
    }

    @Override
    public void onDisable(){

        for (Map.Entry<Location, ArmorStand> entry : FishTrapHolograms.entrySet()){

            ArmorStand armorStand = entry.getValue();
            armorStand.remove();

        }

        for (Map.Entry<Player, Integer> entry : PlayerCoins.entrySet()){

            Player player = entry.getKey();
            playerDataManager.getConfig().set("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Coins", entry.getValue());
            playerDataManager.saveConfig();

        }

    }

    private void registerEvents(){

        pluginManager.registerEvents(new PlayerJoin(this), this);
        pluginManager.registerEvents(new StoneBreak(), this);
        pluginManager.registerEvents(new DigGrass(), this);
        pluginManager.registerEvents(new CraftingGUIListener(), this);
        pluginManager.registerEvents(new WoodBreak(), this);
        pluginManager.registerEvents(new LogScripCanceller(), this);
        pluginManager.registerEvents(new FurnaceGUIListener(), this);
        pluginManager.registerEvents(new OreBreak(this), this);
        pluginManager.registerEvents(new CraftingBlockInteract(), this);
        pluginManager.registerEvents(new FishTrapPlace(this), this);
        pluginManager.registerEvents(new FishTrapInteract(this), this);
        pluginManager.registerEvents(new FishTrapBreak(this), this);

    }

    private void setExecutors(){

        this.getCommand("getitem").setExecutor(new GetItem());
        this.getCommand("setcoin").setExecutor(new SetCoin(this));

    }

}
