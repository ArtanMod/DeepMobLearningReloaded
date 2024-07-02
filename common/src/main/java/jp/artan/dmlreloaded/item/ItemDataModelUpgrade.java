package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.util.MathHelper;
import jp.artan.dmlreloaded.util.TierHelper;
import net.minecraft.world.item.Item;

public class ItemDataModelUpgrade extends Item {
    private final int nextTier;
    public ItemDataModelUpgrade(Properties properties, int nextTier) {
        super(properties);
        this.nextTier = MathHelper.ensureRange(nextTier, 0, TierHelper.getMaxTier());
    }

    public int getNextTier() {
        return this.nextTier;
    }
}
