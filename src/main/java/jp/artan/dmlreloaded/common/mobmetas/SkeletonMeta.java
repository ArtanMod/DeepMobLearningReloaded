package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;

public class SkeletonMeta extends MobMetaData {
    public SkeletonMeta() {
        super(
                MobKey.SKELETON,
                "entity.minecraft.skeleton",
                80, 10,
                ItemInit.LivingMatter.OVERWORLDIAN.get(),
                ItemInit.PristineMatter.SKELETON.get(),
                3
        );
    }

    public Skeleton getEntity(Level world) {
        return new Skeleton(EntityType.SKELETON, world);
    }
}
