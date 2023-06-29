package jp.artan.dmlreloaded.plugin.twilight.common;

import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraft.ChatFormatting;
import net.minecraftforge.common.util.NonNullSupplier;

public enum TwilightLivingMatterType implements ILivingMatterType {
    TWILIGHT("twilight", 28, () -> TwilightItemInit.LivingMatter.TWILIGHT::get, ChatFormatting.DARK_PURPLE);

    private final String id;
    private final int exp;
    private final NonNullSupplier<NonNullSupplier<ItemLivingMatter>> livingMatter;
    private final String langId;
    private final ChatFormatting color;

    TwilightLivingMatterType(
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
