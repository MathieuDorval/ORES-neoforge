package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.OreDefinition;
import net.minecraft.world.item.Rarity; // Importez la classe Rarity de Minecraft

import java.util.List;

public class OreList {
    public static final List<OreDefinition> ORES = List.of(
            // Nom, T. Level, Rareté, Nécessite fonte?, Forme après traitement, Min Drops, Max Drops, Forme de Drop, Is Fire Resistant
            new OreDefinition("coal",     0, Rarity.COMMON,   false, "gem",   1, 1, "gem", false),
            new OreDefinition("iron",     1, Rarity.COMMON,   true,  "ingot", 1, 1, "raw", false),
            new OreDefinition("gold",     2, Rarity.COMMON,   true,  "ingot", 1, 1, "raw", false),
            new OreDefinition("diamond",  2, Rarity.UNCOMMON, false, "gem",   1, 1, "gem", false),
            new OreDefinition("emerald",  2, Rarity.UNCOMMON, false, "gem",   1, 1, "gem", false),
            new OreDefinition("lapis",    1, Rarity.COMMON,   false, "gem",   4, 9, "gem", false),
            new OreDefinition("redstone", 1, Rarity.COMMON,   false, "dust",  4, 5, "dust", false),
            new OreDefinition("copper",   1, Rarity.COMMON,   true,  "ingot", 1, 1, "raw", false),
            new OreDefinition("tin",      1, Rarity.COMMON,   true,  "ingot", 1, 1, "raw", false),
            new OreDefinition("silver",   2, Rarity.COMMON,   true,  "ingot", 1, 1, "raw", false)
    );

    private OreList() {
        // Constructeur privé pour empêcher l'instanciation
    }
}