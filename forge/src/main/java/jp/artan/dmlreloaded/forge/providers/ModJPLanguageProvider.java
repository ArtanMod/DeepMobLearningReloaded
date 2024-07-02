package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractJPLanguageProvider;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.init.DMLBlocksForge;
import jp.artan.dmlreloaded.forge.init.DMLItemsForge;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.data.DataGenerator;

public class ModJPLanguageProvider extends AbstractJPLanguageProvider {
    public ModJPLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void addTranslations() {
        addTranslationsToolTip();
        addTranslationsScreen();
        registerDataModelUpgrade();

        addTranslationsStandardBlock();
        addTranslationsStandardItem();
        addTranslationsDataModel();
        addTranslationsPristineMatter();
        addTranslationsLivingMatter();
    }

    /**
     * ToolTip
     */
    private void addTranslationsToolTip() {
        this.add(this.createToolTip("data_model.data.collected"), "データ収集: %1$s/%2$s");
        this.add(this.createToolTip("data_model.data.killmultiplier"), "キル数ごとの学習量: %1$s");
        this.add(this.createToolTip("data_model.rfcost"), "シミュレーションコスト: %1$s RF/t");
        this.add(this.createToolTip("data_model.tier"), "等級: %1$s");
        this.add(this.createToolTip("data_model.type_text"), "タイプ: %1$s");
        this.add(this.createToolTip("gui.deep_learner.collect_data"), "データモデルは、深層学習装置に配置される");
        this.add(this.createToolTip("gui.deep_learner.hp"), "体力");
        this.add(this.createToolTip("gui.deep_learner.in_order"), "データを収集するためには");
        this.add(this.createToolTip("gui.deep_learner.insert"), "データモデルを挿入してください!");
        this.add(this.createToolTip("gui.deep_learner.killing_blow"), "とどめの一撃を与える必要があります.");
        this.add(this.createToolTip("gui.deep_learner.max"), "達成した最大等級");
        this.add(this.createToolTip("gui.deep_learner.not_found"), "データモデルが見つかりません");
        this.add(this.createToolTip("gui.deep_learner.overlay"), "%1$sのモデル");
        this.add(this.createToolTip("gui.deep_learner.when_placed"), "とデータを収集するようになります.");
        this.add(this.createToolTip("gui.defeated"), "%1$sを倒した回数: %2$s");
        this.add(this.createToolTip("gui.energy.energystored"), "%1$s/%2$s RF");
        this.add(this.createToolTip("gui.extraction_chamber.opcost"), "実行コスト: %1$s RF/t");
        this.add(this.createToolTip("gui.information"), "情報");
        this.add(this.createToolTip("gui.mob_name"), "%1$s");
        this.add(this.createToolTip("gui.name"), "名前");
        this.add(this.createToolTip("gui.simulation_chamber.cannot_begin"), "シミュレーションを開始できません");
        this.add(this.createToolTip("gui.simulation_chamber.collected"), "%1$s / %2$sデータを収集");
        this.add(this.createToolTip("gui.simulation_chamber.drain"), "現在のデータモデルでシミュレーションすると%1$s RF/t消費します");
        this.add(this.createToolTip("gui.simulation_chamber.insert"), "シミュレーションを開始するために");
        this.add(this.createToolTip("gui.simulation_chamber.iterations"), "繰り返し回数: %1$s");
        this.add(this.createToolTip("gui.simulation_chamber.max_tier"), "このデータモデルは最大等級に達しています.");
        this.add(this.createToolTip("gui.simulation_chamber.missing"), "機械にデータモデルがありません");
        this.add(this.createToolTip("gui.simulation_chamber.missing_polymer"), "ポリマー粘土がありません");
        this.add(this.createToolTip("gui.simulation_chamber.pristine_chance"), "綺麗なマターの入手確率: %1$s%%");
        this.add(this.createToolTip("gui.simulation_chamber.tier1.1"), "モデルのデータが不足しています");
        this.add(this.createToolTip("gui.simulation_chamber.tier1.2"), "等級が基本以上のデータモデルを");
        this.add(this.createToolTip("gui.simulation_chamber.tier1.3"), "挿入してください");
        this.add(this.createToolTip("gui.simulation_chamber.to_begin"), "データモデルを挿入してください");
        this.add(this.createToolTip("holdctrl"), "- %1$s長押しで対象モブ情報を表示");
        this.add(this.createToolTip("holdshift"), "- %1$s長押しで情報を表示");
        this.add(this.createToolTip("hover_text.glitch_fragment_1"), "%1$sを粉砕して作る");
        this.add(this.createToolTip("hover_text.glitch_fragment_2"), "%1$sに対して(右クリック)");
        this.add(this.createToolTip("hover_text.glitch_fragment_3"), "砕いた心臓1個につき3個の破片を得ることができます");
        this.add(this.createToolTip("hover_text.glitch_fragment_4"), "敵対するモブからまれにドロップすることがあります");
        this.add(this.createToolTip("hover_text.glitch_heart"), "グリッチシステムからドロップ");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_1"), "ボーナス: フルセット装備時");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_2"), "(ボーナスは試練中は無効です)");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_3"), "  1. データモデルがデータを獲得したときに");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_4"), "     一定の確率で綺麗なマターをドロップします");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_5"), "  2. 飛行と落下ダメージ無効");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_1"), "ボーナス: クイックラーニング");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_2"), "(ボーナスは試練中は無効です)");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_3"), "モブを倒した時に得られるデータが2倍になります");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_4"), "データが得られたとき、ごくわずかな確率で");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_5"), "剣の耐久値が増加します.");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_6"), "現在の耐久値増加: %1$s (最大 %2$s)");
        this.add(this.createToolTip("hover_text.glitchingot_1"), "%1$sを安定化させることで作成できます");
        this.add(this.createToolTip("hover_text.more_info"), "詳細はJEIかガイドブックを参照してください");
        this.add(this.createToolTip("hover_text.soot_covered_redstone_1"), "%1$sを押し潰して作成します");
        this.add(this.createToolTip("hover_text.soot_covered_redstone_2"), "%1$sに対して(左クリック)");
        this.add(this.createToolTip("learning_target"), "学習対象のモブ");
        this.add(this.createToolTip("living_matter.deeperdarker"), "Deeper Darkerマター");
        this.add(this.createToolTip("living_matter.exp"), "アイテムごとの経験値: %1$s");
        this.add(this.createToolTip("living_matter.exp_consume"), "%1$sで消費することができます");
        this.add(this.createToolTip("living_matter.exp_consume_stack"), "%1$sを押しながら使用するとスタック全体が消費されます.");
        this.add(this.createToolTip("living_matter.extraterrestrial"), "Extraterrestrial");
        this.add(this.createToolTip("living_matter.hellish"), "Hellish");
        this.add(this.createToolTip("living_matter.overworldian"), "Overworldian");
        this.add(this.createToolTip("messages.sword_levelup"), "%1$sは力を増しています");
        this.add(this.createToolTip("messages.sword_levelup.max"), "%1$sは最大の性能に達しました");
        this.add(this.createToolTip("tiers.increase_tier"), "%1$sが%2$sの階級にアップデート");
        this.add(this.createToolTip("tiers.tier"), "モデルの等級: %1$s");
        this.add(this.createToolTip("tiers.tier_1"), "不完全");
        this.add(this.createToolTip("tiers.tier_2"), "基本");
        this.add(this.createToolTip("tiers.tier_3"), "上級");
        this.add(this.createToolTip("tiers.tier_4"), "至上");
        this.add(this.createToolTip("tiers.tier_5"), "自己認識");
        this.add(this.createToolTip("tiers.tier_next"), "%2$sまであと%1$s体倒すと達成");
    }

    /**
     * Screen
     */
    private void addTranslationsScreen() {

    }

    private String createToolTip(String key) {
        return DeepMobLearningReloadedMod.MOD_ID + "." + key;
    }

    private void addTranslationsStandardBlock() {
        this.add(DMLBlocksForge.MACHINE_CASING.get(), "機械の枠");
        this.add(DMLBlocksForge.SIMULATION_CHAMBER.get(), "シミュレーション室");
        this.add(DMLBlocksForge.EXTRACTION_CHAMBER.get(), "抽出室");
        this.add(DMLBlocksForge.INFUSED_INGOT_BLOCK.get(), "グリッチが染み込んだブロック");
    }


    /**
     * 標準アイテム
     */
    private void addTranslationsStandardItem() {
        this.add(DMLItems.SOOT_COVERED_REDSTONE.get(), "煤で覆われたレッドストーン");
        this.add(DMLItems.SOOT_COVERED_PLATE.get(), "煤で覆われたプレート");
        this.add(DMLItems.GLITCH_FRAGMENT.get(), "不安定なグリッチの断片");
        this.add(DMLItems.GLITCH_HEART.get(), "破損したグリッチの心臓");
        this.add(DMLItems.GLITCH_INGOT.get(), "グリッチが染み込んだインゴット");
        this.add(DMLItems.NETHERITE_GLITCH_INGOT.get(), "ネザライトグリッチが染み込んだインゴット");
        this.add(DMLItemsForge.DEEP_LEARNER.get(), "深層学習装置");
        this.add(DMLItemsForge.NETHERITE_DEEP_LEARNER.get(), "ネザライト深層学習装置");
        this.add(DMLItems.POLYMER_CLAY.get(), "ポリマー粘土");
        this.add(DMLItems.GLITCH_SWORD.get(), "グリッチが染み込んだ剣");
        this.add(DMLItems.NETHERITE_GLITCH_SWORD.get(), "ネザライトグリッチが染み込んだ剣");
    }

    /**
     * アップグレードデータモデル
     */
    private void registerDataModelUpgrade() {
        this.add(DMLItems.DATA_MODEL_UPGRADE_TIER1.get(), "データモデルアップグレード: Tier1");
        this.add(DMLItems.DATA_MODEL_UPGRADE_TIER2.get(), "データモデルアップグレード: Tier2");
        this.add(DMLItems.DATA_MODEL_UPGRADE_TIER3.get(), "データモデルアップグレード: Tier3");
        this.add(DMLItems.DATA_MODEL_UPGRADE_TIER4.get(), "データモデルアップグレード: Tier4");
    }

    /**
     * データモデル
     */
    private void addTranslationsDataModel() {
        this.add(DMLItems.DATA_MODEL_BLANK.get(), "空のデータモデル");
        this.add(DMLItems.DATA_MODEL_BLAZE.get(), "ブレイズのデータモデル");
        this.add(DMLItems.DATA_MODEL_CREEPER.get(), "クリーパーのデータモデル");
        this.add(DMLItems.DATA_MODEL_ENDER_DRAGON.get(), "エルダーガーディアンのデータモデル");
        this.add(DMLItems.DATA_MODEL_ELDER_GUARDIAN.get(), "エンダードラゴンのデータモデル");
        this.add(DMLItems.DATA_MODEL_ENDERMAN.get(), "エンダーマンのデータモデル");
        this.add(DMLItems.DATA_MODEL_EVOKER.get(), "エヴォーカーのデータモデル");
        this.add(DMLItems.DATA_MODEL_GHAST.get(), "ガストのデータモデル");
        this.add(DMLItems.DATA_MODEL_GUARDIAN.get(), "ガーディアンのデータモデル");
        this.add(DMLItems.DATA_MODEL_HOGLIN.get(), "ホグリンのデータモデル");
        this.add(DMLItems.DATA_MODEL_MAGMA_CUBE.get(), "マグマキューブのデータモデル");
        this.add(DMLItems.DATA_MODEL_PHANTOM.get(), "ファントムのデータモデル");
        this.add(DMLItems.DATA_MODEL_PIGLIN.get(), "ピグリンのデータモデル");
        this.add(DMLItems.DATA_MODEL_RAVAGER.get(), "ラヴェジャーのデータモデル");
        this.add(DMLItems.DATA_MODEL_SHULKER.get(), "シュルカーのデータモデル");
        this.add(DMLItems.DATA_MODEL_SKELETON.get(), "スケルトンのデータモデル");
        this.add(DMLItems.DATA_MODEL_SLIME.get(), "スライムのデータモデル");
        this.add(DMLItems.DATA_MODEL_SPIDER.get(), "クモのデータモデル");
        this.add(DMLItems.DATA_MODEL_WARDEN.get(), "ウォーデンのデータモデル");
        this.add(DMLItems.DATA_MODEL_WITCH.get(), "ウィッチのデータモデル");
        this.add(DMLItems.DATA_MODEL_WITHER_SKELETON.get(), "ウィザースケルトンのデータモデル");
        this.add(DMLItems.DATA_MODEL_WITHER.get(), "ウィザーのデータモデル");
        this.add(DMLItems.DATA_MODEL_ZOMBIE.get(), "ゾンビのデータモデル");
    }

    /**
     * マター
     */
    private void addTranslationsPristineMatter() {
        this.add(DMLItems.PRISTINE_MATTER_BLAZE.get(), "綺麗なブレイズのマター");
        this.add(DMLItems.PRISTINE_MATTER_CREEPER.get(), "綺麗なクリーパーのマター");
        this.add(DMLItems.PRISTINE_MATTER_ENDER_DRAGON.get(), "綺麗なエルダーガーディアンのマター");
        this.add(DMLItems.PRISTINE_MATTER_ELDER_GUARDIAN.get(), "綺麗なエンダードラゴンのマター");
        this.add(DMLItems.PRISTINE_MATTER_ENDERMAN.get(), "綺麗なエンダーマンのマター");
        this.add(DMLItems.PRISTINE_MATTER_EVOKER.get(), "綺麗なエヴォーカーのマター");
        this.add(DMLItems.PRISTINE_MATTER_GHAST.get(), "綺麗なガストのマター");
        this.add(DMLItems.PRISTINE_MATTER_GUARDIAN.get(), "綺麗なガーディアンのマター");
        this.add(DMLItems.PRISTINE_MATTER_HOGLIN.get(), "綺麗なホグリンのマター");
        this.add(DMLItems.PRISTINE_MATTER_MAGMA_CUBE.get(), "綺麗なマグマキューブのマター");
        this.add(DMLItems.PRISTINE_MATTER_PHANTOM.get(), "綺麗なファントムのマター");
        this.add(DMLItems.PRISTINE_MATTER_PIGLIN.get(), "綺麗なピグリンのマター");
        this.add(DMLItems.PRISTINE_MATTER_RAVAGER.get(), "綺麗なラヴェジャーのマター");
        this.add(DMLItems.PRISTINE_MATTER_SHULKER.get(), "綺麗なシュルカーのマター");
        this.add(DMLItems.PRISTINE_MATTER_SKELETON.get(), "綺麗なスケルトンのマター");
        this.add(DMLItems.PRISTINE_MATTER_SLIME.get(), "綺麗なスライムのマター");
        this.add(DMLItems.PRISTINE_MATTER_SPIDER.get(), "綺麗なクモのマター");
        this.add(DMLItems.PRISTINE_MATTER_WARDEN.get(), "綺麗なウォーデンのマター");
        this.add(DMLItems.PRISTINE_MATTER_WITCH.get(), "綺麗なウィッチのマター");
        this.add(DMLItems.PRISTINE_MATTER_WITHER_SKELETON.get(), "綺麗なウィザースケルトンのマター");
        this.add(DMLItems.PRISTINE_MATTER_WITHER.get(), "綺麗なウィザーのマター");
        this.add(DMLItems.PRISTINE_MATTER_ZOMBIE.get(), "綺麗なゾンビマター");
    }

    /**
     * 環境マター
     */
    private void addTranslationsLivingMatter() {
        this.add(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get(), "Extraterrestrialマター");
        this.add(DMLItems.LIVING_MATTER_HELLISH.get(), "Hellishマター");
        this.add(DMLItems.LIVING_MATTER_OVERWORLDIAN.get(), "Overworldianマター");
    }

}
