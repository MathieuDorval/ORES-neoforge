// src/main/java/com/__mathieu/ores/ORES.java (Modifié)
package com.__mathieu.ores;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// Importations des classes de registre (assurez-vous des chemins de package corrects)
import com.__mathieu.ores.registries.ModBlocks;
import com.__mathieu.ores.registries.ModItems;
// import com.__mathieu.ores.registries.ModCreativeTabs; // Commenté car Creative Tabs sont mis de côté pour l'instant


// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ORES.MODID)
public class ORES {
    public static final String MODID = "ores";
    public static final Logger LOGGER = LogUtils.getLogger();

    // Le DeferredRegister.Blocks n'est plus nécessaire ici, il est géré par ModBlocks
    // public static final net.neoforged.neoforge.registries.DeferredRegister.Blocks BLOCKS = net.neoforged.neoforge.registries.DeferredRegister.createBlocks(MODID);


    public ORES(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Enregistrement des Deferred Registers des classes dédiées
        ModBlocks.register(modEventBus);     // Enregistre les blocs et leurs BlockItems via ModBlocks
        ModItems.register(modEventBus);      // Enregistre les items dérivés via ModItems
        // ModCreativeTabs.register(modEventBus); // Réactiver si vous voulez les Creative Tabs

        // modEventBus.addListener(this::addCreative); // Réactiver si vous ajoutez à des onglets vanilla

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP - ORES Mod Loaded!");

        // Logs pour vérifier les enregistrements des blocs et des items
        ModBlocks.ALL_UNIFIED_ORE_BLOCKS.forEach((key, deferredBlock) -> {
            LOGGER.info("Verified registered Ore Block: {}:{}", MODID, key);
        });
        ModItems.DERIVED_ITEMS.forEach((key, deferredItem) -> {
            LOGGER.info("Verified registered Derived Item: {}:{}", MODID, key);
        });
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting - ORES Mod!");
    }
}