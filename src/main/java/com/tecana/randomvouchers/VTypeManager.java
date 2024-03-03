package com.tecana.randomvouchers;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VTypeManager {

    private final HashMap<String, VType> vTypeMap = new HashMap<>();

    public VTypeManager() {
        loadVTypes();
    }

    private void loadVTypes() {
        ConfigurationSection cTypesSection = RandomVouchers.instance.getConfig().getConfigurationSection("randomvouchers");

        if (cTypesSection != null) {
            for (String key : cTypesSection.getKeys(false)) {
                ConfigurationSection specificTypeSection = cTypesSection.getConfigurationSection(key);
                if (specificTypeSection != null) {
                    String material = specificTypeSection.getString("material");
                    String displayname = specificTypeSection.getString("displayname");
                    List<String> lore = specificTypeSection.getStringList("lore");
                    ConfigurationSection rewardsSection = specificTypeSection.getConfigurationSection("rewards");
                    Map<Integer, Reward> rewards = new HashMap<>();
                    if (rewardsSection != null) {
                        for (String rewardKey : rewardsSection.getKeys(false)) {
                            ConfigurationSection rewardSection = rewardsSection.getConfigurationSection(rewardKey);
                            if (rewardSection != null) {
                                String command = rewardSection.getString("command");
                                String message = rewardSection.getString("message");
                                rewards.put(Integer.parseInt(rewardKey), new Reward(command, message));
                            }
                        }
                    }
                    VType vType = new VType(key, material, displayname, lore, rewards);
                    vTypeMap.put(key, vType);
                }
            }
        }
    }

    public VType getVTypeByName(String name) {
        return vTypeMap.get(name);
    }
}
