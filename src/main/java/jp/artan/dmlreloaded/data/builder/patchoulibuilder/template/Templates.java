package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template;

import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import net.minecraft.core.NonNullList;

public class Templates {
    private final PatchouliBuilder parent;
    private final NonNullList<Template> templates = NonNullList.create();

    public Templates(
            PatchouliBuilder parent
    ) {
        this.parent = parent;
    }

    public NonNullList<Template> getTemplates() {
        return this.templates;
    }

    public Template addTemplate(String name) {
        Template template = new Template(this.parent, this, name);
        this.templates.add(template);
        return template;
    }

    public PatchouliBuilder build() {
        return this.parent;
    }
}
