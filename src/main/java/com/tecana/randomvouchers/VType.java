package com.tecana.randomvouchers;

import java.util.List;

import java.util.Map;

public class VType {
    private final String name;
    private final String material;
    private final String displayname;
    private final List<String> lore;
    private final Map<Integer, Reward> rewards;

    public VType(String name, String material, String displayname, List<String> lore, Map<Integer, Reward> rewards) {
        this.name = name;
        this.material = material;
        this.displayname = displayname;
        this.lore = lore;
        this.rewards = rewards;
    }
    public String getName() {
        return name;
    }
    public String getMaterial() {
        return material;
    }
    public String getDisplayName() {
        return displayname;
    }
    public List<String> getLore() {
        return lore;
    }
    public Map<Integer, Reward> getRewards() {
        return rewards;
    }
}
