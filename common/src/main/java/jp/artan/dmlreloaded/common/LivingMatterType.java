package jp.artan.dmlreloaded.common;

import jp.artan.artansprojectcoremod.utils.inject.NonNullSupplier;
import jp.artan.dmlreloaded.init.DMLItems;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import net.minecraft.ChatFormatting;

public enum LivingMatterType implements ILivingMatterType {
    OVERWORLDIAN("overworldian", 10, () -> DMLItems.LIVING_MATTER_OVERWORLDIAN::get, ChatFormatting.GREEN),
    HELLISH("hellish", 14, () -> DMLItems.LIVING_MATTER_HELLISH::get, ChatFormatting.DARK_RED),
    EXTRATERRESTRIAL("extraterrestrial", 20, () -> DMLItems.LIVING_MATTER_EXTRATERRESTRIAL::get, ChatFormatting.LIGHT_PURPLE);

    private final String id;
    private final int exp;
    private final NonNullSupplier<NonNullSupplier<ItemLivingMatter>> livingMatter;
    private final String langId;
    private final ChatFormatting color;
    LivingMatterType(
            String id,
            int exp,
            NonNullSupplier<NonNullSupplier<ItemLivingMatter>> livingMatter,
            ChatFormatting color
    ) {
        this.id = id;
        this.exp = exp;
        this.livingMatter = livingMatter;
        this.langId = "dmlreloaded.living_matter." + id;
        this.color = color;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getExp() {
        return this.exp;
    }

    @Override
    public NonNullSupplier<ItemLivingMatter> getLivingMatter() {
        return this.livingMatter.get();
    }

    @Override
    public String getLangId() {
        return this.langId;
    }

    @Override
    public ChatFormatting getColor() {
        return this.color;
    }
}
