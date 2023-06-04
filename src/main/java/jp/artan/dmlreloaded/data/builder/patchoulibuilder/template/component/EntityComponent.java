package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;

import java.util.Optional;

public class EntityComponent extends Component<EntityComponent> {
    private final String entity;
    private Optional<Integer> renderSize = Optional.empty();
    private Optional<Boolean> rotate = Optional.empty();
    private Optional<Float> defaultRotation  = Optional.empty();

    public EntityComponent(Template.Properties parent, String entity) {
        super(parent, "patchouli:entity");
        this.entity = entity;
    }

    public EntityComponent setRenderSize(int renderSize) {
        this.renderSize = Optional.of(renderSize);
        return this;
    }

    public EntityComponent setRotate(boolean rotate) {
        this.rotate = Optional.of(rotate);
        return this;
    }

    public EntityComponent setDefaultRotation(float defaultRotation) {
        this.defaultRotation = Optional.of(defaultRotation);
        return this;
    }

    @Override
    protected void serializeData(com.google.gson.JsonObject jsonobject) {
        jsonobject.addProperty("entity", this.entity);
        this.renderSize.ifPresent(integer -> jsonobject.addProperty("render_size", integer));
        this.rotate.ifPresent(aBoolean -> jsonobject.addProperty("rotate", aBoolean));
        this.defaultRotation.ifPresent(aFloat -> jsonobject.addProperty("default_rotation", aFloat));
    }
}
