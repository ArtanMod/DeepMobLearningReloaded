package jp.artan.dmlreloaded.config;

import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.MobKey;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.HashMap;

public class EnergyCostConfig {
    public static ForgeConfigSpec.IntValue FECOSTEXTRACTIONCHAMBER; //256

    private static HashMap<IMobKey, ForgeConfigSpec.IntValue> mobKeyHashMap = new HashMap();

    /**
     * Mobごとに消費するエネルギーコストを設定する
     * @param mobKey    対象のMobKey
     * @param intValue
     */
    private static void registerMobEnergyCost(IMobKey mobKey, ForgeConfigSpec.IntValue intValue) {
        mobKeyHashMap.put(mobKey, intValue);
    }

    public static void registerServerConfig(ForgeConfigSpec.Builder SERVER_BUILDER) {
        SERVER_BUILDER.comment("Data Model cost (FE/t)").push("data_model");

//        registerMobEnergyCost(MobKey.BLAZE, SERVER_BUILDER.defineInRange("blazeCost", 256, 1, 6666));
//        registerMobEnergyCost(MobKey.CREEPER, SERVER_BUILDER.defineInRange("creeperCost", 80, 1, 6666));
//        registerMobEnergyCost(MobKey.DRAGON, SERVER_BUILDER.defineInRange("dragonCost", 4096, 1, 6666));
        registerMobEnergyCost(MobKey.ELDER_GUARDIAN, SERVER_BUILDER.defineInRange("elderGuardianCost", 2048, 1, 6666));
//        registerMobEnergyCost(MobKey.ENDERMAN, SERVER_BUILDER.defineInRange("endermanCost", 512, 1, 6666));
        registerMobEnergyCost(MobKey.EVOKER, SERVER_BUILDER.defineInRange("evokerCost", 512, 1, 6666));
//        registerMobEnergyCost(MobKey.GHAST, SERVER_BUILDER.defineInRange("ghastCost", 372, 1, 6666));
//        registerMobEnergyCost(MobKey.GUARDIAN, SERVER_BUILDER.defineInRange("guardianCost", 340, 1, 6666));
        registerMobEnergyCost(MobKey.HOGLIN, SERVER_BUILDER.defineInRange("hoglinCost", 512, 1, 6666));
        registerMobEnergyCost(MobKey.MAGMA_CUBE, SERVER_BUILDER.defineInRange("magmaCubeCost", 150, 1, 6666));
        registerMobEnergyCost(MobKey.PHONTOM, SERVER_BUILDER.defineInRange("phontomCost", 512, 1, 6666));
        registerMobEnergyCost(MobKey.PIGLIN, SERVER_BUILDER.defineInRange("piglinCost", 80, 1, 6666));
        registerMobEnergyCost(MobKey.PILLAGER, SERVER_BUILDER.defineInRange("pillagerCost", 80, 1, 6666));
        registerMobEnergyCost(MobKey.RAVAGER, SERVER_BUILDER.defineInRange("ravagerCost", 372, 1, 6666));
//        registerMobEnergyCost(MobKey.SHULKER, SERVER_BUILDER.defineInRange("shulkerCost", 512, 1, 6666));
//        registerMobEnergyCost(MobKey.SKELETON, SERVER_BUILDER.defineInRange("shulkerCost", 80, 1, 6666));
//        registerMobEnergyCost(MobKey.SLIME, SERVER_BUILDER.defineInRange("slimeCost", 150, 1, 6666));
//        registerMobEnergyCost(MobKey.SPIDER, SERVER_BUILDER.defineInRange("spiderCost", 80, 1, 6666));
//        registerMobEnergyCost(MobKey.WITCH, SERVER_BUILDER.defineInRange("witchCost", 120, 1, 6666));
//        registerMobEnergyCost(MobKey.WITHER_SKELETON, SERVER_BUILDER.defineInRange("witherSkeletonCost", 880, 1, 6666));
//        registerMobEnergyCost(MobKey.WITHER, SERVER_BUILDER.defineInRange("witherCost", 2048, 1, 6666));
//        registerMobEnergyCost(MobKey.ZOMBIE, SERVER_BUILDER.defineInRange("zombieCost", 80, 1, 6666));

        FECOSTEXTRACTIONCHAMBER = SERVER_BUILDER.comment("Balance the energy cost of the Loot Fabricator (FE/t)")
                .defineInRange("lootFabricatorCost", 256, 1, 18000);

        SERVER_BUILDER.pop();
    }
}
