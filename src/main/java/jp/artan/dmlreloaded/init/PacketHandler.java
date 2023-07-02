package jp.artan.dmlreloaded.init;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.network.ServerboundResultingItemPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;


public final class PacketHandler {
    private static final String PROTOCOL_VERSION = "1";

    private PacketHandler() {
    }

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    public static void register() {
        int index = 0;
        INSTANCE.messageBuilder(ServerboundResultingItemPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(ServerboundResultingItemPacket::encode).decoder(ServerboundResultingItemPacket::new)
                .consumerMainThread(ServerboundResultingItemPacket::handle).add();
    }
}
