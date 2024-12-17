package jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.mobmetas;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModEntities;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.CataclysmMobKey;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.init.DMLIntegrationLCItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class EnderGuardianMobMetaData extends CataclysmMobMetaData {
    public EnderGuardianMobMetaData() {
        super(
                CataclysmMobKey.ENDER_GOLEM,
                "entity.cataclysm.ender_guardian",
                1024, 167,
                DMLIntegrationLCItems.PRISTINE_MATTER_ENDER_GUARDIAN.get(),
                new ResourceLocation(Cataclysm.MODID, "ender_guardian")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return ModEntities.ENDER_GUARDIAN.get().create(world);
    }
}
