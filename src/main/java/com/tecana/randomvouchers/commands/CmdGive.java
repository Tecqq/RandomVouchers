package com.tecana.blueprints.cmds;

import com.tecana.blueprints.Blueprints;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CmdGive extends BCommand {

    public CmdGive() {
        aliases.add("give");
    }
    @Override
    public boolean execute(CommandSender sender, String[] args) {

        Player player = (Player) sender;
        if (args.length < 2) {
            if (sender.hasPermission("blueprints.admin")) {
                sendAdminHelpMessage(sender);
                return false;
            }
            sendHelpMessage(sender);
            return false;
        }

        if (sender.hasPermission("blueprints.admin")) {
            NBTItem nbtItem = new NBTItem(new ItemStack(Material.BRICKS, 1));
            nbtItem.setBoolean("blueprint", true);
            nbtItem.setString("blueprinttype", Blueprints.instance.getBTypeManager().getBTypeByName(args[1]).getName());
            ItemStack itemStack = nbtItem.getItem();
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Blueprints.instance.getBTypeManager().getBTypeByName(args[1]).getDisplayName()));
            ArrayList<String> lore = new ArrayList<>();
            for (String loree : Blueprints.instance.getBTypeManager().getBTypeByName(args[1]).getLore()) {
                lore.add(ChatColor.translateAlternateColorCodes('&', loree));
            }
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
            player.getInventory().addItem(itemStack);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lBlueprints &8&l→ &7You have been given a " + Blueprints.instance.getBTypeManager().getBTypeByName(args[1]).getDisplayName() + " blueprint."));
        }
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
