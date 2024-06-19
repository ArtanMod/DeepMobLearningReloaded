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

    // #############################################################################################################################################################################################
    // ## 環境マター
    // #############################################################################################################################################################################################

    public static final RegistrySupplier<ItemLivingMatter> LIVING_MATTER_EXTRATERRESTRIAL = registerLivingMatter("living_matter_extraterrestrial", LivingMatterType.EXTRATERRESTRIAL);
    public static final RegistrySupplier<ItemLivingMatter> LIVING_MATTER_HELLISH = registerLivingMatter("living_matter_hellish", LivingMatterType.HELLISH);
    public static final RegistrySupplier<ItemLivingMatter> LIVING_MATTER_OVERWORLDIAN = registerLivingMatter("living_matter_overworldian", LivingMatterType.OVERWORLDIAN);

    private static RegistrySupplier<ItemLivingMatter> registerLivingMatter(String name, LivingMatterType livingMatterType) {
        return register(name, p -> new ItemLivingMatter(p, livingMatterType));
    }

    public static <T extends Item> RegistrySupplier<T> register(String name, NonNullFunction<Item.Properties, T> item) {
        return ITEMS.register(name, () -> item.apply(new Item.Properties().tab(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED)));
    }
}
