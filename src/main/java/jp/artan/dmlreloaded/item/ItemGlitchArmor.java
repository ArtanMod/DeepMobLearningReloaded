package jp.artan.dmlreloaded.item;

import io.netty.util.internal.ThreadLocalRandom;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.config.BalanceConfigs;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.util.DataModelHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemGlitchArmor extends ArmorItem{

    private static final int PRISTINE_SET_CHANCE = 16;
    private static final int FRAGMENT_SET_CHANCE = 6;
    private static final int HEART_SET_CHANCE = 1;
    private static final int PRISTINE_SET_NUMBER_OF_DROPS = 2;

    public ItemGlitchArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }


    public static boolean isSetEquippedByPlayer(ServerPlayer player) {
        Item glitchHelmet = player.getItemBySlot(EquipmentSlot.HEAD).getItem();
        Item glitchChestplate = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        Item glitchLeggings = player.getItemBySlot(EquipmentSlot.LEGS).getItem();
        Item glitchBoots = player.getItemBySlot(EquipmentSlot.FEET).getItem();

        // すべての装備がGlitchArmorであるか
        boolean isSetEquipped = glitchHelmet instanceof ItemGlitchArmor &&
                glitchChestplate instanceof ItemGlitchArmor &&
                glitchLeggings instanceof ItemGlitchArmor &&
                glitchBoots instanceof ItemGlitchArmor;
        if(isSetEquipped) {
            // すべての装備のMaterialが同じであるか
            return ((ItemGlitchArmor)glitchHelmet).getMaterial() == ((ItemGlitchArmor)glitchChestplate).getMaterial() &&
                    ((ItemGlitchArmor)glitchHelmet).getMaterial() == ((ItemGlitchArmor)glitchLeggings).getMaterial() &&
                    ((ItemGlitchArmor)glitchHelmet).getMaterial() == ((ItemGlitchArmor)glitchBoots).getMaterial();
        }
        return false;
    }

    public static boolean isFlyEnabledAndFullSet(ServerPlayer player) {
        return isSetEquippedByPlayer(player) && BalanceConfigs.isGlitchArmorCreativeFlightEnabled.get();
    }

    public static void dropPristineMatter(Level level, BlockPos blockPos, ItemStack stack) {
        if(ThreadLocalRandom.current().nextInt(1, 100) <= PRISTINE_SET_CHANCE) {
            MobMetaData meta = DataModelHelper.getMobMetaData(stack);
            ItemEntity drop = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), meta.getPristineMatterStack(PRISTINE_SET_NUMBER_OF_DROPS));
            drop.setDefaultPickUpDelay();
            level.addFreshEntity(drop);
        }
    }

    public static void dropGlitchFragment(Level level, BlockPos blockPos) {
        if(ThreadLocalRandom.current().nextInt(1, 100) <= FRAGMENT_SET_CHANCE) {
            ItemEntity drop = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ItemInit.GLITCH_FRAGMENT.get(),1));
            drop.setDefaultPickUpDelay();
            level.addFreshEntity(drop);
        }
    }

    public static void dropGlitchHeart(Level level, BlockPos blockPos) {
        if(ThreadLocalRandom.current().nextInt(1, 100) <= HEART_SET_CHANCE) {
            ItemEntity drop = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ItemInit.GLITCH_HEART.get(),1));
            drop.setDefaultPickUpDelay();
            level.addFreshEntity(drop);
        }
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return new TranslatableComponent(super.getName(p_41458_).getString()).withStyle(t -> t.withColor(ChatFormatting.AQUA));
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_armor_1"));
        //list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_armor_2"));
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_armor_3", new TextComponent(Integer.toString(PRISTINE_SET_CHANCE)), new TextComponent(Integer.toString(PRISTINE_SET_NUMBER_OF_DROPS))).withStyle(t->t.withColor(ChatFormatting.GOLD)));
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_armor_4").withStyle(t->t.withColor(ChatFormatting.GOLD)));
        list.add(new TranslatableComponent("dmlreloaded.hover_text.glitch_infused_armor_5").withStyle(t->t.withColor(ChatFormatting.GOLD)));
    }
}

