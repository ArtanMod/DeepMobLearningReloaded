package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#smelting-recipe-pages"
 */
public class SmeltingRecipePage extends Page<SmeltingRecipePage> {
    private final ResourceLocation recipe;
    private Optional<ResourceLocation> recipe2 = Optional.empty();
    private Optional<String> title = Optional.empty();
    private Optional<String> text = Optional.empty();

    public SmeltingRecipePage(Entry.Properties parent, ResourceLocation recipe) {
        super(parent, "patchouli:smelting");
        this.recipe = recipe;
    }

    public SmeltingRecipePage setRecipe2(ResourceLocation recipe2) {
        this.recipe2 = Optional.of(recipe2);
        return this;
    }

    public SmeltingRecipePage setTitle(String title) {
        this.title = Optional.of(title);
        return this;
    }

    public SmeltingRecipePage setText(String text) {
        this.text = Optional.of(text);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("recipe", this.recipe.toString());
        this.recipe2.ifPresent(recipe2 -> jsonobject.addProperty("recipe2", recipe2.toString()));
        this.title.ifPresent(title -> jsonobject.addProperty("title", title));
        this.text.ifPresent(text -> jsonobject.addProperty("text", text));
    }
}

