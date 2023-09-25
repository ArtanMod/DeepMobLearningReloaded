package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.joml.Quaternionf;

public class SlimeMeta extends MobMetaData {
    public SlimeMeta() {
        super(
                MobKey.SLIME,
                "entity.minecraft.slime",
                150, 8,
                ItemInit.PristineMatter.SLIME.get(),
                Items.SLIME_SPAWN_EGG,
                3
        );
    }

    public Slime getEntity(Level world) {
        return new Slime(EntityType.SLIME, world);
    }
}
