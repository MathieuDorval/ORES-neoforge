// src/main/java/com/__mathieu/ores/registries/ModBlocks.java (Modifié)
package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;
import com.__mathieu.ores.lists.OreList;
import com.__mathieu.ores.lists.StoneList;
import com.__mathieu.ores.lists.BlockList;
import com.__mathieu.ores.lists.def.OreDefinition;
import com.__mathieu.ores.lists.def.StoneDefinition;
import com.__mathieu.ores.lists.def.BlockDefinition;
import com.__mathieu.ores.core.UnifiedOreBlockProperties;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ORES.MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(ORES.MODID);

    public static final Map<String, DeferredBlock<Block>> ALL_UNIFIED_ORE_BLOCKS = new HashMap<>();
    public static final Map<String, DeferredItem<BlockItem>> ALL_UNIFIED_ORE_BLOCK_ITEMS = new HashMap<>();

    public static final Map<String, UnifiedOreBlockProperties> UNIFIED_ORE_BLOCK_DEFINITIONS = new HashMap<>();


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        registerUnifiedBlocks();
        ORES.LOGGER.info("Registered all unified blocks for ORES mod.");
    }

    private static void registerUnifiedBlocks() {
        registerUnifiedOreBlocksOnStone();
        registerUnifiedMaterialBlocks();
        // TODO: Gérer l'inflammabilité ici après que les blocs soient enregistrés si nécessaire
        // (ex: Blocks.setFlammable(block, catchChance, destroyChance))
    }

    private static void registerUnifiedOreBlocksOnStone() {
        for (OreDefinition material : OreList.ORES) {
            for (StoneDefinition stone : StoneList.STONES) {
                String blockId = String.format("%s_%s_ore", stone.getName(), material.getName());

                String requiredTool = stone.getRequiredTool();
                int toolLevel = Math.max(stone.getToolLevel(), material.getToolLevel());
                float hardness = Math.max(stone.getHardness(), material.getHardness());
                float resistance = Math.max(stone.getResistance(), material.getResistance());
                MapColor mapColor = material.getMapColor();
                SoundType soundType = stone.getSoundType();
                boolean isFireResistant = material.isFireResistant();
                float friction = material.getFriction(); // Nouveau
                int lightEmission = material.getLightEmission(); // Nouveau
                boolean flammable = material.isFlammable(); // Nouveau

                UnifiedOreBlockProperties blockProps = new UnifiedOreBlockProperties(
                        blockId,
                        material,
                        stone,
                        requiredTool,
                        toolLevel,
                        hardness,
                        resistance,
                        mapColor,
                        soundType,
                        isFireResistant,
                        friction,
                        lightEmission,
                        flammable
                );
                UNIFIED_ORE_BLOCK_DEFINITIONS.put(blockId, blockProps);

                BlockBehaviour.Properties properties = blockProps.toBlockProperties();

                DeferredBlock<Block> registeredBlock = BLOCKS.registerSimpleBlock(blockId, properties);
                ALL_UNIFIED_ORE_BLOCKS.put(blockId, registeredBlock);

                DeferredItem<BlockItem> registeredBlockItem = BLOCK_ITEMS.registerSimpleBlockItem(blockId, registeredBlock);
                ALL_UNIFIED_ORE_BLOCK_ITEMS.put(blockId, registeredBlockItem);

                ORES.LOGGER.debug("Registering unified ore block on stone: {}:{}", ORES.MODID, blockId);
            }
        }
    }

    private static void registerUnifiedMaterialBlocks() {
        for (OreDefinition material : OreList.ORES) {
            for (BlockDefinition blockType : BlockList.BLOCKS) {
                String blockId = blockType.getFullName(material.getName());

                String requiredTool = blockType.getRequiredTool();
                int toolLevel = Math.max(blockType.getToolLevel(), material.getToolLevel());
                float hardness = Math.max(blockType.getHardness(), material.getHardness());
                float resistance = Math.max(blockType.getResistance(), material.getResistance());
                MapColor mapColor = material.getMapColor();
                SoundType soundType = material.getSoundType();
                float friction = material.getFriction();
                int lightEmission = material.getLightEmission();
                boolean isFireResistant = material.isFireResistant();
                boolean flammable = material.isFlammable();


                BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .strength(hardness, resistance)
                        .requiresCorrectToolForDrops()
                        .sound(soundType)
                        .friction(friction)
                        .lightLevel(state -> lightEmission);


                DeferredBlock<Block> registeredBlock = BLOCKS.registerSimpleBlock(blockId, properties);
                ALL_UNIFIED_ORE_BLOCKS.put(blockId, registeredBlock);

                DeferredItem<BlockItem> registeredBlockItem = BLOCK_ITEMS.registerSimpleBlockItem(blockId, registeredBlock);
                ALL_UNIFIED_ORE_BLOCK_ITEMS.put(blockId, registeredBlockItem);

                ORES.LOGGER.debug("Registering unified material block: {}:{}", ORES.MODID, blockId);
            }
        }
    }

    public static DeferredItem<BlockItem> getOreBlockItem(String id) {
        return ALL_UNIFIED_ORE_BLOCK_ITEMS.get(id);
    }

    public static UnifiedOreBlockProperties getUnifiedOreBlockProperties(String id) {
        return UNIFIED_ORE_BLOCK_DEFINITIONS.get(id);
    }
}