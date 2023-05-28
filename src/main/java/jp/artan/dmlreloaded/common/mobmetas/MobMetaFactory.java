package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.IMobKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MobMetaFactory {

    private static List<Function<IMobKey, MobMetaData>> factories = new ArrayList();

    public static MobMetaData createMobMetaData(IMobKey mobKey) {
        return mobKey.getMobMetaData().get();
    }

    public static void registerMobMetaDataFactory(Function<IMobKey, MobMetaData> factory) {
        factories.add(factory);
    }
}
