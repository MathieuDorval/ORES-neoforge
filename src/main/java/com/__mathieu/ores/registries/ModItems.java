// src/main/java/com/__mathieu/ores/registries/ModItems.java
package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;
import com.__mathieu.ores.lists.OreList;
import com.__mathieu.ores.lists.def.OreDefinition;
import com.__mathieu.ores.lists.def.ItemTypeDefinition;
import com.__mathieu.ores.lists.ItemList;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

// Cette classe est responsable de l'enregistrement de tous les items dérivés (ingots, dusts, gems, etc.)
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ORES.MODID);

    public static final Map<String, DeferredItem<Item>> DERIVED_ITEMS = new HashMap<>();

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        registerDerivedItems();
        ORES.LOGGER.info("Registered all derived items for ORES mod.");
    }

    private static void registerDerivedItems() {
        for (OreDefinition material : OreList.ORES) {
            String oreName = material.getName();

            // **CORRECTION ICI : Utiliser ModItemTypes.ITEM_TYPES**
            for (ItemTypeDefinition itemTypeDef : ItemList.ITEM_TYPES) {
                String fullItemName = itemTypeDef.getFullName(oreName);

                // --- Logique pour filtrer la création d'items non pertinents (selon vos règles) ---
                if (itemTypeDef.getName().equals("raw") && !material.requiresSmelting()) {
                    continue;
                }
                if (itemTypeDef.getName().equals("ingot") && !material.requiresSmelting()) {
                    continue;
                }
                if (itemTypeDef.getName().equals("gem") && material.requiresSmelting()) {
                    continue;
                }
                if (itemTypeDef.getName().equals("dust") && !material.getDropItemForm().equals("dust")) {
                    continue;
                }
                if (itemTypeDef.getName().equals("nugget") && !material.getBaseForm().equals("ingot")) {
                    continue;
                }

                Item.Properties properties = new Item.Properties();

                DeferredItem<Item> registeredItem = ITEMS.registerSimpleItem(fullItemName, properties);
                DERIVED_ITEMS.put(fullItemName, registeredItem);

                ORES.LOGGER.debug("Registering derived item: {}:{}", ORES.MODID, fullItemName);
            }
        }
    }

    public static DeferredItem<Item> getDerivedItem(String id) {
        return DERIVED_ITEMS.get(id);
    }
}