package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.OreDefinition;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class OreList {

    private OreList() {}

    public static final OreDefinition IRON = new OreDefinition(
            "iron", false, "ingot",
            Rarity.COMMON, false,
            1, 1, 1, "raw", 0, 0, 1.0f, 1.0f,
            MapColor.METAL, SoundType.METAL, 6.0F, 5.0F, 0.6F, 0, false, true, true, false, PushReaction.NORMAL, false, false,
            0xFFC0C0C0, 10, 3000, 1811, 6000, true, 0.0F, MapColor.METAL, SoundType.MUD,
            0xFF8C7E7E, MapColor.DIRT, SoundType.SLIME_BLOCK, 0xFFC0C0C0, MapColor.METAL, SoundType.SLIME_BLOCK,
            0xFFA09999, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition GOLD = new OreDefinition(
            "gold", false, "ingot",
            Rarity.UNCOMMON, false,
            2, 1, 1, "raw", 0, 0, 1.0f, 1.0f,
            MapColor.GOLD, SoundType.METAL, 6.0F, 3.0F, 0.6F, 0, false, true, true, false, PushReaction.NORMAL, false, false,
            0xFFFCEE4B, 12, 4000, 1337, 8000, true, 0.0F, MapColor.GOLD, SoundType.MUD,
            0xFF9A8411, MapColor.DIRT, SoundType.SLIME_BLOCK, 0xFFFCEE4B, MapColor.GOLD, SoundType.SLIME_BLOCK,
            0xFFFCEE4B, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition DIAMOND = new OreDefinition(
            "diamond", true, "self",
            Rarity.UNCOMMON, false,
            2, 1, 1, "self", 3, 7, 1.0f, 1.0f,
            MapColor.DIAMOND, SoundType.METAL, 6.0F, 5.0F, 0.6F, 0, false, true, true, false, PushReaction.NORMAL, false, false,
            0xFF6AE8E0, 15, 5000, 4000, 10000, true, 0.0F, MapColor.DIAMOND, SoundType.MUD,
            0xFF4AC4B9, MapColor.DIRT, SoundType.SLIME_BLOCK, 0xFF6AE8E0, MapColor.DIAMOND, SoundType.SLIME_BLOCK,
            0xFFB9F2FF, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition EMERALD = new OreDefinition(
            "emerald", true, "self",
            Rarity.RARE, false,
            2, 1, 1, "self", 3, 7, 1.0f, 1.0f,
            MapColor.EMERALD, SoundType.METAL, 6.0F, 5.0F, 0.6F, 0, false, true, true, false, PushReaction.NORMAL, false, false,
            0xFF00B039, 14, 4500, 2500, 9000, true, 0.0F, MapColor.EMERALD, SoundType.MUD,
            0xFF008A2D, MapColor.DIRT, SoundType.SLIME_BLOCK, 0xFF00B039, MapColor.EMERALD, SoundType.SLIME_BLOCK,
            0xFF7CFF9A, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition LAPIS = new OreDefinition(
            "lapis", true, "self",
            Rarity.COMMON, false,
            1, 4, 9, "self", 2, 5, 1.0f, 1.0f,
            MapColor.LAPIS, SoundType.STONE, 3.0F, 3.0F, 0.6F, 0, false, true, true, false, PushReaction.NORMAL, false, false,
            0xFF1044AA, 8, 2000, 800, 4000, true, 0.0F, MapColor.LAPIS, SoundType.MUD,
            0xFF0B2D6D, MapColor.DIRT, SoundType.SLIME_BLOCK, 0xFF1044AA, MapColor.LAPIS, SoundType.SLIME_BLOCK,
            0xFF5E8AFF, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition REDSTONE = new OreDefinition(
            "redstone", true, "dust",
            Rarity.COMMON, false,
            2, 4, 5, "self", 1, 5, 1.0f, 1.0f,
            MapColor.COLOR_RED, SoundType.STONE, 6.0F, 5.0F, 0.6F, 0, false, true, true, false, PushReaction.NORMAL, false, true,
            0xFFFF0000, 15, 1500, 660, 7000, true, 0.0F, MapColor.COLOR_RED, SoundType.MUD,
            0xFF8B0000, MapColor.DIRT, SoundType.SLIME_BLOCK, 0xFFFF0000, MapColor.COLOR_RED, SoundType.SLIME_BLOCK,
            0xFFFF5555, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition COAL = new OreDefinition(
            "coal", true, "self",
            Rarity.COMMON, false,
            0, 1, 1, "self", 0, 2, 1.0f, 1.0f,
            MapColor.COLOR_BLACK, SoundType.STONE, 6.0F, 5.0F, 0.6F, 0, false, true, true, false, PushReaction.NORMAL, false, false,
            0xFF363636, 2, 1350, 600, 3000, true, 0.0F, MapColor.COLOR_BLACK, SoundType.MUD,
            0xFF202020, MapColor.DIRT, SoundType.SLIME_BLOCK, 0xFF404040, MapColor.COLOR_BLACK, SoundType.SLIME_BLOCK,
            0xFF555555, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition COPPER = new OreDefinition(
            "copper", false, "ingot",
            Rarity.COMMON, false,
            1, 2, 5, "raw", 0, 0, 1.0f, 1.0f,
            MapColor.COLOR_ORANGE, SoundType.COPPER, 6.0F, 3.0F, 0.6F, 0, false, true, true, false, PushReaction.NORMAL, true, false,
            0xFFD96941, 10, 3500, 1358, 7000, true, 0.0F, MapColor.COLOR_ORANGE, SoundType.MUD,
            0xFF94482D, MapColor.DIRT, SoundType.SLIME_BLOCK, 0xFFD96941, MapColor.COLOR_ORANGE, SoundType.SLIME_BLOCK,
            0xFFE07C5A, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition NETHERITE = new OreDefinition(
            "netherite", false, "ingot",
            Rarity.EPIC, true,
            3, 1, 1, "self", 1, 2, 1.0f, 1.0f,
            MapColor.COLOR_BLACK, SoundType.NETHERITE_BLOCK, 1200.0F, 50.0F, 0.6F, 0, false, true, true, false, PushReaction.BLOCK, false, false,
            0xFF4C414C, 15, 7000, 3200, 12000, true, 0.0F, MapColor.COLOR_BLACK, SoundType.MUD,
            0xFF3B323B, MapColor.NETHER, SoundType.SLIME_BLOCK, 0xFF4C414C, MapColor.COLOR_BLACK, SoundType.SLIME_BLOCK,
            0xFF6D5F6D, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition QUARTZ = new OreDefinition(
            "quartz", true, "self",
            Rarity.COMMON, false,
            0, 1, 1, "self", 2, 5, 1.0f, 1.0f,
            MapColor.QUARTZ, SoundType.STONE, 0.8F, 0.8F, 0.6F, 0, false, true, true, false, PushReaction.NORMAL, false, false,
            0xFFF7F4EC, 5, 2200, 1986, 8000, true, 0.0F, MapColor.QUARTZ, SoundType.MUD,
            0xFFCEC4B7, MapColor.NETHER, SoundType.SLIME_BLOCK, 0xFFF7F4EC, MapColor.QUARTZ, SoundType.SLIME_BLOCK,
            0xFFFFFFFF, MapColor.NONE, SoundType.EMPTY
    );

    public static final OreDefinition EXEMPLE = new OreDefinition(
            "exemple", false, "ingot",
            Rarity.UNCOMMON, false,
            2, 1, 1, "raw", 2, 6, 1.1f, 1.1f,
            MapColor.COLOR_PURPLE, SoundType.AMETHYST, 7.0F, 4.0F, 0.6F, 4, false, true, true, false, PushReaction.NORMAL, false, false,
            0xFF8A2BE2, 10, 3200, 2000, 6500, true, 0.0F, MapColor.COLOR_PURPLE, SoundType.MUD,
            0xFF6A1F9C, MapColor.DIRT, SoundType.SLIME_BLOCK, 0xFF8A2BE2, MapColor.COLOR_PURPLE, SoundType.SLIME_BLOCK,
            0xFFC388FF, MapColor.NONE, SoundType.EMPTY
    );
}