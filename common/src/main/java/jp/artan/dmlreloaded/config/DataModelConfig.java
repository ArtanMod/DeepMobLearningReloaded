package jp.artan.dmlreloaded.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import jp.artan.artansprojectcoremod.config.ModConfigs;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;

public class DataModelConfig extends ModConfigs {
    private static final DataModelConfig config = new DataModelConfig();
    public static ConfigEntry<Integer> killMultiplierTier0; // 1;
    public static ConfigEntry<Integer> killMultiplierTier1; // 4;
    public static ConfigEntry<Integer> killMultiplierTier2; // 10;
    public static ConfigEntry<Integer> killMultiplierTier3; // 18;
    public static ConfigEntry<Integer> killsToTier1; // 6;
    public static ConfigEntry<Integer> killsToTier2; // 12;
    public static ConfigEntry<Integer> killsToTier3; // 30;
    public static ConfigEntry<Integer> killsToTier4; // 50;
    public static ConfigEntry<Integer> tier1; //5;
    public static ConfigEntry<Integer> tier2; //11;
    public static ConfigEntry<Integer> tier3; //24;
    public static ConfigEntry<Integer> tier4; //42;

    protected DataModelConfig() {
        super(DeepMobLearningReloadedMod.MOD_ID + "/data_model.toml");
    }

    @Override
    protected void read(CommentedFileConfig commentedFileConfig) {
        killMultiplierTier0 = ModConfigs.defineEntry("killMultiplierTier0", commentedFileConfig, 1, 1, 100)
                .comment("The kill multiplier for Tier 0.");
        killMultiplierTier1 = ModConfigs.defineEntry("killMultiplierTier1", commentedFileConfig, 4, 1, 100)
                .comment("The kill multiplier for Tier 1.");
        killMultiplierTier2 = ModConfigs.defineEntry("killMultiplierTier2", commentedFileConfig, 10, 1, 100)
                .comment("The kill multiplier for Tier 2.");
        killMultiplierTier3 = ModConfigs.defineEntry("killMultiplierTier3", commentedFileConfig, 18, 1, 100)
                .comment("The kill multiplier for Tier 3.");
        killsToTier1 = ModConfigs.defineEntry("killsToTier1", commentedFileConfig, 6, 1, 500)
                .comment("The number of kills required to reach Tier 1.");
        killsToTier2 = ModConfigs.defineEntry("killsToTier2", commentedFileConfig, 12, 1, 500)
                .comment("The number of kills required to reach Tier 2.");
        killsToTier3 = ModConfigs.defineEntry("killsToTier3", commentedFileConfig, 30, 1, 500)
                .comment("The number of kills required to reach Tier 3.");
        killsToTier4 = ModConfigs.defineEntry("killsToTier4", commentedFileConfig, 50, 1, 500)
                .comment("The number of kills required to reach Tier 4.");
        tier1 = ModConfigs.defineEntry("tier1", commentedFileConfig, 5, 1, 100)
                .comment("The number of kills required to reach Tier 1.");
        tier2 = ModConfigs.defineEntry("tier2", commentedFileConfig, 11, 1, 100)
                .comment("The number of kills required to reach Tier 2.");
        tier3 = ModConfigs.defineEntry("tier3", commentedFileConfig, 24, 1, 100)
                .comment("The number of kills required to reach Tier 3.");
        tier4 = ModConfigs.defineEntry("tier4", commentedFileConfig, 42, 1, 100)
                .comment("The number of kills required to reach Tier 4.");
    }

    public static void init() {
        DataModelConfig.config.read();
    }
}
