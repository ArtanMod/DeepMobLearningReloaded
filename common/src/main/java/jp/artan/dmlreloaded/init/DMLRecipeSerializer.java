package jp.artan.dmlreloaded.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.recipe.DataModelUpgradeRecipe.DataModelUpgradeRecipe;
import jp.artan.dmlreloaded.recipe.SpawnEggShapelessRecipe.SpawnEggShapelessRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public class DMLRecipeSerializer {
    private static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.RECIPE_SERIALIZER);

    public static final RegistrySupplier<SimpleCraftingRecipeSerializer<SpawnEggShapelessRecipe>> CRAFTING_SPECIAL_SPAWN_EGG_RECIPE = RECIPES.register("crafting_special_spawn_egg", () -> new SimpleCraftingRecipeSerializer<>(SpawnEggShapelessRecipe::new));
    public static final RegistrySupplier<SimpleCraftingRecipeSerializer<DataModelUpgradeRecipe>> CRAFTING_SPECIAL_DATA_MODE_UPGRADE_RECIPE = RECIPES.register("crafting_special_data_model_upgrade", () -> new SimpleCraftingRecipeSerializer<>(DataModelUpgradeRecipe::new));

    public static void register() {
        RECIPES.register();
    }
}
