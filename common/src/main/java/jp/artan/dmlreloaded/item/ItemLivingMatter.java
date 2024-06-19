package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.common.ILivingMatterType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemLivingMatter extends Item {

    private final ILivingMatterType type;

    public ItemLivingMatter(Properties properties, ILivingMatterType type) {
        super(properties);
        this.type = type;
    }

    public ILivingMatterType getType() {
        return type;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> list, TooltipFlag flag) {
        list.add(Component.translatable("dmlreloaded.living_matter.exp_consume", Component.literal("(Right-Click)").withStyle(t -> t.withColor(ChatFormatting.WHITE)).withStyle(t -> t.withColor(ChatFormatting.GRAY))));
        list.add(Component.translatable("dmlreloaded.living_matter.exp_consume_stack", Component.literal("SHIFT").withStyle(t -> t.withColor(ChatFormatting.WHITE))).withStyle(t -> t.withColor(ChatFormatting.GRAY)));
        list.add(Component.translatable("dmlreloaded.living_matter.exp", Component.literal(Integer.toString(getType().getExp())).withStyle(t -> t.withColor(ChatFormatting.GREEN))));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(!world.isClientSide()) {
            int exp = getType().getExp();
            if(player.isCrouching()) {
                int size = player.getItemInHand(hand).getCount();
                player.getItemInHand(hand).shrink(size);
                player.giveExperiencePoints(exp * size);
            } else {
                player.getItemInHand(hand).shrink(1);
                player.giveExperiencePoints(exp);
            }
        }
        return super.use(world, player, hand);
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable(super.getName(p_41458_).getString()).withStyle(t -> t.withColor(getType().getColor()));
    }
}
