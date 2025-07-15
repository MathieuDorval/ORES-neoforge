package com.__mathieu.ores.core.lists;

import com.__mathieu.ores.core.definitions.OreDefinition;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.SoundType;

public class OreList {

    private OreList() {}

    public static final OreDefinition IRON = new OreDefinition(
            "iron", false, "ingot",
            Rarity.COMMON, false, false, 0, 0.0f, false, false, 0,
            1, 1, 1, "raw", 0, 0, 1.0f, 1.0f,
            SoundType.METAL, 6.0F, 5.0F, 0.6F, false, false, true, true, false, true, false, 0, 1.0f, 1.0f,
            0xFFC0C0C0, 10, 3000, 1811, 6000, true, 0.0F, SoundType.MUD,
            0xFF8C7E7E, SoundType.SLIME_BLOCK, 0xFFC0C0C0, SoundType.SLIME_BLOCK,
            0xFFA09999, SoundType.EMPTY
    );

    public static final OreDefinition GOLD = new OreDefinition(
            "gold", false, "ingot",
            Rarity.UNCOMMON, false, false, 0, 0.0f, false, false, 0,
            2, 1, 1, "raw", 0, 0, 1.0f, 1.0f,
            SoundType.METAL, 6.0F, 3.0F, 0.6F, false, false, true, true, false, true, false, 0, 1.0f, 1.0f,
            0xFFFCEE4B, 12, 4000, 1337, 8000, true, 0.0F, SoundType.MUD,
            0xFF9A8411, SoundType.SLIME_BLOCK, 0xFFFCEE4B, SoundType.SLIME_BLOCK,
            0xFFFCEE4B, SoundType.EMPTY
    );

    public static final OreDefinition DIAMOND = new OreDefinition(
            "diamond", true, "self",
            Rarity.UNCOMMON, false, false, 0, 0.0f, false, false, 0,
            2, 1, 1, "self", 3, 7, 1.0f, 1.0f,
            SoundType.METAL, 6.0F, 5.0F, 0.6F, false, false, true, true, false, true, false, 0, 1.0f, 1.0f,
            0xFF6AE8E0, 15, 5000, 4000, 10000, true, 0.0F, SoundType.MUD,
            0xFF4AC4B9, SoundType.SLIME_BLOCK, 0xFF6AE8E0, SoundType.SLIME_BLOCK,
            0xFFB9F2FF, SoundType.EMPTY
    );

    public static final OreDefinition EMERALD = new OreDefinition(
            "emerald", true, "self",
            Rarity.RARE, false, false, 0, 0.0f, false, false, 0,
            2, 1, 1, "self", 3, 7, 1.0f, 1.0f,
            SoundType.METAL, 6.0F, 5.0F, 0.6F, false, false, true, true, false, true, false, 0, 1.0f, 1.0f,
            0xFF00B039, 14, 4500, 2500, 9000, true, 0.0F, SoundType.MUD,
            0xFF008A2D, SoundType.SLIME_BLOCK, 0xFF00B039, SoundType.SLIME_BLOCK,
            0xFF7CFF9A, SoundType.EMPTY
    );

    public static final OreDefinition LAPIS = new OreDefinition(
            "lapis", true, "self",
            Rarity.COMMON, false, false, 0, 0.0f, false, false, 0,
            1, 4, 9, "self", 2, 5, 1.0f, 1.0f,
            SoundType.STONE, 3.0F, 3.0F, 0.6F, false, false, true, true, false, true, false, 0, 1.0f, 1.0f,
            0xFF1044AA, 8, 2000, 800, 4000, true, 0.0F, SoundType.MUD,
            0xFF0B2D6D, SoundType.SLIME_BLOCK, 0xFF1044AA, SoundType.SLIME_BLOCK,
            0xFF5E8AFF, SoundType.EMPTY
    );

