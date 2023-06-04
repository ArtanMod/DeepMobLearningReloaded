package jp.artan.dmlreloaded.data.builder.patchoulibuilder.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.entry.Entry;

import javax.annotation.Nullable;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#quest-pages"
 */
public class QuestPage extends Page<QuestPage> {
    private @Nullable String trigger;
    private @Nullable String title;
    private @Nullable String text;

    public QuestPage(Entry.Properties parent) {
        super(parent, "patchouli:quest");
    }

    public QuestPage setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public QuestPage setTitle(String title) {
        this.title = title;
        return this;
    }

    public QuestPage setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        if(this.trigger != null) jsonobject.addProperty("trigger", this.trigger);
        if(this.title != null) jsonobject.addProperty("title", this.title);
        if(this.text != null) jsonobject.addProperty("text", this.text);
    }
}

