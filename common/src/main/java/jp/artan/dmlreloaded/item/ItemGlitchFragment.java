package jp.artan.dmlreloaded.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemGlitchFragment extends Item {

    // FIXME: GlitchFragmentからGlitchIngotを作成するレシピを追加する

    public ItemGlitchFragment(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> list, TooltipFlag flagIn) {
        list.add(Component.translatable("dmlreloaded.hover_text.glitch_fragment_1", Component.translatable("item.dmlreloaded.glitch_heart").withStyle(t->t.withColor(ChatFormatting.AQUA))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
        list.add(Component.translatable("dmlreloaded.hover_text.glitch_fragment_2", Component.literal(new ItemStack(Items.OBSIDIAN).getHoverName().getString()).withStyle(t->t.withColor(ChatFormatting.DARK_PURPLE))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
        list.add(Component.translatable("dmlreloaded.hover_text.glitch_fragment_3").withStyle(t->t.withColor(ChatFormatting.GRAY)));
        list.add(Component.translatable("dmlreloaded.hover_text.glitch_fragment_4").withStyle(t->t.withColor(ChatFormatting.GRAY)));
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable(super.getName(p_41458_).getString()).withStyle(t->t.withColor(ChatFormatting.AQUA));
    }
}
