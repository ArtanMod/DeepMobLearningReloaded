package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#spotlight-pages"
 */
public class SpotlightPage extends Page<SpotlightPage> {
    private final String item;
    private Optional<String> title = Optional.empty();
    private Optional<Boolean> linkRecipe = Optional.empty();
    private Optional<String> text = Optional.empty();

    public SpotlightPage(Entry.Properties parent, String item) {
        super(parent, "patchouli:spotlight");
        this.item = item;
    }

    public SpotlightPage setTitle(String title) {
        this.title = Optional.of(title);
        return this;
    }

    public SpotlightPage setLinkRecipe(boolean linkRecipe) {
        this.linkRecipe = Optional.of(linkRecipe);
        return this;
    }

    public SpotlightPage setText(String text) {
        this.text = Optional.of(text);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("item", this.item);
        this.title.ifPresent(title -> jsonobject.addProperty("title", title));
        this.linkRecipe.ifPresent(linkRecipe -> jsonobject.addProperty("link_recipe", linkRecipe));
        this.text.ifPresent(text -> jsonobject.addProperty("text", text));
    }
}

