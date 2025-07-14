package com.__mathieu.ores;

import com.__mathieu.ores.registries.BlockRegistry;
import com.__mathieu.ores.registries.CreativeTabs;
import com.__mathieu.ores.registries.ItemRegistry;
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




@Mod(ORES.MODID)
public class ORES {
    public static final String MODID = "ores"; //
    public static final Logger LOGGER = LogUtils.getLogger(); //

    public ORES(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup); //

        // Enregistrement des items, blocs et onglets
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        BlockRegistry.ITEMS.register(modEventBus); // Ne pas oublier les items des blocs !
        CreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this); //

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC); //
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP -- ORES Mod Loaded! --"); //

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO FROM SERVER STARTING -- ORES Mod! --"); //
    }
}