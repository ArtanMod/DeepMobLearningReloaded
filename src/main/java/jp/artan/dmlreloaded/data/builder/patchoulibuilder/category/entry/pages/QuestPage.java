package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;

import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#quest-pages"
 */
public class QuestPage extends Page<QuestPage> {
    private Optional<String> trigger = Optional.empty();
    private Optional<String> title = Optional.empty();
    private Optional<String> text = Optional.empty();

    public QuestPage(Entry.Properties parent) {
        super(parent, "patchouli:quest");
    }

    public QuestPage setTrigger(String trigger) {
        this.trigger = Optional.of(trigger);
        return this;
    }

    public QuestPage setTitle(String title) {
        this.title = Optional.of(title);
        return this;
    }

    public QuestPage setText(String text) {
        this.text = Optional.of(text);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        this.trigger.ifPresent(trigger -> jsonobject.addProperty("trigger", trigger));
        this.title.ifPresent(title -> jsonobject.addProperty("title", title));
        this.text.ifPresent(text -> jsonobject.addProperty("text", text));
    }
}

