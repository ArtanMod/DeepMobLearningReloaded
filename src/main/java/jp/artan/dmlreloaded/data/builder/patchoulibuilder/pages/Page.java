package jp.artan.dmlreloaded.data.builder.patchoulibuilder.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.entry.Entry;

import javax.annotation.Nullable;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/"
 */
public abstract class Page<T extends Page<T>> {
    private final Entry.Properties parent;
    private final String type;
    private @Nullable String advancement;
    private @Nullable String flag;
    private @Nullable String anchor;

    public Page(Entry.Properties parent, String type) {
        this.parent = parent;
        this.type = type;
    }

    public T setAdvancement(String advancement) {
        this.advancement = advancement;
        return (T) this;
    }

    public T setFlag(String flag) {
        this.flag = flag;
        return (T) this;
    }

    public T setAnchor(String anchor) {
        this.anchor = anchor;
        return (T) this;
    }

    public JsonObject serialize() {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("type", this.type);
        if(this.advancement != null) jsonobject.addProperty("advancement", this.advancement);
        if(this.flag != null) jsonobject.addProperty("flag", this.flag);
        if(this.anchor != null) jsonobject.addProperty("anchor", this.anchor);
        this.serializeData(jsonobject);
        return jsonobject;
    }

    public Entry.Properties build() {
        return this.parent;
    }

    protected abstract void serializeData(JsonObject jsonobject);
}
