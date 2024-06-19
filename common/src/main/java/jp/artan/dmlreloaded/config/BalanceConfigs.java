package jp.artan.dmlreloaded.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import jp.artan.artansprojectcoremod.config.ModConfigs;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;

public class BalanceConfigs extends ModConfigs {
    private static final BalanceConfigs config = new BalanceConfigs();

    public static ConfigEntry<Boolean> isGlitchArmorCreativeFlightEnabled;
    public static ConfigEntry<Boolean> isGlitchArmorExtraDropsEnabled;

    protected BalanceConfigs() {
        super(DeepMobLearningReloadedMod.MOD_ID + "/balance.toml");
    }

    @Override
    protected void read(CommentedFileConfig commentedFileConfig) {
        isGlitchArmorCreativeFlightEnabled = ModConfigs.defineEntry("isGlitchArmorCreativeFlightEnabled", commentedFileConfig, true)
                .comment("If true, the Glitch Armor will allow creative flight.");
        isGlitchArmorExtraDropsEnabled = ModConfigs.defineEntry("isGlitchArmorExtraDropsEnabled", commentedFileConfig, true)
                .comment("If true, the Glitch Armor will drop extra items when breaking blocks.");
    }

    public static void init() {
        BalanceConfigs.config.read();
    }
}
