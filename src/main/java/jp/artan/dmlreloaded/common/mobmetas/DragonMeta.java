package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.Level;

public class DragonMeta extends MobMetaData{
    public DragonMeta() {
        super(
                MobKey.DRAGON,
                "entity.minecraft.ender_dragon",
                4096, 100,
                ItemInit.LivingMatter.EXTRATERRESTRIAL.get(),
                ItemInit.PristineMatter.DRAGON.get(),
                2
        );
    }

    public EnderDragon getEntity(Level world) {
        return new EnderDragon(EntityType.ENDER_DRAGON ,world);
    }
}
