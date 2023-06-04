package jp.artan.dmlreloaded.data.builder.patchoulibuilder.pages;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jp.artan.dmlreloaded.data.builder.patchoulibuilder.entry.Entry;
import net.minecraft.core.NonNullList;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/page-types/#multiblock-pages"
 */
public class MultiblockPage extends Page<MultiblockPage> {
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

    /**
     * @see "https://vazkiimods.github.io/Patchouli/docs/patchouli-basics/multiblocks/"
     */
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

