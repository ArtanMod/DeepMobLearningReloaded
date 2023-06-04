package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#empty-pages"
 */
public class EmptyPage extends Page<EmptyPage> {
    private boolean drawFiller = true;

    public EmptyPage(Entry.Properties parent) {
        super(parent, "patchouli:empty");
    }

    public EmptyPage setNoFiller() {
        this.drawFiller = false;
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("draw_filler", this.drawFiller);
    }
}
