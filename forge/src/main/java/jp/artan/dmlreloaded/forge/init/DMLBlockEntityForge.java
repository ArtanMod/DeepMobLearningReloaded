package jp.artan.dmlreloaded.forge.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.block.entity.BlockEntityExtractionChamber;
import jp.artan.dmlreloaded.forge.block.entity.BlockEntitySimulationChamber;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class DMLBlockEntityForge {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    public static void register() {
        BLOCK_ENTITIES.register();
    }

    public static final RegistrySupplier<BlockEntityType<BlockEntitySimulationChamber>> ENTITY_SIMULATION_CHAMBER = BLOCK_ENTITIES.register("simulation_chamber",
            () -> BlockEntityType.Builder.of(BlockEntitySimulationChamber::new, DMLBlocksForge.SIMULATION_CHAMBER.get()).build(null));

    public static final RegistrySupplier<BlockEntityType<BlockEntityExtractionChamber>> ENTITY_EXTRACTION_CHAMBER = BLOCK_ENTITIES.register("extraction_chamber",
            () -> BlockEntityType.Builder.of(BlockEntityExtractionChamber::new, DMLBlocksForge.EXTRACTION_CHAMBER.get()).build(null));

}
