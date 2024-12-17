package jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.init;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.artansprojectcoremod.utils.inject.NonNullFunction;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.CataclysmLivingMatterType;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.CataclysmMobKey;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class DMLIntegrationLCItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.ITEM);

    public static void register() {
        ITEMS.register();
    }

    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_ENDER_GOLEM = registerDataModel("data_model_ender_golem", CataclysmMobKey.ENDER_GOLEM);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_ENDER_GUARDIAN = registerDataModel("data_model_ender_guardian", CataclysmMobKey.ENDER_GUARDIAN);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_NETHERITE_MONSTROSITY = registerDataModel("data_model_netherite_monstrosity", CataclysmMobKey.NETHERITE_MONSTROSITY);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_IGNIS = registerDataModel("data_model_ignis", CataclysmMobKey.IGNIS);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_THE_HARBINGER = registerDataModel("data_model_the_harbinger", CataclysmMobKey.THE_HARBINGER);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_THE_LEVIATHAN = registerDataModel("data_model_the_leviathan", CataclysmMobKey.THE_LEVIATHAN);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_CORAL_GOLEM = registerDataModel("data_model_coral_golem", CataclysmMobKey.CORAL_GOLEM);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_ANCIENT_REMNANT = registerDataModel("data_model_ancient_remnant", CataclysmMobKey.ANCIENT_REMNANT);

    private static RegistrySupplier<ItemDataModel> registerDataModel(String name, IMobKey mobKey) {
        return register(name, p -> new ItemDataModel(p, mobKey));
    }

    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_ENDER_GOLEM = registerPristineMatter("pristine_matter_ender_golem", CataclysmMobKey.ENDER_GOLEM);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_ENDER_GUARDIAN = registerPristineMatter("pristine_matter_ender_guardian", CataclysmMobKey.ENDER_GUARDIAN);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_NETHERITE_MONSTROSITY = registerPristineMatter("pristine_matter_netherite_monstrosity", CataclysmMobKey.NETHERITE_MONSTROSITY);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_IGNIS = registerPristineMatter("pristine_matter_ignis", CataclysmMobKey.IGNIS);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_THE_HARBINGER = registerPristineMatter("pristine_matter_the_harbinger", CataclysmMobKey.THE_HARBINGER);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_THE_LEVIATHAN = registerPristineMatter("pristine_matter_the_leviathan", CataclysmMobKey.THE_LEVIATHAN);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_CORAL_GOLEM = registerPristineMatter("pristine_matter_coral_golem", CataclysmMobKey.CORAL_GOLEM);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_ANCIENT_REMNANT = registerPristineMatter("pristine_matter_ancient_remnant", CataclysmMobKey.ANCIENT_REMNANT);

    private static RegistrySupplier<ItemPristineMatter> registerPristineMatter(String name, IMobKey mobKey) {
        return register(name, p -> new ItemPristineMatter(p, mobKey));
    }

    public static final RegistrySupplier<ItemLivingMatter> LIVING_MATTER_CATACLYSM = registerLivingMatter("living_matter_cataclysm", CataclysmLivingMatterType.CATACLYSM);

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
