package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.BlockDefinition;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class BlockList {

    private BlockList() {}

    public static final BlockDefinition RAW_BLOCK = new BlockDefinition(
            "raw_block", "raw", "block", "pickaxe", 1, 5.0F, 6.0F,
            MapColor.STONE, SoundType.STONE, 0.6F, 0, false,
            true, true, false, PushReaction.NORMAL, false, false
    );

    public static final BlockDefinition BLOCK = new BlockDefinition(
            "block", "", "block", "pickaxe", 1, 5.0F, 6.0F,
            MapColor.STONE, SoundType.METAL, 0.6F, 0, false,
            true, true, false, PushReaction.NORMAL, false, false
    );
}