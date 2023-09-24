package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.joml.Quaternionf;

public class SpiderMeta extends MobMetaData {
    public SpiderMeta() {
        super(
                MobKey.SPIDER,
                "entity.minecraft.spider",
                80, 8,
                ItemInit.PristineMatter.SPIDER.get(),
                Items.SPIDER_SPAWN_EGG,
                2
        );
    }

    public Spider getEntity(Level world) {
        return new Spider(EntityType.SPIDER, world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(1.02F, 1.02F, -1.02F);
        poseStack.translate((double)(xPos-68), (double)(yPos- 110 + Math.sin(world.getGameTime()/13.0d)*3.0d), 0.0D);
    }
}
