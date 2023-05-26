package jp.artan.dmlreloaded.util;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.config.DataModelConfig;

public class DataModelLevelupHelper {
    private static final int[] killMultiplier = {
            DataModelConfig.killMultiplierTier0.get(),
            DataModelConfig.killMultiplierTier1.get(),
            DataModelConfig.killMultiplierTier2.get(),
            DataModelConfig.killMultiplierTier3.get(),
            0 // Max tier, no kill multiplier
    };

    private static final int[] maxExperience = {
            DataModelConfig.killsToTier1.get() * killMultiplier[0],
            DataModelConfig.killsToTier2.get() * killMultiplier[1],
            DataModelConfig.killsToTier3.get() * killMultiplier[2],
            DataModelConfig.killsToTier4.get() * killMultiplier[3],
    };

    /* tier is CURRENT tier, kc is kill count for CURRENT tier, sc is simulation count for CURRENT  tier */
    public static boolean shouldIncreaseTier(int tier, int kc, int sc) {
        if(tier == DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            return false;
        }
        int roof = maxExperience[tier];
        int killExperience = kc * killMultiplier[tier];

        return killExperience + sc >= roof;
    }

    public static double getCurrentTierKillCountWithSims(int tier, int kc, int sc) {
        if(tier == DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            return 0;
        }
        return kc + ((double) sc / killMultiplier[tier]);
    }

    public static int getCurrentTierSimulationCountWithKills(int tier, int kc, int sc) {
        if(tier == DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            return 0;
        }
        return sc + (kc * killMultiplier[tier]);
    }

    public static double getKillsToNextTier(int tier, int kc, int sc) {
        if(tier == DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            return 0;
        }
        int killRoof = getTierRoof(tier, true);
        return killRoof - getCurrentTierKillCountWithSims(tier, kc, sc);
    }

    public static int getSimulationsToNextTier(int tier, int kc, int sc) {
        if(tier == DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            return 0;
        }
        int roof = getTierRoof(tier, false);
        return roof - getCurrentTierSimulationCountWithKills(tier, kc, sc);
    }

    public static int getTierRoof(int tier, boolean asKills) {
        if(tier == DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            return 0;
        }
        if(!asKills) {
            return maxExperience[tier];
        } else {
            return maxExperience[tier] / killMultiplier[tier];
        }
    }

    public static int getKillMultiplier(int tier) {
        return killMultiplier[tier];
    }
}
