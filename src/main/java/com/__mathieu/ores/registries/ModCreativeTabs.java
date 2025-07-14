// src/main/java/com/__mathieu/ores/registries/ModCreativeTabs.java
package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;

import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items; // Pour les items de fallback
import net.minecraft.world.item.BlockItem; // Pour les BlockItems
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;
import java.util.Objects;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ORES.MODID);

    // 1. Onglet pour les BLOCS DE MINERAI (minerais sur pierre)
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORES_ORE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("ores_ore_blocks_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + ORES.MODID + ".ores_ore_blocks_tab"))
            .icon(() -> {
                // Tente d'utiliser le bloc de minerai de fer sur pierre comme icône
                String iconBlockId = "stone_iron_ore";
                DeferredItem<BlockItem> iconItem = ModBlocks.ALL_UNIFIED_ORE_BLOCK_ITEMS.get(iconBlockId);
                if (iconItem != null && iconItem.get() != null) {
                    return iconItem.get().getDefaultInstance();
                }
                ORES.LOGGER.warn("Could not find icon for ORES_ORE_BLOCKS_TAB: {}. Using fallback.", iconBlockId);
                return Items.IRON_ORE.getDefaultInstance(); // Fallback sur le minerai de fer vanilla
            })
            .displayItems((parameters, output) -> {
                // Filtre pour n'afficher que les blocs de minerai (ceux qui finissent par "_ore")
                ModBlocks.ALL_UNIFIED_ORE_BLOCK_ITEMS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_ore")) // Garde seulement les IDs finissant par "_ore"
                        .map(Map.Entry::getValue) // Obtient le DeferredItem
                        .map(DeferredItem::get) // Obtient l'instance réelle de l'Item
                        .filter(Objects::nonNull) // S'assure que l'item n'est pas nul
                        .forEach(output::accept); // Ajoute l'item à l'onglet
            }).build());

    // 2. Onglet pour les ITEMS DÉRIVÉS (lingots, poudres, bruts, etc.)
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORES_ITEMS_TAB = CREATIVE_MODE_TABS.register("ores_items_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + ORES.MODID + ".ores_items_tab"))
            .icon(() -> {
                // Tente d'utiliser le lingot de fer unifié comme icône
                String iconItemId = "iron_ingot";
                DeferredItem<Item> iconItem = ModItems.DERIVED_ITEMS.get(iconItemId);
                if (iconItem != null && iconItem.get() != null) {
                    return iconItem.get().getDefaultInstance();
                }
                ORES.LOGGER.warn("Could not find icon for ORES_ITEMS_TAB: {}. Using fallback.", iconItemId);
                return Items.IRON_INGOT.getDefaultInstance(); // Fallback sur le lingot de fer vanilla
            })
            .displayItems((parameters, output) -> {
                // Ajoute tous les items dérivés enregistrés à cet onglet
                ModItems.DERIVED_ITEMS.values().stream()
                        .map(DeferredItem::get)
                        .filter(Objects::nonNull)
                        .forEach(output::accept);
            }).build());

    // 3. NOUVEL ONGLETS pour les BLOCS DE MATIÈRE (blocs de fer, blocs compressés, etc.)
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORES_MATERIAL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("ores_material_blocks_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + ORES.MODID + ".ores_material_blocks_tab"))
            .icon(() -> {
                // Tente d'utiliser le bloc de fer unifié comme icône
                String iconBlockId = "iron_block"; // Nom du bloc de fer unifié
                DeferredItem<BlockItem> iconItem = ModBlocks.ALL_UNIFIED_ORE_BLOCK_ITEMS.get(iconBlockId);
                if (iconItem != null && iconItem.get() != null) {
                    return iconItem.get().getDefaultInstance();
                }
                ORES.LOGGER.warn("Could not find icon for ORES_MATERIAL_BLOCKS_TAB: {}. Using fallback.", iconBlockId);
                return Items.IRON_BLOCK.getDefaultInstance(); // Fallback sur le bloc de fer vanilla
            })
            .displayItems((parameters, output) -> {
                // Filtre pour n'afficher que les blocs de matière (ceux qui NE finissent PAS par "_ore")
                ModBlocks.ALL_UNIFIED_ORE_BLOCK_ITEMS.entrySet().stream()
                        .filter(entry -> !entry.getKey().endsWith("_ore")) // Garde seulement les IDs NE finissant PAS par "_ore"
                        .map(Map.Entry::getValue)
                        .map(DeferredItem::get)
                        .filter(Objects::nonNull)
                        .forEach(output::accept);
            }).build());


    // Méthode pour enregistrer le Deferred Register de Creative Tabs.
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        ORES.LOGGER.info("Registered all creative tabs for ORES mod.");
    }
}