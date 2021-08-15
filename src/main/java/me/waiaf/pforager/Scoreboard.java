package me.waiaf.pforager;

import dev.jcsoftware.jscoreboards.JPerPlayerMethodBasedScoreboard;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Scoreboard {

    Main plugin;
    public Scoreboard(Main plugin){
        this.plugin = plugin;
    }

    public void createBoard(Player player){

        JPerPlayerMethodBasedScoreboard scoreboard = new JPerPlayerMethodBasedScoreboard();

        scoreboard.addPlayer(player);
        scoreboard.setTitle(player, ChatColor.WHITE + "Project: " + ChatColor.GREEN + "" + ChatColor.BOLD + "Forager");
        scoreboard.setLines(player,
                "",
                StringUtils.center(ChatColor.WHITE + "Tên người chơi", 23),
                StringUtils.center(ChatColor.DARK_GREEN + player.getName(), 23),
                "",
                StringUtils.center(ChatColor.WHITE + "Coins", 23),
                StringUtils.center(ChatColor.YELLOW + String.format("%,d", plugin.PlayerCoins.get(player)), 23),
                "",
                StringUtils.center(ChatColor.WHITE + "Level", 23),
                StringUtils.center(ChatColor.LIGHT_PURPLE + String.valueOf(plugin.playerDataManager.getPlayerLevel(player)), 23),
                "",
                StringUtils.center(ChatColor.WHITE + "Tiến độ", 23),
                StringUtils.center(ChatColor.GREEN + String.valueOf(plugin.playerDataManager.getPlayerXP(player)) + "/" + plugin.getPlayerXPReq(player) + " (" + Math.round(((float)plugin.playerDataManager.getPlayerXP(player)/(float)plugin.getPlayerXPReq(player))*100) + "%)", 23),
                "",
                StringUtils.center(ChatColor.YELLOW + "github.com/WaIaF", 23));

        updateScoreboard(scoreboard, player);
    }

    private void updateScoreboard(JPerPlayerMethodBasedScoreboard scoreboard, Player player){

        new BukkitRunnable(){

            @Override
            public void run(){

                scoreboard.setLines(player,
                        "",
                        StringUtils.center(ChatColor.WHITE + "Tên người chơi", 23),
                        StringUtils.center(ChatColor.DARK_GREEN + player.getName(), 23),
                        "",
                        StringUtils.center(ChatColor.WHITE + "Coins", 23),
                        StringUtils.center(ChatColor.YELLOW + String.format("%,d", plugin.PlayerCoins.get(player)), 23),
                        "",
                        StringUtils.center(ChatColor.WHITE + "Level", 23),
                        StringUtils.center(ChatColor.LIGHT_PURPLE + String.valueOf(plugin.playerDataManager.getPlayerLevel(player)), 23),
                        "",
                        StringUtils.center(ChatColor.WHITE + "Tiến độ", 23),
                        StringUtils.center(ChatColor.GREEN + String.valueOf(plugin.playerDataManager.getPlayerXP(player)) + "/" + plugin.getPlayerXPReq(player) + " (" + Math.round(((float)plugin.playerDataManager.getPlayerXP(player)/(float)plugin.getPlayerXPReq(player))*100) + "%)", 23),
                        "",
                        StringUtils.center(ChatColor.YELLOW + "github.com/WaIaF", 23));

            }

        }.runTaskTimer(Main.getPlugin(Main.class), 1, 1);

    }

}
