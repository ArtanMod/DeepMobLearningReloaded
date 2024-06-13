package jp.artan.dmlreloaded.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class DBLItems {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.BLOCK_REGISTRY);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.ITEM_REGISTRY);

    public static void register() {
        BLOCKS.register();
        ITEMS.register();
    }

    private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> block, CreativeModeTab tab) {
        ResourceLocation id = DeepMobLearningReloadedMod.getResource(name);
        RegistrySupplier<T> registeredBlock = BLOCKS.register(id, block);
        ITEMS.register(id, () -> new BlockItem(registeredBlock.get(), new Item.Properties().tab(tab)));
        return registeredBlock;
    }
}
