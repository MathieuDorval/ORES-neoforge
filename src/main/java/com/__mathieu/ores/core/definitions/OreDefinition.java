package com.__mathieu.ores.core.definitions;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.PushReaction;

public class OreDefinition {
    // GENERAL PROPERTIES
    private final String name;              // The base name of the ore (e.g., "iron", "diamond").
    private final boolean selfExist;        // True if the ore has a "self" item form (e.g., coal, diamond), false if it's processed (e.g., iron -> iron_ingot).
    private final String baseForm;          // The primary processed form of the material (e.g., "ingot", "dust", "self" for pure items).

    // ITEM PROPERTIES
    private final Rarity rarity;            // The base rarity of items derived from this ore (e.g., Rarity.COMMON, Rarity.UNCOMMON).
    private final boolean isFireResistant;  // True if items derived from this ore should be fire resistant.

    // ORE BLOCK MINING PROPERTIES (for the ore block, e.g., "stone_iron_ore")
    private final int toolLevel;            // The minimum tool harvest level required to break the ore block (0=wood/gold, 1=stone, 2=iron, 3=diamond, 4=netherite).
    private final int minDrops;             // The minimum number of items dropped when mining the ore block.
    private final int maxDrops;             // The maximum number of items dropped when mining the ore block.
    private final String dropItemForm;      // The item type dropped directly from the ore block (e.g., "raw", "self", "dust").
    private final int xpMin;                // The minimum amount of experience dropped when mining the ore.
    private final int xpMax;                // The maximum amount of experience dropped when mining the ore.
    private final float hardnessMultiplier; // Factor to multiply by the base stone's hardness (e.g., 1.0f for same hardness).
    private final float resistanceMultiplier; // Factor to multiply by the base stone's resistance (e.g., 1.0f for same resistance).


    // MATERIAL BLOCK PROPERTIES (for crafted blocks like "iron_block", "raw_iron_block")
    private final MapColor mapColor;        // The map color of blocks made from this material.
    private final SoundType soundType;      // The sound type of blocks made from this material.
    private final float resistance;         // The blast resistance of blocks made from this material.
    private final float hardness;           // The mining hardness of blocks made from this material.
    private final float friction;           // The friction coefficient of blocks made from this material (0.6F for normal blocks, 0.98F for ice).
    private final int lightEmission;        // The light level emitted by blocks made from this material (0-15).
    private final boolean flammable;        // True if blocks made from this material can catch fire and burn.
    private final boolean canSuffocate;     // True if blocks made from this material can suffocate entities.
    private final boolean isViewBlocking;   // True if blocks made from this material fully block vision.
    private final boolean isRandomlyTicking;// True if blocks made from this material receive random ticks (e.g., for growth, decay).
    private final PushReaction pushReaction;// How blocks made from this material react to pistons (e.g., NORMAL, BLOCK, DESTROY).
    private final boolean isOxidizable;     // True if blocks made from this material can oxidize (like copper).
    private final boolean canEmitRedstonePower; // True if blocks made from this material can emit redstone power.

    // MOLTEN FLUID PROPERTIES
    private final int moltenFluidColor;                 // ARGB color of the molten fluid.
    private final int moltenFluidLuminosity;            // Light emitted by the molten fluid (0-15).
    private final int moltenFluidDensity;               // Density of the molten fluid (e.g., 1000 for water, >1000 for sinking).
    private final int moltenFluidTemperature;           // Temperature of the molten fluid in Kelvin (e.g., 300 for water).
    private final int moltenFluidViscosity;             // Viscosity of the molten fluid (flow speed).
    private final boolean moltenFluidCanDrown;          // True if entities can drown in the molten fluid.
    private final float moltenFluidFallDamageModifier;  // Fall damage modifier for the molten fluid (0.0F for no damage).
    private final MapColor moltenFluidMapColor;         // Map color of the molten fluid.
    private final SoundType moltenFluidSoundType;       // Sound type of the molten fluid.

    // SLURRY FLUID PROPERTIES (Mekanism-like)
    private final int dirtySlurryColor;                 // ARGB color of the dirty slurry.
    private final MapColor dirtySlurryMapColor;         // Map color of the dirty slurry.
    private final SoundType dirtySlurrySoundType;       // Sound type of the dirty slurry.
    private final int cleanSlurryColor;                 // ARGB color of the clean slurry.
    private final MapColor cleanSlurryMapColor;         // Map color of the clean slurry.
    private final SoundType cleanSlurrySoundType;       // Sound type of the clean slurry.

