// src/main/java/com/__mathieu/ores/lists/OreList.java
package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.OreDefinition;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;

import java.util.List;

public class OreList {
    public static final List<OreDefinition> ORES = List.of(
            new OreDefinition("coal",     0, Rarity.COMMON,   true,  "self",   1, 1, "self", false, MapColor.COLOR_BLACK,    SoundType.STONE,   3.0F, 3.0F),
            new OreDefinition("iron",     1, Rarity.COMMON,   false, "ingot",  1, 1, "raw",  false, MapColor.RAW_IRON,       SoundType.STONE,   3.0F, 3.0F),
            new OreDefinition("gold",     2, Rarity.COMMON,   false, "ingot",  1, 1, "raw",  false, MapColor.GOLD,           SoundType.STONE,   3.0F, 3.0F),
            new OreDefinition("diamond",  2, Rarity.UNCOMMON, true,  "self",   1, 1, "self", false, MapColor.DIAMOND,        SoundType.STONE,   3.0F, 3.0F),
            new OreDefinition("emerald",  2, Rarity.UNCOMMON, true,  "self",   1, 1, "self", false, MapColor.EMERALD,        SoundType.STONE,   3.0F, 3.0F),
            new OreDefinition("lapis",    1, Rarity.COMMON,   true,  "self",   4, 9, "self", false, MapColor.LAPIS,          SoundType.STONE,   3.0F, 3.0F),
            new OreDefinition("redstone", 1, Rarity.COMMON,   false, "dust",   4, 5, "dust", false, MapColor.COLOR_RED,      SoundType.STONE,   3.0F, 3.0F),
            new OreDefinition("copper",   1, Rarity.COMMON,   false, "ingot",  1, 1, "raw",  false, MapColor.COLOR_ORANGE,   SoundType.STONE,   3.0F, 3.0F),
            new OreDefinition("tin",      1, Rarity.COMMON,   false, "ingot",  1, 1, "raw",  false, MapColor.TERRACOTTA_GRAY, SoundType.STONE,   3.0F, 3.0F),
            new OreDefinition("silver",   2, Rarity.COMMON,   false, "ingot",  1, 1, "raw",  false, MapColor.TERRACOTTA_WHITE,SoundType.STONE,   3.0F, 3.0F)
    );

    private OreList() {
        // Constructeur privé pour empêcher l'instanciation
    }
}