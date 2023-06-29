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
import net.minecraft.world.item.Item;
import twilightforest.item.TFItems;

import java.util.function.Supplier;

public class TwilightItemInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static class DataModel {
        public static final ItemEntry<ItemDataModel> NAGA = registerDataModel("data_model_twilight_naga", TwilightMobKey.NAGA, TFItems.NAGA_SCALE::get)
                .lang("Naga Data Model")
                .jpLang("ナーガのデータモデル")
                .register();

        public static void register() {

        }

        private static ModItemBuilder<ItemDataModel, DeepMobLearningReloadedRegistrate> registerDataModel(String id, TwilightMobKey key, Supplier<? extends Item> material) {
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
//                .addRawLang(MobMetaData.getMobTriviaLangId(TwilightMobKey.NAGA, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(TwilightMobKey.NAGA, 0), "")
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
