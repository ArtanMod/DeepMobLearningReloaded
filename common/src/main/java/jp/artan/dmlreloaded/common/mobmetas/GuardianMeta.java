package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class GuardianMeta extends MobMetaData {
    public GuardianMeta() {
        super(
                MobKey.GUARDIAN,
                "entity.minecraft.guardian",
                340, 15,
                DMLItems.PRISTINE_MATTER_GUARDIAN.get(),
                Items.GUARDIAN_SPAWN_EGG,
                3
        );
    }

    public Guardian getEntity(Level world) {
        return new Guardian(EntityType.GUARDIAN, world);
    }
}
