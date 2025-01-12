package jp.artan.dmlreloaded.neoforge.init;

import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.neoforge.network.ServerboundResultingItemPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = DeepMobLearningReloadedMod.MOD_ID)
public final class DMLPacketHandler {
    private static final String PROTOCOL_VERSION = "1";

    private DMLPacketHandler() {
    }

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playBidirectional(
                ServerboundResultingItemPacket.TYPE,
                ServerboundResultingItemPacket.STREAM_CODEC,
                new MainThreadPayloadHandler<>(ServerboundResultingItemPacket::handleDataOnMain)
        );
    }
}
