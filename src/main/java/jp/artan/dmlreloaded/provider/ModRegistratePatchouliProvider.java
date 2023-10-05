package jp.artan.dmlreloaded.provider;

import jp.artan.artansprojectcoremod.provider.RegistratePatchouliProvider;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.init.BlockInit;
import jp.artan.dmlreloaded.init.ItemGroupInit;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class ModRegistratePatchouliProvider extends RegistratePatchouliProvider {
    public ModRegistratePatchouliProvider(String modid, DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(modid, pGenerator, existingFileHelper);
    }

    public static void addLang(DeepMobLearningReloadedRegistrate registrate) {
        {
            registrate.addRawLang("patchouli.book.landing_text", "$(dml) adds new ways to acquire loot that normally drops from mobs, the intent is to remove the need for a big laggy mobfarm.$(br2)The mod is inspired by $(l:https://minecraft.curseforge.com/projects/soul-shards-respawn)Soul shards$() and $(l:https://minecraft.curseforge.com/projects/woot)Woot$().$(br2)This guide was written with $(l:https://minecraft.curseforge.com/projects/patchouli)Patchouli$(), a $(o)neat$() mod by $(l:https://twitter.com/Vazkii)Vazkii$().");
            registrate.addRawJPLang("patchouli.book.landing_text", "$(dml)は$(l:https://minecraft.curseforge.com/projects/soul-shards-respawn)Soul shards$()と$(l:https://minecraft.curseforge.com/projects/woot)Woot$()に影響を受けています。$(br2)このガイドは$(l:https://minecraft.curseforge.com/projects/patchouli)Patchouli$()、$(l:https://twitter.com/Vazkii)Vazkii$()によって作成され、Artanによって追記されてます");
            registrate.addRawLang("patchouli.book.sub_title", "A not-so comprehensive Guide");
            registrate.addRawJPLang("patchouli.book.sub_title", "総合的なガイドではない");

            {
                registrate.addRawLang("patchouli.category.1.introduction.title", "Introduction");
                registrate.addRawJPLang("patchouli.category.1.introduction.title", "はじめに");
                registrate.addRawLang("patchouli.category.1.introduction.text", "This chapter will cover the basics of the $(item)Mod$() so you can start accumulating $(l:0_introduction/1_data)Data$() for your $(l:0_introduction/2_data_models#data_models)Data Models$().");
                registrate.addRawJPLang("patchouli.category.1.introduction.text", "この章では$(item)Mod$()の基本を説明します。$(l:0_introduction/1_data)データ$()の学習を始めて、$(l:0_introduction/2_data_models#data_models)データモデル$()を作成することができます。");
                {
                    registrate.addRawLang("patchouli.category.1.introduction.entry.1.title", "Introduction");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.1.title", "はじめに");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.1.page.1.text", "The design principle of this $(item)Mod$() is to be a simple and$(br)lag-free alternative to gathering mob resources by traditional means.$(br2)The mods mechanics encourage players to explore and engage in combat and benefit from it later on.$(br2)To get started you will need some specialized $(item)Crafting Components$().");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.1.page.1.text", "この$(item)Mod$()の設計原理は、従来の方法でモブの資源を集める代わりに、シンプルで$(br)ラグがないことです。$(br2)このModの仕組みは、プレイヤーが探索や戦闘に参加し後々その恩恵を受けるようにします。 $(br2)これを始めるには、いくつかの特殊な$(item)クラフト部品$()が必要になるでしょう。");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.1.page.2.text", "$(item)Soot-covered Redstone$() can be created by crushing some $(item)Redstone$() against a $(item)Block of Coal$().$(br2)This sooty marvel will be required to craft most things this $(item)Mod$() has to offer.");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.1.page.2.text", "煤に覆われたレッドストーン$()は、$(item)レッドストーンダスト$()を$(item)石炭のブロック$()に押し付けることで作ることができます。");
                }
                {
                    registrate.addRawLang("patchouli.category.1.introduction.entry.2.title", "Data");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.2.title", "データ");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.2.page.1.text", "Before you can start reaping the rewards you will need to collect some $(item)Data$() about a mob, the handheld device that makes that possible is called the $(item)Deep Learner$().$(br2)The $(item)Deep Learner$() is a device that can detect whenever you deliver mortal harm to a mob.");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.2.page.1.text", "報酬を得るためにモブの$(item)データ$()を学習する必要があります。それを可能にする携帯端末が$(item)深層学習装置$()です。");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.2.page.2.text", "It can turn your encounter with that mob into $(item)Data$() if you have a $(l:0_introduction/2_data_models)Data model$() attached to the $(item)Deep Learner$().$(br2)The $(item)Deep Learner$() Can have 4 attached $(l:0_introduction/2_data_models)Data Models$() at any given time.");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.2.page.2.text", "$(item)深層学習装置$()に$(l:0_introduction/2_data_models)データモデル$()が付いていれば、そのモブとの出会いを$(item)データ$()にすることができます。$(br2)深層学習装置$()には$(l:0_introduction/2_data_models)データモデル$()を最大4つ設定できます。");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.2.page.3.text", "If you hold the $(item)Deep Learner$() in your $(item)Mainhand$() or $(item)Offhand$() a HUD will be displayed showing you how much more $(item)Data$() you need before you reach the next $(l:0_introduction/2_data_models)Data Model$() $(item)Tier$().");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.2.page.3.text", "$(item)深層学習装置$()を$(item)メインハンド$()または$(item)オフハンド$()に持っていると、$(item)データモデル$()が次の$(item)等級$()に達するまでにあとどのくらい必要かを示すHUDが表示されます。");
                }
                {
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.title", "Data Models");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.title", "データモデル");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.1.text", "You can craft a $(item)Blank Data Model$() with some of that$(br)$(l:0_introduction/0_introduction#sooted_redstone)Soot-covered Redstone$() you made earlier.");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.1.text", "以前作った$(l:0_introduction/0_introduction#sooted_redstone)煤まみれのレッドストーン$()の一部で、$(item)空のデータモデル$()を作ることができます。");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.2.text", "All of the $(item)Data Models$() start at the \\\"$(8)Faulty$()\\\" tier, this tier goes up as the $(item)Data Models$() gather more $(item)Data$().$(br2)As you $(item)Tier$() up you will gain more $(item)Data$() from the mobs you defeat.$(br2)$(item)Data Models$() can be put inside a $(l:1_machines/0_simulation_chamber)Simulation chamber$()");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.2.text", "全ての$(item)データモデル$()は「$(8)不完全$()」という階層から始まり、$(item)データモデル$()が多くの$(item)データ$()を学習するとこの等級は上がります。$(br2)$(item)等級$()が上がると、倒したモブからより多くの$(item)データ$()を獲得できます。$(br2)$(item)データモデル$()は、$(l:1_machines/0_simulation_chamber)シミュレーション室$()に入れてもよいです。");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.3.text", "$(item)Data Models$() are split into $(item)Types$() depending on their $(item)Habitat$().$(br2)The basic $(item)Habitats$() are: $(a)Overworldian$(), $(c)Hellish$() and $(d)Extraterrestrial$().$(br2)The type of the $(item)Data Model$() will determine what kind of $(l:1_machines/1_matter#living)Living Matter$() and $(l:1_machines/1_matter#pristine)Pristine Matter$() the $(l:1_machines/0_simulation_chamber)Simulation Chamber$() will produce.");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.3.text", "$(item)データモデル$()は、$(item)生息地$()によって$(item)タイプ$()が分かれます。$(item)生息地$()の種類は、$(a)オーバーワールド$()、$(c)ネザー$()、$(d)エンド$()の3つです。 $(br2)データモデル$()のタイプによって、$(l:1_machines/0_simulation_chamber)シミュレーション室$()がどのような$(l:1_machines/1_matter#living)Living Matter$()や$(l:1_machines/1_matter#pristine)綺麗なマター$()を生成するかが決まります。");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.4.title", "Zombie / Skeleton");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.4.title", "ゾンビ / スケルトン");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.5.title", "Creeper / Spider");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.5.title", "クリーパー / スパイダー");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.6.title", "Slime / Witch");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.6.title", "スライム / ウィッチ");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.7.title", "Blaze / Ghast");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.7.title", "ブレイズ / ガスト");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.8.title", "Wither Skeleton / Enderman");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.8.title", "ウィザースケルトン / エンダーマン");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.9.title", "Wither / Ender Dragon");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.9.title", "ウィザー / エンダードラゴン");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.10.title", "Shulker / Guardian");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.10.title", "シュルカー / ガーディアン");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.11.title", "Elder Guardian / Evoker");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.11.title", "エルダーガーディアン / エヴォーカー");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.12.title", "Hoglin / Magma Cube");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.12.title", "ホグリン / マグマキューブ");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.13.title", "Phantom / Piglin");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.13.title", "ファントム / ピグリン");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.14.title", "Ravager");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.14.title", "ラヴェジャー");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.15.title", "Ravager / Naga");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.15.title", "ラヴェジャー / ナーガ");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.16.title", "Lich / Minoshroom");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.16.title", "リッチ / ミノッシュルーム");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.17.title", "Hydra / Knight Phantom");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.17.title", "ヒドラ / ナイトファントム");
                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.18.title", "Ur Ghast / Alpha Yeti");
                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.18.title", "ウルガスト / アルファイエティ");
//                    registrate.addRawLang("patchouli.category.1.introduction.entry.3.page.19.title", "Snow Queen");
//                    registrate.addRawJPLang("patchouli.category.1.introduction.entry.3.page.19.title", "雪の女王");
                }
            }
            {
                registrate.addRawLang("patchouli.category.2.introduction.title", "Machines");
                registrate.addRawJPLang("patchouli.category.2.introduction.title", "機械");
                registrate.addRawLang("patchouli.category.2.introduction.text", "This chapter will teach you everything you need to know about the machines$(br)in $(dml)$(br2)All $(item)Machines$() accepts $(item)Inputs$() from the top of the block. The other sides are used to pipe $(item)Outputs$().");
                registrate.addRawJPLang("patchouli.category.2.introduction.text", "この章では、$(dml)の機械について説明します。$(br2)すべての$(item)機械$()は、ブロックの上部から$(item)Inputs$()を受け入れることができます。他の側面は、$(item)Outputs$()のパイプに使われます。");

                {
                    registrate.addRawLang("patchouli.category.2.introduction.entry.1.title", "Simulation Chamber");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.1.title", "シミュレーション室");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.1.page.1.text", "The $(item)Simulation Chamber$() is a machine that can read the information stored on your $(l:0_introduction/2_data_models)Data Models$() and from that $(l:0_introduction/1_data)Data$() create $(l:1_machines/1_matter)Matter$().$(br2)This process will add more $(l:0_introduction/1_data)Data$() to the $(l:0_introduction/2_data_models)Data Model$() currently being used.$(br2)This process also requires a $(a)Basic$() (or higher) tier$(br)$(l:0_introduction/2_data_models)Data Model$(), $(l:1_machines/3_energy)Energy$() and$(br)$(item)Polymer Clay$().");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.1.page.1.text", "$(item)シミュレーション室$()は、あなたの$(l:0_introduction/2_data_models)データモデル$()に保存されている情報を読み取り、そこから$(l:0_introduction/1_data)データ$()を作成することができる機械です。$(br2)この処理によって、現在使われている$(l:0_introduction/2_data_models)データモデル$()に、さらに$(l:0_introduction/1_data)データ$()が追加されます。$(br2)この処理には、$(a)基本$()(またはそれ以上)の等級の$(br)$(l:0_introduction/2_data_models)データモデル$()と$(l:1_machines/3_energy)エネルギー$()、$(br)$(item)ポリマー粘土$()が必要です。");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.1.page.2.text", "The $(item)Simulation Chamber$() is crafted with a $(l:0_introduction/0_introduction#plates_and_casings)Sooted Machine Casing$().$(br2)The operational $(item)Energy$() cost depends on what $(l:0_introduction/2_data_models)Data Model$() is used.");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.1.page.2.text", "$(item)シミュレーション室$()は、$(l:0_introduction/0_introduction#plates_and_casings)機械の枠$()で作られています。$(br2)運用$(item)エネルギー$()のコストは、どの$(l:0_introduction/2_data_models)データモデル$()が使われるかにより異なります。");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.1.page.3.text", "$(item)Polymer Clay$() is a very soft and adept clay that can take on most shapes.$(br2)In the $(item)Simulation Chamber$() its used as a binding agent to create $(l:1_machines/1_matter)Matter$()");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.1.page.3.text", "$(item)ポリマー粘土$()はとても柔らかく、ほとんどの形を作ることができる粘土です。$(br2)シミュレーション室$()では、$(l:1_machines/1_matter)マター$()を作るための結合剤として使われています。");
                }
                {
                    registrate.addRawLang("patchouli.category.2.introduction.entry.2.title", "Matter");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.2.title", "マター");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.2.page.1.text", "There are two kinds of $(item)Matter$(), $(item)Living$() and $(item)Pristine$().$(br2)You will always get one$(br2)$(item)Living Matter$() from running a $(l:1_machines/0_simulation_chamber)Simulation$().$(br2)There is also a chance to produce $(item)Pristine Matter$(), the chance depends on the $(item)Tier$() of the $(l:0_introduction/2_data_models#data_models)Data Model$() currently in the $(l:1_machines/0_simulation_chamber)Simulation Chamber$().");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.2.page.1.text", "$(item)マター$()には、$(item)Living Matter$()と$(item)綺麗なマター$()の2種類があります。$(br2)$(l:1_machines/0_simulation_chamber)シミュレーション$()を行うと、必ず$(item)Living Matter$()を1つ入手できます。$(br2)また、$(item)綺麗なマター$()を生成する確率もあり、その確率は$(l:0_introduction/2_data_models#data_models)データモデル$()の等級$()に依存してます。");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.2.page.2.title", "Living Matter");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.2.page.2.title", "Living Matter");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.2.page.2.text", "$(item)Living Matter$() is a versatile matter that can be used to $(item)Transmute$() ingredients local to that $(item)Habitat$(), check $(item)JEI$() to see what recipes are available.$(br2)You can also consume $(item)Living Matter$() to gain $(item)Experience$().");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.2.page.2.text", "その$(item)Living Matter$()はいろいろなアイテムに$(item)変換$()するのに使える万能な物質で、どんなレシピがあるかは$(item)JEI$()で確認してください。$(br2)$(item)Living Matter$()は消費して経験値も獲得できます。");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.2.page.3.title", "Example Transmutes");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.2.page.3.title", "変換の例");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.2.page.4.title", "Pristine Matter");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.2.page.4.title", "綺麗なマター");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.2.page.4.text", "Secondary output from the $(l:1_machines/0_simulation_chamber)Simulation Chamber$().$(br2)The type of $(item)Pristine Matter$() you will produce depends on the type of the $(l:0_introduction/2_data_models#data_models)Data Model$().$(br2)$(item)Pristine Matter$() will produce mob drops in the$(br)$(l:1_machines/2_loot_fabricator)Loot Fabricator$().");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.2.page.4.text", "$(l:1_machines/0_simulation_chamber)シミュレーション室$()の2次出力です。$(br2)$(l:0_introduction/2_data_models#data_models)データモデル$()の種類によって、生産する$(item)綺麗なマター$()の種類が変わっています。$(br2)$(item)綺麗なマター$()は$(l:1_machines/2_loot_fabricator)抽出室$()でモブのドロップを生成します。");
                }
                {
                    registrate.addRawLang("patchouli.category.2.introduction.entry.3.title", "Loot Fabricator");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.3.title", "マターの生産品");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.3.page.1.text", "The $(item)Loot Fabricator$() is a machine that can well.... $(item)Fabricate Loot$() from the various accessible $(item)Pristine Matters$().$(br2)This process requires $(l:1_machines/3_energy)Energy$() aswell as a selected $(item)Item$() to produce $(item)Loot$().");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.3.page.1.text", "$(item)抽出室$()は、よくできる機械です。$(item)綺麗なマター$()から戦利品を作ることができます。$(br2)戦利品を作るには$(l:1_machines/3_energy)エネルギー$()と$(item)アイテム$()を必要とします。");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.3.page.2.text", "The selected $(item)Item$() will be remembered for automation puposes, it will stay selected until its unselected.");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.3.page.2.text", "選択された$(item)アイテム$()は、自動化のために記憶され、非選択になるまで選択されたままとなります。");
                }
                {
                    registrate.addRawLang("patchouli.category.2.introduction.entry.4.title", "Energy");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.4.title", "エネルギー");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.4.page.1.title", "Energy");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.4.page.1.title", "エネルギー");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.4.page.1.text", "This mod adds no way of producing $(item)Energy$(), so you will need some sort of $(item)Generator$() from another mod to power the $(item)Machines$().");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.4.page.1.text", "このMODでは、$(item)エネルギー$()を生成する方法は追加されていないので、$(item)機械$()を動かすには、他のMODから$(item)発電機$()が必要になります。");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.4.page.2.title", "Power Units");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.4.page.2.title", "電源装置");
                    registrate.addRawLang("patchouli.category.2.introduction.entry.4.page.2.text", "Both $(item)Forge Energy (FE)$() and $(item)Redstone Flux (RF)$() will work.$(br2)Below are some example mods that could work to power your $(item)Machines$().$(br2)$(l:https://www.curseforge.com/minecraft/mc-mods/simple-generators)Simple Generators$() (Misc)$(br)$(l:https://www.curseforge.com/minecraft/mc-mods/mekanism-generators)Mekanism Generators$() (Reactors)$(br)$(l:https://minecraft.curseforge.com/projects/advanced-generators)Advanced Generators$()");
                    registrate.addRawJPLang("patchouli.category.2.introduction.entry.4.page.2.text", "$(item)FE$()と$(item)RF$()の両方が動作します。$(br2)以下は、$(item)機械$()を動かすために動作することができるいくつかのMOD例です。$(br2)$(l:https://www.curseforge.com/minecraft/mc-mods/simple-generators)Simple Generators$() (Misc)$(br)$(l:https://www.curseforge.com/minecraft/mc-mods/mekanism-generators)Mekanism Generators$() (Reactors)$(br)$(l:https://minecraft.curseforge.com/projects/advanced-generators)Advanced Generators$()");
                }
            }
        }
    }

    @Override
    protected void registerPatchouli(Consumer<RegistratePatchouliProvider.Result> consumer) {
        this.book("book")
                .book().properties(
                        p -> p.setName("Deep Mob Learning")
                                .setLandingText("patchouli.book.landing_text")
                                .setBookTexture(DeepMobLearningReloaded.getResource("textures/gui/patchouli/book_gray.png"))
                                .setCrafterTexture(DeepMobLearningReloaded.getResource("textures/gui/patchouli/crafting.png"))
                                .setModel(DeepMobLearningReloaded.getResource("book"))
                                .setTextColor(0xDDDDDD)
                                .setHeaderColor(0x16EFF7)
                                .setNameplateColor(0x16EFF7)
                                .setLinkColor(0x16EFF7)
                                .setLinkHoverColor(0x00FFC0)
                                .setShowProgress(false)
                                .setSubtitle("patchouli.book.sub_title")
                                .setCreativeTab(ItemGroupInit.DEEP_MOB_LEARNING_RELOADED)
                                .addMacros("$(primary)", "$(#16EFF7)")
                                .addMacros("$(item)", "$(#ff8c00)")
                                .addMacros("$(dml)", "$(l:https://minecraft.curseforge.com/projects/deep-mob-learning)Deep Mob Learning$()")
                                .addMacros("$(dmlbm)", "$(l:https://minecraft.curseforge.com/projects/deep-mob-learning-blood-magic-addon)Deep Mob Learning - BM Addon$()")
                                .setI18n(true)
                ).shapelessRecipe().properties(
                        p -> p.requires(Items.BOOK)
                                .requires(ItemInit.SOOT_COVERED_REDSTONE.get())
                ).build().build()
                .categories()
                .addCategory(
                        "Introduction",
                        "patchouli.category.1.introduction.title",
                        "patchouli.category.1.introduction.text",
                        ItemInit.DEEP_LEARNER
                )
                .entries()
                .addEntry("Introduction", "patchouli.category.1.introduction.entry.1.title", ItemInit.SOOT_COVERED_REDSTONE).properties(p -> {
                    p.addTextPage("patchouli.category.1.introduction.entry.1.page.1.text")
                            .build();
                    p.addSpotlightPage(ItemInit.SOOT_COVERED_REDSTONE)
                            .setTitle("item.dmlreloaded.soot_covered_redstone")
                            .setAnchor("sooted_redstone")
                            .setText("patchouli.category.1.introduction.entry.1.page.2.text")
                            .build();
                    p.addCraftingRecipePage(ItemInit.SOOT_COVERED_PLATE)
                            .setRecipe2(BlockInit.MACHINE_CASING)
                            .build();
                    return p;
                }).build()
                .addEntry("Data", "patchouli.category.1.introduction.entry.2.title", ItemInit.DEEP_LEARNER).properties(p -> {
                    p.addTextPage("patchouli.category.1.introduction.entry.2.page.1.text")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DEEP_LEARNER)
                            .setText("patchouli.category.1.introduction.entry.2.page.2.text")
                            .build();
                    p.addSpotlightPage(ItemInit.DEEP_LEARNER)
                            .setText("patchouli.category.1.introduction.entry.2.page.3.text")
                            .build();
                    return p;
                }).build()
                .addEntry("Data Models", "patchouli.category.1.introduction.entry.3.title", ItemInit.DataModel.GUARDIAN).properties(p -> {
                    p.addCraftingRecipePage(ItemInit.DataModel.BLANK)
                            .setText("patchouli.category.1.introduction.entry.3.page.1.text")
                            .build();
                    p.addSpotlightPage(ItemInit.DataModel.GUARDIAN)
                            .setAnchor("data_models")
                            .setText("patchouli.category.1.introduction.entry.3.page.2.text")
                            .build();
                    p.addTextPage("patchouli.category.1.introduction.entry.3.page.3.text")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.ZOMBIE)
                            .setRecipe2(ItemInit.DataModel.SKELETON)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.4.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.CREEPER)
                            .setRecipe2(ItemInit.DataModel.SPIDER)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.5.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.SLIME)
                            .setRecipe2(ItemInit.DataModel.WITCH)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.6.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.BLAZE)
                            .setRecipe2(ItemInit.DataModel.GHAST)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.7.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.WITHER_SKELETON)
                            .setRecipe2(ItemInit.DataModel.ENDERMAN)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.8.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.WITHER)
                            .setRecipe2(ItemInit.DataModel.ENDER_DRAGON)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.9.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.SHULKER)
                            .setRecipe2(ItemInit.DataModel.GUARDIAN)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.10.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.ELDER_GUARDIAN)
                            .setRecipe2(ItemInit.DataModel.EVOKER)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.11.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.HOGLIN)
                            .setRecipe2(ItemInit.DataModel.MAGMA_CUBE)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.12.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.PHANTOM)
                            .setRecipe2(ItemInit.DataModel.PIGLIN)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.13.title")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.RAVAGER)
