package jp.artan.dmlreloaded.plugin.twilight.init;

import jp.artan.artansprojectcoremod.plugin.registrate.builder.ModItemBuilder;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.init.ItemGroupInit;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightLivingMatterType;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.repack.registrate.providers.RegistrateRecipeProvider;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.Block;
import twilightforest.init.TFBlocks;

import java.util.function.Supplier;

public class TwilightItemInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static class DataModel {
        public static final ItemEntry<ItemDataModel> NAGA = registerDataModel("data_model_twilight_naga", TwilightMobKey.NAGA, TFBlocks.NAGA_TROPHY::get)
                .lang("Naga Data Model")
                .jpLang("ナーガのデータモデル")
                .register();
        public static final ItemEntry<ItemDataModel> LICH = registerDataModel("data_model_twilight_lich", TwilightMobKey.LICH, TFBlocks.LICH_TROPHY::get)
                .lang("Lich Data Model")
                .jpLang("リッチのデータモデル")
                .register();
        public static final ItemEntry<ItemDataModel> MINOSHROOM = registerDataModel("data_model_twilight_minoshroom", TwilightMobKey.MINOSHROOM, TFBlocks.MINOSHROOM_TROPHY::get)
                .lang("Minoshroom Data Model")
                .jpLang("ミノッシュルームのデータモデル")
                .register();
        public static final ItemEntry<ItemDataModel> HYDRA = registerDataModel("data_model_twilight_hydra", TwilightMobKey.HYDRA, TFBlocks.HYDRA_TROPHY::get)
                .lang("Hydra Data Model")
                .jpLang("ヒドラのデータモデル")
                .register();
        public static final ItemEntry<ItemDataModel> KNIGHT_PHANTOM = registerDataModel("data_model_twilight_knight_phantom", TwilightMobKey.KNIGHT_PHANTOM, TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY::get)
                .lang("Knight Phantom Data Model")
                .jpLang("ナイトファントムのデータモデル")
                .register();
        public static final ItemEntry<ItemDataModel> UR_GHAST = registerDataModel("data_model_twilight_ur_ghast", TwilightMobKey.UR_GHAST, TFBlocks.UR_GHAST_TROPHY::get)
                .lang("Ur Ghast Data Model")
                .jpLang("ウルガストのデータモデル")
                .register();
        public static final ItemEntry<ItemDataModel> ALPHA_YETI = registerDataModel("data_model_twilight_alpha_yeti", TwilightMobKey.ALPHA_YETI, TFBlocks.ALPHA_YETI_TROPHY::get)
                .lang("Alpha Yeti Data Model")
                .jpLang("アルファイエティのデータモデル")
                .register();
        public static final ItemEntry<ItemDataModel> SNOW_QUEEN = registerDataModel("data_model_twilight_snow_queen", TwilightMobKey.SNOW_QUEEN, TFBlocks.SNOW_QUEEN_TROPHY::get)
                .lang("Snow Queen Data Model")
                .jpLang("雪の女王のデータモデル")
                .register();

        public static void register() {

        }

        private static ModItemBuilder<ItemDataModel, DeepMobLearningReloadedRegistrate> registerDataModel(String id, TwilightMobKey key, Supplier<? extends Block> material) {
            return REGISTRATE.item(id, p -> new ItemDataModel(p, key))
                    .properties(p -> p.stacksTo(1))
                    .recipe((ctx, prov) -> {
                        ShapelessRecipeBuilder.shapeless(ctx.get())
                                .requires(ItemInit.DataModel.BLANK.get())
                                .requires(material.get())
                                .unlockedBy("has_item", RegistrateRecipeProvider.has(ItemInit.DataModel.BLANK.get()))
                                .save(prov);
                    });
        }
    }

    public static class PristineMatter {
        public static final ItemEntry<ItemPristineMatter> NAGA = REGISTRATE.item("pristine_matter_twilight_naga", p -> new ItemPristineMatter(p, TwilightMobKey.NAGA))
                .lang("Pristine Naga Matter")
                .jpLang("綺麗なナーガマター")
                .register();
        public static final ItemEntry<ItemPristineMatter> LICH = REGISTRATE.item("pristine_matter_twilight_lich", p -> new ItemPristineMatter(p, TwilightMobKey.LICH))
                .lang("Pristine Lich Matter")
                .jpLang("綺麗なリッチマター")
                .register();
        public static final ItemEntry<ItemPristineMatter> MINOSHROOM = REGISTRATE.item("pristine_matter_twilight_minoshroom", p -> new ItemPristineMatter(p, TwilightMobKey.MINOSHROOM))
                .lang("Pristine Minoshroom Matter")
                .jpLang("綺麗なミノッシュルームマター")
                .register();
        public static final ItemEntry<ItemPristineMatter> HYDRA = REGISTRATE.item("pristine_matter_twilight_hydra", p -> new ItemPristineMatter(p, TwilightMobKey.HYDRA))
                .lang("Pristine Hydra Matter")
                .jpLang("綺麗なヒドラマター")
                .register();
        public static final ItemEntry<ItemPristineMatter> KNIGHT_PHANTOM = REGISTRATE.item("pristine_matter_twilight_knight_phantom", p -> new ItemPristineMatter(p, TwilightMobKey.KNIGHT_PHANTOM))
                .lang("Pristine Knight Phantom Matter")
                .jpLang("綺麗なナイトファントムマター")
                .register();
        public static final ItemEntry<ItemPristineMatter> UR_GHAST = REGISTRATE.item("pristine_matter_twilight_ur_ghast", p -> new ItemPristineMatter(p, TwilightMobKey.UR_GHAST))
                .lang("Pristine UR Ghast Matter")
                .jpLang("綺麗なウルガストマター")
                .register();
        public static final ItemEntry<ItemPristineMatter> ALPHA_YETI = REGISTRATE.item("pristine_matter_twilight_alpha_yeti", p -> new ItemPristineMatter(p, TwilightMobKey.ALPHA_YETI))
                .lang("Pristine Alpha Yeti Matter")
                .jpLang("綺麗なアルファイエティマター")
                .register();
        public static final ItemEntry<ItemPristineMatter> SNOW_QUEEN = REGISTRATE.item("pristine_matter_twilight_snow_queen", p -> new ItemPristineMatter(p, TwilightMobKey.SNOW_QUEEN))
                .lang("Pristine Snow Queen Matter")
                .jpLang("綺麗な雪の女王マター")
                .register();

        public static void register() {

        }
    }

    public static class LivingMatter {
        public static final ItemEntry<ItemLivingMatter> TWILIGHT = REGISTRATE.item("living_matter_twilight", p -> new ItemLivingMatter(p, TwilightLivingMatterType.TWILIGHT))
                .recipe((ctx, prov) -> {

                })
                .lang("Twilight Matter")
                .jpLang("Twilightマター")
                .addRawLang(TwilightLivingMatterType.TWILIGHT.getLangId(), "Twilight Matter")
                .addRawJPLang(TwilightLivingMatterType.TWILIGHT.getLangId(), "Twilightマター")
                .register();

        public static void register() {

        }
    }

    public static void register() {
        DataModel.register();
        PristineMatter.register();
        LivingMatter.register();
    }
}
