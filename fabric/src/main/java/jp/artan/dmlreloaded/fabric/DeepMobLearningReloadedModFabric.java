package jp.artan.dmlreloaded.fabric;

import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import net.fabricmc.api.ModInitializer;

public class DeepMobLearningReloadedModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        DeepMobLearningReloadedMod.init();
        DeepMobLearningReloadedMod.initClient();
    }
}