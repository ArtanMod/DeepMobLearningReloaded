package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class ShulkerMeta extends MobMetaData {
    public ShulkerMeta() {
        super(
                MobKey.SHULKER,
                "entity.minecraft.shulker",
                512, 15,
                ItemInit.PristineMatter.SHULKER.get(),
                Items.SHULKER_SPAWN_EGG,
                2
        );
    }

    public Shulker getEntity(Level world) {
        return new Shulker(EntityType.SHULKER, world);
    }
}
