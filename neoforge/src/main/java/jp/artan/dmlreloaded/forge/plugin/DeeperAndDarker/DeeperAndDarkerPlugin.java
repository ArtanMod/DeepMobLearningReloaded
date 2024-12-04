package jp.artan.dmlreloaded.forge.plugin.DeeperAndDarker;

import com.kyanite.deeperdarker.content.DDItems;
import jp.artan.dmlreloaded.common.MobKey;
import jp.artan.dmlreloaded.forge.plugin.DeeperAndDarker.init.DMLIntegrationDADItems;
import net.minecraft.world.item.ItemStack;

public class DeeperAndDarkerPlugin {
    public static final String NAME = "deeperdarker";

    public static void init() {
        DMLIntegrationDADItems.register();
        registerMobKey();
    }

    public static void registerMobKey() {
        MobKey.WARDEN.addLoot(() -> new ItemStack(DDItems.WARDEN_CARAPACE.get()));
        MobKey.WARDEN.addLoot(() -> new ItemStack(DDItems.HEART_OF_THE_DEEP.get()));
    }
}
