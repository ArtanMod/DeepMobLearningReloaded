package jp.artan.dmlreloaded.common;

import net.minecraft.ChatFormatting;

public enum LivingMatterType implements ILivingMatterType {
    OVERWORLDIAN("overworldian", 10, ChatFormatting.GREEN),
    HELLISH("hellish", 14, ChatFormatting.DARK_RED),
    EXTRATERRESTRIAL("extraterrestrial", 20, ChatFormatting.LIGHT_PURPLE);

    private final String id;
    private final int exp;
    private final String langId;
    private final ChatFormatting color;
    LivingMatterType(
            String id,
            int exp,
            ChatFormatting color
    ) {
        this.id = id;
        this.exp = exp;
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
    public String getLangId() {
        return this.langId;
    }

    @Override
    public ChatFormatting getColor() {
        return this.color;
    }
}
