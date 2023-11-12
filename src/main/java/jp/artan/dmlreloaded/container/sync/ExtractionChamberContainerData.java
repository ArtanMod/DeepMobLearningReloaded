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
        System.out.println(this.blockEntity.energyStorage.getEnergyStored() + " / " + this.blockEntity.energyStorage.getMaxEnergyStored());
        return switch (key) {
            case 0 -> this.blockEntity.getProgress();
            case 1 -> this.blockEntity.getResultingIndex();
            case 2 -> this.blockEntity.isSelected() ? 1 : 0;
            case 3 -> this.blockEntity.energyStorage.getEnergyStored() & 0x0000FFFF;
            case 4 -> (this.blockEntity.energyStorage.getEnergyStored() & 0xFFFF0000) >> 16;
            case 5 -> this.blockEntity.energyStorage.getMaxEnergyStored() & 0x0000FFFF;
            case 6 -> (this.blockEntity.energyStorage.getMaxEnergyStored() & 0xFFFF0000) >> 16;
            default -> throw new UnsupportedOperationException("Unable to get key: '" + key + "' for block entity: '"
                    + this.blockEntity + "' at pos: '" + this.blockEntity.getBlockPos() + "'");
        };
    }
}