    // GAS FLUID PROPERTIES (Mekanism-like)
    private final int gasColor;                         // ARGB color of the gas.
    private final MapColor gasMapColor;                 // Map color of the gas.
    private final SoundType gasSoundType;               // Sound type of the gas.


    // CONSTRUCTOR
    public OreDefinition(String name, boolean selfExist, String baseForm, Rarity rarity, boolean isFireResistant,
                         int toolLevel, int minDrops, int maxDrops, String dropItemForm, int xpMin, int xpMax, float hardnessMultiplier, float resistanceMultiplier,
                         MapColor mapColor, SoundType soundType, float resistance, float hardness,
                         float friction, int lightEmission, boolean flammable,
                         boolean canSuffocate, boolean isViewBlocking, boolean isRandomlyTicking, PushReaction pushReaction,
                         boolean isOxidizable, boolean canEmitRedstonePower,
                         // Molten Fluid properties
                         int moltenFluidColor, int moltenFluidLuminosity, int moltenFluidDensity, int moltenFluidTemperature,
                         int moltenFluidViscosity, boolean moltenFluidCanDrown, float moltenFluidFallDamageModifier,
                         MapColor moltenFluidMapColor, SoundType moltenFluidSoundType,
                         // Slurry properties
                         int dirtySlurryColor, MapColor dirtySlurryMapColor, SoundType dirtySlurrySoundType,
                         int cleanSlurryColor, MapColor cleanSlurryMapColor, SoundType cleanSlurrySoundType,
                         // Gas properties
                         int gasColor, MapColor gasMapColor, SoundType gasSoundType) {
        // GENERAL
        this.name = name;
        this.selfExist = selfExist;
        this.baseForm = baseForm;

        // ITEMS
        this.rarity = rarity;
        this.isFireResistant = isFireResistant;

        // ORES
        this.toolLevel = toolLevel;
        this.minDrops = minDrops;
        this.maxDrops = maxDrops;
        this.dropItemForm = dropItemForm;
        this.xpMin = xpMin;
        this.xpMax = xpMax;
        this.hardnessMultiplier = hardnessMultiplier;
        this.resistanceMultiplier = resistanceMultiplier;


        // BLOCKS
        this.mapColor = mapColor;
        this.soundType = soundType;
        this.resistance = resistance;
        this.hardness = hardness;
        this.friction = friction;
        this.lightEmission = lightEmission;
        this.flammable = flammable;
        this.canSuffocate = canSuffocate;
        this.isViewBlocking = isViewBlocking;
        this.isRandomlyTicking = isRandomlyTicking;
        this.pushReaction = pushReaction;
        this.isOxidizable = isOxidizable;
        this.canEmitRedstonePower = canEmitRedstonePower;

        // FLUIDS
        this.moltenFluidColor = moltenFluidColor;
        this.moltenFluidLuminosity = moltenFluidLuminosity;
        this.moltenFluidDensity = moltenFluidDensity;
        this.moltenFluidTemperature = moltenFluidTemperature;
        this.moltenFluidViscosity = moltenFluidViscosity;
        this.moltenFluidCanDrown = moltenFluidCanDrown;
        this.moltenFluidFallDamageModifier = moltenFluidFallDamageModifier;
        this.moltenFluidMapColor = moltenFluidMapColor;
        this.moltenFluidSoundType = moltenFluidSoundType;

        // SLURRIES
        this.dirtySlurryColor = dirtySlurryColor;
        this.dirtySlurryMapColor = dirtySlurryMapColor;
        this.dirtySlurrySoundType = dirtySlurrySoundType;
        this.cleanSlurryColor = cleanSlurryColor;
        this.cleanSlurryMapColor = cleanSlurryMapColor;
        this.cleanSlurrySoundType = cleanSlurrySoundType;

        // GAS
        this.gasColor = gasColor;
        this.gasMapColor = gasMapColor;
        this.gasSoundType = gasSoundType;
    }

    // GETTERS
    // General Properties
    public String getName() { return name; }
    public boolean selfExist() { return selfExist; }
    public String getBaseForm() { return baseForm; }

    // Item Properties
    public Rarity getRarity() { return rarity; }
    public boolean isFireResistant() { return isFireResistant; }

    // Ore Properties
    public int getToolLevel() { return toolLevel; }
    public int getMinDrops() { return minDrops; }
    public int getMaxDrops() { return maxDrops; }
    public String getDropItemForm() { return dropItemForm; }
    public int getXpMin() { return xpMin; }
    public int getXpMax() { return xpMax; }
    public float getHardnessMultiplier() { return hardnessMultiplier; }
    public float getResistanceMultiplier() { return resistanceMultiplier; }


