package jp.artan.dmlreloaded.recipe.builders;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class SpawnEggShapelessRecipeBuilders {
    public static final String FILE_NAME = "spawn_egg";


    public static void save(Consumer<FinishedRecipe> consumer) {
        consumer.accept(
                new SpawnEggShapelessRecipeBuilders.Result(DeepMobLearningReloaded.getResource(FILE_NAME))
        );
    }

    public static class Result implements FinishedRecipe {
        protected final ResourceLocation id;

        public Result(ResourceLocation id) {
            this.id = id;
        }

        @Override
        public void serializeRecipeData(JsonObject p_218610_1_) {
            p_218610_1_.addProperty("type", DeepMobLearningReloaded.getResource("crafting_special_" + FILE_NAME).toString());
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return RecipeSerializer.SHAPED_RECIPE;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
