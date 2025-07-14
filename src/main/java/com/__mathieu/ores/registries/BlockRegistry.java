package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;
import com.__mathieu.ores.core.generation.OreBlocks;
import com.__mathieu.ores.core.generation.OreStoneBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockRegistry {
    // Registre pour les blocs
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, ORES.MODID);
    // Registre pour les items correspondants aux blocs
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, ORES.MODID);

    // Listes pour stocker les items des blocs enregistrés, afin de les ajouter facilement aux onglets créatifs
    public static final List<Supplier<Item>> REGISTERED_ORE_BLOCK_ITEMS = new ArrayList<>();
    public static final List<Supplier<Item>> REGISTERED_MATERIAL_BLOCK_ITEMS = new ArrayList<>();

    static {
        // Enregistrement des minerais dans la roche (stone ores)
        for (OreStoneBlocks.CombinedOreBlock combined : OreStoneBlocks.ORE_BLOCKS) {
            Supplier<Block> blockSupplier = BLOCKS.register(combined.getName(),
                    () -> new Block(BlockBehaviour.Properties.of()
                            .mapColor(combined.getStone().getMapColor())
                            .sound(combined.getStone().getSoundType())
                            .strength(combined.getHardness(), combined.getResistance())
                            .requiresCorrectToolForDrops()));
            registerBlockItem(combined.getName(), blockSupplier, REGISTERED_ORE_BLOCK_ITEMS);
        }

        // Enregistrement des blocs de matériaux (material blocks)
        for (OreBlocks.CombinedMaterialBlock combined : OreBlocks.MATERIAL_BLOCKS) {
            Supplier<Block> blockSupplier = BLOCKS.register(combined.getName(),
                    () -> new Block(BlockBehaviour.Properties.of()
                            .mapColor(combined.getMapColor())
                            .sound(combined.getSoundType())
                            .strength(combined.getHardness(), combined.getResistance())
                            .requiresCorrectToolForDrops()));
            registerBlockItem(combined.getName(), blockSupplier, REGISTERED_MATERIAL_BLOCK_ITEMS);
        }
    }

    private static void registerBlockItem(String name, Supplier<Block> blockSupplier, List<Supplier<Item>> itemList) {
        Supplier<Item> itemSupplier = ITEMS.register(name, () -> new BlockItem(blockSupplier.get(), new Item.Properties()));
        itemList.add(itemSupplier);
    }
}