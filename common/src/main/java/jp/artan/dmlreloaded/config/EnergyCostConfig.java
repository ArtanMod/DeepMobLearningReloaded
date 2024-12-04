package jp.artan.dmlreloaded.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;

public class EnergyCostConfig extends ModConfigs {
    private static final EnergyCostConfig config = new EnergyCostConfig();

    public static ConfigEntry<Integer> efCostExtractionChamber;

    protected EnergyCostConfig() {
        super(DeepMobLearningReloadedMod.MOD_ID + "/energy_cost.toml");
    }

    @Override
    protected void read(CommentedFileConfig commentedFileConfig) {
        efCostExtractionChamber = ModConfigs.defineEntry("efCostExtractionChamber", commentedFileConfig, 256, 1, 18000)
                .comment("Balance the energy cost of the Loot Fabricator (FE/t)");
    }

    public static void init() {
        EnergyCostConfig.config.read();
    }
}
