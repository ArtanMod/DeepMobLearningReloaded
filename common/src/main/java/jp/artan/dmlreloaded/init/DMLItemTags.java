package jp.artan.dmlreloaded.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class DMLItemTags {
    public static final TagKey<Item> CURIOS_DEEP_LEARNER = register(ResourceLocation.fromNamespaceAndPath("curios", "deep_learner"));

    public static TagKey<Item> register(ResourceLocation tag) {
        return TagKey.create(Registries.ITEM, tag);
    }
}
