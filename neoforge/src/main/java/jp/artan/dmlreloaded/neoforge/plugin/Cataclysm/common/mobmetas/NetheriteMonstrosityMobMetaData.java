package jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.mobmetas;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModEntities;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.CataclysmMobKey;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.init.DMLIntegrationLCItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class NetheriteMonstrosityMobMetaData extends CataclysmMobMetaData {
    public NetheriteMonstrosityMobMetaData() {
        super(
                CataclysmMobKey.NETHERITE_MONSTROSITY,
                "entity.cataclysm.netherite_monstrosity",
                1024, 250,
                DMLIntegrationLCItems.PRISTINE_MATTER_NETHERITE_MONSTROSITY.get(),
                new ResourceLocation(Cataclysm.MODID, "netherite_monstrosity")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return ModEntities.NETHERITE_MONSTROSITY.get().create(world);
    }
}
