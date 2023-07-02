package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.init.TFEntities;
import twilightforest.entity.TFEntityNames;

public class LichMeta extends TwilightMobMetaData {
    public LichMeta() {
        super(
                TwilightMobKey.LICH,
                "entity.twilightforest.lich",
                4096, 100,
                TwilightItemInit.PristineMatter.LICH.get(),
                TFEntityNames.LICH
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return TFEntities.LICH.get().create(world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.8F, 0.8F, -0.8F);
    }
}
