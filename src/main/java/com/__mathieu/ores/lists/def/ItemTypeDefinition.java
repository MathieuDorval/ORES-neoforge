// src/main/java/com/__mathieu/ores/lists/def/ItemTypeDefinition.java (Modifié)
package com.__mathieu.ores.lists.def;

import net.minecraft.world.item.Rarity; // Assurez-vous d'importer Rarity si vous l'avez ajouté

public class ItemTypeDefinition {
    private final String name;
    private final String prefix;
    private final String suffix;
    private final int maxStackSize;
    private final Rarity rarity; // Si vous avez déjà ajouté ce paramètre
    private final boolean isFireResistant; // Nouveau paramètre : résistance au feu

    public ItemTypeDefinition(String name, String prefix, String suffix, int maxStackSize, Rarity rarity, boolean isFireResistant) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.maxStackSize = maxStackSize;
        this.rarity = rarity;
        this.isFireResistant = isFireResistant; // Initialisation du nouveau paramètre
    }

    // Si vous n'utilisez pas le paramètre 'rarity' actuellement, le constructeur sans rarity est :
    /*
    public ItemTypeDefinition(String name, String prefix, String suffix, int maxStackSize, boolean isFireResistant) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.maxStackSize = maxStackSize;
        this.rarity = Rarity.COMMON; // Valeur par défaut si non incluse
        this.isFireResistant = isFireResistant;
    }
    */


    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public Rarity getRarity() { // Getter pour Rarity (si présent)
        return rarity;
    }

    public boolean isFireResistant() { // Nouveau getter pour isFireResistant
        return isFireResistant;
    }

    public String getFullName(String oreName) {
        StringBuilder fullName = new StringBuilder();
        if (!prefix.isEmpty()) {
            fullName.append(prefix).append("_");
        }
        fullName.append(oreName);
        if (!suffix.isEmpty()) {
            fullName.append("_").append(suffix);
        }
        return fullName.toString();
    }

    @Override
    public String toString() {
        return "ItemTypeDefinition{" +
                "name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", maxStackSize=" + maxStackSize +
                ", rarity=" + rarity + // Ajoutez au toString si présent
                ", isFireResistant=" + isFireResistant + // Ajoutez au toString
                '}';
    }
}