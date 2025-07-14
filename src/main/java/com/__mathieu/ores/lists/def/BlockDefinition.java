// src/main/java/com/__mathieu/ores/lists/def/BlockDefinition.java
package com.__mathieu.ores.lists.def;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.PushReaction; // Importez PushReaction

public class BlockDefinition {
    // BLOC TYPE PROPERTIES
    private final String name;              // Name of this block type (e.g., "raw_block", "block", "compressed_block").
    private final String prefix;            // Prefix for the block ID (e.g., "raw_" for "raw_iron_block").
    private final String suffix;            // Suffix for the block ID (e.g., "block" for "iron_block").

    // MINING PROPERTIES (Base values for this block type)
    private final String requiredTool;      // Tool type required to mine this block (e.g., "pickaxe").
    private final int toolLevel;            // Min tool harvest level for this block.
    private final float hardness;           // Mining hardness for this block.
    private final float resistance;         // Blast resistance for this block.

    // VISUAL & INTERACTION PROPERTIES (Base values for this block type)
    private final MapColor mapColor;        // Map color for this block.
    private final SoundType soundType;      // Sound type for this block.
    private final float friction;           // Friction coefficient for this block.
    private final int lightEmission;        // Light level emitted by this block (0-15).
    private final boolean flammable;        // True if this block can catch fire.
    private final boolean canSuffocate;     // True if this block can suffocate entities.
    private final boolean isViewBlocking;   // True if this block fully blocks vision.
    private final boolean isRandomlyTicking;// True if this block receives random ticks.
    private final PushReaction pushReaction; // How this block reacts to pistons.
    private final boolean isOxidizable;     // True if this block type can oxidize.
    private final boolean canEmitRedstonePower; // True if this block type can emit redstone power.


    // CONSTRUCTOR
    public BlockDefinition(String name, String prefix, String suffix,
                           String requiredTool, int toolLevel, float hardness, float resistance,
                           MapColor mapColor, SoundType soundType, float friction, int lightEmission,
                           boolean flammable, boolean canSuffocate, boolean isViewBlocking, boolean isRandomlyTicking,
                           PushReaction pushReaction, boolean isOxidizable, boolean canEmitRedstonePower) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.requiredTool = requiredTool;
        this.toolLevel = toolLevel;
        this.hardness = hardness;
        this.resistance = resistance;
        this.mapColor = mapColor;
        this.soundType = soundType;
        this.friction = friction;
        this.lightEmission = lightEmission;
        this.flammable = flammable;
        this.canSuffocate = canSuffocate;
        this.isViewBlocking = isViewBlocking;
        this.isRandomlyTicking = isRandomlyTicking;
        this.pushReaction = pushReaction;
        this.isOxidizable = isOxidizable;
        this.canEmitRedstonePower = canEmitRedstonePower;
    }

    // GETTERS
    // Block Type Properties
    public String getName() { return name; }
    public String getPrefix() { return prefix; }
    public String getSuffix() { return suffix; }

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
    public boolean isFlammable() { return flammable; }
    public boolean canSuffocate() { return canSuffocate; }
    public boolean isViewBlocking() { return isViewBlocking; }
    public boolean isRandomlyTicking() { return isRandomlyTicking; }
    public PushReaction getPushReaction() { return pushReaction; }
    public boolean isOxidizable() { return isOxidizable; }
    public boolean canEmitRedstonePower() { return canEmitRedstonePower; }

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
                ", hardness=" + hardness +
                ", resistance=" + resistance +
                ", mapColor=" + mapColor +
                ", soundType=" + soundType +
                ", friction=" + friction +
                ", lightEmission=" + lightEmission +
                ", flammable=" + flammable +
                ", canSuffocate=" + canSuffocate +
                ", isViewBlocking=" + isViewBlocking +
                ", isRandomlyTicking=" + isRandomlyTicking +
                ", pushReaction=" + pushReaction +
                ", isOxidizable=" + isOxidizable +
                ", canEmitRedstonePower=" + canEmitRedstonePower +
                '}';
    }
}