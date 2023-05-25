package jp.artan.dmlreloaded.data;

import jp.artan.artansprojectcoremod.ArtanRegistrate;
import jp.artan.repack.registrate.util.nullness.NonNullSupplier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class DeepMobLearningReloadedRegistrate extends ArtanRegistrate<DeepMobLearningReloadedRegistrate> {
    protected DeepMobLearningReloadedRegistrate(String modid) {
        super(modid);
    }

    public static NonNullSupplier<DeepMobLearningReloadedRegistrate> lazy(String modid) {
        return NonNullSupplier.lazy(
                () -> new DeepMobLearningReloadedRegistrate(modid).registerEventListeners(FMLJavaModLoadingContext.get()
                        .getModEventBus()));
    }
}
