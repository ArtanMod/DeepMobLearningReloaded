package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.entity.TFEntities;
import twilightforest.entity.TFEntityNames;
import twilightforest.entity.boss.Naga;

public class NagaMeta extends TwilightMobMetaData {
    public NagaMeta() {
        super(
                TwilightMobKey.NAGA,
                "entity.twilightforest.naga",
                256, 200,
                TwilightItemInit.PristineMatter.NAGA.get(),
                TFEntityNames.NAGA
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return new Naga(TFEntities.NAGA.get(), world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.7F, 0.7F, -0.7F);
    }
}
