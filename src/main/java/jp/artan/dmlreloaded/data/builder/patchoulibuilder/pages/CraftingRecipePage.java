package jp.artan.dmlreloaded.data.builder.patchoulibuilder.pages;

import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.entry.Entry;
import jp.artan.repack.registrate.util.entry.BlockEntry;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#crafting-recipe-pages"
 */
public class CraftingRecipePage extends Page<CraftingRecipePage> {
    private final ResourceLocation recipe;
    private @Nullable ResourceLocation recipe2;
    private @Nullable String title;
    private @Nullable String title2;
    private @Nullable String text;

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
        this.recipe2 = recipe2;
        return this;
    }

    public CraftingRecipePage setTitle(String title) {
        this.title = title;
        return this;
    }

    public CraftingRecipePage setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("recipe", this.recipe.toString());
        if(this.recipe2 != null) jsonobject.addProperty("recipe2", this.recipe2.toString());
        if(this.title != null) jsonobject.addProperty("title", this.title);
        if(this.text != null) jsonobject.addProperty("text", this.text);
    }
}
