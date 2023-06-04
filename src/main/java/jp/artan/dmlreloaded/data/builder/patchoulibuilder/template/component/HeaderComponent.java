package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;

import java.util.Optional;

public class HeaderComponent extends Component<HeaderComponent> {
    private final String text;
    private Optional<String> color = Optional.empty();
    private Optional<Boolean> centered = Optional.empty();
    private Optional<Float> scale = Optional.empty();

    public HeaderComponent(Template.Properties parent, String text) {
        super(parent, "patchouli:header");
        this.text = text;
    }

    public HeaderComponent setColor(String color) {
        this.color = Optional.of(color);
        return this;
    }

    public HeaderComponent setCentered(boolean centered) {
        this.centered = Optional.of(centered);
        return this;
    }

    public HeaderComponent setScale(float scale) {
        this.scale = Optional.of(scale);
        return this;
    }

    @Override
    protected void serializeData(com.google.gson.JsonObject jsonobject) {
        jsonobject.addProperty("text", this.text);
        this.color.ifPresent(string -> jsonobject.addProperty("color", string));
        this.centered.ifPresent(aBoolean -> jsonobject.addProperty("centered", aBoolean));
        this.scale.ifPresent(aFloat -> jsonobject.addProperty("scale", aFloat));
    }
}
