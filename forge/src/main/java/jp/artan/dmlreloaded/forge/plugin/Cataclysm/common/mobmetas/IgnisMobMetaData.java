package jp.artan.dmlreloaded.forge.plugin.Cataclysm.common.mobmetas;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModEntities;
import jp.artan.dmlreloaded.forge.plugin.Cataclysm.common.CataclysmMobKey;
import jp.artan.dmlreloaded.forge.plugin.Cataclysm.init.DMLIntegrationLCItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class IgnisMobMetaData extends CataclysmMobMetaData {
    public IgnisMobMetaData() {
        super(
                CataclysmMobKey.IGNIS,
                "entity.cataclysm.ignis",
                1024, 225,
                DMLIntegrationLCItems.PRISTINE_MATTER_IGNIS.get(),
                new ResourceLocation(Cataclysm.MODID, "ignis")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return ModEntities.IGNIS.get().create(world);
    }
}
