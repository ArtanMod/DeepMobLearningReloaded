package jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.mobmetas;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModEntities;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.CataclysmMobKey;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.init.DMLIntegrationLCItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class CoralGolemMobMetaData extends CataclysmMobMetaData {
    public CoralGolemMobMetaData() {
        super(
                CataclysmMobKey.CORAL_GOLEM,
                "entity.cataclysm.coral_golem",
                1024, 55,
                DMLIntegrationLCItems.PRISTINE_MATTER_CORAL_GOLEM.get(),
                new ResourceLocation(Cataclysm.MODID, "coral_golem")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return ModEntities.CORAL_GOLEM.get().create(world);
    }
}
