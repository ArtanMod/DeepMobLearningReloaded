package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category;


import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.entry.Entries;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.entry.Entry;
import jp.artan.dmlreloaded.data.providers.RegistratePatchouliProvider;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.function.Function;

import static jp.artan.dmlreloaded.data.builder.PatchouliBuilder.getBasePath;

public class Category implements RegistratePatchouliProvider.Result {
    private final PatchouliBuilder parent;
    private final Categories categories;
    private final Category.Properties properties;
    private final Entries entries;

    public Category(
            PatchouliBuilder parent,
            Categories categories,
            int index,
            String name,
            String description,
            String icon
    ) {
        this.parent = parent;
        this.categories = categories;
        this.properties = new Category.Properties(name, description, icon, index);
        this.entries = new Entries(parent, this);
    }

    public NonNullList<Entry> getEntries() {
        return this.entries.getEntries();
    }

    public Category properties(Function<Properties, Properties> properties) {
        properties.apply(this.properties);
        return this;
    }

    public Entries entries() {
        return this.entries;
    }

    public Categories build() {
        return this.categories;
    }

    @Override
    public ResourceLocation getId() {
        return new ResourceLocation(this.parent.modId, this.getCategoryId());
    }

    @Override
    public JsonObject serialize() {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("name", this.properties.name);
        jsonobject.addProperty("description", this.properties.description);
        jsonobject.addProperty("icon", this.properties.icon);
        if(this.properties.parent != null) jsonobject.addProperty("parent", this.properties.parent);
        if(this.properties.flag != null) jsonobject.addProperty("flag", this.properties.flag);
        jsonobject.addProperty("sortnum", this.properties.sortnum);
        jsonobject.addProperty("secret", this.properties.secret);
        return jsonobject;
    }

    @Override
    public Path getPath(Path pathIn) {
        return getBasePath(this.parent.getId(), pathIn, "/en_us/categories/" + this.getCategoryId() + ".json");
    }

    @Override
    public RegistratePatchouliProvider.ProviderType getProviderType() {
        return RegistratePatchouliProvider.ProviderType.BOOK_CATEGORY;
    }

    public String getCategoryId() {
        return this.properties.sortnum + "_" + this.properties.name.replace(" ", "_").toLowerCase();
    }

    /**
     * @see "https://vazkiimods.github.io/Patchouli/docs/reference/category-json/"
     */
    public static class Properties {
        private final String name;
        private final String description;
        private final String icon;
        private @Nullable String parent;
        private @Nullable String flag;
        private int sortnum;
        private boolean secret = false;
        public Properties(
                String name,
                String description,
                String icon,
                int sortnum
        ) {
            this.name = name;
            this.description = description;
            this.icon = icon;
            this.sortnum = sortnum;
        }

        public Properties setParent(String parent) {
            this.parent = parent;
            return this;
        }

        public Properties setFlag(String flag) {
            this.flag = flag;
            return this;
        }

        public Properties setSortnum(int sortnum) {
            this.sortnum = sortnum;
            return this;
        }

        public Properties setSecret() {
            this.secret = true;
            return this;
        }
    }
}
