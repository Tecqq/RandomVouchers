package com.tecana.randomvouchers.commands;

import com.tecana.randomvouchers.RandomVouchers;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class CmdBase implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length > 0) {
            return RandomVouchers.instance.commandManager.executeCommand(sender, args[0], Arrays.copyOfRange(args, 1, args.length));
        }
        if (sender.hasPermission("randomvouchers.admin")) {
            sendHelpMessage(sender);
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomVouchers.instance.getConfig().getConfigurationSection("messages").getString("nopermission")));
        }

        return false;
    }
    private void sendHelpMessage(CommandSender sender) {
        for (String string : RandomVouchers.instance.getConfig().getConfigurationSection("messages").getStringList("helpmessage")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
        }
    }
}
