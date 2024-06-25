package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SkeletonMeta extends MobMetaData {
    public SkeletonMeta() {
        super(
                MobKey.SKELETON,
                "entity.minecraft.skeleton",
                80, 10,
                DMLItems.PRISTINE_MATTER_SKELETON.get(),
                Items.SKELETON_SPAWN_EGG,
                3
        );
    }

    public Skeleton getEntity(Level world) {
        return new Skeleton(EntityType.SKELETON, world);
    }
}
