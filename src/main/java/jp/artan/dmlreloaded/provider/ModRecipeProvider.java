package jp.artan.dmlreloaded.provider;

import jp.artan.dmlreloaded.recipe.builders.SpawnEggShapelessRecipeBuilders;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        // SpecialRecipeを登録
        SpawnEggShapelessRecipeBuilders.save(consumer);
    }
}
