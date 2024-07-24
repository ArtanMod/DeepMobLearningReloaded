package jp.artan.dmlreloaded.forge;

import dev.architectury.platform.forge.EventBuses;
import jp.artan.artansprojectcoremod.forge.providers.RegistratePatchouliProvider;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.init.*;
import jp.artan.dmlreloaded.forge.plugin.PluginInit;
import jp.artan.dmlreloaded.forge.providers.*;
import jp.artan.dmlreloaded.forge.screen.DataOverlay;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;

@Mod(DeepMobLearningReloadedMod.MOD_ID)
public class DeepMobLearningReloadedModForge {
    public DeepMobLearningReloadedModForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(DeepMobLearningReloadedMod.MOD_ID, eventBus);
        DeepMobLearningReloadedMod.init();

        DropModifier.GLM.register(eventBus);

        DMLItemsForge.register();
        DMLBlocksForge.register();
        DMLBlockEntityForge.register();
        DMLContainersForge.register();


        eventBus.addListener(DeepMobLearningReloadedModForge::registerProviders);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::onClientSetup);

        PluginInit.init(eventBus);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        DeepMobLearningReloadedMod.commonSetup();
        event.enqueueWork(DMLPacketHandler::register);
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        DeepMobLearningReloadedMod.initClient();
        event.enqueueWork(() -> {
            MinecraftForge.EVENT_BUS.register(new DataOverlay(MutableComponent.create(ComponentContents.EMPTY)));
        });
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
        generator.addProvider(event.includeServer(), new ModLootTableProvider(output, DeepMobLearningReloadedMod.MOD_ID));

        // Lang
        generator.addProvider(event.includeClient(), new ModUDLanguageProvider(output, DeepMobLearningReloadedMod.MOD_ID));
        generator.addProvider(event.includeClient(), new ModUSLanguageProvider(output, DeepMobLearningReloadedMod.MOD_ID));
        generator.addProvider(event.includeClient(), new ModJPLanguageProvider(output, DeepMobLearningReloadedMod.MOD_ID));

        // Recipe
        generator.addProvider(event.includeClient(), new ModRecipeProvider(output));

        // Tag
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(output, lookupProvider, DeepMobLearningReloadedMod.MOD_ID, existingFileHelper);
        generator.addProvider(event.includeClient(), blockTagsProvider);
        generator.addProvider(event.includeClient(), new ModItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), DeepMobLearningReloadedMod.MOD_ID, existingFileHelper));

        // Global Loot Modifier
        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(output, DeepMobLearningReloadedMod.MOD_ID));

        // Patchouli
        generator.addProvider(event.includeClient(), new ModPatchouliProvider(event.includeClient(), DeepMobLearningReloadedMod.MOD_ID, generator, existingFileHelper));
    }
}