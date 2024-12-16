package jp.artan.dmlreloaded.init;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.netty.buffer.ByteBuf;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.item.dct.DataModelInfo;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.Nullable;

public class DMLDataComponentType {
    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.DATA_COMPONENT_TYPE);

    public static final RegistrySupplier<DataComponentType<DataModelInfo>> DATA_MODEL_INFO = register("data_model_info", DataModelInfo.DATA_MODEL_INFO_CODEC, DataModelInfo.DATA_MODEL_INFO_STREAM_CODEC);

    public static void register() {
        DATA_COMPONENT_TYPE.register();
    }

    private static <T> RegistrySupplier<DataComponentType<T>> register(String name, Codec<T> codec, StreamCodec<ByteBuf, T> streamCodec) {
        return DATA_COMPONENT_TYPE.register(DeepMobLearningReloadedMod.getResource(name), () -> new DataComponentType<T>() {
            @Override
            public @Nullable Codec<T> codec() {
                return codec;
            }

            @Override
            public StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
                return streamCodec;
            }
        });
    }

}
