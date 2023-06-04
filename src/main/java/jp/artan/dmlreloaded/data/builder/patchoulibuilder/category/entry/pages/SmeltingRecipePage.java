package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#smelting-recipe-pages"
 */
public class SmeltingRecipePage extends Page<SmeltingRecipePage> {
    private final ResourceLocation recipe;
    private @Nullable ResourceLocation recipe2;
    private @Nullable String title;
    private @Nullable String text;

    public SmeltingRecipePage(Entry.Properties parent, ResourceLocation recipe) {
        super(parent, "patchouli:smelting");
        this.recipe = recipe;
    }

    public SmeltingRecipePage setRecipe2(ResourceLocation recipe2) {
        this.recipe2 = recipe2;
        return this;
    }

    public SmeltingRecipePage setTitle(String title) {
        this.title = title;
        return this;
    }

    public SmeltingRecipePage setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("recipe", this.recipe.toString());
        if(this.recipe2 != null) jsonobject.addProperty("recipe2", this.recipe2.toString());
        if(this.title != null) jsonobject.addProperty("title", this.title);
        if(this.text != null) jsonobject.addProperty("text", this.text);
    }
}

