package jp.artan.dmlreloaded.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.artansprojectcoremod.sets.ArmorItems;
import jp.artan.artansprojectcoremod.utils.inject.NonNullFunction;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.common.LivingMatterType;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.item.*;
import jp.artan.dmlreloaded.item.material.GlitchArmorMaterials;
import jp.artan.dmlreloaded.item.material.GlitchToolMaterials;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class DMLItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.ITEM_REGISTRY);

    public static void register() {
        ITEMS.register();
    }

    // #############################################################################################################################################################################################
    // ## 標準アイテム
    // #############################################################################################################################################################################################

    public static final RegistrySupplier<ItemSootedRedstone> SOOT_COVERED_REDSTONE = register("soot_covered_redstone", ItemSootedRedstone::new);
    public static final RegistrySupplier<Item> SOOT_COVERED_PLATE = register("soot_covered_plate", Item::new);
    public static final RegistrySupplier<ItemGlitchHeart> GLITCH_HEART = register("glitch_heart", ItemGlitchHeart::new);
    public static final RegistrySupplier<ItemGlitchIngot> GLITCH_INGOT = register("glitch_infused_ingot", ItemGlitchIngot::new);
    public static final RegistrySupplier<Item> NETHERITE_GLITCH_INGOT = register("netherite_glitch_infused_ingot", p -> new Item(p.fireResistant()));
    public static final RegistrySupplier<Item> POLYMER_CLAY = register("polymer_clay", Item::new);
    public static final RegistrySupplier<ItemGlitchSword> GLITCH_SWORD = register("glitch_infused_sword", p -> new ItemGlitchSword(GlitchToolMaterials.GLITCH, p));
    public static final RegistrySupplier<ItemGlitchSword> NETHERITE_GLITCH_SWORD = register("netherite_glitch_infused_sword", p -> new ItemGlitchSword(GlitchToolMaterials.NETHERITE_GLITCH, p.fireResistant()));
    public static final ArmorItems<ItemGlitchArmor> GLITCH_ARMOR = registerGlitchArmor();
    private static ArmorItems<ItemGlitchArmor> registerGlitchArmor() {
        RegistrySupplier<ItemGlitchArmor> helmet = register("glitch_infused_helmet", p -> new ItemGlitchArmor(GlitchArmorMaterials.GLITCH, EquipmentSlot.HEAD, p));
        RegistrySupplier<ItemGlitchArmor> chestplate = register("glitch_infused_chestplate", p -> new ItemGlitchArmor(GlitchArmorMaterials.GLITCH, EquipmentSlot.CHEST, p));
        RegistrySupplier<ItemGlitchArmor> leggings = register("glitch_infused_leggings", p -> new ItemGlitchArmor(GlitchArmorMaterials.GLITCH, EquipmentSlot.LEGS, p));
        RegistrySupplier<ItemGlitchArmor> boots = register("glitch_infused_boots", p -> new ItemGlitchArmor(GlitchArmorMaterials.GLITCH, EquipmentSlot.FEET, p));
        return new ArmorItems<>(helmet, chestplate, leggings, boots, null);
    }
    public static final ArmorItems<ItemGlitchArmor> NETHERITE_GLITCH_ARMOR = registerNetheriteGlitchArmor();
    private static ArmorItems<ItemGlitchArmor> registerNetheriteGlitchArmor() {
        RegistrySupplier<ItemGlitchArmor> helmet = register("netherite_glitch_infused_helmet", p -> new ItemGlitchArmor(GlitchArmorMaterials.NETHERITE_GLITCH, EquipmentSlot.HEAD, p.fireResistant()));
        RegistrySupplier<ItemGlitchArmor> chestplate = register("netherite_glitch_infused_chestplate", p -> new ItemGlitchArmor(GlitchArmorMaterials.NETHERITE_GLITCH, EquipmentSlot.CHEST, p.fireResistant()));
        RegistrySupplier<ItemGlitchArmor> leggings = register("netherite_glitch_infused_leggings", p -> new ItemGlitchArmor(GlitchArmorMaterials.NETHERITE_GLITCH, EquipmentSlot.LEGS, p.fireResistant()));
        RegistrySupplier<ItemGlitchArmor> boots = register("netherite_glitch_infused_boots", p -> new ItemGlitchArmor(GlitchArmorMaterials.NETHERITE_GLITCH, EquipmentSlot.FEET, p.fireResistant()));
        return new ArmorItems<>(helmet, chestplate, leggings, boots, DMLItems.GLITCH_ARMOR);
    }

    // #############################################################################################################################################################################################
    // ## アップグレードデータモデル
    // #############################################################################################################################################################################################

    public static final RegistrySupplier<ItemDataModelUpgrade> DATA_MODEL_UPGRADE_TIER1 = register("data_model_upgrade_tier1", p -> new ItemDataModelUpgrade(p, 1));
    public static final RegistrySupplier<ItemDataModelUpgrade> DATA_MODEL_UPGRADE_TIER2 = register("data_model_upgrade_tier2", p -> new ItemDataModelUpgrade(p, 2));
    public static final RegistrySupplier<ItemDataModelUpgrade> DATA_MODEL_UPGRADE_TIER3 = register("data_model_upgrade_tier3", p -> new ItemDataModelUpgrade(p, 3));
    public static final RegistrySupplier<ItemDataModelUpgrade> DATA_MODEL_UPGRADE_TIER4 = register("data_model_upgrade_tier4", p -> new ItemDataModelUpgrade(p, 4));

    // #############################################################################################################################################################################################
    // ## データモデル
    // #############################################################################################################################################################################################

    public static final RegistrySupplier<Item> DATA_MODEL_BLANK = register("data_model_blank", Item::new);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_BLAZE = registerDataModel("data_model_blaze", MobKey.BLAZE);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_CREEPER = registerDataModel("data_model_creeper", MobKey.CREEPER);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_ENDER_DRAGON = registerDataModel("data_model_ender_dragon", MobKey.ENDER_DRAGON);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_ELDER_GUARDIAN = registerDataModel("data_model_elder_guardian", MobKey.ELDER_GUARDIAN);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_ENDERMAN = registerDataModel("data_model_enderman", MobKey.ENDERMAN);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_EVOKER = registerDataModel("data_model_evoker", MobKey.EVOKER);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_GHAST = registerDataModel("data_model_ghast", MobKey.GHAST);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_GUARDIAN = registerDataModel("data_model_guardian", MobKey.GUARDIAN);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_HOGLIN = registerDataModel("data_model_hoglin", MobKey.HOGLIN);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_MAGMA_CUBE = registerDataModel("data_model_magma_cube", MobKey.MAGMA_CUBE);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_PHANTOM = registerDataModel("data_model_phantom", MobKey.PHANTOM);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_PIGLIN = registerDataModel("data_model_piglin", MobKey.PIGLIN);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_RAVAGER = registerDataModel("data_model_ravager", MobKey.RAVAGER);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_SHULKER = registerDataModel("data_model_shulker", MobKey.SHULKER);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_SKELETON = registerDataModel("data_model_skeleton", MobKey.SKELETON);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_SLIME = registerDataModel("data_model_slime", MobKey.SLIME);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_SPIDER = registerDataModel("data_model_spider", MobKey.SPIDER);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_WARDEN = registerDataModel("data_model_warden", MobKey.WARDEN);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_WITCH = registerDataModel("data_model_witch", MobKey.WITCH);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_WITHER_SKELETON = registerDataModel("data_model_wither_skeleton", MobKey.WITHER_SKELETON);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_WITHER = registerDataModel("data_model_wither", MobKey.WITHER);
    public static final RegistrySupplier<ItemDataModel> DATA_MODEL_ZOMBIE = registerDataModel("data_model_zombie", MobKey.ZOMBIE);

    private static RegistrySupplier<ItemDataModel> registerDataModel(String name, MobKey mobKey) {
        return register(name, p -> new ItemDataModel(p, mobKey));
    }

    // #############################################################################################################################################################################################
    // ## マター
    // #############################################################################################################################################################################################

    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_BLAZE = registerPristineMatter("pristine_matter_blaze", MobKey.BLAZE);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_CREEPER = registerPristineMatter("pristine_matter_creeper", MobKey.CREEPER);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_ENDER_DRAGON = registerPristineMatter("pristine_matter_ender_dragon", MobKey.ENDER_DRAGON);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_ELDER_GUARDIAN = registerPristineMatter("pristine_matter_elder_guardian", MobKey.ELDER_GUARDIAN);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_ENDERMAN = registerPristineMatter("pristine_matter_enderman", MobKey.ENDERMAN);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_EVOKER = registerPristineMatter("pristine_matter_evoker", MobKey.EVOKER);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_GHAST = registerPristineMatter("pristine_matter_ghast", MobKey.GHAST);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_GUARDIAN = registerPristineMatter("pristine_matter_guardian", MobKey.GUARDIAN);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_HOGLIN = registerPristineMatter("pristine_matter_hoglin", MobKey.HOGLIN);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_MAGMA_CUBE = registerPristineMatter("pristine_matter_magma_cube", MobKey.MAGMA_CUBE);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_PHANTOM = registerPristineMatter("pristine_matter_phantom", MobKey.PHANTOM);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_PIGLIN = registerPristineMatter("pristine_matter_piglin", MobKey.PIGLIN);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_RAVAGER = registerPristineMatter("pristine_matter_ravager", MobKey.RAVAGER);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_SHULKER = registerPristineMatter("pristine_matter_shulker", MobKey.SHULKER);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_SKELETON = registerPristineMatter("pristine_matter_skeleton", MobKey.SKELETON);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_SLIME = registerPristineMatter("pristine_matter_slime", MobKey.SLIME);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_SPIDER = registerPristineMatter("pristine_matter_spider", MobKey.SPIDER);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_WARDEN = registerPristineMatter("pristine_matter_warden", MobKey.WARDEN);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_WITCH = registerPristineMatter("pristine_matter_witch", MobKey.WITCH);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_WITHER_SKELETON = registerPristineMatter("pristine_matter_wither_skeleton", MobKey.WITHER_SKELETON);
    public static final RegistrySupplier<ItemPristineMatter> PRISTINE_MATTER_WITHER = registerPristineMatter("pristine_matter_wither", MobKey.WITHER);
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

    private static <T extends Item> RegistrySupplier<T> register(String name, NonNullFunction<Item.Properties, T> item) {
        return ITEMS.register(name, () -> item.apply(new Item.Properties().tab(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED)));
    }
}
