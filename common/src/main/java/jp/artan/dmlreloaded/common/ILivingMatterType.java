package jp.artan.dmlreloaded.common;

import jp.artan.artansprojectcoremod.utils.inject.NonNullSupplier;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import net.minecraft.ChatFormatting;

public interface ILivingMatterType {
    String getId();
    int getExp();
    NonNullSupplier<ItemLivingMatter> getLivingMatter();
    String getLangId();
    ChatFormatting getColor();
}
