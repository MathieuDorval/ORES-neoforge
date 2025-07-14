package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.ItemDefinition;
import net.minecraft.world.item.Rarity;

public class ItemList {

    private ItemList() {}

    public static final ItemDefinition SELF = new ItemDefinition(
            "self", "", "", 64, Rarity.COMMON,
            false, false, false, 0, 0.0f, false
    );

    public static final ItemDefinition INGOT = new ItemDefinition(
            "ingot", "", "ingot", 64, Rarity.COMMON,
            false, false, false, 0, 0.0f, false
    );

    public static final ItemDefinition RAW = new ItemDefinition(
            "raw", "raw", "", 64, Rarity.COMMON,
            false, false, false, 0, 0.0f, false
    );

    public static final ItemDefinition DUST = new ItemDefinition(
            "dust", "", "dust", 64, Rarity.COMMON,
            false, false, false, 0, 0.0f, false
    );

}