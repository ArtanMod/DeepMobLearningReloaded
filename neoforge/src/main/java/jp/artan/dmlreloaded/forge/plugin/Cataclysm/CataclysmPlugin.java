package jp.artan.dmlreloaded.forge.plugin.Cataclysm;

import jp.artan.dmlreloaded.forge.plugin.Cataclysm.init.DMLIntegrationLCItems;
import net.minecraftforge.eventbus.api.IEventBus;

public class CataclysmPlugin {
    public static final String NAME = "cataclysm";

    public static void init(IEventBus modEventBus) {
        DMLIntegrationLCItems.register();
    }
}
