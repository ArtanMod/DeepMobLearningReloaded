package jp.artan.dmlreloaded.plugin;

import jp.artan.dmlreloaded.plugin.tconstruct.TiCPlugin;
import jp.artan.dmlreloaded.plugin.twilight.TwilightPlugin;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

public class PluginInit {
    public static final boolean TWILIGHT_ACTIVE = ModList.get().isLoaded(TwilightPlugin.NAME);
    public static final boolean TIC_ACTIVE = ModList.get().isLoaded(TiCPlugin.NAME);

    public static void init(IEventBus modEventBus){
        TwilightPlugin.init(modEventBus);
        TiCPlugin.init(modEventBus);
    }
}
