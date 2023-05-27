package jp.artan.dmlreloaded.init;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.LivingMatterType;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.item.*;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ItemInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static final ItemEntry<ItemDeepLearner> DEEP_LEARNER = REGISTRATE.item("deep_learner", ItemDeepLearner::new)
            .lang("Deep Learner")
            .jpLang("深層学習装置")
            .register();

    public static final ItemEntry<ItemGlitchFragment> GLITCH_FRAGMENT = REGISTRATE.item("glitch_fragment", ItemGlitchFragment::new)
            .lang("Unstable Glitch Fragment")
            .jpLang("不安定なグリッチの断片")
            .register();

    public static final ItemEntry<ItemGlitchHeart> GLITCH_HEART = REGISTRATE.item("glitch_heart", ItemGlitchHeart::new)
            .lang("Corrupted Glitch Heart")
            .jpLang("破損したグリッチの心臓")
            .register();

    public static final ItemEntry<ItemGlitchIngot> GLITCH_INGOT = REGISTRATE.item("glitch_infused_ingot", ItemGlitchIngot::new)
            .lang("Glitch Infused Ingot")
            .jpLang("グリッチを注入したインゴット")
            .register();

    public static class DataModel {
        public static final ItemEntry<Item> BLANK = REGISTRATE.item("data_model_blank", Item::new)
                .lang("Blank Data Model")
                .jpLang("空のデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> BLAZE = REGISTRATE.item("data_model_blaze", p -> new ItemDataModel(p, MobKey.BLAZE))
                .properties(p -> p.stacksTo(1))
                .lang("Blaze Data Model")
                .jpLang("ブレイズのデータモデル")
                .register();

        public static void register() {
            REGISTRATE.addRawLang("dmlreloaded.holdshift", "- hold %1$s for more info");
            REGISTRATE.addRawLang("dmlreloaded.data_model.tier", "Tier: %1$s");
            REGISTRATE.addRawLang("dmlreloaded.data_model.data.collected", "Data collected: %1$s/%2$s");
            REGISTRATE.addRawLang("dmlreloaded.data_model.data.killmultiplier", "Data per kill: %1$s");
            REGISTRATE.addRawLang("dmlreloaded.data_model.rfcost", "Simulation cost: %1$s RF/t");
            REGISTRATE.addRawLang("dmlreloaded.data_model.type_text", "Type: %1$s");
            REGISTRATE.addRawLang("dmlreloaded.tiers.tier_1", "Faulty");
            REGISTRATE.addRawLang("dmlreloaded.tiers.tier_2", "Basic");
            REGISTRATE.addRawLang("dmlreloaded.tiers.tier_3", "Advanced");
            REGISTRATE.addRawLang("dmlreloaded.tiers.tier_4", "Superior");
            REGISTRATE.addRawLang("dmlreloaded.tiers.tier_5", "Self Aware");
            REGISTRATE.addRawLang("dmlreloaded.tiers.increase_tier", "%1$s reached the %2$s tier");

            REGISTRATE.addRawJPLang("dmlreloaded.holdshift", "- %1$s長押しで情報を表示");
            REGISTRATE.addRawJPLang("dmlreloaded.data_model.tier", "等級: %1$s");
            REGISTRATE.addRawJPLang("dmlreloaded.data_model.data.collected", "データ収集: %1$s/%2$s");
            REGISTRATE.addRawJPLang("dmlreloaded.data_model.data.killmultiplier", "キル数ごとの学習量: %1$s");
            REGISTRATE.addRawJPLang("dmlreloaded.data_model.rfcost", "シミュレーションコスト: %1$s RF/t");
            REGISTRATE.addRawJPLang("dmlreloaded.data_model.type_text", "タイプ: %1$s");
            REGISTRATE.addRawJPLang("dmlreloaded.tiers.tier_1", "不完全");
            REGISTRATE.addRawJPLang("dmlreloaded.tiers.tier_2", "基本");
            REGISTRATE.addRawJPLang("dmlreloaded.tiers.tier_3", "上級");
            REGISTRATE.addRawJPLang("dmlreloaded.tiers.tier_4", "至上");
            REGISTRATE.addRawJPLang("dmlreloaded.tiers.tier_5", "自己認識");
            REGISTRATE.addRawJPLang("dmlreloaded.tiers.increase_tier", "%1$sが%2$sの階級にアップデート");
        }
    }

    public static class PristineMatter {
        public static final ItemEntry<ItemPristineMatter> BLAZE = REGISTRATE.item("pristine_matter_blaze", p -> new ItemPristineMatter(p, MobKey.BLAZE))
                .lang("Pristine Blaze Matter")
                .jpLang("綺麗なブレイズマター")
                .register();

        public static void register() {
        }
    }

    public static class LivingMatter {
        public static final ItemEntry<ItemLivingMatter> OVERWORLDIAN = REGISTRATE.item("living_matter_overworldian", p -> new ItemLivingMatter(p, LivingMatterType.OVERWORLDIAN))
                .lang("Overworldian Matter")
                .jpLang("Overworldianマター")
                .register();

        public static final ItemEntry<ItemLivingMatter> HELLISH = REGISTRATE.item("living_matter_hellish", p -> new ItemLivingMatter(p, LivingMatterType.HELLISH))
                .lang("Hellish Matter")
                .jpLang("Hellishマター")
                .register();

        public static final ItemEntry<ItemLivingMatter> EXTRATERRESTRIAL = REGISTRATE.item("living_matter_extraterrestrial", p -> new ItemLivingMatter(p, LivingMatterType.EXTRATERRESTRIAL))
                .lang("Extraterrestrial Matter")
                .jpLang("Extraterrestrialマター")
                .register();

        public static void register() {
            REGISTRATE.addRawLang(LivingMatterType.HELLISH.getLangId(), "Hellish");
            REGISTRATE.addRawLang(LivingMatterType.EXTRATERRESTRIAL.getLangId(), "Extraterrestrial");
            REGISTRATE.addRawLang(LivingMatterType.OVERWORLDIAN.getLangId(), "Overworldian");
            REGISTRATE.addRawLang("dmlreloaded.living_matter.exp_consume", "Can be consumed for expirience %1$s");
            REGISTRATE.addRawLang("dmlreloaded.living_matter.exp_consume_stack", "Hold %1$s to consume entire stack.");
            REGISTRATE.addRawLang("dmlreloaded.living_matter.exp", "Experience per item: %1$s");

            REGISTRATE.addRawJPLang(LivingMatterType.HELLISH.getLangId(), "Hellish");
            REGISTRATE.addRawJPLang(LivingMatterType.EXTRATERRESTRIAL.getLangId(), "Extraterrestrial");
            REGISTRATE.addRawJPLang(LivingMatterType.OVERWORLDIAN.getLangId(), "Overworldian");
            REGISTRATE.addRawJPLang("dmlreloaded.living_matter.exp_consume", "%1$sで消費することができます");
            REGISTRATE.addRawJPLang("dmlreloaded.living_matter.exp_consume_stack", "%1$sを押しながら使用するとスタック全体が消費されます.");
            REGISTRATE.addRawJPLang("dmlreloaded.living_matter.exp", "アイテムごとの経験値: %1$s");
        }
    }

    public static void register() {
        DataModel.register();
        PristineMatter.register();
        LivingMatter.register();
    }
}
