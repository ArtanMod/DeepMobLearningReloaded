package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractJPLanguageProvider;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.init.DMLBlocksForge;
import jp.artan.dmlreloaded.forge.init.DMLItemsForge;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;

public class ModJPLanguageProvider extends AbstractJPLanguageProvider {
    public ModJPLanguageProvider(PackOutput output, String modid) {
        super(output, modid);
    }

    @Override
    protected void addTranslations() {
        addTranslationsToolTip();
        addTranslationsCurios();
        registerDataModelUpgrade();
        addPatchouliLang();
        addTranslationJEI();

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
        this.add(this.createToolTip("data_model_upgrade.desc"), "クリエイティブ専用");
        this.add(this.createToolTip("data_model_upgrade.tier"), "データモデルを等級%1$sにアップグレードできる");
        this.add(this.createToolTip("deep_learner.data_model_slots"), "データモデルに格納されているデータモデル.");
        this.add(this.createToolTip("deep_learner.data_model_slots_empty"), "データモデルは格納されていません.");
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
        this.add(this.createToolTip("hover_text.glitch_infused_sword_5"), "剣の攻撃力が増加します.");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_6"), "現在の攻撃力増加: %1$s (最大 %2$s)");
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
        this.add(this.createToolTip("upgrade", "glitch_upgrade"), "グリッチ強化");
        this.add(this.createToolTip("item", "smithing_template.glitch_upgrade.applies_to"), "グリッチの装備");
        this.add(this.createToolTip("item", "smithing_template.glitch_upgrade.ingredients"), "ネザライトグリッチが染み込んだインゴット");
        this.add(this.createToolTip("item", "smithing_template.glitch_upgrade.base_slot_description"), "グリッチの装備、武器、ツール");
        this.add(this.createToolTip("item", "smithing_template.glitch_upgrade.additions_slot_description"), "ネザライトグリッチが染み込んだインゴットを追加");
    }

    /**
     * Curios
     */
    private void addTranslationsCurios() {
        this.add("curios.identifier.deep_learner", "深層学習装置");
    }

    /**
     * JEI
     */
    private void addTranslationJEI() {
        this.add("jei.dmlreloaded.glitch_ingot", "TLDR: 不安定なグリッチの断片・ラピスラズリ・金インゴットを水に落とす。\\n\\nラピスラズリは不安定なグリッチの断片を安定させるのに適していることがわかりました。\\n不安定なグリッチの断片が安定した後、結合する素材を求めて必死探してます。\\n\\nこのプロセス全体は繊細で、水中で行わないと材料が適切に結合しない。");
    }

