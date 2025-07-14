package com.__mathieu.ores.lists.def;

public class OreDefinition {
    private final String name;
    private final int toolLevel;
    private final int rarity;
    private final boolean requiresSmelting;
    private final String baseForm;

    private final int minDrops;
    private final int maxDrops;
    private final String dropItemForm;

    public OreDefinition(String name, int toolLevel, int rarity, boolean requiresSmelting, String baseForm,
                         int minDrops, int maxDrops, String dropItemForm) {
        this.name = name;
        this.toolLevel = toolLevel;
        this.rarity = rarity;
        this.requiresSmelting = requiresSmelting;
        this.baseForm = baseForm;
        this.minDrops = minDrops;
        this.maxDrops = maxDrops;
        this.dropItemForm = dropItemForm;
    }

    public String getName() {
        return name;
    }

    public int getToolLevel() {
        return toolLevel;
    }

    public int getRarity() {
        return rarity;
    }

    public boolean requiresSmelting() {
        return requiresSmelting;
    }

    public String getBaseForm() {
        return baseForm;
    }

    public int getMinDrops() {
        return minDrops;
    }

    public int getMaxDrops() {
        return maxDrops;
    }

    public String getDropItemForm() {
        return dropItemForm;
    }

    @Override
    public String toString() {
        return "OreDefinition{" +
                "name='" + name + '\'' +
                ", toolLevel=" + toolLevel +
                ", rarity=" + rarity +
                ", requiresSmelting=" + requiresSmelting +
                ", baseForm='" + baseForm + '\'' +
                ", minDrops=" + minDrops +
                ", maxDrops=" + maxDrops +
                ", dropItemForm='" + dropItemForm + '\'' +
                '}';
    }
}