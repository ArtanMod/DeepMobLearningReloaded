package jp.artan.dmlreloaded.init;

import dev.architectury.registry.registries.DeferredRegister;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class DBLItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.ITEM_REGISTRY);

    public static void register() {
        ITEMS.register();
    }
}
