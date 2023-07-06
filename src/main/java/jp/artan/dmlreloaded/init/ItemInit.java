package jp.artan.dmlreloaded.init;

import jp.artan.artansprojectcoremod.plugin.registrate.builder.ModItemBuilder;
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
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

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
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_armor_3", "  1.  Certain probability of drop Pristine Matter");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_armor_4", "     when a Data Model gains Data.");
        REGISTRATE.addRawLang("dmlreloaded.hover_text.glitch_infused_armor_5", "  2. Flight & Immunity against fall damage");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_armor_1", "ボーナス: フルセット装備時");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_armor_2", "(ボーナスは試練中は無効です)");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_armor_3", "  1.  データモデルがデータを獲得したときに");
        REGISTRATE.addRawJPLang("dmlreloaded.hover_text.glitch_infused_armor_4", "     一定の確率で綺麗なマターをドロップします");
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

        public static final ItemEntry<ItemDataModel> BLAZE = registerDataModel("data_model_blaze", MobKey.BLAZE, () -> Items.BLAZE_ROD)
                .lang("Blaze Data Model")
                .jpLang("ブレイズのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> CREEPER = registerDataModel("data_model_creeper", MobKey.CREEPER, () -> Items.GUNPOWDER)
                .lang("Creeper Data Model")
                .jpLang("クリーパーのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> DRAGON = registerDataModel("data_model_dragon", MobKey.DRAGON, () -> Items.DRAGON_EGG)
                .lang("Dragon Data Model")
                .jpLang("ドラゴンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> ELDER_GUARDIAN = registerDataModel("data_model_elder_guardian", MobKey.ELDER_GUARDIAN, () -> Items.SPONGE)
                .lang("Elder Guardian Data Model")
                .jpLang("エルダーガーディアンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> ENDERMAN = registerDataModel("data_model_enderman", MobKey.ENDERMAN, () -> Items.ENDER_PEARL)
                .lang("Enderman Data Model")
                .jpLang("エンダーマンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> EVOKER = registerDataModel("data_model_evoker", MobKey.EVOKER, () -> Items.TOTEM_OF_UNDYING)
                .lang("Evoker Data Model")
                .jpLang("エヴォーカーのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> GHAST = registerDataModel("data_model_ghast", MobKey.GHAST, () -> Items.GHAST_TEAR)
                .lang("Ghast Data Model")
                .jpLang("ガストのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> GUARDIAN = registerDataModel("data_model_guardian", MobKey.GUARDIAN, () -> Items.PRISMARINE_SHARD)
                .lang("Guardian Data Model")
                .jpLang("ガーディアンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> HOGLIN = registerDataModel("data_model_hoglin", MobKey.HOGLIN)
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(ctx.get())
                            .requires(BLANK.get())
                            .requires(Items.LEATHER)
                            .requires(Items.PORKCHOP)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                            .save(prov);
                })
                .lang("Hoglin Data Model")
                .jpLang("ホグリンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> MAGMA_CUBE = registerDataModel("data_model_magma_cube", MobKey.MAGMA_CUBE, () -> Items.MAGMA_CREAM)
                .lang("Magma Cube Data Model")
                .jpLang("マグマキューブのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> PHANTOM = registerDataModel("data_model_phantom", MobKey.PHANTOM, () -> Items.PHANTOM_MEMBRANE)
                .lang("Phantom Data Model")
                .jpLang("ファントムのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> PIGLIN = registerDataModel("data_model_piglin", MobKey.PIGLIN, () -> Items.GOLD_INGOT)
                .lang("Piglin Data Model")
                .jpLang("ピグリンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> RAVAGER = registerDataModel("data_model_ravager", MobKey.RAVAGER, () -> Items.SADDLE)
                .lang("Ravager Data Model")
                .jpLang("ラヴェジャーのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> SHULKER = registerDataModel("data_model_shulker", MobKey.SHULKER, () -> Items.SHULKER_SHELL)
                .lang("Shulker Data Model")
                .jpLang("シュルカーのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> SKELETON = registerDataModel("data_model_skeleton", MobKey.SKELETON, () -> Items.BONE)
                .lang("Skeleton Data Model")
                .jpLang("スケルトンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> SLIME = registerDataModel("data_model_slime", MobKey.SLIME, () -> Items.SLIME_BALL)
                .lang("Slime Data Model")
                .jpLang("スライムのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> SPIDER = registerDataModel("data_model_spider", MobKey.SPIDER, () -> Items.SPIDER_EYE)
                .lang("Spider Data Model")
                .jpLang("クモのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> WITCH = registerDataModel("data_model_witch", MobKey.WITCH, () -> Items.GLASS_BOTTLE)
                .lang("Witch Data Model")
                .jpLang("ウィッチのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> WITHER_SKELETON = registerDataModel("data_model_wither_skeleton", MobKey.WITHER_SKELETON, () -> Items.WITHER_SKELETON_SKULL)
                .lang("Wither Skeleton Data Model")
                .jpLang("ウィザースケルトンのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> WITHER = registerDataModel("data_model_wither", MobKey.WITHER, () -> Items.NETHER_STAR)
                .lang("Wither Data Model")
                .jpLang("ウィザーのデータモデル")
                .register();

        public static final ItemEntry<ItemDataModel> ZOMBIE = registerDataModel("data_model_zombie", MobKey.ZOMBIE, () -> Items.ROTTEN_FLESH)
                .lang("Zombie Data Model")
                .jpLang("ゾンビのデータモデル")
                .register();

        public static void register() {

        }

        private static ModItemBuilder<ItemDataModel, DeepMobLearningReloadedRegistrate> registerDataModel(String id, MobKey key) {
            return REGISTRATE.item(id, p -> new ItemDataModel(p, key));
        }
        
        private static ModItemBuilder<ItemDataModel, DeepMobLearningReloadedRegistrate> registerDataModel(String id, MobKey key, Supplier<? extends Item> material) {
            return registerDataModel(id, key)
                    .properties(p -> p.stacksTo(1))
                    .recipe((ctx, prov) -> {
                        ShapelessRecipeBuilder.shapeless(ctx.get())
                                .requires(BLANK.get())
                                .requires(material.get())
                                .unlockedBy("has_item", RegistrateRecipeProvider.has(BLANK.get()))
                                .save(prov);
                    });
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

        public static final ItemEntry<ItemPristineMatter> ELDER_GUARDIAN = REGISTRATE.item("pristine_matter_elder_guardian", p -> new ItemPristineMatter(p, MobKey.ELDER_GUARDIAN))
                .lang("Elder Guardian Dragon Matter")
                .jpLang("綺麗なエルダーガーディアンマター")
//                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> ENDERMAN = REGISTRATE.item("pristine_matter_enderman", p -> new ItemPristineMatter(p, MobKey.ENDERMAN))
                .lang("Pristine Enderman Matter")
                .jpLang("綺麗なエンダーマンマター")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ENDERMAN, 0), "Friendly unless provoked, dislikes rain.")
                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ENDERMAN, 1), "Teleports short distances")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ENDERMAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ENDERMAN, 1), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> EVOKER = REGISTRATE.item("pristine_matter_evoker", p -> new ItemPristineMatter(p, MobKey.EVOKER))
                .lang("Evoker Dragon Matter")
                .jpLang("綺麗なエヴォーカーマター")
//                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
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

        public static final ItemEntry<ItemPristineMatter> HOGLIN = REGISTRATE.item("pristine_matter_hoglin", p -> new ItemPristineMatter(p, MobKey.HOGLIN))
                .lang("Hoglin Dragon Matter")
                .jpLang("綺麗なホグリンマター")
//                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> MAGMA_CUBE = REGISTRATE.item("pristine_matter_magma_cube", p -> new ItemPristineMatter(p, MobKey.MAGMA_CUBE))
                .lang("Magma Cube Dragon Matter")
                .jpLang("綺麗なマグマキューブマター")
//                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> PHANTOM = REGISTRATE.item("pristine_matter_phantom", p -> new ItemPristineMatter(p, MobKey.PHANTOM))
                .lang("Phantom Dragon Matter")
                .jpLang("綺麗なファントムマター")
//                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> PIGLIN = REGISTRATE.item("pristine_matter_piglin", p -> new ItemPristineMatter(p, MobKey.PIGLIN))
                .lang("Piglin Dragon Matter")
                .jpLang("綺麗なピグリンマター")
//                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> RAVAGER = REGISTRATE.item("pristine_matter_ravager", p -> new ItemPristineMatter(p, MobKey.RAVAGER))
                .lang("Ravager Dragon Matter")
                .jpLang("綺麗なラヴェジャーマター")
//                .addRawLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(MobKey.ELDER_GUARDIAN, 0), "")
                .register();

        public static final ItemEntry<ItemPristineMatter> SHULKER = REGISTRATE.item("pristine_matter_shulker", p -> new ItemPristineMatter(p, MobKey.SHULKER))
                .lang("Pristine Shulker Matter")
                .jpLang("綺麗なシュルカーマター")
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

        public static final ItemEntry<ItemLivingMatter> EXTRATERRESTRIAL = REGISTRATE.item("living_matter_extraterrestrial", p -> new ItemLivingMatter(p, LivingMatterType.EXTRATERRESTRIAL))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(Items.CHORUS_FRUIT)
                            .requires(ctx.get())
                            .requires(Items.APPLE)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "chorus_flower_from_living_matter_extraterrestrial");
                    ShapelessRecipeBuilder.shapeless(Blocks.END_STONE, 8)
                            .requires(ctx.get())
                            .requires(Blocks.SANDSTONE, 2)
                            .requires(Items.ENDER_PEARL)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "ender_stone_from_living_matter_extraterrestrial");
                    ShapedRecipeBuilder.shaped(Items.NETHER_STAR)
                            .define('#', ctx.get())
                            .define('X', Blocks.WITHER_SKELETON_SKULL)
                            .define('Y', Blocks.SOUL_SAND)
                            .pattern("X#X")
                            .pattern("YYY")
                            .pattern(" Y ")
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "nether_star_from_living_matter_extraterrestrial");
                    ShapelessRecipeBuilder.shapeless(Items.ENDER_PEARL)
                            .requires(ctx.get())
                            .requires(Items.EMERALD)
                            .requires(Items.SNOWBALL)
                            .requires(Items.SLIME_BALL)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ItemInit.LivingMatter.EXTRATERRESTRIAL.get()))
                            .save(prov, DeepMobLearningReloaded.getResource("ender_pearl_from_extraterrestrial_living_matter"));
                })
                .lang("Extraterrestrial Matter")
                .jpLang("Extraterrestrialマター")
                .addRawLang(LivingMatterType.EXTRATERRESTRIAL.getLangId(), "Extraterrestrial")
                .addRawJPLang(LivingMatterType.EXTRATERRESTRIAL.getLangId(), "Extraterrestrial")
                .register();

        public static final ItemEntry<ItemLivingMatter> HELLISH = REGISTRATE.item("living_matter_hellish", p -> new ItemLivingMatter(p, LivingMatterType.HELLISH))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(Items.BLAZE_POWDER, 2)
                            .requires(ctx.get())
                            .requires(Items.GUNPOWDER)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "blaze_powder_from_living_matter_hellish");
                    ShapedRecipeBuilder.shaped(EXTRATERRESTRIAL.get())
                            .define('#', ctx.get())
                            .define('X', Blocks.END_STONE)
                            .pattern(" # ")
                            .pattern("#X#")
                            .pattern(" # ")
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "living_matter_extraterrestrial_from_living_matter_hellish");
                    ShapelessRecipeBuilder.shapeless(Items.BLAZE_ROD)
                            .requires(ctx.get(), 2)
                            .requires(Items.BONE)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "blaze_rod_from_living_matter_hellish");
                    ShapelessRecipeBuilder.shapeless(Items.GHAST_TEAR, 3)
                            .requires(ctx.get(), 2)
                            .requires(Items.SUGAR)
                            .requires(Items.SPIDER_EYE)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "ghast_tear_from_living_matter_hellish");
                    ShapelessRecipeBuilder.shapeless(Blocks.SOUL_SAND, 4)
                            .requires(ctx.get())
                            .requires(Blocks.SAND)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ItemInit.LivingMatter.HELLISH.get()))
                            .save(prov, DeepMobLearningReloaded.getResource("soul_sand_from_hellish_living_matter"));
                    ShapelessRecipeBuilder.shapeless(Items.NETHER_WART, 4)
                            .requires(ctx.get())
                            .requires(Blocks.RED_MUSHROOM)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "nether_wart_from_living_matter_hellish");
                    ShapelessRecipeBuilder.shapeless(Items.GOLD_INGOT, 6)
                            .requires(ctx.get())
                            .requires(Items.IRON_INGOT)
                            .requires(Items.GLOWSTONE_DUST)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "gold_ingot_from_living_matter_hellish");
                })
                .lang("Hellish Matter")
                .jpLang("Hellishマター")
                .addRawLang(LivingMatterType.HELLISH.getLangId(), "Hellish")
                .addRawJPLang(LivingMatterType.HELLISH.getLangId(), "Hellish")
                .register();

        public static final ItemEntry<ItemLivingMatter> OVERWORLDIAN = REGISTRATE.item("living_matter_overworldian", p -> new ItemLivingMatter(p, LivingMatterType.OVERWORLDIAN))
                .recipe((ctx, prov) -> {
                    ShapelessRecipeBuilder.shapeless(Blocks.GRASS, 4)
                            .requires(ctx.get())
                            .requires(Blocks.DIRT)
                            .requires(ItemTags.LEAVES)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "grass_from_living_matter_overworldian");
                    ShapedRecipeBuilder.shaped(HELLISH.get())
                            .define('#', ctx.get())
                            .define('X', Blocks.NETHERRACK)
                            .pattern(" # ")
                            .pattern("#X#")
                            .pattern(" # ")
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "hellish_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Items.CARROT, 2)
                            .requires(ctx.get())
                            .requires(Items.WHEAT_SEEDS)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "carrot_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Items.PRISMARINE_SHARD, 2)
                            .requires(ctx.get())
                            .requires(Items.QUARTZ)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "prismarine_shard_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Items.IRON_INGOT, 8)
                            .requires(ctx.get(), 4)
                            .requires(Items.ROTTEN_FLESH)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "iron_ingot_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Items.POTATO, 2)
                            .requires(ctx.get())
                            .requires(Items.STICK)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "potato_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Items.GUNPOWDER, 16)
                            .requires(ctx.get())
                            .requires(Items.COAL)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "gunpowder_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Items.ARROW, 12)
                            .requires(ctx.get())
                            .requires(Items.STICK)
                            .requires(Items.FLINT)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "arrow_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Items.BONE, 22)
                            .requires(ctx.get())
                            .requires(Items.BONE_MEAL)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "bone_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Items.ROTTEN_FLESH, 16)
                            .requires(ctx.get())
                            .requires(Items.PORKCHOP)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "rotten_flesh_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Items.SPIDER_EYE, 2)
                            .requires(ctx.get())
                            .requires(Items.ROTTEN_FLESH)
                            .requires(Items.APPLE)
                            .requires(Items.RED_MUSHROOM)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "spider_eye_from_living_matter_overworldian");
                    ShapelessRecipeBuilder.shapeless(Blocks.COBWEB, 4)
                            .requires(ctx.get(), 2)
                            .requires(Items.STRING)
                            .requires(Items.SLIME_BALL)
                            .unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
                            .save(prov, "cobweb_from_living_matter_overworldian");
                })
                .lang("Overworldian Matter")
                .jpLang("Overworldianマター")
                .addRawLang(LivingMatterType.OVERWORLDIAN.getLangId(), "Overworldian")
                .addRawJPLang(LivingMatterType.OVERWORLDIAN.getLangId(), "Overworldian")
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
