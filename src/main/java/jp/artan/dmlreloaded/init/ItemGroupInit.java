package jp.artan.dmlreloaded.init;

import jp.artan.artansprojectcoremod.tabs.CreativeTab;
import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.DeepMobLearningReloadedRegistrate;
import net.minecraft.world.item.ItemStack;

public class ItemGroupInit {
    private static final DeepMobLearningReloadedRegistrate REGISTRATE = DeepMobLearningReloaded.registrate();

    public static final CreativeTab DEEP_MOB_LEARNING_RELOADED = REGISTRATE.tab("deep_mob_learning_reloaded", () -> new ItemStack(ItemInit.DEEP_LEARNER.get()))
            .lang("Deep Mob Learning: Reloaded")
            .register();

    public static void register() {
    }
}
