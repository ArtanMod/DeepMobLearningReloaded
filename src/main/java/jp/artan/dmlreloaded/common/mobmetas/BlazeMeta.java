package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.level.Level;

public class BlazeMeta extends MobMetaData {
    static String[] mobTrivia = {"Bring buckets, and watch in despair", "as it evaporates, and everything is on fire", "You are on fire"};

    BlazeMeta(int numberOfHearts, int interfaceScale, int interfaceOffsetX, int interfaceOffsetY) {
        super(
                MobKey.BLAZE,
                "Blaze",
                "Blazes",
                numberOfHearts,
                interfaceScale,
                interfaceOffsetX,
                interfaceOffsetY,
                ItemInit.LivingMatter.HELLISH.get(),
                ItemInit.PristineMatter.BLAZE.get(),
                mobTrivia
        );
    }

    public Blaze getEntity(Level world) {
        return new Blaze(EntityType.BLAZE, world);
    }
}
