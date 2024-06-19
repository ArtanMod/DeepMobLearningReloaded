package jp.artan.dmlreloaded;

import jp.artan.dmlreloaded.config.Config;
import jp.artan.dmlreloaded.init.DMLItems;
import jp.artan.dmlreloaded.init.DMLBlockEntities;
import jp.artan.dmlreloaded.init.DMLBlocks;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.resources.ResourceLocation;

public class DeepMobLearningReloadedMod {
    public static final String MOD_ID = "dmlreloaded";

    // Minecraft logic
    public static final int TICKS_TO_SECOND = 20;

    // Internal inventory sizes
    public static final int DEEP_LEARNER_INTERNAL_SLOTS_SIZE = 4;
    public static final int NETHERITE_DEEP_LEARNER_INTERNAL_SLOTS_SIZE = 9;

    // Data model max tier
    public static final int DATA_MODEL_MAXIMUM_TIER = 4;

    public static void init() {
        Config.init();
        DMLCreativeTab.register();
        DMLItems.register();
        DMLBlocks.register();
        DMLBlockEntities.register();
    }

    public static void commonSetup() {
    }

    public static void initClient() {
        DMLBlockEntities.initClient();
    }

    public static ResourceLocation getResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
