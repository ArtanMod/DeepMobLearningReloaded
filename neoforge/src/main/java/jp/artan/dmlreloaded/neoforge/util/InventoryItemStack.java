package jp.artan.dmlreloaded.neoforge.util;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import net.neoforged.neoforge.common.util.Lazy;

public class InventoryItemStack extends ItemStackHandler implements ICapabilityProvider {
    public final int size;
    protected int timer;
    protected boolean requiresUpdate;

    public final ItemStackHandler inventory;
    protected Lazy<ItemStackHandler> handler;

    public InventoryItemStack(int pSize) {
        this.size = pSize;
        this.inventory = createInventory();
        this.handler = Lazy.of(()-> this.inventory);
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

    @Nullable
    @Override
    public Object getCapability(Object object, Object object2) {
        return null;
    }
}
