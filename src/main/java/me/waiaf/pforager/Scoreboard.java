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
                StringUtils.center(ChatColor.WHITE + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=", 19),
                "",
                StringUtils.center(ChatColor.WHITE + "Tên người chơi", 19),
                StringUtils.center(ChatColor.GREEN + player.getName(), 19),
                "",
                StringUtils.center(ChatColor.WHITE + "Coins", 19),
                StringUtils.center(ChatColor.YELLOW + String.format("%,d", plugin.PlayerCoins.get(player)), 19),
                "",
                StringUtils.center(ChatColor.WHITE + "Kinh nghiệm", 19),
                StringUtils.center(ChatColor.LIGHT_PURPLE + String.valueOf(Math.round(player.getExp())), 19),
                "",
                ChatColor.YELLOW + "github.com/WaIaF");

        updateScoreboard(scoreboard, player);
    }

    private void updateScoreboard(JPerPlayerMethodBasedScoreboard scoreboard, Player player){

        new BukkitRunnable(){

            @Override
            public void run(){

                scoreboard.setLines(player,
                        StringUtils.center(ChatColor.WHITE + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=", 19),
                        "",
                        StringUtils.center(ChatColor.WHITE + "Tên người chơi", 19),
                        StringUtils.center(ChatColor.GREEN + player.getName(), 19),
                        "",
                        StringUtils.center(ChatColor.WHITE + "Coins", 19),
                        StringUtils.center(ChatColor.YELLOW + String.format("%,d", plugin.PlayerCoins.get(player)), 19),
                        "",
                        StringUtils.center(ChatColor.WHITE + "Kinh nghiệm", 19),
                        StringUtils.center(ChatColor.LIGHT_PURPLE + String.valueOf(Math.round(player.getExp())), 19),
                        "",
                        ChatColor.YELLOW + "github.com/WaIaF");

            }

        }.runTaskTimer(Main.getPlugin(Main.class), 3, 3);

    }

}
