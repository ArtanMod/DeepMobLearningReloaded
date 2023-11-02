package jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.mobmetas;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEntities;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.DeeperAndDarkerMobKey;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.init.DeeperAndDarkerItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class StalkerMeta extends DeeperAndDarkerMobMetaData {
    public StalkerMeta() {
        super(
                DeeperAndDarkerMobKey.STALKER,
                "entity.deeperdarker.stalker",
                4096, 125,
                DeeperAndDarkerItemInit.PristineMatter.STALKER.get(),
                new ResourceLocation(DeeperDarker.MOD_ID, "stalker")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return DDEntities.STALKER.get().create(world);
    }
}
