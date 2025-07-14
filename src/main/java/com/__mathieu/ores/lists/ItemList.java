package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.ItemTypeDefinition;

import java.util.List;

public class ItemList {
    public static final List<ItemTypeDefinition> ITEM_TYPES = List.of(
            new ItemTypeDefinition("raw", "raw", ""),
            new ItemTypeDefinition("ingot", "", "ingot"),
            new ItemTypeDefinition("dust", "", "dust"),
            new ItemTypeDefinition("nugget", "", "nugget"),
            new ItemTypeDefinition("gem", "", ""));

    private ItemList() {
        // Constructeur privé pour empêcher l'instanciation
    }
}