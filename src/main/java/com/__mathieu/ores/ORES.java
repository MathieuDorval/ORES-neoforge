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

import com.__mathieu.ores.registries.ModBlocks;
import com.__mathieu.ores.registries.ModItems;
import com.__mathieu.ores.registries.ModCreativeTabs;


@Mod(ORES.MODID)
public class ORES {
    public static final String MODID = "ores";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ORES(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP - ORES Mod Loaded!");

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