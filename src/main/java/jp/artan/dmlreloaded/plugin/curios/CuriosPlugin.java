package jp.artan.dmlreloaded.plugin.curios;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;
import top.theillusivec4.curios.api.CuriosApi;

public class CuriosPlugin {
    public static final String NAME = CuriosApi.MODID;
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate();

    public static void init(IEventBus modEventBus) {
        CuriosPlugin.registerLang();
    }

    private static void registerLang() {
        REGISTRATE.addRawLang("curios.identifier.deep_learner", "Deep Learner");
        REGISTRATE.addRawJPLang("curios.identifier.deep_learner", "深層学習装置");
    }
}
