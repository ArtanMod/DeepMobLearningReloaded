package jp.artan.dmlreloaded.provider;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.recipe.builders.SpawnEggShapelessRecipeBuilders;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        // SpecialRecipeを登録
        SpawnEggShapelessRecipeBuilders.save(consumer);

        // バニラアイテムのレシピを登録
        this.registerVanillaRecipes(consumer);
    }

    private void registerVanillaRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(Blocks.SOUL_SAND, 4)
                .requires(ItemInit.LivingMatter.HELLISH.get())
                .requires(Blocks.SAND)
                .unlockedBy("has_item", has(ItemInit.LivingMatter.HELLISH.get()))
                .save(consumer, DeepMobLearningReloaded.getResource("soul_sand_from_hellish_living_matter"));
        ShapelessRecipeBuilder.shapeless(Items.ENDER_PEARL)
                .requires(ItemInit.LivingMatter.EXTRATERRESTRIAL.get())
                .requires(Items.EMERALD)
                .requires(Items.SNOWBALL)
                .requires(Items.SLIME_BALL)
                .unlockedBy("has_item", has(ItemInit.LivingMatter.EXTRATERRESTRIAL.get()))
                .save(consumer, DeepMobLearningReloaded.getResource("ender_pearl_from_extraterrestrial_living_matter"));

    }
}
