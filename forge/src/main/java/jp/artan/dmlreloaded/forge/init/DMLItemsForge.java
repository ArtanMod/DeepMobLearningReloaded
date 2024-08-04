package jp.artan.dmlreloaded.forge.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.artansprojectcoremod.utils.inject.NonNullFunction;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.item.ItemDeepLearner;
import jp.artan.dmlreloaded.forge.item.ItemGlitchFragment;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class DMLItemsForge {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.ITEM_REGISTRY);

    public static void register() {
        ITEMS.register();
    }

    public static final RegistrySupplier<ItemGlitchFragment> GLITCH_FRAGMENT = register("glitch_fragment", ItemGlitchFragment::new);
    public static final RegistrySupplier<ItemDeepLearner> DEEP_LEARNER = register("deep_learner", p -> new ItemDeepLearner(p, DeepMobLearningReloadedMod.DEEP_LEARNER_INTERNAL_SLOTS_SIZE));
    public static final RegistrySupplier<ItemDeepLearner> NETHERITE_DEEP_LEARNER = register("netherite_deep_learner", p -> new ItemDeepLearner(p, DeepMobLearningReloadedMod.NETHERITE_DEEP_LEARNER_INTERNAL_SLOTS_SIZE));

    private static <T extends Item> RegistrySupplier<T> register(String name, NonNullFunction<Item.Properties, T> item) {
        return ITEMS.register(name, () -> item.apply(new Item.Properties().tab(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED)));
    }
}
