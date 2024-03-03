package com.tecana.blueprints.cmds;


import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private final Map<String, BCommand> commands = new HashMap<>();

    public CommandManager() {
        addCommand(new CmdGive());
    }

    private void addCommand(BCommand command) {
        for (String alias : command.getAliases()) {
            commands.put(alias, command);
        }
    }

    public boolean executeCommand(CommandSender sender, String alias, String[] args) {
        BCommand command = commands.get(alias);
        if (command != null) {
            return command.execute(sender, args);
        }
        if (sender.hasPermission("blueprints.admin")) {
            sendAdminHelpMessage(sender);
            return false;
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
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l→ &7/blueprints help"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l---------------------------------------"));
    }

    private void sendAdminHelpMessage(CommandSender sender) {
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
