package jp.artan.dmlreloaded.forge.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import jp.artan.dmlreloaded.item.ItemGlitchSword;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class ItemGlitchSwordWrap extends ItemGlitchSword {

    public ItemGlitchSwordWrap(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();
        if (slot == EquipmentSlot.MAINHAND) {
            modifiers.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", getTier().getAttackDamageBonus() + getPermanentWeaponDamage(stack), AttributeModifier.Operation.ADDITION));
            modifiers.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4000000953674316D, AttributeModifier.Operation.ADDITION));
        }

        return modifiers;
    }
}
