package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.ItemTypeDefinition;
import net.minecraft.world.item.Rarity; // Importez Rarity

import java.util.List;

public class ItemList {
    public static final List<ItemTypeDefinition> ITEM_TYPES = List.of(
            // Nom du type, Préfixe, Suffixe, Max Stack Size, Rareté, Is Fire Resistant
            new ItemTypeDefinition("raw",    "raw",    "",        64, Rarity.COMMON, false),
            new ItemTypeDefinition("ingot",  "",       "ingot",   64, Rarity.COMMON, false),
            new ItemTypeDefinition("dust",   "",       "dust",    64, Rarity.COMMON, false),
            new ItemTypeDefinition("nugget", "",       "nugget",  64, Rarity.COMMON, false),
            new ItemTypeDefinition("gem",    "",       "",        64, Rarity.COMMON, false)
    );

    private ItemList() {
        // Constructeur privé pour empêcher l'instanciation
    }
}