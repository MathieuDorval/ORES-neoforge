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

    public static void generate() {
        if (!ORE_BLOCKS.isEmpty()) return;

        for (Field stoneField : StoneList.class.getFields()) {
            if (java.lang.reflect.Modifier.isStatic(stoneField.getModifiers())) {
                try {
                    StoneDefinition stone = (StoneDefinition) stoneField.get(null);
                    for (Field oreField : OreList.class.getFields()) {
                        if (java.lang.reflect.Modifier.isStatic(oreField.getModifiers())) {
                            try {
                                OreDefinition ore = (OreDefinition) oreField.get(null);
                                ORE_BLOCKS.add(new CombinedOreBlock(stone, ore));
                            } catch (IllegalAccessException e) { e.printStackTrace(); }
                        }
                    }
                } catch (IllegalAccessException e) { e.printStackTrace(); }
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
            this.hardness = stone.getHardness() * ore.getHardnessMultiplier();
            this.resistance = stone.getResistance() * ore.getResistanceMultiplier();
            this.toolLevel = Math.max(stone.getToolLevel(), ore.getToolLevel());
        }

        public String getName() { return name; }
        public float getHardness() { return hardness; }
        public float getResistance() { return resistance; }
        public int getToolLevel() { return toolLevel; }
        public StoneDefinition getStone() { return stone; }
        public OreDefinition getOre() { return ore; }
    }
}