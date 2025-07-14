package com.__mathieu.ores.lists.def;


public class ItemTypeDefinition {
    private final String name;   // Le nom du type (ex: "ingot", "dust")
    private final String prefix; // Le préfixe à ajouter au nom du minerai (ex: "raw")
    private final String suffix; // Le suffixe à ajouter au nom du minerai (ex: "ingot")

    public ItemTypeDefinition(String name, String prefix, String suffix) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
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

    public String getFullName(String oreName) {
        StringBuilder fullName = new StringBuilder();
        if (!prefix.isEmpty()) {
            fullName.append(prefix).append("_");
        }
        fullName.append(oreName);
        if (!suffix.isEmpty()) {
            fullName.append("_").append(suffix);
        }
        return fullName.toString();
    }

    @Override
    public String toString() {
        return "ItemTypeDefinition{" +
                "name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}