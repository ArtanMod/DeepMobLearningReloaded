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
            .addRawLang("dmlreloaded.hover_text.soot_covered_redstone_1", "Crafted by crushing %1$s against")
            .addRawLang("dmlreloaded.hover_text.soot_covered_redstone_2", "a %1$s (Left click)")
            .addRawJPLang("dmlreloaded.hover_text.soot_covered_redstone_1", "%1$sを押し潰して作成します")
            .addRawJPLang("dmlreloaded.hover_text.soot_covered_redstone_2", "%1$s(左クリック)")
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
            .addRawLang("dmlreloaded.hover_text.glitch_fragment_1", "Crafted by crushing a %1$s")
            .addRawJPLang("dmlreloaded.hover_text.glitch_fragment_1", "%1$sを粉砕して作る")
            .addRawLang("dmlreloaded.hover_text.glitch_fragment_2", "against some %1$s (Right click)")
            .addRawJPLang("dmlreloaded.hover_text.glitch_fragment_2", "%1$sに対して(右クリック)")
            .addRawLang("dmlreloaded.hover_text.glitch_fragment_3", "Yields 3 fragments per crushed heart")
            .addRawJPLang("dmlreloaded.hover_text.glitch_fragment_3", "砕いた心臓1個につき3個の破片を得ることができます")
            .addRawLang("dmlreloaded.hover_text.glitch_fragment_4", "Can rarly drop from hostile mobs.")
            .addRawJPLang("dmlreloaded.hover_text.glitch_fragment_4", "敵対するモブからまれにドロップすることがあります")
            .register();

    public static final ItemEntry<ItemGlitchHeart> GLITCH_HEART = REGISTRATE.item("glitch_heart", ItemGlitchHeart::new)
            .lang("Corrupted Glitch Heart")
            .jpLang("破損したグリッチの心臓")
            .addRawLang("dmlreloaded.hover_text.glitch_heart", "Drops from System Glitches")
            .addRawJPLang("dmlreloaded.hover_text.glitch_heart", "グリッチシステムからドロップ")
            .register();

    public static final ItemEntry<ItemGlitchIngot> GLITCH_INGOT = REGISTRATE.item("glitch_infused_ingot", ItemGlitchIngot::new)
            .recipe((ctx, prov) -> {
                ShapelessRecipeBuilder.shapeless(ctx.get(), 9).requires(BlockInit.INFUSED_INGOT_BLOCK.get())
                        .unlockedBy("has_item", RegistrateRecipeProvider.has(ItemInit.GLITCH_INGOT.get()))
                        .save(prov);
            })
            .lang("Glitch Infused Ingot")
            .jpLang("グリッチが染み込んだインゴット")
            .addRawLang("dmlreloaded.hover_text.glitchingot_1", "Made by stabilizing %1$s")
            .addRawLang("dmlreloaded.hover_text.more_info", "more info found in JEI or the Guidebook")
            .addRawJPLang("dmlreloaded.hover_text.glitchingot_1", "%1$sを安定化させることで作成できます")
            .addRawJPLang("dmlreloaded.hover_text.more_info", "詳細はJEIかガイドブックを参照してください")
            .addRawLang("jei.dmlreloaded.glitch_ingot", "TLDR: Drop some fragments, lapis and gold ingots into a body of water and hope for the best\\n\\nYou've found that lapis is a good stabilization agent for Unstable glitch fragments.\\nAfter the fragments are stable, they desperately seek out a material to latch on to, you think that gold might be strong enough as a host.\\n\\nThe entire process is delicate, it needs to be performed in water or the materials wont bind properly.")
            .addRawJPLang("jei.dmlreloaded.glitch_ingot", "TLDR: 不安定なグリッチの断片・ラピスラズリ・金インゴットを水に落とす。\\n\\nラピスラズリは不安定なグリッチの断片を安定させるのに適していることがわかりました。\\n不安定なグリッチの断片が安定した後、結合する素材を求めて必死探してます。\\n\\nこのプロセス全体は繊細で、水中で行わないと材料が適切に結合しない。")
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
            .addRawLang("dmlreloaded.messages.sword_levelup.max", "Your %1$s has now reached peak performance!")
            .addRawLang("dmlreloaded.messages.sword_levelup", "Your %1$s grows in power!")
            .addRawLang("dmlreloaded.hover_text.glitch_infused_sword_1", "Bonus: Quick learner")
            .addRawLang("dmlreloaded.hover_text.glitch_infused_sword_2", "(Bonuses are disabled during Trials)")
            .addRawLang("dmlreloaded.hover_text.glitch_infused_sword_3", "The Data gained from the demise of a mob is doubled,")
            .addRawLang("dmlreloaded.hover_text.glitch_infused_sword_4", "when Data is gained there is also a small chance")
            .addRawLang("dmlreloaded.hover_text.glitch_infused_sword_5", "that the sword will get a permanent damage increase.")
            .addRawLang("dmlreloaded.hover_text.glitch_infused_sword_6", "Current damage increase: %1$s (Max %2$s)")
            .addRawJPLang("dmlreloaded.messages.sword_levelup.max", "%1$sは最大の性能に達しました")
            .addRawJPLang("dmlreloaded.messages.sword_levelup", "%1$sは力を増しています")
            .addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_1", "ボーナス: クイックラーニング")
            .addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_2", "(ボーナスは試練中は無効です)")
            .addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_3", "モブを倒した時に得られるデータが2倍になります")
            .addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_4", "データが得られたとき、ごくわずかな確率で")
            .addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_5", "剣の耐久値が増加します.")
            .addRawJPLang("dmlreloaded.hover_text.glitch_infused_sword_6", "現在の耐久値増加: %1$s (最大 %2$s)")
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

        // 共通翻訳情報: GLITCH_HELMET GLITCH_CHEST GLITCH_LEGGINGS GLITCH_BOOTS
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
    }

    public static class DataModel {
        public static final ItemEntry<Item> BLANK = REGISTRATE.item("data_model_blank", Item::new)
                .recipe((ctx, prov) -> {
                    ShapedRecipeBuilder.shaped(ctx.get())
                            .define('#', Items.LAPIS_LAZULI)
                            .define('A', Items.REPEATER)
                            .define('B', SOOT_COVERED_REDSTONE.get())
                            .define('C', Blocks.STONE)
                            .define('D', Items.GOLD_INGOT)
                            .pattern("#A#")
                            .pattern("BCB")
                            .pattern("#D#")
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(SOOT_COVERED_REDSTONE.get()))
                            .save(prov);
                })
                .lang("Blank Data Model")
                .jpLang("空のデータモデル")
                .addRawLang("dmlreloaded.holdshift", "- hold %1$s for more info")
                .addRawLang("dmlreloaded.holdctrl", "- hold %1$s for more info")
                .addRawLang("dmlreloaded.learning_target", "Learning Target Mobs")
                .addRawLang("dmlreloaded.data_model.tier", "Tier: %1$s")
                .addRawLang("dmlreloaded.data_model.data.collected", "Data collected: %1$s/%2$s")
                .addRawLang("dmlreloaded.data_model.data.killmultiplier", "Data per kill: %1$s")
                .addRawLang("dmlreloaded.data_model.rfcost", "Simulation cost: %1$s RF/t")
                .addRawLang("dmlreloaded.data_model.type_text", "Type: %1$s")
                .addRawLang("dmlreloaded.tiers.tier_1", "Faulty")
                .addRawLang("dmlreloaded.tiers.tier_2", "Basic")
                .addRawLang("dmlreloaded.tiers.tier_3", "Advanced")
                .addRawLang("dmlreloaded.tiers.tier_4", "Superior")
                .addRawLang("dmlreloaded.tiers.tier_5", "Self Aware")
                .addRawLang("dmlreloaded.tiers.increase_tier", "%1$s reached the %2$s tier")
                .addRawJPLang("dmlreloaded.holdshift", "- %1$s長押しで情報を表示")
                .addRawJPLang("dmlreloaded.holdctrl", "- %1$s長押しで対象モブ情報を表示")
                .addRawJPLang("dmlreloaded.learning_target", "学習対象のモブ")
                .addRawJPLang("dmlreloaded.data_model.tier", "等級: %1$s")
                .addRawJPLang("dmlreloaded.data_model.data.collected", "データ収集: %1$s/%2$s")
                .addRawJPLang("dmlreloaded.data_model.data.killmultiplier", "キル数ごとの学習量: %1$s")
                .addRawJPLang("dmlreloaded.data_model.rfcost", "シミュレーションコスト: %1$s RF/t")
                .addRawJPLang("dmlreloaded.data_model.type_text", "タイプ: %1$s")
                .addRawJPLang("dmlreloaded.tiers.tier_1", "不完全")
                .addRawJPLang("dmlreloaded.tiers.tier_2", "基本")
                .addRawJPLang("dmlreloaded.tiers.tier_3", "上級")
                .addRawJPLang("dmlreloaded.tiers.tier_4", "至上")
                .addRawJPLang("dmlreloaded.tiers.tier_5", "自己認識")
                .addRawJPLang("dmlreloaded.tiers.increase_tier", "%1$sが%2$sの階級にアップデート")
                .register();

        public static final ItemEntry<ItemDataModel> BLAZE = REGISTRATE.item("data_model_blaze", p -> new ItemDataModel(p, MobKey.BLAZE))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.BLAZE_POWDER)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Blaze Data Model")
                .jpLang("ブレイズのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> CREEPER = REGISTRATE.item("data_model_creeper", p -> new ItemDataModel(p, MobKey.CREEPER))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.GUNPOWDER)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Creeper Data Model")
                .jpLang("クリーパーのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> DRAGON = REGISTRATE.item("data_model_dragon", p -> new ItemDataModel(p, MobKey.DRAGON))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Blocks.DRAGON_EGG)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Dragon Data Model")
                .jpLang("ドラゴンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> ENDERMAN = REGISTRATE.item("data_model_enderman", p -> new ItemDataModel(p, MobKey.ENDERMAN))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.ENDER_PEARL)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Enderman Data Model")
                .jpLang("エンダーマンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> GHAST = REGISTRATE.item("data_model_ghast", p -> new ItemDataModel(p, MobKey.GHAST))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.GHAST_TEAR)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Ghast Data Model")
                .jpLang("ガストのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> GUARDIAN = REGISTRATE.item("data_model_guardian", p -> new ItemDataModel(p, MobKey.GUARDIAN))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.PRISMARINE_SHARD)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Guardian Data Model")
                .jpLang("ガーディアンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> SHULKER = REGISTRATE.item("data_model_shulker", p -> new ItemDataModel(p, MobKey.SHULKER))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.SHULKER_SHELL)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Shulker Data Model")
                .jpLang("シェルカーのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> SKELETON = REGISTRATE.item("data_model_skeleton", p -> new ItemDataModel(p, MobKey.SKELETON))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.BONE)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Skeleton Data Model")
                .jpLang("スケルトンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> SLIME = REGISTRATE.item("data_model_slime", p -> new ItemDataModel(p, MobKey.SLIME))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.SLIME_BALL)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Slime Data Model")
                .jpLang("スライムのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> SPIDER = REGISTRATE.item("data_model_spider", p -> new ItemDataModel(p, MobKey.SPIDER))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.SPIDER_EYE)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Spider Data Model")
                .jpLang("クモのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> WITCH = REGISTRATE.item("data_model_witch", p -> new ItemDataModel(p, MobKey.WITCH))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.GLASS_BOTTLE)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Witch Data Model")
                .jpLang("ウィッチのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> WITHER_SKELETON = REGISTRATE.item("data_model_wither_skeleton", p -> new ItemDataModel(p, MobKey.WITHER_SKELETON))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Blocks.WITHER_SKELETON_SKULL)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Wither Skeleton Data Model")
                .jpLang("ウィザースケルトンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> WITHER = REGISTRATE.item("data_model_wither", p -> new ItemDataModel(p, MobKey.WITHER))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.NETHER_STAR)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Wither Data Model")
                .jpLang("ウィザーのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> ZOMBIE = REGISTRATE.item("data_model_zombie", p -> new ItemDataModel(p, MobKey.ZOMBIE))
                .properties(p -> p.stacksTo(1))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.ROTTEN_FLESH)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Zombie Data Model")
                .jpLang("ゾンビのデータモデル")
                .register();

        public static void register() {

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

        public static final ItemEntry<ItemPristineMatter> CREEPER = REGISTRATE.item("pristine_matter_creeper", p -> new ItemPristineMatter(p, MobKey.CREEPER))
                .lang("Pristine Creeper Matter")
                .jpLang("綺麗なクリーパーマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.CREEPER, 0), "Will blow up your base if")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.CREEPER, 1), "left unattended.")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.CREEPER, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.CREEPER, 1), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> DRAGON = REGISTRATE.item("pristine_matter_dragon", p -> new ItemPristineMatter(p, MobKey.DRAGON))
                .lang("Pristine Dragon Matter")
                .jpLang("綺麗なドラゴンマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.DRAGON, 0), "Resides in the end, does not harbor treasure")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.DRAGON, 1), "Destroy its crystals, break the cycle.")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.DRAGON, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.DRAGON, 1), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> ENDERMAN = REGISTRATE.item("pristine_matter_enderman", p -> new ItemPristineMatter(p, MobKey.ENDERMAN))
                .lang("Pristine Enderman Matter")
                .jpLang("綺麗なエンダーマンマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ENDERMAN, 0), "Friendly unless provoked, dislikes rain.")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ENDERMAN, 1), "Teleports short distances")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ENDERMAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ENDERMAN, 1), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> GHAST = REGISTRATE.item("pristine_matter_ghast", p -> new ItemPristineMatter(p, MobKey.GHAST))
                .lang("Pristine Ghast Matter")
                .jpLang("綺麗なガストマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.GHAST, 0), "If you hear something that sounds like")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.GHAST, 1), "a crying llama, you're probably hearing a ghast")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.GHAST, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.GHAST, 1), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> GUARDIAN = REGISTRATE.item("pristine_matter_guardian", p -> new ItemPristineMatter(p, MobKey.GUARDIAN))
                .lang("Pristine Guardian Matter")
                .jpLang("綺麗なガーディアンマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.GUARDIAN, 0), "Lurking in the oceans.")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.GUARDIAN, 1), "Uses some sort of sonar beam as")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.GUARDIAN, 2), "a means of attack")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.GUARDIAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.GUARDIAN, 1), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.GUARDIAN, 2), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> SHULKER = REGISTRATE.item("pristine_matter_shulker", p -> new ItemPristineMatter(p, MobKey.SHULKER))
                .lang("Pristine Shulker Matter")
                .jpLang("綺麗なシェルカーマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SHULKER, 0), "Found in End cities")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SHULKER, 1), "Sneaky little buggers")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SHULKER, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SHULKER, 1), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> SKELETON = REGISTRATE.item("pristine_matter_skeleton", p -> new ItemPristineMatter(p, MobKey.SKELETON))
                .lang("Pristine Skeleton Matter")
                .jpLang("綺麗なスケルトンマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SKELETON, 0), "A formidable archer, which seem to be running")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SKELETON, 1), "some sort of cheat engine")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SKELETON, 2), "A shield could prove useful")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SKELETON, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SKELETON, 1), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SKELETON, 2), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> SLIME = REGISTRATE.item("pristine_matter_slime", p -> new ItemPristineMatter(p, MobKey.SLIME))
                .lang("Pristine Slime Matter")
                .jpLang("綺麗なスライムマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SLIME, 0), "The bounce")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SLIME, 1), "bounce his bounce")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SLIME, 2), "squish - \"A slime haiku\"")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SLIME, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SLIME, 1), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SLIME, 2), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> SPIDER = REGISTRATE.item("pristine_matter_spider", p -> new ItemPristineMatter(p, MobKey.SPIDER))
                .lang("Pristine Spider Matter")
                .jpLang("綺麗なクモマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SPIDER, 0), "Nocturnal douchebags, beware")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.SPIDER, 1), "Drops strands of string for some reason..")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SPIDER, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.SPIDER, 1), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> WITCH = REGISTRATE.item("pristine_matter_witch", p -> new ItemPristineMatter(p, MobKey.WITCH))
                .lang("Pristine Witch Matter")
                .jpLang("綺麗なウィッチマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.WITCH, 0), "Affinity with potions and concoctions")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.WITCH, 1), "Beware!")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.WITCH, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.WITCH, 1), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> WITHER_SKELETON = REGISTRATE.item("pristine_matter_wither_skeleton", p -> new ItemPristineMatter(p, MobKey.WITHER_SKELETON))
                .lang("Pristine Wither Skeleton Matter")
                .jpLang("綺麗なウィザースケルトンマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER_SKELETON, 0), "Inflicts the wither effect")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER_SKELETON, 1), "Bring milk")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER_SKELETON, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER_SKELETON, 1), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> WITHER = REGISTRATE.item("pristine_matter_wither", p -> new ItemPristineMatter(p, MobKey.WITHER))
                .lang("Pristine Wither Matter")
                .jpLang("綺麗なウィザーマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER, 0), "Do not approach this enemy. Run!")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER, 1), "I mean it has 3 heads, what could")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER, 2), "possibly go wrong?")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER, 1), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.WITHER, 2), "")
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
                .addRawLang(LivingMatterType.OVERWORLDIAN.getLangId(), "Overworldian")
                .addRawJPLang(LivingMatterType.OVERWORLDIAN.getLangId(), "Overworldian")
                .register();

        public static final ItemEntry<ItemLivingMatter> HELLISH = REGISTRATE.item("living_matter_hellish", p -> new ItemLivingMatter(p, LivingMatterType.HELLISH))
                .lang("Hellish Matter")
                .jpLang("Hellishマター")
                .addRawLang(LivingMatterType.HELLISH.getLangId(), "Hellish")
                .addRawJPLang(LivingMatterType.HELLISH.getLangId(), "Hellish")
                .register();

        public static final ItemEntry<ItemLivingMatter> EXTRATERRESTRIAL = REGISTRATE.item("living_matter_extraterrestrial", p -> new ItemLivingMatter(p, LivingMatterType.EXTRATERRESTRIAL))
                .lang("Extraterrestrial Matter")
                .jpLang("Extraterrestrialマター")
                .addRawLang(LivingMatterType.EXTRATERRESTRIAL.getLangId(), "Extraterrestrial")
                .addRawJPLang(LivingMatterType.EXTRATERRESTRIAL.getLangId(), "Extraterrestrial")
                .register();

        public static void register() {
            // 共通翻訳情報
            REGISTRATE.addRawLang("dmlreloaded.living_matter.exp_consume", "Can be consumed for expirience %1$s");
            REGISTRATE.addRawLang("dmlreloaded.living_matter.exp_consume_stack", "Hold %1$s to consume entire stack.");
            REGISTRATE.addRawLang("dmlreloaded.living_matter.exp", "Experience per item: %1$s");
            REGISTRATE.addRawJPLang("dmlreloaded.living_matter.exp_consume", "%1$sで消費することができます");
            REGISTRATE.addRawJPLang("dmlreloaded.living_matter.exp_consume_stack", "%1$sを押しながら使用するとスタック全体が消費されます.");
            REGISTRATE.addRawJPLang("dmlreloaded.living_matter.exp", "アイテムごとの経験値: %1$s");
        }
    }
}
