package jp.artan.dmlreloaded;

import net.minecraft.resources.ResourceLocation;

public class DeepMobLearningReloadedMod {
    public static final String MOD_ID = "dmlreloaded";

    public static void init() {

    }

    public static void initClient() {
    }

    public static ResourceLocation getResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
