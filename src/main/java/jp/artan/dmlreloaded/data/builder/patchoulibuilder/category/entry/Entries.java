package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry;


import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.Category;
import jp.artan.repack.registrate.util.entry.BlockEntry;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Entries {
    private final PatchouliBuilder parent;
    private final Category category;
    private final NonNullList<Entry> entries = NonNullList.create();

    public Entries(PatchouliBuilder parent, Category category) {
        this.parent = parent;
        this.category = category;
    }

    public NonNullList<Entry> getEntries() {
        return this.entries;
    }

    public Entry addEntry(String name, ItemEntry<? extends Item> itemIcon) {
        return this.addEntry(name, itemIcon.getId().toString());
    }

    public Entry addEntry(String name, BlockEntry<? extends Block> blockIcon) {
        return this.addEntry(name, blockIcon.getId().toString());
    }

    public Entry addEntry(String name, String icon) {
        String category = this.parent.modId + ":" + this.category.getCategoryId();
        Entry entry = new Entry(parent, this, this.entries.size(), name, category, icon);
        this.entries.add(entry);
        return entry;
    }

    public Category build() {
        return this.category;
    }

    public String getCategoryId() {
        return this.category.getCategoryId();
    }
}