package jp.artan.dmlreloaded.neoforge.providers;

import jp.artan.dmlreloaded.neoforge.init.DMLBlocksForge;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockStateProvider {

    public ModBlockModelProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile machineCasing = this.models().cubeAll("machine_casing", this.modLoc("block/machine_base_up"));
        this.simpleBlock(DMLBlocksForge.MACHINE_CASING.get(), machineCasing);
        this.simpleBlockItem(DMLBlocksForge.MACHINE_CASING.get(), machineCasing);

        ModelFile simulationChamber = this.models().getExistingFile(this.modLoc("block/simulation_chamber"));
        this.getVariantBuilder(DMLBlocksForge.SIMULATION_CHAMBER.get())
                .forAllStates(state -> {
                    return ConfiguredModel.builder()
                            .modelFile(simulationChamber)
                            .rotationY((((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180)) % 360)
                            .build();
                });
        this.simpleBlockItem(DMLBlocksForge.SIMULATION_CHAMBER.get(), simulationChamber);

        ModelFile extractionChamber = this.models().getExistingFile(this.modLoc("block/extraction_chamber"));
        this.getVariantBuilder(DMLBlocksForge.EXTRACTION_CHAMBER.get())
                .forAllStates(state -> {
                    return ConfiguredModel.builder()
                            .modelFile(extractionChamber)
                            .rotationY((((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180)) % 360)
                            .build();
                });
        this.simpleBlockItem(DMLBlocksForge.EXTRACTION_CHAMBER.get(), extractionChamber);

        ModelFile infusedIngotBlock = this.models().cubeAll("infused_ingot_block", this.modLoc("block/infused_ingot_blockface"));
        this.simpleBlock(DMLBlocksForge.INFUSED_INGOT_BLOCK.get(), infusedIngotBlock);
        this.simpleBlockItem(DMLBlocksForge.INFUSED_INGOT_BLOCK.get(), infusedIngotBlock);
    }
}
