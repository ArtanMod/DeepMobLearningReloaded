package jp.artan.dmlreloaded.init;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.LivingMatterType;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ItemInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

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
        }
    }

    public static class PristineMatter {
        public static final ItemEntry<ItemPristineMatter> BLAZE = REGISTRATE.item("pristine_matter_blaze", p -> new ItemPristineMatter(p, MobKey.BLAZE))
                .lang("Pristine Blaze Matter")
                .register();

        public static void register() {
        }
    }

    public static class LivingMatter {
        public static final ItemEntry<ItemLivingMatter> OVERWORLDIAN = REGISTRATE.item("living_matter_overworldian", p -> new ItemLivingMatter(p, LivingMatterType.OVERWORLDIAN))
                .lang("Overworldian Matter")
                .register();

        public static final ItemEntry<ItemLivingMatter> HELLISH = REGISTRATE.item("living_matter_hellish", p -> new ItemLivingMatter(p, LivingMatterType.HELLISH))
                .lang("Hellish Matter")
                .register();

        public static final ItemEntry<ItemLivingMatter> EXTRATERRESTRIAL = REGISTRATE.item("living_matter_extraterrestrial", p -> new ItemLivingMatter(p, LivingMatterType.EXTRATERRESTRIAL))
                .lang("Extraterrestrial Matter")
                .register();

        public static void register() {
            REGISTRATE.addRawLang("dmlreloaded.living_matter.exp_consume", "Can be consumed for expirience %1$s");
            REGISTRATE.addRawLang("dmlreloaded.living_matter.exp_consume_stack", "Hold %1$s to consume entire stack.");
            REGISTRATE.addRawLang("dmlreloaded.living_matter.exp", "Experience per item: %1$s");
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
