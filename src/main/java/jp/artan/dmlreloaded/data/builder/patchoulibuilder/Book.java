package jp.artan.dmlreloaded.data.builder.patchoulibuilder;

import com.google.gson.JsonObject;
import jp.artan.artansprojectcoremod.tabs.CreativeTab;
import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.recipe.Recipe;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.recipe.ShapedRecipe;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.recipe.ShapelessRecipe;
import jp.artan.dmlreloaded.data.providers.RegistratePatchouliProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import static jp.artan.dmlreloaded.data.builder.PatchouliBuilder.getBasePath;

public class Book implements RegistratePatchouliProvider.Result {
    private final ResourceLocation id;
    private final PatchouliBuilder parent;
    private final Book.Properties properties;
    private Consumer<Consumer<FinishedRecipe>> pFinishedRecipeConsumer;
    private @Nullable Recipe recipe;
    public Book(
            ResourceLocation id,
            PatchouliBuilder parent
    ) {
        this.id = id;
        this.parent = parent;
        this.properties = new Book.Properties(this);
    }

    public Book properties(Function<Properties, Properties> properties) {
        properties.apply(this.properties);
        return this;
    }

    public ShapelessRecipe shapelessRecipe() {
        this.recipe = new ShapelessRecipe(this);
        return (ShapelessRecipe) this.recipe;
    }

    public ShapedRecipe shapedRecipe() {
        this.recipe = new ShapedRecipe(this);
        return (ShapedRecipe) this.recipe;
    }

