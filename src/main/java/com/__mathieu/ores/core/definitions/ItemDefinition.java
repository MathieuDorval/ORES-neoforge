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
    private final boolean isEdible;         // True if items of this type are edible.
    private final int foodNutrition;        // Amount of hunger points restored by the food item.**
    private final float foodSaturationModifier; // Saturation modifier for the food item.**
    private final boolean foodAlwaysEdible; // True if the food item can always be eaten, regardless of hunger level.**


    // Constructor
    public ItemDefinition(String name, String prefix, String suffix, int maxStackSize, Rarity rarity, boolean isFireResistant, boolean hasGlint, boolean isEdible,
                          int foodNutrition, float foodSaturationModifier, boolean foodAlwaysEdible) { // Nouveaux paramètres nourriture
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.maxStackSize = maxStackSize;
        this.rarity = rarity;
        this.isFireResistant = isFireResistant;
        this.hasGlint = hasGlint;
        this.isEdible = isEdible;
        this.foodNutrition = foodNutrition;         // Initialisation
        this.foodSaturationModifier = foodSaturationModifier; // Initialisation
        this.foodAlwaysEdible = foodAlwaysEdible;   // Initialisation
    }

    // Getters
    public String getName() { return name; }
    public String getPrefix() { return prefix; }
    public String getSuffix() { return suffix; }
    public int getMaxStackSize() { return maxStackSize; }
    public Rarity getRarity() { return rarity; }
    public boolean isFireResistant() { return isFireResistant; }
    public boolean hasGlint() { return hasGlint; }
    public boolean isEdible() { return isEdible; }
    public int getFoodNutrition() { return foodNutrition; }
    public float getFoodSaturationModifier() { return foodSaturationModifier; }
    public boolean isFoodAlwaysEdible() { return foodAlwaysEdible; } // Nouveau getter

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
                ", foodNutrition=" + foodNutrition +
                ", foodSaturationModifier=" + foodSaturationModifier +
                ", foodAlwaysEdible=" + foodAlwaysEdible +
                '}';
    }
}