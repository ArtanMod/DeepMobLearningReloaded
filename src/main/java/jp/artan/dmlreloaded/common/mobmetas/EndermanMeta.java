package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.joml.Quaternionf;

public class EndermanMeta extends MobMetaData {
    public EndermanMeta() {
        super(
                MobKey.ENDERMAN,
                "entity.minecraft.enderman",
                512, 20,
                ItemInit.PristineMatter.ENDERMAN.get(),
                Items.ENDERMAN_SPAWN_EGG,
                2
        );
    }

    public EnderMan getEntity(Level world) {
        return new EnderMan(EntityType.ENDERMAN, world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(1.02F, 1.02F, -1.02F);
        poseStack.translate((double)(xPos-68), (double)(yPos- 99 + Math.sin(world.getGameTime()/13.0d)*0.00001d), 0.0D);
    }
}
