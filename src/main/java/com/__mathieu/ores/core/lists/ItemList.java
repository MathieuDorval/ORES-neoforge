package com.__mathieu.ores.core.lists;

import com.__mathieu.ores.core.definitions.ItemDefinition;
import net.minecraft.world.item.Rarity;

public class ItemList {

    private ItemList() {}

    /**
     * Represents the "self" form of an ore (e.g., coal, diamond).
     * It inherits edibility and fuel properties directly from the base OreDefinition.
     */
    public static final ItemDefinition SELF = new ItemDefinition(
            "self", "", "", 64, Rarity.COMMON,
            false, false,
            true, 1.0f, 1.0f, // isEdible = true, with 100% of base nutrition/saturation
            true, 1.0f  // isFuel = true, with 100% of base burn time
    );

    /**
     * Represents an ingot form (e.g., iron ingot, gold ingot).
     * Ingots are generally not edible or used as fuel.
     */
    public static final ItemDefinition INGOT = new ItemDefinition(
            "ingot", "", "ingot", 64, Rarity.COMMON,
            false, false,
            false, 0.0f, 0.0f, // Not edible
            false, 0.0f  // Not a fuel
    );

    /**
     * Represents a raw form (e.g., raw iron, raw gold).
     * Raw forms are not edible or used as fuel.
     */
    public static final ItemDefinition RAW = new ItemDefinition(
            "raw", "raw", "", 64, Rarity.COMMON,
            false, false,
            false, 0.0f, 0.0f, // Not edible
            false, 0.0f  // Not a fuel
    );

    /**
     * Represents a dust form (e.g., iron dust, gold dust).
     * Dusts are not edible or used as fuel.
     */
    public static final ItemDefinition DUST = new ItemDefinition(
            "dust", "", "dust", 64, Rarity.COMMON,
            false, false,
            false, 0.0f, 0.0f, // Not edible
            false, 0.0f  // Not a fuel
    );

}