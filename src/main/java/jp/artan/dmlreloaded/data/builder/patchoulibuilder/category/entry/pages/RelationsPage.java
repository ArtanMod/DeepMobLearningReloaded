package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;
import net.minecraft.core.NonNullList;

import javax.annotation.Nullable;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#relations-pages"
 */
public class RelationsPage extends Page<RelationsPage> {
    private final NonNullList<String> entries = NonNullList.create();
    private @Nullable String title;
    private @Nullable String text;

    public RelationsPage(Entry.Properties parent) {
        super(parent, "patchouli:relations");
    }

    public RelationsPage addEntry(String entry) {
        this.entries.add(entry);
        return this;
    }

    public RelationsPage setTitle(String title) {
        this.title = title;
        return this;
    }

    public RelationsPage setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        JsonObject entriesJson = new JsonObject();
        for(String entry : this.entries) {
            entriesJson.addProperty(entry, entry);
        }
        jsonobject.add("entries", entriesJson);
        if(this.title != null) jsonobject.addProperty("title", this.title);
        if(this.text != null) jsonobject.addProperty("text", this.text);
    }
}

