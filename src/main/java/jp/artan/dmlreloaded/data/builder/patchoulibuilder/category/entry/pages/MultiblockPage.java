package jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.pages;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.category.entry.Entry;
import net.minecraft.core.NonNullList;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#multiblock-pages"
 */
public class MultiblockPage extends Page<MultiblockPage> {
    private final String name;
    private Optional<String> multiblockId = Optional.empty();
    private MultiblockProperties multiblock;
    private Optional<Boolean> enableVisualize = Optional.empty();
    private Optional<String> text = Optional.empty();

    public MultiblockPage(Entry.Properties parent, String name) {
        super(parent, "patchouli:multiblock");
        this.name = name;
        this.multiblock = new MultiblockProperties(this);
    }

    public MultiblockPage setMultiblockId(String multiblockId) {
        this.multiblockId = Optional.of(multiblockId);
        return this;
    }

    public MultiblockPage setEnableVisualize(boolean enableVisualize) {
        this.enableVisualize = Optional.of(enableVisualize);
        return this;
    }

    public MultiblockPage setText(String text) {
        this.text = Optional.of(text);
        return this;
    }

    @Override
    protected void serializeData(JsonObject jsonobject) {
        jsonobject.addProperty("name", this.name);
        this.multiblockId.ifPresent(multiblockId -> jsonobject.addProperty("multiblock", multiblockId));
        this.enableVisualize.ifPresent(enableVisualize -> jsonobject.addProperty("enable_visualize", enableVisualize));
        this.text.ifPresent(text -> jsonobject.addProperty("text", text));

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

        this.multiblock.symmetrical.ifPresent(symmetrical -> multiblockJson.addProperty("symmetrical", symmetrical));

        this.multiblock.offset.ifPresent(offset -> {
            JsonArray offsetJson = new JsonArray();
            for(int offsetValue : offset) {
                offsetJson.add(offsetValue);
            }
            multiblockJson.add("offset", offsetJson);
        });

        jsonobject.add("multiblock", multiblockJson);
    }

    /**
     * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/multiblocks/"
     */
    public static class MultiblockProperties {
        private final MultiblockPage parent;
        private final HashMap<String, String> properties = new HashMap<>();
        private final NonNullList<String[]> pattern = NonNullList.create();
        private Optional<Boolean> symmetrical = Optional.empty();
        private Optional<int[]> offset = Optional.empty();

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

        public MultiblockProperties setSymmetrical(boolean symmetrical) {
            this.symmetrical = Optional.of(symmetrical);
            return this;
        }

        public MultiblockProperties setOffset(int x, int y, int z) {
            this.offset = Optional.of(new int[]{x, y, z});
            return this;
        }

        public MultiblockPage build() {
            return this.parent;
        }
    }
}

