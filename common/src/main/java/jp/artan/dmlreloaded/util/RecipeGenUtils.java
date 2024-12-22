package jp.artan.dmlreloaded.util;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class RecipeGenUtils {
    public final static class Smithing {
        public static SmithingTransformRecipeBuilder netheriteUpgrade(RecipeCategory recipeCategory, Supplier<? extends Item> result, Supplier<? extends ItemLike> material) {
            return smithingUpgrade(recipeCategory, Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), result, material, Ingredient.of(Items.NETHERITE_INGOT));
        }

        public static SmithingTransformRecipeBuilder smithingUpgrade(RecipeCategory recipeCategory, Ingredient upgradeTemplate, Supplier<? extends Item> resultItem, Supplier<? extends ItemLike> material, Ingredient upgradeItem) {
            return SmithingTransformRecipeBuilder.smithing(upgradeTemplate, Ingredient.of(material.get()), upgradeItem, recipeCategory, resultItem.get())
                    .unlocks("has_netherite_ingot", has(upgradeItem.getItems()[0].getItem()));
        }
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike itemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(new ItemLike[]{itemLike}));
    }
    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tag) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tag));
    }
    private static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate.Builder... items) {
        return inventoryTrigger((ItemPredicate[]) Arrays.stream(items).map(ItemPredicate.Builder::build).toArray((x$0) -> {
            return new ItemPredicate[x$0];
        }));
    }
    private static Criterion<InventoryChangeTrigger.TriggerInstance> inventoryTrigger(ItemPredicate... predicates) {
        return CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(predicates)));
    }
    private static String getItemName(Supplier<? extends ItemLike> pItemLike) {
        return BuiltInRegistries.ITEM.getKey(pItemLike.get().asItem()).getPath();
    }
}
