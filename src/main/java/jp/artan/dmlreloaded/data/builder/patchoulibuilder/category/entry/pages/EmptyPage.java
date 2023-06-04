package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;

import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#empty-pages"
 */
public class EmptyPage extends Page<EmptyPage> {
    private Optional<Boolean> drawFiller = Optional.empty();

    public EmptyPage(Entry.Properties parent) {
        super(parent, "patchouli:empty");
    }

    public EmptyPage setNoFiller() {
        this.drawFiller = Optional.of(false);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        this.drawFiller.ifPresent(drawFiller -> jsonobject.addProperty("draw_filler", drawFiller));
    }
}
