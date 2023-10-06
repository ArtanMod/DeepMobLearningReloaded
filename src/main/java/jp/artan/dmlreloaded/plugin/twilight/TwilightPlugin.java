package jp.artan.dmlreloaded.plugin.twilight;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraftforge.eventbus.api.IEventBus;

public class TwilightPlugin {
    public static final String NAME = "twilightforest";

    public static void init(IEventBus modEventBus) {
        TwilightItemInit.register();
        registerMobKey();
    }

    public static void registerMobKey() {
        MobKey.SPIDER.addMob("entity.twilightforest.carminite_broodling");
        MobKey.SPIDER.addMob("entity.twilightforest.hedge_spider");
        MobKey.SPIDER.addMob("entity.twilightforest.king_spider");
        MobKey.SPIDER.addMob("entity.twilightforest.swarm_spider");

        MobKey.GHAST.addMob("entity.twilightforest.carminite_ghastling");

        MobKey.SLIME.addMob("entity.twilightforest.maze_slime");
        MobKey.SLIME.addMob("entity.twilightforest.slime_beetle");

        MobKey.SKELETON.addMob("entity.twilightforest.skeleton_druid");
    }
}
