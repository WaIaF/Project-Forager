package me.waiaf.pforager.Commands;

import me.waiaf.pforager.Utils.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GetItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("getitem")){

            if (sender instanceof Player){

                Player player = (Player) sender;

                if (player.hasPermission("projectforager.getitem")){

                    if (args.length == 1){

                        try{

                            if (ItemManager.ItemIDs.containsKey(Integer.parseInt(args[0]))){

                                ItemStack itemStack = ItemManager.ItemIDs.get(Integer.parseInt(args[0]));
                                player.getInventory().addItem(itemStack);

                            } else {

                                player.sendMessage(ChatColor.RED + "ID không tồn tại");

                            }

                        } catch (NumberFormatException exception){

                            player.sendMessage(ChatColor.RED + "Vui lòng điền ID hợp lệ");
                            return true;

                        }

                    } else if (args.length == 2){

                        try{

                            if (ItemManager.ItemIDs.containsKey(Integer.parseInt(args[0]))){

                                ItemStack itemStack = ItemManager.ItemIDs.get(Integer.parseInt(args[0]));
                                itemStack.setAmount(Integer.parseInt(args[1]));
                                player.getInventory().addItem(itemStack);

                            } else {

                                player.sendMessage(ChatColor.RED + "ID không tồn tại");

                            }

                        } catch (NumberFormatException exception){
                            
                            player.sendMessage(ChatColor.RED + "Vui lòng điền ID / số lượng hợp lệ");
                            return true;

                        }

                    } else if (args.length < 1){

                        player.sendMessage(ChatColor.WHITE + "Cách dùng lệnh: /getitem <ID vật phẩm> [số lượng]");

                    } else {

                        player.sendMessage(ChatColor.WHITE + "Cách dùng lệnh: /getitem <ID vật phẩm> [số lượng]");

                    }

                }

            } else {

                sender.sendMessage("Chỉ người chơi mới có thể sử dụng lệnh này!");

            }


        }

        return true;
    }
}
