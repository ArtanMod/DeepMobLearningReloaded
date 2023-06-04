package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component.*;
import jp.artan.dmlreloaded.data.providers.RegistratePatchouliProvider;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.function.Function;

import static jp.artan.dmlreloaded.data.builder.PatchouliBuilder.getBasePath;

public class Template implements RegistratePatchouliProvider.Result {
    private final ResourceLocation id;
    private final PatchouliBuilder parent;
    private final Templates templates;
    private final String name;
    private final Properties properties;

    public Template(PatchouliBuilder parent, Templates templates, String name) {
        this.id = new ResourceLocation(parent.modId, name);
        this.parent = parent;
        this.templates = templates;
        this.name = name;
        this.properties = new Properties();
    }

    public Template properties(Function<Properties, Properties> properties) {
        properties.apply(this.properties);
        return this;
    }

    public Templates build() {
        return this.templates;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public JsonObject serialize() {
        JsonObject jsonObject = new JsonObject();
        JsonArray components = new JsonArray();
        for(Component<?> component : this.properties.components) {
            components.add(component.serialize());
        }
        jsonObject.add("components", components);
        return jsonObject;
    }

    @Override
    public Path getPath(Path pathIn) {
        return getBasePath(this.parent.getId(), pathIn, "/en_us/templates/" + this.getTemplateId() + ".json");
    }

    @Override
    public RegistratePatchouliProvider.ProviderType getProviderType() {
        return RegistratePatchouliProvider.ProviderType.BOOK_TEMPLATE;
    }

    public String getTemplateId() {
        return this.name;
    }

    public static class Properties {
        private final NonNullList<Component<?>> components = NonNullList.create();

        public Properties() {

        }

        public TextComponent addTextComponent(String text) {
            TextComponent component = new TextComponent(this, text);
            this.components.add(component);
            return component;
        }

        public ItemComponent addItemComponent(String item) {
            ItemComponent component = new ItemComponent(this, item);
            this.components.add(component);
            return component;
        }

        public ImageComponent addImageComponent(String image, int width, int height) {
            ImageComponent component = new ImageComponent(this, image, width, height);
            this.components.add(component);
            return component;
        }

        public HeaderComponent addHeaderComponent(String text) {
            HeaderComponent component = new HeaderComponent(this, text);
            this.components.add(component);
            return component;
        }

        public EntityComponent addEntityComponent(String entity) {
            EntityComponent component = new EntityComponent(this, entity);
            this.components.add(component);
            return component;
        }

        public SeparatorComponent addSeparatorComponent() {
            SeparatorComponent component = new SeparatorComponent(this);
            this.components.add(component);
            return component;
        }

        public FrameComponent addFrameComponent() {
            FrameComponent component = new FrameComponent(this);
            this.components.add(component);
            return component;
        }

        public TooltipComponent addTooltipComponent() {
            TooltipComponent component = new TooltipComponent(this);
            this.components.add(component);
            return component;
        }

        public CustomComponent addCustomComponent(String className) {
            CustomComponent component = new CustomComponent(this, className);
            this.components.add(component);
            return component;
        }
    }
}
