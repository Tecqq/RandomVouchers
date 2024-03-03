package com.tecana.randomvouchers;

import com.tecana.randomvouchers.commands.CmdBase;
import com.tecana.randomvouchers.commands.CommandManager;
import com.tecana.randomvouchers.events.EventPlayerInteract;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomVouchers extends JavaPlugin {

    public CommandManager commandManager;
    private VTypeManager vTypeManager;

    public static RandomVouchers instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        commandManager = new CommandManager();
        vTypeManager = new VTypeManager();
        getCommand("randomvoucher").setExecutor(new CmdBase());
        getServer().getPluginManager().registerEvents(new EventPlayerInteract(), this);
    }

    public VTypeManager getVTypeManager() {
        return vTypeManager;
    }

}
