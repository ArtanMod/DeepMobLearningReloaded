package jp.artan.dmlreloaded.init;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import jp.artan.repack.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ItemInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate().creativeModeTab(() -> ItemGroupInit.DEEP_MOB_LEARNING_RELOADED);

    public static final ItemEntry<Item> DATA_MODEL_BLANK = REGISTRATE.item("data_model_blank", Item::new)
            .lang("Blank Data Model")
            .jpLang("空のデータモデル")
            .register();

    public static void register() {
    }
}
