package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
    public Quaternionf getEntityXRotation() {
        return (new Quaternionf()).rotateX(10.0F);
//        return Vector3f.XP.rotationDegrees(10.0F);
    }

    @Override
    public Quaternionf getEntityZRotation() {
        return (new Quaternionf()).rotateZ(180.0F);
//        return Vector3f.ZP.rotationDegrees(180.0F);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.19F, 0.19F, -0.19F);
        poseStack.translate((double)xPos-67, (double)yPos - 200 + Math.sin(world.getGameTime()/13.0d)*3.0d, 1050.0D);
    }
}
