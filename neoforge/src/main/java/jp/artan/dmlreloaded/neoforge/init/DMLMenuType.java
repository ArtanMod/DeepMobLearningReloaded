package jp.artan.dmlreloaded.neoforge.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.neoforge.container.DeepLearnerContainer;
import jp.artan.dmlreloaded.neoforge.container.ExtractionChamberContainer;
import jp.artan.dmlreloaded.neoforge.container.SimulationChamberContainer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;

public class DMLMenuType {
    private static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.MENU);

    public static final RegistrySupplier<MenuType<DeepLearnerContainer>> DEEP_LEARNER_MENU_TYPE = register("deep_learner", DeepLearnerContainer::fromNetwork);
    public static final RegistrySupplier<MenuType<SimulationChamberContainer>> SIMULATION_CHAMBER_MENU_TYPE = register("simulation_chamber_menu_type", SimulationChamberContainer::new);
    public static final RegistrySupplier<MenuType<ExtractionChamberContainer>> EXTRACTION_CHAMBER_MENU_TYPE = register("extraction_chamber", ExtractionChamberContainer::new);

    public static void register() {
        MENUS.register();
    }

    public static <T extends AbstractContainerMenu> RegistrySupplier<MenuType<T>> register(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }
}
