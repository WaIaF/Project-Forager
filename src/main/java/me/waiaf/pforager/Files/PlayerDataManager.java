package me.waiaf.pforager.Files;

import me.waiaf.pforager.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class PlayerDataManager {

    Main plugin;
    public PlayerDataManager(Main plugin){
        this.plugin = plugin;
        saveDefaultConfig();
    }

    private FileConfiguration coinsConfig = null;
    private File configFile = null;

    public void reloadConfig(){

        if (this.configFile == null) this.configFile = new File(this.plugin.getDataFolder(), "playerdata.yml");

        this.coinsConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("playerdata.yml");

        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.coinsConfig.setDefaults(defaultConfig);
        }

    }

    public FileConfiguration getConfig(){

        if (this.coinsConfig == null) reloadConfig();

        return this.coinsConfig;
    }

    public void saveConfig(){

        if (this.coinsConfig == null || this.configFile == null) return;

        try {

            this.getConfig().save(this.configFile);

        } catch (IOException exception) {

            this.plugin.getLogger().log(Level.SEVERE, "Không thể lưu config vào " + this.configFile, exception);

        }

    }

    public void saveDefaultConfig(){

        if (this.configFile == null) this.configFile = new File(this.plugin.getDataFolder(), "playerdata.yml");

        if (!this.configFile.exists()){

            this.plugin.saveResource("playerdata.yml", false);

        }
    }

    public int getPlayerXP(Player player){

        return getConfig().getInt("Players." + player.getName() + "." + player.getUniqueId().toString() + ".XP");

    }

    public int getPlayerCoin(Player player){

        return getConfig().getInt("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Coins");

    }

    public int getPlayerLevel(Player player){

        return getConfig().getInt("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Level");

    }

    public void setPlayerXP(Player player, Integer xp){

        getConfig().set("Players." + player.getName() + "." + player.getUniqueId().toString() + ".XP", xp);
        saveConfig();
        plugin.PlayerLevel.put(player, xp);

    }

    public void setPlayerCoin(Player player, Integer coin){

        getConfig().set("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Coins", coin);
        saveConfig();
        plugin.PlayerCoins.put(player, coin);

    }

    public void setPlayerLevel(Player player, Integer level){

        getConfig().set("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Level", level);
        saveConfig();
        plugin.PlayerLevel.put(player, level);

    }

    public boolean playerHasXP(Player player){

        return getConfig().contains("Players." + player.getName() + "." + player.getUniqueId().toString() + ".XP");

    }

    public boolean playerHasCoin(Player player){

        return getConfig().contains("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Coins");

    }

    public boolean playerHasLevel(Player player){

        return getConfig().contains("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Level");

    }

    public void increasePlayerXP(Player player, Integer integer){

       setPlayerXP(player, plugin.playerDataManager.getPlayerXP(player) + integer);

    }


}
