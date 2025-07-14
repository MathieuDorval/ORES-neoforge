package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.StoneDefinition;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;

import java.util.List;

public class StoneList {
    public static final List<StoneDefinition> STONES = List.of(
            // === VANILLA ===
            // --- Overworld Stones ---
            new StoneDefinition("stone", "minecraft:stone", "pickaxe", 0, 1.5F, 6.0F, MapColor.STONE, SoundType.STONE),
            new StoneDefinition("granite", "minecraft:granite", "pickaxe", 0, 1.5F, 6.0F, MapColor.COLOR_RED, SoundType.STONE),
            new StoneDefinition("diorite", "minecraft:diorite", "pickaxe", 0, 1.5F, 6.0F, MapColor.QUARTZ, SoundType.STONE),
            new StoneDefinition("andesite", "minecraft:andesite", "pickaxe", 0, 1.5F, 6.0F, MapColor.COLOR_GRAY, SoundType.STONE),
            new StoneDefinition("deepslate", "minecraft:deepslate", "pickaxe", 1, 3.0F, 6.0F, MapColor.DEEPSLATE, SoundType.DEEPSLATE),
            new StoneDefinition("tuff", "minecraft:tuff", "pickaxe", 0, 1.5F, 6.0F, MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.TUFF),
            new StoneDefinition("calcite", "minecraft:calcite", "pickaxe", 0, 0.75F, 0.75F, MapColor.TERRACOTTA_LIGHT_GRAY, SoundType.CALCITE),
            // --- Nether Stones ---
            new StoneDefinition("netherrack", "minecraft:netherrack", "pickaxe", 0, 0.4F, 0.4F, MapColor.NETHER, SoundType.NETHERRACK),
            new StoneDefinition("basalt", "minecraft:basalt", "pickaxe", 0, 1.25F, 4.2F, MapColor.PODZOL, SoundType.BASALT),
            new StoneDefinition("smooth_basalt", "minecraft:smooth_basalt", "pickaxe", 0, 2.0F, 6.0F, MapColor.PODZOL, SoundType.BASALT),
            new StoneDefinition("blackstone", "minecraft:blackstone", "pickaxe", 0, 1.5F, 6.0F, MapColor.COLOR_BLACK, SoundType.STONE),
            // --- End Stones ---
            new StoneDefinition("end_stone", "minecraft:end_stone", "pickaxe", 0, 3.0F, 9.0F, MapColor.SAND, SoundType.STONE),
            // --- Shovel ---
            new StoneDefinition("dirt", "minecraft:dirt", "shovel", 0, 0.5F, 0.5F, MapColor.DIRT, SoundType.GRAVEL),
            new StoneDefinition("gravel", "minecraft:gravel", "shovel", 0, 0.6F, 0.6F, MapColor.DIRT, SoundType.GRAVEL),
            new StoneDefinition("sand", "minecraft:sand", "shovel", 0, 0.5F, 0.5F, MapColor.SAND, SoundType.SAND)
    );

    private StoneList() {
        // Constructeur privé pour empêcher l'instanciation
    }
}