package com.jake.blockplacelava;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("blockplacelava.trigger")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("start")) {
                        if (!Blockplacelava.isStarted) {
                            Blockplacelava.isStarted = true;
                            Bukkit.broadcastMessage(ChatColor.GRAY + "Every Block you place turns to lava has " + ChatColor.GREEN + "begun" + ChatColor.GRAY + "!");
                        } else {
                            player.sendMessage(ChatColor.RED + "The challenge has already started!");
                        }
                    } else if (args[0].equalsIgnoreCase("stop")) {
                        if (Blockplacelava.isStarted) {
                            Blockplacelava.isStarted = false;
                            Bukkit.broadcastMessage(ChatColor.GRAY + "Every Block you place turns to lava has " + ChatColor.RED + "ended" + ChatColor.GRAY + "!");
                        } else {
                            player.sendMessage(ChatColor.RED + "The challenge hasn't started yet!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "/blockplacelava <start/stop>");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "/blockplacelava <start/stop>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
        }

        return false;
    }

}
