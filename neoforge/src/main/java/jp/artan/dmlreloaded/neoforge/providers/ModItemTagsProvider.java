package jp.artan.dmlreloaded.neoforge.providers;

import jp.artan.dmlreloaded.neoforge.init.DMLItemsForge;
import jp.artan.dmlreloaded.init.DMLItemTags;
import jp.artan.dmlreloaded.init.DMLItems;
import jp.artan.dmlreloaded.sets.ArmorItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> completableFuture2, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, completableFuture, completableFuture2, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tag(DMLItemTags.CURIOS_DEEP_LEARNER).add(DMLItemsForge.DEEP_LEARNER.get(), DMLItemsForge.NETHERITE_DEEP_LEARNER.get());
        this.addArmor(DMLItems.GLITCH_ARMOR);
        this.addArmor(DMLItems.NETHERITE_GLITCH_ARMOR);
    }

    protected void addArmor(ArmorItems<?> armorItems) {
        this.tag(ItemTags.TRIMMABLE_ARMOR).add(armorItems.Helmet.get(), armorItems.Chestplate.get(), armorItems.Leggings.get(), armorItems.Boots.get());
    }
}
