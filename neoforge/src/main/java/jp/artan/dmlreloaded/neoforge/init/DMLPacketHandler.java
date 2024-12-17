package jp.artan.dmlreloaded.neoforge.init;

import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.neoforge.network.ServerboundResultingItemPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;


public final class DMLPacketHandler {
    private static final String PROTOCOL_VERSION = "1";

    private DMLPacketHandler() {
    }

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(DeepMobLearningReloadedMod.MOD_ID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    public static void register() {
        int index = 0;
        INSTANCE.messageBuilder(ServerboundResultingItemPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(ServerboundResultingItemPacket::encode).decoder(ServerboundResultingItemPacket::new)
                .consumerMainThread(ServerboundResultingItemPacket::handle).add();
    }
}
