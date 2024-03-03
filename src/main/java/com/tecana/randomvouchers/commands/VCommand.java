package com.tecana.randomvouchers.commands;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public abstract class VCommand {

    protected final List<String> aliases = new ArrayList<>();

    public abstract boolean execute(CommandSender sender, String[] args);

    public List<String> getAliases() {
        return this.aliases;
    }
}