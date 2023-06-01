package jp.artan.dmlreloaded.addon;

import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.config.EnergyCostConfig;
import jp.artan.dmlreloaded.config.MobConfig;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

/**
 * 本MODのアドオンで新しいDataModelやLivingExpを追加するためのヘルパークラス
 */
public class AddonHelper {

    /**
     * 新しいDataModelを追加
     *
     * @param mobKey      新しいモブ種別
     * @param mobs        対象とするモブのEntityID
     * @param loot        マターから生産されるアイテムリスト
     */
    public static void registerMob(
            IMobKey mobKey,
            ForgeConfigSpec.ConfigValue<List<? extends String>> mobs,
            ForgeConfigSpec.ConfigValue<List<? extends String>> loot
    ) {
        MobConfig.registerMobConfig(mobKey, mobs, loot);
    }
}
