package jp.artan.dmlreloaded.neoforge.plugin.jei;

import com.google.common.collect.Lists;
import jp.artan.dmlreloaded.util.inject.NonNullSupplier;
import jp.artan.dmlreloaded.neoforge.init.DMLBlocksForge;
import jp.artan.dmlreloaded.init.DMLItems;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.dmlreloaded.neoforge.plugin.jei.category.ExtractionChamberRecipeCategory;
import jp.artan.dmlreloaded.neoforge.plugin.jei.category.SimulationChamberRecipeCategory;
import jp.artan.dmlreloaded.neoforge.plugin.jei.maker.CraftingRecipeMaker;
import jp.artan.dmlreloaded.util.DataModelHelper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return DeepMobLearningReloadedRecipeCategoryUid.pluginUid;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SimulationChamberRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new ExtractionChamberRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(RecipeTypes.CRAFTING, CraftingRecipeMaker.getCraftingRecipes());
        this.addSimulationChamberRecipe(registration);
        this.addExtractionChamberRecipe(registration);
        registration.addIngredientInfo(new ItemStack(DMLItems.GLITCH_INGOT.get()), VanillaTypes.ITEM_STACK, Component.translatable("jei.dmlreloaded.glitch_ingot"));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(DMLBlocksForge.SIMULATION_CHAMBER.get()), SimulationChamberRecipeCategory.type);
        registration.addRecipeCatalyst(new ItemStack(DMLBlocksForge.EXTRACTION_CHAMBER.get()), ExtractionChamberRecipeCategory.type);
    }

    private void addSimulationChamberRecipe(IRecipeRegistration registration) {
        List<SimulationChamberRecipeCategory.SimulationChamberRecipes> list = Lists.newArrayList();

        BuiltInRegistries.ITEM.stream().forEach(item -> {
            if(item instanceof ItemDataModel dataModel) {
                ItemStack dataStack = new ItemStack(dataModel);
                DataModelHelper.setTier(dataStack, 1);
                list.add(new SimulationChamberRecipeCategory.SimulationChamberRecipes(dataStack));
            }
        });
        registration.addRecipes(SimulationChamberRecipeCategory.type, list);
    }

    private void addExtractionChamberRecipe(IRecipeRegistration registration) {
        Map<ItemStack, List<NonNullSupplier<ItemStack>>> pristineTables = new HashMap<>();
        List<ExtractionChamberRecipeCategory.ExtractionChamberRecipes> list = Lists.newArrayList();

        BuiltInRegistries.ITEM.stream().forEach(item -> {
            if(item instanceof ItemPristineMatter matter) {
                pristineTables.put(new ItemStack(matter, 1),  matter.getMobKey().getLoot());
            }
        });
        pristineTables.forEach(
                (input, outputs) -> outputs.forEach((output) -> {
                    list.add(new ExtractionChamberRecipeCategory.ExtractionChamberRecipes(input, output.get()));
                })
        );
        registration.addRecipes(ExtractionChamberRecipeCategory.type, list);
    }
}

