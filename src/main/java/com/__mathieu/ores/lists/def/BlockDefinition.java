// src/main/java/com/__mathieu/ores/lists/def/BlockDefinition.java
package com.__mathieu.ores.lists.def;

public class BlockDefinition {
    private final String name;
    private final String prefix;
    private final String suffix;
    private final String requiredTool;
    private final int toolLevel;
    private final float hardness;
    private final float resistance;


    public BlockDefinition(String name, String prefix, String suffix, String requiredTool, int toolLevel, float hardness, float resistance) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.requiredTool = requiredTool;
        this.toolLevel = toolLevel;
        this.hardness = hardness;
        this.resistance = resistance;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getRequiredTool() {
        return requiredTool;
    }

    public int getToolLevel() {
        return toolLevel;
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }

    public String getFullName(String materialName) {
        StringBuilder fullName = new StringBuilder();
        if (!prefix.isEmpty()) {
            fullName.append(prefix).append("_");
        }
        fullName.append(materialName);
        if (!suffix.isEmpty()) {
            fullName.append("_").append(suffix);
        }
        return fullName.toString();
    }


    @Override
    public String toString() {
        return "BlockDefinition{" +
                "name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", requiredTool='" + requiredTool + '\'' +
                ", toolLevel=" + toolLevel +
                ", hardness=" + hardness +
                ", resistance=" + resistance +
                '}';
    }
}