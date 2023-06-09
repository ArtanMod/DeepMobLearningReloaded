package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class EvokerMeta extends MobMetaData {
    public EvokerMeta() {
        super(
                MobKey.EVOKER,
                "entity.minecraft.evoker",
                1024, 12,
                ItemInit.PristineMatter.EVOKER.get(),
                Items.EVOKER_SPAWN_EGG
        );
    }

    public Evoker getEntity(Level world) {
        return new Evoker(EntityType.EVOKER , world);
    }
}
