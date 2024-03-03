package com.tecana.blueprints.cmds;

import com.tecana.blueprints.Blueprints;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class CmdBase implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length > 0) {
            return Blueprints.instance.commandManager.executeCommand(sender, args[0], Arrays.copyOfRange(args, 1, args.length));
        }
        sendHelpMessage(sender);

        return false;
    }

    private void sendHelpMessage(CommandSender sender) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l---------------------------------------"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lBlueprints &8&l→ &7Help"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<> = Required"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[] = Optional"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lCOMMANDS:"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l→ &7/blueprints give <player> <type> [amount]"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l→ &7/blueprints help"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l---------------------------------------"));
    }
}
