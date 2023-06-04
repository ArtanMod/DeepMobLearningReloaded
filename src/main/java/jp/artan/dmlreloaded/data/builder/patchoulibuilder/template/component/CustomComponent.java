package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;

public class CustomComponent extends Component<CustomComponent> {
    public final String className;

    public CustomComponent(Template.Properties parent, String className) {
        super(parent, "patchouli:custom");
        this.className = className;
    }

    @Override
    protected void serializeData(com.google.gson.JsonObject jsonobject) {
        jsonobject.addProperty("class", this.className);
    }
}
