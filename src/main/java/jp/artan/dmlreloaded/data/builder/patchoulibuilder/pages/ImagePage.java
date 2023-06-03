package jp.artan.dmlreloaded.data.builder.patchoulibuilder.pages;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;

import javax.annotation.Nullable;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#image-pages"
 */
public class ImagePage extends Page<ImagePage> {
    private final String[] images;
    private @Nullable String title;
    private boolean border = false;
    private @Nullable String text;

    public ImagePage(PatchouliBuilder.Entry.Properties parent, String ...images) {
        super(parent, "patchouli:image");
        this.images = images;
    }

    public ImagePage setTitle(String title) {
        this.title = title;
        return this;
    }

    public ImagePage setBorder() {
        this.border = true;
        return this;
    }

    public ImagePage setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        JsonArray imagesJsonArray = new JsonArray();
        for(String image : this.images) {
            imagesJsonArray.add(image);
        }
        jsonobject.add("images", imagesJsonArray);
        if(this.title != null) jsonobject.addProperty("title", this.title);
        if(this.border) jsonobject.addProperty("border", this.border);
        if(this.text != null) jsonobject.addProperty("text", this.text);
    }
}

