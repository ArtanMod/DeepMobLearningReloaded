package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractRecipeProvider;
import jp.artan.dmlreloaded.recipe.DataModelUpgradeRecipe.DataModelUpgradeRecipeBuilder;
import jp.artan.dmlreloaded.recipe.SpawnEggShapelessRecipe.SpawnEggShapelessRecipeBuilders;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class ModRecipeProvider extends AbstractRecipeProvider {
    public ModRecipeProvider(DataGenerator arg) {
        super(arg);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        // SpecialRecipeを登録
        SpawnEggShapelessRecipeBuilders.save(consumer);
        DataModelUpgradeRecipeBuilder.save(consumer);
    }
}
