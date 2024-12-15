package jp.artan.dmlreloaded.item.material;

import com.google.common.base.Suppliers;
import jp.artan.dmlreloaded.init.DMLBlockTags;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.Objects;
import java.util.function.Supplier;

public enum GlitchToolMaterials implements Tier {
    GLITCH(DMLBlockTags.INCORRECT_FOR_GLITCH_TOOL, 2200, 3.0f, 9.0F, 15, () -> {
        return Ingredient.of(DMLItems.GLITCH_INGOT.get());
    }),
    NETHERITE_GLITCH(DMLBlockTags.INCORRECT_FOR_NETHERITE_GLITCH_TOOL,3000, 9.0F, 12.0F, 20, () -> {
        return Ingredient.of(DMLItems.NETHERITE_GLITCH_INGOT.get());
    });

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    GlitchToolMaterials(final TagKey incorrectBlockForDrops, final int uses, final float speed, final float damage, final int enchantmentValue, final Supplier<Ingredient> repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlockForDrops;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
