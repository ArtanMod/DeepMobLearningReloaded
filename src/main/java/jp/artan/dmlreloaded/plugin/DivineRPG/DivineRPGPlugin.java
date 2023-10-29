package jp.artan.dmlreloaded.plugin.DivineRPG;

import jp.artan.dmlreloaded.common.MobKey;
import net.minecraftforge.eventbus.api.IEventBus;

public class DivineRPGPlugin {
    public static final String NAME = "divinerpg";

    public static void init(IEventBus modEventBus) {
        registerMobKey();
    }

    private static void registerMobKey() {
        MobKey.ENDERMAN.addMob("entity.divinerpg.ender_spider");
        MobKey.ENDERMAN.addMob("entity.divinerpg.ender_scrounge");
        MobKey.ENDERMAN.addMob("entity.divinerpg.ender_triplets");
        MobKey.ENDERMAN.addMob("entity.divinerpg.ender_watcher");

        MobKey.SPIDER.addMob("entity.divinerpg.hell_spider");
        MobKey.SPIDER.addMob("entity.divinerpg.jungle_spider");
        MobKey.SPIDER.addMob("entity.divinerpg.ender_spider");
        MobKey.SPIDER.addMob("entity.divinerpg.pumpkin_spider");
        MobKey.SPIDER.addMob("entity.divinerpg.soul_spider");
    }
}
