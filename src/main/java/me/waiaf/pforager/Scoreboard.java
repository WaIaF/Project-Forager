package me.waiaf.pforager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
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

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        assert scoreboardManager != null;
        org.bukkit.scoreboard.Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        final Objective objective = scoreboard.registerNewObjective("PlayerScoreboard", "dummy", ChatColor.WHITE + "Project: " + ChatColor.GREEN + "" + ChatColor.BOLD + "Forager");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score1 = objective.getScore(" ");
        score1.setScore(420);
        Score score2 = objective.getScore(ChatColor.WHITE + "Coins: " + ChatColor.YELLOW + this.plugin.PlayerCoins.get(player));
        score2.setScore(69);
        Score score3 = objective.getScore("  ");
        score3.setScore(-69);
        Score score4 = objective.getScore(ChatColor.YELLOW + "github.com/WaIaF");
        score4.setScore(-420);
        player.setScoreboard(scoreboard);

    }

}
