package jp.artan.dmlreloaded;

import jp.artan.dmlreloaded.config.Config;
import jp.artan.dmlreloaded.init.DBLItems;
import jp.artan.dmlreloaded.init.DMLBlockEntities;
import jp.artan.dmlreloaded.init.DMLBlocks;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.resources.ResourceLocation;

public class DeepMobLearningReloadedMod {
    public static final String MOD_ID = "dmlreloaded";

    public static void init() {
        Config.init();
        DMLCreativeTab.register();
        DBLItems.register();
        DMLBlocks.register();
        DMLBlockEntities.register();
    }

    public static void commonSetup() {
    }

    public static void initClient() {
        DMLBlockEntities.initClient();
    }

    public static ResourceLocation getResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
