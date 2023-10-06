package jp.artan.dmlreloaded.plugin.reliquary;

import jp.artan.dmlreloaded.common.MobKey;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import reliquary.init.ModItems;

public class ReliquaryPlugin {
    public static final String NAME = "reliquary";

    public static void init(IEventBus modEventBus) {
        registerMobKey();
    }

    private static void registerMobKey() {

        MobKey.SKELETON.addLoot(() -> new ItemStack(ModItems.RIB_BONE.get(), 8));

        MobKey.WITHER_SKELETON.addLoot(() -> new ItemStack(ModItems.WITHERED_RIB.get(), 8));

        MobKey.SPIDER.addLoot(() -> new ItemStack(ModItems.CHELICERAE.get(), 8));

        MobKey.CREEPER.addLoot(() -> new ItemStack(ModItems.CATALYZING_GLAND.get(), 8));
        MobKey.GHAST.addLoot(() -> new ItemStack(ModItems.CATALYZING_GLAND.get(), 8));

        MobKey.SLIME.addLoot(() -> new ItemStack(ModItems.SLIME_PEARL.get(), 8));

        MobKey.ZOMBIE.addLoot(() -> new ItemStack(ModItems.ZOMBIE_HEART.get(), 8));
        MobKey.PIGLIN.addLoot(() -> new ItemStack(ModItems.ZOMBIE_HEART.get(), 8));

        MobKey.BLAZE.addLoot(() -> new ItemStack(ModItems.MOLTEN_CORE.get(), 8));

        MobKey.ENDERMAN.addLoot(() -> new ItemStack(ModItems.NEBULOUS_HEART.get(), 8));

        MobKey.WITCH.addLoot(() -> new ItemStack(ModItems.WITCH_HAT.get(), 8));

        MobKey.GUARDIAN.addLoot(() -> new ItemStack(ModItems.GUARDIAN_SPIKE.get(), 8));
    }
}
