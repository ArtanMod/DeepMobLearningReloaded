package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#entity-pages"
 */
public class EntityPage extends Page<EntityPage> {
    private final String entity;
    private Optional<Float> scale = Optional.empty();
    private Optional<Float> offset = Optional.empty();
    private Optional<Boolean> rotate = Optional.empty();
    private Optional<Float> defaultRotation = Optional.empty();
    private Optional<String> name = Optional.empty();
    private Optional<String> text = Optional.empty();

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
        this.rotate = Optional.of(false);
        return this;
    }

    public EntityPage setDefaultRotation(float defaultRotation) {
        this.defaultRotation = Optional.of(defaultRotation);
        return this;
    }

    public EntityPage setName(String name) {
        this.name = Optional.of(name);
        return this;
    }

    public EntityPage setText(String text) {
        this.text = Optional.of(text);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("entity", this.entity);
        this.scale.ifPresent(aFloat -> jsonobject.addProperty("scale", aFloat));
        this.offset.ifPresent(aFloat -> jsonobject.addProperty("offset", aFloat));
        this.rotate.ifPresent(aBoolean -> jsonobject.addProperty("rotate", aBoolean));
        this.defaultRotation.ifPresent(aFloat -> jsonobject.addProperty("default_rotation", aFloat));
        this.name.ifPresent(name -> jsonobject.addProperty("name", name));
        this.text.ifPresent(text -> jsonobject.addProperty("text", text));
    }
}

