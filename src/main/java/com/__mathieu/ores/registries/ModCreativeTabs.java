package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;

import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Objects;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ORES.MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORES_BLOCKS_TAB = CREATIVE_MODE_TABS.register("ores_blocks_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + ORES.MODID + ".ores_blocks_tab"))
            .icon(() -> {

                String iconBlockId = "stone_iron_ore";
                DeferredItem<BlockItem> iconItem = ModBlocks.ALL_UNIFIED_ORE_BLOCK_ITEMS.get(iconBlockId);
                if (iconItem != null && iconItem.get() != null) {
                    return iconItem.get().getDefaultInstance();
                }
                ORES.LOGGER.warn("Could not find icon for ORES_BLOCKS_TAB: {}. Using fallback.", iconBlockId);
                return Items.STONE.getDefaultInstance();
            })
            .displayItems((parameters, output) -> {

                ModBlocks.ALL_UNIFIED_ORE_BLOCK_ITEMS.values().stream()
                        .map(DeferredItem::get)
                        .filter(Objects::nonNull)
                        .forEach(output::accept);
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORES_ITEMS_TAB = CREATIVE_MODE_TABS.register("ores_items_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + ORES.MODID + ".ores_items_tab"))
            .icon(() -> {

                String iconItemId = "iron_ingot";
                DeferredItem<Item> iconItem = ModItems.DERIVED_ITEMS.get(iconItemId);
                if (iconItem != null && iconItem.get() != null) {
                    return iconItem.get().getDefaultInstance();
                }

                ORES.LOGGER.warn("Could not find icon for ORES_ITEMS_TAB: {}. Using fallback.", iconItemId);
                return Items.IRON_INGOT.getDefaultInstance(); // Fallback sur le lingot de fer vanilla
            })
            .displayItems((parameters, output) -> {
                ModItems.DERIVED_ITEMS.values().stream()
                        .map(DeferredItem::get)
                        .filter(Objects::nonNull)
                        .forEach(output::accept);
            }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        ORES.LOGGER.info("Registered all creative tabs for ORES mod.");
    }
}