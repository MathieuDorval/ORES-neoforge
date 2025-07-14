package com.__mathieu.ores.lists;

import com.__mathieu.ores.lists.def.OreDefinition;

import java.util.List;

public class OreList {
    // Autre exemple de nouveau minerai (raw)
    public static final List<OreDefinition> ORES = List.of(
            new OreDefinition("coal", 0, 100, false, "gem", 1, 1, "gem"),     // Le charbon drop du charbon (gem)
            new OreDefinition("iron", 1, 80, true, "ingot", 1, 1, "raw"),     // Le fer drop du fer brut (raw)
            new OreDefinition("gold", 2, 40, true, "ingot", 1, 1, "raw"),     // L'or drop de l'or brut (raw)
            new OreDefinition("diamond", 2, 10, false, "gem", 1, 1, "gem"),     // Le diamant drop une gemme directe
            new OreDefinition("emerald", 2, 5, false, "gem", 1, 1, "gem"),     // L'émeraude drop une gemme directe
            new OreDefinition("lapis", 1, 60, false, "gem", 4, 9, "gem"),     // Le lapis drop des gemmes (4-9)
            new OreDefinition("redstone", 1, 70, false, "dust", 4, 5, "dust"),    // La redstone drop de la poudre (4-5)
            new OreDefinition("copper", 1, 90, true, "ingot", 1, 1, "raw"),     // Le cuivre drop du cuivre brut (raw)
            new OreDefinition("tin", 1, 75, true, "ingot", 1, 1, "raw"),     // Exemple de nouveau minerai (raw)
            new OreDefinition("silver", 2, 30, true, "ingot", 1, 1, "raw"));

    private OreList() {
        // Constructeur privé pour empêcher l'instanciation
    }
}