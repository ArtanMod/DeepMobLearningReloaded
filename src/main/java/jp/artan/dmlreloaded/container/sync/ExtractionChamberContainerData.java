package jp.artan.dmlreloaded.container.sync;

import jp.artan.dmlreloaded.block.entity.BlockEntityExtractionChamber;
import net.minecraft.world.inventory.SimpleContainerData;

public class ExtractionChamberContainerData extends SimpleContainerData {
    private final BlockEntityExtractionChamber blockEntity;

    public ExtractionChamberContainerData(BlockEntityExtractionChamber be, int amount) {
        super(amount);
        this.blockEntity = be;
    }

    @Override
    public int get(int key) {
        return switch (key) {
            case 0 -> this.blockEntity.getProgress();
            case 1 -> this.blockEntity.getEnergy();
            case 2 -> this.blockEntity.energyStorage.getMaxEnergyStored();
            case 3 -> this.blockEntity.getResultingIndex();
            case 4 -> this.blockEntity.isSelected() ? 1 : 0;
            default -> throw new UnsupportedOperationException("Unable to get key: '" + key + "' for block entity: '"
                    + this.blockEntity + "' at pos: '" + this.blockEntity.getBlockPos() + "'");
        };
    }

}

