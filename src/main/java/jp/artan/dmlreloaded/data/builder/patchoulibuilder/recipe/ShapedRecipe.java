package jp.artan.dmlreloaded.data.builder.patchoulibuilder.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.Book;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import java.util.HashMap;
import java.util.Map;

public class ShapedRecipe extends Recipe<ShapedRecipe, ShapedRecipe.Properties> {

    public ShapedRecipe(Book parent) {
        super(
                parent,
                new ResourceLocation(parent.getId().getNamespace(), parent.getId().getPath() + "_recipe_shaped"),
                new ShapedRecipe.Properties()
        );
    }

    @Override
    public JsonObject serialize() {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("type", "patchouli:shaped_book_recipe");
        jsonobject.addProperty("book", this.itemId);
        JsonArray jsonarray = new JsonArray();
        for (String pattern : this.properties.pattern) {
            jsonarray.add(pattern);
        }
        jsonobject.add("pattern", jsonarray);
        JsonObject jsonobject1 = new JsonObject();
        for (Map.Entry<Character, ItemLike> define : this.properties.defines.entrySet()) {
            JsonObject jsonobject2 = new JsonObject();
            jsonobject2.addProperty("item", define.getValue().asItem().builtInRegistryHolder().key().location().toString());
            jsonobject1.add(define.getKey().toString(), jsonobject2);
        }
        jsonobject.add("key", jsonobject1);
        return jsonobject;
    }

    public static class Properties {
        private final HashMap<Character, ItemLike> defines = new HashMap<>();
        private final NonNullList<String> pattern = NonNullList.create();

        public Properties() {

        }

        public Properties define(Character key, ItemLike item) {
            this.defines.put(key, item);
            return this;
        }

        public Properties pattern(String pattern) {
            if(pattern.length() > 3) {
                throw new IllegalArgumentException("Invalid pattern: too many rows, 3 is maximum");
            }
            this.pattern.add(pattern);
            return this;
        }
    }
}
