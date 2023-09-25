package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.joml.Quaternionf;

public class MagmaCubeMeta extends MobMetaData {
    public MagmaCubeMeta() {
        super(
                MobKey.MAGMA_CUBE,
                "entity.minecraft.magma_cube",
                150, 8,
                ItemInit.PristineMatter.MAGMA_CUBE.get(),
                Items.MAGMA_CUBE_SPAWN_EGG
        );
    }

    public MagmaCube getEntity(Level world) {
        return new MagmaCube(EntityType.MAGMA_CUBE , world);
    }

}
