package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;

import javax.annotation.Nullable;
import java.util.Optional;

public class TextComponent extends Component<TextComponent> {
    private final String text;
    private @Nullable String color;
    protected Optional<Integer> maxWidth = Optional.empty();
    protected Optional<Integer> maxHeight = Optional.empty();

    public TextComponent(Template.Properties parent, String text) {
        super(parent, "patchouli:text");
        this.text = text;
    }

    public TextComponent setColor(@Nullable String color) {
        this.color = color;
        return this;
    }

    public TextComponent setMaxWidth(int maxWidth) {
        this.maxWidth = Optional.of(maxWidth);
        return this;
    }

    public TextComponent setMaxHeight(int maxHeight) {
        this.maxHeight = Optional.of(maxHeight);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        if(this.color != null) jsonobject.addProperty("color", this.color);
        this.maxWidth.ifPresent(integer -> jsonobject.addProperty("max_width", integer));
        this.maxHeight.ifPresent(integer -> jsonobject.addProperty("max_height", integer));
    }
}
