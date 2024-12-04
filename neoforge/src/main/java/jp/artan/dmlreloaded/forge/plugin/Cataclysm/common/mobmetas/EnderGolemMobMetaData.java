package jp.artan.dmlreloaded.forge.plugin.Cataclysm.common.mobmetas;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModEntities;
import jp.artan.dmlreloaded.forge.plugin.Cataclysm.common.CataclysmMobKey;
import jp.artan.dmlreloaded.forge.plugin.Cataclysm.init.DMLIntegrationLCItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class EnderGolemMobMetaData extends CataclysmMobMetaData {
    public EnderGolemMobMetaData() {
        super(
                CataclysmMobKey.ENDER_GOLEM,
                "entity.cataclysm.ender_golem",
                1024, 75,
                DMLIntegrationLCItems.PRISTINE_MATTER_ENDER_GOLEM.get(),
                new ResourceLocation(Cataclysm.MODID, "ender_golem")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return ModEntities.ENDER_GOLEM.get().create(world);
    }
}
