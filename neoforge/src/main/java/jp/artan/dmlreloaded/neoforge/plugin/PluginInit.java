package jp.artan.dmlreloaded.neoforge.plugin;

import dev.architectury.platform.Platform;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.CataclysmPlugin;
import jp.artan.dmlreloaded.neoforge.plugin.DeeperAndDarker.DeeperAndDarkerPlugin;
import jp.artan.dmlreloaded.neoforge.plugin.DivineRPG.DivineRPGPlugin;
import jp.artan.dmlreloaded.neoforge.plugin.curios.CuriosPlugin;
import jp.artan.dmlreloaded.neoforge.plugin.mekanism.MekanismPlugin;
import jp.artan.dmlreloaded.neoforge.plugin.reliquary.ReliquaryPlugin;
import net.minecraftforge.eventbus.api.IEventBus;

public class PluginInit {
    public static final boolean RELIQUARY_ACTIVE = Platform.isModLoaded(ReliquaryPlugin.NAME);
    public static final boolean DIVINE_RPG_ACTIVE = Platform.isModLoaded(DivineRPGPlugin.NAME);
    public static final boolean MEKANISM_ACTIVE = Platform.isModLoaded(MekanismPlugin.NAME);
    public static final boolean CURIOS_ACTIVE = Platform.isModLoaded(CuriosPlugin.NAME);
    public static final boolean DEEP_AND_DARKER_ACTIVE = Platform.isModLoaded(DeeperAndDarkerPlugin.NAME);
    public static final boolean CATACLYSM_ACTIVE = Platform.isModLoaded(CataclysmPlugin.NAME);

    public static void init(IEventBus modEventBus) {
        if (RELIQUARY_ACTIVE) {
            ReliquaryPlugin.init();
        }
        if (DIVINE_RPG_ACTIVE) {
            DivineRPGPlugin.init();
        }
        if (MEKANISM_ACTIVE) {
            MekanismPlugin.init();
        }
        if (CURIOS_ACTIVE) {
            CuriosPlugin.init(modEventBus);
        }
        if (DEEP_AND_DARKER_ACTIVE) {
            DeeperAndDarkerPlugin.init();
        }
//        if (CATACLYSM_ACTIVE) {
//            CataclysmPlugin.init(modEventBus);
//        }
    }
}
