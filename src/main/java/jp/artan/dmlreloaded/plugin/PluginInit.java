package jp.artan.dmlreloaded.plugin;

import jp.artan.dmlreloaded.plugin.curios.CuriosPlugin;
import jp.artan.dmlreloaded.plugin.mekanism.MekanismPlugin;
import jp.artan.dmlreloaded.plugin.reliquary.ReliquaryPlugin;
import jp.artan.dmlreloaded.plugin.twilight.TwilightPlugin;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

public class PluginInit {
    public static final boolean TWILIGHT_ACTIVE = ModList.get().isLoaded(TwilightPlugin.NAME);
    public static final boolean RELIQUARY_ACTIVE = ModList.get().isLoaded(ReliquaryPlugin.NAME);
    public static final boolean MEKANISM_ACTIVE = ModList.get().isLoaded(MekanismPlugin.NAME);
    public static final boolean CURIOS_ACTIVE = ModList.get().isLoaded(CuriosPlugin.NAME);

    public static void init(IEventBus modEventBus){
//        if (TWILIGHT_ACTIVE) {
//            TwilightPlugin.init(modEventBus);
//        }
        if (RELIQUARY_ACTIVE) {
            ReliquaryPlugin.init(modEventBus);
        }
        if (MEKANISM_ACTIVE) {
            MekanismPlugin.init(modEventBus);
        }
        if (CURIOS_ACTIVE) {
            CuriosPlugin.init(modEventBus);
        }
    }
}
