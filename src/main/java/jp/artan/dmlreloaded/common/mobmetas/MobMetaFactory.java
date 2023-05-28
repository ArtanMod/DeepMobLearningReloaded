package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.config.MobMetaDataConfig;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MobMetaFactory {

    private static List<Function<IMobKey, MobMetaData>> factories = new ArrayList();

    public static MobMetaData createMobMetaData(IMobKey mobKey) {
        MobMetaData meta = null;
        try {
            NonNullSupplier<MobMetaData> func = MobMetaDataConfig.getMobMetaData(mobKey);
            meta = func.get();
        } catch(Exception e) {
//            TODO: zombieをデフォルトとする
            meta = MobMetaDataConfig.getMobMetaData(MobKey.BLAZE).get();
        }
        return meta;
    }

    public static void registerMobMetaDataFactory(Function<IMobKey, MobMetaData> factory) {
        factories.add(factory);
    }
}
