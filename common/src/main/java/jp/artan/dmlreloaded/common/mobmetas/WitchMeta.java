package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class WitchMeta extends MobMetaData {
    public WitchMeta() {
        super(
                MobKey.WITCH,
                "entity.minecraft.witch",
                120, 13,
                DMLItems.PRISTINE_MATTER_WITCH.get(),
                Items.WITCH_SPAWN_EGG,
                2
        );
    }

    public Witch getEntity(Level world) {
        return new Witch(EntityType.WITCH, world);
    }
}
