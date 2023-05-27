package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.config.BalanceConfigs;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemGlitchIngot extends Item{

    public ItemGlitchIngot(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> list, TooltipFlag flagIn) {
        if(BalanceConfigs.isSootedRedstoneCraftingEnabled.get()) {
            list.add(new TranslatableComponent("dmlreloaded.hover_text.glitchingot_1", new TranslatableComponent("item.dmlreforged.glitch_heart").withStyle(t->t.withColor(ChatFormatting.AQUA))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
            list.add(new TranslatableComponent("dmlreloaded.hover_text.more_info").withStyle(t->t.withColor(ChatFormatting.GRAY)));
        }
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return new TranslatableComponent(super.getName(p_41458_).getString()).withStyle(t -> t.withColor(ChatFormatting.AQUA));
    }
}