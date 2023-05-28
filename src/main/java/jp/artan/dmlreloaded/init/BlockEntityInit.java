package jp.artan.dmlreloaded.init;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.block.entity.BlockEntitySimulationChamber;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BET = DeferredRegister.create(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, DeepMobLearningReloaded.MOD_ID);

    public static final RegistryObject<BlockEntityType<BlockEntitySimulationChamber>> ENTITY_SIMULATION_CHAMBER = BET.register("simulation_chamber",
            () -> BlockEntityType.Builder.of(BlockEntitySimulationChamber::new, BlockInit.SIMULATION_CHAMBER.get()).build(null));

    public static void register() {

    }
}