    public @Nullable Recipe getRecipe() {
        return this.recipe;
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
        this.properties.name.ifPresent(name -> jsonobject.addProperty("name", name));
        this.properties.landingText.ifPresent(landingText -> jsonobject.addProperty("landing_text", landingText));
        this.properties.bookTexture.ifPresent(bookTexture -> jsonobject.addProperty("book_texture", bookTexture));
        this.properties.fillerTexture.ifPresent(fillerTexture -> jsonobject.addProperty("filler_texture", fillerTexture));
        this.properties.craftingTexture.ifPresent(craftingTexture -> jsonobject.addProperty("crafting_texture", craftingTexture));
        this.properties.model.ifPresent(model -> jsonobject.addProperty("model", model));
        this.properties.textColor.ifPresent(textColor -> jsonobject.addProperty("text_color", textColor));
        this.properties.headerColor.ifPresent(headerColor -> jsonobject.addProperty("header_color", headerColor));
        this.properties.nameplateColor.ifPresent(nameplateColor -> jsonobject.addProperty("nameplate_color", nameplateColor));
        this.properties.linkColor.ifPresent(linkColor -> jsonobject.addProperty("link_color", linkColor));
        this.properties.linkHoverColor.ifPresent(linkHoverColor -> jsonobject.addProperty("link_hover_color", linkHoverColor));
        this.properties.progressBarColor.ifPresent(progressBarColor -> jsonobject.addProperty("progress_bar_color", progressBarColor));
        this.properties.progressBarBackground.ifPresent(progressBarBackground -> jsonobject.addProperty("progress_bar_background", progressBarBackground));
        this.properties.openSound.ifPresent(openSound -> jsonobject.addProperty("open_sound", openSound));
        this.properties.flipSound.ifPresent(flipSound -> jsonobject.addProperty("flip_sound", flipSound));
        this.properties.indexIcon.ifPresent(indexIcon -> jsonobject.addProperty("index_icon", indexIcon));
        this.properties.pamphlet.ifPresent(pamphlet -> jsonobject.addProperty("pamphlet", pamphlet));
        this.properties.showProgress.ifPresent(showProgress -> jsonobject.addProperty("show_progress", showProgress));
        this.properties.version.ifPresent(version -> jsonobject.addProperty("version", version));
        this.properties.subtitle.ifPresent(subtitle -> jsonobject.addProperty("subtitle", subtitle));
        this.properties.creativeTab.ifPresent(creativeTab -> jsonobject.addProperty("creative_tab", creativeTab));
        this.properties.advancementsTab.ifPresent(advancementsTab -> jsonobject.addProperty("advancements_tab", advancementsTab));
        this.properties.dontGenerateBook.ifPresent(dontGenerateBook -> jsonobject.addProperty("dont_generate_book", dontGenerateBook));
        this.properties.customBookItem.ifPresent(customBookItem -> jsonobject.addProperty("custom_book_item", customBookItem));
        this.properties.showToasts.ifPresent(showToasts -> jsonobject.addProperty("show_toasts", showToasts));
        this.properties.useBlockyFont.ifPresent(useBlockyFont -> jsonobject.addProperty("use_blocky_font", useBlockyFont));
        this.properties.i18n.ifPresent(i18n -> jsonobject.addProperty("i18n", i18n));

        if(!this.properties.macros.isEmpty()) {
            JsonObject macrosJsonobject = new JsonObject();
            for(String key : this.properties.macros.keySet()) {
                macrosJsonobject.addProperty(key, this.properties.macros.get(key));
            }
            jsonobject.add("macros", macrosJsonobject);
        }
        this.properties.pauseGame.ifPresent(pauseGame -> jsonobject.addProperty("pause_game", pauseGame));
        this.properties.textOverflowMode.ifPresent(textOverflowMode -> jsonobject.addProperty("text_overflow_mode", textOverflowMode.getMode()));
        this.properties.extend.ifPresent(extend -> jsonobject.addProperty("extend", extend));
        this.properties.allowExtensions.ifPresent(allowExtensions -> jsonobject.addProperty("allow_extensions", allowExtensions));
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
        private Optional<String> name = Optional.empty();
        private Optional<String> landingText = Optional.empty();
        private Optional<String> bookTexture = Optional.empty();
        private Optional<String> fillerTexture = Optional.empty();
        private Optional<String> craftingTexture = Optional.empty();
        private Optional<String> model = Optional.empty();
        private Optional<String> textColor = Optional.empty();
        private Optional<String> headerColor = Optional.empty();
        private Optional<String> nameplateColor = Optional.empty();
        private Optional<String> linkColor = Optional.empty();
        private Optional<String> linkHoverColor = Optional.empty();
        private Optional<String> progressBarColor = Optional.empty();
        private Optional<String> progressBarBackground = Optional.empty();
        private Optional<String> openSound = Optional.empty();
        private Optional<String> flipSound = Optional.empty();
        private Optional<String> indexIcon = Optional.empty();
        private Optional<String> pamphlet = Optional.empty();
        private Optional<Boolean> showProgress = Optional.empty();
        private Optional<String> version = Optional.empty();
        private Optional<String> subtitle = Optional.empty();
        private Optional<String> creativeTab = Optional.empty();
        private Optional<String> advancementsTab = Optional.empty();
        private Optional<Boolean> dontGenerateBook = Optional.empty();
        private Optional<String> customBookItem = Optional.empty();
        private Optional<Boolean> showToasts  = Optional.empty();
        private Optional<Boolean> useBlockyFont = Optional.empty();
        private Optional<Boolean> i18n = Optional.empty();
        private HashMap<String, String> macros = new HashMap<>();
        private Optional<Boolean> pauseGame  = Optional.empty();
        private Optional<OverflowMode> textOverflowMode = Optional.empty();
        private Optional<String> extend = Optional.empty();
        private Optional<Boolean> allowExtensions = Optional.empty();

        public Properties(Book parent) {
            this.parent = parent;
        }

        /**
         * The name of the book that will be displayed in the book item and the GUI. For modders, this can be a localization key.
         */
        public Properties setName(String name) {
            this.name = Optional.of(name);
            return this;
        }

        /**
         * The text that will be displayed in the landing page of your book. This text can be formatted. For modders, this can be a localization key.
         */
        public Properties setLandingText(String landingText) {
            this.landingText = Optional.of(landingText);
            return this;
        }

        public Properties setBookTexture(ResourceLocation bookTexturePath) {
            this.bookTexture = Optional.of(this.getTexturePath(bookTexturePath));
            return this;
        }

        public Properties setBookTextureNoConfirmation(ResourceLocation bookTexturePath) {
            this.bookTexture = Optional.of(bookTexturePath.toString());
            return this;
        }

        public Properties setBookTexture(DefaultTextureColor bookTexture) {
            this.bookTexture = Optional.of(bookTexture.getBookGuiTexture());
            return this;
        }

        public Properties setFillerTexture(String fillerTexture) {
            this.fillerTexture = Optional.of(fillerTexture);
            return this;
        }

        public Properties setCrafterTexture(ResourceLocation craftingTexturePath) {
            this.craftingTexture = Optional.of(this.getTexturePath(craftingTexturePath));
            return this;
        }
        public Properties setCrafterTextureNoConfirmation(ResourceLocation craftingTexturePath) {
            this.craftingTexture = Optional.of(craftingTexturePath.toString());
            return this;
        }

        public Properties setModel(ResourceLocation bookTextureLocation) {
            this.model = Optional.of(bookTextureLocation.toString());
            return this;
        }

        public Properties setModel(DefaultTextureColor bookTexture) {
            this.model = Optional.of(bookTexture.getBookGuiTexture());
            return this;
        }

        /**
         * @param textColor 0xRRGGBB
         */
        public Properties setTextColor(int textColor) {
            this.textColor = Optional.of(String.format("%X", textColor));
            return this;
        }

        /**
         * @param headerColor 0xRRGGBB
         */
        public Properties setHeaderColor(int headerColor) {
            this.headerColor = Optional.of(String.format("%X", headerColor));
            return this;
        }

        /**
         * @param nameplateColor 0xRRGGBB
         */
        public Properties setNameplateColor(int nameplateColor) {
            this.nameplateColor = Optional.of(String.format("%X", nameplateColor));
            return this;
        }

        /**
         * @param linkColor 0xRRGGBB
         */
        public Properties setLinkColor(int linkColor) {
            this.linkColor = Optional.of(String.format("%X", linkColor));
            return this;
        }

        /**
         * @param linkHoverColor 0xRRGGBB
         */
        public Properties setLinkHoverColor(int linkHoverColor) {
            this.linkHoverColor = Optional.of(String.format("%X", linkHoverColor));
            return this;
        }

        /**
         * @param progressBarColor 0xRRGGBB
         */
        public Properties setProgressBarColor(int progressBarColor) {
            this.progressBarColor = Optional.of(String.format("%X", progressBarColor));
            return this;
        }

        /**
         * @param progressBarBackground 0xRRGGBB
         */
        public Properties setProgressBarBackground(int progressBarBackground) {
            this.progressBarBackground = Optional.of(String.format("%X", progressBarBackground));
            return this;
        }

        public Properties setOpenSound(ResourceLocation openSound) {
            this.openSound = Optional.of(openSound.toString());
            return this;
        }

        public Properties setFlipSound(ResourceLocation flipSound) {
            this.flipSound = Optional.of(flipSound.toString());
            return this;
        }

        public Properties setIndexIcon(ResourceLocation indexIcon) {
            this.indexIcon = Optional.of(indexIcon.toString());
            return this;
        }

        public Properties setPamphlet(ResourceLocation pamphlet) {
            this.pamphlet = Optional.of(pamphlet.toString());
            return this;
        }

        public Properties setShowProgress(boolean showProgress) {
            this.showProgress = Optional.of(showProgress);
            return this;
        }

        public Properties setVersion(String version) {
            this.version = Optional.of(version);
            return this;
        }

        public Properties setSubtitle(String subtitle) {
            this.subtitle = Optional.of(subtitle);
            return this;
        }

        public Properties setCreativeTab(String creativeTab) {
            this.creativeTab = Optional.of(creativeTab);
            return this;
        }

        public Properties setCreativeTab(CreativeTab creativeTab) {
            this.creativeTab = Optional.of(((TranslatableComponent)creativeTab.getDisplayName()).getKey().replace("itemGroup.", ""));
            return this;
        }

        public Properties setAdvancementsTab(String advancementsTab) {
            this.advancementsTab = Optional.of(advancementsTab);
            return this;
        }

        public Properties setDontGenerateBook(boolean dontGenerateBook) {
            this.dontGenerateBook = Optional.of(dontGenerateBook);
            return this;
        }

        public Properties setCustomBookItem(String namespace, String path) {
            this.customBookItem = Optional.of(namespace + ":" + path);
            return this;
        }

        public Properties setCustomBookItem(String namespace, String path, int count) {
            this.customBookItem = Optional.of(namespace + ":" + path + "#" + count);
            return this;
        }

        public Properties setCustomBookItem(String namespace, String path, String nbtStr) {
            this.customBookItem = Optional.of(namespace + ":" + path + nbtStr);
            return this;
        }

        public Properties setCustomBookItem(String namespace, String path, int count, String nbtStr) {
            this.customBookItem = Optional.of(namespace + ":" + path + "#" + count + nbtStr);
            return this;
        }

        public Properties setShowToasts(boolean showToasts) {
            this.showToasts = Optional.of(showToasts);
            return this;
        }

        public Properties setUseBlockyFont(boolean useBlockyFont) {
            this.useBlockyFont = Optional.of(useBlockyFont);
            return this;
        }

        public Properties setI18n(boolean i18n) {
            this.i18n = Optional.of(i18n);
            return this;
        }

        public Properties addMacros(String key, String value) {
            this.macros.put(key, value);
            return this;
        }

        public Properties setPauseGame() {
            this.pauseGame = Optional.of(true);
            return this;
        }

        public Properties setTextOverflowMode(OverflowMode overflowMode) {
            this.textOverflowMode = Optional.of(overflowMode);
            return this;
        }

        public Properties setExtend(String extend) {
            this.extend = Optional.of(extend);
            return this;
        }

        public Properties setAllowExtensions(boolean allowExtensions) {
            this.allowExtensions = Optional.of(allowExtensions);
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