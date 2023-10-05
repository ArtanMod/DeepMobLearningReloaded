package jp.artan.dmlreloaded.plugin.twilight.common.mobmetas;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.plugin.twilight.common.TwilightMobKey;
import jp.artan.dmlreloaded.plugin.twilight.init.TwilightItemInit;
import jp.artan.dmlreloaded.util.RenderInfo;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import twilightforest.init.TFEntities;
import twilightforest.entity.TFEntityNames;

public class MinoshroomMeta extends TwilightMobMetaData {
    public MinoshroomMeta() {
        super(
                TwilightMobKey.MINOSHROOM,
                "entity.twilightforest.minoshroom",
                4096, 120,
                TwilightItemInit.PristineMatter.MINOSHROOM.get(),
                TFEntityNames.MINOSHROOM
        );
    }

    @Override
    public LivingEntity getEntity(Level world) {
        return TFEntities.MINOSHROOM.get().create(world);
    }

    @Override
    public RenderInfo transform(RenderInfo renderInfo, LivingEntity entity) {
        PoseStack modelViewStack = RenderSystem.getModelViewStack();
        modelViewStack.scale(0.8F, 0.8F, -0.8F);
        return renderInfo;
    }
}
