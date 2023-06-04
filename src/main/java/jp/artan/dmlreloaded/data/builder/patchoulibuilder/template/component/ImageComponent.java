package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;

import java.util.Optional;

public class ImageComponent extends Component<ImageComponent> {

    private final String image;
    private final int width;
    private final int height;
    private Optional<Integer> u = Optional.empty();
    private Optional<Integer> v = Optional.empty();
    private Optional<Integer> textureWidth = Optional.empty();
    private Optional<Integer> textureHeight = Optional.empty();
    private Optional<Float> scale = Optional.empty();

    public ImageComponent(Template.Properties parent, String image, int width, int height) {
        super(parent, "patchouli:image");
        this.image = image;
        this.width = width;
        this.height = height;
    }

    public ImageComponent setU(int u) {
        this.u = Optional.of(u);
        return this;
    }

    public ImageComponent setV(int v) {
        this.v = Optional.of(v);
        return this;
    }

    public ImageComponent setTextureWidth(int textureWidth) {
        this.textureWidth = Optional.of(textureWidth);
        return this;
    }

    public ImageComponent setTextureHeight(int textureHeight) {
        this.textureHeight = Optional.of(textureHeight);
        return this;
    }

    public ImageComponent setScale(float scale) {
        this.scale = Optional.of(scale);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("image", this.image);
        jsonobject.addProperty("width", this.width);
        jsonobject.addProperty("height", this.height);
        this.u.ifPresent(integer -> jsonobject.addProperty("u", integer));
        this.v.ifPresent(integer -> jsonobject.addProperty("v", integer));
        this.textureWidth.ifPresent(integer -> jsonobject.addProperty("texture_width", integer));
        this.textureHeight.ifPresent(integer -> jsonobject.addProperty("texture_height", integer));
        this.scale.ifPresent(aFloat -> jsonobject.addProperty("scale", aFloat));
    }
}
