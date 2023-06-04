package jp.artan.dmlreloaded.data.builder;

import com.google.common.base.Preconditions;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.Book;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.Categories;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.Category;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.entry.Entry;
import jp.artan.dmlreloaded.data.providers.RegistratePatchouliProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.nio.file.Path;
import java.util.function.Consumer;

public class PatchouliBuilder {
    public final String modId;
    private final ExistingFileHelper existingFileHelper;
    private final ResourceLocation location;
    private final Book book;
    private final Categories categories;

    public PatchouliBuilder(
            String modId,
            String name,
            ExistingFileHelper existingFileHelper
    ) {
        this.modId = modId;
        this.location = new ResourceLocation(modId, name);
        this.existingFileHelper = existingFileHelper;
        this.book = new Book(this.location, this);
        this.categories = new Categories(this);
    }

    public Book book() {
        return this.book;
    }

    public Categories categories() {
        return this.categories;
    }

    public void save(Consumer<RegistratePatchouliProvider.Result> consumer) {
        consumer.accept(this.book);
        if(this.book.getRecipe() != null) {
            consumer.accept(this.book.getRecipe());
        }
        for(Category category : categories.getCategories()) {
            consumer.accept(category);
            for(Entry entry : category.getEntries()) {
                consumer.accept(entry);
            }
        }
    }

    public ResourceLocation getId() {
        return this.location;
    }

    public void existTextureFile(ResourceLocation location) {
        boolean fileExist = this.existingFileHelper.exists(location, PackType.CLIENT_RESOURCES);
        Preconditions.checkState(fileExist, "Texture at %s does not exist", location);
    }

    public static Path getBasePath(ResourceLocation location, Path pathIn, String children) {
        return pathIn.resolve("data/" + location.getNamespace() + "/patchouli_books/" + location.getPath() + children);
    }
}
