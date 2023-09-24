package jp.artan.dmlreloaded.provider;

import jp.artan.dmlreloaded.recipe.builders.SpawnEggShapelessRecipeBuilders;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // SpecialRecipeを登録
        SpawnEggShapelessRecipeBuilders.save(pWriter);
    }
}
