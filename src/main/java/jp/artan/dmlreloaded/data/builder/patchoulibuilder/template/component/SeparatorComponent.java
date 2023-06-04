package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;

public class SeparatorComponent extends Component<SeparatorComponent> {

    public SeparatorComponent(Template.Properties parent) {
        super(parent, "patchouli:separator");
    }

    @Override
    protected void serializeData(com.google.gson.JsonObject jsonobject) {
    }
}
