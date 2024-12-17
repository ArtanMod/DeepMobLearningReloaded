package jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.mobmetas;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModEntities;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.CataclysmMobKey;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.init.DMLIntegrationLCItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class AncientRemnantMobMetaData extends CataclysmMobMetaData {
    public AncientRemnantMobMetaData() {
        super(
                CataclysmMobKey.ANCIENT_REMNANT,
                "entity.cataclysm.ancient_remnant",
                1024, 200,
                DMLIntegrationLCItems.PRISTINE_MATTER_ANCIENT_REMNANT.get(),
                new ResourceLocation(Cataclysm.MODID, "ancient_remnant")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return ModEntities.ANCIENT_REMNANT.get().create(world);
    }
}
