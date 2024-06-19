package jp.artan.dmlreloaded.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.artansprojectcoremod.utils.inject.NonNullFunction;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.common.LivingMatterType;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.item.*;
import jp.artan.dmlreloaded.item.material.GlitchToolMaterials;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class DBLItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.ITEM_REGISTRY);

    public static void register() {
        ITEMS.register();
    }

    // #############################################################################################################################################################################################
    // ## 標準アイテム
    // #############################################################################################################################################################################################

    public static final RegistrySupplier<ItemSootedRedstone> SOOT_COVERED_REDSTONE = register("soot_covered_redstone", ItemSootedRedstone::new);
    public static final RegistrySupplier<Item> SOOT_COVERED_PLATE = register("soot_covered_plate", Item::new);
    public static final RegistrySupplier<ItemGlitchFragment> GLITCH_FRAGMENT = register("glitch_fragment", ItemGlitchFragment::new);
    public static final RegistrySupplier<ItemGlitchHeart> GLITCH_HEART = register("glitch_heart", ItemGlitchHeart::new);
    public static final RegistrySupplier<ItemGlitchIngot> GLITCH_INGOT = register("glitch_infused_ingot", ItemGlitchIngot::new);
    public static final RegistrySupplier<Item> NETHERITE_GLITCH_INGOT = register("netherite_glitch_infused_ingot", Item::new);
//    public static final RegistrySupplier<ItemDeepLearner> DEEP_LEARNER = register("deep_learner", ItemDeepLearner::new);
//    public static final RegistrySupplier<ItemDeepLearner> NETHERITE_DEEP_LEARNER = register("netherite_deep_learner", ItemDeepLearner::new);
    public static final RegistrySupplier<Item> POLYMER_CLAY = register("polymer_clay", Item::new);
    public static final RegistrySupplier<ItemGlitchSword> GLITCH_SWORD = register("glitch_infused_sword", p -> new ItemGlitchSword(GlitchToolMaterials.GLITCH, p));
    public static final RegistrySupplier<ItemGlitchSword> NETHERITE_GLITCH_SWORD = register("glitch_infused_sword", p -> new ItemGlitchSword(GlitchToolMaterials.NETHERITE_GLITCH, p));
    // TODO: 装備2式追加

    // #############################################################################################################################################################################################
    // ## データモデル
    // #############################################################################################################################################################################################

    public static final RegistrySupplier<Item> DATA_MODEL_BLANK = register("data_model_blank", Item::new);
//    public static final RegistrySupplier<Item> DATA_MODEL_BLAZE = registerDataModel("data_model_blaze");
//    public static final RegistrySupplier<Item> DATA_MODEL_CREEPER = registerDataModel("data_model_creeper");
//    public static final RegistrySupplier<Item> DATA_MODEL_ENDER_DRAGON = registerDataModel("data_model_ender_dragon");
//    public static final RegistrySupplier<Item> DATA_MODEL_ELDER_GUARDIAN = registerDataModel("data_model_elder_guardian");
//    public static final RegistrySupplier<Item> DATA_MODEL_ENDERMAN = registerDataModel("data_model_enderman");
//    public static final RegistrySupplier<Item> DATA_MODEL_EVOKER = registerDataModel("data_model_evoker");
//    public static final RegistrySupplier<Item> DATA_MODEL_GHAST = registerDataModel("data_model_ghast");
//    public static final RegistrySupplier<Item> DATA_MODEL_GUARDIAN = registerDataModel("data_model_guardian");
//    public static final RegistrySupplier<Item> DATA_MODEL_HOGLIN = registerDataModel("data_model_hoglin");
//    public static final RegistrySupplier<Item> DATA_MODEL_MAGMA_CUBE = registerDataModel("data_model_magma_cube");
//    public static final RegistrySupplier<Item> DATA_MODEL_PHANTOM = registerDataModel("data_model_phantom");
//    public static final RegistrySupplier<Item> DATA_MODEL_PIGLIN = registerDataModel("data_model_piglin");
//    public static final RegistrySupplier<Item> DATA_MODEL_RAVAGER = registerDataModel("data_model_ravager");
//    public static final RegistrySupplier<Item> DATA_MODEL_SHULKER = registerDataModel("data_model_shulker");
//    public static final RegistrySupplier<Item> DATA_MODEL_SKELETON = registerDataModel("data_model_skeleton");
//    public static final RegistrySupplier<Item> DATA_MODEL_SLIME = registerDataModel("data_model_slime");
//    public static final RegistrySupplier<Item> DATA_MODEL_SPIDER = registerDataModel("data_model_spider");
//    public static final RegistrySupplier<Item> DATA_MODEL_WARDEN = registerDataModel("data_model_warden");
//    public static final RegistrySupplier<Item> DATA_MODEL_WITCH = registerDataModel("data_model_witch");
//    public static final RegistrySupplier<Item> DATA_MODEL_WITHER_SKELETON = registerDataModel("data_model_wither_skeleton");
//    public static final RegistrySupplier<Item> DATA_MODEL_WITHER = registerDataModel("data_model_wither");
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_ZOMBIE = registerDataModel("data_model_zombie", MobKey.ZOMBIE);

    private static RegistrySupplier<ItemDataModel> registerDataModel(String name, MobKey mobKey) {
        return register(name, p -> new ItemDataModel(p, mobKey));
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
