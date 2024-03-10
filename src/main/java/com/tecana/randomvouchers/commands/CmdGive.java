package com.tecana.randomvouchers.commands;

import com.tecana.randomvouchers.RandomVouchers;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CmdGive extends VCommand {

    public CmdGive() {
        aliases.add("give");
    }
    @Override
    public boolean execute(CommandSender sender, String[] args) {

        Player player = (Player) sender;
        if (args.length < 2) {
            if (sender.hasPermission("randomvouchers.admin")) {
                sendHelpMessage(sender);
                return false;
            }
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomVouchers.instance.getConfig().getConfigurationSection("messages").getString("nopermission")));
            return false;
        }

        if (sender.hasPermission("randomvouchers.admin")) {
            NBTItem nbtItem = new NBTItem(new ItemStack(Material.getMaterial(RandomVouchers.instance.getVTypeManager().getVTypeByName(args[1]).getMaterial()), Integer.parseInt(args[2])));
            nbtItem.setBoolean("randomvoucher", true);
            nbtItem.setString("randomvouchertype", RandomVouchers.instance.getVTypeManager().getVTypeByName(args[1]).getName());
            ItemStack itemStack = nbtItem.getItem();
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomVouchers.instance.getVTypeManager().getVTypeByName(args[1]).getDisplayName()));
            ArrayList<String> lore = new ArrayList<>();
            for (String loree : RandomVouchers.instance.getVTypeManager().getVTypeByName(args[1]).getLore()) {
                lore.add(ChatColor.translateAlternateColorCodes('&', loree));
            }
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
            Bukkit.getPlayer(args[0]).getInventory().addItem(itemStack);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomVouchers.instance.getConfig().getConfigurationSection("messages").getString("vouchergive").replace("%voucher%", RandomVouchers.instance.getVTypeManager().getVTypeByName(args[1]).getDisplayName())));
        }
        return false;
    }

    private void sendHelpMessage(CommandSender sender) {
        for (String string : RandomVouchers.instance.getConfig().getConfigurationSection("messages").getStringList("helpmessage")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
        }
    }

}
