package jp.artan.dmlreloaded.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import jp.artan.dmlreloaded.util.NBTHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ItemGlitchSword extends SwordItem {
    private static final int DAMAGE_BONUS = 1;
    private static final int DAMAGE_BONUS_MAX = 32;
    private static final int DAMAGE_INCREASE_CHANCE = 4;

    public ItemGlitchSword(Tier pTier, Item.Properties pProperties) {
        super(pTier, 10, 5f, pProperties);
    }

    public static boolean canIncreaseDamage(ItemStack sword) {
        return getPermanentWeaponDamage(sword) < DAMAGE_BONUS_MAX;
    }

    public static void increaseDamage(ItemStack sword, ServerPlayer player) {
        if(ThreadLocalRandom.current().nextInt(1, 100) <= DAMAGE_INCREASE_CHANCE) {
            int current = getPermanentWeaponDamage(sword);

            setPermanentWeaponDamage(sword, current + DAMAGE_BONUS >= DAMAGE_BONUS_MAX ? DAMAGE_BONUS_MAX : current + DAMAGE_BONUS);

            if(getPermanentWeaponDamage(sword) >= DAMAGE_BONUS_MAX) {
                player.displayClientMessage(new TranslatableComponent("dmlreloaded.messages.sword_levelup.max",new TextComponent(sword.getHoverName().getString()).withStyle(t->t.withColor(ChatFormatting.AQUA))), true);
            } else {
                player.displayClientMessage(new TranslatableComponent("dmlreloaded.messages.sword_levelup",new TextComponent(sword.getHoverName().getString()).withStyle(t->t.withColor(ChatFormatting.AQUA))), true);
            }
        }
    }

    public static int getPermanentWeaponDamage(ItemStack stack) {
        return NBTHelper.getInt(stack,"permDamage", 0);
    }

    public static void setPermanentWeaponDamage(ItemStack stack, int damage) {
        NBTHelper.setInt(stack,"permDamage", damage);
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

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> list, TooltipFlag flag) {
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_sword_1"));
        //list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_sword_2"));
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_sword_3").withStyle(t->t.withColor(ChatFormatting.GOLD)));
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_sword_4").withStyle(t->t.withColor(ChatFormatting.GOLD)));
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_sword_5").withStyle(t->t.withColor(ChatFormatting.GOLD)));
        list.add(new TextComponent(""));
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_sword_6", new TextComponent(Integer.toString(getPermanentWeaponDamage(stack))).withStyle(t->t.withColor(ChatFormatting.AQUA)), new TextComponent(Integer.toString(DAMAGE_BONUS_MAX)).withStyle(t->t.withColor(ChatFormatting.WHITE))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return new TranslatableComponent(super.getName(p_41458_).getString()).withStyle(t -> t.withColor(ChatFormatting.AQUA));
    }
}
