package jp.artan.dmlreloaded.forge.plugin.curios;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;

public class CuriosPlugin {
    public static final String NAME = CuriosApi.MODID;

    public static void init(IEventBus modEventBus) {
        modEventBus.addListener(CuriosPlugin::enqueueCompatMessages);
    }

    public static void enqueueCompatMessages(final InterModEnqueueEvent evt) {
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                () -> new SlotTypeMessage.Builder("deep_learner")
                        .size(1)
                        .icon(new ResourceLocation("curios:slot/empty_deep_learner"))
                        .build()
        );
    }
}
