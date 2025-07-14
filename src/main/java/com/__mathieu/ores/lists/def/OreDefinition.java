// src/main/java/com/__mathieu/ores/lists/def/OreDefinition.java
package com.__mathieu.ores.lists.def;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;

public class OreDefinition {
    private final String name;
    private final int toolLevel;
    private final Rarity rarity;
    private final boolean selfExist;
    private final String baseForm;

    private final int minDrops;
    private final int maxDrops;
    private final String dropItemForm;
    private final boolean isFireResistant;

    private final MapColor mapColor;
    private final SoundType soundType;
    private final float resistance;
    private final float hardness;

    private final float friction;
    private final int lightEmission;
    private final boolean flammable;


    public OreDefinition(String name, int toolLevel, Rarity rarity, boolean selfExist, String baseForm,
                         int minDrops, int maxDrops, String dropItemForm, boolean isFireResistant,
                         MapColor mapColor, SoundType soundType, float resistance, float hardness,
                         float friction, int lightEmission, boolean flammable) { // Nouveaux paramètres dans le constructeur
        this.name = name;
        this.toolLevel = toolLevel;
        this.rarity = rarity;
        this.selfExist = selfExist;
        this.baseForm = baseForm;
        this.minDrops = minDrops;
        this.maxDrops = maxDrops;
        this.dropItemForm = dropItemForm;
        this.isFireResistant = isFireResistant;
        this.mapColor = mapColor;
        this.soundType = soundType;
        this.resistance = resistance;
        this.hardness = hardness;
        this.friction = friction;
        this.lightEmission = lightEmission;
        this.flammable = flammable;
    }

    public String getName() {
        return name;
    }

    public int getToolLevel() {
        return toolLevel;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public boolean selfExist() {
        return selfExist;
    }

    public String getBaseForm() {
        return baseForm;
    }

    public int getMinDrops() {
        return minDrops;
    }

    public int getMaxDrops() {
        return maxDrops;
    }

    public String getDropItemForm() {
        return dropItemForm;
    }

    public boolean isFireResistant() {
        return isFireResistant;
    }

    public MapColor getMapColor() {
        return mapColor;
    }

    public SoundType getSoundType() {
        return soundType;
    }

    public float getResistance() {
        return resistance;
    }

    public float getHardness() {
        return hardness;
    }

    public float getFriction() {
        return friction;
    }

    public int getLightEmission() {
        return lightEmission;
    }

    public boolean isFlammable() {
        return flammable;
    }

    @Override
    public String toString() {
        return "OreDefinition{" +
                "name='" + name + '\'' +
                ", toolLevel=" + toolLevel +
                ", rarity=" + rarity +
                ", selfExist=" + selfExist +
                ", baseForm='" + baseForm + '\'' +
                ", minDrops=" + minDrops +
                ", maxDrops=" + maxDrops +
                ", dropItemForm='" + dropItemForm + '\'' +
                ", isFireResistant=" + isFireResistant +
                ", mapColor=" + mapColor +
                ", soundType=" + soundType +
                ", resistance=" + resistance +
                ", hardness=" + hardness +
                ", friction=" + friction +
                ", lightEmission=" + lightEmission +
                ", flammable=" + flammable +
                '}';
    }
}