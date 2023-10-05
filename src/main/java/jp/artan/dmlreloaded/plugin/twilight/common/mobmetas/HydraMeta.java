package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import jp.artan.dmlreloaded.util.RenderInfo;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.entity.TFEntityNames;

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
    public RenderInfo transform(RenderInfo renderInfo, LivingEntity entity) {
        PoseStack modelViewStack = RenderSystem.getModelViewStack();
        modelViewStack.scale(0.3F, 0.3F, -0.3F);
        return renderInfo;
    }
}
