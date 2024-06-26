package jp.artan.dmlreloaded.forge.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.block.BlockExtractionChamber;
import jp.artan.dmlreloaded.forge.block.BlockSimulationChamber;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class DMLBlocksForge {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.BLOCK_REGISTRY);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.ITEM_REGISTRY);

    public static void register() {
        BLOCKS.register();
        ITEMS.register();
    }

    public static final RegistrySupplier<Block> MACHINE_CASING = register("machine_casing", () -> new Block(Block.Properties.of(Material.STONE)));
    public static final RegistrySupplier<BlockSimulationChamber> SIMULATION_CHAMBER = register("simulation_chamber", () -> new BlockSimulationChamber(Block.Properties.of(Material.STONE).strength(4f, 3000.0f).lightLevel(blockstate -> 7)));
    public static final RegistrySupplier<BlockExtractionChamber> EXTRACTION_CHAMBER = register("extraction_chamber", () -> new BlockExtractionChamber(Block.Properties.of(Material.STONE).strength(4f, 10.0f).lightLevel(blockstate -> 15)));
    public static final RegistrySupplier<Block> INFUSED_INGOT_BLOCK = register("infused_ingot_block", () -> new Block(Block.Properties.of(Material.METAL)));

    // #############################################################################################################################################################################################
    // ## Register
    // #############################################################################################################################################################################################

    private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> block) {
        RegistrySupplier<T> registeredBlock = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties().tab(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED)));
        return registeredBlock;
    }
}
