package jp.artan.dmlreloaded.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class DMLItemTags {
    public static final TagKey<Item> CURIOS_DEEP_LEARNER = register(new ResourceLocation("curios", "deep_learner"));

    public static TagKey<Item> register(ResourceLocation tag) {
        return TagKey.create(Registry.ITEM_REGISTRY, tag);
    }
}
