package jp.artan.dmlreloaded.plugin.jei.category;


import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.init.BlockInit;
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

public class ExtractionChamberRecipeCategory implements IRecipeCategory<ExtractionChamberRecipeCategory.ExtractionChamberRecipes> {

    public static MutableComponent title = Component.translatable("block.dmlreloaded.extraction_chamber");
    public static ResourceLocation id = new ResourceLocation(DeepMobLearningReloaded.MOD_ID, "extraction_chamber");
    public static RecipeType<ExtractionChamberRecipes> type = RecipeType.create(DeepMobLearningReloaded.MOD_ID, "extraction_chamber", ExtractionChamberRecipes.class);
    private IDrawable icon;
    private IDrawable background;
    private IDrawableAnimated progress;

    public ExtractionChamberRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation base = DeepMobLearningReloaded.getResource("textures/gui/jei/extraction_chamber.png");
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockInit.EXTRACTION_CHAMBER.get()));

        background = guiHelper.createDrawable(base, 0, 0, 103, 30);
        IDrawableStatic progressStatic = guiHelper.createDrawable(base, 0, 30, 35, 6);
        this.progress = guiHelper.createAnimatedDrawable(progressStatic, 120, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ExtractionChamberRecipes recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 9, 7).addItemStack(recipe.getInputs());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 77, 7).addItemStack(recipe.getOutput());
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
    public void draw(ExtractionChamberRecipes recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        progress.draw(guiGraphics,34,12);
    }

//    @Override
//    public ResourceLocation getUid() {
//        return id;
//    }

    @Override
    public RecipeType<ExtractionChamberRecipes> getRecipeType() {
        return type;
    }

//    @Override
//    public Class<? extends ExtractionChamberRecipes> getRecipeClass() {
//        return ExtractionChamberRecipes.class;
//    }

    public static class ExtractionChamberRecipes {

        public final ItemStack input;
        public final ItemStack output;


        public ExtractionChamberRecipes(ItemStack input, ItemStack output) {
            this.input = input;
            this.output = output;
        }

        public ItemStack getInputs() {
            return input;
        }

        public ItemStack getOutput() {
            return output;
        }

    }
}
