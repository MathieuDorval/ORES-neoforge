package com.__mathieu.ores.core.definitions;

import net.minecraft.world.item.Rarity;

public class ItemDefinition {
    // Item type properties
    private final String name;              // Name of this item type (e.g., "ingot", "dust", "raw").
    private final String prefix;            // Prefix for the item ID (e.g., "raw" for "raw_iron").
    private final String suffix;            // Suffix for the item ID (e.g., "ingot" for "iron_ingot").
    private final int maxStackSize;         // Maximum stack size for items of this type.
    private final Rarity rarity;            // Base rarity for items of this type.
    private final boolean isFireResistant;  // True if items of this type should be fire resistant.
    private final boolean hasGlint;         // True if items of this type should always have the enchantment glint effect.

    // Food properties
    private final boolean isEdible;         // Can this item type be eaten?
    private final float nutritionMultiplier; // Multiplier for the ore's base nutrition.
    private final float saturationModifierMultiplier; // Multiplier for the ore's base saturation.

    // Fuel properties
    private final boolean isFuel;           // Can this item type be used as fuel?
    private final float burnTimeMultiplier; // Multiplier for the ore's base burn time.


    // Constructor
    public ItemDefinition(String name, String prefix, String suffix, int maxStackSize, Rarity rarity, boolean isFireResistant, boolean hasGlint,
                          boolean isEdible, float nutritionMultiplier, float saturationModifierMultiplier,
                          boolean isFuel, float burnTimeMultiplier) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.maxStackSize = maxStackSize;
        this.rarity = rarity;
        this.isFireResistant = isFireResistant;
        this.hasGlint = hasGlint;
        this.isEdible = isEdible;
        this.nutritionMultiplier = nutritionMultiplier;
        this.saturationModifierMultiplier = saturationModifierMultiplier;
        this.isFuel = isFuel;
        this.burnTimeMultiplier = burnTimeMultiplier;
    }

    // Getters
    public String getName() { return name; }
    public String getPrefix() { return prefix; }
    public String getSuffix() { return suffix; }
    public int getMaxStackSize() { return maxStackSize; }
    public Rarity getRarity() { return rarity; }
    public boolean isFireResistant() { return isFireResistant; }
    public boolean hasGlint() { return hasGlint; }

    // Food Getters
    public boolean isEdible() { return isEdible; }
    public float getNutritionMultiplier() { return nutritionMultiplier; }
    public float getSaturationModifierMultiplier() { return saturationModifierMultiplier; }

    // Fuel Getters
    public boolean isFuel() { return isFuel; }
    public float getBurnTimeMultiplier() { return burnTimeMultiplier; }


    // Constructs the full item ID name.
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
                ", hasGlint=" + hasGlint +
                ", isEdible=" + isEdible +
                ", nutritionMultiplier=" + nutritionMultiplier +
                ", saturationModifierMultiplier=" + saturationModifierMultiplier +
                ", isFuel=" + isFuel +
                ", burnTimeMultiplier=" + burnTimeMultiplier +
                '}';
    }
}