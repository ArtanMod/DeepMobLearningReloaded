package jp.artan.dmlreloaded.plugin.tconstruct.init;

import jp.artan.artansprojectcoremod.plugin.registrate.builder.ModItemBuilder;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.dmlreloaded.init.ItemGroupInit;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.item.ItemDataModel;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.dmlreloaded.plugin.tconstruct.common.TiCMobKey;
import jp.artan.repack.registrate.providers.RegistrateRecipeProvider;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import slimeknights.tconstruct.shared.TinkerCommons;
import slimeknights.tconstruct.shared.block.SlimeType;

import java.util.function.Supplier;

public class TiCItemInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static class DataModel {
        public static final ItemEntry<ItemDataModel> BLUE_SLIME = registerDataModel("data_model_tinker_slime", TiCMobKey.SLIME, () -> TinkerCommons.slimeball.get(SlimeType.SKY))
                .lang("Blue Slime Data Model")
                .jpLang("ブルースライムのデータモデル")
                .register();

        public static void register() {
        }
    }


    public static class PristineMatter {
        public static final ItemEntry<ItemPristineMatter> BLUE_SLIME = REGISTRATE.item("pristine_matter_tinker_slime", p -> new ItemPristineMatter(p, TiCMobKey.SLIME))
                .lang("Pristine Blue Slime Matter")
                .jpLang("綺麗なブルースライムマター")
//                .addRawLang(MobMetaData.getMobTriviaLangId(TiCMobKey.SLIME, 0), "")
//                .addRawJPLang(MobMetaData.getMobTriviaLangId(TiCMobKey.SLIME, 0), "")
                .register();

        public static void register() {
        }
    }


    public static void register() {
        DataModel.register();
        PristineMatter.register();
    }

    private static ModItemBuilder<ItemDataModel, DeepMobLearningReloadedRegistrate> registerDataModel(String id, TiCMobKey key, Supplier<? extends Item> material) {
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
