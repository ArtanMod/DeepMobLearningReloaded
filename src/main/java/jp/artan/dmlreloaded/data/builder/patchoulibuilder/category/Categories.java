package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category;


import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import jp.artan.repack.registrate.util.entry.BlockEntry;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Categories {
    private final PatchouliBuilder parent;
    private final NonNullList<Category> categories = NonNullList.create();

    public Categories(PatchouliBuilder parent) {
        this.parent = parent;
    }

    public NonNullList<Category> getCategories() {
        return this.categories;
    }

    public Category addCategory(String fileName, String lang,String description, ItemEntry<? extends Item> item) {
        return this.addCategory(fileName, lang, description, item.getId().toString());
    }

    public Category addCategory(String fileName, String lang,String description, BlockEntry<? extends Block> block) {
        return this.addCategory(fileName, lang, description, block.getId().toString());
    }

    public Category addCategory(String fileName, String lang,String description, String icon) {
        Category category = new Category(this.parent, this, categories.size(), fileName, lang, description, icon);
        this.categories.add(category);
        return category;
    }

    public PatchouliBuilder build() {
        return this.parent;
    }
}