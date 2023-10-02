package jp.artan.dmlreloaded.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemTagInit {
    public static final TagKey<Item> CURIOS_DEEP_LEARNER = register(new ResourceLocation("curios", "deep_learner"));

    public static TagKey<Item> register(ResourceLocation tag) {
        return TagKey.create(ForgeRegistries.Keys.ITEMS, tag);
    }
}
