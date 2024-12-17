package jp.artan.dmlreloaded.neoforge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractItemTagsProvider;
import jp.artan.dmlreloaded.neoforge.init.DMLItemsForge;
import jp.artan.dmlreloaded.init.DMLItemTags;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends AbstractItemTagsProvider {
    public ModItemTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> completableFuture2, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, completableFuture, completableFuture2, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tag(DMLItemTags.CURIOS_DEEP_LEARNER).add(DMLItemsForge.DEEP_LEARNER.get(), DMLItemsForge.NETHERITE_DEEP_LEARNER.get());
        this.addArmor(DMLItems.GLITCH_ARMOR);
        this.addArmor(DMLItems.NETHERITE_GLITCH_ARMOR);
    }
}