    // Block Properties
    public MapColor getMapColor() { return mapColor; }
    public SoundType getSoundType() { return soundType; }
    public float getResistance() { return resistance; }
    public float getHardness() { return hardness; }
    public float getFriction() { return friction; }
    public int getLightEmission() { return lightEmission; }
    public boolean isFlammable() { return flammable; }
    public boolean canSuffocate() { return canSuffocate; }
    public boolean isViewBlocking() { return isViewBlocking; }
    public boolean isRandomlyTicking() { return isRandomlyTicking; }
    public PushReaction getPushReaction() { return pushReaction; }
    public boolean isOxidizable() { return isOxidizable; }
    public boolean canEmitRedstonePower() { return canEmitRedstonePower; }

    // Molten Fluid Properties
    public int getMoltenFluidColor() { return moltenFluidColor; }
    public int getMoltenFluidLuminosity() { return moltenFluidLuminosity; }
    public int getMoltenFluidDensity() { return moltenFluidDensity; }
    public int getMoltenFluidTemperature() { return moltenFluidTemperature; }
    public int getMoltenFluidViscosity() { return moltenFluidViscosity; }
    public boolean canMoltenFluidDrown() { return moltenFluidCanDrown; }
    public float getMoltenFluidFallDamageModifier() { return moltenFluidFallDamageModifier; }
    public MapColor getMoltenFluidMapColor() { return moltenFluidMapColor; }
    public SoundType getMoltenFluidSoundType() { return moltenFluidSoundType; }

    // Slurry Properties
    public int getDirtySlurryColor() { return dirtySlurryColor; }
    public MapColor getDirtySlurryMapColor() { return dirtySlurryMapColor; }
    public SoundType getDirtySlurrySoundType() { return dirtySlurrySoundType; }
    public int getCleanSlurryColor() { return cleanSlurryColor; }
    public MapColor getCleanSlurryMapColor() { return cleanSlurryMapColor; }
    public SoundType getCleanSlurrySoundType() { return cleanSlurrySoundType; }

    // Gas Properties
    public int getGasColor() { return gasColor; }
    public MapColor getGasMapColor() { return gasMapColor; }
    public SoundType getGasSoundType() { return gasSoundType; }


    @Override
    public String toString() {
        return "OreDefinition{" +
                "name='" + name + '\'' +
                ", selfExist=" + selfExist +
                ", baseForm='" + baseForm + '\'' +
                ", rarity=" + rarity +
                ", isFireResistant=" + isFireResistant +
                ", toolLevel=" + toolLevel +
                ", minDrops=" + minDrops +
                ", maxDrops=" + maxDrops +
                ", dropItemForm='" + dropItemForm + '\'' +
                ", xpMin=" + xpMin +
                ", xpMax=" + xpMax +
                ", hardnessMultiplier=" + hardnessMultiplier +
                ", resistanceMultiplier=" + resistanceMultiplier +
                ", mapColor=" + mapColor +
                ", soundType=" + soundType +
                ", resistance=" + resistance +
                ", hardness=" + hardness +
                ", friction=" + friction +
                ", lightEmission=" + lightEmission +
                ", flammable=" + flammable +
                ", canSuffocate=" + canSuffocate +
                ", isViewBlocking=" + isViewBlocking +
                ", isRandomlyTicking=" + isRandomlyTicking +
                ", pushReaction=" + pushReaction +
                ", isOxidizable=" + isOxidizable +
                ", canEmitRedstonePower=" + canEmitRedstonePower +
                ", moltenFluidColor=" + moltenFluidColor +
                ", moltenFluidLuminosity=" + moltenFluidLuminosity +
                ", moltenFluidDensity=" + moltenFluidDensity +
                ", moltenFluidTemperature=" + moltenFluidTemperature +
                ", moltenFluidViscosity=" + moltenFluidViscosity +
                ", moltenFluidCanDrown=" + moltenFluidCanDrown +
                ", moltenFluidFallDamageModifier=" + moltenFluidFallDamageModifier +
                ", moltenFluidMapColor=" + moltenFluidMapColor +
                ", moltenFluidSoundType=" + moltenFluidSoundType +
                ", dirtySlurryColor=" + dirtySlurryColor +
                ", dirtySlurryMapColor=" + dirtySlurryMapColor +
                ", dirtySlurrySoundType=" + dirtySlurrySoundType +
                ", cleanSlurryColor=" + cleanSlurryColor +
                ", cleanSlurryMapColor=" + cleanSlurryMapColor +
                ", cleanSlurrySoundType=" + cleanSlurrySoundType +
                ", gasColor=" + gasColor +
                ", gasMapColor=" + gasMapColor +
                ", gasSoundType=" + gasSoundType +
                '}';
    }
}