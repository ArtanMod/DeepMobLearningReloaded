package jp.artan.dmlreloaded.util;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaFactory;
import jp.artan.dmlreloaded.item.ItemDataModel;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DataModelHelper {
    public static NonNullList<ItemStack> getValidFromList(NonNullList<ItemStack> list) {
        NonNullList<ItemStack> filteredList = NonNullList.create();

        for(ItemStack stack : list) {
            Item item = stack.getItem();

            if(item instanceof ItemDataModel) {
                filteredList.add(stack);
            }
        }

        return filteredList;
    }

    public static MutableComponent getTierName(ItemStack stack, boolean getNextTierName) {
        return TierHelper.getTierName(getTier(stack), getNextTierName);
    }

    public static boolean hasExtraTooltip(ItemStack stack) {
        return getExtraTooltip(stack) != null;
    }

    public static String getExtraTooltip(ItemStack stack) {
        return getMobMetaData(stack).getExtraTooltip();
    }

    public static ILivingMatterType getMatterTypeName(ItemStack stack) {
        return getMobMetaData(stack).getType();
    }

    public static int getSimulationTickCost(ItemStack stack) {
        return getMobMetaData(stack).getSimulationTickCost();
    }

    public static MobMetaData getMobMetaData(ItemStack stack) {
        return MobMetaFactory.createMobMetaData(getMobKey(stack));
    }

    public static int getTier(ItemStack stack) {
        return NBTHelper.getInt(stack, "tier", 0);
    }


    public static void setTier(ItemStack stack, int tier) {
        NBTHelper.setInt(stack, "tier", tier);
    }

    public static int getCurrentTierKillCount(ItemStack stack) {
        return NBTHelper.getInt(stack, "killCount", 0);
    }

    public static void setCurrentTierKillCount(ItemStack stack, int count) {
        NBTHelper.setInt(stack, "killCount", count);
    }

    public static int getCurrentTierSimulationCount(ItemStack stack) {
        return NBTHelper.getInt(stack, "simulationCount", 0);
    }

    public static void setCurrentTierSimulationCount(ItemStack stack, int count) {
        NBTHelper.setInt(stack, "simulationCount", count);
    }

    public static int getTotalKillCount(ItemStack stack) {
        return NBTHelper.getInt(stack, "totalKillCount", 0);
    }

    public static void setTotalKillCount(ItemStack stack, int count) {
        NBTHelper.setInt(stack, "totalKillCount", count);
    }

    public static int getTotalSimulationCount(ItemStack stack) {
        return NBTHelper.getInt(stack, "totalSimulationCount", 0);
    }

    public static void setTotalSimulationCount(ItemStack stack, int count) {
        NBTHelper.setInt(stack, "totalSimulationCount", count);
    }

    public static IMobKey getMobKey(ItemStack stack) {
        if(stack.getItem() instanceof ItemDataModel model) {
            return (model.getMobKey());
        } else {
            return MobKey.ZOMBIE;
        }
    }

    public static double getCurrentTierKillCountWithSims(ItemStack stack) {
        return DataModelLevelupHelper.getCurrentTierKillCountWithSims(getTier(stack), getCurrentTierKillCount(stack), getCurrentTierSimulationCount(stack));
    }

    public static int getCurrentTierSimulationCountWithKills(ItemStack stack) {
        return DataModelLevelupHelper.getCurrentTierSimulationCountWithKills(getTier(stack), getCurrentTierKillCount(stack), getCurrentTierSimulationCount(stack));
    }

    public static double getKillsToNextTier(ItemStack stack) {
        return DataModelLevelupHelper.getKillsToNextTier(getTier(stack), getCurrentTierKillCount(stack), getCurrentTierSimulationCount(stack));
    }

    public static int getSimulationsToNextTier(ItemStack stack) {
        return DataModelLevelupHelper.getSimulationsToNextTier(getTier(stack), getCurrentTierKillCount(stack), getCurrentTierSimulationCount(stack));
    }

    public static int getTierRoofAsKills(ItemStack stack) {
        if(getTier(stack) == DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            return 0;
        }
        return DataModelLevelupHelper.getTierRoof(getTier(stack), true);
    }

    public static int getTierRoof(ItemStack stack) {
        if(getTier(stack) == DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
            return 0;
        }
        return DataModelLevelupHelper.getTierRoof(getTier(stack), false);
    }
}
