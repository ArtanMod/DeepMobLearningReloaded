package jp.artan.dmlreloaded.item.dct;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import jp.artan.dmlreloaded.init.DMLDataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

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
            info.set(DMLDataComponentType.GLITCH_SWORD_INFO.get(), new GlitchSwordInfo(permDamage));
        }
    }
}
