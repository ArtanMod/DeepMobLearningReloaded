package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.container.DeepLearnerContainer;
import jp.artan.dmlreloaded.init.ContainerInit;
import jp.artan.dmlreloaded.util.InventoryItemStack;
import jp.artan.dmlreloaded.util.ItemBackedInventory;
import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
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
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

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
    public Component getName(ItemStack p_41458_) {
        return new TranslatableComponent(super.getName(p_41458_).getString()).withStyle(t -> t.withColor(ChatFormatting.AQUA));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(!world.isClientSide) {
            NetworkHooks.openGui((ServerPlayer) player, new MenuProvider() {

                @Override
                public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
                    return new DeepLearnerContainer(ContainerInit.DEEP_LEARNER.get(), windowId, inv, player.getItemInHand(hand));
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
