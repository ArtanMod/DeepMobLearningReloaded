package jp.artan.dmlreloaded.plugin.DeeperAndDarker.init;

import com.kyanite.deeperdarker.content.DDItems;
import jp.artan.artansprojectcoremod.plugin.registrate.builder.ModItemBuilder;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.init.ItemGroupInit;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.DeeperAndDarkerLivingMatterType;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.DeeperAndDarkerMobKey;
import jp.artan.repack.registrate.providers.RegistrateRecipeProvider;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class DeeperAndDarkerItemInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static class DataModel {

        public static final ItemEntry<ItemDataModel> SHATTERED = registerDataModel("data_model_deeper_darker_shattered", DeeperAndDarkerMobKey.SHATTERED, DDItems.SOUL_DUST::get)
                .lang("Shattered Data Model")
                .register();
//        public static final ItemEntry<ItemDataModel> SCULK_LEECH = registerDataModel("data_model_deeper_darker_sculk_leech", DeeperAndDarkerMobKey.SCULK_LEECH)
//                .lang("Sculk Leech Data Model")
//                .register();
//        public static final ItemEntry<ItemDataModel> SCULK_SNAPPER = registerDataModel("data_model_deeper_darker_sculk_snapper", DeeperAndDarkerMobKey.SCULK_SNAPPER)
//                .lang("Sculk Snapper Data Model")
//                .register();
//        public static final ItemEntry<ItemDataModel> SHRIEK_WORM = registerDataModel("data_model_deeper_darker_shriek_worm", DeeperAndDarkerMobKey.SHRIEK_WORM)
//                .lang("Shriek Worm Data Model")
//                .register();
        public static final ItemEntry<ItemDataModel> SCULK_CENTIPEDE = registerDataModel("data_model_deeper_darker_sculk_centipede", DeeperAndDarkerMobKey.SCULK_CENTIPEDE, DDItems.SCULK_BONE::get)
                .lang("Sculk Centipede Data Model")
                .register();
        public static final ItemEntry<ItemDataModel> STALKER = registerDataModel("data_model_deeper_darker_stalker", DeeperAndDarkerMobKey.STALKER, DDItems.SOUL_CRYSTAL::get)
                .lang("Stalker Data Model")
                .register();

        private static ModItemBuilder<ItemDataModel, DeepMobLearningReloadedRegistrate> registerDataModel(String id, DeeperAndDarkerMobKey key, Supplier<? extends Item> material) {
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

        public static void register() {

        }
    }

    public static class PristineMatter {

        public static final ItemEntry<ItemPristineMatter> SHATTERED = REGISTRATE.item("pristine_matter_deeper_darker_shattered", p -> new ItemPristineMatter(p, DeeperAndDarkerMobKey.SHATTERED))
                .lang("Pristine Shattered Matter")
                .register();
//        public static final ItemEntry<ItemPristineMatter> SCULK_LEECH = REGISTRATE.item("pristine_matter_deeper_darker_sculk_leech", p -> new ItemPristineMatter(p, DeeperAndDarkerMobKey.SCULK_LEECH))
//                .lang("Pristine Sculk Leech Matter")
//                .register();
//        public static final ItemEntry<ItemPristineMatter> SCULK_SNAPPER = REGISTRATE.item("pristine_matter_deeper_darker_sculk_snapper", p -> new ItemPristineMatter(p, DeeperAndDarkerMobKey.SCULK_SNAPPER))
//                .lang("Pristine Sculk Snapper Matter")
//                .register();
//        public static final ItemEntry<ItemPristineMatter> SHRIEK_WORM = REGISTRATE.item("pristine_matter_deeper_darker_shriek_worm", p -> new ItemPristineMatter(p, DeeperAndDarkerMobKey.SHRIEK_WORM))
//                .lang("Pristine Shriek Worm Matter")
//                .register();
        public static final ItemEntry<ItemPristineMatter> SCULK_CENTIPEDE = REGISTRATE.item("pristine_matter_deeper_darker_sculk_centipede", p -> new ItemPristineMatter(p, DeeperAndDarkerMobKey.SCULK_CENTIPEDE))
                .lang("Pristine Sculk Centipede Matter")
                .register();
        public static final ItemEntry<ItemPristineMatter> STALKER = REGISTRATE.item("pristine_matter_deeper_darker_stalker", p -> new ItemPristineMatter(p, DeeperAndDarkerMobKey.STALKER))
                .lang("Pristine Stalker Matter")
                .register();

        public static void register() {

        }
    }

    public static class LivingMatter {
        public static final ItemEntry<ItemLivingMatter> DEEPER_AND_DARKER = REGISTRATE.item("living_matter_deeper_darker", p -> new ItemLivingMatter(p, DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER))
                .recipe((ctx, prov) -> {

                })
                .lang("Deeper Darker Matter")
                .jpLang("Deeper Darkerマター")
                .addRawLang(DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER.getLangId(), "Deeper Darker Matter")
                .addRawJPLang(DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER.getLangId(), "Deeper Darkerマター")
                .register();

        public static void register() {

        }
    }

    public static void register() {
        DeeperAndDarkerItemInit.DataModel.register();
        DeeperAndDarkerItemInit.PristineMatter.register();
        DeeperAndDarkerItemInit.LivingMatter.register();
    }
}
