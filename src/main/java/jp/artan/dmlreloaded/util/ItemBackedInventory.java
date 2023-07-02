package jp.artan.dmlreloaded.util;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ItemBackedInventory extends SimpleContainer {
    private static final String TAG_ITEMS = "inventory";
    private final Object stack;


    //Item
    public ItemBackedInventory(Object tempObj, int expectedSize) {
        super(expectedSize);

        if(tempObj instanceof ItemStack iStack) {
            ListTag lst = iStack.getOrCreateTag().getList(TAG_ITEMS, Tag.TAG_COMPOUND);
            int i = 0;
            for (; i < expectedSize && i < lst.size(); i++) {
                setItem(i, ItemStack.of(lst.getCompound(i)));
            }
            this.stack = iStack;
        } else if(tempObj instanceof BlockEntity bEntity) {
            ListTag lst = bEntity.getPersistentData().getList(TAG_ITEMS, Tag.TAG_COMPOUND);
            int i = 0;
            for (; i < expectedSize && i < lst.size(); i++) {
                setItem(i, ItemStack.of(lst.getCompound(i)));
            }
            this.stack = bEntity;
        } else{
            this.stack = null;
        }

    }

    public void setItemsIn() {
        ListTag list = new ListTag();
        for (int i = 0; i < getContainerSize(); i++) {
            list.add(getItem(i).save(new CompoundTag()));
        }
        if(stack instanceof ItemStack iStack) {
            iStack.getOrCreateTag().put(TAG_ITEMS, list);
        } else if(stack instanceof BlockEntity bEntity) {
            bEntity.getPersistentData().put(TAG_ITEMS, list);
        }

    }

    @Override
    public void setChanged() {
        super.setChanged();
        setItemsIn();
    }
}
