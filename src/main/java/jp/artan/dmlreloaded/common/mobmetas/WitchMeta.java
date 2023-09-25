package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.joml.Quaternionf;

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
    public int getOffsetY(LivingEntity livingEntity) {
        return -5;
    }
}
