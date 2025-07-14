package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;
import com.__mathieu.ores.lists.OreList; // Importez OreList
import com.__mathieu.ores.lists.StoneList; // Importez StoneList
import com.__mathieu.ores.lists.def.OreDefinition; // Importez OreDefinition
import com.__mathieu.ores.lists.def.StoneDefinition; // Importez StoneDefinition
import com.__mathieu.ores.core.UnifiedOreBlockProperties; // Importez la nouvelle classe

import net.minecraft.world.item.BlockItem;
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

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ORES.MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(ORES.MODID); // Pour les BlockItems

    // Map pour stocker tous les DeferredBlock générés
    public static final Map<String, DeferredBlock<Block>> ALL_UNIFIED_ORE_BLOCKS = new HashMap<>();
    // Map pour stocker tous les BlockItem associés aux blocs de minerai
    public static final Map<String, DeferredItem<BlockItem>> ALL_UNIFIED_ORE_BLOCK_ITEMS = new HashMap<>();

    // Map pour stocker les définitions de propriétés des blocs unifiés
    public static final Map<String, UnifiedOreBlockProperties> UNIFIED_ORE_BLOCK_DEFINITIONS = new HashMap<>();


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus); // Enregistre aussi le DeferredRegister pour les BlockItems
        registerUnifiedOreBlocks();
        ORES.LOGGER.info("Registered all unified ore blocks for ORES mod.");
    }

    private static void registerUnifiedOreBlocks() {
        // Itérer sur les listes de définitions
        for (OreDefinition material : OreList.ORES) { // Itérer sur OreList.ORES
            for (StoneDefinition stone : StoneList.STONES) { // Itérer sur StoneList.STONES
                String blockId = String.format("%s_%s_ore", stone.getName(), material.getName());

                // Calcul des propriétés combinées
                String requiredTool = stone.getRequiredTool();
                int toolLevel = Math.max(stone.getToolLevel(), material.getToolLevel());
                float hardness = Math.max(stone.getHardness(), material.getToolLevel() + 1.0F);
                float resistance = stone.getResistance();
                MapColor mapColor = stone.getMapColor();
                SoundType soundType = stone.getSoundType();

                // Crée une instance de notre nouvelle définition de propriétés de bloc unifié
                UnifiedOreBlockProperties blockProps = new UnifiedOreBlockProperties(
                        blockId,
                        material,
                        stone,
                        requiredTool,
                        toolLevel,
                        hardness,
                        resistance,
                        mapColor,
                        soundType
                );
                UNIFIED_ORE_BLOCK_DEFINITIONS.put(blockId, blockProps); // Stocke la définition

                // Utilise la définition pour obtenir les BlockBehaviour.Properties
                BlockBehaviour.Properties properties = blockProps.toBlockProperties();

                // Enregistrement du bloc
                DeferredBlock<Block> registeredBlock = BLOCKS.registerSimpleBlock(blockId, properties);
                ALL_UNIFIED_ORE_BLOCKS.put(blockId, registeredBlock);

                // Enregistrement de l'item correspondant au bloc (BlockItem)
                DeferredItem<BlockItem> registeredBlockItem = BLOCK_ITEMS.registerSimpleBlockItem(blockId, registeredBlock);
                ALL_UNIFIED_ORE_BLOCK_ITEMS.put(blockId, registeredBlockItem);

                ORES.LOGGER.debug("Registering unified ore block: {}:{}", ORES.MODID, blockId);
            }
        }
    }

    // Méthode pour obtenir le DeferredItem du BlockItem d'un minerai unifié
    public static DeferredItem<BlockItem> getOreBlockItem(String id) {
        return ALL_UNIFIED_ORE_BLOCK_ITEMS.get(id);
    }

    // Méthode pour obtenir la définition des propriétés d'un bloc par son ID
    public static UnifiedOreBlockProperties getUnifiedOreBlockProperties(String id) {
        return UNIFIED_ORE_BLOCK_DEFINITIONS.get(id);
    }
}