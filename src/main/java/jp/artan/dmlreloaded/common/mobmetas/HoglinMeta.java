package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class HoglinMeta extends MobMetaData {
    public HoglinMeta() {
        super(
                MobKey.HOGLIN,
                "entity.minecraft.hoglin",
                1024, 20,
                ItemInit.PristineMatter.HOGLIN.get(),
                Items.HOGLIN_SPAWN_EGG
        );
    }

    public Hoglin getEntity(Level world) {
        return new Hoglin(EntityType.HOGLIN , world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.9F, 0.9F, -0.9F);
    }
}
