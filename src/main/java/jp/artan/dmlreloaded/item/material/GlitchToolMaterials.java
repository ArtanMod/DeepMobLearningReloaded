package jp.artan.dmlreloaded.item.material;

import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum GlitchToolMaterials implements Tier {
    GLITCH(3, 2200, 3.0f, 9.0F, 15, () -> {
        return Ingredient.of(ItemInit.GLITCH_INGOT.get());
    }),
    NETHERITE_GLITCH(4, 3000, 9.0F, 12.0F, 20, () -> {
        return Ingredient.of(ItemInit.NETHERITE_GLITCH_INGOT.get());
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    GlitchToolMaterials(int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
        this.level = pLevel;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
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

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @javax.annotation.Nullable
    public net.minecraft.tags.TagKey<net.minecraft.world.level.block.Block> getTag() {
        return switch(this) {
            case GLITCH -> BlockTags.NEEDS_DIAMOND_TOOL;
            case NETHERITE_GLITCH -> Tags.Blocks.NEEDS_NETHERITE_TOOL;
        };
    }
}
