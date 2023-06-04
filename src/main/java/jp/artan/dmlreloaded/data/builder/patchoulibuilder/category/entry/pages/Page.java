package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/"
 */
public abstract class Page<T extends Page<T>> {
    private final Entry.Properties parent;
    private final String type;
    private Optional<String> advancement = Optional.empty();
    private Optional<String> flag = Optional.empty();
    private Optional<String> anchor = Optional.empty();

    public Page(Entry.Properties parent, String type) {
        this.parent = parent;
        this.type = type;
    }

    public T setAdvancement(String advancement) {
        this.advancement = Optional.of(advancement);
        return (T) this;
    }

    public T setFlag(String flag) {
        this.flag = Optional.of(flag);
        return (T) this;
    }

    public T setAnchor(String anchor) {
        this.anchor = Optional.of(anchor);
        return (T) this;
    }

    public JsonObject serialize() {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("type", this.type);
        this.advancement.ifPresent(advancement -> jsonobject.addProperty("advancement", advancement));
        this.flag.ifPresent(flag -> jsonobject.addProperty("flag", flag));
        this.anchor.ifPresent(anchor -> jsonobject.addProperty("anchor", anchor));
        this.serializeData(jsonobject);
        return jsonobject;
    }

    public Entry.Properties build() {
        return this.parent;
    }

    protected abstract void serializeData(JsonObject jsonobject);
}
