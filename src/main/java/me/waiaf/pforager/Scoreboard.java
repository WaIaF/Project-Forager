package me.waiaf.pforager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class Scoreboard {

    Main plugin;
    public Scoreboard(Main plugin){
        this.plugin = plugin;
    }

    public void createBoard(Player player){

        int coin = plugin.PlayerCoins.get(player);
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        assert scoreboardManager != null;
        org.bukkit.scoreboard.Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("PlayerScoreboard", "dummy", ChatColor.WHITE + "Project: " + ChatColor.GREEN + "" + ChatColor.BOLD + "Forager");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score1 = objective.getScore("");
        score1.setScore(6);
        Score score2 = objective.getScore(" ");
        score2.setScore(5);
        Score score3 = objective.getScore(ChatColor.WHITE + "Coins: " + ChatColor.YELLOW + coin);
        score3.setScore(4);
        Score score4 = objective.getScore("  ");
        score4.setScore(3);
        Score score5 = objective.getScore("   ");
        score5.setScore(2);
        Score score6 = objective.getScore(ChatColor.YELLOW + "github.com/WaIaF");
        score6.setScore(1);
        updateScoreboard(player, scoreboard, coin, objective);

    }

    private void updateScoreboard(Player player, org.bukkit.scoreboard.Scoreboard scoreboard, Integer coin, Objective objective){

        new BukkitRunnable(){

            @Override
            public void run(){

                Score score3 = objective.getScore(ChatColor.WHITE + "Coins: " + ChatColor.YELLOW + coin);
                score3.setScore(4);
                player.setScoreboard(scoreboard);

            }

        }.runTaskTimer(Main.getPlugin(Main.class), 10, 10);

    }

}
