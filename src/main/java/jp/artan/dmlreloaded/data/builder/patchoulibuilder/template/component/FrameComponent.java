package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;

public class FrameComponent extends Component<FrameComponent> {
    public FrameComponent(Template.Properties parent) {
        super(parent, "patchouli:frame");
    }

    @Override
    protected void serializeData(com.google.gson.JsonObject jsonobject) {
    }
}
