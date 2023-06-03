package jp.artan.dmlreloaded.data.builder.patchoulibuilder.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;

import javax.annotation.Nullable;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#spotlight-pages"
 */
public class SpotlightPage extends Page<SpotlightPage> {
    private String item;
    private @Nullable String title;
    private boolean linkRecipe = false;
    private @Nullable String text;

    public SpotlightPage(PatchouliBuilder.Entry.Properties parent, String item) {
        super(parent, "patchouli:spotlight");
        this.item = item;
    }

    public SpotlightPage setTitle(String title) {
        this.title = title;
        return this;
    }

    public SpotlightPage setLinkRecipe() {
        this.linkRecipe = true;
        return this;
    }

    public SpotlightPage setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("item", this.item);
        if(this.title != null) jsonobject.addProperty("title", this.title);
        jsonobject.addProperty("link_recipe", this.linkRecipe);
        if(this.text != null) jsonobject.addProperty("text", this.text);
    }
}

