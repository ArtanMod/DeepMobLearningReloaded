package jp.artan.dmlreloaded.util;


import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import java.util.Arrays;
import java.util.List;

public class OutputStackHandler extends ItemStackHandler{

    private final BaseStackHandler internal;
    private List<Integer> blockedSlots;

    public OutputStackHandler(BaseStackHandler handler, Integer[] arr) {
        super();
        this.internal = handler;
        this.blockedSlots = Arrays.asList(arr);
    }

    @Override
    public void setSize(int size) {
        stacks = NonNullList.<ItemStack>withSize(size, ItemStack.EMPTY);
    }

    @Override
    public void setStackInSlot(int slot, ItemStack stack) {
        internal.setStackInSlot(slot, stack);
    }

    @Override
    public int getSlots() {
        return internal.getSlots();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return internal.getStackInSlot(slot);
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        return internal.insertItem(slot, stack, simulate);
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        for(Integer inter : blockedSlots) {
            if(inter.equals(slot)) {
                return ItemStack.EMPTY;
            }
        }
        return internal.extractItem(slot, amount, simulate);

    }
}
