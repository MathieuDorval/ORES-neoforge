package com.__mathieu.ores.core;

import com.__mathieu.ores.lists.def.OreDefinition;   // Importez OreDefinition
import com.__mathieu.ores.lists.def.StoneDefinition; // Importez StoneDefinition
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;

// Cette classe définit les propriétés d'un bloc de minerai unifié combinant un matériau et une pierre.
public record UnifiedOreBlockProperties(
        String id,
        OreDefinition material,
        StoneDefinition stone,
        String requiredTool,
        int toolLevel,
        float hardness,
        float resistance,
        MapColor mapColor,
        SoundType soundType
) {

    public BlockBehaviour.Properties toBlockProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .strength(hardness, resistance)
                .requiresCorrectToolForDrops()
                .sound(soundType);
    }
}