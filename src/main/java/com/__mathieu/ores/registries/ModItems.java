// src/main/java/com/__mathieu/ores/registries/ModItems.java
package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;
import com.__mathieu.ores.lists.OreList;
import com.__mathieu.ores.lists.def.OreDefinition;
import com.__mathieu.ores.lists.def.ItemTypeDefinition;
import com.__mathieu.ores.lists.ItemList;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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
        Rarity[] rarities = Rarity.values();

        for (OreDefinition material : OreList.ORES) {
            String oreName = material.getName();

            for (ItemTypeDefinition itemTypeDef : ItemList.ITEM_TYPES) {
                String fullItemName = itemTypeDef.getFullName(oreName);

                Rarity oreRarity = material.getRarity();
                Rarity itemTypeRarity = itemTypeDef.getRarity();

                Rarity finalRarity = rarities[Math.max(oreRarity.ordinal(), itemTypeRarity.ordinal())];

                boolean finalIsFireResistant = material.isFireResistant() || itemTypeDef.isFireResistant();

                Item.Properties properties = new Item.Properties()
                        .stacksTo(itemTypeDef.getMaxStackSize())
                        .rarity(finalRarity);

                if (finalIsFireResistant) {
                    properties.fireResistant();
                }

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