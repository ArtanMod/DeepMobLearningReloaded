package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class WardenMeta extends MobMetaData {
    public WardenMeta() {
        super(
                MobKey.WARDEN,
                "entity.minecraft.warden",
                4096, 250,
                ItemInit.PristineMatter.WARDEN.get(),
                Items.WARDEN_SPAWN_EGG
        );
    }

    public Warden getEntity(Level world) {
        return new Warden(EntityType.WARDEN , world);
    }
}
