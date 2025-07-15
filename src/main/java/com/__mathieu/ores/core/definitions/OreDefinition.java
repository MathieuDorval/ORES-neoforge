package com.__mathieu.ores.core.definitions;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.SoundType;

public class OreDefinition {
    // GENERAL PROPERTIES
    private final String name;              // The base name of the ore (e.g., "iron", "diamond").
    private final boolean selfExist;        // True if the ore has a "self" item form (e.g., coal, diamond), false if it's processed (e.g., iron -> iron_ingot).
    private final String baseForm;          // The primary processed form of the material (e.g., "ingot", "dust", "self" for pure items).

    // ITEM PROPERTIES
    private final Rarity rarity;            // The base rarity of items derived from this ore (e.g., Rarity.COMMON, Rarity.UNCOMMON).
    private final boolean isFireResistant;  // True if items derived from this ore should be fire resistant.
    private final boolean isEdible;         // Base value for whether the ore item is edible.
    private final int nutrition;            // Base value for food nutrition.
    private final float saturationModifier; // Base value for food saturation.
    private final boolean foodAlwaysEdible; // Base value for whether the food is always edible.
    private final boolean isFuel;           // Base value for whether the ore item is fuel.
    private final int burnTime;             // Base value for the burn time.


    // ORE BLOCK MINING PROPERTIES (for the ore block, e.g., "stone_iron_ore")
    private final int toolLevel;            // The minimum tool harvest level required to break the ore block (0=wood/gold, 1=stone, 2=iron, 3=diamond, 4=netherite).
    private final int minDrops;             // The minimum number of items dropped when mining the ore block.
    private final int maxDrops;             // The maximum number of items dropped when mining the ore block.
    private final String dropItemForm;      // The item type dropped directly from the ore block (e.g., "raw", "self", "dust").
    private final int xpMin;                // The minimum amount of experience dropped when mining the ore.
    private final int xpMax;                // The maximum amount of experience dropped when mining the ore.
    private final float oreHardnessMultiplier; // Factor to multiply by the base stone's hardness (e.g., 1.0f for same hardness).
    private final float oreResistanceMultiplier; // Factor to multiply by the base stone's resistance (e.g., 1.0f for same resistance).


    // MATERIAL BLOCK PROPERTIES (for crafted blocks like "iron_block", "raw_iron_block")
    private final SoundType soundType;      // The sound type of blocks made from this material.
    private final float blockResistanceMultiplier;         // The blast resistance of blocks made from this material.
    private final float blockHardnessMultiplier;           // The mining hardness of blocks made from this material.
    private final float friction;           // The friction coefficient of blocks made from this material (0.6F for normal blocks, 0.98F for ice).
    private final boolean canEmitLight;        // The light level emitted by blocks made from this material (0-15).
    private final boolean flammable;        // True if blocks made from this material can catch fire and burn.
    private final boolean canSuffocate;     // True if blocks made from this material can suffocate entities.
    private final boolean isViewBlocking;   // True if blocks made from this material fully block vision.
    private final boolean isRandomlyTicking;// True if blocks made from this material receive random ticks (e.g., for growth, decay).
    private final boolean reactsToPistons;// How blocks made from this material react to pistons (e.g., NORMAL, BLOCK, DESTROY).
    private final boolean isOxidizable;     // True if blocks made from this material can oxidize (like copper).
    private final int redstoneSignalStrength; // The strength of the redstone signal emitted by this material's blocks (0-15).
    private final float speedFactorMultiplier;        // The speed factor of the block.
    private final float jumpFactorMultiplier;         // The jump factor of the block.

    // MOLTEN FLUID PROPERTIES
    private final int moltenFluidColor;                 // ARGB color of the molten fluid.
    private final int moltenFluidLuminosity;            // Light emitted by the molten fluid (0-15).
    private final int moltenFluidDensity;               // Density of the molten fluid (e.g., 1000 for water, >1000 for sinking).
    private final int moltenFluidTemperature;           // Temperature of the molten fluid in Kelvin (e.g., 300 for water).
    private final int moltenFluidViscosity;             // Viscosity of the molten fluid (flow speed).
    private final boolean moltenFluidCanDrown;          // True if entities can drown in the molten fluid.
    private final float moltenFluidFallDamageModifier;  // Fall damage modifier for the molten fluid (0.0F for no damage).
    private final SoundType moltenFluidSoundType;       // Sound type of the molten fluid.

    // SLURRY FLUID PROPERTIES (Mekanism-like)
    private final int dirtySlurryColor;                 // ARGB color of the dirty slurry.
    private final SoundType dirtySlurrySoundType;       // Sound type of the dirty slurry.
    private final int cleanSlurryColor;                 // ARGB color of the clean slurry.
    private final SoundType cleanSlurrySoundType;       // Sound type of the clean slurry.

