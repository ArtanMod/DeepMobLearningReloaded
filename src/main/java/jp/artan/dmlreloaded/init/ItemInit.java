package jp.artan.dmlreloaded.init;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.LivingMatterType;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.item.*;
import jp.artan.repack.registrate.providers.RegistrateRecipeProvider;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class ItemInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);



    public static final ItemEntry<ItemSootedRedstone> SOOT_COVERED_REDSTONE = REGISTRATE.item("soot_covered_redstone", ItemSootedRedstone::new)
            .lang("Soot Covered Redstone")
            .jpLang("煤で覆われたレッドストーン")
            .register();

    public static final ItemEntry<Item> SOOT_COVERED_PLATE = REGISTRATE.item("soot_covered_plate", Item::new)
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get(), 8)
                        .define('X', Items.OBSIDIAN)
                        .define('Y', SOOT_COVERED_REDSTONE.get())
                        .pattern("XX")
                        .pattern("XY")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(SOOT_COVERED_REDSTONE.get()))
                        .save(prov);
            })
            .lang("Soot Covered Plate")
            .jpLang("煤で覆われたプレート")
            .register();

    public static final ItemEntry<ItemDeepLearner> DEEP_LEARNER = REGISTRATE.item("deep_learner", ItemDeepLearner::new)
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get())
                        .define('#', SOOT_COVERED_PLATE.get())
                        .define('X', Items.REPEATER)
                        .define('Y', Blocks.GLASS_PANE)
                        .define('Z', SOOT_COVERED_REDSTONE.get())
                        .pattern("#X#")
                        .pattern("XYX")
                        .pattern("#Z#")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(SOOT_COVERED_PLATE.get()))
                        .save(prov);
            })
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
            .recipe((ctx, prov) -> {
                ShapelessRecipeBuilder.shapeless(ctx.get(), 9).requires(BlockInit.INFUSED_INGOT_BLOCK.get())
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(ItemInit.GLITCH_INGOT.get()))
                        .save(prov);
            })
            .lang("Glitch Infused Ingot")
            .jpLang("グリッチが染み込んだインゴット")
            .register();

    public static final ItemEntry<Item> POLYMER_CLAY = REGISTRATE.item("polymer_clay", Item::new)
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get(), 16)
                        .define('#', Items.CLAY_BALL)
                        .define('X', Items.IRON_INGOT)
                        .define('Y', Items.GOLD_INGOT)
                        .define('Z', Items.LAPIS_LAZULI)
                        .pattern("Y# ")
                        .pattern("#Z#")
                        .pattern(" #X")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(Items.CLAY_BALL))
                        .save(prov);
            })
            .lang("Polymer Clay")
            .jpLang("ポリマー粘土")
            .register();

    public static final ItemEntry<ItemGlitchSword> GLITCH_SWORD = REGISTRATE.item("glitch_infused_sword", ItemGlitchSword::new)
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get())
                        .define('#', GLITCH_INGOT.get())
                        .define('X', Items.IRON_NUGGET)
                        .define('Y', Items.STICK)
                        .pattern("  #")
                        .pattern("X# ")
                        .pattern("YX ")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(GLITCH_INGOT.get()))
                        .save(prov);
            })
            .lang("Glitch Infused Sword")
            .jpLang("グリッチが染み込んだ剣")
            .register();

    public static final ItemEntry<ItemGlitchArmor> GLITCH_HELMET = REGISTRATE.item("glitch_infused_helmet", p -> new ItemGlitchArmor(EquipmentSlot.HEAD, p))
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get())
                        .define('#', GLITCH_INGOT.get())
                        .pattern("###")
                        .pattern("# #")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(GLITCH_INGOT.get()))
                        .save(prov);
            })
            .lang("Glitch Infused Helmet")
            .jpLang("グリッチが染み込んだヘルメット")
            .register();

    public static final ItemEntry<ItemGlitchArmor> GLITCH_CHEST = REGISTRATE.item("glitch_infused_chestplate", p -> new ItemGlitchArmor(EquipmentSlot.CHEST, p))
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get())
                        .define('#', GLITCH_INGOT.get())
                        .pattern("# #")
                        .pattern("###")
                        .pattern("###")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(GLITCH_INGOT.get()))
                        .save(prov);
            })
            .lang("Glitch Infused Chestplate")
            .jpLang("グリッチが染み込んだチェストプレート")
            .register();

    public static final ItemEntry<ItemGlitchArmor> GLITCH_LEGGINGS = REGISTRATE.item("glitch_infused_leggings", p -> new ItemGlitchArmor(EquipmentSlot.LEGS, p))
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get())
                        .define('#', GLITCH_INGOT.get())
                        .pattern("###")
                        .pattern("# #")
                        .pattern("# #")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(GLITCH_INGOT.get()))
                        .save(prov);
            })
            .lang("Glitch Infused Leggings")
            .jpLang("グリッチが染み込んだレギンス")
            .register();

    public static final ItemEntry<ItemGlitchArmor> GLITCH_BOOTS = REGISTRATE.item("glitch_infused_boots", p -> new ItemGlitchArmor(EquipmentSlot.FEET, p))
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.get())
                        .define('#', GLITCH_INGOT.get())
                        .pattern("# #")
                        .pattern("# #")
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(GLITCH_INGOT.get()))
                        .save(prov);
            })
            .lang("Glitch Infused Boots")
            .jpLang("グリッチが染み込んだブーツ")
            .register();

    public static void register() {
        DataModel.register();
        PristineMatter.register();
        LivingMatter.register();

        // GLITCH_INGOT
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitchingot_1", "Made by stabilizing %1$s");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.more_info", "more info found in JEI or the Guidebook");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitchingot_1", "%1$sを安定化させることで作成できます");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.more_info", "詳細はJEIかガイドブックを参照してください");

        // GLITCH_SWORD
        REGISTRATE.addRawLang("dmlreloaded.messages.sword_levelup.max", "Your %1$s has now reached peak performance!");
        REGISTRATE.addRawLang("dmlreloaded.messages.sword_levelup", "Your %1$s grows in power!");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_sword_1", "Bonus: Quick learner");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_sword_2", "(Bonuses are disabled during Trials)");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_sword_3", "The Data gained from the demise of a mob is doubled,");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_sword_4", "when Data is gained there is also a small chance");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_sword_5", "that the sword will get a permanent damage increase.");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_sword_6", "Current damage increase: %1$s (Max %2$s)");
        REGISTRATE.addRawJPLang("dmlreloaded.messages.sword_levelup.max", "%1$sは最大の性能に達しました");
        REGISTRATE.addRawJPLang("dmlreloaded.messages.sword_levelup", "%1$sは力を増しています");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_1", "ボーナス: クイックラーニング");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_2", "(ボーナスは試練中は無効です)");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_3", "モブを倒した時に得られるデータが2倍になります");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_4", "データが得られたとき、ごくわずかな確率で");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_5", "剣の耐久値が増加します.");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_6", "現在の耐久値増加: %1$s (最大 %2$s)");

        // GLITCH_HELMET GLITCH_CHEST GLITCH_LEGGINGS GLITCH_BOOTS
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_armor_1", "Bonus while full set is equipped");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_armor_2", "(Bonuses are disabled during Trials)");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_armor_3", "  1.  %1$s%% chance to drop %2$s Pristine Matter");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_armor_4", "     when a Data Model gains Data.");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_armor_5", "  2. Flight & Immunity against fall damage");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_armor_1", "ボーナス: フルセット装備時");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_armor_2", "(ボーナスは試練中は無効です)");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_armor_3", "  1.  データモデルがデータを獲得したときに");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_armor_4", "     %1$s%%の確率で%2$sの綺麗なマターをドロップします");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_armor_5", "  2. 飛行と落下ダメージ無効");

        // ItemSootedRedstone
        REGISTRATE.addRawLang("dmlreloaded.hover_text.soot_covered_redstone_1", "Crafted by crushing %1$s against");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.soot_covered_redstone_2", "a %1$s (Left click)");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.soot_covered_redstone_1", "%1$sを押し潰して作成します");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.soot_covered_redstone_2", "%1$s(左クリック)");
    }

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

        public static final ItemEntry<ItemDataModel> ZOMBIE = REGISTRATE.item("data_model_zombie", p -> new ItemDataModel(p, MobKey.ZOMBIE))
                .properties(p -> p.stacksTo(1))
                .lang("Zombie Data Model")
                .jpLang("ゾンビのデータモデル")
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
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.BLAZE, 0), "Bring buckets, and watch in despair")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.BLAZE, 1), "as it evaporates, and everything is on fire")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.BLAZE, 2), "You are on fire")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.BLAZE, 0), "バケツを持って来て、絶望して見ている")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.BLAZE, 1), "それが蒸発し、すべてが燃え上がるのを絶望的に眺める")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.BLAZE, 2), "君は燃えている")
                .register();
        public static final ItemEntry<ItemPristineMatter> ZOMBIE = REGISTRATE.item("pristine_matter_zombie", p -> new ItemPristineMatter(p, MobKey.ZOMBIE))
                .lang("Pristine Zombie Matter")
                .jpLang("綺麗なゾンビマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ZOMBIE, 0), "They go moan in the night.")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ZOMBIE, 1), "Does not understand the need for")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ZOMBIE, 2), "personal space")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ZOMBIE, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ZOMBIE, 1), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ZOMBIE, 2), "")
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
}
