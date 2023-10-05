package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import jp.artan.dmlreloaded.util.RenderInfo;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.entity.TFEntityNames;
import twilightforest.init.TFEntities;

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
    public RenderInfo transform(RenderInfo renderInfo, LivingEntity entity) {
        PoseStack modelViewStack = RenderSystem.getModelViewStack();
        modelViewStack.scale(0.7F, 0.7F, -0.7F);
        return renderInfo;
    }
}
