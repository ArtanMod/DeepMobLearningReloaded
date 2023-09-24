package jp.artan.dmlreloaded.init;

import jp.artan.artansprojectcoremod.tabs.CreativeTab;
import jp.artan.artansprojectcoremod.utils.RegistrateDisplayItemsGenerator;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ItemGroupInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate();
    public static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeepMobLearningReloaded.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DEEP_MOB_LEARNING_RELOADED = TAB_REGISTER.register("deep_mob_learning_reloaded", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.deep_mob_learning_reloaded"))
                    .displayItems(new DisplayItemsGenerator())
                    .icon(() -> new ItemStack(ItemInit.DEEP_LEARNER.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .build());

    public static void register() {
        REGISTRATE.addRawLang("itemGroup.deep_mob_learning_reloaded", "Deep Mob Learning: Reloaded");
    }

    private static class DisplayItemsGenerator extends RegistrateDisplayItemsGenerator<DeepMobLearningReloadedRegistrate> {

        public DisplayItemsGenerator() {
            super(DeepMobLearningReloaded::registrate);
        }

        @Override
        protected RegistryObject<CreativeModeTab> getCreativeTab() {
            return DEEP_MOB_LEARNING_RELOADED;
        }
    }
}
