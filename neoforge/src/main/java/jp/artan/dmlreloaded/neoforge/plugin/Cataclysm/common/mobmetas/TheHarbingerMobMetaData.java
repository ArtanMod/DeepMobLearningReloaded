package jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.mobmetas;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModEntities;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.CataclysmMobKey;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.init.DMLIntegrationLCItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class TheHarbingerMobMetaData extends CataclysmMobMetaData {
    public TheHarbingerMobMetaData() {
        super(
                CataclysmMobKey.THE_HARBINGER,
                "entity.cataclysm.the_harbinger",
                1024, 195,
                DMLIntegrationLCItems.PRISTINE_MATTER_THE_HARBINGER.get(),
                new ResourceLocation(Cataclysm.MODID, "the_harbinger")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return ModEntities.THE_HARBINGER.get().create(world);
    }
}