    private void addPatchouliLang() {
        {
            this.add("patchouli.book.landing_text", "$(dml)は$(l:https://minecraft.curseforge.com/projects/soul-shards-respawn)Soul shards$()と$(l:https://minecraft.curseforge.com/projects/woot)Woot$()に影響を受けています。$(br2)このガイドは$(l:https://minecraft.curseforge.com/projects/patchouli)Patchouli$()、$(l:https://twitter.com/Vazkii)Vazkii$()によって作成され、Artanによって追記されてます");
            this.add("patchouli.book.sub_title", "総合的なガイドではない");

            {
                this.add("patchouli.category.1.introduction.title", "はじめに");
                this.add("patchouli.category.1.introduction.text", "この章では$(item)Mod$()の基本を説明します。$(l:0_introduction/1_data)データ$()の学習を始めて、$(l:0_introduction/2_data_models#data_models)データモデル$()を作成することができます。");
                {
                    this.add("patchouli.category.1.introduction.entry.1.title", "はじめに");
                    this.add("patchouli.category.1.introduction.entry.1.page.1.text", "この$(item)Mod$()の設計原理は、従来の方法でモブの資源を集める代わりに、シンプルで$(br)ラグがないことです。$(br2)このModの仕組みは、プレイヤーが探索や戦闘に参加し後々その恩恵を受けるようにします。 $(br2)これを始めるには、いくつかの特殊な$(item)クラフト部品$()が必要になるでしょう。");
                    this.add("patchouli.category.1.introduction.entry.1.page.2.text", "煤に覆われたレッドストーン$()は、$(item)レッドストーンダスト$()を$(item)石炭のブロック$()に押し付けることで作ることができます。");
                }
                {
                    this.add("patchouli.category.1.introduction.entry.2.title", "データ");
                    this.add("patchouli.category.1.introduction.entry.2.page.1.text", "報酬を得るためにモブの$(item)データ$()を学習する必要があります。それを可能にする携帯端末が$(item)深層学習装置$()です。");
                    this.add("patchouli.category.1.introduction.entry.2.page.2.text", "$(item)深層学習装置$()に$(l:0_introduction/2_data_models)データモデル$()が付いていれば、そのモブとの出会いを$(item)データ$()にすることができます。$(br2)深層学習装置$()には$(l:0_introduction/2_data_models)データモデル$()を最大4つ設定できます。");
                    this.add("patchouli.category.1.introduction.entry.2.page.3.text", "$(item)深層学習装置$()を$(item)メインハンド$()または$(item)オフハンド$()に持っていると、$(item)データモデル$()が次の$(item)等級$()に達するまでにあとどのくらい必要かを示すHUDが表示されます。");
                }
                {
                    this.add("patchouli.category.1.introduction.entry.3.title", "データモデル");
                    this.add("patchouli.category.1.introduction.entry.3.page.1.text", "以前作った$(l:0_introduction/0_introduction#sooted_redstone)煤まみれのレッドストーン$()の一部で、$(item)空のデータモデル$()を作ることができます。");
                    this.add("patchouli.category.1.introduction.entry.3.page.2.text", "全ての$(item)データモデル$()は「$(8)不完全$()」という階層から始まり、$(item)データモデル$()が多くの$(item)データ$()を学習するとこの等級は上がります。$(br2)$(item)等級$()が上がると、倒したモブからより多くの$(item)データ$()を獲得できます。$(br2)$(item)データモデル$()は、$(l:1_machines/0_simulation_chamber)シミュレーション室$()に入れてもよいです。");
                    this.add("patchouli.category.1.introduction.entry.3.page.3.text", "$(item)データモデル$()は、$(item)生息地$()によって$(item)タイプ$()が分かれます。$(item)生息地$()の種類は、$(a)オーバーワールド$()、$(c)ネザー$()、$(d)エンド$()の3つです。 $(br2)データモデル$()のタイプによって、$(l:1_machines/0_simulation_chamber)シミュレーション室$()がどのような$(l:1_machines/1_matter#living)Living Matter$()や$(l:1_machines/1_matter#pristine)綺麗なマター$()を生成するかが決まります。");
                    this.add("patchouli.category.1.introduction.entry.3.page.4.title", "ゾンビ / スケルトン");
                    this.add("patchouli.category.1.introduction.entry.3.page.5.title", "クリーパー / スパイダー");
                    this.add("patchouli.category.1.introduction.entry.3.page.6.title", "スライム / ウィッチ");
                    this.add("patchouli.category.1.introduction.entry.3.page.7.title", "ブレイズ / ガスト");
                    this.add("patchouli.category.1.introduction.entry.3.page.8.title", "ウィザースケルトン / エンダーマン");
                    this.add("patchouli.category.1.introduction.entry.3.page.9.title", "ウィザー / エンダードラゴン");
                    this.add("patchouli.category.1.introduction.entry.3.page.10.title", "シュルカー / ガーディアン");
                    this.add("patchouli.category.1.introduction.entry.3.page.11.title", "エルダーガーディアン / エヴォーカー");
                    this.add("patchouli.category.1.introduction.entry.3.page.12.title", "ホグリン / マグマキューブ");
                    this.add("patchouli.category.1.introduction.entry.3.page.13.title", "ファントム / ピグリン");
                    this.add("patchouli.category.1.introduction.entry.3.page.14.title", "ラヴェジャー");
                }
            }
            {
                this.add("patchouli.category.2.introduction.title", "機械");
                this.add("patchouli.category.2.introduction.text", "この章では、$(dml)の機械について説明します。$(br2)すべての$(item)機械$()は、ブロックの上部から$(item)Inputs$()を受け入れることができます。他の側面は、$(item)Outputs$()のパイプに使われます。");

                {
                    this.add("patchouli.category.2.introduction.entry.1.title", "シミュレーション室");
                    this.add("patchouli.category.2.introduction.entry.1.page.1.text", "$(item)シミュレーション室$()は、あなたの$(l:0_introduction/2_data_models)データモデル$()に保存されている情報を読み取り、そこから$(l:0_introduction/1_data)データ$()を作成することができる機械です。$(br2)この処理によって、現在使われている$(l:0_introduction/2_data_models)データモデル$()に、さらに$(l:0_introduction/1_data)データ$()が追加されます。$(br2)この処理には、$(a)基本$()(またはそれ以上)の等級の$(br)$(l:0_introduction/2_data_models)データモデル$()と$(l:1_machines/3_energy)エネルギー$()、$(br)$(item)ポリマー粘土$()が必要です。");
                    this.add("patchouli.category.2.introduction.entry.1.page.2.text", "$(item)シミュレーション室$()は、$(l:0_introduction/0_introduction#plates_and_casings)機械の枠$()で作られています。$(br2)運用$(item)エネルギー$()のコストは、どの$(l:0_introduction/2_data_models)データモデル$()が使われるかにより異なります。");
                    this.add("patchouli.category.2.introduction.entry.1.page.3.text", "$(item)ポリマー粘土$()はとても柔らかく、ほとんどの形を作ることができる粘土です。$(br2)シミュレーション室$()では、$(l:1_machines/1_matter)マター$()を作るための結合剤として使われています。");
                }
                {
                    this.add("patchouli.category.2.introduction.entry.2.title", "マター");
                    this.add("patchouli.category.2.introduction.entry.2.page.1.text", "$(item)マター$()には、$(item)Living Matter$()と$(item)綺麗なマター$()の2種類があります。$(br2)$(l:1_machines/0_simulation_chamber)シミュレーション$()を行うと、必ず$(item)Living Matter$()を1つ入手できます。$(br2)また、$(item)綺麗なマター$()を生成する確率もあり、その確率は$(l:0_introduction/2_data_models#data_models)データモデル$()の等級$()に依存してます。");
                    this.add("patchouli.category.2.introduction.entry.2.page.2.title", "Living Matter");
                    this.add("patchouli.category.2.introduction.entry.2.page.2.text", "その$(item)Living Matter$()はいろいろなアイテムに$(item)変換$()するのに使える万能な物質で、どんなレシピがあるかは$(item)JEI$()で確認してください。$(br2)$(item)Living Matter$()は消費して経験値も獲得できます。");
                    this.add("patchouli.category.2.introduction.entry.2.page.3.title", "変換の例");
                    this.add("patchouli.category.2.introduction.entry.2.page.4.title", "綺麗なマター");
                    this.add("patchouli.category.2.introduction.entry.2.page.4.text", "$(l:1_machines/0_simulation_chamber)シミュレーション室$()の2次出力です。$(br2)$(l:0_introduction/2_data_models#data_models)データモデル$()の種類によって、生産する$(item)綺麗なマター$()の種類が変わっています。$(br2)$(item)綺麗なマター$()は$(l:1_machines/2_loot_fabricator)抽出室$()でモブのドロップを生成します。");
                }
                {
                    this.add("patchouli.category.2.introduction.entry.3.title", "マターの生産品");
                    this.add("patchouli.category.2.introduction.entry.3.page.1.text", "$(item)抽出室$()は、よくできる機械です。$(item)綺麗なマター$()から戦利品を作ることができます。$(br2)戦利品を作るには$(l:1_machines/3_energy)エネルギー$()と$(item)アイテム$()を必要とします。");
                    this.add("patchouli.category.2.introduction.entry.3.page.2.text", "選択された$(item)アイテム$()は、自動化のために記憶され、非選択になるまで選択されたままとなります。");
                }
                {
                    this.add("patchouli.category.2.introduction.entry.4.title", "エネルギー");
                    this.add("patchouli.category.2.introduction.entry.4.page.1.title", "エネルギー");
                    this.add("patchouli.category.2.introduction.entry.4.page.1.text", "このMODでは、$(item)エネルギー$()を生成する方法は追加されていないので、$(item)機械$()を動かすには、他のMODから$(item)発電機$()が必要になります。");
                    this.add("patchouli.category.2.introduction.entry.4.page.2.title", "電源装置");
                    this.add("patchouli.category.2.introduction.entry.4.page.2.text", "$(item)FE$()と$(item)RF$()の両方が動作します。$(br2)以下は、$(item)機械$()を動かすために動作することができるいくつかのMOD例です。$(br2)$(l:https://www.curseforge.com/minecraft/mc-mods/simple-generators)Simple Generators$() (Misc)$(br)$(l:https://www.curseforge.com/minecraft/mc-mods/mekanism-generators)Mekanism Generators$() (Reactors)$(br)$(l:https://minecraft.curseforge.com/projects/advanced-generators)Advanced Generators$()");
                }
            }
//            {
//                this.add("patchouli.category.3.title", "モッド連携");
//                this.add("patchouli.category.3.description", "DeepMobLearningReloadedはいくつかのMODと連携をしています。MOD連携には段階があります。$(br2)Level1は既存のデータモデルに対して討伐対象モブとして追加や綺麗なマターで生産できるモンスタードロップ品の追加を行う連携。$(br2)Level2は対象のMODで追加されるモブのデータモデルや綺麗なマターを追加します。");
//                {
//                    this.add("patchouli.category.3.entry.1.title", "Twilight Forest");
//                    this.add("patchouli.category.3.entry.1.page.1.text", "連携レベル2$(br2)黄昏の森では新たに7種類のボスモンスター用のデータモデルが追加されます。");
//                    this.add("patchouli.category.3.entry.1.page.2.title", "ナーガ / リッチ");
//                    this.add("patchouli.category.3.entry.1.page.3.title", "ミノッシュルーム / ヒドラ");
//                    this.add("patchouli.category.3.entry.1.page.4.title", "ナイトファントム / ウルガスト");
//                    this.add("patchouli.category.3.entry.1.page.5.title", "アルファイエティ");
//                }
//                {
//                    this.add("patchouli.category.3.entry.2.title", "DeeperAndDarker");
//                    this.add("patchouli.category.3.entry.2.page.1.text", "連携レベル2$(br2)DeeperAndDarkerでは新たに3種類のボスモンスター用のデータモデルが追加されます。");
//                    this.add("patchouli.category.3.entry.2.page.2.title", "Shattered / Sculk Centipede");
//                    this.add("patchouli.category.3.entry.2.page.3.title", "Stalker");
//                }
//            }
        }
    }

