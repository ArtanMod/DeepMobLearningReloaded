package jp.artan.dmlreloaded.util;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

public class InventoryItemStack extends ItemStackHandler implements ICapabilityProvider {
    public final int size;
    protected int timer;
    protected boolean requiresUpdate;

    public final ItemStackHandler inventory;
    protected LazyOptional<ItemStackHandler> handler;

    public InventoryItemStack(int pSize) {
        this.size = pSize;
        this.inventory = createInventory();
        this.handler = LazyOptional.of(()-> this.inventory);
    }

    private ItemStackHandler createInventory() {
        return new ItemStackHandler(this.size) {
            @Override
            public ItemStack extractItem(int slot, int amount, boolean simulate) {
                return super.extractItem(slot, amount, simulate);
            }
            @Override
            public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == ForgeCapabilities.ITEM_HANDLER ? this.handler.cast() : LazyOptional.empty();
    }
}
