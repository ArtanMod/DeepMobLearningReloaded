package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.util.RenderInfo;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.joml.Quaternionf;

public class EnderDragonMeta extends MobMetaData{
    public EnderDragonMeta() {
        super(
                MobKey.ENDER_DRAGON,
                "entity.minecraft.ender_dragon",
                4096, 100,
                ItemInit.PristineMatter.ENDER_DRAGON.get(),
                null,
                2
        );
    }

    public EnderDragon getEntity(Level world) {
        return new EnderDragon(EntityType.ENDER_DRAGON ,world);
    }

    @Override
    public ItemStack getSpawnEgg() {
        return ItemStack.EMPTY;
    }

    @Override
    public int getOffsetY(LivingEntity livingEntity) {
        return 15;
    }

    @Override
    public RenderInfo transform(RenderInfo renderInfo, LivingEntity entity) {
        PoseStack modelViewStack = RenderSystem.getModelViewStack();
        modelViewStack.mulPose(Axis.XP.rotationDegrees(20.0F));
        modelViewStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        renderInfo.pitch = -renderInfo.pitch - 80;
        modelViewStack.mulPose(Axis.YN.rotationDegrees(((float)(renderInfo.yaw < 90 ? (renderInfo.yaw < -90 ? 90 : -renderInfo.yaw) : -90) / 2.0F)));
        return renderInfo;
    }
}
