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
    // ## マター
    // #############################################################################################################################################################################################

//    public static final RegistrySupplier<Item> PRISTINE_MATTER_BLAZE = registerPristineMatter("pristine_matter_blaze");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_CREEPER = registerPristineMatter("pristine_matter_creeper");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_ENDER_DRAGON = registerPristineMatter("pristine_matter_ender_dragon");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_ELDER_GUARDIAN = registerPristineMatter("pristine_matter_elder_guardian");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_ENDERMAN = registerPristineMatter("pristine_matter_enderman");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_EVOKER = registerPristineMatter("pristine_matter_evoker");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_GHAST = registerPristineMatter("pristine_matter_ghast");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_GUARDIAN = registerPristineMatter("pristine_matter_guardian");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_HOGLIN = registerPristineMatter("pristine_matter_hoglin");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_MAGMA_CUBE = registerPristineMatter("pristine_matter_magma_cube");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_PHANTOM = registerPristineMatter("pristine_matter_phantom");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_PIGLIN = registerPristineMatter("pristine_matter_piglin");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_RAVAGER = registerPristineMatter("pristine_matter_ravager");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_SHULKER = registerPristineMatter("pristine_matter_shulker");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_SKELETON = registerPristineMatter("pristine_matter_skeleton");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_SLIME = registerPristineMatter("pristine_matter_slime");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_SPIDER = registerPristineMatter("pristine_matter_spider");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_WARDEN = registerPristineMatter("pristine_matter_warden");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_WITCH = registerPristineMatter("pristine_matter_witch");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_WITHER_SKELETON = registerPristineMatter("pristine_matter_wither_skeleton");
//    public static final RegistrySupplier<Item> PRISTINE_MATTER_WITHER = registerPristineMatter("pristine_matter_wither");
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_ZOMBIE = registerPristineMatter("pristine_matter_zombie", MobKey.ZOMBIE);

    private static RegistrySupplier<ItemPristineMatter> registerPristineMatter(String name, MobKey mobKey) {
        return register(name, p -> new ItemPristineMatter(p, mobKey));
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
