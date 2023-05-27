package jp.artan.dmlreloaded.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BalanceConfigs {

    public static ForgeConfigSpec.BooleanValue isGlitchArmorCreativeFlightEnabled; //true
    public static ForgeConfigSpec.BooleanValue isGlitchArmorExtraDropsEnabled; //true
    public static ForgeConfigSpec.BooleanValue isSootedRedstoneCraftingEnabled; // true;

    public static void registerServerConfig(ForgeConfigSpec.Builder SERVER_BUILDER) {
        SERVER_BUILDER.comment("Balance the game mechanics").push("balancing");
        isGlitchArmorCreativeFlightEnabled = SERVER_BUILDER.define("isGlitchArmorCreativeFlightEnabled", true);
        isGlitchArmorExtraDropsEnabled = SERVER_BUILDER.define("isGlitchArmorExtraDropsEnabled", true);
        isSootedRedstoneCraftingEnabled = SERVER_BUILDER.comment("Not advised to make false. Datapack for diffrent recipes must be written in order for mod to work correctly")
                .define("sootedRedstoneCraftingEnabled", true);
        SERVER_BUILDER.pop();
    }
}
