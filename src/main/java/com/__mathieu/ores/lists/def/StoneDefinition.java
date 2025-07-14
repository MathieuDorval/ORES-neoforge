package com.__mathieu.ores.lists.def;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;

public class StoneDefinition {
    private final String name;
    private final String blockId;
    private final String requiredTool;
    private final int toolLevel;
    private final float hardness;
    private final float resistance;
    private final MapColor mapColor;
    private final SoundType soundType;

    public StoneDefinition(String name, String blockId, String requiredTool, int toolLevel, float hardness, float resistance, MapColor mapColor, SoundType soundType) {
        this.name = name;
        this.blockId = blockId;
        this.requiredTool = requiredTool;
        this.toolLevel = toolLevel;
        this.hardness = hardness;
        this.resistance = resistance;
        this.mapColor = mapColor;
        this.soundType = soundType;
    }

    public String getName() {
        return name;
    }

    public String getBlockId() {
        return blockId;
    }

    public String getRequiredTool() {
        return requiredTool;
    }

    public int getToolLevel() {
        return toolLevel;
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }

    public MapColor getMapColor() {
        return mapColor;
    }

    public SoundType getSoundType() { // Nouveau getter
        return soundType;
    }

    @Override
    public String toString() {
        return "StoneDefinition{" +
                "name='" + name + '\'' +
                ", blockId='" + blockId + '\'' +
                ", requiredTool='" + requiredTool + '\'' +
                ", toolLevel=" + toolLevel +
                ", hardness=" + hardness +
                ", resistance=" + resistance +
                ", mapColor=" + mapColor +
                ", soundType=" + soundType +
                '}';
    }
}