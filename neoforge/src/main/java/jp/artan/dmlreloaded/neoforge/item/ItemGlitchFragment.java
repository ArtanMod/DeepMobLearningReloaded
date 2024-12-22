package jp.artan.dmlreloaded.neoforge.item;

import jp.artan.dmlreloaded.neoforge.item.entity.ItemEntityGlitchFragment;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemGlitchFragment extends Item {

    public ItemGlitchFragment(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("dmlreloaded.hover_text.glitch_fragment_1", Component.translatable("item.dmlreloaded.glitch_heart").withStyle(t->t.withColor(ChatFormatting.AQUA))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
        tooltipComponents.add(Component.translatable("dmlreloaded.hover_text.glitch_fragment_2", Component.literal(new ItemStack(Items.OBSIDIAN).getHoverName().getString()).withStyle(t->t.withColor(ChatFormatting.DARK_PURPLE))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
        tooltipComponents.add(Component.translatable("dmlreloaded.hover_text.glitch_fragment_3").withStyle(t->t.withColor(ChatFormatting.GRAY)));
        tooltipComponents.add(Component.translatable("dmlreloaded.hover_text.glitch_fragment_4").withStyle(t->t.withColor(ChatFormatting.GRAY)));
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable(super.getName(p_41458_).getString()).withStyle(t->t.withColor(ChatFormatting.AQUA));
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Entity createEntity(Level level, Entity location, ItemStack stack) {
        return new ItemEntityGlitchFragment(level, location.position().x, location.position().y, location.position().z, new ItemStack(this, stack.getCount()), location.getDeltaMovement().x(), location.getDeltaMovement().y(), location.getDeltaMovement().z());
    }
}
