package jp.artan.dmlreloaded.plugin.tconstruct;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.plugin.tconstruct.init.TiCItemInit;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.shared.TinkerMaterials;
import slimeknights.tconstruct.world.TinkerHeadType;
import slimeknights.tconstruct.world.TinkerWorld;

import static jp.artan.dmlreloaded.plugin.PluginInit.TIC_ACTIVE;

public class TiCPlugin {
    public static final String NAME = "tconstruct";

    public static void init(IEventBus modEventBus) {
        if (TIC_ACTIVE) {
            registerMobKey();
            TiCItemInit.register();
        }
    }

    private static void registerMobKey() {
        MobKey.SLIME.addMob(NAME + ":earth_slime", "entity.tconstruct.earth_slime");
        MobKey.BLAZE.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.BLAZE), 6));
        MobKey.SPIDER.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.SPIDER), 6));
        MobKey.SPIDER.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.CAVE_SPIDER), 6));
        MobKey.ZOMBIE.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.DROWNED), 6));
        MobKey.ZOMBIE.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.HUSK), 6));
        MobKey.ZOMBIE.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.ZOMBIFIED_PIGLIN), 6));
        MobKey.ENDERMAN.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.ENDERMAN), 6));
        MobKey.PIGLIN.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.PIGLIN), 6));
        MobKey.PIGLIN.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.PIGLIN_BRUTE), 6));
        MobKey.SKELETON.addLoot(() -> new ItemStack(TinkerWorld.heads.get(TinkerHeadType.STRAY), 6));
        MobKey.WITHER_SKELETON.addLoot(() -> new ItemStack(TinkerMaterials.necroticBone, 8));
    }
}
