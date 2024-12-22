package jp.artan.dmlreloaded.neoforge.plugin.jei.maker;

import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.util.TierHelper;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;

import java.util.ArrayList;
import java.util.List;

public class CraftingRecipeMaker {
    public static List<RecipeHolder<CraftingRecipe>> getCraftingRecipes() {
        List<RecipeHolder<CraftingRecipe>> recipes = new ArrayList<>();

        addSpawnEggRecipe(recipes);

        return recipes;
    }

    private static void addSpawnEggRecipe(List<RecipeHolder<CraftingRecipe>> recipes) {
        BuiltInRegistries.ITEM.stream().forEach(item -> {
            if(item instanceof ItemDataModel dataModel) {
                ItemStack dataStack = new ItemStack(dataModel);
                DataModelHelper.setTier(dataStack, TierHelper.getMaxTier());
                MobMetaData metaData = DataModelHelper.getMobMetaData(dataStack);
                ItemStack output = metaData.getSpawnEgg();
                if(!output.isEmpty()) {
                    recipes.add(new RecipeHolder(DeepMobLearningReloadedMod.getResource(output.getItem().toString()), new ShapelessRecipe(
                            "craft_spawn_egg",
                            CraftingBookCategory.MISC,
                            output,
                            NonNullList.of(
                                    Ingredient.EMPTY,
                                    Ingredient.of(Items.EGG),
                                    Ingredient.of(metaData.getPristineMatter()),
                                    Ingredient.of(dataStack)
                            )
                    )));
                }
            }
        });
    }
}
