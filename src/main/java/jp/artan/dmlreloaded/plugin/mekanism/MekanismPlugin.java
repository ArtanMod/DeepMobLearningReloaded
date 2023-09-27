package jp.artan.dmlreloaded.plugin.mekanism;

import jp.artan.dmlreloaded.common.MobKey;
import net.minecraftforge.eventbus.api.IEventBus;

public class MekanismPlugin {
    public static final String NAME = "mekanismadditions";

    public static void init(IEventBus modEventBus) {
        registerMobKey();
    }

    private static void registerMobKey() {
        MobKey.CREEPER.addMob("entity.mekanismadditions.baby_creeper");

        MobKey.ENDERMAN.addMob("entity.mekanismadditions.baby_enderman");

        MobKey.SKELETON.addMob("entity.mekanismadditions.baby_skeleton");
        MobKey.SKELETON.addMob("entity.mekanismadditions.baby_stray");

        MobKey.WITHER_SKELETON.addMob("entity.mekanismadditions.baby_wither_skeleton");
    }
}
