package jp.artan.dmlreloaded.data.providers;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import jp.artan.repack.registrate.providers.RegistrateProvider;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.LogicalSide;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;

public abstract class RegistratePatchouliProvider implements RegistrateProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    private final String modid;
    private final DataGenerator generator;
    private final ExistingFileHelper existingFileHelper;

    public RegistratePatchouliProvider(boolean pRun, String modid, DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        this.modid = modid;
        this.generator = pGenerator;
        this.existingFileHelper = existingFileHelper;
        pGenerator.addProvider(pRun, new ItemModelProvider(pGenerator, modid, existingFileHelper) {
            @Override
            public String getName() {
                return "Patchouli Item Model Provider";
            }

            @Override
            protected void registerModels() {
                LOGGER.debug("Registering Patchouli Item Models");
                registerPatchouli(result -> {
                    if(result.getProviderType() == ProviderType.BOOK_ITEM) {
                        LOGGER.debug("Registering Patchouli Item Model: {}", result.getId().getPath());
                        getBuilder(result.getId().getPath()).parent(getExistingFile(mcLoc("item/generated")))
                                .texture("layer0", new ResourceLocation(modid, "item/" + result.getId().getPath()));
                    }
                });
            }
            private Path getPath(ResourceLocation loc) {
                return generator.getOutputFolder().resolve("assets/item/models/" + loc.getPath() + ".json");
            }
        });
    }

    public PatchouliBuilder book(String name) {
        return new PatchouliBuilder(modid, name, this.existingFileHelper);
    }

    @Override
    public LogicalSide getSide() {
        return LogicalSide.CLIENT;
    }

    @Override
    public String getName() {
        return "Patchouli";
    }

    @Override
    public void run(CachedOutput pOutput) {
        Set<ResourceLocation> set = Sets.newHashSet();
        LOGGER.debug("Registering Patchouli Books");
        registerPatchouli(result -> {
            LOGGER.debug("Registering Patchouli Book: {}", result.getId().getPath());
            if(set.add(result.getId())) {
                Path path = result.getPath(this.generator.getOutputFolder());
                try {
                    DataProvider.saveStable(pOutput, result.serialize(), path);
                } catch (IOException ioexception) {
                    LOGGER.error("Couldn't save patchouli book {}", path, ioexception);
                }
            } else {
                throw new IllegalStateException("Duplicate patchouli " + result.getId());
            }
        });
    }

    protected abstract void registerPatchouli(Consumer<Result> consumer);

    public interface Result {
        ResourceLocation getId();

        JsonObject serialize();

        Path getPath(Path pathIn);

        ProviderType getProviderType();
    }

    public enum ProviderType {
        BOOK_ITEM,
        BOOK_CATEGORY,
        BOOK_ENTRY,
        BOOK_RECIPE,
        BOOK_TEMPLATE
    }
}
