package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractLootTableProvider;
import jp.artan.dmlreloaded.forge.init.DMLBlocksForge;
import net.minecraft.data.DataGenerator;

import java.util.function.Function;

public class ModLootTableProvider extends AbstractLootTableProvider {
    public ModLootTableProvider(DataGenerator arg, String modId) {
        super(arg, modId);
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
        protected void addTables() {
            this.dropSelf(DMLBlocksForge.MACHINE_CASING.get());
            this.dropSelf(DMLBlocksForge.SIMULATION_CHAMBER.get());
            this.dropSelf(DMLBlocksForge.EXTRACTION_CHAMBER.get());
            this.dropSelf(DMLBlocksForge.INFUSED_INGOT_BLOCK.get());
        }
    }
}
