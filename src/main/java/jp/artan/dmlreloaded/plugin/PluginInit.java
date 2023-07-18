package jp.artan.dmlreloaded.plugin;

import jp.artan.dmlreloaded.plugin.twilight.TwilightPlugin;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

public class PluginInit {
    public static final boolean TWILIGHT_ACTIVE = ModList.get().isLoaded(TwilightPlugin.NAME);

    public static void init(IEventBus modEventBus){
        if (TWILIGHT_ACTIVE) {
//            TwilightPlugin.init(modEventBus);
        }
    }
}
