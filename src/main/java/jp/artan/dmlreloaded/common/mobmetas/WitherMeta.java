package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WitherMeta extends MobMetaData {
    public WitherMeta() {
        super(
                MobKey.WITHER,
                "entity.minecraft.wither",
                2048, 150,
                ItemInit.PristineMatter.WITHER.get(),
                null,
                1
        );
    }
    public WitherBoss getEntity(Level world) {
        return new WitherBoss(EntityType.WITHER,world) {
        };
    }

    @Override
    public ItemStack getSpawnEgg() {
        return ItemStack.EMPTY;
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
        poseStack.scale(0.7F, 0.7F, -0.7F);
        poseStack.translate((double)(xPos-68), (double)(yPos- 87 + Math.sin(world.getGameTime()/13.0d)*3.0d), 1050.0D);
    }
}