//                            .setFlag("!mod:twilightforest")
                            .setTitle("patchouli.category.1.introduction.entry.3.page.14.title")
                            .build();
//                    p.addCraftingRecipePage(ItemInit.DataModel.RAVAGER)
//                            .setRecipe2(TwilightItemInit.DataModel.NAGA)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.1.introduction.entry.3.page.15.title")
//                            .build();
//                    p.addCraftingRecipePage(TwilightItemInit.DataModel.LICH)
//                            .setRecipe2(TwilightItemInit.DataModel.MINOSHROOM)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.1.introduction.entry.3.page.16.title")
//                            .build();
//                    p.addCraftingRecipePage(TwilightItemInit.DataModel.HYDRA)
//                            .setRecipe2(TwilightItemInit.DataModel.KNIGHT_PHANTOM)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.1.introduction.entry.3.page.17.title")
//                            .build();
//                    p.addCraftingRecipePage(TwilightItemInit.DataModel.UR_GHAST)
//                            .setRecipe2(TwilightItemInit.DataModel.ALPHA_YETI)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.1.introduction.entry.3.page.18.title")
//                            .build();
//                    p.addCraftingRecipePage(TwilightItemInit.DataModel.SNOW_QUEEN)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.1.introduction.entry.3.page.19.title")
//                            .build();
                    return p;
                }).build()
                .build()
                .build()
                .addCategory(
                        "Machines",
                        "patchouli.category.2.introduction.title",
                        "patchouli.category.2.introduction.text",
                        BlockInit.SIMULATION_CHAMBER
                )
                .entries()
                .addEntry("Simulation Chamber", "patchouli.category.2.introduction.entry.1.title", BlockInit.SIMULATION_CHAMBER).properties(p -> {
                    p.addTextPage("patchouli.category.2.introduction.entry.1.page.1.text")
                            .build();
                    p.addCraftingRecipePage(BlockInit.SIMULATION_CHAMBER)
                            .setAnchor("simulation_chamber")
                            .setText("patchouli.category.2.introduction.entry.1.page.2.text")
                            .build();
                    p.addCraftingRecipePage(ItemInit.POLYMER_CLAY)
                            .setAnchor("simulation_chamber")
                            .setText("patchouli.category.2.introduction.entry.1.page.3.text")
                            .build();
                return p;
                }).build()
                .addEntry("Matter", "patchouli.category.2.introduction.entry.2.title", ItemInit.LivingMatter.HELLISH).properties(p -> {
                    p.addTextPage("patchouli.category.2.introduction.entry.2.page.1.text")
                            .build();
                    p.addSpotlightPage(ItemInit.LivingMatter.HELLISH)
                            .setTitle("patchouli.category.2.introduction.entry.2.page.2.title")
                            .setAnchor("living")
                            .setText("patchouli.category.2.introduction.entry.2.page.2.text")
                            .build();
                    p.addCraftingRecipePage(DeepMobLearningReloaded.getResource("soul_sand_from_hellish_living_matter"))
                            .setTitle("patchouli.category.2.introduction.entry.2.page.3.title")
                            .setRecipe2(DeepMobLearningReloaded.getResource("ender_pearl_from_extraterrestrial_living_matter"))
                            .setAnchor("living_transmute")
                            .build();
                    p.addSpotlightPage(ItemInit.PristineMatter.ZOMBIE)
                            .setTitle("patchouli.category.2.introduction.entry.2.page.4.title")
                            .setAnchor("pristine")
                            .setText("patchouli.category.2.introduction.entry.2.page.4.text")
                            .build();
                    return p;
                }).build()
                .addEntry("Loot Fabricator", "patchouli.category.2.introduction.entry.3.title", BlockInit.EXTRACTION_CHAMBER).properties(p -> {
                    p.addTextPage("patchouli.category.2.introduction.entry.3.page.1.text")
                            .build();
                    p.addCraftingRecipePage(BlockInit.EXTRACTION_CHAMBER)
                            .setText("patchouli.category.2.introduction.entry.3.page.2.text")
                            .build();
                    return p;
                }).build()
                .addEntry("Energy", "patchouli.category.2.introduction.entry.4.title", "minecraft:redstone").properties(p -> {
                    p.addSpotlightPage("minecraft:redstone")
                            .setTitle("patchouli.category.2.introduction.entry.4.page.1.title")
                            .setText("patchouli.category.2.introduction.entry.4.page.1.text")
                            .build();
                    p.addTextPage("patchouli.category.2.introduction.entry.4.page.2.text")
                            .setTitle("patchouli.category.2.introduction.entry.4.page.2.title")
                            .build();
                    return p;
                }).build()
                .build()
                .build()
                .build()
                .getTemplates()
                .addTemplate("fluid_infusion").properties(p -> {
                    p.addHeaderComponent("#title").setX(-1).setY(-1).build();
                    p.addSeparatorComponent().setX(-1).setY(-1).build();
                    p.addItemComponent("#input1").setFramed(true).setX(27).setY(30).build();
                    p.addItemComponent("#input2").setFramed(true).setX(50).setY(30).build();
                    p.addItemComponent("#input3").setFramed(true).setX(73).setY(30).build();
                    p.addImageComponent("dmlreloaded:textures/gui/patchouli/arrow_down.png", 16, 16).setX(50).setY(50).setTextureWidth(16).setTextureHeight(16).build();
                    p.addImageComponent("#fluid", 16, 16).setX(50).setY(65).setTextureWidth(16).setTextureHeight(16).build();
                    p.addTooltipComponent().addTooltip("#fluidTooltip").setX(49).setY(64).setHeight(16).setWidth(16).build();
                    p.addImageComponent("dmlreloaded:textures/gui/patchouli/arrow_down.png", 16, 16).setX(50).setY(84).setTextureWidth(16).setTextureHeight(16).build();
                    p.addItemComponent("#output").setX(50).setY(102).setFramed(true).setLinkRecipe(true).build();
                    return p;
                }).build()
                .build()
                .save(consumer);
    }
}
