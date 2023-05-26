package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.MobKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MobMetaFactory {

    private static List<Function<IMobKey, MobMetaData>> factories = new ArrayList();

    public static MobMetaData createMobMetaData(IMobKey mobKey) {
        MobMetaData meta = null;
        meta = new BlazeMeta(10, 48, 10, 20);
        return meta;
    }

    public static void registerMobMetaDataFactory(Function<IMobKey, MobMetaData> factory) {
        factories.add(factory);
    }
}