    // GAS FLUID PROPERTIES (Mekanism-like)
    private final int gasColor;                         // ARGB color of the gas.
    private final SoundType gasSoundType;               // Sound type of the gas.


    // CONSTRUCTOR
    public OreDefinition(String name, boolean selfExist, String baseForm, Rarity rarity, boolean isFireResistant,
                         boolean isEdible, int nutrition, float saturationModifier, boolean foodAlwaysEdible, boolean isFuel, int burnTime,
                         int toolLevel, int minDrops, int maxDrops, String dropItemForm, int xpMin, int xpMax, float oreHardnessMultiplier, float oreResistanceMultiplier,
                         SoundType soundType, float blockResistanceMultiplier, float blockHardnessMultiplier,
                         float friction, boolean canEmitLight, boolean flammable,
                         boolean canSuffocate, boolean isViewBlocking, boolean isRandomlyTicking, boolean reactsToPistons,
                         boolean isOxidizable, int redstoneSignalStrength, float speedFactorMultiplier, float jumpFactorMultiplier,
                         // Molten Fluid properties
                         int moltenFluidColor, int moltenFluidLuminosity, int moltenFluidDensity, int moltenFluidTemperature,
                         int moltenFluidViscosity, boolean moltenFluidCanDrown, float moltenFluidFallDamageModifier,
                         SoundType moltenFluidSoundType,
                         // Slurry properties
                         int dirtySlurryColor, SoundType dirtySlurrySoundType,
                         int cleanSlurryColor, SoundType cleanSlurrySoundType,
                         // Gas properties
                         int gasColor, SoundType gasSoundType) {
        // GENERAL
        this.name = name;
        this.selfExist = selfExist;
        this.baseForm = baseForm;

        // ITEMS
        this.rarity = rarity;
        this.isFireResistant = isFireResistant;
        this.isEdible = isEdible;
        this.nutrition = nutrition;
        this.saturationModifier = saturationModifier;
        this.foodAlwaysEdible = foodAlwaysEdible;
        this.isFuel = isFuel;
        this.burnTime = burnTime;


        // ORES
        this.toolLevel = toolLevel;
        this.minDrops = minDrops;
        this.maxDrops = maxDrops;
        this.dropItemForm = dropItemForm;
        this.xpMin = xpMin;
        this.xpMax = xpMax;
        this.oreHardnessMultiplier = oreHardnessMultiplier;
        this.oreResistanceMultiplier = oreResistanceMultiplier;


        // BLOCKS
        this.soundType = soundType;
        this.blockResistanceMultiplier = blockResistanceMultiplier;
        this.blockHardnessMultiplier = blockHardnessMultiplier;
        this.friction = friction;
        this.canEmitLight = canEmitLight;
        this.flammable = flammable;
        this.canSuffocate = canSuffocate;
        this.isViewBlocking = isViewBlocking;
        this.isRandomlyTicking = isRandomlyTicking;
        this.reactsToPistons = reactsToPistons;
        this.isOxidizable = isOxidizable;
        this.redstoneSignalStrength = redstoneSignalStrength;
        this.speedFactorMultiplier = speedFactorMultiplier;
        this.jumpFactorMultiplier = jumpFactorMultiplier;


        // FLUIDS
        this.moltenFluidColor = moltenFluidColor;
        this.moltenFluidLuminosity = moltenFluidLuminosity;
        this.moltenFluidDensity = moltenFluidDensity;
        this.moltenFluidTemperature = moltenFluidTemperature;
        this.moltenFluidViscosity = moltenFluidViscosity;
        this.moltenFluidCanDrown = moltenFluidCanDrown;
        this.moltenFluidFallDamageModifier = moltenFluidFallDamageModifier;
        this.moltenFluidSoundType = moltenFluidSoundType;

        // SLURRIES
        this.dirtySlurryColor = dirtySlurryColor;
        this.dirtySlurrySoundType = dirtySlurrySoundType;
        this.cleanSlurryColor = cleanSlurryColor;
        this.cleanSlurrySoundType = cleanSlurrySoundType;

        // GAS
        this.gasColor = gasColor;
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
    public boolean isEdible() { return isEdible; }
    public int getNutrition() { return nutrition; }
    public float getSaturationModifier() { return saturationModifier; }
    public boolean isFoodAlwaysEdible() { return foodAlwaysEdible; }
    public boolean isFuel() { return isFuel; }
    public int getBurnTime() { return burnTime; }


    // Ore Properties
    public int getToolLevel() { return toolLevel; }
    public int getMinDrops() { return minDrops; }
    public int getMaxDrops() { return maxDrops; }
    public String getDropItemForm() { return dropItemForm; }
    public int getXpMin() { return xpMin; }
    public int getXpMax() { return xpMax; }
    public float getOreHardnessMultiplier() { return oreHardnessMultiplier; }
    public float getOreResistanceMultiplier() { return oreResistanceMultiplier; }


    // Block Properties
    public SoundType getSoundType() { return soundType; }
    public float getBlockResistanceMultiplier() { return blockResistanceMultiplier; }
    public float getBlockHardnessMultiplier() { return blockHardnessMultiplier; }
    public float getFriction() { return friction; }
    public boolean canEmitLight() { return canEmitLight; }
    public boolean isFlammable() { return flammable; }
    public boolean canSuffocate() { return canSuffocate; }
    public boolean isViewBlocking() { return isViewBlocking; }
    public boolean isRandomlyTicking() { return isRandomlyTicking; }
    public boolean reactsToPistons() { return reactsToPistons; }
    public boolean isOxidizable() { return isOxidizable; }
    public int getRedstoneSignalStrength() { return redstoneSignalStrength; }
    public float getSpeedFactorMultiplier() { return speedFactorMultiplier; }
    public float getJumpFactorMultiplier() { return jumpFactorMultiplier; }


    // Molten Fluid Properties
    public int getMoltenFluidColor() { return moltenFluidColor; }
    public int getMoltenFluidLuminosity() { return moltenFluidLuminosity; }
    public int getMoltenFluidDensity() { return moltenFluidDensity; }
    public int getMoltenFluidTemperature() { return moltenFluidTemperature; }
    public int getMoltenFluidViscosity() { return moltenFluidViscosity; }
    public boolean canMoltenFluidDrown() { return moltenFluidCanDrown; }
    public float getMoltenFluidFallDamageModifier() { return moltenFluidFallDamageModifier; }
    public SoundType getMoltenFluidSoundType() { return moltenFluidSoundType; }

    // Slurry Properties
    public int getDirtySlurryColor() { return dirtySlurryColor; }
    public SoundType getDirtySlurrySoundType() { return dirtySlurrySoundType; }
    public int getCleanSlurryColor() { return cleanSlurryColor; }
    public SoundType getCleanSlurrySoundType() { return cleanSlurrySoundType; }

    // Gas Properties
    public int getGasColor() { return gasColor; }
    public SoundType getGasSoundType() { return gasSoundType; }


    @Override
    public String toString() {
        return "OreDefinition{" +
                "name='" + name + '\'' +
                ", selfExist=" + selfExist +
                ", baseForm='" + baseForm + '\'' +
                ", rarity=" + rarity +
                ", isFireResistant=" + isFireResistant +
                ", isEdible=" + isEdible +
                ", nutrition=" + nutrition +
                ", saturationModifier=" + saturationModifier +
                ", foodAlwaysEdible=" + foodAlwaysEdible +
                ", isFuel=" + isFuel +
                ", burnTime=" + burnTime +
                ", toolLevel=" + toolLevel +
                ", minDrops=" + minDrops +
                ", maxDrops=" + maxDrops +
                ", dropItemForm='" + dropItemForm + '\'' +
                ", xpMin=" + xpMin +
                ", xpMax=" + xpMax +
                ", oreHardnessMultiplier=" + oreHardnessMultiplier +
                ", oreResistanceMultiplier=" + oreResistanceMultiplier +
                ", soundType=" + soundType +
                ", blockResistanceMultiplier=" + blockResistanceMultiplier +
                ", blockHardnessMultiplier=" + blockHardnessMultiplier +
                ", friction=" + friction +
                ", canEmitLight=" + canEmitLight +
                ", flammable=" + flammable +
                ", canSuffocate=" + canSuffocate +
                ", isViewBlocking=" + isViewBlocking +
                ", isRandomlyTicking=" + isRandomlyTicking +
                ", reactsToPistons=" + reactsToPistons +
                ", isOxidizable=" + isOxidizable +
                ", redstoneSignalStrength=" + redstoneSignalStrength +
                ", speedFactorMultiplier=" + speedFactorMultiplier +
                ", jumpFactorMultiplier=" + jumpFactorMultiplier +
                ", moltenFluidColor=" + moltenFluidColor +
                ", moltenFluidLuminosity=" + moltenFluidLuminosity +
                ", moltenFluidDensity=" + moltenFluidDensity +
                ", moltenFluidTemperature=" + moltenFluidTemperature +
                ", moltenFluidViscosity=" + moltenFluidViscosity +
                ", moltenFluidCanDrown=" + moltenFluidCanDrown +
                ", moltenFluidFallDamageModifier=" + moltenFluidFallDamageModifier +
                ", moltenFluidSoundType=" + moltenFluidSoundType +
                ", dirtySlurryColor=" + dirtySlurryColor +
                ", dirtySlurrySoundType=" + dirtySlurrySoundType +
                ", cleanSlurryColor=" + cleanSlurryColor +
                ", cleanSlurrySoundType=" + cleanSlurrySoundType +
                ", gasColor=" + gasColor +
                ", gasSoundType=" + gasSoundType +
                '}';
    }
}