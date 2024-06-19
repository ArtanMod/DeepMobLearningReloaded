package jp.artan.dmlreloaded.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ItemSootedRedstone extends Item {

    public ItemSootedRedstone(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("dmlreloaded.hover_text.soot_covered_redstone_1", Component.literal(new ItemStack(Items.REDSTONE).getHoverName().getString()).withStyle(t->t.withColor(ChatFormatting.RED))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
        list.add(Component.translatable("dmlreloaded.hover_text.soot_covered_redstone_2", Component.literal(new ItemStack(Items.COAL_BLOCK).getHoverName().getString()).withStyle(t->t.withColor(ChatFormatting.WHITE))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
    }
}