    private String createToolTip(String parent, String key) {
        return parent + "." + DeepMobLearningReloadedMod.MOD_ID + "." + key;
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
        this.add(DMLItemsForge.GLITCH_FRAGMENT.get(), "不安定なグリッチの断片");
        this.add(DMLItems.GLITCH_HEART.get(), "破損したグリッチの心臓");
        this.add(DMLItems.GLITCH_INGOT.get(), "グリッチが染み込んだインゴット");
        this.add(DMLItems.NETHERITE_GLITCH_INGOT.get(), "ネザライトグリッチが染み込んだインゴット");
        this.add(DMLItems.GLITCH_UPGRADE_SMITHING_TEMPLATE.get(), "鍛冶型");
        this.add(DMLItemsForge.DEEP_LEARNER.get(), "深層学習装置");
        this.add(DMLItemsForge.NETHERITE_DEEP_LEARNER.get(), "ネザライト深層学習装置");
        this.add(DMLItems.POLYMER_CLAY.get(), "ポリマー粘土");
        this.add(DMLItems.GLITCH_SWORD.get(), "グリッチが染み込んだ剣");
        this.add(DMLItems.NETHERITE_GLITCH_SWORD.get(), "ネザライトグリッチが染み込んだ剣");
        this.addArmorItems(DMLItems.GLITCH_ARMOR, "グリッチが染み込んだ");
        this.addArmorItems(DMLItems.NETHERITE_GLITCH_ARMOR, "ネザライトグリッチが染み込んだ");
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
        this.add(DMLItems.DATA_MODEL_ENDER_DRAGON.get(), "エンダードラゴンのデータモデル");
        this.add(DMLItems.DATA_MODEL_ELDER_GUARDIAN.get(), "エルダーガーディアンのデータモデル");
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
        this.add(DMLItems.PRISTINE_MATTER_ENDER_DRAGON.get(), "綺麗なエンダードラゴンのマター");
        this.add(DMLItems.PRISTINE_MATTER_ELDER_GUARDIAN.get(), "綺麗なエルダーガーディアンのマター");
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
