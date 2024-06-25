package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class GhastMeta extends MobMetaData {
    public GhastMeta() {
        super(
                MobKey.GHAST,
                "entity.minecraft.ghast",
                372, 5,
                DMLItems.PRISTINE_MATTER_GHAST.get(),
                Items.GHAST_SPAWN_EGG,
                2
        );
    }

    public Ghast getEntity(Level world) {
        return new Ghast(EntityType.GHAST, world);
    }

    @Override
    public int getOffsetY(LivingEntity livingEntity) {
        return 15;
    }
}
