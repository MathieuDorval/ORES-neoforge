package com.__mathieu.ores.core.generation;

import com.__mathieu.ores.core.definitions.BlockDefinition;
import com.__mathieu.ores.core.definitions.OreDefinition;
import com.__mathieu.ores.core.lists.BlockList;
import com.__mathieu.ores.core.lists.OreList;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class OreBlocks {

    public static final List<CombinedMaterialBlock> MATERIAL_BLOCKS = new ArrayList<>();

    static {
        // Parcourt tous les types de blocs définis dans BlockList
        for (Field blockField : BlockList.class.getFields()) {
            if (java.lang.reflect.Modifier.isStatic(blockField.getModifiers())) {
                try {
                    BlockDefinition blockDef = (BlockDefinition) blockField.get(null);
                    // Pour chaque type de bloc, parcourt tous les minerais définis dans OreList
                    for (Field oreField : OreList.class.getFields()) {
                        if (java.lang.reflect.Modifier.isStatic(oreField.getModifiers())) {
                            try {
                                OreDefinition oreDef = (OreDefinition) oreField.get(null);
                                // Crée une nouvelle combinaison et l'ajoute à la liste
                                MATERIAL_BLOCKS.add(new CombinedMaterialBlock(blockDef, oreDef));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class CombinedMaterialBlock {
        private final BlockDefinition blockDefinition;
        private final OreDefinition oreDefinition;

        private final String name;
        private final float hardness;
        private final float resistance;
        private final int toolLevel;
        private final MapColor mapColor;
        private final SoundType soundType;
        private final PushReaction pushReaction;

        public CombinedMaterialBlock(BlockDefinition blockDef, OreDefinition oreDef) {
            this.blockDefinition = blockDef;
            this.oreDefinition = oreDef;

            // Construit le nom final du bloc (ex: "raw_iron_block")
            this.name = blockDef.getFullName(oreDef.getName());

            // Les propriétés du matériau (dureté, résistance, etc.) sont prises de l'OreDefinition
            // car elles sont spécifiques à ce matériau.
            this.hardness = oreDef.getHardness();
            this.resistance = oreDef.getResistance();
            this.toolLevel = oreDef.getToolLevel();
            this.mapColor = oreDef.getMapColor();
            this.soundType = oreDef.getSoundType();
            this.pushReaction = oreDef.getPushReaction();
        }

        // --- GETTERS ---

        public String getName() {
            return name;
        }

        public float getHardness() {
            return hardness;
        }

        public float getResistance() {
            return resistance;
        }

        public int getToolLevel() {
            return toolLevel;
        }

        public MapColor getMapColor() {
            return mapColor;
        }

        public SoundType getSoundType() {
            return soundType;
        }

        public PushReaction getPushReaction() {
            return pushReaction;
        }

        public BlockDefinition getBlockDefinition() {
            return blockDefinition;
        }

        public OreDefinition getOreDefinition() {
            return oreDefinition;
        }
    }
}