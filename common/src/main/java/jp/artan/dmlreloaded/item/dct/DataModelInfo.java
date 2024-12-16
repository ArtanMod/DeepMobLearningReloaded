package jp.artan.dmlreloaded.item.dct;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import jp.artan.dmlreloaded.init.DMLDataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public record DataModelInfo(int tier, int killCount, int simulationCount, int totalKillCount, int totalSimulationCount) {
    public static final Codec<DataModelInfo> DATA_MODEL_INFO_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("tier").forGetter(DataModelInfo::tier),
            Codec.INT.fieldOf("killCount").forGetter(DataModelInfo::killCount),
            Codec.INT.fieldOf("simulationCount").forGetter(DataModelInfo::simulationCount),
            Codec.INT.fieldOf("totalKillCount").forGetter(DataModelInfo::totalKillCount),
            Codec.INT.fieldOf("totalSimulationCount").forGetter(DataModelInfo::totalSimulationCount)
    ).apply(instance, DataModelInfo::new));
    public static final StreamCodec<ByteBuf, DataModelInfo> DATA_MODEL_INFO_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, DataModelInfo::tier,
            ByteBufCodecs.INT, DataModelInfo::killCount,
            ByteBufCodecs.INT, DataModelInfo::simulationCount,
            ByteBufCodecs.INT, DataModelInfo::totalKillCount,
            ByteBufCodecs.INT, DataModelInfo::totalSimulationCount,
            DataModelInfo::new
    );

    public DataModelInfo() {
        this(0,0,0,0,0);
    }

    @Nullable
    private static DataModelInfo get(ItemStack stack) {
        return stack.get(DMLDataComponentType.DATA_MODEL_INFO.get());
    }

    public static int getTier(ItemStack stack) {
        DataModelInfo info = DataModelInfo.get(stack);
        return info != null ? info.tier() : 0;
    }

    public static void setTier(ItemStack stack, int tier) {
        DataModelInfo info = DataModelInfo.get(stack);
        if(info != null) {
            stack.set(DMLDataComponentType.DATA_MODEL_INFO.get(), new DataModelInfo(tier, info.killCount(), info.simulationCount(), info.totalKillCount(), info.totalSimulationCount()));
        }
    }

    public static int getKillCount(ItemStack stack) {
        DataModelInfo info = DataModelInfo.get(stack);
        return info != null ? info.killCount() : 0;
    }

    public static void setKillCount(ItemStack stack, int killCount) {
        DataModelInfo info = DataModelInfo.get(stack);
        if(info != null) {
            stack.set(DMLDataComponentType.DATA_MODEL_INFO.get(), new DataModelInfo(info.tier(), killCount, info.simulationCount(), info.totalKillCount(), info.totalSimulationCount()));
        }
    }

    public static int getSimulationCount(ItemStack stack) {
        DataModelInfo info = DataModelInfo.get(stack);
        return info != null ? info.simulationCount() : 0;
    }

    public static void setSimulationCount(ItemStack stack, int simulationCount) {
        DataModelInfo info = DataModelInfo.get(stack);
        if(info != null) {
            stack.set(DMLDataComponentType.DATA_MODEL_INFO.get(), new DataModelInfo(info.tier(), info.killCount(), simulationCount, info.totalKillCount(), info.totalSimulationCount()));
        }
    }

    public static int getTotalKillCount(ItemStack stack) {
        DataModelInfo info = DataModelInfo.get(stack);
        return info != null ? info.totalKillCount() : 0;
    }

    public static void setTotalKillCount(ItemStack stack, int totalKillCount) {
        DataModelInfo info = DataModelInfo.get(stack);
        if(info != null) {
            stack.set(DMLDataComponentType.DATA_MODEL_INFO.get(), new DataModelInfo(info.tier(), info.killCount(), info.simulationCount(), totalKillCount, info.totalSimulationCount()));
        }
    }

    public static int getTotalSimulationCount(ItemStack stack) {
        DataModelInfo info = DataModelInfo.get(stack);
        return info != null ? info.totalSimulationCount() : 0;
    }

    public static void setTotalSimulationCount(ItemStack stack, int totalSimulationCount) {
        DataModelInfo info = DataModelInfo.get(stack);
        if(info != null) {
            stack.set(DMLDataComponentType.DATA_MODEL_INFO.get(), new DataModelInfo(info.tier(), info.killCount(), info.simulationCount(), info.totalKillCount(), totalSimulationCount));
        }
    }
}
