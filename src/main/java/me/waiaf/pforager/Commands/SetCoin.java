package me.waiaf.pforager.Commands;

import me.waiaf.pforager.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCoin implements CommandExecutor {

    Main plugin;
    public SetCoin(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("setcoin")){

            if (sender instanceof Player){

                Player Commandsender = (Player) sender;

                if (Commandsender.hasPermission("projectforager.setcoin")){

                    if (args.length < 1){

                        Commandsender.sendMessage(ChatColor.WHITE + "Cách dùng lệnh: /setcoin <số coin> [tên người chơi]");

                    } else if (args.length == 1){

                        try{

                            int coin = Integer.parseInt(args[0]);

                            plugin.PlayerCoins.put(Commandsender, coin);
                            plugin.coinManager.getConfig().set("Players." + Commandsender.getName() + "." + Commandsender.getUniqueId().toString() + ".Coins", coin);
                            plugin.coinManager.saveConfig();

                        } catch (NumberFormatException exception){

                            Commandsender.sendMessage(ChatColor.RED + "Vui lòng nhập số coin hợp lệ");
                            return true;

                        }

                    } else if (args.length == 2){

                        try {

                            int coin = Integer.parseInt(args[0]);
                            Player player = Bukkit.getPlayer(args[1]);
                            if (player != null && player.hasPlayedBefore() && player.isOnline()){

                                plugin.PlayerCoins.put(player, coin);
                                plugin.coinManager.getConfig().set("Players." + player.getName() + "." + player.getUniqueId().toString() + ".Coins", coin);
                                plugin.coinManager.saveConfig();

                            }

                        } catch (NumberFormatException exception){

                            Commandsender.sendMessage(ChatColor.RED + "Vui lòng nhập số coin hợp lệ");
                            return true;

                        }

                    } else {

                        Commandsender.sendMessage(ChatColor.WHITE + "Cách dùng lệnh: /setcoin <số coin> [tên người chơi]");

                    }

                }

            } else {

                sender.sendMessage("Chỉ người chơi mới có thể sử dụng lệnh này!");

            }

        }

        return true;
    }
}
