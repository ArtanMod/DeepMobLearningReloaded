package jp.artan.dmlreloaded.init;

import dev.architectury.registry.registries.DeferredRegister;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class DMLBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    public static void register() {
        BLOCK_ENTITIES.register();
    }

    public static void initClient() {
    }
}
