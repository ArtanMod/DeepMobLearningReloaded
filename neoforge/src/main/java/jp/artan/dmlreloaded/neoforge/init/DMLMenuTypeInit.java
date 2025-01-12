package jp.artan.dmlreloaded.neoforge.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;

public class DMLMenuTypeInit {
    private static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.MENU);

    public static void register() {
        MENUS.register();
    }

    public static <T extends AbstractContainerMenu> RegistrySupplier<MenuType<T>> register(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }
}
