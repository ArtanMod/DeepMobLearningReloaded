package jp.artan.dmlreloaded;

import com.mojang.logging.LogUtils;
import jp.artan.dmlreloaded.config.Config;
import jp.artan.dmlreloaded.config.MobMetaDataConfig;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.init.*;
import jp.artan.dmlreloaded.provider.ModGlobalLootModifierProvider;
import jp.artan.dmlreloaded.screen.DataOverlay;
import jp.artan.repack.registrate.util.nullness.NonNullSupplier;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DeepMobLearningReloaded.MOD_ID)
public class DeepMobLearningReloaded {
    public static final String MOD_ID = "dmlreloaded";

    // Minecraft logic
    public static final int TICKS_TO_SECOND = 20;

    // Internal inventory sizes
    public static final int DEEP_LEARNER_INTERNAL_SLOTS_SIZE = 4;

    // Data model max tier
    public static final int DATA_MODEL_MAXIMUM_TIER = 4;

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final NonNullSupplier<DeepMobLearningReloadedRegistrate> REGISTRATE = DeepMobLearningReloadedRegistrate.lazy(MOD_ID);

    public DeepMobLearningReloaded() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        DropModifier.GLM.register(modEventBus);

        modEventBus.addListener(this::registerProviders);
        modEventBus.addListener(this::onFMLClientSetup);

        Config.register();
        MobMetaDataConfig.register();

        ContainerInit.register();
        ItemGroupInit.register();
        ItemInit.register();
        BlockInit.register();
    }

    public static ResourceLocation getResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static DeepMobLearningReloadedRegistrate registrate() {
        return REGISTRATE.get();
    }

    public void onFMLClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MinecraftForge.EVENT_BUS.register(new DataOverlay(TextComponent.EMPTY));
        });
    }

    void registerProviders(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        if(event.includeServer()) {
            gen.addProvider(new ModGlobalLootModifierProvider(gen, MOD_ID));
        }
    }
}
