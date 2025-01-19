package jp.artan.dmlreloaded.neoforge;

import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.neoforge.init.*;
import jp.artan.dmlreloaded.neoforge.plugin.PluginInit;
import jp.artan.dmlreloaded.neoforge.providers.*;
import jp.artan.dmlreloaded.neoforge.screen.DeepLearnerScreen;
import jp.artan.dmlreloaded.neoforge.screen.ExtractionChamberScreen;
import jp.artan.dmlreloaded.neoforge.screen.SimulationChamberScreen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(DeepMobLearningReloadedMod.MOD_ID)
public class DeepMobLearningReloadedModNeoForge {

    public DeepMobLearningReloadedModNeoForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus eventBus = ModLoadingContext.get().getActiveContainer().getEventBus();
        DeepMobLearningReloadedMod.init();

        DropModifier.register();
        DMLItemsForge.register();
        DMLBlocksForge.register();
        DMLBlockEntityForge.register();
        DMLMenuType.register();


        eventBus.addListener(DeepMobLearningReloadedModNeoForge::registerProviders);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::onClientSetup);
        eventBus.addListener(this::registerScreens);

        PluginInit.init(eventBus);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        DeepMobLearningReloadedMod.commonSetup();
        event.enqueueWork(DMLPacketHandler::register);
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        DeepMobLearningReloadedMod.initClient();
        event.enqueueWork(() -> {
//            MinecraftForge.EVENT_BUS.register(new DataOverlay(MutableComponent.create(ComponentContents.EMPTY)));
        });
    }

    public void registerScreens(final RegisterMenuScreensEvent event) {
        event.register(DMLMenuType.DEEP_LEARNER_MENU_TYPE.get(), DeepLearnerScreen::new);
        event.register(DMLMenuType.EXTRACTION_CHAMBER_MENU_TYPE.get(), ExtractionChamberScreen::new);
        event.register(DMLMenuType.SIMULATION_CHAMBER_MENU_TYPE.get(), SimulationChamberScreen::new);
    }

    private static void registerProviders(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Model
        generator.addProvider(event.includeClient(), new ModBlockModelProvider(output, DeepMobLearningReloadedMod.MOD_ID, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, DeepMobLearningReloadedMod.MOD_ID, existingFileHelper));

        // LootTable
        generator.addProvider(event.includeServer(), new ModLootTableProvider(output, lookupProvider));

        // Lang
        generator.addProvider(event.includeClient(), new ModUDLanguageProvider(output, DeepMobLearningReloadedMod.MOD_ID));
        generator.addProvider(event.includeClient(), new ModUSLanguageProvider(output, DeepMobLearningReloadedMod.MOD_ID));
        generator.addProvider(event.includeClient(), new ModJPLanguageProvider(output, DeepMobLearningReloadedMod.MOD_ID));

        // Recipe
        generator.addProvider(event.includeClient(), new ModRecipeProvider(output, lookupProvider));

        // Tag
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(output, lookupProvider, DeepMobLearningReloadedMod.MOD_ID, existingFileHelper);
        generator.addProvider(event.includeClient(), blockTagsProvider);
        generator.addProvider(event.includeClient(), new ModItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), DeepMobLearningReloadedMod.MOD_ID, existingFileHelper));

        // Global Loot Modifier
        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(output, lookupProvider, DeepMobLearningReloadedMod.MOD_ID));

        // Patchouli
//        generator.addProvider(event.includeClient(), new ModPatchouliProvider(event.includeClient(), DeepMobLearningReloadedMod.MOD_ID, generator, existingFileHelper));
    }
}