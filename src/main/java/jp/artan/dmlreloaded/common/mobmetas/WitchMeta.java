package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.level.Level;

public class WitchMeta extends MobMetaData {
    public WitchMeta() {
        super(
                MobKey.WITCH,
                "entity.minecraft.witch",
                120, 13,
                ItemInit.LivingMatter.OVERWORLDIAN.get(),
                ItemInit.PristineMatter.WITCH.get(),
                2
        );
    }

    public Witch getEntity(Level world) {
        return new Witch(EntityType.WITCH, world);
    }
}
