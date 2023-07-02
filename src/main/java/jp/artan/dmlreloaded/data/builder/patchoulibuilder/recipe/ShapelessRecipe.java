package jp.artan.dmlreloaded.data.builder.patchoulibuilder.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.Book;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import java.util.Arrays;
import java.util.HashMap;

public class ShapelessRecipe extends Recipe<ShapelessRecipe, ShapelessRecipe.Properties> {
    public ShapelessRecipe(Book parent) {
        super(
                parent,
                new ResourceLocation(parent.getId().getNamespace(), parent.getId().getPath() + "_recipe_shapeless"),
                new ShapelessRecipe.Properties()
        );
    }

    @Override
    public JsonObject serialize() {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("type", "patchouli:shapeless_book_recipe");
        jsonobject.addProperty("book", this.itemId);
        JsonArray jsonarray = new JsonArray();
        for (ItemLike item : this.properties.requires) {
            JsonObject jsonobject1 = new JsonObject();
            jsonobject1.addProperty("item", item.asItem().builtInRegistryHolder().key().location().toString());
            jsonarray.add(jsonobject1);
        }
        jsonobject.add("ingredients", jsonarray);
        return jsonobject;
    }

    public static class Properties {
        private final NonNullList<ItemLike> requires = NonNullList.create();

        public Properties() { }

        public Properties requires(ItemLike item) {
            this.requires.add(item);
            return this;
        }
    }
}
