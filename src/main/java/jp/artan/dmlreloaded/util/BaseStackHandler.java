package jp.artan.dmlreloaded.util;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

public class BaseStackHandler extends ItemStackHandler{
    int size;
    Runnable slotUpdateListener = () -> {
    };

    public BaseStackHandler(int size) {
        super(size);
        this.size = size;
    }

    public boolean canInsertItem(ItemStack stack) {
        int availableSlots = 0;

        for(int i = 0; i < size; i++) {
            if(getStackInSlot(i).isEmpty()) {
                availableSlots = availableSlots + stack.getMaxStackSize();
            } else if(ItemStack.isSame(getStackInSlot(i), stack)) {
                availableSlots = availableSlots + stack.getMaxStackSize() - getStackInSlot(i).getCount();
            }
        }

        return availableSlots >= stack.getCount();
    }

    public ItemStack setInFirstAvailableSlot(ItemStack stack) {
        ItemStack remainder = ItemStack.EMPTY;

        for(int i = 1; i < size+1; i++) {
            if(getStackInSlot(i).isEmpty()) {
                setStackInSlot(i, stack.copy());
                return remainder;
            } else if(ItemHandlerHelper.canItemStacksStack(getStackInSlot(i), stack) && getStackInSlot(i).getCount() < getStackInSlot(i).getMaxStackSize()) {
                ItemStack itemInSlot = getStackInSlot(i);
                int available = itemInSlot.getMaxStackSize() - itemInSlot.getCount();
                if(stack.getCount() <= available) {
                    itemInSlot.grow(stack.getCount());
                    return remainder;
                } else {
                    int newSize = stack.getCount() - available;
                    itemInSlot.grow(available);
                    return ItemHandlerHelper.copyStackWithSize(stack, newSize);
                }
            }
        }

        return remainder;

    }

    public void registerUpdateListener(Runnable pListener) {
        this.slotUpdateListener = pListener;
    }
}
