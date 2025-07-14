// src/main/java/com/__mathieu/ores/lists/def/StoneDefinition.java
package com.__mathieu.ores.lists.def;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.PushReaction;

public class StoneDefinition {
    // GENERAL STONE PROPERTIES
    private final String name;              // The base name of the stone (e.g., "stone", "deepslate").
    private final String blockId;           // The registry ID of the vanilla/modded block this stone type is based on (e.g., "minecraft:stone").

    // MINING PROPERTIES
    private final String requiredTool;      // The tool type required to mine this stone (e.g., "pickaxe", "shovel").
    private final int toolLevel;            // The minimum tool harvest level required to break this stone (0=wood/gold, 1=stone, etc.).
    private final float hardness;           // The mining hardness of this stone.
    private final float resistance;         // The blast resistance of this stone.

    // VISUAL & INTERACTION PROPERTIES
    private final MapColor mapColor;        // The map color of this stone.
    private final SoundType soundType;      // The sound type of this stone (e.g., when walked on, mined).
    private final float friction;           // The friction coefficient of this stone (0.6F for normal blocks, 0.98F for ice).
    private final int lightEmission;        // The light level emitted by this stone (0-15).
    private final boolean canSuffocate;     // True if this stone can suffocate entities.
    private final boolean isViewBlocking;   // True if this stone completely blocks vision.
    private final boolean isRandomlyTicking;// True if this stone receives random ticks (e.g., for growth, decay).
    private final PushReaction pushReaction; // How this stone reacts to pistons (e.g., NORMAL, BLOCK, DESTROY).


    // CONSTRUCTOR
    public StoneDefinition(String name, String blockId, String requiredTool, int toolLevel, float hardness, float resistance, MapColor mapColor, SoundType soundType,
                           float friction, int lightEmission, boolean canSuffocate, boolean isViewBlocking, boolean isRandomlyTicking, PushReaction pushReaction) {
        this.name = name;
        this.blockId = blockId;
        this.requiredTool = requiredTool;
        this.toolLevel = toolLevel;
        this.hardness = hardness;
        this.resistance = resistance;
        this.mapColor = mapColor;
        this.soundType = soundType;
        this.friction = friction;
        this.lightEmission = lightEmission;
        this.canSuffocate = canSuffocate;
        this.isViewBlocking = isViewBlocking;
        this.isRandomlyTicking = isRandomlyTicking;
        this.pushReaction = pushReaction;
    }

    // GETTERS
    // General Stone Properties
    public String getName() { return name; }
    public String getBlockId() { return blockId; }

    // Mining Properties
    public String getRequiredTool() { return requiredTool; }
    public int getToolLevel() { return toolLevel; }
    public float getHardness() { return hardness; }
    public float getResistance() { return resistance; }

    // Visual & Interaction Properties
    public MapColor getMapColor() { return mapColor; }
    public SoundType getSoundType() { return soundType; }
    public float getFriction() { return friction; }
    public int getLightEmission() { return lightEmission; }
    public boolean canSuffocate() { return canSuffocate; }
    public boolean isViewBlocking() { return isViewBlocking; }
    public boolean isRandomlyTicking() { return isRandomlyTicking; }
    public PushReaction getPushReaction() { return pushReaction; }


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
                ", friction=" + friction +
                ", lightEmission=" + lightEmission +
                ", canSuffocate=" + canSuffocate +
                ", isViewBlocking=" + isViewBlocking +
                ", isRandomlyTicking=" + isRandomlyTicking +
                ", pushReaction=" + pushReaction +
                '}';
    }
}