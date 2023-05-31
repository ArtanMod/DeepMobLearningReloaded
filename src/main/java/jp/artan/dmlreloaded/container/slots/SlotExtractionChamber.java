package jp.artan.dmlreloaded.container.slots;

import jp.artan.dmlreloaded.container.ExtractionChamberContainer;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotExtractionChamber extends SlotItemHandler{

    public SlotExtractionChamber(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        Item item = stack.getItem();
        switch(getSlotIndex()) {
            case ExtractionChamberContainer.PRISTINE_SLOT:
                return !stack.isEmpty() && item instanceof ItemPristineMatter;
            default:
                return false;
        }
    }
}
