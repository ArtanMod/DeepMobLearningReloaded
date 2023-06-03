package jp.artan.dmlreloaded.data;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import jp.artan.artansprojectcoremod.ArtanRegistrate;
import jp.artan.repack.registrate.providers.ProviderType;
import jp.artan.repack.registrate.providers.RegistrateProvider;
import jp.artan.repack.registrate.util.nullness.NonNullConsumer;
import jp.artan.repack.registrate.util.nullness.NonNullSupplier;
import jp.artan.repack.registrate.util.nullness.NonnullType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class DeepMobLearningReloadedRegistrate extends ArtanRegistrate<DeepMobLearningReloadedRegistrate> {
    private final ListMultimap<ProviderType<?>, @NonnullType NonNullConsumer<? extends RegistrateProvider>> datagens = ArrayListMultimap.create();

    protected DeepMobLearningReloadedRegistrate(String modid) {
        super(modid);
    }

    public static NonNullSupplier<DeepMobLearningReloadedRegistrate> lazy(String modid) {
        return NonNullSupplier.lazy(
                () -> new DeepMobLearningReloadedRegistrate(modid).registerEventListeners(FMLJavaModLoadingContext.get()
                        .getModEventBus()));
    }

    @Override
    protected DeepMobLearningReloadedRegistrate registerEventListeners(IEventBus bus) {
        return super.registerEventListeners(bus);
    }
}
