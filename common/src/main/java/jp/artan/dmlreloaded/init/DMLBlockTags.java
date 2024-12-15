package jp.artan.dmlreloaded.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static jp.artan.dmlreloaded.DeepMobLearningReloadedMod.getResource;

public class DMLBlockTags {
    public static final TagKey<Block> INCORRECT_FOR_GLITCH_TOOL = register(getResource("incorrect_for_glitch_tool"));
    public static final TagKey<Block> INCORRECT_FOR_NETHERITE_GLITCH_TOOL = register(getResource("incorrect_for_netherite_glitch_tool"));

    public static TagKey<Block> register(ResourceLocation tag) {
        return TagKey.create(Registries.BLOCK, tag);
    }
}
