package me.waiaf.pforager.Commands;

import me.waiaf.pforager.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetXP implements CommandExecutor {

    Main plugin;
    public SetXP(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player Commandsender = (Player) sender;

            if (Commandsender.hasPermission("projectforager.setxp")){

                if (args.length < 1){

                    Commandsender.sendMessage(ChatColor.WHITE + "Cách dùng lệnh: /setxp <xp> [tên người chơi]");

                } else if (args.length == 1){

                    try{

                        int xp = Integer.parseInt(args[0]);

                        plugin.playerDataManager.setPlayerXP(Commandsender, xp);
                        Commandsender.sendMessage(ChatColor.GREEN + "Thành công!");
                        Commandsender.playSound(Commandsender.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);

                    } catch (NumberFormatException exception){

                        Commandsender.sendMessage(ChatColor.RED + "Vui lòng nhập level hợp lệ");
                        return true;

                    }

                } else if (args.length == 2){

                    try {

                        int xp = Integer.parseInt(args[0]);
                        Player player = Bukkit.getPlayer(args[1]);
                        if (player != null && player.hasPlayedBefore() && player.isOnline()){

                            plugin.playerDataManager.setPlayerXP(player, xp);
                            Commandsender.sendMessage(ChatColor.GREEN + "Thành công!");
                            Commandsender.playSound(Commandsender.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2f);

                        } else {

                            Commandsender.sendMessage(ChatColor.RED + "Người chơi không tồn tại hoặc đang offline");

                        }

                    } catch (NumberFormatException exception){

                        Commandsender.sendMessage(ChatColor.RED + "Vui lòng nhập số coin hợp lệ");
                        return true;

                    }

                } else {

                    Commandsender.sendMessage(ChatColor.WHITE + "Cách dùng lệnh: /setxp <xp> [tên người chơi]");

                }

            }

        } else {

            sender.sendMessage("Chỉ người chơi mới có thể sử dụng lệnh này!");

        }

        return true;
    }
}
