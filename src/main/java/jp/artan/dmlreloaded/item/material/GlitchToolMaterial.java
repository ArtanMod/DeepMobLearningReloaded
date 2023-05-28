package jp.artan.dmlreloaded.item.material;

import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class GlitchToolMaterial implements Tier {

    private final Supplier<Ingredient> ingredient;

    public GlitchToolMaterial() {
        this.ingredient = () -> Ingredient.of(ItemInit.GLITCH_INGOT.get());
    }

    @Override
    public int getUses() {
        return 2200;
    }

    @Override
    public float getSpeed() {
        return 3.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 9;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.ingredient.get();
    }

}