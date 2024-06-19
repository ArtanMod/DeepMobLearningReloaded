package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.common.IMobKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemPristineMatter extends Item {
    private final IMobKey mobKey;

    public ItemPristineMatter(Properties properties, IMobKey mobKey) {
        super(properties);
        this.mobKey = mobKey;
    }

    public IMobKey getMobKey() {
        return mobKey;
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }
}