    public static final OreDefinition REDSTONE = new OreDefinition(
            "redstone", true, "dust",
            Rarity.COMMON, false, false, 0, 0.0f, false, false, 0,
            2, 4, 5, "self", 1, 5, 1.0f, 1.0f,
            SoundType.STONE, 6.0F, 5.0F, 0.6F, false, false, true, true, false, true, true, 15, 1.0f, 1.0f,
            0xFFFF0000, 15, 1500, 660, 7000, true, 0.0F, SoundType.MUD,
            0xFF8B0000, SoundType.SLIME_BLOCK, 0xFFFF0000, SoundType.SLIME_BLOCK,
            0xFFFF5555, SoundType.EMPTY
    );

    public static final OreDefinition COAL = new OreDefinition(
            "coal", true, "self",
            Rarity.COMMON, false, false, 0, 0.0f, false, true, 1600,
            0, 1, 1, "self", 0, 2, 1.0f, 1.0f,
            SoundType.STONE, 6.0F, 5.0F, 0.6F, false, false, true, true, false, true, false, 0, 1.0f, 1.0f,
            0xFF363636, 2, 1350, 600, 3000, true, 0.0F, SoundType.MUD,
            0xFF202020, SoundType.SLIME_BLOCK, 0xFF404040, SoundType.SLIME_BLOCK,
            0xFF555555, SoundType.EMPTY
    );

    public static final OreDefinition COPPER = new OreDefinition(
            "copper", false, "ingot",
            Rarity.COMMON, false, false, 0, 0.0f, false, false, 0,
            1, 2, 5, "raw", 0, 0, 1.0f, 1.0f,
            SoundType.COPPER, 6.0F, 3.0F, 0.6F, false, false, true, true, false, true, true, 0, 1.0f, 1.0f,
            0xFFD96941, 10, 3500, 1358, 7000, true, 0.0F, SoundType.MUD,
            0xFF94482D, SoundType.SLIME_BLOCK, 0xFFD96941, SoundType.SLIME_BLOCK,
            0xFFE07C5A, SoundType.EMPTY
    );

    public static final OreDefinition NETHERITE = new OreDefinition(
            "netherite", false, "ingot",
            Rarity.EPIC, true, false, 0, 0.0f, false, false, 0,
            3, 1, 1, "self", 1, 2, 1.0f, 1.0f,
            SoundType.NETHERITE_BLOCK, 1200.0F, 50.0F, 0.6F, false, false, true, true, false, false, false, 0, 1.0f, 1.0f,
            0xFF4C414C, 15, 7000, 3200, 12000, true, 0.0F, SoundType.MUD,
            0xFF3B323B, SoundType.SLIME_BLOCK, 0xFF4C414C, SoundType.SLIME_BLOCK,
            0xFF6D5F6D, SoundType.EMPTY
    );

    public static final OreDefinition QUARTZ = new OreDefinition(
            "quartz", true, "self",
            Rarity.COMMON, false, false, 0, 0.0f, false, false, 0,
            0, 1, 1, "self", 2, 5, 1.0f, 1.0f,
            SoundType.STONE, 0.8F, 0.8F, 0.6F, false, false, true, true, false, true, false, 0, 1.0f, 1.0f,
            0xFFF7F4EC, 5, 2200, 1986, 8000, true, 0.0F, SoundType.MUD,
            0xFFCEC4B7, SoundType.SLIME_BLOCK, 0xFFF7F4EC, SoundType.SLIME_BLOCK,
            0xFFFFFFFF, SoundType.EMPTY
    );

    public static final OreDefinition EXEMPLE = new OreDefinition(
            "exemple", false, "ingot",
            Rarity.UNCOMMON, false, false, 0, 0.0f, false, false, 0,
            2, 1, 1, "raw", 2, 6, 1.1f, 1.1f,
            SoundType.AMETHYST, 7.0F, 4.0F, 0.6F, true, false, true, true, false, true, false, 0, 1.0f, 1.0f,
            0xFF8A2BE2, 10, 3200, 2000, 6500, true, 0.0F, SoundType.MUD,
            0xFF6A1F9C, SoundType.SLIME_BLOCK, 0xFF8A2BE2, SoundType.SLIME_BLOCK,
            0xFFC388FF, SoundType.EMPTY
    );
}