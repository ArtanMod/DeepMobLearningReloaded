package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class ZombieMeta extends MobMetaData {
    public ZombieMeta() {
        super(
                MobKey.ZOMBIE,
                "entity.minecraft.zombie",
                10, 35, -2, 6,
                ItemInit.LivingMatter.OVERWORLDIAN.get(),
                ItemInit.PristineMatter.ZOMBIE.get(),
                3);
    }

    public Zombie getEntity(Level world) {
        return new Zombie(world);
    }

    public Zombie getExtraEntity(Level world) {
        Zombie childEntity = new Zombie(world);
        childEntity.setBaby(true);

        return childEntity;
    }

    public int getExtraInterfaceOffsetX() {
        return 21;
    }

    public int getExtraInterfaceOffsetY() {
        return 6;
    }
}
