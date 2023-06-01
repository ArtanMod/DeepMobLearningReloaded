package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.item.ItemLivingMatter;
import net.minecraft.ChatFormatting;
import net.minecraftforge.common.util.NonNullSupplier;

public interface ILivingMatterType {
    String getId();
    int getExp();
    NonNullSupplier<ItemLivingMatter> getLivingMatter();
    String getLangId();
    ChatFormatting getColor();
}
