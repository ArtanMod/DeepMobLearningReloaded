package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.data.MobKey;
import net.minecraft.world.item.Item;

public class ItemDataModel extends Item {
    public final MobKey mobKey;

    public ItemDataModel(Properties properties, MobKey mobKey) {
        super(properties);
        this.mobKey = mobKey;
    }
}
