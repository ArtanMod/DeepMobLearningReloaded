package jp.artan.dmlreloaded.container.slots;

import jp.artan.dmlreloaded.container.SimulationChamberContainer;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.item.ItemDataModel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotSimulationChamber extends SlotItemHandler{

    public SlotSimulationChamber(IItemHandler handler, int index, int xPosition, int yPosition) {
        super(handler, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        Item item = stack.getItem();
        switch(getSlotIndex()) {
            case SimulationChamberContainer.DATA_MODEL_SLOT:
                return !stack.isEmpty() && item instanceof ItemDataModel;
            case SimulationChamberContainer.POLYMER_SLOT:
                return !stack.isEmpty() && item == ItemInit.POLYMER_CLAY.get();
            case SimulationChamberContainer.LIVING_SLOT:
                return false;
            case SimulationChamberContainer.PRISTINE_SLOT:
                return false;
            default:
                return false;
        }
    }
}

