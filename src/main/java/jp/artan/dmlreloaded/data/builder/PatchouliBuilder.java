package jp.artan.dmlreloaded.data.builder;

import com.google.common.base.Preconditions;
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
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;

public class PatchouliBuilder {
    protected final String modId;
    private final ExistingFileHelper existingFileHelper;
    protected final ResourceLocation location;
    private final PatchouliBuilder.Book book;
    private final PatchouliBuilder.Categories categories;
    private final NonNullList<PatchouliBuilder.Entry> entries = NonNullList.create();

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
        private final int index;
        private final Categories categories;
        private final PatchouliBuilder.Category.Properties properties;

        protected Category(
                Categories categories,
                int index,
                String name,
                String description,
                String icon
        ) {
            this.index = index;
            this.categories = categories;
            this.properties = new PatchouliBuilder.Category.Properties(name, description, icon, index);
        }

        public Category properties(Function<Category.Properties, Category.Properties> properties) {
            properties.apply(this.properties);
            return this;
        }

        public Categories build() {
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
            return getBasePath(this.categories.parent.getId(), pathIn, "/en_us/categories/" + index + "_" + this.getCategoryId() + ".json");
        }

        @Override
        public RegistratePatchouliProvider.ProviderType getProviderType() {
            return RegistratePatchouliProvider.ProviderType.BOOK_CATEGORY;
        }

        private String getCategoryId() {
            return this.properties.name.toLowerCase();
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

    public static class Entry {
        private final PatchouliBuilder parent;
        protected Entry(PatchouliBuilder parent) {
            this.parent = parent;
        }

        protected static PatchouliBuilder.Entry create(PatchouliBuilder parent) {
            return new PatchouliBuilder.Entry(parent);
        }

        public PatchouliBuilder build() {
            return this.parent;
        }
    }

    private static Path getBasePath(ResourceLocation location, Path pathIn, String children) {
        return pathIn.resolve("data/" + location.getNamespace() + "/patchouli_books/" + location.getPath() + children);
    }
}
