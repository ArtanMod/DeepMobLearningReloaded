package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PiglinMeta extends MobMetaData {
    public PiglinMeta() {
        super(
                MobKey.PIGLIN,
                "entity.minecraft.piglin",
                80, 8,
                DMLItems.PRISTINE_MATTER_PIGLIN.get(),
                Items.PIGLIN_SPAWN_EGG
        );
    }

    public Piglin getEntity(Level world) {
        return new Piglin(EntityType.PIGLIN , world);
    }
}
