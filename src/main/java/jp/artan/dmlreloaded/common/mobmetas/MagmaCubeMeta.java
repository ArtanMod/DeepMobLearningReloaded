package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class MagmaCubeMeta extends MobMetaData {
    public MagmaCubeMeta() {
        super(
                MobKey.MAGMA_CUBE,
                "entity.minecraft.magma_cube",
                150, 8,
                ItemInit.PristineMatter.MAGMA_CUBE.get(),
                Items.MAGMA_CUBE_SPAWN_EGG
        );
    }

    public MagmaCube getEntity(Level world) {
        return new MagmaCube(EntityType.MAGMA_CUBE , world);
    }

    @Override
    public Quaternion getEntityXRotation() {
        return Vector3f.XP.rotationDegrees(180.0F);
    }

    @Override
    public Quaternion getEntityZRotation() {
        return Vector3f.ZP.rotationDegrees(0.0F);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(2F, 2F, -2F);
        poseStack.translate((double)(xPos-68), (double)(yPos- 110 + Math.sin(world.getGameTime()/13.0d)*3.0d), 0.0D);
    }
}
