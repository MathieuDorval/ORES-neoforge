// src/main/java/com/__mathieu/ores/lists/BlockList.java
package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.BlockDefinition;

import java.util.List;

public class BlockList {
    public static final List<BlockDefinition> BLOCKS = List.of(
            new BlockDefinition("raw_block",        "raw_",       "block",   "pickaxe", 0, 3.0F, 3.0F),
            new BlockDefinition("block",            "",           "block",   "pickaxe", 0, 5.0F, 6.0F),
            new BlockDefinition("compressed_block", "compressed_", "block",  "pickaxe", 1, 8.0F, 10.0F)
    );

    private BlockList() {
        // Constructeur privé pour empêcher l'instanciation
    }
}