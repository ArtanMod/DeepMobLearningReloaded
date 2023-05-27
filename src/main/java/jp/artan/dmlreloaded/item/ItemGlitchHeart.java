package jp.artan.dmlreloaded.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemGlitchHeart extends Item {

    public ItemGlitchHeart(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> list, TooltipFlag flagIn) {
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_heart").withStyle(t->t.withColor(ChatFormatting.GRAY)));
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return new TranslatableComponent(super.getName(p_41458_).getString()).withStyle(t -> t.withColor(ChatFormatting.AQUA));
    }
}
