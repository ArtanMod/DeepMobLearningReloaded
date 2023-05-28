package jp.artan.dmlreloaded.block.entity;

import jp.artan.dmlreloaded.util.BaseStackHandler;
import jp.artan.dmlreloaded.util.OutputStackHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class InventoryBlockEntity extends BlockEntity {
    public final int size;
    protected int timer;

    public final BaseStackHandler inventory;
    protected LazyOptional<ItemStackHandler> handler;

    public InventoryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int size, Integer[] arr) {
        super(type, pos, state);
        if (size <= 0) {
            size = 1;
        }

        this.size = size;
        this.inventory = createInventory();
        this.handler = LazyOptional.of(() -> new OutputStackHandler(this.inventory, arr));
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? this.handler.cast() : super.getCapability(cap, side);
    }

//    public LazyOptional<ItemStackHandler> getHandler() {
//        return this.handler;
//    }
//
//    public ItemStack getItemInSlot(int slot) {
//        return this.handler.map(inv -> inv.getStackInSlot(slot)).orElse(ItemStack.EMPTY);
//    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return serializeNBT();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        load(tag);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.handler.invalidate();
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.inventory.deserializeNBT(tag.getCompound("Inventory"));
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(pkt.getTag());
    }

    public void update() {
        requestModelDataUpdate();
        setChanged();
        if (this.level != null) {
            this.level.setBlockAndUpdate(this.worldPosition, getBlockState());
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory", this.inventory.serializeNBT());
    }

    private BaseStackHandler createInventory() {
        return new BaseStackHandler(this.size) {
            @Override
            protected void onContentsChanged(int slot) {
                update();
                super.onContentsChanged(slot);
            }
        };
    }
}
