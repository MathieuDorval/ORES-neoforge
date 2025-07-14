// src/main/java/com/__mathieu/ores/lists/def/OreDefinition.java
package com.__mathieu.ores.lists.def;

import net.minecraft.world.item.Rarity; // Importez la classe Rarity de Minecraft

public class OreDefinition {
    private final String name;
    private final int toolLevel;
    private final Rarity rarity; // Changé de 'int' à 'Rarity'
    private final boolean requiresSmelting;
    private final String baseForm; // Le type d'item de base *après traitement* (ex: "gem", "ingot", "dust")

    private final int minDrops; // Nombre minimum d'items lâchés lors du minage
    private final int maxDrops; // Nombre maximum d'items lâchés lors du minage
    private final String dropItemForm; // La forme de l'item lâché directement lors du minage (ex: "raw", "gem", "dust")
    private final boolean isFireResistant; // Nouveau paramètre : résistance au feu

    public OreDefinition(String name, int toolLevel, Rarity rarity, boolean requiresSmelting, String baseForm,
                         int minDrops, int maxDrops, String dropItemForm, boolean isFireResistant) {
        this.name = name;
        this.toolLevel = toolLevel;
        this.rarity = rarity;
        this.requiresSmelting = requiresSmelting;
        this.baseForm = baseForm;
        this.minDrops = minDrops;
        this.maxDrops = maxDrops;
        this.dropItemForm = dropItemForm;
        this.isFireResistant = isFireResistant; // Initialisation du nouveau paramètre
    }

    public String getName() {
        return name;
    }

    public int getToolLevel() {
        return toolLevel;
    }

    public Rarity getRarity() { // Le getter retourne maintenant un objet Rarity
        return rarity;
    }

    public boolean requiresSmelting() {
        return requiresSmelting;
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

    public boolean isFireResistant() { // Nouveau getter pour isFireResistant
        return isFireResistant;
    }

    @Override
    public String toString() {
        return "OreDefinition{" +
                "name='" + name + '\'' +
                ", toolLevel=" + toolLevel +
                ", rarity=" + rarity +
                ", requiresSmelting=" + requiresSmelting +
                ", baseForm='" + baseForm + '\'' +
                ", minDrops=" + minDrops +
                ", maxDrops=" + maxDrops +
                ", dropItemForm='" + dropItemForm + '\'' +
                ", isFireResistant=" + isFireResistant + // Ajout au toString
                '}';
    }
}