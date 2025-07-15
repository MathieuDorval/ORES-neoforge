package com.__mathieu.ores.core.definitions;

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
    private final boolean requiresCorrectToolForDrops; // True if this stone requires the correct tool to drop items.
    private final float hardness;           // The mining hardness of this stone.
    private final float resistance;         // The blast resistance of this stone.

    // VISUAL & INTERACTION PROPERTIES
    private final MapColor mapColor;        // The map color of this stone.
    private final SoundType soundType;      // The sound type of this stone (e.g., when walked on, mined).
    private final float friction;           // The friction coefficient of this stone (0.6F for normal blocks, 0.98F for ice).
    private final boolean canEmitLight;     // True if this stone can emit light.
    private final boolean canSuffocate;     // True if this stone can suffocate entities.
    private final boolean isViewBlocking;   // True if this stone completely blocks vision.
    private final boolean isRandomlyTicking;// True if this stone receives random ticks (e.g., for growth, decay).
    private final boolean reactsToPistons;  // True if this stone reacts to pistons.
    private final float speedFactor;        // The speed factor of the block.
    private final float jumpFactor;         // The jump factor of the block.


    // CONSTRUCTOR
    public StoneDefinition(String name, String blockId, String requiredTool, int toolLevel, boolean requiresCorrectToolForDrops, float hardness, float resistance, MapColor mapColor, SoundType soundType,
                           float friction, boolean canEmitLight, boolean canSuffocate, boolean isViewBlocking, boolean isRandomlyTicking, boolean reactsToPistons,
                           float speedFactor, float jumpFactor) {
        this.name = name;
        this.blockId = blockId;
        this.requiredTool = requiredTool;
        this.toolLevel = toolLevel;
        this.requiresCorrectToolForDrops = requiresCorrectToolForDrops;
        this.hardness = hardness;
        this.resistance = resistance;
        this.mapColor = mapColor;
        this.soundType = soundType;
        this.friction = friction;
        this.canEmitLight = canEmitLight;
        this.canSuffocate = canSuffocate;
        this.isViewBlocking = isViewBlocking;
        this.isRandomlyTicking = isRandomlyTicking;
        this.reactsToPistons = reactsToPistons;
        this.speedFactor = speedFactor;
        this.jumpFactor = jumpFactor;
    }

    // GETTERS
    // General Stone Properties
    public String getName() { return name; }
    public String getBlockId() { return blockId; }

    // Mining Properties
    public String getRequiredTool() { return requiredTool; }
    public int getToolLevel() { return toolLevel; }
    public boolean requiresCorrectToolForDrops() { return requiresCorrectToolForDrops; }
    public float getHardness() { return hardness; }
    public float getResistance() { return resistance; }

    // Visual & Interaction Properties
    public MapColor getMapColor() { return mapColor; }
    public SoundType getSoundType() { return soundType; }
    public float getFriction() { return friction; }
    public boolean canEmitLight() { return canEmitLight; }
    public boolean canSuffocate() { return canSuffocate; }
    public boolean isViewBlocking() { return isViewBlocking; }
    public boolean isRandomlyTicking() { return isRandomlyTicking; }
    public boolean reactsToPistons() { return reactsToPistons; }
    public float getSpeedFactor() { return speedFactor; }
    public float getJumpFactor() { return jumpFactor; }


    @Override
    public String toString() {
        return "StoneDefinition{" +
                "name='" + name + '\'' +
                ", blockId='" + blockId + '\'' +
                ", requiredTool='" + requiredTool + '\'' +
                ", toolLevel=" + toolLevel +
                ", requiresCorrectToolForDrops=" + requiresCorrectToolForDrops +
                ", hardness=" + hardness +
                ", resistance=" + resistance +
                ", mapColor=" + mapColor +
                ", soundType=" + soundType +
                ", friction=" + friction +
                ", canEmitLight=" + canEmitLight +
                ", canSuffocate=" + canSuffocate +
                ", isViewBlocking=" + isViewBlocking +
                ", isRandomlyTicking=" + isRandomlyTicking +
                ", reactsToPistons=" + reactsToPistons +
                ", speedFactor=" + speedFactor +
                ", jumpFactor=" + jumpFactor +
                '}';
    }
}