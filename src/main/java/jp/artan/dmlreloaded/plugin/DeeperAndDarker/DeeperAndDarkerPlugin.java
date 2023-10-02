package jp.artan.dmlreloaded.plugin.DeeperAndDarker;

import com.kyanite.deeperdarker.registry.items.DDItems;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.init.DeeperAndDarkerItemInit;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;

public class DeeperAndDarkerPlugin {
    public static final String NAME = "deeperdarker";

    public static void init(IEventBus modEventBus) {
        DeeperAndDarkerItemInit.register();
        registerMobKey();
    }

    public static void registerMobKey() {
        MobKey.WARDEN.addLoot(() -> new ItemStack(DDItems.WARDEN_CARAPACE.get()));
        MobKey.WARDEN.addLoot(() -> new ItemStack(DDItems.HEART_OF_THE_DEEP.get()));
    }
}
