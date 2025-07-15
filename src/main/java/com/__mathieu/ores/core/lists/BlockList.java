package com.__mathieu.ores.core.lists;

import com.__mathieu.ores.core.definitions.BlockDefinition;
import net.minecraft.world.level.block.SoundType;

public class BlockList {

    private BlockList() {}

    public static final BlockDefinition RAW_BLOCK = new BlockDefinition(
            "raw_block", "raw", "block", "pickaxe", 1, true, 5.0F, 6.0F,
            SoundType.STONE, 0.6F, false, false,
            true, true, false, true, false, false, 1.0f, 1.0f
    );

    public static final BlockDefinition BLOCK = new BlockDefinition(
            "block", "", "block", "pickaxe", 1, true, 5.0F, 6.0F,
            null, 0.6F, false, false,
            true, true, false, true, false, false, 1.0f, 1.0f
    );
}