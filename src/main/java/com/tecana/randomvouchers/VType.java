package com.tecana.randomvouchers;

import java.util.List;

public class RType {
    private final String name;
    private final String displayname;
    private final String schematic;
    private final List<String> lore;
    private int blockspersecond;
    private String title;

    public RType(String name, String displayname, List<String> lore, String schematic, int blockspersecond, String title) {
        this.name = name;

        this.lore = lore;
        this.displayname = displayname;
        this.schematic = schematic;
        this.blockspersecond = blockspersecond;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayname;
    }
    public List<String> getLore() {
        return lore;
    }

    public String getSchematic() {
        return schematic;
    }

    public int getBlocksPerSecond() {
        return blockspersecond;
    }

    public String getTitle() {
        return title;
    }
}
