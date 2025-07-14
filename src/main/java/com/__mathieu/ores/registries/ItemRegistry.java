package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;
import com.__mathieu.ores.core.generation.OreItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, ORES.MODID);

    public static final List<Supplier<Item>> REGISTERED_ITEMS = new ArrayList<>();

    static {
        for (OreItems.CombinedItem combined : OreItems.GENERATED_ITEMS) {
            Item.Properties properties = new Item.Properties().rarity(combined.getRarity());
            if (combined.isFireResistant()) {
                properties.fireResistant();
            }

            Supplier<Item> itemSupplier = ITEMS.register(combined.getName(), () -> new Item(properties));
            REGISTERED_ITEMS.add(itemSupplier);
        }
    }
}