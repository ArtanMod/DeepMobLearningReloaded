package jp.artan.dmlreloaded.recipe;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.init.RecipeSerializerInit;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.util.TierHelper;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class SpawnEggShapelessRecipe extends CustomRecipe {
    public SpawnEggShapelessRecipe(ResourceLocation p_43833_) {
        super(p_43833_);
    }

    @Override
    public boolean matches(CraftingContainer inventory, Level world) {
        MobMetaData metaData = this.getMobMetaData(inventory);
        ItemPristineMatter pristineMatter = this.getPristineMatter(inventory);
        boolean flag = metaData != null && pristineMatter != null && pristineMatter == metaData.getPristineMatter();
        boolean egg = false;
        for(int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack itemstack1 = inventory.getItem(i);
            if(itemstack1.getItem() == Items.EGG) {
                egg = true;
            }
        }
        return flag && egg;
    }

    @Override
    public ItemStack assemble(CraftingContainer inventory) {
        MobMetaData metaData = this.getMobMetaData(inventory);
        if(metaData == null) {
            return ItemStack.EMPTY;
        }
        return metaData.getSpawnEgg();
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer inventory) {
        NonNullList<ItemStack> list = NonNullList.withSize(inventory.getContainerSize(), ItemStack.EMPTY);
        for(int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack itemstack1 = inventory.getItem(i);
            if(itemstack1.getItem() instanceof ItemDataModel) {
                list.set(i, itemstack1.copy());
            }
        }
        return list;
    }

    private @Nullable MobMetaData getMobMetaData(CraftingContainer inventory) {
        for(int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack dataModel = inventory.getItem(i);
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

    private @Nullable ItemPristineMatter getPristineMatter(CraftingContainer inventory) {
        for(int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack itemstack = inventory.getItem(i);
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
        return RecipeSerializerInit.CRAFTING_SPECIAL_SPAWN_EGG_RECIPE.get();
    }

    public static class Serializer extends SimpleRecipeSerializer<SpawnEggShapelessRecipe> {
        public Serializer() {
            super(SpawnEggShapelessRecipe::new);
        }
    }
}
