package jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.mobmetas;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.DeeperAndDarkerMobKey;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.init.DeeperAndDarkerItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class ShatteredMeta extends DeeperAndDarkerMobMetaData {
    public ShatteredMeta() {
        super(
                DeeperAndDarkerMobKey.SHATTERED,
                "entity.deeperdarker.shattered",
                1024, 25,
                DeeperAndDarkerItemInit.PristineMatter.SHATTERED.get(),
                new ResourceLocation(DeeperAndDarker.MOD_ID, "shattered")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return DDEntities.SHATTERED.get().create(world);
    }
}
