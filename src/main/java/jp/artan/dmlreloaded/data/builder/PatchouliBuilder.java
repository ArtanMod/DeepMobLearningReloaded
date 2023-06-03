package jp.artan.dmlreloaded.data.builder;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.artansprojectcoremod.tabs.CreativeTab;
import jp.artan.dmlreloaded.data.providers.RegistratePatchouliProvider;
import jp.artan.repack.registrate.util.entry.BlockEntry;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class PatchouliBuilder {
    protected final String modId;
    private final ExistingFileHelper existingFileHelper;
    protected final ResourceLocation location;
    private final PatchouliBuilder.Book book;
    private final PatchouliBuilder.Categories categories;

    public PatchouliBuilder(
            String modId,
            String name,
            ExistingFileHelper existingFileHelper
    ) {
        this.modId = modId;
        this.location = new ResourceLocation(modId, name);
        this.existingFileHelper = existingFileHelper;
        this.book = new PatchouliBuilder.Book(this.location, this);
        this.categories = new PatchouliBuilder.Categories(this);
    }

    public PatchouliBuilder.Book book() {
        return this.book;
    }

    public PatchouliBuilder.Categories categories() {
        return this.categories;
    }

    public void save(Consumer<RegistratePatchouliProvider.Result> consumer) {
        consumer.accept(this.book);
        for(Category category : categories.categories) {
            consumer.accept(category);
            for(Entry entry : category.entries.entries) {
                consumer.accept(entry);
            }
        }
    }

    protected ResourceLocation getId() {
        return this.location;
    }

    protected void existTextureFile(ResourceLocation location) {
        boolean fileExist = this.existingFileHelper.exists(location, PackType.CLIENT_RESOURCES);
        Preconditions.checkState(fileExist, "Texture at %s does not exist", location);
    }

    public static class Book implements RegistratePatchouliProvider.Result {
        private final ResourceLocation id;
        private final PatchouliBuilder parent;
        private final PatchouliBuilder.Book.Properties properties;
        protected Book(
                ResourceLocation id,
                PatchouliBuilder parent
        ) {
            this.id = id;
            this.parent = parent;
            this.properties = new PatchouliBuilder.Book.Properties(this);
        }

        public PatchouliBuilder.Book properties(Function<Book.Properties, Book.Properties> properties) {
            properties.apply(this.properties);
            return this;
        }

        public PatchouliBuilder build() {
            return this.parent;
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public JsonObject serialize() {
            JsonObject jsonobject = new JsonObject();
            if(this.properties.name != null) jsonobject.addProperty("name", this.properties.name);
            if(this.properties.landingText != null) jsonobject.addProperty("landing_text", this.properties.landingText);
            if(this.properties.bookTexture != null) jsonobject.addProperty("book_texture", this.properties.bookTexture);
            if(this.properties.fillerTexture != null) jsonobject.addProperty("filler_texture", this.properties.fillerTexture);
            if(this.properties.craftingTexture != null) jsonobject.addProperty("crafting_texture", this.properties.craftingTexture);
            if(this.properties.model != null) jsonobject.addProperty("model", this.properties.model);
            if(this.properties.textColor != null) jsonobject.addProperty("text_color", this.properties.textColor);
            if(this.properties.headerColor != null) jsonobject.addProperty("header_color", this.properties.headerColor);
            if(this.properties.nameplateColor != null) jsonobject.addProperty("nameplate_color", this.properties.nameplateColor);
            if(this.properties.linkColor != null) jsonobject.addProperty("link_color", this.properties.linkColor);
            if(this.properties.linkHoverColor != null) jsonobject.addProperty("link_hover_color", this.properties.linkHoverColor);
            if(this.properties.progressBarColor != null) jsonobject.addProperty("progress_bar_color", this.properties.progressBarColor);
            if(this.properties.progressBarBackground != null) jsonobject.addProperty("progress_bar_background", this.properties.progressBarBackground);
            if(this.properties.openSound != null) jsonobject.addProperty("open_sound", this.properties.openSound);
            if(this.properties.flipSound != null) jsonobject.addProperty("flip_sound", this.properties.flipSound);
            if(this.properties.indexIcon != null) jsonobject.addProperty("index_icon", this.properties.indexIcon);
            if(this.properties.pamphlet != null) jsonobject.addProperty("pamphlet", this.properties.pamphlet);
            jsonobject.addProperty("show_progress", this.properties.showProgress);
            if(this.properties.version != null) jsonobject.addProperty("version", this.properties.version);
            if(this.properties.subtitle != null) jsonobject.addProperty("subtitle", this.properties.subtitle);
            if(this.properties.creativeTab != null) jsonobject.addProperty("creative_tab", this.properties.creativeTab);
            if(this.properties.advancementsTab != null) jsonobject.addProperty("advancements_tab", this.properties.advancementsTab);
            jsonobject.addProperty("dont_generate_book", this.properties.dontGenerateBook);
            if(this.properties.customBookItem != null) jsonobject.addProperty("custom_book_item", this.properties.customBookItem);
            jsonobject.addProperty("show_toasts", this.properties.showToasts);
            jsonobject.addProperty("use_blocky_font", this.properties.useBlockyFont);
            jsonobject.addProperty("i18n", this.properties.i18n);
            JsonObject macrosJsonobject = new JsonObject();
            for(String key : this.properties.macros.keySet()) {
                macrosJsonobject.addProperty(key, this.properties.macros.get(key));
            }
            if(!this.properties.macros.isEmpty()) jsonobject.add("macros", macrosJsonobject);
            jsonobject.addProperty("pause_game", this.properties.pauseGame);
            if(this.properties.textOverflowMode != null) jsonobject.addProperty("text_overflow_mode", this.properties.textOverflowMode.getMode());
            if(this.properties.extend != null) jsonobject.addProperty("extend", this.properties.extend);
            jsonobject.addProperty("allow_extensions", this.properties.allowExtensions);
            return jsonobject;
        }

        @Override
        public Path getPath(Path pathIn) {
            return getBasePath(this.parent.getId(), pathIn, "/book.json");
        }

        @Override
        public RegistratePatchouliProvider.ProviderType getProviderType() {
            return RegistratePatchouliProvider.ProviderType.BOOK_ITEM;
        }

        /**
         * @see "https://vazkiimods.github.io/Patchouli/docs/reference/book-json/"
         */
        public static class Properties {
            protected final Book parent;
            private @Nullable String name;
            private @Nullable String landingText;
            private @Nullable String bookTexture;
            private @Nullable String fillerTexture;
            private @Nullable String craftingTexture;
            private @Nullable String model;
            private @Nullable String textColor;
            private @Nullable String headerColor;
            private @Nullable String nameplateColor;
            private @Nullable String linkColor;
            private @Nullable String linkHoverColor;
            private @Nullable String progressBarColor;
            private @Nullable String progressBarBackground;
            private @Nullable String openSound;
            private @Nullable String flipSound;
            private @Nullable String indexIcon;
            private @Nullable String pamphlet;
            private boolean showProgress = true;
            private @Nullable String version;
            private @Nullable String subtitle;
            private @Nullable String creativeTab;
            private @Nullable String advancementsTab;
            private boolean dontGenerateBook = false;
            private @Nullable String customBookItem;
            private boolean showToasts  = true;
            private boolean useBlockyFont = false;
            private boolean i18n = false;
            private HashMap<String, String> macros = new HashMap<>();
            private boolean pauseGame  = false;
            private @Nullable OverflowMode textOverflowMode;
            private @Nullable String extend;
            private boolean allowExtensions = true;

            public Properties(Book parent) {
                this.parent = parent;
            }

            /**
             * The name of the book that will be displayed in the book item and the GUI. For modders, this can be a localization key.
             */
            public Properties setName(String name) {
                this.name = name;
                return this;
            }

            /**
             * The text that will be displayed in the landing page of your book. This text can be formatted. For modders, this can be a localization key.
             */
            public Properties setLandingText(String landingText) {
                this.landingText = landingText;
                return this;
            }

            public Properties setBookTexture(ResourceLocation bookTexturePath) {
                this.bookTexture = this.getTexturePath(bookTexturePath);
                return this;
            }

            public Properties setBookTextureNoConfirmation(ResourceLocation bookTexturePath) {
                this.bookTexture = bookTexturePath.toString();
                return this;
            }

            public Properties setBookTexture(DefaultTextureColor bookTexture) {
                this.bookTexture = bookTexture.getBookGuiTexture();
                return this;
            }

            public Properties setFillerTexture(String fillerTexture) {
                this.fillerTexture = fillerTexture;
                return this;
            }

            public Properties setCrafterTexture(ResourceLocation craftingTexturePath) {
                this.craftingTexture = this.getTexturePath(craftingTexturePath);
                return this;
            }
            public Properties setCrafterTextureNoConfirmation(ResourceLocation craftingTexturePath) {
                this.craftingTexture = craftingTexturePath.toString();
                return this;
            }

            public Properties setModel(ResourceLocation bookTextureLocation) {
                this.model = bookTextureLocation.toString();
                return this;
            }

            public Properties setModel(DefaultTextureColor bookTexture) {
                this.model = bookTexture.getBookGuiTexture();
                return this;
            }

            /**
             * @param textColor 0xRRGGBB
             */
            public Properties setTextColor(int textColor) {
                this.textColor = String.format("%X", textColor);
                return this;
            }

            /**
             * @param headerColor 0xRRGGBB
             */
            public Properties setHeaderColor(int headerColor) {
                this.headerColor = String.format("%X", headerColor);
                return this;
            }

            /**
             * @param nameplateColor 0xRRGGBB
             */
            public Properties setNameplateColor(int nameplateColor) {
                this.nameplateColor = String.format("%X", nameplateColor);
                return this;
            }

            /**
             * @param linkColor 0xRRGGBB
             */
            public Properties setLinkColor(int linkColor) {
                this.linkColor = String.format("%X", linkColor);
                return this;
            }

            /**
             * @param linkHoverColor 0xRRGGBB
             */
            public Properties setLinkHoverColor(int linkHoverColor) {
                this.linkHoverColor = String.format("%X", linkHoverColor);
                return this;
            }

            /**
             * @param progressBarColor 0xRRGGBB
             */
            public Properties setProgressBarColor(int progressBarColor) {
                this.progressBarColor = String.format("%X", progressBarColor);
                return this;
            }

            /**
             * @param progressBarBackground 0xRRGGBB
             */
            public Properties setProgressBarBackground(int progressBarBackground) {
                this.progressBarBackground = String.format("%X", progressBarBackground);
                return this;
            }

            public Properties setOpenSound(ResourceLocation openSound) {
                this.openSound = openSound.toString();
                return this;
            }

            public Properties setFlipSound(ResourceLocation flipSound) {
                this.flipSound = flipSound.toString();
                return this;
            }

            public Properties setIndexIcon(ResourceLocation indexIcon) {
                this.indexIcon = indexIcon.toString();
                return this;
            }

            public Properties setPamphlet(ResourceLocation pamphlet) {
                this.pamphlet = pamphlet.toString();
                return this;
            }

            public Properties setHiddenShowProgress() {
                this.showProgress = false;
                return this;
            }

            public Properties setVersion(String version) {
                this.version = version;
                return this;
            }

            public Properties setSubtitle(String subtitle) {
                this.subtitle = subtitle;
                return this;
            }

            public Properties setCreativeTab(String creativeTab) {
                this.creativeTab = creativeTab;
                return this;
            }

            public Properties setCreativeTab(CreativeTab creativeTab) {
                this.creativeTab = ((TranslatableComponent)creativeTab.getDisplayName()).getKey().replace("itemGroup.", "");
                return this;
            }

            public Properties setAdvancementsTab(String advancementsTab) {
                this.advancementsTab = advancementsTab;
                return this;
            }

            public Properties setDontGenerateBook() {
                this.dontGenerateBook = true;
                return this;
            }

            public Properties setCustomBookItem(String namespace, String path) {
                this.customBookItem = namespace + ":" + path;
                return this;
            }

            public Properties setCustomBookItem(String namespace, String path, int count) {
                this.customBookItem = setCustomBookItem(namespace, path) + "#" + count;
                return this;
            }

            public Properties setCustomBookItem(String namespace, String path, String nbtStr) {
                this.customBookItem = setCustomBookItem(namespace, path) + nbtStr;
                return this;
            }

            public Properties setCustomBookItem(String namespace, String path, int count, String nbtStr) {
                this.customBookItem = setCustomBookItem(namespace, path, count) + nbtStr;
                return this;
            }

            public Properties setHideShowToasts() {
                this.showToasts = false;
                return this;
            }

            public Properties setUseFont() {
                this.useBlockyFont = true;
                return this;
            }

            public Properties setI18n() {
                this.i18n = true;
                return this;
            }

            public Properties addMacros(String key, String value) {
                this.macros.put(key, value);
                return this;
            }

            public Properties setPauseGame() {
                this.pauseGame = true;
                return this;
            }

            public Properties setOverflowMode(OverflowMode overflowMode) {
                this.textOverflowMode = overflowMode;
                return this;
            }

            public Properties setExtend(String extend) {
                this.extend = extend;
                return this;
            }

            public Properties setDisableExtensions() {
                this.allowExtensions = false;
                return this;
            }

            private String getTexturePath(ResourceLocation location) {
                this.parent.parent.existTextureFile(location);
                return location.toString();
            }
        }

        public enum DefaultTextureColor {
            BLUE("blue"),
            BROWN("brown"),
            CYAN("cyan"),
            GRAY("gray"),
            GREEN("green"),
            PURPLE("purple"),
            RED("red");

            private final String fileName;
            DefaultTextureColor(String fileName) {
                this.fileName = fileName;
            }

            public String getBookGuiTexture() {
                return String.format("patchouli:textures/gui/book_{}.png", this.fileName);
            }
        }

        public enum OverflowMode {
            OVERFLOW("overflow"), RESIZE("resize"), TRUNCATE("truncate");
            private final String mode;
            OverflowMode(String mode) {
                this.mode = mode;
            }

            public String getMode() {
                return this.mode;
            }
        }
    }

    public static class Categories {
        private final PatchouliBuilder parent;
        private final NonNullList<PatchouliBuilder.Category> categories = NonNullList.create();

        public Categories(PatchouliBuilder parent) {
            this.parent = parent;
        }

        public PatchouliBuilder.Category addCategory(String name, String description, ItemEntry<? extends Item> item) {
            return this.addCategory(name, description, item.getId().toString());
        }

        public PatchouliBuilder.Category addCategory(String name, String description, BlockEntry<? extends Block> block) {
            return this.addCategory(name, description, block.getId().toString());
        }

        public PatchouliBuilder.Category addCategory(String name, String description, String icon) {
            PatchouliBuilder.Category category = new PatchouliBuilder.Category(this, categories.size(), name, description, icon);
            this.categories.add(category);
            return category;
        }

        public PatchouliBuilder build() {
            return this.parent;
        }
    }

    public static class Category implements RegistratePatchouliProvider.Result {
        private final PatchouliBuilder.Categories categories;
        private final PatchouliBuilder.Category.Properties properties;
        private final PatchouliBuilder.Entries entries = new PatchouliBuilder.Entries(this);

        protected Category(
                PatchouliBuilder.Categories categories,
                int index,
                String name,
                String description,
                String icon
        ) {
            this.categories = categories;
            this.properties = new PatchouliBuilder.Category.Properties(name, description, icon, index);
        }

        public PatchouliBuilder.Category properties(Function<Category.Properties, Category.Properties> properties) {
            properties.apply(this.properties);
            return this;
        }

        public PatchouliBuilder.Entries entries() {
            return this.entries;
        }

        public PatchouliBuilder.Categories build() {
            return this.categories;
        }

        @Override
        public ResourceLocation getId() {
            return new ResourceLocation(this.categories.parent.modId, this.getCategoryId());
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
            return getBasePath(this.categories.parent.getId(), pathIn, "/en_us/categories/" + this.getCategoryId() + ".json");
        }

        @Override
        public RegistratePatchouliProvider.ProviderType getProviderType() {
            return RegistratePatchouliProvider.ProviderType.BOOK_CATEGORY;
        }

        private String getCategoryId() {
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

    public static class Entries {
        private final PatchouliBuilder.Category category;
        private final NonNullList<PatchouliBuilder.Entry> entries = NonNullList.create();

        public Entries(PatchouliBuilder.Category category) {
            this.category = category;
        }

        public PatchouliBuilder.Entry addEntry(String name, ItemEntry<? extends Item> itemIcon) {
            return this.addEntry(name, itemIcon.getId().toString());
        }

        public PatchouliBuilder.Entry addEntry(String name, BlockEntry<? extends Block> blockIcon) {
            return this.addEntry(name, blockIcon.getId().toString());
        }

        public PatchouliBuilder.Entry addEntry(String name, String icon) {
            String category = this.category.categories.parent.modId + ":" + this.category.getCategoryId();
            PatchouliBuilder.Entry entry = new PatchouliBuilder.Entry(this, this.entries.size(), name, category, icon);
            this.entries.add(entry);
            return entry;
        }

        public PatchouliBuilder.Category build() {
            return this.category;
        }
    }

    /**
     * @see "https://vazkiimods.github.io/Patchouli/docs/reference/entry-json/"
     */
    public static class Entry implements RegistratePatchouliProvider.Result {
        private final PatchouliBuilder.Entries entries;
        private final PatchouliBuilder.Entry.Properties properties;
        protected Entry(
                PatchouliBuilder.Entries entries,
                int index,
                String name,
                String category,
                String icon
        ) {
            this.entries = entries;
            this.properties = new PatchouliBuilder.Entry.Properties(name, category, icon, index);
        }

        public PatchouliBuilder.Entry properties(Function<Entry.Properties, Entry.Properties> properties) {
            properties.apply(this.properties);
            return this;
        }

        public PatchouliBuilder.Entries build() {
            return this.entries;
        }

        @Override
        public ResourceLocation getId() {
            return new ResourceLocation(this.getParent().modId, this.getEntryId());
        }

        @Override
        public JsonObject serialize() {
            JsonObject jsonobject = new JsonObject();

            jsonobject.addProperty("name", this.properties.name);
            jsonobject.addProperty("category", this.properties.category);
            jsonobject.addProperty("icon", this.properties.icon);

            JsonArray pagesJsonArray = new JsonArray();
            for(Properties.Page page : this.properties.pages) {
                pagesJsonArray.add(page.serialize());
            }
            jsonobject.add("pages", pagesJsonArray);

            return jsonobject;
        }

        @Override
        public Path getPath(Path pathIn) {
            return getBasePath(this.getParent().getId(), pathIn, "/en_us/entries/" + this.getEntryId() + ".json");
        }

        @Override
        public RegistratePatchouliProvider.ProviderType getProviderType() {
            return RegistratePatchouliProvider.ProviderType.BOOK_ENTRY;
        }

        private String getEntryId() {
            return this.getCategoryId() + "/" + this.properties.sortnum + "_" + this.properties.name.replace(" ", "_").toLowerCase();
        }

        private PatchouliBuilder getParent() {
            return this.entries.category.categories.parent;
        }

        private String getCategoryId() {
            return this.entries.category.getCategoryId();
        }

        public static class Properties {

            private final String name;
            private final String category;
            private final String icon;
            private NonNullList<Page> pages = NonNullList.create();
            private @Nullable String advancement;
            private @Nullable String flag;
            private boolean priority = false;
            private boolean secret = false;
            private boolean readByDefault = false;
            private int sortnum;
            private HashMap<String, Integer> extraRecipeMappings = new HashMap<>();

            public Properties(
                    String name,
                    String category,
                    String icon,
                    int sortnum
            ) {
                this.name = name;
                this.category = category;
                this.icon = icon;
                this.sortnum = sortnum;
            }

            public Properties getAdvancement(String advancement) {
                this.advancement = advancement;
                return this;
            }

            public Properties setFlag(String flag) {
                this.flag = flag;
                return this;
            }

            public Properties setHighPriority() {
                this.priority = true;
                return this;
            }

            public Properties setSecret() {
                this.secret = true;
                return this;
            }

            public Properties setOpenYet() {
                this.readByDefault = true;
                return this;
            }

            public Properties setSortnum(int sortnum) {
                this.sortnum = sortnum;
                return this;
            }

            public Properties addExtraRecipeMapping(ItemStack itemStack, int page) {
                this.extraRecipeMappings.put(itemStack.getDescriptionId(), page);
                return this;
            }

            public Properties.TextPage addTextPage(String text) {
                Properties.TextPage page = new Properties.TextPage(this, text);
                this.pages.add(page);
                return page;
            }

            public Properties.ImagePage addImagePage(String image) {
                Properties.ImagePage page = new Properties.ImagePage(this, image);
                this.pages.add(page);
                return page;
            }

            public Properties.CraftingRecipePage addCraftingRecipePage(ItemEntry<? extends Item> item) {
                return this.addCraftingRecipePage(item.getId());
            }

            public Properties.CraftingRecipePage addCraftingRecipePage(BlockEntry<? extends Block> block) {
                return this.addCraftingRecipePage(block.getId());
            }

            public Properties.CraftingRecipePage addCraftingRecipePage(ResourceLocation recipe) {
                Properties.CraftingRecipePage page = new Properties.CraftingRecipePage(this, recipe);
                this.pages.add(page);
                return page;
            }

            public Properties.SmeltingRecipePage addSmeltingRecipePage(ResourceLocation recipe) {
                Properties.SmeltingRecipePage page = new Properties.SmeltingRecipePage(this, recipe);
                this.pages.add(page);
                return page;
            }

            public Properties.MultiblockPage addMultiblockPage(String name) {
                Properties.MultiblockPage page = new Properties.MultiblockPage(this, name);
                this.pages.add(page);
                return page;
            }

            public Properties.EntityPage addEntityPage(String entity) {
                Properties.EntityPage page = new Properties.EntityPage(this, entity);
                this.pages.add(page);
                return page;
            }

            public Properties.SpotlightPage addSpotlightPage(ItemEntry<? extends Item> item) {
                return this.addSpotlightPage(item.getId().toString());
            }

            public Properties.SpotlightPage addSpotlightPage(BlockEntry<? extends Block> block) {
                return this.addSpotlightPage(block.getId().toString());
            }

            public Properties.SpotlightPage addSpotlightPage(String item) {
                Properties.SpotlightPage page = new Properties.SpotlightPage(this, item);
                this.pages.add(page);
                return page;
            }

            public Properties.LinkPage addRelatedPage(String url, String linkText) {
                Properties.LinkPage page = new Properties.LinkPage(this, url, linkText);
                this.pages.add(page);
                return page;
            }

            public Properties.RelationsPage addRelatedPage() {
                Properties.RelationsPage page = new Properties.RelationsPage(this);
                this.pages.add(page);
                return page;
            }

            public Properties.QuestPage addQuestPage() {
                Properties.QuestPage page = new Properties.QuestPage(this);
                this.pages.add(page);
                return page;
            }

            public Properties.EmptyPage addEmptyPage() {
                Properties.EmptyPage page = new Properties.EmptyPage(this);
                this.pages.add(page);
                return page;
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/"
             */
            public static abstract class Page<T extends Page> {
                private final Entry.Properties parent;
                private final String type;
                private @Nullable String advancement;
                private @Nullable String flag;
                private @Nullable String anchor;

                public Page(Entry.Properties parent, String type) {
                    this.parent = parent;
                    this.type = type;
                }

                public T setAdvancement(String advancement) {
                    this.advancement = advancement;
                    return (T) this;
                }

                public T setFlag(String flag) {
                    this.flag = flag;
                    return (T) this;
                }

                public T setAnchor(String anchor) {
                    this.anchor = anchor;
                    return (T) this;
                }

                public JsonObject serialize() {
                    JsonObject jsonobject = new JsonObject();
                    jsonobject.addProperty("type", this.type);
                    if(this.advancement != null) jsonobject.addProperty("advancement", this.advancement);
                    if(this.flag != null) jsonobject.addProperty("flag", this.flag);
                    if(this.anchor != null) jsonobject.addProperty("anchor", this.anchor);
                    this.serializeData(jsonobject);
                    return jsonobject;
                }

                public Entry.Properties build() {
                    return this.parent;
                }

                protected abstract void serializeData(JsonObject jsonobject);
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#text-pages"
             */
            public static class TextPage extends Page<TextPage> {
                private final String text;
                private @Nullable String title;

                public TextPage(Entry.Properties parent, String text) {
                    super(parent, "patchouli:text");
                    this.text = text;
                }

                public TextPage setTitle(String title) {
                    this.title = title;
                    return this;
                }

                @Override
                protected void serializeData(JsonObject jsonobject) {
                    jsonobject.addProperty("text", this.text);
                    if(this.title != null) jsonobject.addProperty("title", this.title);
                }
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#image-pages"
             */
            public static class ImagePage extends Page<ImagePage> {
                private final String[] images;
                private @Nullable String title;
                private boolean border = false;
                private @Nullable String text;

                public ImagePage(Entry.Properties parent, String ...images) {
                    super(parent, "patchouli:image");
                    this.images = images;
                }

                public ImagePage setTitle(String title) {
                    this.title = title;
                    return this;
                }

                public ImagePage setBorder() {
                    this.border = true;
                    return this;
                }

                public ImagePage setText(String text) {
                    this.text = text;
                    return this;
                }

                @Override
                protected void serializeData(JsonObject jsonobject) {
                    JsonArray imagesJsonArray = new JsonArray();
                    for(String image : this.images) {
                        imagesJsonArray.add(image);
                    }
                    jsonobject.add("images", imagesJsonArray);
                    if(this.title != null) jsonobject.addProperty("title", this.title);
                    if(this.border) jsonobject.addProperty("border", this.border);
                    if(this.text != null) jsonobject.addProperty("text", this.text);
                }
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#crafting-recipe-pages"
             */
            public static class CraftingRecipePage extends Page<CraftingRecipePage> {
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

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#smelting-recipe-pages"
             */
            public static class SmeltingRecipePage extends Page<SmeltingRecipePage> {
                private final ResourceLocation recipe;
                private @Nullable ResourceLocation recipe2;
                private @Nullable String title;
                private @Nullable String text;

                public SmeltingRecipePage(Entry.Properties parent, ResourceLocation recipe) {
                    super(parent, "patchouli:smelting");
                    this.recipe = recipe;
                }

                public SmeltingRecipePage setRecipe2(ResourceLocation recipe2) {
                    this.recipe2 = recipe2;
                    return this;
                }

                public SmeltingRecipePage setTitle(String title) {
                    this.title = title;
                    return this;
                }

                public SmeltingRecipePage setText(String text) {
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

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#multiblock-pages"
             */
            public static class MultiblockPage extends Page<MultiblockPage> {
                private final String name;
                private @Nullable String multiblockId;
                private MultiblockProperties multiblock;
                private boolean enableVisualize = true;
                private @Nullable String text;

                public MultiblockPage(Entry.Properties parent, String name) {
                    super(parent, "patchouli:multiblock");
                    this.name = name;
                    this.multiblock = new MultiblockProperties(this);
                }

                public MultiblockPage setMultiblockId(String multiblockId) {
                    this.multiblockId = multiblockId;
                    return this;
                }

                public MultiblockPage setDisableVisualize() {
                    this.enableVisualize = false;
                    return this;
                }

                public MultiblockPage setText(String text) {
                    this.text = text;
                    return this;
                }

                @Override
                protected void serializeData(JsonObject jsonobject) {
                    jsonobject.addProperty("name", this.name);
                    if(this.multiblockId != null) jsonobject.addProperty("multiblock_id", this.multiblockId);
                    jsonobject.addProperty("enable_visualize", this.enableVisualize);
                    if(this.text != null) jsonobject.addProperty("text", this.text);

                    JsonObject multiblockJson = new JsonObject();

                    JsonObject mappingJson = new JsonObject();
                    for(Map.Entry<String, String> entry : this.multiblock.properties.entrySet()) {
                        mappingJson.addProperty(entry.getKey(), entry.getValue());
                    }
                    multiblockJson.add("mapping", mappingJson);

                    JsonArray patternJson = new JsonArray();
                    for(String[] pattern : this.multiblock.pattern) {
                        JsonArray patternRowJson = new JsonArray();
                        for(String patternRow : pattern) {
                            patternRowJson.add(patternRow);
                        }
                        patternJson.add(patternRowJson);
                    }
                    multiblockJson.add("pattern", patternJson);

                    multiblockJson.addProperty("symmetrical", this.multiblock.symmetrical);

                    if(this.multiblock.offset != null) {
                        JsonArray offsetJson = new JsonArray();
                        for(int offset : this.multiblock.offset) {
                            offsetJson.add(offset);
                        }
                        multiblockJson.add("offset", offsetJson);
                    }

                    jsonobject.add("multiblock", multiblockJson);
                }

                public static class MultiblockProperties {
                    private final MultiblockPage parent;
                    private final HashMap<String, String> properties = new HashMap<>();
                    private final NonNullList<String[]> pattern = NonNullList.create();
                    private boolean symmetrical = false;
                    private @Nullable int[] offset;

                    public MultiblockProperties(MultiblockPage parent) {
                        this.parent = parent;
                    }

                    public MultiblockProperties addMapping(String key, String value) {
                        this.properties.put(key, value);
                        return this;
                    }

                    public MultiblockProperties addPattern(String ...pattern) {
                        this.pattern.add(pattern);
                        return this;
                    }

                    public MultiblockProperties setSymmetrical() {
                        this.symmetrical = true;
                        return this;
                    }

                    public MultiblockProperties setOffset(int x, int y, int z) {
                        this.offset = new int[] {x, y, z};
                        return this;
                    }

                    public MultiblockPage build() {
                        return this.parent;
                    }
                }
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#entity-pages"
             */
            public static class EntityPage extends Page<EntityPage> {
                private final String entity;
                private Optional<Float> scale = Optional.empty();
                private Optional<Float> offset = Optional.empty();
                private boolean rotate = true;
                private Optional<Float> defaultRotation = Optional.empty();
                private @Nullable String name;
                private @Nullable String text;

                public EntityPage(Entry.Properties parent, String entity) {
                    super(parent, "patchouli:entity");
                    this.entity = entity;
                }

                public EntityPage setScale(float scale) {
                    this.scale = Optional.of(scale);
                    return this;
                }

                public EntityPage setOffset(float offset) {
                    this.offset = Optional.of(offset);
                    return this;
                }

                public EntityPage setNoRotate() {
                    this.rotate = false;
                    return this;
                }

                public EntityPage setDefaultRotation(float defaultRotation) {
                    this.defaultRotation = Optional.of(defaultRotation);
                    return this;
                }

                public EntityPage setName(String name) {
                    this.name = name;
                    return this;
                }

                public EntityPage setText(String text) {
                    this.text = text;
                    return this;
                }

                @Override
                protected void serializeData(JsonObject jsonobject) {
                    jsonobject.addProperty("entity", this.entity);
                    this.scale.ifPresent(aFloat -> jsonobject.addProperty("scale", aFloat));
                    this.offset.ifPresent(aFloat -> jsonobject.addProperty("offset", aFloat));
                    jsonobject.addProperty("rotate", this.rotate);
                    this.defaultRotation.ifPresent(aFloat -> jsonobject.addProperty("default_rotation", aFloat));
                    if(this.name != null) jsonobject.addProperty("name", this.name);
                    if(this.text != null) jsonobject.addProperty("text", this.text);
                }
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#spotlight-pages"
             */
            public static class SpotlightPage extends Page<SpotlightPage> {
                private String item;
                private @Nullable String title;
                private boolean linkRecipe = false;
                private @Nullable String text;

                public SpotlightPage(Entry.Properties parent, String item) {
                    super(parent, "patchouli:spotlight");
                    this.item = item;
                }

                public SpotlightPage setTitle(String title) {
                    this.title = title;
                    return this;
                }

                public SpotlightPage setLinkRecipe() {
                    this.linkRecipe = true;
                    return this;
                }

                public SpotlightPage setText(String text) {
                    this.text = text;
                    return this;
                }

                @Override
                protected void serializeData(JsonObject jsonobject) {
                    jsonobject.addProperty("item", this.item);
                    if(this.title != null) jsonobject.addProperty("title", this.title);
                    jsonobject.addProperty("link_recipe", this.linkRecipe);
                    if(this.text != null) jsonobject.addProperty("text", this.text);
                }
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#link-pages"
             */
            public static class LinkPage extends Page<LinkPage> {
                private final String url;
                private final String linkText;

                public LinkPage(Entry.Properties parent, String url, String linkText) {
                    super(parent, "patchouli:link");
                    this.url = url;
                    this.linkText = linkText;
                }

                @Override
                protected void serializeData(JsonObject jsonobject) {
                    jsonobject.addProperty("url", this.url);
                    jsonobject.addProperty("link_text", this.linkText);
                }
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#relations-pages"
             */
            public static class RelationsPage extends Page<RelationsPage> {
                private final NonNullList<String> entries = NonNullList.create();
                private @Nullable String title;
                private @Nullable String text;

                public RelationsPage(Entry.Properties parent) {
                    super(parent, "patchouli:relations");
                }

                public RelationsPage addEntry(String entry) {
                    this.entries.add(entry);
                    return this;
                }

                public RelationsPage setTitle(String title) {
                    this.title = title;
                    return this;
                }

                public RelationsPage setText(String text) {
                    this.text = text;
                    return this;
                }

                @Override
                protected void serializeData(JsonObject jsonobject) {
                    JsonObject entriesJson = new JsonObject();
                    for(String entry : this.entries) {
                        entriesJson.addProperty(entry, entry);
                    }
                    jsonobject.add("entries", entriesJson);
                    if(this.title != null) jsonobject.addProperty("title", this.title);
                    if(this.text != null) jsonobject.addProperty("text", this.text);
                }
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#quest-pages"
             */
            public static class QuestPage extends Page<QuestPage> {
                private @Nullable String trigger;
                private @Nullable String title;
                private @Nullable String text;

                public QuestPage(Entry.Properties parent) {
                    super(parent, "patchouli:quest");
                }

                public QuestPage setTrigger(String trigger) {
                    this.trigger = trigger;
                    return this;
                }

                public QuestPage setTitle(String title) {
                    this.title = title;
                    return this;
                }

                public QuestPage setText(String text) {
                    this.text = text;
                    return this;
                }

                @Override
                protected void serializeData(JsonObject jsonobject) {
                    if(this.trigger != null) jsonobject.addProperty("trigger", this.trigger);
                    if(this.title != null) jsonobject.addProperty("title", this.title);
                    if(this.text != null) jsonobject.addProperty("text", this.text);
                }
            }

            /**
             * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#empty-pages"
             */
            public static class EmptyPage extends Page<EmptyPage> {
                private boolean drawFiller = true;

                public EmptyPage(Entry.Properties parent) {
                    super(parent, "patchouli:empty");
                }

                public EmptyPage setNoFiller() {
                    this.drawFiller = false;
                    return this;
                }

                @Override
                protected void serializeData(JsonObject jsonobject) {
                    jsonobject.addProperty("draw_filler", this.drawFiller);
                }
            }
        }
    }

    private static Path getBasePath(ResourceLocation location, Path pathIn, String children) {
        return pathIn.resolve("data/" + location.getNamespace() + "/patchouli_books/" + location.getPath() + children);
    }
}
