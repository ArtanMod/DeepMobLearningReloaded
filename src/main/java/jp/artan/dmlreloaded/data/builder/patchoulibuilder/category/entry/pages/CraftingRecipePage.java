package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;
import jp.artan.repack.registrate.util.entry.BlockEntry;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#crafting-recipe-pages"
 */
public class CraftingRecipePage extends Page<CraftingRecipePage> {
    private final ResourceLocation recipe;
    private Optional<ResourceLocation> recipe2 = Optional.empty();
    private Optional<String> title = Optional.empty();
    private Optional<String> text = Optional.empty();

    public CraftingRecipePage(Entry.Properties parent, ResourceLocation recipe) {
        super(parent, "patchouli:crafting");
        this.recipe = recipe;
    }

    public CraftingRecipePage setRecipe2(ItemEntry<? extends Item> item) {
        return this.setRecipe2(item.getId());
    }

    public CraftingRecipePage setRecipe2(BlockEntry<? extends Block> block) {
        return this.setRecipe2(block.getId());
    }

    public CraftingRecipePage setRecipe2(ResourceLocation recipe2) {
        this.recipe2 = Optional.of(recipe2);
        return this;
    }

    public CraftingRecipePage setTitle(String title) {
        this.title = Optional.of(title);
        return this;
    }

    public CraftingRecipePage setText(String text) {
        this.text = Optional.of(text);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("recipe", this.recipe.toString());
        this.recipe2.ifPresent(recipe2 -> jsonobject.addProperty("recipe2", recipe2.toString()));
        this.title.ifPresent(title -> jsonobject.addProperty("title", title));
        this.text.ifPresent(text -> jsonobject.addProperty("text", text));
    }
}
