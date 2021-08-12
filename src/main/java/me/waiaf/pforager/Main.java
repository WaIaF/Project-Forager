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

    public HashMap<Integer, Integer> LevelRequirement = new HashMap<>();

    public HashMap<Player, Integer> PlayerCoins = new HashMap<>();
    public HashMap<Player, Integer> PlayerXP = new HashMap<>();
    public HashMap<Player, Integer> PlayerLevel = new HashMap<>();

    public HashMap<Location, String> CustomBlocks = new HashMap<>();

    public HashMap<Location, Boolean> FishTrapCaughtStatus = new HashMap<>();
    public HashMap<Location, ArmorStand> FishTrapHolograms = new HashMap<>();

    public Scoreboard scoreboard;

    PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable(){

        for (int i = 0; i < 30; i++){

            int xpReqLvOne = 25;

            if (i == 0){

                LevelRequirement.put(i+1, xpReqLvOne);

            } else {

                float xpReqLF = 25f;
                long xpReqL = Math.round(xpReqLvOne*i + (xpReqLF*i/2));
                int xpReq = (int) xpReqL;

                LevelRequirement.put(i+1, xpReq);

            }

        }

        this.playerDataManager = new PlayerDataManager(this);
        this.scoreboard = new Scoreboard(this);

        ItemManager.init();
        MenuManager.init();
        registerEvents();
        setExecutors();

        if (!Bukkit.getOnlinePlayers().isEmpty())

            for (Player online : Bukkit.getOnlinePlayers()){

                if (playerDataManager.playerHasCoin(online)){

                    PlayerCoins.put(online, playerDataManager.getPlayerCoin(online));

                } else {

                    playerDataManager.setPlayerCoin(online, 0);

                }

                if (playerDataManager.playerHasLevel(online)){

                    PlayerLevel.put(online, playerDataManager.getPlayerLevel(online));

                } else {

                    playerDataManager.setPlayerLevel(online, 1);

                }

                if (playerDataManager.playerHasXP(online)){

                    PlayerXP.put(online, playerDataManager.getPlayerXP(online));

                } else {

                    playerDataManager.setPlayerXP(online, 0);

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
            playerDataManager.setPlayerCoin(player, entry.getValue());

        }

        for (Map.Entry<Player, Integer> entry : PlayerLevel.entrySet()){

            Player player = entry.getKey();
            playerDataManager.setPlayerLevel(player, entry.getValue());

        }

        for (Map.Entry<Player, Integer> entry : PlayerXP.entrySet()){

            Player player = entry.getKey();
            playerDataManager.setPlayerXP(player, entry.getValue());

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
