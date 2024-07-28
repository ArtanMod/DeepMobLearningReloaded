package jp.artan.dmlreloaded.forge.plugin.Cataclysm.init;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.artansprojectcoremod.utils.inject.NonNullFunction;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class DMLIntegrationLCItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.ITEM);

    public static void register() {
        ITEMS.register();
    }

    private static <T extends Item> RegistrySupplier<T> register(String name, NonNullFunction<Item.Properties, T> item) {
        RegistrySupplier<T> itemRegister = ITEMS.register(name, () -> {
            T itemInstance = item.apply(new Item.Properties());
            CreativeTabRegistry.append(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED, itemInstance);
            return itemInstance;
        });
        return itemRegister;
    }
}
