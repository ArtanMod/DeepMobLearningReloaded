package jp.artan.dmlreloaded.recipe.DataModelUpgradeRecipe;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class DataModelUpgradeRecipeBuilder {
    public static final String FILE_NAME = "data_model_upgrade";


    public static void save(Consumer<FinishedRecipe> consumer) {
        consumer.accept(
                new DataModelUpgradeRecipeBuilder.Result(DeepMobLearningReloadedMod.getResource(FILE_NAME))
        );
    }

    public static class Result implements FinishedRecipe {
        protected final ResourceLocation id;

        public Result(ResourceLocation id) {
            this.id = id;
        }

        @Override
        public void serializeRecipeData(JsonObject p_218610_1_) {
            p_218610_1_.addProperty("type", DeepMobLearningReloadedMod.getResource("crafting_special_" + FILE_NAME).toString());
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return RecipeSerializer.SHAPELESS_RECIPE;
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
