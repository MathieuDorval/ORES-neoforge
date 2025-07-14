// src/main/java/com/__mathieu/ores/lists/def/ItemTypeDefinition.java
package com.__mathieu.ores.lists.def;

import net.minecraft.world.item.Rarity;

public class ItemDefinition {
    private final String name;
    private final String prefix;
    private final String suffix;
    private final int maxStackSize;
    private final Rarity rarity;
    private final boolean isFireResistant;

    public ItemDefinition(String name, String prefix, String suffix, int maxStackSize, Rarity rarity, boolean isFireResistant) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.maxStackSize = maxStackSize;
        this.rarity = rarity;
        this.isFireResistant = isFireResistant;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public boolean isFireResistant() {
        return isFireResistant;
    }

    public String getFullName(String oreName) {
        StringBuilder fullName = new StringBuilder();
        if (!prefix.isEmpty()) {
            fullName.append(prefix).append("_");
        }
        fullName.append(oreName);
        if (!suffix.isEmpty()) {
            fullName.append("_").append(suffix);
        }
        return fullName.toString();
    }

    @Override
    public String toString() {
        return "ItemTypeDefinition{" +
                "name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", maxStackSize=" + maxStackSize +
                ", rarity=" + rarity +
                ", isFireResistant=" + isFireResistant +
                '}';
    }
}