package jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.component;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.template.Template;

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class Component<T extends Component<T>> {
    protected final Template.Properties parent;
    protected final String type;
    protected Optional<Integer> x = Optional.empty();
    protected Optional<Integer> y = Optional.empty();
    protected @Nullable String advancement;
    protected boolean negateAdvancement = false;
    protected @Nullable String guard;
    protected @Nullable String flag;
    protected @Nullable String group;


    public Component(Template.Properties parent, String type) {
        this.parent = parent;
        this.type = type;
    }

    public T setX(int x) {
        this.x = Optional.of(x);
        return (T) this;
    }

    public T setY(int y) {
        this.y = Optional.of(y);
        return (T) this;
    }

    public T setAdvancement(@Nullable String advancement) {
        this.advancement = advancement;
        return (T) this;
    }

    public T setNegateAdvancement(boolean negateAdvancement) {
        this.negateAdvancement = negateAdvancement;
        return (T) this;
    }

    public T setGuard(@Nullable String guard) {
        this.guard = guard;
        return (T) this;
    }

    public T setFlag(@Nullable String flag) {
        this.flag = flag;
        return (T) this;
    }

    public T setGroup(@Nullable String group) {
        this.group = group;
        return (T) this;
    }

    public JsonObject serialize() {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("type", this.type);
        this.x.ifPresent(integer -> jsonobject.addProperty("x", integer));
        this.y.ifPresent(integer -> jsonobject.addProperty("y", integer));
        if(this.advancement != null) jsonobject.addProperty("advancement", this.advancement);
        if(this.negateAdvancement) jsonobject.addProperty("negate_advancement", this.negateAdvancement);
        if(this.guard != null) jsonobject.addProperty("guard", this.guard);
        if(this.flag != null) jsonobject.addProperty("flag", this.flag);
        if(this.group != null) jsonobject.addProperty("group", this.group);
        this.serializeData(jsonobject);
        return jsonobject;
    }

    public Template.Properties build() {
        return this.parent;
    }

    protected abstract void serializeData(JsonObject jsonobject);
}
