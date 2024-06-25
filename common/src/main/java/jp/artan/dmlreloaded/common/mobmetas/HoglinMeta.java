package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class HoglinMeta extends MobMetaData {
    public HoglinMeta() {
        super(
                MobKey.HOGLIN,
                "entity.minecraft.hoglin",
                512, 20,
                DMLItems.PRISTINE_MATTER_HOGLIN.get(),
                Items.HOGLIN_SPAWN_EGG
        );
    }

    public Hoglin getEntity(Level world) {
        return new Hoglin(EntityType.HOGLIN , world);
    }
}
