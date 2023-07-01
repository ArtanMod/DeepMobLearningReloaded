package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.entity.TFEntities;
import twilightforest.entity.TFEntityNames;

public class AlphaYetiMeta extends TwilightMobMetaData {
    public AlphaYetiMeta() {
        super(
                TwilightMobKey.ALPHA_YETI,
                "entity.twilightforest.alpha_yeti",
                4096, 200,
                TwilightItemInit.PristineMatter.ALPHA_YETI.get(),
                TFEntityNames.ALPHA_YETI
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return TFEntities.ALPHA_YETI.get().create(world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.3F, 0.3F, -0.3F);
    }
}
