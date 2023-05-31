package jp.artan.dmlreloaded.container;

import jp.artan.dmlreloaded.block.entity.BlockEntityExtractionChamber;
import jp.artan.dmlreloaded.container.slots.SlotExtractionChamber;
import jp.artan.dmlreloaded.container.sync.ExtractionChamberContainerData;
import jp.artan.dmlreloaded.init.BlockInit;
import jp.artan.dmlreloaded.init.ContainerInit;
import jp.artan.dmlreloaded.util.BaseStackHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class ExtractionChamberContainer extends AbstractContainerMenu{

    private final ContainerLevelAccess containerAccess;
    public final ContainerData data;
    public BaseStackHandler handler;
    public static final int PRISTINE_SLOT = 0;
    public BlockPos pos;

    // Client
    public ExtractionChamberContainer(MenuType<?> menuType, int id, Inventory playerInv, FriendlyByteBuf buf) {
        this(menuType, id, playerInv, new BaseStackHandler(17), buf.readBlockPos(), new SimpleContainerData(5));
    }

    // Server
    public ExtractionChamberContainer(MenuType<?> menuType, int pContainerId, Inventory pInventory, BaseStackHandler handler, BlockPos pPos, ContainerData data) {
        super(menuType, pContainerId);
        this.handler = handler;
        this.containerAccess = ContainerLevelAccess.create(pInventory.player.level, pPos);
        this.data = data;
        this.pos = pPos;
        addInventorySlots(pInventory);
        addSlotsToHandler(handler);
        addDataSlots(data);
    }

    private void addInventorySlots(Inventory playerInv) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                int x = 8 + column * 18;
                int y = 119 + row * 18;
                int index = column + row * 9 + 9;
                Slot slot = new Slot(playerInv, index, x, y);
                addSlot(slot);
            }
        }
        // Bind actionbar
        for (int row = 0; row < 9; row++) {
            Slot slot = new Slot(playerInv, row, 8 + row * 18, 177);
            addSlot(slot);
        }
    }

    private void addSlotsToHandler(IItemHandler handler) {
        addSlot(new SlotExtractionChamber(handler, PRISTINE_SLOT, 81, 62));
        int index = 1;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                int x = 102 + column * 18;
                int y = 7 + row * 18;
                Slot slot = new SlotExtractionChamber(handler, index, x, y);
                addSlot(slot);
                index++;
            }
        }
    }



    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = getSlot(index);
        if (slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if (index < 36) {
                if (!moveItemStackTo(item, 36, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(item, 0, 36, false)) {
                return ItemStack.EMPTY;
            }

            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else
                slot.setChanged();
        }
        return retStack;
    }

    public ItemStack getPristine() {
        return handler.getStackInSlot(PRISTINE_SLOT);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(this.containerAccess, pPlayer, BlockInit.EXTRACTION_CHAMBER.get());
    }

    public static MenuConstructor getServerContainer(BlockEntityExtractionChamber be, BlockPos pos) {
        return (id, playerInv, player) -> new ExtractionChamberContainer(ContainerInit.EXTRACTION_CHAMBER.get(), id, playerInv, be.inventory, pos,
                new ExtractionChamberContainerData(be, 5));
    }
}
