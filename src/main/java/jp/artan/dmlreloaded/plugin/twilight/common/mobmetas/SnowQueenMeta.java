package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import jp.artan.dmlreloaded.util.RenderInfo;
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
//                TwilightItemInit.PristineMatter.SNOW_QUEEN.get(),
                null,
                TFEntityNames.SNOW_QUEEN
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return TFEntities.SNOW_QUEEN.get().create(world);
    }

    @Override
    public RenderInfo transform(RenderInfo renderInfo, LivingEntity entity) {
        PoseStack modelViewStack = RenderSystem.getModelViewStack();
        modelViewStack.scale(0.8F, 0.8F, -0.8F);
        return renderInfo;
    }
}
