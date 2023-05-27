package jp.artan.dmlreloaded.config;

import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.LivingMatterType;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.HashMap;

public class LivingExpConfig {

    private static HashMap<ILivingMatterType, ForgeConfigSpec.IntValue> livingHashMap = new HashMap();

    public static void registerLivingMatterType(ILivingMatterType type, ForgeConfigSpec.IntValue config) {
        livingHashMap.put(type, config);
    }

    public static void registerServerConfig(ForgeConfigSpec.Builder SERVER_BUILDER) {
        SERVER_BUILDER.comment("Balance the EXP received from using Living Matter Item").push("living_matter");
        registerLivingMatterType(LivingMatterType.OVERWORLDIAN, SERVER_BUILDER.defineInRange("livingOverworldian", 10, 0, 999));
        registerLivingMatterType(LivingMatterType.HELLISH, SERVER_BUILDER.defineInRange("livingHellish", 14, 0, 999));
        registerLivingMatterType(LivingMatterType.EXTRATERRESTRIAL, SERVER_BUILDER.defineInRange("livingExtraterrestrial", 20, 0, 999));
        SERVER_BUILDER.pop();
    }

    public static final int getExp(ILivingMatterType type) {
        try {
            ForgeConfigSpec.IntValue value = livingHashMap.get(type);
            return value.get();
        } catch(Exception e) {
            return 0;
        }
    }
}
