package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.level.Level;

public class WitherSkeletonMeta extends MobMetaData {
    public WitherSkeletonMeta() {
        super(
                MobKey.WITHER_SKELETON,
                "entity.minecraft.wither_skeleton",
                880, 10,
                ItemInit.PristineMatter.WITHER_SKELETON.get(),
                2
        );
    }

    public WitherSkeleton getEntity(Level world) {
        return new WitherSkeleton(EntityType.WITHER_SKELETON, world);
    }
}
