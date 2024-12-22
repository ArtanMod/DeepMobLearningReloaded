package jp.artan.dmlreloaded.neoforge.providers;

import com.google.common.collect.ImmutableList;
import jp.artan.dmlreloaded.neoforge.init.DMLBlocksForge;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, Set.of(), blockLootTable(ImmutableList.of(BlockLootTable::new)), provider);
    }

    public static List<SubProviderEntry> blockLootTable(List<Function<HolderLookup.Provider, LootTableSubProvider>> providers) {
        ImmutableList.Builder<SubProviderEntry> builder = ImmutableList.builder();
        LootContextParamSet lootContextParamSet = LootContextParamSets.BLOCK;
        providers.forEach(provider -> builder.add(new LootTableProvider.SubProviderEntry(provider, lootContextParamSet)));
        return builder.build();
    }

    private static class BlockLootTable extends VanillaBlockLoot {

        public BlockLootTable(HolderLookup.Provider registries) {
            super(registries);
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
