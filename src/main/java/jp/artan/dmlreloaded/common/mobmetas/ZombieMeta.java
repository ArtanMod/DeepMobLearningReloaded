package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class ZombieMeta extends MobMetaData {
    public ZombieMeta() {
        super(
                MobKey.ZOMBIE,
                "entity.minecraft.zombie",
                80, 10,
                ItemInit.PristineMatter.ZOMBIE.get(),
                Items.ZOMBIE_SPAWN_EGG,
                3);
    }

    @Override
    public Zombie getEntity(Level world) {
        return new Zombie(world);
    }

    @Override
    public Zombie getExtraEntity(Level world) {
        Zombie childEntity = new Zombie(world);
        childEntity.setBaby(true);

        return childEntity;
    }
}
