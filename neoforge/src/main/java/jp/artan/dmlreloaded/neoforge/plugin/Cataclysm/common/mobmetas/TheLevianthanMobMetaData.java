package jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.mobmetas;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModEntities;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.CataclysmMobKey;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.init.DMLIntegrationLCItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class TheLevianthanMobMetaData extends CataclysmMobMetaData {
    public TheLevianthanMobMetaData() {
        super(
                CataclysmMobKey.THE_LEVIATHAN,
                "entity.cataclysm.the_leviathan",
                1024, 200,
                DMLIntegrationLCItems.PRISTINE_MATTER_THE_LEVIATHAN.get(),
                new ResourceLocation(Cataclysm.MODID, "the_leviathan")
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return ModEntities.THE_LEVIATHAN .get().create(world);
    }
}
