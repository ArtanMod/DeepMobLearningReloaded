package jp.artan.dmlreloaded.plugin.jei.maker;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.plugin.jei.category.SimulationChamberRecipeCategory;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.util.TierHelper;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class CraftingRecipeMaker {
    public static List<CraftingRecipe> getCraftingRecipes() {
        List<CraftingRecipe> recipes = new ArrayList<>();

        addSpawnEggRecipe(recipes);

        return recipes;
    }

    private static void addSpawnEggRecipe(List<CraftingRecipe> recipes) {
        ForgeRegistries.ITEMS.getEntries().forEach(hashMapItem -> {
            if(hashMapItem.getValue() instanceof ItemDataModel dataModel) {
                ItemStack dataStack = new ItemStack(dataModel);
                DataModelHelper.setTier(dataStack, TierHelper.getMaxTier());
                MobMetaData metaData = DataModelHelper.getMobMetaData(dataStack);
                ItemStack output = metaData.getSpawnEgg();
                if(!output.isEmpty()) {
                    recipes.add(new ShapelessRecipe(
                            DeepMobLearningReloaded.getResource(output.getItem().getRegistryName().getPath()),
                            null,
                            output,
                            NonNullList.of(
                                    Ingredient.EMPTY,
                                    Ingredient.of(Items.EGG),
                                    Ingredient.of(metaData.getPristineMatter()),
                                    Ingredient.of(dataStack)
                            )
                    ));
                }
            }
        });
    }
}
