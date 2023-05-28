package jp.artan.dmlreloaded.container.sync;

import jp.artan.dmlreloaded.block.entity.BlockEntitySimulationChamber;
import net.minecraft.world.inventory.SimpleContainerData;

public class SimulationChamberContainerData extends SimpleContainerData {
    private final BlockEntitySimulationChamber blockEntity;

    public SimulationChamberContainerData(BlockEntitySimulationChamber be, int amount) {
        super(amount);
        this.blockEntity = be;
    }

    @Override
    public int get(int key) {
        return switch (key) {
            case 0 -> this.blockEntity.getProgress();
            case 1 -> this.blockEntity.getEnergy();
            case 2 -> this.blockEntity.energyStorage.getMaxEnergyStored();
            case 3 -> this.blockEntity.getByproductSuccess()? 1 : 0;
            default -> throw new UnsupportedOperationException("Unable to get key: '" + key + "' for block entity: '"
                    + this.blockEntity + "' at pos: '" + this.blockEntity.getBlockPos() + "'");
        };
    }


}
