package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.Level;

public class WitherMeta extends MobMetaData {
    public WitherMeta() {
        super(
                MobKey.WITHER,
                "entity.minecraft.wither",
                2048, 150,
                ItemInit.PristineMatter.WITHER.get(),
                1
        );
    }
    public WitherBoss getEntity(Level world) {
        return new WitherBoss(EntityType.WITHER,world) {
        };
    }

}
