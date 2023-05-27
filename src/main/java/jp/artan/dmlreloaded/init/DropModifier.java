package jp.artan.dmlreloaded.init;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.loot.GlitchFragmentModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DropModifier {
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, DeepMobLearningReloaded.MOD_ID);
    public static final RegistryObject<GlitchFragmentModifier.Serializer> GLITCH_FRAGMENT = GLM.register("glitch_fragment_all_entities", GlitchFragmentModifier.Serializer::new);

    public static void register() {}
}
