package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class WitchMeta extends MobMetaData {
    public WitchMeta() {
        super(
                MobKey.WITCH,
                "entity.minecraft.witch",
                120, 13,
                ItemInit.PristineMatter.WITCH.get(),
                Items.WITCH_SPAWN_EGG,
                2
        );
    }

    public Witch getEntity(Level world) {
        return new Witch(EntityType.WITCH, world);
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
        poseStack.scale(1.2F, 1.2F, -1.2F);
        poseStack.translate((double)(xPos-68), (double)(yPos- 97 + Math.sin(world.getGameTime()/13.0d)*0.001d), 0.0D);
    }
}
