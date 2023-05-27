package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.config.BalanceConfigs;
import jp.artan.dmlreloaded.item.entity.ItemEntityGlitchFragment;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
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
    public void appendHoverText(ItemStack stack, Level world, List<Component> list, TooltipFlag flagIn) {
        if(BalanceConfigs.isSootedRedstoneCraftingEnabled.get()) {
            list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_fragment_1", new TranslatableComponent("item.dmlreloaded.glitch_heart").withStyle(t->t.withColor(ChatFormatting.AQUA))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
            list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_fragment_2", new TextComponent(new ItemStack(Items.OBSIDIAN).getHoverName().getString()).withStyle(t->t.withColor(ChatFormatting.DARK_PURPLE))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
            list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_fragment_3").withStyle(t->t.withColor(ChatFormatting.GRAY)));
            list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_fragment_4").withStyle(t->t.withColor(ChatFormatting.GRAY)));
        }
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return new TranslatableComponent(super.getName(p_41458_).getString()).withStyle(t -> t.withColor(ChatFormatting.AQUA));
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Entity createEntity(Level level, Entity location, ItemStack stack) {
        ItemEntity result = new ItemEntityGlitchFragment(level, location.position().x, location.position().y, location.position().z, new ItemStack(this, stack.getCount()), location.getDeltaMovement().x(), location.getDeltaMovement().y(), location.getDeltaMovement().z());
        return result;
    }

}
