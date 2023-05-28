package jp.artan.dmlreloaded.addon;

import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.config.EnergyCostConfig;
import jp.artan.dmlreloaded.config.LivingExpConfig;
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
     * @param energyCost  マターで生産するときに消費するエネルギー量
     */
    public static void registerMob(
            IMobKey mobKey,
            ForgeConfigSpec.ConfigValue<List<? extends String>> mobs,
            ForgeConfigSpec.ConfigValue<List<? extends String>> loot,
            ForgeConfigSpec.IntValue energyCost
    ) {
        MobConfig.registerMobConfig(mobKey, mobs, loot);
        EnergyCostConfig.registerMobEnergyCost(mobKey, energyCost);
    }

    /**
     * 新しいLivingExpを追加
     *
     * @param livingMatterType 新しいLivingExpの種別
     * @param getExp           モブを倒したときに取得できる経験値の量
     */
    public static void registerLivingExp(
            ILivingMatterType livingMatterType,
            ForgeConfigSpec.IntValue getExp
    ) {
        LivingExpConfig.registerLivingMatterType(livingMatterType, getExp);
    }
}
