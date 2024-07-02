package jp.artan.dmlreloaded.recipe.DataModelUpgradeRecipe;

import jp.artan.dmlreloaded.init.DMLRecipeSerializer;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemDataModelUpgrade;
import jp.artan.dmlreloaded.util.DataModelHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class DataModelUpgradeRecipe extends CustomRecipe {
    public DataModelUpgradeRecipe(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        ItemStack metaData = this.getMobMetaData(container);
        ItemDataModelUpgrade dataModelUpgrade = this.getDataModelUpgrade(container);
        boolean isNotNullable = metaData != null && dataModelUpgrade != null;
        if(isNotNullable) {
            int currentTier = DataModelHelper.getTier(metaData);
            int nextTier = dataModelUpgrade.getNextTier();
            return isContainerItems(container, 2) && currentTier < nextTier;
        }
        return false;
    }

    @Override
    public ItemStack assemble(CraftingContainer container) {
        ItemStack metaDataItem = this.getMobMetaData(container).copy();
        ItemDataModelUpgrade dataModelUpgrade = this.getDataModelUpgrade(container);
        DataModelHelper.setTier(metaDataItem, dataModelUpgrade.getNextTier());
        return metaDataItem;
    }

    private boolean isContainerItems(CraftingContainer inventory, int size) {
        int count = 0;
        for(int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack dataModel = inventory.getItem(i);
            count += dataModel.isEmpty() ? 0 : 1;
        }
        return count == size;
    }

    @Nullable
    private ItemStack getMobMetaData(CraftingContainer inventory) {
        for(int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack dataModel = inventory.getItem(i);
            if(dataModel.getItem() instanceof ItemDataModel) {
                return dataModel;
            }
        }
        return null;
    }

    @Nullable
    private ItemDataModelUpgrade getDataModelUpgrade(CraftingContainer inventory) {
        for(int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack itemstack = inventory.getItem(i);
            if(itemstack.getItem() instanceof ItemDataModelUpgrade dataModelUpgrade) {
                return dataModelUpgrade;
            }
        }
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DMLRecipeSerializer.CRAFTING_SPECIAL_DATA_MODE_UPGRADE_RECIPE.get();
    }

    public static class Serializer extends SimpleRecipeSerializer<DataModelUpgradeRecipe> {
        public Serializer() {
            super(DataModelUpgradeRecipe::new);
        }
    }
}
