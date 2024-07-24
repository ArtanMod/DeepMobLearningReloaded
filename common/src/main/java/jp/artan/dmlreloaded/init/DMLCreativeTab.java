package jp.artan.dmlreloaded.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class DMLCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(DeepMobLearningReloadedMod.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> DEEP_MOB_LEARNING_RELOADED = createTab("deep_mob_learning_reloaded", () -> new ItemStack(BuiltInRegistries.ITEM.get(DeepMobLearningReloadedMod.getResource("deep_learner"))));
    public static void register() {
        CREATIVE_MODE_TABS.register();
    }

    private static RegistrySupplier<CreativeModeTab> createTab(String name, Supplier<ItemStack> icon) {
        return CREATIVE_MODE_TABS.register(name, () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).icon(icon).title(Component.translatable("itemGroup." + DeepMobLearningReloadedMod.MOD_ID + "." + name)).build());
    }
}
