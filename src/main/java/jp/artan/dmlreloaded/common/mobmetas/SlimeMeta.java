package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public class SlimeMeta extends MobMetaData {
    public SlimeMeta() {
        super(
                MobKey.SLIME,
                "entity.minecraft.slime",
                150, 8,
                ItemInit.PristineMatter.SLIME.get(),
                3
        );
    }

    public Slime getEntity(Level world) {
        return new Slime(EntityType.SLIME, world);
    }
}
