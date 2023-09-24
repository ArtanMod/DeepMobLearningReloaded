package jp.artan.dmlreloaded.plugin.jei.category;


import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.init.BlockInit;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.plugin.jei.DeepMobLearningReloadedRecipeCategoryUid;
import jp.artan.dmlreloaded.util.DataModelHelper;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class SimulationChamberRecipeCategory implements IRecipeCategory<SimulationChamberRecipeCategory.SimulationChamberRecipes> {
    public static MutableComponent title = Component.translatable("block.dmlreloaded.simulation_chamber");
    public static RecipeType<SimulationChamberRecipes> type = RecipeType.create(DeepMobLearningReloaded.MOD_ID, "simulation_chamber", SimulationChamberRecipes.class);
    private IDrawable icon;
    private IDrawable background;
    private IDrawableAnimated progress;

    public SimulationChamberRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation base = DeepMobLearningReloaded.getResource("textures/gui/jei/simulation_chamber.png");
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockInit.SIMULATION_CHAMBER.get()));

        background = guiHelper.createDrawable(base, 0, 0, 116, 43);
        IDrawableStatic progressStatic = guiHelper.createDrawable(base, 0, 43, 35, 6);
        this.progress = guiHelper.createAnimatedDrawable(progressStatic, 120, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SimulationChamberRecipes recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.CATALYST, 4, 4).addItemStack(recipe.getDataModel());
        builder.addSlot(RecipeIngredientRole.INPUT, 28, 4).addItemStack(new ItemStack(ItemInit.POLYMER_CLAY.get()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 96, 4).addItemStack(recipe.getMatter());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 76, 26).addItemStack(recipe.getPristine());
    }

    @Override
    public Component getTitle() {
        return title;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void draw(SimulationChamberRecipes recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        progress.draw(guiGraphics,52,9);
    }

//    @Override
//    public ResourceLocation getUid() {
//        return DeepMobLearningReloadedRecipeCategoryUid.SIMULATION_CHAMBER_ID;
//    }
//
//    @Override
//    public Class<? extends SimulationChamberRecipes> getRecipeClass() {
//        return SimulationChamberRecipes.class;
//    }

    @Override
    public RecipeType<SimulationChamberRecipes> getRecipeType() {
        return type;
    }

    public static class SimulationChamberRecipes {

        private ItemStack pristine;
        private ItemStack data;
        private ItemStack matter;

        public SimulationChamberRecipes(ItemStack data) {
            this.data = data;
            this.pristine = DataModelHelper.getMobMetaData(data).getPristineMatterStack(1);
            this.matter = DataModelHelper.getMobMetaData(data).getLivingMatterStack(1);
        }

        public ItemStack getPristine() {
            return pristine;
        }

        public ItemStack getDataModel() {
            return data;
        }

        public ItemStack getMatter() {
            return matter;
        }
    }
}
