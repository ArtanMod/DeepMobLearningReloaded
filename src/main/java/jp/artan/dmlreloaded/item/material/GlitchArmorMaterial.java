package jp.artan.dmlreloaded.item.material;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class GlitchArmorMaterial implements ArmorMaterial {

    private final Supplier<Ingredient> ingredient = () -> Ingredient.of(ItemInit.GLITCH_INGOT.get());

    @Override
    public String getName() {
        return DeepMobLearningReloaded.MOD_ID+":glitch_infused";
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        switch (slot) {
            case FEET: return 400;
            case HEAD: return 400;
            case LEGS: return 400;
            case CHEST: return 400;
            default: return 0;
        }
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        switch (slot) {
            case FEET: return 3;
            case HEAD: return 3;
            case LEGS: return 6;
            case CHEST: return 8;
            default: return 0;
        }
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.ingredient.get();
    }

    @Override
    public float getToughness() {

        return 3.0f;
    }

    @Override
    public float getKnockbackResistance() {

        return 0;
    }
}
