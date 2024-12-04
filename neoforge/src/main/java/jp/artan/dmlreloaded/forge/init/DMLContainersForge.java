package jp.artan.dmlreloaded.forge.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.util.inject.NonNullSupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.container.DeepLearnerContainer;
import jp.artan.dmlreloaded.forge.container.ExtractionChamberContainer;
import jp.artan.dmlreloaded.forge.container.SimulationChamberContainer;
import jp.artan.dmlreloaded.forge.screen.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nullable;

public class DMLContainersForge {
    private static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.MENU);

    public static void register() {
        MENUS.register();
    }

    public static final RegistrySupplier<MenuType<DeepLearnerContainer>> DEEP_LEARNER = register("deep_learner", DeepLearnerContainer::fromNetwork, () -> DeepLearnerScreen::new);
    public static final RegistrySupplier<MenuType<SimulationChamberContainer>> SIMULATION_CHAMBER = register("simulation_chamber", SimulationChamberContainer::new, () -> SimulationChamberScreen::new);
    public static final RegistrySupplier<MenuType<ExtractionChamberContainer>> EXTRACTION_CHAMBER = register("extraction_chamber", ExtractionChamberContainer::new, () -> ExtractionChamberScreen::new);

    public static <T extends AbstractContainerMenu, S extends Screen & MenuAccess<T>> RegistrySupplier<MenuType<T>> register(String name, MenuFactory<T> factory, NonNullSupplier<ScreenFactory<T, S>> screenFactory) {
        return register(name, (type, windowId, inv, $) -> factory.create(type, windowId, inv), screenFactory);
    }

    public static <T extends AbstractContainerMenu, S extends Screen & MenuAccess<T>> RegistrySupplier<MenuType<T>> register(String name, ForgeMenuFactory<T> factory, NonNullSupplier<ScreenFactory<T, S>> screenFactory) {
        return MENUS.register(DeepMobLearningReloadedMod.getResource(name), () -> {
            MenuType<T> ret = IForgeMenuType.create((windowId, inv, buf) -> factory.create((MenuType<T>)MENUS.getRegistrar().get(DeepMobLearningReloadedMod.getResource(name)), windowId, inv, buf));
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                MenuScreens.register(ret, screenFactory.get()::create);
            });
            return ret;
        });
    }

    public interface MenuFactory<T extends AbstractContainerMenu> {
        T create(MenuType<T> var1, int var2, Inventory var3);
    }
    public interface ForgeMenuFactory<T extends AbstractContainerMenu> {
        T create(MenuType<T> var1, int var2, Inventory var3, @Nullable FriendlyByteBuf var4);
    }
    public interface ScreenFactory<M extends AbstractContainerMenu, T extends Screen & MenuAccess<M>> {
        T create(M var1, Inventory var2, Component var3);
    }
}
