package jp.artan.dmlreloaded.common;

import net.minecraft.ChatFormatting;

public enum LivingMatterType implements ILivingMatterType {
    OVERWORLDIAN("overworldian", ChatFormatting.GREEN),
    HELLISH("hellish", ChatFormatting.DARK_RED),
    EXTRATERRESTRIAL("extraterrestrial", ChatFormatting.LIGHT_PURPLE);

    private final String type;
    private final ChatFormatting color;
    LivingMatterType(
            String type,
            ChatFormatting color
    ) {
        this.type = type;
        this.color = color;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public ChatFormatting getColor() {
        return this.color;
    }
}
