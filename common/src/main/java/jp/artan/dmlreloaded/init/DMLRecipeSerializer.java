package jp.artan.dmlreloaded.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.recipe.DataModelUpgradeRecipe.DataModelUpgradeRecipe;
import jp.artan.dmlreloaded.recipe.SpawnEggShapelessRecipe.SpawnEggShapelessRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;

public class DMLRecipeSerializer {
    private static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registry.RECIPE_SERIALIZER_REGISTRY);

    public static final RegistrySupplier<SimpleRecipeSerializer<SpawnEggShapelessRecipe>> CRAFTING_SPECIAL_SPAWN_EGG_RECIPE = RECIPES.register("crafting_special_spawn_egg", SpawnEggShapelessRecipe.Serializer::new);
    public static final RegistrySupplier<SimpleRecipeSerializer<DataModelUpgradeRecipe>> CRAFTING_SPECIAL_DATA_MODE_UPGRADE_RECIPE = RECIPES.register("crafting_special_data_model_upgrade", DataModelUpgradeRecipe.Serializer::new);

    public static void register() {
        RECIPES.register();
    }
}
