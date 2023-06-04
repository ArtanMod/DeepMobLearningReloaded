package jp.artan.dmlreloaded.data.builder.patchoulibuilder.pages;


import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.entry.Entry;

import javax.annotation.Nullable;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#text-pages"
 */
public class TextPage extends Page<TextPage> {
    private final String text;
    private @Nullable String title;

    public TextPage(Entry.Properties parent, String text) {
        super(parent, "patchouli:text");
        this.text = text;
    }

    public TextPage setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("text", this.text);
        if(this.title != null) jsonobject.addProperty("title", this.title);
    }
}