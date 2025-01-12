package jp.artan.dmlreloaded.neoforge.network;

import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.neoforge.block.entity.BlockEntityExtractionChamber;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundResultingItemPacket(BlockPos pos, ItemStack stack, int index, boolean pSelected) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundResultingItemPacket> TYPE = new CustomPacketPayload.Type<>(DeepMobLearningReloadedMod.getResource("main"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundResultingItemPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundResultingItemPacket::pos,
            ItemStack.STREAM_CODEC, ServerboundResultingItemPacket::stack,
            ByteBufCodecs.VAR_INT, ServerboundResultingItemPacket::index,
            ByteBufCodecs.BOOL, ServerboundResultingItemPacket::pSelected,
            ServerboundResultingItemPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleDataOnMain(final ServerboundResultingItemPacket packet, final IPayloadContext context) {
        final BlockEntity blockEntity = context.player().level().getBlockEntity(packet.pos);
        if (blockEntity instanceof final BlockEntityExtractionChamber eCham) {
            eCham.setResultingItem(packet.stack);
            eCham.setResultingIndex(packet.index);
            eCham.setSelected(packet.pSelected);
            eCham.finishCraft(true);
            eCham.update();
        }
    }
}
