package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;


import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#text-pages"
 */
public class TextPage extends Page<TextPage> {
    private final String text;
    private Optional<String> title = Optional.empty();

    public TextPage(Entry.Properties parent, String text) {
        super(parent, "patchouli:text");
        this.text = text;
    }

    public TextPage setTitle(String title) {
        this.title = Optional.of(title);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("text", this.text);
        this.title.ifPresent(title -> jsonobject.addProperty("title", title));
    }
}