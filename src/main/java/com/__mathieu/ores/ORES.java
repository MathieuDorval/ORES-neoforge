// src/main/java/com/__mathieu/ores/ORES.java
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

import com.__mathieu.ores.core.ModItems;

@Mod(ORES.MODID)
public class ORES {
    public static final String MODID = "ores";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final net.neoforged.neoforge.registries.DeferredRegister.Blocks BLOCKS = net.neoforged.neoforge.registries.DeferredRegister.createBlocks(MODID);


    public ORES(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ModItems.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP - ORES Mod Loaded!");

        // Logs pour vérifier les items enregistrés via ModItems
        ModItems.ALL_UNIFIED_ITEMS.forEach((key, deferredItem) -> {
            LOGGER.info("Verified registered Unified Item: {}:{}", MODID, key);
        });
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting - ORES Mod!");
    }
}