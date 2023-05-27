package jp.artan.dmlreloaded.config;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.common.mobmetas.BlazeMeta;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.HashMap;

public class MobMetaDataConfig {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate();

    private static HashMap<IMobKey, NonNullSupplier<MobMetaData>> mobMobMetaData = new HashMap();

    public static void registerMobMetaData(IMobKey mobKey, NonNullSupplier<MobMetaData> mobMetaData) {
        mobMobMetaData.put(mobKey, mobMetaData);
    }

    public static void register() {
        registerMobMetaData(MobKey.BLAZE, () -> new BlazeMeta(10, 48, 10, 20));
        REGISTRATE.addRawLang(MobMetaData.getMobTriviaLangId(0), "Bring buckets, and watch in despair");
        REGISTRATE.addRawLang(MobMetaData.getMobTriviaLangId(1), "as it evaporates, and everything is on fire");
        REGISTRATE.addRawLang(MobMetaData.getMobTriviaLangId(2), "You are on fire");
//        REGISTRATE.addRawJPLang(MobMetaData.getMobTriviaLangId(0), "バケツを持って来て、絶望して見ている");
//        REGISTRATE.addRawJPLang(MobMetaData.getMobTriviaLangId(1), "それが蒸発し、すべてが燃え上がるのを絶望的に眺める");
//        REGISTRATE.addRawJPLang(MobMetaData.getMobTriviaLangId(2), "君は燃えている");
    }

    public static NonNullSupplier<MobMetaData> getMobMetaData(IMobKey mobKey) {
        return mobMobMetaData.get(mobKey);
    }
}
