package jp.artan.dmlreloaded.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import jp.artan.dmlreloaded.util.NBTHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ItemGlitchSword extends SwordItem {
    private static final int DAMAGE_BONUS = 1;
    private static final int DAMAGE_BONUS_MAX = 32;
    private static final int DAMAGE_INCREASE_CHANCE = 4;

    public ItemGlitchSword(Tier pTier, Properties pProperties) {
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

                player.displayClientMessage(Component.translatable("dmlreloaded.messages.sword_levelup.max", Component.literal(sword.getHoverName().getString()).withStyle(t->t.withColor(ChatFormatting.AQUA))), true);
            } else {
                player.displayClientMessage(Component.translatable("dmlreloaded.messages.sword_levelup", Component.literal(sword.getHoverName().getString()).withStyle(t->t.withColor(ChatFormatting.AQUA))), true);
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
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            // TODO: 正しく動くか要確認
            Player player = Minecraft.getInstance().player;
            if(player == null) {
                return HashMultimap.create();
            }
            ItemStack hand = player.getMainHandItem();
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", getTier().getAttackDamageBonus() + getPermanentWeaponDamage(hand), AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4000000953674316D, AttributeModifier.Operation.ADDITION));
            return builder.build();
        }
        return super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> list, TooltipFlag flag) {
        list.add(Component.translatable("dmlreloaded.hover_text.glitch_infused_sword_1"));
//        list.add(Component.translatable("dmlreloaded.hover_text.glitch_infused_sword_2"));
        list.add(Component.translatable("dmlreloaded.hover_text.glitch_infused_sword_3").withStyle(t->t.withColor(ChatFormatting.GOLD)));
        list.add(Component.translatable("dmlreloaded.hover_text.glitch_infused_sword_4").withStyle(t->t.withColor(ChatFormatting.GOLD)));
        list.add(Component.translatable("dmlreloaded.hover_text.glitch_infused_sword_5").withStyle(t->t.withColor(ChatFormatting.GOLD)));
        list.add(Component.literal(""));
        list.add(Component.translatable("dmlreloaded.hover_text.glitch_infused_sword_6", Component.literal(Integer.toString(getPermanentWeaponDamage(stack))).withStyle(t->t.withColor(ChatFormatting.AQUA)), Component.literal(Integer.toString(DAMAGE_BONUS_MAX)).withStyle(t->t.withColor(ChatFormatting.WHITE))).withStyle(t->t.withColor(ChatFormatting.GRAY)));
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable(super.getName(p_41458_).getString()).withStyle(t->t.withColor(ChatFormatting.AQUA));
    }
}
