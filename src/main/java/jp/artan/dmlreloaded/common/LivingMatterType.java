package jp.artan.dmlreloaded.common;

import net.minecraft.ChatFormatting;

public enum LivingMatterType implements ILivingMatterType {
    OVERWORLDIAN("overworldian", ChatFormatting.GREEN),
    HELLISH("hellish", ChatFormatting.DARK_RED),
    EXTRATERRESTRIAL("extraterrestrial", ChatFormatting.LIGHT_PURPLE);

    private final String id;
    private final String langId;
    private final ChatFormatting color;
    LivingMatterType(
            String id,
            ChatFormatting color
    ) {
        this.id = id;
        this.langId = "dmlreloaded.living_matter." + id;
        this.color = color;
    }

    @Override
    public String getId() {
        return this.id;
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
