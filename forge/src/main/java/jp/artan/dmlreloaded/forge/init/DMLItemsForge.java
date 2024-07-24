package jp.artan.dmlreloaded.forge.init;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.artansprojectcoremod.utils.inject.NonNullFunction;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.item.ItemDeepLearner;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class DMLItemsForge {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.ITEM);

    public static void register() {
        ITEMS.register();
    }

    public static final RegistrySupplier<ItemDeepLearner> DEEP_LEARNER = register("deep_learner", p -> new ItemDeepLearner(p, DeepMobLearningReloadedMod.DEEP_LEARNER_INTERNAL_SLOTS_SIZE));
    public static final RegistrySupplier<ItemDeepLearner> NETHERITE_DEEP_LEARNER = register("netherite_deep_learner", p -> new ItemDeepLearner(p, DeepMobLearningReloadedMod.NETHERITE_DEEP_LEARNER_INTERNAL_SLOTS_SIZE));

    private static <T extends Item> RegistrySupplier<T> register(String name, NonNullFunction<Item.Properties, T> item) {
        RegistrySupplier<T> itemRegister = ITEMS.register(name, () -> {
            T itemInstance = item.apply(new Item.Properties());
            CreativeTabRegistry.append(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED, itemInstance);
            return itemInstance;
        });
        return itemRegister;
    }
}
