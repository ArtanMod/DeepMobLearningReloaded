package jp.artan.dmlreloaded.forge.plugin.DeeperAndDarker.common;

import jp.artan.dmlreloaded.util.inject.NonNullSupplier;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.forge.plugin.DeeperAndDarker.init.DMLIntegrationDADItems;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import net.minecraft.ChatFormatting;

public enum DeeperAndDarkerLivingMatterType implements ILivingMatterType {
    DEEPER_AND_DARKER("deeperdarker", 56, () -> DMLIntegrationDADItems.LIVING_MATTER_DEEPER_AND_DARKER::get, ChatFormatting.AQUA);

    private final String id;
    private final int exp;
    private final NonNullSupplier<NonNullSupplier<ItemLivingMatter>> livingMatter;
    private final String langId;
    private final ChatFormatting color;

    DeeperAndDarkerLivingMatterType(
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
