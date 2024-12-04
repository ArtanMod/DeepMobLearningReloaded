package jp.artan.dmlreloaded;

import jp.artan.dmlreloaded.config.Config;
import jp.artan.dmlreloaded.events.EntityDeathHandler;
import jp.artan.dmlreloaded.events.PlayerHandler;
import jp.artan.dmlreloaded.init.DMLItems;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import jp.artan.dmlreloaded.init.DMLRecipeSerializer;
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
        DMLRecipeSerializer.register();
        EntityDeathHandler.register();
    }

    public static void commonSetup() {
    }

    public static void initClient() {
        PlayerHandler.register();
    }

    public static ResourceLocation getResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
