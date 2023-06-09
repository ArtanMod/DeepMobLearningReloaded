package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class ElderGuardianMeta extends MobMetaData {
    public ElderGuardianMeta() {
        super(
                MobKey.ELDER_GUARDIAN,
                "entity.minecraft.elder_guardian",
                2048, 40,
                ItemInit.PristineMatter.ELDER_GUARDIAN.get(),
                Items.ELDER_GUARDIAN_SPAWN_EGG
        );
    }

    public ElderGuardian getEntity(Level world) {
        return new ElderGuardian(EntityType.ELDER_GUARDIAN , world);
    }
}
