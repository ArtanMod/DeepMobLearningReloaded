package jp.artan.dmlreloaded.recipe.SpawnEggShapelessRecipe;

import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.init.DMLRecipeSerializer;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.util.TierHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SpawnEggShapelessRecipe extends CustomRecipe {
    public SpawnEggShapelessRecipe(CraftingBookCategory pCategory) {
        super(pCategory);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        MobMetaData metaData = this.getMobMetaData(input);
        ItemPristineMatter pristineMatter = this.getPristineMatter(input);
        boolean flag = metaData != null && pristineMatter != null && pristineMatter == metaData.getPristineMatter();
        boolean egg = false;
        for(int i = 0; i < input.size(); i++) {
            ItemStack itemstack1 = input.getItem(i);
            if(itemstack1.getItem() == Items.EGG) {
                egg = true;
            }
        }
        return flag && egg;
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        MobMetaData metaData = this.getMobMetaData(input);
        if(metaData == null) {
            return ItemStack.EMPTY;
        }
        return metaData.getSpawnEgg();
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        NonNullList<ItemStack> list = NonNullList.withSize(input.size(), ItemStack.EMPTY);
        for(int i = 0; i < input.size(); i++) {
            ItemStack itemstack1 = input.getItem(i);
            if(itemstack1.getItem() instanceof ItemDataModel) {
                list.set(i, itemstack1.copy());
            }
        }
        return list;
    }

    private @Nullable MobMetaData getMobMetaData(CraftingInput input) {
        for(int i = 0; i < input.size(); i++) {
            ItemStack dataModel = input.getItem(i);
            if(dataModel.getItem() instanceof ItemDataModel) {
//                if(DeepMobLearningReloaded.DEBUG_MODE) {
//                    DataModelHelper.setTier(dataModel, 4);
//                }
                int tier = DataModelHelper.getTier(dataModel);
                if(TierHelper.isMaxTier(tier)) {
                    return DataModelHelper.getMobMetaData(dataModel);
                }
            }
        }
        return null;
    }

    private @Nullable ItemPristineMatter getPristineMatter(CraftingInput input) {
        for(int i = 0; i < input.size(); i++) {
            ItemStack itemstack = input.getItem(i);
            if(itemstack.getItem() instanceof ItemPristineMatter pristineMatter) {
                return pristineMatter;
            }
        }
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DMLRecipeSerializer.CRAFTING_SPECIAL_SPAWN_EGG_RECIPE.get();
    }

}
