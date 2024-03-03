package com.tecana.randomvouchers.commands;


import com.tecana.randomvouchers.RandomVouchers;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private final Map<String, VCommand> commands = new HashMap<>();

    public CommandManager() {
        addCommand(new CmdGive());
    }

    private void addCommand(VCommand command) {
        for (String alias : command.getAliases()) {
            commands.put(alias, command);
        }
    }

    public boolean executeCommand(CommandSender sender, String alias, String[] args) {
        VCommand command = commands.get(alias);
        if (command != null) {
            return command.execute(sender, args);
        }
        if (sender.hasPermission("randomvouchers.admin")) {
            sendHelpMessage(sender);
            return false;
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomVouchers.instance.getConfig().getConfigurationSection("messages").getString("nopermission")));
        return false;
    }
    private void sendHelpMessage(CommandSender sender) {
        for (String string : RandomVouchers.instance.getConfig().getConfigurationSection("messages").getStringList("helpmessage")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
        }
    }
}
