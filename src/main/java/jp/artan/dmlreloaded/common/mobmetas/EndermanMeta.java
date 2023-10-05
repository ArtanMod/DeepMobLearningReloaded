package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.util.RenderInfo;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

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
    public int getOffsetY(LivingEntity livingEntity) {
        return -10;
    }
}
