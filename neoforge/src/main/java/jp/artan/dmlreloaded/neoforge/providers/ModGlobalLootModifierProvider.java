package jp.artan.dmlreloaded.neoforge.providers;

import jp.artan.dmlreloaded.neoforge.loot.GlitchFragmentModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, String modid) {
        super(output, modid);
    }

    @Override
    protected void start() {
        add("glitch_fragment_all_entities", new GlitchFragmentModifier(new LootItemCondition[] {}));
    }
}

