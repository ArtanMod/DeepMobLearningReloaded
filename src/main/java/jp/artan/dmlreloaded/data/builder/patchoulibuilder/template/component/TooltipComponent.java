package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;
import net.minecraft.core.NonNullList;

import java.util.Optional;

public class TooltipComponent extends Component<TooltipComponent> {
    private final NonNullList<String> tooltip = NonNullList.create();
    private Optional<Integer> width;
    private Optional<Integer> height;

    public TooltipComponent(Template.Properties parent) {
        super(parent, "patchouli:tooltip");
    }

    public TooltipComponent addTooltip(String text) {
        this.tooltip.add(text);
        return this;
    }

    public TooltipComponent setWidth(int width) {
        this.width = Optional.of(width);
        return this;
    }

    public TooltipComponent setHeight(int height) {
        this.height = Optional.of(height);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        JsonArray array = new JsonArray();
        this.tooltip.forEach(array::add);
        jsonobject.add("tooltip", array);
        this.width.ifPresent(integer -> jsonobject.addProperty("width", integer));
        this.height.ifPresent(integer -> jsonobject.addProperty("height", integer));
    }
}
