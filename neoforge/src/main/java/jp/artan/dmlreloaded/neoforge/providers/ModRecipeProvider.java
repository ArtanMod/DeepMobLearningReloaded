package jp.artan.dmlreloaded.neoforge.providers;

import com.kyanite.deeperdarker.content.DDItems;
import jp.artan.dmlreloaded.neoforge.init.DMLBlocksForge;
import jp.artan.dmlreloaded.neoforge.init.DMLItemsForge;
import jp.artan.dmlreloaded.neoforge.plugin.DeeperAndDarker.init.DMLIntegrationDADItems;
import jp.artan.dmlreloaded.neoforge.plugin.PluginInit;
import jp.artan.dmlreloaded.init.DMLItems;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.recipe.DataModelUpgradeRecipe.DataModelUpgradeRecipe;
import jp.artan.dmlreloaded.recipe.SpawnEggShapelessRecipe.SpawnEggShapelessRecipe;
import jp.artan.dmlreloaded.sets.ArmorItems;
import jp.artan.dmlreloaded.util.RecipeGenUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {

        // SpecialRecipeを登録
        SpecialRecipeBuilder.special(SpawnEggShapelessRecipe::new).save(consumer, "crafting_special_spawn_egg");
        SpecialRecipeBuilder.special(DataModelUpgradeRecipe::new).save(consumer, "crafting_special_data_model_upgrade");

        // 通常のレシピを登録
        blockRecipes(consumer);
        itemRecipes(consumer);

        if(PluginInit.DEEP_AND_DARKER_ACTIVE) {
            pluginDeeperAndDarkerRecipe(consumer);
        }
    }

    private void pluginDeeperAndDarkerRecipe(RecipeOutput consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DMLIntegrationDADItems.SHATTERED.get())
                .requires(DMLItems.DATA_MODEL_BLANK.get())
                .requires(DDItems.SOUL_DUST.get())
                .unlockedBy("has_item", has(DMLItems.DATA_MODEL_BLANK.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DMLIntegrationDADItems.SCULK_CENTIPEDE.get())
                .requires(DMLItems.DATA_MODEL_BLANK.get())
                .requires(DDItems.SCULK_BONE.get())
                .unlockedBy("has_item", has(DMLItems.DATA_MODEL_BLANK.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DMLIntegrationDADItems.STALKER.get())
                .requires(DMLItems.DATA_MODEL_BLANK.get())
                .requires(DDItems.SOUL_CRYSTAL.get())
                .unlockedBy("has_item", has(DMLItems.DATA_MODEL_BLANK.get()))
                .save(consumer);
    }

    private static void blockRecipes(RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DMLBlocksForge.MACHINE_CASING.get(), 8)
                .define('#', DMLItems.SOOT_COVERED_PLATE.get())
                .define('X', Items.IRON_INGOT)
                .define('Y', DMLItems.SOOT_COVERED_REDSTONE.get())
                .pattern("#X#")
                .pattern("XYX")
                .pattern("#X#")
                .unlockedBy("has_item", has(DMLItems.SOOT_COVERED_PLATE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DMLBlocksForge.SIMULATION_CHAMBER.get())
                .define('#', Blocks.GLASS_PANE)
                .define('X', Items.ENDER_PEARL)
                .define('Y', DMLBlocksForge.MACHINE_CASING.get())
                .define('A', Items.CYAN_DYE)
                .define('B', Items.COMPARATOR)
                .pattern(" # ")
                .pattern("XYX")
                .pattern("ABA")
                .unlockedBy("has_item", has(DMLBlocksForge.MACHINE_CASING.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DMLBlocksForge.EXTRACTION_CHAMBER.get())
                .define('#', Items.GOLD_INGOT)
                .define('X', Items.DIAMOND)
                .define('Y', DMLBlocksForge.MACHINE_CASING.get())
                .define('A', Items.DANDELION)
                .define('B', Items.COMPARATOR)
                .pattern(" # ")
                .pattern("XYX")
                .pattern("ABA")
                .unlockedBy("has_item", has(DMLBlocksForge.MACHINE_CASING.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DMLBlocksForge.INFUSED_INGOT_BLOCK.get()).requires(DMLItems.GLITCH_INGOT.get(), 9)
                .unlockedBy("has_item", has(DMLItems.GLITCH_INGOT.get()))
                .save(consumer);
    }

    private static void itemRecipes(RecipeOutput consumer) {

        // 通常アイテム
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DMLItems.SOOT_COVERED_PLATE.get(), 8)
                .define('X', Items.OBSIDIAN)
                .define('Y', DMLItems.SOOT_COVERED_REDSTONE.get())
                .pattern("XX")
                .pattern("XY")
                .unlockedBy("has_item", has(DMLItems.SOOT_COVERED_REDSTONE.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DMLItems.GLITCH_INGOT.get(), 9).requires(DMLBlocksForge.INFUSED_INGOT_BLOCK.get())
                .unlockedBy("has_item", has(DMLItems.GLITCH_INGOT.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DMLItems.NETHERITE_GLITCH_INGOT.get())
                .requires(Items.NETHERITE_SCRAP, 4)
                .requires(DMLItems.GLITCH_INGOT.get(), 4)
                .group("netherite_ingot")
                .unlockedBy("has_netherite_scrap", has(Items.NETHERITE_SCRAP))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DMLItemsForge.DEEP_LEARNER.get())
                .define('#', DMLItems.SOOT_COVERED_PLATE.get())
                .define('X', Items.REPEATER)
                .define('Y', Blocks.GLASS_PANE)
                .define('Z', DMLItems.SOOT_COVERED_REDSTONE.get())
                .pattern("#X#")
                .pattern("XYX")
                .pattern("#Z#")
                .unlockedBy("has_item", has(DMLItems.SOOT_COVERED_PLATE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DMLItems.GLITCH_UPGRADE_SMITHING_TEMPLATE.get())
                .define('A', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('B', DMLItems.GLITCH_INGOT.get())
                .define('C', DMLItemsForge.GLITCH_FRAGMENT.get())
                .pattern("BCB")
                .pattern("CAC")
                .pattern("BCB")
                .unlockedBy("has_item", has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .save(consumer);
        RecipeGenUtils.Smithing.smithingUpgrade(RecipeCategory.TOOLS, Ingredient.of(DMLItems.GLITCH_UPGRADE_SMITHING_TEMPLATE.get()), DMLItemsForge.NETHERITE_DEEP_LEARNER, DMLItemsForge.DEEP_LEARNER, Ingredient.of(DMLItems.NETHERITE_GLITCH_INGOT.get()))
                .unlocks("has_netherite_glitch_ingot", has(DMLItems.NETHERITE_GLITCH_INGOT.get()))
                .save(consumer, "netherite_deep_learner_smithing");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DMLItems.POLYMER_CLAY.get(), 16)
                .define('#', Items.CLAY_BALL)
                .define('X', Items.IRON_INGOT)
                .define('Y', Items.GOLD_INGOT)
                .define('Z', Items.LAPIS_LAZULI)
                .pattern("Y# ")
                .pattern("#Z#")
                .pattern(" #X")
                .unlockedBy("has_item", has(Items.CLAY_BALL))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, DMLItemsForge.GLITCH_SWORD.get())
                .define('#', DMLItems.GLITCH_INGOT.get())
                .define('X', Items.IRON_NUGGET)
                .define('Y', Items.STICK)
                .pattern("  #")
                .pattern("X# ")
                .pattern("YX ")
                .unlockedBy("has_item", has(DMLItems.GLITCH_INGOT.get()))
                .save(consumer);
        RecipeGenUtils.Smithing.smithingUpgrade(RecipeCategory.COMBAT, Ingredient.of(DMLItems.GLITCH_UPGRADE_SMITHING_TEMPLATE.get()), DMLItemsForge.NETHERITE_GLITCH_SWORD, DMLItemsForge.GLITCH_SWORD, Ingredient.of(DMLItems.NETHERITE_GLITCH_INGOT.get()))
                .unlocks("has_netherite_glitch_ingot", has(DMLItems.NETHERITE_GLITCH_INGOT.get()))
                .save(consumer, "netherite_glitch_infused_sword_smithing");
        armorRecipes(DMLItems.GLITCH_ARMOR, consumer);
        armorRecipes(DMLItems.NETHERITE_GLITCH_ARMOR, DMLItems.GLITCH_ARMOR, Ingredient.of(DMLItems.NETHERITE_GLITCH_INGOT.get()), Ingredient.of(DMLItems.GLITCH_UPGRADE_SMITHING_TEMPLATE.get()), consumer);

        // データモデル
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, DMLItems.DATA_MODEL_BLANK.get())
                .define('#', Items.LAPIS_LAZULI)
                .define('A', Items.REPEATER)
                .define('B', DMLItems.SOOT_COVERED_REDSTONE.get())
                .define('C', Blocks.STONE)
                .define('D', Items.GOLD_INGOT)
                .pattern("#A#")
                .pattern("BCB")
                .pattern("#D#")
                .unlockedBy("has_item", has(DMLItems.SOOT_COVERED_REDSTONE.get()))
                .save(consumer);
        BiConsumer<ItemDataModel, Item> dataModelRecipe = (dataModel, material) -> {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, dataModel)
                    .requires(DMLItems.DATA_MODEL_BLANK.get())
                    .requires(material)
                    .unlockedBy("has_item", has(DMLItems.DATA_MODEL_BLANK.get()))
                    .save(consumer);
        };
        dataModelRecipe.accept(DMLItems.DATA_MODEL_BLAZE.get(), Items.BLAZE_ROD);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_CREEPER.get(), Items.GUNPOWDER);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_ENDER_DRAGON.get(), Items.DRAGON_EGG);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_ELDER_GUARDIAN.get(), Items.SPONGE);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_ENDERMAN.get(), Items.ENDER_PEARL);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_EVOKER.get(), Items.TOTEM_OF_UNDYING);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_GHAST.get(), Items.GHAST_TEAR);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_GUARDIAN.get(), Items.PRISMARINE_SHARD);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DMLItems.DATA_MODEL_HOGLIN.get())
                .requires(DMLItems.DATA_MODEL_BLANK.get())
                .requires(Items.LEATHER)
                .requires(Items.PORKCHOP)
                .unlockedBy("has_item", has(DMLItems.DATA_MODEL_BLANK.get()))
                .save(consumer);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_MAGMA_CUBE.get(), Items.MAGMA_CREAM);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_PHANTOM.get(), Items.PHANTOM_MEMBRANE);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_PIGLIN.get(), Items.GOLD_INGOT);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_RAVAGER.get(), Items.SADDLE);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_SHULKER.get(), Items.SHULKER_SHELL);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_SKELETON.get(), Items.BONE);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_SLIME.get(), Items.SLIME_BALL);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_SPIDER.get(), Items.SPIDER_EYE);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_WARDEN.get(), Items.ECHO_SHARD);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_WITCH.get(), Items.GLASS_BOTTLE);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_WITHER_SKELETON.get(), Items.WITHER_SKELETON_SKULL);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_WITHER.get(), Items.NETHER_STAR);
        dataModelRecipe.accept(DMLItems.DATA_MODEL_ZOMBIE.get(), Items.ROTTEN_FLESH);

        // 環境マター: LIVING_MATTER_EXTRATERRESTRIAL
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHORUS_FRUIT)
                .requires(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get())
                .requires(Items.APPLE)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get()))
                .save(consumer, "chorus_flower_from_living_matter_extraterrestrial");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.END_STONE, 8)
                .requires(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get())
                .requires(Blocks.SANDSTONE, 2)
                .requires(Items.ENDER_PEARL)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get()))
                .save(consumer, "ender_stone_from_living_matter_extraterrestrial");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NETHER_STAR)
                .define('#', DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get())
                .define('X', Blocks.WITHER_SKELETON_SKULL)
                .define('Y', Blocks.SOUL_SAND)
                .pattern("X#X")
                .pattern("YYY")
                .pattern(" Y ")
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get()))
                .save(consumer, "nether_star_from_living_matter_extraterrestrial");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ENDER_PEARL)
                .requires(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get())
                .requires(Items.EMERALD)
                .requires(Items.SNOWBALL)
                .requires(Items.SLIME_BALL)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get()))
                .save(consumer, "ender_pearl_from_extraterrestrial_living_matter");

        // 環境マター: LIVING_MATTER_HELLISH
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLAZE_POWDER, 2)
                .requires(DMLItems.LIVING_MATTER_HELLISH.get())
                .requires(Items.GUNPOWDER)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_HELLISH.get()))
                .save(consumer, "blaze_powder_from_living_matter_hellish");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get())
                .define('#', DMLItems.LIVING_MATTER_HELLISH.get())
                .define('X', Blocks.END_STONE)
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_HELLISH.get()))
                .save(consumer, "living_matter_extraterrestrial_from_living_matter_hellish");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLAZE_ROD)
                .requires(DMLItems.LIVING_MATTER_HELLISH.get(), 2)
                .requires(Items.BONE)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_HELLISH.get()))
                .save(consumer, "blaze_rod_from_living_matter_hellish");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GHAST_TEAR, 3)
                .requires(DMLItems.LIVING_MATTER_HELLISH.get(), 2)
                .requires(Items.SUGAR)
                .requires(Items.SPIDER_EYE)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_HELLISH.get()))
                .save(consumer, "ghast_tear_from_living_matter_hellish");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.SOUL_SAND, 4)
                .requires(DMLItems.LIVING_MATTER_HELLISH.get())
                .requires(Blocks.SAND)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_HELLISH.get()))
                .save(consumer, "soul_sand_from_hellish_living_matter");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHER_WART, 4)
                .requires(DMLItems.LIVING_MATTER_HELLISH.get())
                .requires(Blocks.RED_MUSHROOM)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_HELLISH.get()))
                .save(consumer, "nether_wart_from_living_matter_hellish");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_INGOT, 6)
                .requires(DMLItems.LIVING_MATTER_HELLISH.get())
                .requires(Items.IRON_INGOT)
                .requires(Items.GLOWSTONE_DUST)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_HELLISH.get()))
                .save(consumer, "gold_ingot_from_living_matter_hellish");

        // 環境マター: LIVING_MATTER_OVERWORLDIAN
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.GRASS_BLOCK, 4)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .requires(Blocks.DIRT)
                .requires(ItemTags.LEAVES)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "grass_from_living_matter_overworldian");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DMLItems.LIVING_MATTER_HELLISH.get())
                .define('#', DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .define('X', Blocks.NETHERRACK)
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "hellish_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CARROT, 2)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .requires(Items.WHEAT_SEEDS)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "carrot_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PRISMARINE_SHARD, 2)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .requires(Items.QUARTZ)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "prismarine_shard_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_INGOT, 8)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get(), 4)
                .requires(Items.ROTTEN_FLESH)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "iron_ingot_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.POTATO, 2)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .requires(Items.STICK)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "potato_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GUNPOWDER, 16)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .requires(Items.COAL)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "gunpowder_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ARROW, 12)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .requires(Items.STICK)
                .requires(Items.FLINT)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "arrow_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE, 22)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .requires(Items.BONE_MEAL)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "bone_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ROTTEN_FLESH, 16)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .requires(Items.PORKCHOP)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "rotten_flesh_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SPIDER_EYE, 2)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get())
                .requires(Items.ROTTEN_FLESH)
                .requires(Items.APPLE)
                .requires(Items.RED_MUSHROOM)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "spider_eye_from_living_matter_overworldian");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.COBWEB, 4)
                .requires(DMLItems.LIVING_MATTER_OVERWORLDIAN.get(), 2)
                .requires(Items.STRING)
                .requires(Items.SLIME_BALL)
                .unlockedBy("has_item", has(DMLItems.LIVING_MATTER_OVERWORLDIAN.get()))
                .save(consumer, "cobweb_from_living_matter_overworldian");
    }

    protected static void armorRecipes(ArmorItems<?> armorItems, RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItems.Helmet.get())
                .define('#', armorItems.Helmet.get().getMaterial().value().repairIngredient().get())
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_item", has(armorItems.Helmet.get().getMaterial().value().repairIngredient().get().getItems()[0].getItem()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItems.Chestplate.get())
                .define('#', armorItems.Chestplate.get().getMaterial().value().repairIngredient().get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(armorItems.Chestplate.get().getMaterial().value().repairIngredient().get().getItems()[0].getItem()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItems.Leggings.get())
                .define('#', armorItems.Leggings.get().getMaterial().value().repairIngredient().get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_item", has(armorItems.Leggings.get().getMaterial().value().repairIngredient().get().getItems()[0].getItem()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, armorItems.Boots.get())
                .define('#', armorItems.Boots.get().getMaterial().value().repairIngredient().get())
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_item", has(armorItems.Boots.get().getMaterial().value().repairIngredient().get().getItems()[0].getItem()))
                .save(consumer);
    }

    protected static void armorRecipes(ArmorItems<?> armorItems, ArmorItems<?> baseArmorItems, Ingredient upgradeItems, Ingredient template, RecipeOutput consumer) {
        RecipeGenUtils.Smithing.smithingUpgrade(
                RecipeCategory.COMBAT,
                template,
                armorItems.Helmet,
                baseArmorItems.Helmet,
                upgradeItems
        ).save(consumer, getItemName(armorItems.Helmet.get()) + "_smithing");
        RecipeGenUtils.Smithing.smithingUpgrade(
                RecipeCategory.COMBAT,
                template,
                armorItems.Chestplate,
                baseArmorItems.Chestplate,
                upgradeItems
        ).save(consumer, getItemName(armorItems.Chestplate.get()) + "_smithing");
        RecipeGenUtils.Smithing.smithingUpgrade(
                RecipeCategory.COMBAT,
                template,
                armorItems.Leggings,
                baseArmorItems.Leggings,
                upgradeItems
        ).save(consumer, getItemName(armorItems.Leggings.get()) + "_smithing");
        RecipeGenUtils.Smithing.smithingUpgrade(
                RecipeCategory.COMBAT,
                template,
                armorItems.Boots,
                baseArmorItems.Boots,
                upgradeItems
        ).save(consumer, getItemName(armorItems.Boots.get()) + "_smithing");
    }

}
