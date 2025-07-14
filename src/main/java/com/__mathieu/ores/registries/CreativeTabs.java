package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ORES.MODID);

    /**
     * Onglet créatif pour tous les items (lingots, poudres, etc.).
     */
    public static final Supplier<CreativeModeTab> ORES_ITEMS_TAB = CREATIVE_MODE_TABS.register("ores_items_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.ores_items_tab"))
                    .icon(() -> new ItemStack(ItemRegistry.REGISTERED_ITEMS.get(0).get())) // Prend le premier item enregistré comme icône
                    .displayItems((displayParameters, output) -> {
                        // Ajoute tous les items enregistrés depuis ItemRegistry
                        ItemRegistry.REGISTERED_ITEMS.forEach(item -> output.accept(item.get()));
                    })
                    .build());

    /**
     * Onglet créatif pour les blocs de matériaux (bloc de fer, bloc d'or, etc.).
     */
    public static final Supplier<CreativeModeTab> ORES_BLOCKS_TAB = CREATIVE_MODE_TABS.register("ores_blocks_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.ores_blocks_tab"))
                    .icon(() -> new ItemStack(BlockRegistry.REGISTERED_MATERIAL_BLOCK_ITEMS.get(0).get())) // Prend le premier bloc comme icône
                    .displayItems((displayParameters, output) -> {
                        // Ajoute tous les blocs de matériaux enregistrés
                        BlockRegistry.REGISTERED_MATERIAL_BLOCK_ITEMS.forEach(item -> output.accept(item.get()));
                    })
                    .build());

    /**
     * Onglet créatif pour les minerais dans la roche (minerai de fer dans la pierre, etc.).
     */
    public static final Supplier<CreativeModeTab> ORES_STONES_TAB = CREATIVE_MODE_TABS.register("ores_stones_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.ores_stones_tab"))
                    .icon(() -> new ItemStack(BlockRegistry.REGISTERED_ORE_BLOCK_ITEMS.get(0).get())) // Prend le premier minerai comme icône
                    .displayItems((displayParameters, output) -> {
                        // Ajoute tous les minerais enregistrés
                        BlockRegistry.REGISTERED_ORE_BLOCK_ITEMS.forEach(item -> output.accept(item.get()));
                    })
                    .build());
}