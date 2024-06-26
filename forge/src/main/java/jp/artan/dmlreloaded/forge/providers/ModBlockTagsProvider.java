package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractBlockTagsProvider;
import jp.artan.dmlreloaded.forge.init.DMLBlocksForge;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagsProvider extends AbstractBlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator arg, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                DMLBlocksForge.INFUSED_INGOT_BLOCK.get(),
                DMLBlocksForge.MACHINE_CASING.get(),
                DMLBlocksForge.SIMULATION_CHAMBER.get(),
                DMLBlocksForge.EXTRACTION_CHAMBER.get()
        );
    }
}
