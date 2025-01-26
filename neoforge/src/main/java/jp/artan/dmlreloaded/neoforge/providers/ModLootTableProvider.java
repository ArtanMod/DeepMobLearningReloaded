package jp.artan.dmlreloaded.neoforge.providers;

import com.google.common.collect.ImmutableList;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.neoforge.init.DMLBlocksForge;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
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

    protected void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationcontext, ProblemReporter.Collector problemreporter$collector) {
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

        protected Iterable<Block> getKnownBlocks() {
            return BuiltInRegistries.BLOCK.stream().filter((block) -> DeepMobLearningReloadedMod.MOD_ID.equals(BuiltInRegistries.BLOCK.getKey(block).getNamespace())).toList();
        }
    }
}
