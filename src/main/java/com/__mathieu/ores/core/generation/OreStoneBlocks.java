package com.__mathieu.ores.core.generation;

import com.__mathieu.ores.core.definitions.OreDefinition;
import com.__mathieu.ores.core.definitions.StoneDefinition;
import com.__mathieu.ores.core.lists.OreList;
import com.__mathieu.ores.core.lists.StoneList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OreStoneBlocks {

    public static final List<CombinedOreBlock> ORE_BLOCKS = new ArrayList<>();

    static {
        // Parcourt toutes les pierres définies dans StoneList
        for (Field stoneField : StoneList.class.getFields()) {
            if (java.lang.reflect.Modifier.isStatic(stoneField.getModifiers())) {
                try {
                    StoneDefinition stone = (StoneDefinition) stoneField.get(null);
                    // Pour chaque pierre, parcourt tous les minerais définis dans OreList
                    for (Field oreField : OreList.class.getFields()) {
                        if (java.lang.reflect.Modifier.isStatic(oreField.getModifiers())) {
                            try {
                                OreDefinition ore = (OreDefinition) oreField.get(null);
                                // Crée une nouvelle combinaison et l'ajoute à la liste
                                ORE_BLOCKS.add(new CombinedOreBlock(stone, ore));
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

    public static class CombinedOreBlock {
        private final String name;
        private final float hardness;
        private final float resistance;
        private final int toolLevel;
        private final StoneDefinition stone;
        private final OreDefinition ore;

        public CombinedOreBlock(StoneDefinition stone, OreDefinition ore) {
            this.stone = stone;
            this.ore = ore;
            this.name = stone.getName() + "_" + ore.getName() + "_ore";
            // Calcule la dureté en multipliant la dureté de la pierre par le multiplicateur du minerai
            this.hardness = stone.getHardness() * ore.getHardnessMultiplier(); //
            // Calcule la résistance de la même manière
            this.resistance = stone.getResistance() * ore.getResistanceMultiplier(); //
            // Le niveau de l'outil est le plus élevé des deux
            this.toolLevel = Math.max(stone.getToolLevel(), ore.getToolLevel()); //
        }

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

        public StoneDefinition getStone() {
            return stone;
        }

        public OreDefinition getOre() {
            return ore;
        }
    }
}