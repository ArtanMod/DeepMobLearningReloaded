package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#image-pages"
 */
public class ImagePage extends Page<ImagePage> {
    private final String[] images;
    private Optional<String> title = Optional.empty();
    private Optional<Boolean> border = Optional.empty();
    private Optional<String> text = Optional.empty();

    public ImagePage(Entry.Properties parent, String ...images) {
        super(parent, "patchouli:image");
        this.images = images;
    }

    public ImagePage setTitle(String title) {
        this.title = Optional.of(title);
        return this;
    }

    public ImagePage setBorder(boolean border) {
        this.border = Optional.of(border);
        return this;
    }

    public ImagePage setText(String text) {
        this.text = Optional.of(text);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        JsonArray imagesJsonArray = new JsonArray();
        for(String image : this.images) {
            imagesJsonArray.add(image);
        }
        jsonobject.add("images", imagesJsonArray);
        this.title.ifPresent(title -> jsonobject.addProperty("title", title));
        this.border.ifPresent(border -> jsonobject.addProperty("border", border));
        this.text.ifPresent(text -> jsonobject.addProperty("text", text));
    }
}

