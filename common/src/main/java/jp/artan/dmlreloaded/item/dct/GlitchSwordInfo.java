package jp.artan.dmlreloaded.item.dct;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import jp.artan.dmlreloaded.init.DMLDataComponentType;
import jp.artan.dmlreloaded.item.ItemGlitchSword;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record GlitchSwordInfo(int permDamage) {
    public static final Codec<GlitchSwordInfo> GLITCH_SWORD_INFO_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("permDamage").forGetter(GlitchSwordInfo::permDamage)
    ).apply(instance, GlitchSwordInfo::new));
    public static final StreamCodec<ByteBuf, GlitchSwordInfo> GLITCH_SWORD_INFO_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, GlitchSwordInfo::permDamage,
            GlitchSwordInfo::new
    );
    public GlitchSwordInfo() {
        this(0);
    }

    @Nullable
    private static GlitchSwordInfo get(ItemStack stack) {
        return stack.get(DMLDataComponentType.GLITCH_SWORD_INFO.get());
    }

    public static int getPermDamage(ItemStack info) {
        GlitchSwordInfo swordInfo = GlitchSwordInfo.get(info);
        return swordInfo != null ? swordInfo.permDamage() : 0;
    }

    public static void setPermDamage(ItemStack info, int permDamage) {
        GlitchSwordInfo swordInfo = GlitchSwordInfo.get(info);
        if(swordInfo != null) {
            ItemGlitchSword item = (ItemGlitchSword) info.getItem();
            info.set(DMLDataComponentType.GLITCH_SWORD_INFO.get(), new GlitchSwordInfo(permDamage));
            info.set(DataComponents.ATTRIBUTE_MODIFIERS, new ItemAttributeModifiers(List.of(
                    new ItemAttributeModifiers.Entry(Attributes.ATTACK_DAMAGE, new AttributeModifier(ItemGlitchSword.BASE_ATTACK_DAMAGE_ID, item.getTier().getAttackDamageBonus() + swordInfo.permDamage(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND),
                    new ItemAttributeModifiers.Entry(Attributes.ATTACK_SPEED, new AttributeModifier(ItemGlitchSword.BASE_ATTACK_SPEED_ID, -2.4000000953674316D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
            ), true));
        }
    }
}
