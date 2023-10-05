package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class RavagerMeta extends MobMetaData {
    public RavagerMeta() {
        super(
                MobKey.RAVAGER,
                "entity.minecraft.ravager",
                372, 50,
                ItemInit.PristineMatter.RAVAGER.get(),
                Items.RAVAGER_SPAWN_EGG
        );
    }

    public Ravager getEntity(Level world) {
        return new Ravager(EntityType.RAVAGER , world);
    }
}
