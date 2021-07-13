package me.waiaf.pforager.Commands;

import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("getitem")){

            if (sender instanceof Player){

                Player player = (Player) sender;

                if (player.hasPermission("projectforager.getitem")){

                    if (args.length < 1){

                        player.sendMessage(ChatColor.WHITE + "Cách dùng lệnh: /getitem <ID vật phẩm>");

                    } else if (args.length == 1){

                        try{

                            switch (Integer.parseInt(args[0])){

                                case 1:

                                    player.sendMessage(ChatColor.GREEN + "Lấy vật phẩm thành công");
                                    player.getInventory().addItem(ItemManager.IronPickaxe);
                                    break;

                                case 2:

                                    player.sendMessage(ChatColor.GREEN + "Lấy vật phẩm thành công");
                                    player.getInventory().addItem(ItemManager.IronShovel);
                                    break;

                                default:

                                    player.sendMessage(ChatColor.RED + "ID không tồn tại");

                            }


                        } catch (NumberFormatException exception){

                            sender.sendMessage(ChatColor.RED + "Vui lòng điền ID hợp lệ");
                            return true;

                        }

                    }

                }

            } else {

                sender.sendMessage("Chỉ người chơi mới có thể sử dụng lệnh này!");

            }


        }

        return true;
    }
}
