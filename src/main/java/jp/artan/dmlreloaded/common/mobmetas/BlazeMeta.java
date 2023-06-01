package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.level.Level;

public class BlazeMeta extends MobMetaData {
    public BlazeMeta() {
        super(
                MobKey.BLAZE,
                "entity.minecraft.blaze",
                256, 10,
                ItemInit.PristineMatter.BLAZE.get(),
                3
        );
    }

    public Blaze getEntity(Level world) {
        return new Blaze(EntityType.BLAZE, world);
    }
}
