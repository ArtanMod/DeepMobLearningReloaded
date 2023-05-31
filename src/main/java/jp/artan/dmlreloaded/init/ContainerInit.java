package jp.artan.dmlreloaded.init;

import jp.artan.artansprojectcoremod.plugin.registrate.builder.ModContainerBuilder;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.container.DeepLearnerContainer;
import jp.artan.dmlreloaded.container.ExtractionChamberContainer;
import jp.artan.dmlreloaded.container.SimulationChamberContainer;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.screen.DeepLearnerScreen;
import jp.artan.dmlreloaded.screen.ExtractionChamberScreen;
import jp.artan.dmlreloaded.screen.SimulationChamberScreen;
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
            .addRawLang("dmlreloaded.gui.deep_learner.overlay", "%1$s Model")
            .addRawJPLang("dmlreloaded.gui.deep_learner.overlay", "%1$sのモデル")
            .addRawLang("dmlreloaded.gui.defeated", "%1$s defeated: %2$s")
            .addRawJPLang("dmlreloaded.gui.defeated", "%1$sを倒した回数: %2$s")
            .register();

    public static final MenuEntry<SimulationChamberContainer> SIMULATION_CHAMBER = register("simulation_chamber", SimulationChamberContainer::new, () -> SimulationChamberScreen::new)
            .addRawLang("dmlreloaded.gui.simulation_chamber.collected", "%1$s / %2$s Data collected")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.collected", "%1$s / %2$sデータを収集")
            .addRawLang("dmlreloaded.gui.simulation_chamber.max_tier", "This data model has reached the max tier.")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.max_tier", "このデータモデルは最大等級に達しています.")
            .addRawLang("dmlreloaded.gui.simulation_chamber.missing", "Machine is missing a data model")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.missing", "機械にデータモデルがありません")
            .addRawLang("dmlreloaded.gui.energy.energystored", "%1$s/%2$s RF")
            .addRawJPLang("dmlreloaded.gui.energy.energystored", "%1$s/%2$s RF")
            .addRawLang("dmlreloaded.gui.simulation_chamber.drain", "Simulations with current data model drains %1$s RF/t")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.drain", "現在のデータモデルでシミュレーションすると%1$s RF/t消費します")
            .addRawLang("dmlreloaded.gui.simulation_chamber.insert", "Please insert a data model")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.insert", "シミュレーションを開始するために")
            .addRawLang("dmlreloaded.gui.simulation_chamber.to_begin", "to begin the simulation")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.to_begin", "データモデルを挿入してください")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.1", "> Launching runtime")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.2", "v1.4.7")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.3", "> Iteration # %1$s started")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.4", "> Loading model from chip memory")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.5", "> Assessing threat level")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.6", "> Engaged enemy")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.7", "> Pristine procurement")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.8_succeeded", "succeeded")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.8_failed", "failed")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.9", "> Processing results")
            .addRawLang("dmlreloaded.gui.simulation_chamber.console.10", "...")
            .addRawLang("dmlreloaded.gui.simulation_chamber.cannot_begin", "Cannot begin simulation")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.cannot_begin", "シミュレーションを開始できません")
            .addRawLang("dmlreloaded.gui.simulation_chamber.missing_polymer", "Missing polymer medium")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.missing_polymer", "ポリマー粘土がありません")
            .addRawLang("dmlreloaded.gui.simulation_chamber.iterations", "Iterations: %1$s")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.iterations", "繰り返し回数: %1$s")
            .addRawLang("dmlreloaded.gui.simulation_chamber.pristine_chance", "Pristine chance: %1$s%%")
            .addRawJPLang("dmlreloaded.gui.simulation_chamber.pristine_chance", "綺麗なマターの入手確率: %1$s%%")
            .register();
    public static final MenuEntry<ExtractionChamberContainer> EXTRACTION_CHAMBER = register("extraction_chamber", ExtractionChamberContainer::new, () -> ExtractionChamberScreen::new)
            .addRawLang("dmlreloaded.gui.extraction_chamber.opcost", "Operational cost: %1$s RF/t")
            .addRawJPLang("dmlreloaded.gui.extraction_chamber.opcost", "実行コスト: %1$s RF/t")
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
