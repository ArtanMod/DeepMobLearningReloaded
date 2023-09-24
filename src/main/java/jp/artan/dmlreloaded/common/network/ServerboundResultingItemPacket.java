package jp.artan.dmlreloaded.common.network;

import jp.artan.dmlreloaded.block.entity.BlockEntityExtractionChamber;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ServerboundResultingItemPacket {

    public final ItemStack stack;
    public final BlockPos bPos;
    public final int index;
    public final boolean selected;

    public ServerboundResultingItemPacket(BlockPos pos, ItemStack stack, int index, boolean pSelected) {
        this.bPos = pos;
        this.stack = stack;
        this.index = index;
        this.selected = pSelected;
    }

    public ServerboundResultingItemPacket(FriendlyByteBuf buffer) {
        this(buffer.readBlockPos(), buffer.readItem(), buffer.readInt(), buffer.readBoolean());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeBlockPos(this.bPos);
        buffer.writeItem(this.stack);
        buffer.writeInt(this.index);
        buffer.writeBoolean(this.selected);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            final BlockEntity blockEntity = ctx.get().getSender().level().getBlockEntity(this.bPos);
            if (blockEntity instanceof final BlockEntityExtractionChamber eCham) {
                eCham.setResultingItem(this.stack);
                eCham.setResultingIndex(this.index);
                eCham.setSelected(selected);
                eCham.finishCraft(true);
                eCham.update();
            }
        });

        ctx.get().setPacketHandled(true);
    }
}
