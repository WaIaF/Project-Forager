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
                ChatColor.WHITE + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=-=-=-=",
                "",
                "",
                StringUtils.center(ChatColor.WHITE + "Coins", 19),
                StringUtils.center(ChatColor.YELLOW + plugin.PlayerCoins.get(player).toString(), 19),
                "",
                "",
                ChatColor.YELLOW + "github.com/WaIaF");

        updateScoreboard(scoreboard, player);
    }

    private void updateScoreboard(JPerPlayerMethodBasedScoreboard scoreboard, Player player){

        new BukkitRunnable(){

            @Override
            public void run(){

                scoreboard.setLines(player,
                        ChatColor.WHITE + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=-=-=-=",
                        "",
                        "",
                        StringUtils.center(ChatColor.WHITE + "Coins", 19),
                        StringUtils.center(ChatColor.YELLOW + plugin.PlayerCoins.get(player).toString(), 19),
                        "",
                        "",
                        ChatColor.YELLOW + "github.com/WaIaF");

            }

        }.runTaskTimer(Main.getPlugin(Main.class), 5, 5);

    }

}
