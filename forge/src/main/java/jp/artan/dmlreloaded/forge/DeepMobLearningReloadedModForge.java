package jp.artan.dmlreloaded.forge;

import dev.architectury.platform.forge.EventBuses;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.providers.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DeepMobLearningReloadedMod.MOD_ID)
public class DeepMobLearningReloadedModForge {
    public DeepMobLearningReloadedModForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(DeepMobLearningReloadedMod.MOD_ID, eventBus);
        DeepMobLearningReloadedMod.init();
        eventBus.addListener(DeepMobLearningReloadedModForge::registerProviders);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::onClientSetup);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        DeepMobLearningReloadedMod.commonSetup();
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        DeepMobLearningReloadedMod.initClient();
    }

    private static void registerProviders(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Model
        generator.addProvider(event.includeClient(), new ModBlockModelProvider(generator, DeepMobLearningReloadedMod.MOD_ID, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, DeepMobLearningReloadedMod.MOD_ID, existingFileHelper));

        // LootTable
        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator, DeepMobLearningReloadedMod.MOD_ID));

        // Lang
        generator.addProvider(event.includeClient(), new ModUDLanguageProvider(generator, DeepMobLearningReloadedMod.MOD_ID));
        generator.addProvider(event.includeClient(), new ModUSLanguageProvider(generator, DeepMobLearningReloadedMod.MOD_ID));
        generator.addProvider(event.includeClient(), new ModJPLanguageProvider(generator, DeepMobLearningReloadedMod.MOD_ID));

        // Recipe
        generator.addProvider(event.includeClient(), new ModRecipeProvider(generator));

        // Tag
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, DeepMobLearningReloadedMod.MOD_ID, existingFileHelper);
        generator.addProvider(event.includeClient(), blockTagsProvider);
        generator.addProvider(event.includeClient(), new ModItemTagsProvider(generator, blockTagsProvider, DeepMobLearningReloadedMod.MOD_ID, existingFileHelper));
    }
}