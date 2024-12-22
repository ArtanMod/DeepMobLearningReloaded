package jp.artan.dmlreloaded.neoforge.plugin.DeeperAndDarker.common.mobmetas;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEntities;
import jp.artan.dmlreloaded.neoforge.plugin.DeeperAndDarker.common.DeeperAndDarkerMobKey;
import jp.artan.dmlreloaded.neoforge.plugin.DeeperAndDarker.init.DMLIntegrationDADItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class SculkCentipedeMeta extends DeeperAndDarkerMobMetaData {
    public SculkCentipedeMeta() {
        super(
                DeeperAndDarkerMobKey.SCULK_CENTIPEDE,
                "entity.deeperdarker.sculk_centipede",
                1024, 13,
                DMLIntegrationDADItems.PRISTINE_MATTER_SCULK_CENTIPEDE.get(),
                ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, "sculk_centipede")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return DDEntities.SCULK_CENTIPEDE.get().create(world);
    }
}
