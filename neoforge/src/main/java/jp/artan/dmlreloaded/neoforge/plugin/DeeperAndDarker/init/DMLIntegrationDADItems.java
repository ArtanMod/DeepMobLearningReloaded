package jp.artan.dmlreloaded.neoforge.plugin.DeeperAndDarker.init;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.neoforge.plugin.DeeperAndDarker.common.DeeperAndDarkerLivingMatterType;
import jp.artan.dmlreloaded.neoforge.plugin.DeeperAndDarker.common.DeeperAndDarkerMobKey;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.dmlreloaded.util.inject.NonNullFunction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class DMLIntegrationDADItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.ITEM);

    public static void register() {
        ITEMS.register();
    }

    public static final RegistrySupplier<ItemDataModel> SHATTERED = registerDataModel("data_model_deeper_darker_shattered", DeeperAndDarkerMobKey.SHATTERED);
    public static final RegistrySupplier<ItemDataModel> SCULK_CENTIPEDE = registerDataModel("data_model_deeper_darker_sculk_centipede", DeeperAndDarkerMobKey.SCULK_CENTIPEDE);
    public static final RegistrySupplier<ItemDataModel> STALKER = registerDataModel("data_model_deeper_darker_stalker", DeeperAndDarkerMobKey.STALKER);

    private static RegistrySupplier<ItemDataModel> registerDataModel(String name, IMobKey mobKey) {
        return register(name, p -> new ItemDataModel(p, mobKey));
    }

    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_SHATTERED = registerPristineMatter("pristine_matter_deeper_darker_shattered", DeeperAndDarkerMobKey.SHATTERED);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_SCULK_CENTIPEDE = registerPristineMatter("pristine_matter_deeper_darker_sculk_centipede", DeeperAndDarkerMobKey.SCULK_CENTIPEDE);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_STALKER = registerPristineMatter("pristine_matter_deeper_darker_stalker", DeeperAndDarkerMobKey.STALKER);

    private static RegistrySupplier<ItemPristineMatter> registerPristineMatter(String name, IMobKey mobKey) {
        return register(name, p -> new ItemPristineMatter(p, mobKey));
    }

    public static final RegistrySupplier<ItemLivingMatter> LIVING_MATTER_DEEPER_AND_DARKER = registerLivingMatter("living_matter_deeper_darker", DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER);

    private static RegistrySupplier<ItemLivingMatter> registerLivingMatter(String name, ILivingMatterType livingMatterType) {
        return register(name, p -> new ItemLivingMatter(p, livingMatterType));
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
