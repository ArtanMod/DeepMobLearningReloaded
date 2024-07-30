package jp.artan.dmlreloaded.forge.item;

import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.forge.container.DeepLearnerContainer;
import jp.artan.dmlreloaded.forge.init.DMLContainersForge;
import jp.artan.dmlreloaded.forge.util.InventoryItemStack;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.util.DataModelLevelupHelper;
import jp.artan.dmlreloaded.util.ItemBackedInventory;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemDeepLearner extends Item {
    protected InventoryItemStack deepLearnerCont;
    public final int internalSlotSize;
    public final int squareSlotSize;

    public ItemDeepLearner(Properties properties, int internalSlotSize) {
        super(properties);
        this.internalSlotSize = internalSlotSize;
        this.squareSlotSize = (int)Math.sqrt(internalSlotSize);

        this.deepLearnerCont = new InventoryItemStack(this.internalSlotSize);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flagIn) {
        if(Screen.hasShiftDown()) {
            list.add(Component.translatable("dmlreloaded.deep_learner.data_model_slots"));
            NonNullList<ItemStack> dataModels = DataModelHelper.getValidFromList(ItemDeepLearner.getContainedItems(stack));
            int count = 0;
            for(ItemStack datamodel : dataModels) {
                if(!datamodel.isEmpty()) {
                    list.add(Component.translatable("%1$s. %2$s", count + 1, datamodel.getItem().getDescription()));
                    count++;
                }
            }
            if(count == 0) {
                list.add(Component.translatable("dmlreloaded.deep_learner.data_model_slots_empty"));
            }
        } else {
            list.add(Component.translatable("dmlreloaded.holdshift", Component.literal("SHIFT").withStyle(t -> t.withColor(ChatFormatting.WHITE).withItalic(true))).withStyle(t -> t.withColor(ChatFormatting.GRAY)));
        }
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable(super.getName(p_41458_).getString()).withStyle(t -> t.withColor(ChatFormatting.AQUA));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(!world.isClientSide) {
            NetworkHooks.openScreen((ServerPlayer) player, new MenuProvider() {

                @Override
                public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
                    return new DeepLearnerContainer(DMLContainersForge.DEEP_LEARNER.get(), windowId, inv, player.getItemInHand(hand));
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
        if(deepLearner.hasTag()) {
            CompoundTag currentTag = deepLearner.getTag();
            if(currentTag.contains("inventory")) {
                ListTag inventory = deepLearner.getTag().getList("inventory", Tag.TAG_COMPOUND);

                for(int i = 0; i < deepLearnerItem.internalSlotSize; i++) {
                    CompoundTag tag = inventory.getCompound(i);
                    list.set(i, ItemStack.of(tag));
                }
            }
        }
        return list;
    }

    public static void setContainedItems(ItemStack deepLearner, NonNullList<ItemStack> list) {
        ListTag inventory = new ListTag();

        for (ItemStack stack : list) {
            CompoundTag tag = new CompoundTag();
            stack.save(tag);
            inventory.add(tag);
        }
        CompoundTag tag = new CompoundTag();
        tag.put("inventory", inventory);
        deepLearner.setTag(tag);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
        return deepLearnerCont;
    }
}
