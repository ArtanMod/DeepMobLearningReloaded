package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class CreeperMeta extends MobMetaData {
    public CreeperMeta() {
        super(
                MobKey.CREEPER,
                "entity.minecraft.creeper",
                80, 10,
                ItemInit.PristineMatter.CREEPER.get(),
                Items.CREEPER_SPAWN_EGG,
                2
        );
    }

    public LivingEntity getEntity(Level world) {
        return new Creeper(EntityType.CREEPER, world);
    }
}
