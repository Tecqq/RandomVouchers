package com.tecana.randomvouchers.events;

import com.tecana.randomvouchers.RandomVouchers;
import com.tecana.randomvouchers.Reward;
import com.tecana.randomvouchers.VType;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EventPlayerInteract implements Listener {

    public boolean isRandomVoucher(ItemStack stack) {
        return new NBTItem(stack).getBoolean("randomvoucher");
    }

    public String getType(ItemStack stack) {
        return new NBTItem(stack).getString("randomvouchertype");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand().getType().equals(Material.AIR)) return;
        if ((event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) && isRandomVoucher(player.getItemInHand())) {
            VType vType = RandomVouchers.instance.getVTypeManager().getVTypeByName(getType(player.getItemInHand()));
            event.setCancelled(true);
            if (vType != null && !vType.getRewards().isEmpty()) {
                if (player.getItemInHand().getAmount() == 1) player.setItemInHand(new ItemStack(Material.AIR));
                if (player.getItemInHand().getAmount() > 1) player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                Random random = new Random();
                int randomIndex = random.nextInt(vType.getRewards().size()) + 1;

                Reward reward = vType.getRewards().get(randomIndex);
                if (reward != null) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), reward.getCommand().replace("%player%", player.getName()));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', reward.getMessage()));
                }
            }
        }
    }
}
