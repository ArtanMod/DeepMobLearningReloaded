package jp.artan.dmlreloaded.forge.init;


import com.mojang.serialization.Codec;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.loot.GlitchFragmentModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DropModifier {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DeepMobLearningReloadedMod.MOD_ID);
    public static final RegistryObject<Codec<GlitchFragmentModifier>> GLITCH_FRAGMENT = GlitchFragmentModifier.create();
}
