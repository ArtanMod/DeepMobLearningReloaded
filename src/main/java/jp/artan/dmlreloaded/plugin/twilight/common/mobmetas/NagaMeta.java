package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.init.TFEntities;
import twilightforest.entity.TFEntityNames;

public class NagaMeta extends TwilightMobMetaData {
    public NagaMeta() {
        super(
                TwilightMobKey.NAGA,
                "entity.twilightforest.naga",
                4096, 200,
                TwilightItemInit.PristineMatter.NAGA.get(),
                TFEntityNames.NAGA
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return TFEntities.NAGA.get().create(world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.7F, 0.7F, -0.7F);
    }
}
