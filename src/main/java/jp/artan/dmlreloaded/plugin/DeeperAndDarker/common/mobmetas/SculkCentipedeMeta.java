package jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.mobmetas;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEntities;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.DeeperAndDarkerMobKey;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.init.DeeperAndDarkerItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class SculkCentipedeMeta extends DeeperAndDarkerMobMetaData {
    public SculkCentipedeMeta() {
        super(
                DeeperAndDarkerMobKey.SCULK_CENTIPEDE,
                "entity.deeperdarker.sculk_centipede",
                1024, 13,
                DeeperAndDarkerItemInit.PristineMatter.SCULK_CENTIPEDE.get(),
                new ResourceLocation(DeeperDarker.MOD_ID, "sculk_centipede")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return DDEntities.SCULK_CENTIPEDE.get().create(world);
    }
}
