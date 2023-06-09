package jp.artan.dmlreloaded.config;

import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.MobKey;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.HashMap;

public class EnergyCostConfig {
    public static ForgeConfigSpec.IntValue FECOSTEXTRACTIONCHAMBER; //256

    public static void registerServerConfig(ForgeConfigSpec.Builder SERVER_BUILDER) {
        SERVER_BUILDER.comment("Data Model cost (FE/t)").push("data_model");

        FECOSTEXTRACTIONCHAMBER = SERVER_BUILDER.comment("Balance the energy cost of the Loot Fabricator (FE/t)")
                .defineInRange("lootFabricatorCost", 256, 1, 18000);

        SERVER_BUILDER.pop();
    }
}
