package jp.artan.dmlreloaded.loot;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.config.BalanceConfigs;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemDeepLearner;
import jp.artan.dmlreloaded.item.ItemGlitchArmor;
import jp.artan.dmlreloaded.util.DataModelHelper;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GlitchFragmentModifier extends LootModifier {
    private final Item fragment;
    private final Item heart;
    private final int chanceFragment;
    private final float chanceHeart;
    private final boolean enabled;

    public GlitchFragmentModifier(LootItemCondition[] conditionsIn) {
        this(conditionsIn, 3, 0.5F, true);
    }

    public GlitchFragmentModifier(LootItemCondition[] conditionsIn, int chanceFragment, float chanceHeart, boolean enabled) {
        super(conditionsIn);
        this.fragment = ItemInit.GLITCH_FRAGMENT.get();
        this.heart = ItemInit.GLITCH_HEART.get();
        this.chanceFragment = chanceFragment;
        this.chanceHeart = chanceHeart;
        this.enabled = enabled;
    }

    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext ctx) {
        if(enabled && ctx.getParamOrNull(LootContextParams.THIS_ENTITY) instanceof Enemy) {

            if(ThreadLocalRandom.current().nextInt(1, 100) <= chanceFragment) {
                generatedLoot.add(new ItemStack(fragment, ThreadLocalRandom.current().nextInt(1, 3)));
            }
            if(ThreadLocalRandom.current().nextFloat(0, 100) <= chanceHeart) {
                generatedLoot.add(new ItemStack(heart, 1));
            }
            //Bow works
            if(ctx.getParamOrNull(LootContextParams.KILLER_ENTITY) instanceof ServerPlayer player) {
                NonNullList<ItemStack> updatedModels = updateDataModel(ctx, player);

                // Return early if no models were affected
                if(updatedModels.size() == 0) {
                    return generatedLoot;
                }

                // Chance to drop pristine matter from the model that gained data
                // Can be toggled in Configs
                if(BalanceConfigs.isGlitchArmorExtraDropsEnabled.get() && ItemGlitchArmor.isSetEquippedByPlayer(player) && ThreadLocalRandom.current().nextInt(1, 100) <= 16) {
                    MobMetaData meta = DataModelHelper.getMobMetaData(updatedModels.get(0));
                    generatedLoot.add(meta.getPristineMatterStack(2));
                }
            }
        } else if(enabled && ctx.getParamOrNull(LootContextParams.THIS_ENTITY) instanceof Animal && ctx.getParamOrNull(LootContextParams.KILLER_ENTITY) instanceof ServerPlayer player) {
            NonNullList<ItemStack> updatedModels = updateDataModel(ctx, player);

            // Return early if no models were affected
            if(updatedModels.size() == 0) {
                return generatedLoot;
            }

            // Chance to drop pristine matter from the model that gained data
            // Can be toggled in Configs
            if(BalanceConfigs.isGlitchArmorExtraDropsEnabled.get() && ItemGlitchArmor.isSetEquippedByPlayer(player) && ThreadLocalRandom.current().nextInt(1, 100) <= 16) {
                MobMetaData meta = DataModelHelper.getMobMetaData(updatedModels.get(0));
                generatedLoot.add(meta.getPristineMatterStack(2));
            }
        }
        return generatedLoot;
    }

    private static NonNullList<ItemStack> updateDataModel(LootContext ctx, ServerPlayer player) {
        NonNullList<ItemStack> inventory = NonNullList.create();
        inventory.addAll(player.getInventory().items);
        inventory.addAll(player.getInventory().offhand);

        // Grab the deep learners and combat trial items from a players inventory
        NonNullList<ItemStack> deepLearners = getDeepLearners(inventory);
        NonNullList<ItemStack> updatedModels = NonNullList.create();

        // Update every data model in every deeplearner that match the kill event
        deepLearners.forEach(stack -> {
            NonNullList<ItemStack> models = updateAndReturnModels(stack, (LivingEntity) ctx.getParamOrNull(LootContextParams.THIS_ENTITY), player);
            updatedModels.addAll(models);
        });

        return updatedModels;
    }

    private static NonNullList<ItemStack> updateAndReturnModels(ItemStack deepLearner, LivingEntity entity, ServerPlayer player) {
        NonNullList<ItemStack> deepLearnerItems = ItemDeepLearner.getContainedItems(deepLearner);
        NonNullList<ItemStack> result = NonNullList.create();

        deepLearnerItems.forEach(stack -> {
            if (stack.getItem() instanceof ItemDataModel) {
                MobMetaData meta = DataModelHelper.getMobMetaData(stack);
                if(meta.entityLivingMatchesMob(entity)) {
                    DataModelHelper.increaseMobKillCount(stack, player);
                    result.add(stack);
                }
            }
            ItemDeepLearner.setContainedItems(deepLearner, deepLearnerItems);
        });

        return result;
    }

    private static NonNullList<ItemStack> getDeepLearners(NonNullList<ItemStack> inventory) {
        NonNullList<ItemStack> result = NonNullList.create();
        inventory.forEach(stack -> {
            if(stack.getItem() instanceof ItemDeepLearner) {
                result.add(stack);
            }
        });

        return result;
    }

    public static class Serializer extends GlobalLootModifierSerializer<GlitchFragmentModifier> {

        @Override
        public GlitchFragmentModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditions) {
            int chanceFragment = GsonHelper.getAsInt(object, "chanceFragment");
            float chanceHeart = GsonHelper.getAsFloat(object, "chanceHeart");
            boolean enabled = GsonHelper.getAsBoolean(object, "enabled");
            return new GlitchFragmentModifier(conditions, chanceFragment, chanceHeart, enabled);
        }

        @Override
        public JsonObject write(GlitchFragmentModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("chanceFragment", instance.chanceFragment);
            json.addProperty("chanceHeart", instance.chanceHeart);
            json.addProperty("enabled", instance.enabled);
            return json;
        }
    }
}
