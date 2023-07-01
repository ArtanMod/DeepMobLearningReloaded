package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.entity.TFEntities;
import twilightforest.entity.TFEntityNames;
import twilightforest.entity.boss.Hydra;

public class HydraMeta extends TwilightMobMetaData {
    public HydraMeta() {
        super(
                TwilightMobKey.HYDRA,
                "entity.twilightforest.hydra",
                4096, 360,
                TwilightItemInit.PristineMatter.HYDRA.get(),
                TFEntityNames.HYDRA
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
//        return TFEntities.HYDRA.get().create(world);
        return null;
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.3F, 0.3F, -0.3F);
    }
}
