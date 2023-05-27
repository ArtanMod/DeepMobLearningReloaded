package jp.artan.dmlreloaded.provider;

import jp.artan.dmlreloaded.init.DropModifier;
import jp.artan.dmlreloaded.loot.GlitchFragmentModifier;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void start() {
        add("glitch_fragment_all_entities", DropModifier.GLITCH_FRAGMENT.get(), new GlitchFragmentModifier(new LootItemCondition[] {}));
    }
}

