package jp.artan.dmlreloaded.plugin.tconstruct.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.plugin.tconstruct.common.TiCMobKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TinkerSlimeMeta extends MobMetaData {
    public TinkerSlimeMeta() {
        super(
                TiCMobKey.SLIME,
                "entity.tconstruct.sky_slime",
                150, 8,
//                TiCItemInit.PristineMatter.BLUE_SLIME.get(),
                null,
                null
        );
    }

    public Slime getEntity(Level world) {
        return new Slime(EntityType.SLIME, world);
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
        poseStack.scale(2F, 2F, -2F);
        poseStack.translate((double)(xPos-68), (double)(yPos- 110 + Math.sin(world.getGameTime()/13.0d)*3.0d), 0.0D);
    }
}
