package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PhantomMeta extends MobMetaData {
    public PhantomMeta() {
        super(
                MobKey.PHANTOM,
                "entity.minecraft.phantom",
                512, 10,
                ItemInit.PristineMatter.PHANTOM.get(),
                Items.PHANTOM_SPAWN_EGG
        );
    }

    public Phantom getEntity(Level world) {
        return new Phantom(EntityType.PHANTOM , world);
    }

    @Override
    public void setPose(PoseStack poseStack, int xPos, int yPos, Level world) {
        poseStack.scale(0.9F, 0.9F, -0.9F);
    }
}
