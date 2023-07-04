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
        MobKey.SPIDER.addMob("twilightforest:carminite_broodling", "entity.twilightforest.carminite_broodling");
        MobKey.SPIDER.addMob("twilightforest:hedge_spider", "entity.twilightforest.hedge_spider");
        MobKey.SPIDER.addMob("twilightforest:king_spider", "entity.twilightforest.king_spider");
        MobKey.SPIDER.addMob("twilightforest:swarm_spider", "entity.twilightforest.swarm_spider");

        MobKey.GHAST.addMob("twilightforest:carminite_ghastling", "entity.twilightforest.carminite_ghastling");

        MobKey.SLIME.addMob("twilightforest:maze_slime", "entity.twilightforest.maze_slime");
        MobKey.SLIME.addMob("twilightforest:slime_beetle", "entity.twilightforest.slime_beetle");

        MobKey.SKELETON.addMob("twilightforest:skeleton_druid", "entity.twilightforest.skeleton_druid");
    }
}
