package jp.artan.dmlreloaded.recipe.DataModelUpgradeRecipe;

import jp.artan.dmlreloaded.init.DMLRecipeSerializer;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemDataModelUpgrade;
import jp.artan.dmlreloaded.util.DataModelHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class DataModelUpgradeRecipe extends CustomRecipe {
    public DataModelUpgradeRecipe(CraftingBookCategory pCategory) {
        super(pCategory);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        ItemStack metaData = this.getMobMetaData(input);
        ItemDataModelUpgrade dataModelUpgrade = this.getDataModelUpgrade(input);
        boolean isNotNullable = metaData != null && dataModelUpgrade != null;
        if(isNotNullable) {
            int currentTier = DataModelHelper.getTier(metaData);
            int nextTier = dataModelUpgrade.getNextTier();
            return isContainerItems(input, 2) && currentTier < nextTier;
        }
        return false;
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        ItemStack metaDataItem = this.getMobMetaData(input).copy();
        metaDataItem.setCount(1);
        ItemDataModelUpgrade dataModelUpgrade = this.getDataModelUpgrade(input);
        DataModelHelper.setTier(metaDataItem, dataModelUpgrade.getNextTier());
        return metaDataItem;
    }

    private boolean isContainerItems(CraftingInput input, int size) {
        int count = 0;
        for(int i = 0; i < input.size(); i++) {
            ItemStack dataModel = input.getItem(i);
            count += dataModel.isEmpty() ? 0 : 1;
        }
        return count == size;
    }

    @Nullable
    private ItemStack getMobMetaData(CraftingInput input) {
        for(int i = 0; i < input.size(); i++) {
            ItemStack dataModel = input.getItem(i);
            if(dataModel.getItem() instanceof ItemDataModel) {
                return dataModel;
            }
        }
        return null;
    }

    @Nullable
    private ItemDataModelUpgrade getDataModelUpgrade(CraftingInput input) {
        for(int i = 0; i < input.size(); i++) {
            ItemStack itemstack = input.getItem(i);
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
}
