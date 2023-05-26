package jp.artan.dmlreloaded.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static void register() {
        registerClientConfigs();
        registerServerConfigs();
        registerCommonConfigs();
    }

    private static void registerClientConfigs() {
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    }

    private static void registerServerConfigs() {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        DataModelConfig.registerServerConfig(SERVER_BUILDER);
        EnergyCostConfig.registerServerConfig(SERVER_BUILDER);
        LivingExpConfig.registerServerConfig(SERVER_BUILDER);
    }

    private static void registerCommonConfigs() {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        MobConfig.registerCommonConfig(COMMON_BUILDER);
    }
}
