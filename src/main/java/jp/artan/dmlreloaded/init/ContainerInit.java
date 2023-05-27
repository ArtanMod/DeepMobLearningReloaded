package jp.artan.dmlreloaded.init;

import jp.artan.artansprojectcoremod.plugin.registrate.builder.ModContainerBuilder;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.container.DeepLearnerContainer;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.screen.DeepLearnerScreen;
import jp.artan.repack.registrate.builders.MenuBuilder;
import jp.artan.repack.registrate.util.entry.MenuEntry;
import jp.artan.repack.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class ContainerInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate();

    public static final MenuEntry<DeepLearnerContainer> DEEP_LEARNER = register("deep_learner", DeepLearnerContainer::fromNetwork, () -> DeepLearnerScreen::new)
            .addRawLang("dmlreloaded.gui.deep_learner.not_found", "No Data Model Found")
            .addRawJPLang("dmlreloaded.gui.deep_learner.not_found", "データモデルが見つかりません")
            .addRawLang("dmlreloaded.gui.deep_learner.insert", "Please insert a Data Model!")
            .addRawJPLang("dmlreloaded.gui.deep_learner.insert", "データモデルを挿入してください!")
            .addRawLang("dmlreloaded.gui.deep_learner.collect_data", "Your data models will collect data")
            .addRawJPLang("dmlreloaded.gui.deep_learner.collect_data", "データモデルは、深層学習装置に配置される")
            .addRawLang("dmlreloaded.gui.deep_learner.when_placed", "when they are placed in the deep learner.")
            .addRawJPLang("dmlreloaded.gui.deep_learner.when_placed", "とデータを収集するようになります.")
            .addRawLang("dmlreloaded.gui.deep_learner.in_order", "In order to collect data, you must")
            .addRawJPLang("dmlreloaded.gui.deep_learner.in_order", "データを収集するためには")
            .addRawLang("dmlreloaded.gui.deep_learner.killing_blow", "deliver the killing blow.")
            .addRawJPLang("dmlreloaded.gui.deep_learner.killing_blow", "とどめの一撃を与える必要があります.")
            .addRawLang("dmlreloaded.tiers.tier", "Model Tier: %1$s")
            .addRawJPLang("dmlreloaded.tiers.tier", "モデルの等級: %1$s")
            .addRawLang("dmlreloaded.tiers.tier_next", "Defeat %1$s more to reach %2$s")
            .addRawJPLang("dmlreloaded.tiers.tier_next", "%2$sまであと%1$s体倒すと達成")
            .addRawLang("dmlreloaded.gui.deep_learner.max", "Maximum tier achieved")
            .addRawJPLang("dmlreloaded.gui.deep_learner.max", "達成した最大等級")
            .addRawLang("dmlreloaded.gui.deep_learner.hp", "Life points")
            .addRawJPLang("dmlreloaded.gui.deep_learner.hp", "体力")
            .addRawLang("dmlreloaded.gui.name", "Name")
            .addRawJPLang("dmlreloaded.gui.name", "名前")
            .addRawLang("dmlreloaded.gui.information", "Information")
            .addRawJPLang("dmlreloaded.gui.information", "情報")
            .addRawLang("dmlreloaded.gui.mob_name", "The %1$s")
            .addRawJPLang("dmlreloaded.gui.mob_name", "%1$s")
            .register();

    public static void register() {
    }

    private static <C extends AbstractContainerMenu, S extends Screen & MenuAccess<C>> ModContainerBuilder<C, S, DeepMobLearningReloadedRegistrate> register(
            String name,
            MenuBuilder.ForgeMenuFactory<C> factory,
            NonNullSupplier<MenuBuilder.ScreenFactory<C, S>> screenFactory
    ) {
        return REGISTRATE.menu(name, factory, screenFactory);
    }
}
