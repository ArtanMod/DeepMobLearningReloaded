package jp.artan.dmlreloaded.container;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.init.ContainerInit;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemDeepLearner;
import jp.artan.dmlreloaded.util.ItemBackedInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class DeepLearnerContainer extends AbstractContainerMenu {

    protected Player player;
    protected InteractionHand usedHand;
    protected ItemStack deepLearner;
    public final Container deepLearnerInv;

    public static DeepLearnerContainer fromNetwork(MenuType<?> menuType, int windowId, Inventory inv, FriendlyByteBuf buf) {
        InteractionHand hand = buf.readBoolean() ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        return new DeepLearnerContainer(menuType, windowId, inv, inv.player.getItemInHand(hand));
    }

    //Server
    public DeepLearnerContainer(MenuType<?> menuType, int id, Inventory playerInv, ItemStack deepLearner) {
        super(menuType, id);
        ContainerLevelAccess.create(playerInv.player.level, BlockPos.ZERO);
        this.player = playerInv.player;
        this.usedHand = player.getMainHandItem().getItem() instanceof ItemDeepLearner ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        ItemStack heldItem = player.getMainHandItem().getItem() instanceof ItemDeepLearner ? player.getMainHandItem() : player.getOffhandItem();
        this.deepLearner = heldItem;

        this.deepLearner = deepLearner;
        if (!playerInv.player.level.isClientSide) {
            deepLearnerInv = ItemDeepLearner.getInventory(deepLearner);
        } else {
            deepLearnerInv = new ItemBackedInventory(deepLearner, DeepMobLearningReloaded.DEEP_LEARNER_INTERNAL_SLOTS_SIZE);
        }

        addInventorySlots();
        addDataModelSlots();
    }

    private void addDataModelSlots() {
        int index = 0;
        for(int column = 0; column < 2; column++){
            for(int row = 0; row < 2; row++){
                addSlot(new Slot(deepLearnerInv, index, 193- (row*18), 82 - (column*18)) {
                    @Override
                    public boolean mayPlace(ItemStack stack)
                    {
                        return !stack.isEmpty() && stack.getItem() instanceof ItemDataModel;
                    }
                    @Override
                    public int getMaxStackSize() {
                        return 1;
                    }
                });
                index++;
            }
        }
    }

    private void addInventorySlots() {

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                int x = 8 + column * 18;
                int y = 119 + row * 18;
                int index = column + row * 9 + 9;
                Slot slot = new Slot(player.getInventory(), index, x, y);
                addSlot(slot);
            }
        }
        // Bind actionbar
        for (int row = 0; row < 9; row++) {
            Slot slot = new Slot(player.getInventory(), row, 8 + row * 18, 177);
            addSlot(slot);
        }
    }

    @Override
    public boolean stillValid(Player player) {
        if(player.getMainHandItem().getItem() == ItemInit.DEEP_LEARNER.get()) {
            return true;
        }
        else if(player.getOffhandItem().getItem() == ItemInit.DEEP_LEARNER.get()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = getSlot(index);
        if(slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if(index < 36) {
                if(!moveItemStackTo(item, 36, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if(!moveItemStackTo(item, 0, 36, false)) {
                return ItemStack.EMPTY;
            }

            if(item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }
            else slot.setChanged();
        }
        return retStack;
    }

    public Container getDeepInv() {
        return deepLearnerInv;
    }
}
