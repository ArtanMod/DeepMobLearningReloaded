package jp.artan.dmlreloaded.data.builder.patchoulibuilder.recipe;

import jp.artan.dmlreloaded.data.builder.patchoulibuilder.Book;
import jp.artan.dmlreloaded.data.providers.RegistratePatchouliProvider;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.function.Function;

public abstract class Recipe<T extends Recipe<T, K>, K> implements RegistratePatchouliProvider.Result {
    protected final ResourceLocation id;
    protected final String itemId;
    protected final Book parent;
    protected final K properties;

    public Recipe(Book parent, ResourceLocation id, K properties) {
        this.parent = parent;
        this.id = id;
        this.properties = properties;
        this.itemId = parent.getId().getNamespace() + ":" + parent.getId().getPath();
    }

    public T properties(Function<K, K> properties) {
        properties.apply(this.properties);
        return (T) this;
    }

    public Book build() {
        return this.parent;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public Path getPath(Path pathIn) {
        return pathIn.resolve("data/" + this.getId().getNamespace() + "/recipes/" + this.getId().getPath() + ".json");
    }

    @Override
    public RegistratePatchouliProvider.ProviderType getProviderType() {
        return RegistratePatchouliProvider.ProviderType.BOOK_RECIPE;
    }
}
