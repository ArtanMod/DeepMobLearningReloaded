package jp.artan.dmlreloaded.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DataModelConfig {
    public static ForgeConfigSpec.IntValue killMultiplierTier0; // 1;
    public static ForgeConfigSpec.IntValue killMultiplierTier1; // 4;
    public static ForgeConfigSpec.IntValue killMultiplierTier2; // 10;
    public static ForgeConfigSpec.IntValue killMultiplierTier3; // 18;
    public static ForgeConfigSpec.IntValue killsToTier1; // 6;
    public static ForgeConfigSpec.IntValue killsToTier2; // 12;
    public static ForgeConfigSpec.IntValue killsToTier3; // 30;
    public static ForgeConfigSpec.IntValue killsToTier4; // 50;
    public static ForgeConfigSpec.IntValue tier1; //5;
    public static ForgeConfigSpec.IntValue tier2; //11;
    public static ForgeConfigSpec.IntValue tier3; //24;
    public static ForgeConfigSpec.IntValue tier4; //42;

    public static void registerServerConfig(ForgeConfigSpec.Builder SERVER_BUILDER) {
        SERVER_BUILDER.comment("Balance the game mechanics").push("balancing");
        killMultiplierTier0 = SERVER_BUILDER.defineInRange("killMultiplierTier0", 1, 1, 100);
        killMultiplierTier1 = SERVER_BUILDER.defineInRange("killMultiplierTier1", 4, 1, 100);
        killMultiplierTier2 = SERVER_BUILDER.defineInRange("killMultiplierTier2", 10, 1, 100);
        killMultiplierTier3 = SERVER_BUILDER.defineInRange("killMultiplierTier3", 18, 1, 100);
        killsToTier1 = SERVER_BUILDER.defineInRange("killsToTier1", 6, 1, 500);
        killsToTier2 = SERVER_BUILDER.defineInRange("killsToTier2", 12, 1, 500);
        killsToTier3 = SERVER_BUILDER.defineInRange("killsToTier3", 30, 1, 500);
        killsToTier4 = SERVER_BUILDER.defineInRange("killsToTier4", 50, 1, 500);
        tier1 = SERVER_BUILDER.defineInRange("tier1", 5, 1, 100);
        tier2 = SERVER_BUILDER.defineInRange("tier2", 11, 1, 100);
        tier3 = SERVER_BUILDER.defineInRange("tier3", 24, 1, 100);
        tier4 = SERVER_BUILDER.defineInRange("tier4", 42, 1, 100);
        SERVER_BUILDER.pop();
    }
}
