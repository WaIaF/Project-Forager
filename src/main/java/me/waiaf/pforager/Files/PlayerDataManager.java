package me.waiaf.pforager.Files;

import me.waiaf.pforager.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

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

}
