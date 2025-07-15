package com.__mathieu.ores.core.definitions;

import net.minecraft.world.level.block.SoundType;

public class BlockDefinition {
    // BLOC TYPE PROPERTIES
    private final String name;              // Name of this block type (e.g., "raw_block", "block", "compressed_block").
    private final String prefix;            // Prefix for the block ID (e.g., "raw_" for "raw_iron_block").
    private final String suffix;            // Suffix for the block ID (e.g., "block" for "iron_block").

    // MINING PROPERTIES (Base values for this block type)
    private final String requiredTool;      // Tool type required to mine this block (e.g., "pickaxe").
    private final int toolLevel;            // Min tool harvest level for this block.
    private final boolean requiresCorrectToolForDrops; // True if this block requires the correct tool to drop items.
    private final float hardness;           // Mining hardness for this block.
    private final float resistance;         // Blast resistance for this block.

    // VISUAL & INTERACTION PROPERTIES (Base values for this block type)
    private final SoundType customSoundType; // Specific sound for this block type, if null uses the ore's default sound.
    private final float friction;           // Friction coefficient for this block.
    private final boolean canEmitLight;     // True if this block can emit light.
    private final boolean flammable;        // True if this block can catch fire.
    private final boolean canSuffocate;     // True if this block can suffocate entities.
    private final boolean isViewBlocking;   // True if this block fully blocks vision.
    private final boolean isRandomlyTicking;// True if this block receives random ticks.
    private final boolean reactsToPistons;  // True if this block reacts to pistons.
    private final boolean isOxidizable;     // True if this block type can oxidize.
    private final boolean canEmitRedstonePower; // True if this block type can emit redstone power.
    private final float speedFactor;        // The speed factor of the block.
    private final float jumpFactor;         // The jump factor of the block.


    // CONSTRUCTOR
    public BlockDefinition(String name, String prefix, String suffix,
                           String requiredTool, int toolLevel, boolean requiresCorrectToolForDrops, float hardness, float resistance,
                           SoundType customSoundType, float friction, boolean canEmitLight,
                           boolean flammable, boolean canSuffocate, boolean isViewBlocking, boolean isRandomlyTicking,
                           boolean reactsToPistons, boolean isOxidizable, boolean canEmitRedstonePower,
                           float speedFactor, float jumpFactor) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.requiredTool = requiredTool;
        this.toolLevel = toolLevel;
        this.requiresCorrectToolForDrops = requiresCorrectToolForDrops;
        this.hardness = hardness;
        this.resistance = resistance;
        this.customSoundType = customSoundType;
        this.friction = friction;
        this.canEmitLight = canEmitLight;
        this.flammable = flammable;
        this.canSuffocate = canSuffocate;
        this.isViewBlocking = isViewBlocking;
        this.isRandomlyTicking = isRandomlyTicking;
        this.reactsToPistons = reactsToPistons;
        this.isOxidizable = isOxidizable;
        this.canEmitRedstonePower = canEmitRedstonePower;
        this.speedFactor = speedFactor;
        this.jumpFactor = jumpFactor;
    }

    // GETTERS
    // Block Type Properties
    public String getName() { return name; }
    public String getPrefix() { return prefix; }
    public String getSuffix() { return suffix; }

    // Mining Properties
    public String getRequiredTool() { return requiredTool; }
    public int getToolLevel() { return toolLevel; }
    public boolean requiresCorrectToolForDrops() { return requiresCorrectToolForDrops; }
    public float getHardness() { return hardness; }
    public float getResistance() { return resistance; }

    // Visual & Interaction Properties
    public SoundType getCustomSoundType() { return customSoundType; }
    public float getFriction() { return friction; }
    public boolean canEmitLight() { return canEmitLight; }
    public boolean isFlammable() { return flammable; }
    public boolean canSuffocate() { return canSuffocate; }
    public boolean isViewBlocking() { return isViewBlocking; }
    public boolean isRandomlyTicking() { return isRandomlyTicking; }
    public boolean reactsToPistons() { return reactsToPistons; }
    public boolean isOxidizable() { return isOxidizable; }
    public boolean canEmitRedstonePower() { return canEmitRedstonePower; }
    public float getSpeedFactor() { return speedFactor; }
    public float getJumpFactor() { return jumpFactor; }

    public String getFullName(String materialName) {
        StringBuilder fullName = new StringBuilder();
        if (!prefix.isEmpty()) {
            fullName.append(prefix).append("_");
        }
        fullName.append(materialName);
        if (!suffix.isEmpty()) {
            fullName.append("_").append(suffix);
        }
        return fullName.toString();
    }

    @Override
    public String toString() {
        return "BlockDefinition{" +
                "name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", requiredTool='" + requiredTool + '\'' +
                ", toolLevel=" + toolLevel +
                ", requiresCorrectToolForDrops=" + requiresCorrectToolForDrops +
                ", hardness=" + hardness +
                ", resistance=" + resistance +
                ", customSoundType=" + customSoundType +
                ", friction=" + friction +
                ", canEmitLight=" + canEmitLight +
                ", flammable=" + flammable +
                ", canSuffocate=" + canSuffocate +
                ", isViewBlocking=" + isViewBlocking +
                ", isRandomlyTicking=" + isRandomlyTicking +
                ", reactsToPistons=" + reactsToPistons +
                ", isOxidizable=" + isOxidizable +
                ", canEmitRedstonePower=" + canEmitRedstonePower +
                ", speedFactor=" + speedFactor +
                ", jumpFactor=" + jumpFactor +
                '}';
    }
}