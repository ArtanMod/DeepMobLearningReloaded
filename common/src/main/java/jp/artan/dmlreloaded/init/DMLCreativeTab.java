package jp.artan.dmlreloaded.init;

import dev.architectury.registry.CreativeTabRegistry;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class DMLCreativeTab {
    public static final CreativeModeTab DEEP_MOB_LEARNING_RELOADED = CreativeTabRegistry.create(DeepMobLearningReloadedMod.getResource("deep_mob_learning_reloaded"), () -> new ItemStack(Registry.ITEM.get(DeepMobLearningReloadedMod.getResource("deep_learner"))));
    public static void register() {
    }
}
