package com.__mathieu.ores.core;

import com.__mathieu.ores.ORES;
import com.__mathieu.ores.lists.ItemList;
import com.__mathieu.ores.lists.OreList;
import com.__mathieu.ores.lists.def.ItemTypeDefinition;
import com.__mathieu.ores.lists.def.OreDefinition;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.HashMap;
import java.util.Map;

// Cette classe est responsable de l'enregistrement de tous les items de notre mod.
public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ORES.MODID);

    public static final Map<String, DeferredItem<Item>> ALL_UNIFIED_ITEMS = new HashMap<>();

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        registerUnifiedItems();
        ORES.LOGGER.info("Registered all unified items for ORES mod.");
    }

    private static void registerUnifiedItems() {

        for (OreDefinition oreDef : OreList.ORES) {
            String oreName = oreDef.getName();

            for (ItemTypeDefinition itemTypeDef : ItemList.ITEM_TYPES) {

                String fullItemName = itemTypeDef.getFullName(oreName);

                Item.Properties properties = new Item.Properties();

                DeferredItem<Item> registeredItem = ITEMS.registerSimpleItem(fullItemName, properties);

                ALL_UNIFIED_ITEMS.put(fullItemName, registeredItem);

                ORES.LOGGER.debug("Registering unified item: {}:{}", ORES.MODID, fullItemName);
            }
        }
    }
}