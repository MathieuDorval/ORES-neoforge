package com.__mathieu.ores;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(ORES.MODID)
public class ORES {
    public static final String MODID = "ores";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ORES(IEventBus modEventBus, ModContainer modContainer) {
        // Enregistre la méthode 'commonSetup' pour l'événement de chargement du mod
        modEventBus.addListener(this::commonSetup);

        // Enregistre cette classe pour les événements généraux du jeu (comme le démarrage du serveur)
        NeoForge.EVENT_BUS.register(this);

        // Enregistre la configuration du mod
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP -- ORES Mod Loaded! --");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO FROM SERVER STARTING -- ORES Mod! --");
    }
}