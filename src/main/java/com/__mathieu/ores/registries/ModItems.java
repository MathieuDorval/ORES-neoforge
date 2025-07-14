// src/main/java/com/__mathieu/ores/registries/ModItems.java
package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;
import com.__mathieu.ores.lists.OreList;       // Importez OreList
import com.__mathieu.ores.lists.def.OreDefinition; // Importez OreDefinition
import com.__mathieu.ores.lists.def.ItemTypeDefinition; // Importez ItemTypeDefinition
import com.__mathieu.ores.lists.ItemList; // Importez ModItemTypes

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

// Cette classe est responsable de l'enregistrement de tous les items dérivés (ingots, dusts, gems, etc.)
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ORES.MODID);

    // Map pour stocker tous les DeferredItem générés
    public static final Map<String, DeferredItem<Item>> DERIVED_ITEMS = new HashMap<>();

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        registerDerivedItems();
        ORES.LOGGER.info("Registered all derived items for ORES mod.");
    }

    private static void registerDerivedItems() {
        for (OreDefinition material : OreList.ORES) { // Itérer sur OreList.ORES
            String oreName = material.getName();

            // Pour chaque type d'item défini (ingot, dust, raw, gem, nugget, block)
            for (ItemTypeDefinition itemTypeDef : ItemList.ITEM_TYPES) { // Itérer sur ModItemTypes.ITEM_TYPES
                String fullItemName = itemTypeDef.getFullName(oreName);

                // --- Logique pour filtrer la création d'items non pertinents (selon vos règles) ---
                // Par exemple, ne pas générer de "raw" si le minerai ne nécessite pas de fonte
                if (itemTypeDef.getName().equals("raw") && !material.requiresSmelting()) {
                    continue;
                }
                // Ne pas générer de "ingot" si le minerai ne nécessite pas de fonte
                if (itemTypeDef.getName().equals("ingot") && !material.requiresSmelting()) {
                    continue;
                }
                // Ne pas générer de "gem" si le minerai nécessite de la fonte (implique ingot/dust)
                if (itemTypeDef.getName().equals("gem") && material.requiresSmelting()) {
                    continue;
                }
                // Ne pas générer de "dust" si le minerai n'est pas censé dropper de la poudre
                if (itemTypeDef.getName().equals("dust") && !material.getDropItemForm().equals("dust")) {
                    continue;
                }
                // Ne pas générer de "nugget" si la forme de base n'est pas "ingot"
                if (itemTypeDef.getName().equals("nugget") && !material.getBaseForm().equals("ingot")) {
                    continue;
                }

                Item.Properties properties = new Item.Properties();
                // Vous pouvez personnaliser les propriétés ici (stack size, rareté, etc.)
                // properties.stacksTo(material.getBaseForm().equals("gem") ? 64 : 64); // Exemple: les gemmes peuvent stacker par 64


                DeferredItem<Item> registeredItem = ITEMS.registerSimpleItem(fullItemName, properties);
                DERIVED_ITEMS.put(fullItemName, registeredItem);

                ORES.LOGGER.debug("Registering derived item: {}:{}", ORES.MODID, fullItemName);
            }
        }
    }

    // Méthode pour obtenir un DeferredItem par son ID
    public static DeferredItem<Item> getDerivedItem(String id) {
        return DERIVED_ITEMS.get(id);
    }
}