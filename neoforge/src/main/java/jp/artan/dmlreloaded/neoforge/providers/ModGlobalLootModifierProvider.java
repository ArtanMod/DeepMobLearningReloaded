package jp.artan.dmlreloaded.neoforge.providers;

import jp.artan.dmlreloaded.neoforge.loot.GlitchFragmentModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid) {
        super(output, registries, modid);
    }

    @Override
    protected void start() {
        add("glitch_fragment_all_entities", new GlitchFragmentModifier(new LootItemCondition[] {}));
    }
}

