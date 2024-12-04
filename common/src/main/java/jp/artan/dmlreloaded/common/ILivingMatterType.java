package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.util.inject.NonNullSupplier;
import net.minecraft.ChatFormatting;

public interface ILivingMatterType {
    String getId();
    int getExp();
    NonNullSupplier<ItemLivingMatter> getLivingMatter();
    String getLangId();
    ChatFormatting getColor();
}
