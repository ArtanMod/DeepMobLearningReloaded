package jp.artan.dmlreloaded.data.builder.patchoulibuilder.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.entry.Entry;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#entity-pages"
 */
public class EntityPage extends Page<EntityPage> {
    private final String entity;
    private Optional<Float> scale = Optional.empty();
    private Optional<Float> offset = Optional.empty();
    private boolean rotate = true;
    private Optional<Float> defaultRotation = Optional.empty();
    private @Nullable String name;
    private @Nullable String text;

    public EntityPage(Entry.Properties parent, String entity) {
        super(parent, "patchouli:entity");
        this.entity = entity;
    }

    public EntityPage setScale(float scale) {
        this.scale = Optional.of(scale);
        return this;
    }

    public EntityPage setOffset(float offset) {
        this.offset = Optional.of(offset);
        return this;
    }

    public EntityPage setNoRotate() {
        this.rotate = false;
        return this;
    }

    public EntityPage setDefaultRotation(float defaultRotation) {
        this.defaultRotation = Optional.of(defaultRotation);
        return this;
    }

    public EntityPage setName(String name) {
        this.name = name;
        return this;
    }

    public EntityPage setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("entity", this.entity);
        this.scale.ifPresent(aFloat -> jsonobject.addProperty("scale", aFloat));
        this.offset.ifPresent(aFloat -> jsonobject.addProperty("offset", aFloat));
        jsonobject.addProperty("rotate", this.rotate);
        this.defaultRotation.ifPresent(aFloat -> jsonobject.addProperty("default_rotation", aFloat));
        if(this.name != null) jsonobject.addProperty("name", this.name);
        if(this.text != null) jsonobject.addProperty("text", this.text);
    }
}

