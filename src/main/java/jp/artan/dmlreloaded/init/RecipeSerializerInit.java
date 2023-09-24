package jp.artan.dmlreloaded.init;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.recipe.SpawnEggShapelessRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeSerializerInit {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DeepMobLearningReloaded.MOD_ID);

    public static final RegistryObject<SimpleCraftingRecipeSerializer<SpawnEggShapelessRecipe>> CRAFTING_SPECIAL_SPAWN_EGG_RECIPE = RECIPE.register("crafting_special_spawn_egg", SpawnEggShapelessRecipe.Serializer::new);

}
