package jp.artan.dmlreloaded.plugin.curios;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.CuriosApi;

public class CuriosPlugin {
    public static final String NAME = CuriosApi.MODID;
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate();

    public static void init(IEventBus modEventBus) {
        modEventBus.addListener(CuriosPlugin::enqueueCompatMessages);
        CuriosPlugin.registerLang();
    }

    public static void enqueueCompatMessages(final InterModEnqueueEvent evt) {
//        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
//                () -> new SlotTypeMessage.Builder("deep_learner")
//                        .size(1)
//                        .icon(new ResourceLocation("curios:slot/empty_deep_learner"))
//                        .build()
//        );
    }

    private static void registerLang() {
        REGISTRATE.addRawLang("curios.identifier.deep_learner", "Deep Learner");
        REGISTRATE.addRawJPLang("curios.identifier.deep_learner", "深層学習装置");
    }
}
