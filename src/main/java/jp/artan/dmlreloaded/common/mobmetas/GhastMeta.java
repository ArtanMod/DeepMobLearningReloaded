package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.level.Level;

public class GhastMeta extends MobMetaData {
    public GhastMeta() {
        super(
                MobKey.GHAST,
                "entity.minecraft.ghast",
                372, 5,
                ItemInit.PristineMatter.GHAST.get(),
                2
        );
    }

    public Ghast getEntity(Level world) {
        return new Ghast(EntityType.GHAST, world);
    }
}