package jp.artan.dmlreloaded.neoforge.item;

import jp.artan.dmlreloaded.neoforge.container.DeepLearnerContainer;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.neoforge.util.ItemBackedInventory;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemDeepLearner extends Item {
    public final int internalSlotSize;
    public final int squareSlotSize;

    public ItemDeepLearner(Properties properties, int internalSlotSize) {
        super(properties.component(DataComponents.CONTAINER, ItemContainerContents.fromItems(NonNullList.withSize(internalSlotSize, ItemStack.EMPTY))));
        this.internalSlotSize = internalSlotSize;
        this.squareSlotSize = (int)Math.sqrt(internalSlotSize);

    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            NonNullList<ItemStack> dataModels = DataModelHelper.getValidFromList(ItemDeepLearner.getContainedItems(stack));
            if(dataModels.isEmpty()) {
                tooltipComponents.add(Component.translatable("dmlreloaded.deep_learner.data_model_slots_empty"));
            } else {
                tooltipComponents.add(Component.translatable("dmlreloaded.deep_learner.data_model_slots"));
                for(int i = 0; i < dataModels.size(); i++) {
                    tooltipComponents.add(Component.translatable("%1$s. %2$s", i + 1, dataModels.get(i).getItem().getDescription()));
                }
            }
        } else {
            tooltipComponents.add(Component.translatable("dmlreloaded.holdshift", Component.literal("SHIFT").withStyle(t -> t.withColor(ChatFormatting.WHITE).withItalic(true))).withStyle(t -> t.withColor(ChatFormatting.GRAY)));
        }
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable(super.getName(p_41458_).getString()).withStyle(t -> t.withColor(ChatFormatting.AQUA));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(!world.isClientSide) {
            player.openMenu(new MenuProvider() {

                @Override
                public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
                    return new DeepLearnerContainer(windowId, inv, player.getItemInHand(hand));
                }

                @Override
                public Component getDisplayName() {
                    return player.getItemInHand(hand).getDisplayName();
                }
            }, buf -> buf.writeBoolean(hand == InteractionHand.MAIN_HAND));
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }


    public static SimpleContainer getInventory(ItemStack deepLearner) {
        ItemDeepLearner deepLearnerItem = (ItemDeepLearner) deepLearner.getItem();
        return new ItemBackedInventory(deepLearner, deepLearnerItem.internalSlotSize) {
            @Override
            public boolean canPlaceItem(int slot, @Nonnull ItemStack stack) {
                return isValid(slot, stack);
            }
        };
    }

    public static boolean isValid(int slot, ItemStack stack) {
        Item itm = stack.getItem();
        if (slot < 9) {
            return itm instanceof ItemDeepLearner;
        } else {
            return false;
        }
    }

    public static NonNullList<ItemStack> getContainedItems(ItemStack deepLearner) {
        ItemDeepLearner deepLearnerItem = (ItemDeepLearner) deepLearner.getItem();
        NonNullList<ItemStack> list = NonNullList.withSize(deepLearnerItem.internalSlotSize, ItemStack.EMPTY);
        ItemContainerContents contents = deepLearner.get(DataComponents.CONTAINER);
        if(contents != null) {
            for(int i = 0; i < deepLearnerItem.internalSlotSize; i++) {
                list.set(i, contents.getStackInSlot(i));
            }
        }
        return list;
    }

    public static void setContainedItems(ItemStack deepLearner, NonNullList<ItemStack> list) {
        deepLearner.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(list));
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
