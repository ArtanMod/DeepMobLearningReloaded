package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.init.TFEntities;
import twilightforest.entity.TFEntityNames;

public class KnightPhantomMeta extends TwilightMobMetaData {
    public KnightPhantomMeta() {
        super(
                TwilightMobKey.KNIGHT_PHANTOM,
                "entity.twilightforest.knight_phantom",
                4096, 210,
                TwilightItemInit.PristineMatter.KNIGHT_PHANTOM.get(),
                TFEntityNames.KNIGHT_PHANTOM
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
//        return TFEntities.KNIGHT_PHANTOM.get().create(world);
        return null;
    }
}
