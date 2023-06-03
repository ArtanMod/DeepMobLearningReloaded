package jp.artan.dmlreloaded.data.providers;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import jp.artan.repack.registrate.providers.RegistrateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.LogicalSide;
import org.slf4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;

public abstract class RegistratePatchouliProvider implements RegistrateProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final String modid;
    private final DataGenerator generator;
    private final ExistingFileHelper existingFileHelper;

    public RegistratePatchouliProvider(String modid, DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        this.modid = modid;
        this.generator = pGenerator;
        this.existingFileHelper = existingFileHelper;
        pGenerator.addProvider(new ItemModelProvider(pGenerator, modid, existingFileHelper) {
            @Override
            public String getName() {
                return "Patchouli Item Model Provider";
            }

            @Override
            protected void registerModels() {
                LOGGER.debug("Registering Patchouli Item Models");
                registerPatchouli(result -> {
                    LOGGER.debug("Registering Patchouli Item Model: {}", result.getId().getPath());
                    getBuilder(result.getId().getPath()).parent(getExistingFile(mcLoc("item/generated")))
                            .texture("layer0", new ResourceLocation(modid, "item/" + result.getId().getPath()));
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

    private Set<ResourceLocation> seenPatchouli = new HashSet<>();

    @Override
    public void run(HashCache pCache) {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        LOGGER.debug("Registering Patchouli Books");
        registerPatchouli(result -> {
            LOGGER.debug("Registering Patchouli Book: {}", result.getId().getPath());
            if(set.add(result.getId())) {
                saveBook(pCache, result.serializeBook(), getBookPath(path, result));
            } else {
                throw new IllegalStateException("Duplicate patchouli " + result.getId());
            }
        });
    }

    protected abstract void registerPatchouli(Consumer<PatchouliBuilder.Result> consumer);

    private static Path getBookPath(Path pathIn, PatchouliBuilder.Result book) {
        return pathIn.resolve("data/" + book.getId().getNamespace() + "/patchouli_books/" + book.getId().getPath() + "/book.json");
    }

    private static void saveBook(HashCache pCache, JsonObject pBookJson, Path pPath) {
        try {
            String jStr = GSON.toJson(pBookJson);
            String hash = SHA1.hashUnencodedChars(jStr).toString();
            if(!Objects.equals(pCache.getHash(pPath), hash) || !Files.exists(pPath)) {
                Files.createDirectories(pPath.getParent());
                BufferedWriter bufferedwriter = Files.newBufferedWriter(pPath);

                try {
                    bufferedwriter.write(jStr);
                } catch(Throwable throwable1) {
                    if (bufferedwriter != null) {
                        try {
                            bufferedwriter.close();
                        } catch (Throwable throwable) {
                            throwable1.addSuppressed(throwable);
                        }
                    }
                    throw throwable1;
                }
                if (bufferedwriter != null) {
                    bufferedwriter.close();
                }
            }
            pCache.putNew(pPath, hash);
        } catch(IOException ioexception) {
            LOGGER.error("Couldn't save patchouli book {}", pPath, ioexception);
        }
    }
}
