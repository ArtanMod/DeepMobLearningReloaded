package jp.artan.dmlreloaded.neoforge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractBlockTagsProvider;
import jp.artan.dmlreloaded.neoforge.init.DMLBlocksForge;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends AbstractBlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                DMLBlocksForge.INFUSED_INGOT_BLOCK.get(),
                DMLBlocksForge.MACHINE_CASING.get(),
                DMLBlocksForge.SIMULATION_CHAMBER.get(),
                DMLBlocksForge.EXTRACTION_CHAMBER.get()
        );
    }
}
