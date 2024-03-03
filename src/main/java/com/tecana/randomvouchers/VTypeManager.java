package com.tecana.randomvouchers;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.List;

public class RTypeManager {

    private final HashMap<String, BType> bTypeMap = new HashMap<>();

    public RTypeManager() {
        loadCTypes();
    }

    private void loadCTypes() {
        ConfigurationSection cTypesSection = Blueprints.instance.getConfig().getConfigurationSection("blueprints");

        if (cTypesSection != null) {
            for (String key : cTypesSection.getKeys(false)) {
                ConfigurationSection specificTypeSection = cTypesSection.getConfigurationSection(key);
                if (specificTypeSection != null) {

                    String displayname = specificTypeSection.getString("displayname");
                    List<String> lore = specificTypeSection.getStringList("lore");
                    String schematic = specificTypeSection.getString("schematic");
                    int blockspersecond = specificTypeSection.getInt("blockspersecond");
                    String title = specificTypeSection.getString("title");

                    BType cType = new BType(key, displayname, lore, schematic, blockspersecond, title);
                    bTypeMap.put(key, cType);
                }
            }
        }
    }

    public BType getBTypeByName(String name) {
        return bTypeMap.get(name);
    }
}
