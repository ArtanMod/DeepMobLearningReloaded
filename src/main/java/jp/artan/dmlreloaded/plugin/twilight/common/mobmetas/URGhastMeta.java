package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.init.TFEntities;
import twilightforest.entity.TFEntityNames;

public class URGhastMeta extends TwilightMobMetaData {
    public URGhastMeta() {
        super(
                TwilightMobKey.UR_GHAST,
                "entity.twilightforest.ur_ghast",
                4096, 250,
                TwilightItemInit.PristineMatter.UR_GHAST.get(),
                TFEntityNames.UR_GHAST
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return TFEntities.UR_GHAST.get().create(world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.1F, 0.1F, -0.1F);
    }
}
