package com.__mathieu.ores.core.lists;

import com.__mathieu.ores.core.definitions.StoneDefinition;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class StoneList {

    private StoneList() {}

    public static final StoneDefinition STONE = new StoneDefinition(
            "stone", "minecraft:stone", "pickaxe", 0, 1.5F, 6.0F,
            MapColor.STONE, SoundType.STONE, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );

    public static final StoneDefinition GRANITE = new StoneDefinition(
            "granite", "minecraft:granite", "pickaxe", 0, 1.5F, 6.0F,
            MapColor.DIRT, SoundType.STONE, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );

    public static final StoneDefinition DIORITE = new StoneDefinition(
            "diorite", "minecraft:diorite", "pickaxe", 0, 1.5F, 6.0F,
            MapColor.QUARTZ, SoundType.STONE, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );

    public static final StoneDefinition ANDESITE = new StoneDefinition(
            "andesite", "minecraft:andesite", "pickaxe", 0, 1.5F, 6.0F,
            MapColor.STONE, SoundType.STONE, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );

    public static final StoneDefinition DEEPSLATE = new StoneDefinition(
            "deepslate", "minecraft:deepslate", "pickaxe", 0, 3.0F, 6.0F,
            MapColor.DEEPSLATE, SoundType.DEEPSLATE, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );

    public static final StoneDefinition TUFF = new StoneDefinition(
            "tuff", "minecraft:tuff", "pickaxe", 0, 1.5F, 6.0F,
            MapColor.TERRACOTTA_GRAY, SoundType.TUFF, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );

    public static final StoneDefinition NETHERRACK = new StoneDefinition(
            "netherrack", "minecraft:netherrack", "pickaxe", 0, 0.4F, 0.4F,
            MapColor.NETHER, SoundType.NETHERRACK, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );

    public static final StoneDefinition BASALT = new StoneDefinition(
            "basalt", "minecraft:basalt", "pickaxe", 0, 1.25F, 4.2F,
            MapColor.COLOR_BLACK, SoundType.BASALT, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );

    public static final StoneDefinition BLACKSTONE = new StoneDefinition(
            "blackstone", "minecraft:blackstone", "pickaxe", 0, 1.5F, 6.0F,
            MapColor.COLOR_BLACK, SoundType.STONE, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );

    public static final StoneDefinition END_STONE = new StoneDefinition(
            "end_stone", "minecraft:end_stone", "pickaxe", 0, 3.0F, 9.0F,
            MapColor.SAND, SoundType.STONE, 0.6F, 0,
            true, true, false, PushReaction.NORMAL
    );
}