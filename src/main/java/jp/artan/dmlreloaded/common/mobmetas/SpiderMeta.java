package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

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
}
