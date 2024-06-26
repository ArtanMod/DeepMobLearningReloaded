package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractBlockModelProvider;
import jp.artan.dmlreloaded.forge.init.DMLBlocksForge;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends AbstractBlockModelProvider {

    public ModBlockModelProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile machineCasing = this.models().cubeAll("machine_casing", this.modLoc("block/machine_base_up"));
        this.simpleBlock(DMLBlocksForge.MACHINE_CASING.get(), machineCasing);

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
    }
}
