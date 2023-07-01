package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.entity.TFEntities;
import twilightforest.entity.TFEntityNames;

public class SnowQueenMeta extends TwilightMobMetaData {
    public SnowQueenMeta() {
        super(
                TwilightMobKey.SNOW_QUEEN,
                "entity.twilightforest.snow_queen",
                4096, 200,
                TwilightItemInit.PristineMatter.SNOW_QUEEN.get(),
                TFEntityNames.SNOW_QUEEN
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return TFEntities.SNOW_QUEEN.get().create(world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.8F, 0.8F, -0.8F);
    }
}
