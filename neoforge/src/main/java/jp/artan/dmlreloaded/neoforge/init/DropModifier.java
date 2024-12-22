package jp.artan.dmlreloaded.neoforge.init;


import com.mojang.serialization.MapCodec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.neoforge.loot.GlitchFragmentModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DropModifier {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS);
    public static final RegistrySupplier<MapCodec<GlitchFragmentModifier>> GLITCH_FRAGMENT = GLM.register("glitch_fragment_all_entities", () -> GlitchFragmentModifier.CODEC);
}
