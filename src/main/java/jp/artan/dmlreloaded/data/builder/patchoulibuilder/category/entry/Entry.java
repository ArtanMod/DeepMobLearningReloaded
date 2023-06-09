package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages.*;
import jp.artan.dmlreloaded.data.providers.RegistratePatchouliProvider;
import jp.artan.repack.registrate.util.entry.BlockEntry;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static jp.artan.dmlreloaded.data.builder.PatchouliBuilder.getBasePath;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/reference/entry-json/"
 */
public class Entry implements RegistratePatchouliProvider.Result {
    private final PatchouliBuilder parent;
    private final Entries entries;
    private final Entry.Properties properties;
    protected Entry(
            PatchouliBuilder parent,
            Entries entries,
            int index,
            String name,
            String lang,
            String category,
            String icon
    ) {
        this.parent = parent;

        this.entries = entries;
        this.properties = new Entry.Properties(name, lang, category, icon, index);
    }

    public Entry properties(Function<Properties, Properties> properties) {
        properties.apply(this.properties);
        return this;
    }

    public Entries build() {
        return this.entries;
    }

    @Override
    public ResourceLocation getId() {
        return new ResourceLocation(this.parent.modId, this.getEntryId());
    }

    @Override
    public JsonObject serialize() {
        JsonObject jsonobject = new JsonObject();

        jsonobject.addProperty("name", this.properties.name);
        jsonobject.addProperty("category", this.properties.category);
        jsonobject.addProperty("icon", this.properties.icon);
        this.properties.advancement.ifPresent(advancement -> jsonobject.addProperty("advancement", advancement.toString()));
        this.properties.flag.ifPresent(flag -> jsonobject.addProperty("flag", flag));
        this.properties.priority.ifPresent(priority -> jsonobject.addProperty("priority", priority));
        this.properties.secret.ifPresent(secret -> jsonobject.addProperty("secret", secret));
        this.properties.readByDefault.ifPresent(readByDefault -> jsonobject.addProperty("read_by_default", readByDefault));
        this.properties.sortnum.ifPresent(sortnum -> jsonobject.addProperty("sortnum", sortnum));

        if(!this.properties.extraRecipeMappings.isEmpty()) {
            JsonObject extraRecipeMappingsJsonObject = new JsonObject();
            for(Map.Entry<String, Integer> extraRecipeMapping : this.properties.extraRecipeMappings.entrySet()) {
                extraRecipeMappingsJsonObject.addProperty(extraRecipeMapping.getKey(), extraRecipeMapping.getValue());
            }
            jsonobject.add("extra_recipe_mappings", extraRecipeMappingsJsonObject);
        }

        JsonArray pagesJsonArray = new JsonArray();
        for(Page page : this.properties.pages) {
            pagesJsonArray.add(page.serialize());
        }
        jsonobject.add("pages", pagesJsonArray);

        return jsonobject;
    }

    @Override
    public Path getPath(Path pathIn) {
        return getBasePath(this.parent.getId(), pathIn, "/en_us/entries/" + this.getEntryId() + ".json");
    }

    @Override
    public RegistratePatchouliProvider.ProviderType getProviderType() {
        return RegistratePatchouliProvider.ProviderType.BOOK_ENTRY;
    }

    private String getEntryId() {
        return this.getCategoryId() + "/" + this.properties.sortnum.get() + "_" + this.properties.name.replace(" ", "_").toLowerCase();
    }

    private String getCategoryId() {
        return this.entries.getCategoryId();
    }

    public static class Properties {

        private final String name;
        private final String lang;
        private final String category;
        private final String icon;
        private final NonNullList<Page<?>> pages = NonNullList.create();
        private Optional<String> advancement = Optional.empty();
        private Optional<String> flag = Optional.empty();
        private Optional<Boolean> priority = Optional.empty();
        private Optional<Boolean> secret = Optional.empty();
        private Optional<Boolean> readByDefault = Optional.empty();
        private Optional<Integer> sortnum;
        private HashMap<String, Integer> extraRecipeMappings = new HashMap<>();

        public Properties(
                String name,
                String lang,
                String category,
                String icon,
                int sortnum
        ) {
            this.name = name;
            this.lang = lang;
            this.category = category;
            this.icon = icon;
            this.sortnum = Optional.of(sortnum);
        }

        public Properties getAdvancement(String advancement) {
            this.advancement = Optional.of(advancement);
            return this;
        }

        public Properties setFlag(String flag) {
            this.flag = Optional.of(flag);
            return this;
        }

        public Properties sePriority(boolean priority) {
            this.priority = Optional.of(priority);
            return this;
        }

        public Properties setSecret(boolean secret) {
            this.secret = Optional.of(secret);
            return this;
        }

        public Properties setReadByDefault(boolean readByDefault) {
            this.readByDefault = Optional.of(readByDefault);
            return this;
        }

        public Properties setSortnum(int sortnum) {
            this.sortnum = Optional.of(sortnum);
            return this;
        }

        public Properties addExtraRecipeMapping(ItemStack itemStack, int page) {
            this.extraRecipeMappings.put(itemStack.getDescriptionId(), page);
            return this;
        }

        public TextPage addTextPage(String text) {
            TextPage page = new TextPage(this, text);
            this.pages.add(page);
            return page;
        }

        public ImagePage addImagePage(String image) {
            ImagePage page = new ImagePage(this, image);
            this.pages.add(page);
            return page;
        }

        public CraftingRecipePage addCraftingRecipePage(ItemEntry<? extends Item> item) {
            return this.addCraftingRecipePage(item.getId());
        }

        public CraftingRecipePage addCraftingRecipePage(BlockEntry<? extends Block> block) {
            return this.addCraftingRecipePage(block.getId());
        }

        public CraftingRecipePage addCraftingRecipePage(ResourceLocation recipe) {
            CraftingRecipePage page = new CraftingRecipePage(this, recipe);
            this.pages.add(page);
            return page;
        }

        public SmeltingRecipePage addSmeltingRecipePage(ResourceLocation recipe) {
            SmeltingRecipePage page = new SmeltingRecipePage(this, recipe);
            this.pages.add(page);
            return page;
        }

        public MultiblockPage addMultiblockPage(String name) {
            MultiblockPage page = new MultiblockPage(this, name);
            this.pages.add(page);
            return page;
        }

        public EntityPage addEntityPage(String entity) {
            EntityPage page = new EntityPage(this, entity);
            this.pages.add(page);
            return page;
        }

        public SpotlightPage addSpotlightPage(ItemEntry<? extends Item> item) {
            return this.addSpotlightPage(item.getId().toString());
        }

        public SpotlightPage addSpotlightPage(BlockEntry<? extends Block> block) {
            return this.addSpotlightPage(block.getId().toString());
        }

        public SpotlightPage addSpotlightPage(String item) {
            SpotlightPage page = new SpotlightPage(this, item);
            this.pages.add(page);
            return page;
        }

        public LinkPage addRelatedPage(String url, String linkText) {
            LinkPage page = new LinkPage(this, url, linkText);
            this.pages.add(page);
            return page;
        }

        public RelationsPage addRelatedPage() {
            RelationsPage page = new RelationsPage(this);
            this.pages.add(page);
            return page;
        }

        public QuestPage addQuestPage() {
            QuestPage page = new QuestPage(this);
            this.pages.add(page);
            return page;
        }

        public EmptyPage addEmptyPage() {
            EmptyPage page = new EmptyPage(this);
            this.pages.add(page);
            return page;
        }

    }
}
