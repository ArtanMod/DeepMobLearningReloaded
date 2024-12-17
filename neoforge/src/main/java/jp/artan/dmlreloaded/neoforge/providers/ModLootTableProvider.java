package jp.artan.dmlreloaded.neoforge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractLootTableProvider;
import jp.artan.dmlreloaded.neoforge.init.DMLBlocksForge;
import net.minecraft.data.PackOutput;

import java.util.function.Function;

public class ModLootTableProvider extends AbstractLootTableProvider {
    public ModLootTableProvider(PackOutput arg, String modId) {
        super(arg, modId, () -> new BlockLootTable(modId));
    }

    @Override
    protected Function<String, BlockLootTable> getBlockLootTable() {
        return BlockLootTable::new;
    }

    private static class BlockLootTable extends AbstractBlockLoot {

        public BlockLootTable(String modid) {
            super(modid);
        }

        @Override
        protected void generate() {
            this.dropSelf(DMLBlocksForge.MACHINE_CASING.get());
            this.dropSelf(DMLBlocksForge.SIMULATION_CHAMBER.get());
            this.dropSelf(DMLBlocksForge.EXTRACTION_CHAMBER.get());
            this.dropSelf(DMLBlocksForge.INFUSED_INGOT_BLOCK.get());
        }
    }
}
