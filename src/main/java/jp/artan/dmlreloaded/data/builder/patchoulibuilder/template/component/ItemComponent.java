package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;

import java.util.Optional;

public class ItemComponent extends Component<ItemComponent> {
    private final String item;
    protected Optional<Boolean> framed = Optional.empty();
    protected Optional<Boolean> linkRecipe = Optional.empty();

    public ItemComponent(Template.Properties parent, String item) {
        super(parent, "patchouli:item");
        this.item = item;
    }

    public ItemComponent setFramed(boolean framed) {
        this.framed = Optional.of(framed);
        return this;
    }

    public ItemComponent setLinkRecipe(boolean linkRecipe) {
        this.linkRecipe = Optional.of(linkRecipe);
        return this;
    }

    @Override
    protected void serializeData(com.google.gson.JsonObject jsonobject) {
        jsonobject.addProperty("item", this.item);
        this.framed.ifPresent(aBoolean -> jsonobject.addProperty("framed", aBoolean));
        this.linkRecipe.ifPresent(aBoolean -> jsonobject.addProperty("link_recipe", aBoolean));
    }
}
