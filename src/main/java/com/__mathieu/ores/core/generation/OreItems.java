package com.__mathieu.ores.core.generation;

import com.__mathieu.ores.core.definitions.ItemDefinition;
import com.__mathieu.ores.core.definitions.OreDefinition;
import com.__mathieu.ores.core.lists.ItemList;
import com.__mathieu.ores.core.lists.OreList;
import net.minecraft.world.item.Rarity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OreItems {

    public static final List<CombinedItem> GENERATED_ITEMS = new ArrayList<>();

    static {
        for (Field itemField : ItemList.class.getFields()) {
            if (java.lang.reflect.Modifier.isStatic(itemField.getModifiers())) {
                try {
                    ItemDefinition itemDef = (ItemDefinition) itemField.get(null);
                    for (Field oreField : OreList.class.getFields()) {
                        if (java.lang.reflect.Modifier.isStatic(oreField.getModifiers())) {
                            try {
                                OreDefinition oreDef = (OreDefinition) oreField.get(null);


                                if (!oreDef.selfExist() && itemDef.getName().equals("self")) {
                                    continue;
                                }

                                GENERATED_ITEMS.add(new CombinedItem(itemDef, oreDef));

                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class CombinedItem {
        private final ItemDefinition itemDefinition;
        private final OreDefinition oreDefinition;

        private final String name;
        private final boolean isFireResistant;
        private final boolean hasGlint;
        private final Rarity rarity;

        public CombinedItem(ItemDefinition itemDef, OreDefinition oreDef) {
            this.itemDefinition = itemDef;
            this.oreDefinition = oreDef;

            // Construit le nom final de l'item (ex: "raw_iron", "iron_ingot", "diamond")
            this.name = itemDef.getFullName(oreDef.getName());

            // La propriété est vraie si l'une des deux définitions est vraie.
            this.isFireResistant = itemDef.isFireResistant() || oreDef.isFireResistant();

            // Le "glint" peut être défini soit par le type d'item, soit par une propriété future sur l'ore
            // Pour l'instant, on se base sur l'ItemDefinition
            this.hasGlint = itemDef.hasGlint();

            // La rareté est généralement héritée de l'OreDefinition.
            this.rarity = oreDef.getRarity();
        }

        // --- GETTERS ---

        public String getName() {
            return name;
        }

        public boolean isFireResistant() {
            return isFireResistant;
        }

        public boolean hasGlint() {
            return hasGlint;
        }

        public Rarity getRarity() {
            return rarity;
        }

        public int getMaxStackSize() {
            return itemDefinition.getMaxStackSize();
        }

        public ItemDefinition getItemDefinition() {
            return itemDefinition;
        }

        public OreDefinition getOreDefinition() {
            return oreDefinition;
        }
    }
}