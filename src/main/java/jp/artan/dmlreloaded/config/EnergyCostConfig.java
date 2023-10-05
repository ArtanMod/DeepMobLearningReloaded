package jp.artan.dmlreloaded.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class EnergyCostConfig {
    public static ForgeConfigSpec.IntValue FECOSTEXTRACTIONCHAMBER; //256

    public static void registerServerConfig(ForgeConfigSpec.Builder SERVER_BUILDER) {
        SERVER_BUILDER.comment("Data Model cost (FE/t)").push("data_model");

        FECOSTEXTRACTIONCHAMBER = SERVER_BUILDER.comment("Balance the energy cost of the Loot Fabricator (FE/t)")
                .defineInRange("lootFabricatorCost", 256, 1, 18000);

        SERVER_BUILDER.pop();
    }
}
