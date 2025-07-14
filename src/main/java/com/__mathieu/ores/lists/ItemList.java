// src/main/java/com/__mathieu/ores/lists/ItemList.java
package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.ItemDefinition;
import net.minecraft.world.item.Rarity;

import java.util.List;

public class ItemList {
    public static final List<ItemDefinition> ITEM_TYPES = List.of(
            // --- INITIALE ---
            new ItemDefinition("self",          "",         "",             64, Rarity.COMMON, false),
            new ItemDefinition("ingot",         "",         "ingot",        64, Rarity.COMMON, false),

            // --- VANILLA ---
            new ItemDefinition("raw",           "raw",      "",             64, Rarity.COMMON, false),
            new ItemDefinition("nugget",        "",         "nugget",       64, Rarity.COMMON, false),

            // --- MEKANISM ---
            new ItemDefinition("clump",         "",         "clump",        64, Rarity.COMMON, false),
            new ItemDefinition("shard",         "",         "shard",        64, Rarity.COMMON, false),
            new ItemDefinition("crystal",       "",         "crystal",      64, Rarity.COMMON, false),
            new ItemDefinition("dirty_dust",    "",         "dirty_dust",   64, Rarity.COMMON, false),
            new ItemDefinition("dust",          "",         "dust",         64, Rarity.COMMON, false),

            // --- AUTRES MODS PRINCIPAUX ---
            new ItemDefinition("plate",         "",         "plate",        64, Rarity.COMMON, false),
            new ItemDefinition("rod",           "",         "rod",          64, Rarity.COMMON, false),
            new ItemDefinition("gear",          "",         "gear",         64, Rarity.COMMON, false),
            new ItemDefinition("wire",          "",         "wire",         64, Rarity.COMMON, false)

    );

    private ItemList() {
        // Constructeur privé pour empêcher l'instanciation
    }
}