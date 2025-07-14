// src/main/java/com/__mathieu/ores/registries/ModBlocks.java
package com.__mathieu.ores.registries;

import com.__mathieu.ores.ORES;
import com.__mathieu.ores.lists.OreList;       // Importez OreList
import com.__mathieu.ores.lists.StoneList;     // Importez StoneList
import com.__mathieu.ores.lists.BlockList;     // **NOUVEAU : Importez BlockList**
import com.__mathieu.ores.lists.def.OreDefinition;   // Importez OreDefinition
import com.__mathieu.ores.lists.def.StoneDefinition; // Importez StoneDefinition
import com.__mathieu.ores.lists.def.BlockDefinition; // **NOUVEAU : Importez BlockDefinition**
import com.__mathieu.ores.core.UnifiedOreBlockProperties; // Importez la nouvelle classe

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item; // Utilisé pour Item.Properties
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
import java.util.Objects; // Assurez-vous que cette importation est là

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ORES.MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(ORES.MODID);

    public static final Map<String, DeferredBlock<Block>> ALL_UNIFIED_ORE_BLOCKS = new HashMap<>();
    public static final Map<String, DeferredItem<BlockItem>> ALL_UNIFIED_ORE_BLOCK_ITEMS = new HashMap<>();

    public static final Map<String, UnifiedOreBlockProperties> UNIFIED_ORE_BLOCK_DEFINITIONS = new HashMap<>();


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        registerUnifiedBlocks(); // Renommé pour englober les deux types de blocs
        ORES.LOGGER.info("Registered all unified blocks for ORES mod.");
    }

    // Méthode principale d'enregistrement pour tous les types de blocs
    private static void registerUnifiedBlocks() {
        registerUnifiedOreBlocksOnStone(); // Enregistre les blocs de minerai sur pierre
        registerUnifiedMaterialBlocks();   // Enregistre les blocs de matière (raw, standard, compressés)
    }

    // Ancien contenu de registerUnifiedOreBlocks()
    private static void registerUnifiedOreBlocksOnStone() {
        for (OreDefinition material : OreList.ORES) {
            for (StoneDefinition stone : StoneList.STONES) {
                String blockId = String.format("%s_%s_ore", stone.getName(), material.getName());

                // Calcul des propriétés combinées (de la pierre et du minerai)
                String requiredTool = stone.getRequiredTool();
                int toolLevel = Math.max(stone.getToolLevel(), material.getToolLevel());
                float hardness = Math.max(stone.getHardness(), material.getHardness()); // Utilise la dureté du minerai
                float resistance = Math.max(stone.getResistance(), material.getResistance()); // Utilise la résistance du minerai
                MapColor mapColor = material.getMapColor(); // Utilise la couleur du minerai pour le bloc d'minerai sur pierre
                SoundType soundType = stone.getSoundType(); // Utilise le son de la pierre

                // Crée une instance de notre définition de propriétés de bloc unifié (pour minerai sur pierre)
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
                UNIFIED_ORE_BLOCK_DEFINITIONS.put(blockId, blockProps);

                // Utilise la définition pour obtenir les BlockBehaviour.Properties
                BlockBehaviour.Properties properties = blockProps.toBlockProperties();

                // Enregistrement du bloc
                DeferredBlock<Block> registeredBlock = BLOCKS.registerSimpleBlock(blockId, properties);
                ALL_UNIFIED_ORE_BLOCKS.put(blockId, registeredBlock);

                // Enregistrement de l'item correspondant au bloc (BlockItem)
                DeferredItem<BlockItem> registeredBlockItem = BLOCK_ITEMS.registerSimpleBlockItem(blockId, registeredBlock);
                ALL_UNIFIED_ORE_BLOCK_ITEMS.put(blockId, registeredBlockItem);

                ORES.LOGGER.debug("Registering unified ore block on stone: {}:{}", ORES.MODID, blockId);
            }
        }
    }

    // NOUVELLE MÉTHODE : Enregistre les blocs de matière (raw_block, block, compressed_block)
    private static void registerUnifiedMaterialBlocks() {
        for (OreDefinition material : OreList.ORES) { // Itérer sur les minerais
            for (BlockDefinition blockType : BlockList.BLOCKS) { // Itérer sur les types de blocs de matière
                // Nom de l'ID du bloc de matière (ex: "raw_iron_block", "iron_block", "compressed_iron_block")
                String blockId = blockType.getFullName(material.getName());

                // Calcul des propriétés du bloc de matière
                // Elles proviennent principalement de BlockDefinition, mais peuvent être influencées par OreDefinition
                String requiredTool = blockType.getRequiredTool();
                int toolLevel = Math.max(blockType.getToolLevel(), material.getToolLevel()); // Niveau d'outil le plus élevé
                float hardness = Math.max(blockType.getHardness(), material.getHardness());   // Dureté la plus élevée
                float resistance = Math.max(blockType.getResistance(), material.getResistance()); // Résistance la plus élevée
                MapColor mapColor = material.getMapColor(); // Couleur basée sur le minerai
                SoundType soundType = material.getSoundType(); // Son basé sur le minerai
                boolean isFireResistant = material.isFireResistant(); // Résistance au feu basée sur le minerai


                // Crée les propriétés du bloc Minecraft
                BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .strength(hardness, resistance)
                        .requiresCorrectToolForDrops()
                        .sound(soundType);

                // Enregistrement du bloc
                DeferredBlock<Block> registeredBlock = BLOCKS.registerSimpleBlock(blockId, properties);
                ALL_UNIFIED_ORE_BLOCKS.put(blockId, registeredBlock); // Utilise la même map pour tous les blocs

                // Enregistrement de l'item correspondant au bloc (BlockItem)
                DeferredItem<BlockItem> registeredBlockItem = BLOCK_ITEMS.registerSimpleBlockItem(blockId, registeredBlock);
                ALL_UNIFIED_ORE_BLOCK_ITEMS.put(blockId, registeredBlockItem); // Utilise la même map pour tous les BlockItems

                ORES.LOGGER.debug("Registering unified material block: {}:{}", ORES.MODID, blockId);
            }
        }
    }


    // Méthode pour obtenir le DeferredItem du BlockItem d'un minerai unifié
    public static DeferredItem<BlockItem> getOreBlockItem(String id) {
        return ALL_UNIFIED_ORE_BLOCK_ITEMS.get(id);
    }

    // Méthode pour obtenir la définition des propriétés d'un bloc par son ID (pour les blocs de minerai sur pierre)
    public static UnifiedOreBlockProperties getUnifiedOreBlockProperties(String id) {
        return UNIFIED_ORE_BLOCK_DEFINITIONS.get(id);
    }
}