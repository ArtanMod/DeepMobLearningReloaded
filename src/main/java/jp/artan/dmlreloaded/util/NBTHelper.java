package jp.artan.dmlreloaded.util;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class NBTHelper {

    public static boolean hasTag(ItemStack item) {
        return item.hasTag();
    }

    public static CompoundTag getTag(ItemStack item) {
        return item.getOrCreateTag();
    }

    public static boolean hasKey(ItemStack item, String key) {
        return hasTag(item) && getTag(item).contains(key);
    }

    public void removeTag(ItemStack item, String key) {
        if(hasKey(item, key)) {
            getTag(item).remove(key);
            if(getTag(item).size() == 0) {
                item.setTag(null);
            }
        }
    }

    public static void setString(ItemStack stack, String key, String val) {
        getTag(stack).putString(key, val);
    }

    public static @Nullable String getString(ItemStack stack, String key, String defaultVal) {
        return hasTag(stack) ? getTag(stack).getString(key) : defaultVal;
    }


    public static void setLong(ItemStack stack, String key, long val) {
        getTag(stack).putLong(key, val);
    }

    public static long getLong(ItemStack stack, String key, long defaultVal) {
        return hasTag(stack) ? getTag(stack).getLong(key) : defaultVal;
    }

    public static void setInt(ItemStack stack, String key, int val) {
        getTag(stack).putInt(key, val);
    }

    public static int getInt(ItemStack stack, String key, int defaultVal) {
        return hasTag(stack) ? getTag(stack).getInt(key) : defaultVal;
    }

    public static boolean getBoolean(ItemStack stack, String key, boolean defaultVal) {
        return hasTag(stack) ? getTag(stack).getBoolean(key) : defaultVal;
    }

    public static void setBoolean(ItemStack stack, String key, boolean value) {
        getTag(stack).putBoolean(key, value);
    }

    public static void setStringList(ItemStack stack, NonNullList<String> list, String key) {
        ListTag stringList = new ListTag();

        int index = 0;
        for (String s : list) {
            CompoundTag tag = new CompoundTag();
            tag.putString(index+"", s);
            stringList.add(tag);
            index++;
        }

        getTag(stack).put(key, stringList);
    }

    public static NonNullList<String> getStringList(ItemStack stack, String key) {
        NonNullList<String> list = NonNullList.create();

        if(stack.hasTag()) {
            ListTag tagList = stack.getTag().getList(key, Tag.TAG_COMPOUND);

            for(int i = 0; i < tagList.size(); i++) {
                CompoundTag tag = tagList.getCompound(i);
                list.add(i, tag.getString(i+""));
            }
        }

        return list;
    }
}
