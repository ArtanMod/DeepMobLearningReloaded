package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#link-pages"
 */
public class LinkPage extends Page<LinkPage> {
    private final String url;
    private final String linkText;

    public LinkPage(Entry.Properties parent, String url, String linkText) {
        super(parent, "patchouli:link");
        this.url = url;
        this.linkText = linkText;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("url", this.url);
        jsonobject.addProperty("link_text", this.linkText);
    }
}
