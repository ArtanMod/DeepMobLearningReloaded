package jp.artan.dmlreloaded.config;

import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.MobKey;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MobConfig {
    private static HashMap<IMobKey, ForgeConfigSpec.ConfigValue<List<? extends String>>> ACCEPTEDMOBS = new HashMap<>();
    private static HashMap<IMobKey, ForgeConfigSpec.ConfigValue<List<? extends String>>> PRISTINELOOT = new HashMap<>();

    public static void addMobConfig(
            IMobKey mobKey,
            ForgeConfigSpec.ConfigValue<List<? extends String>> mobs,
            ForgeConfigSpec.ConfigValue<List<? extends String>> loot
    ) {
        ACCEPTEDMOBS.put(mobKey, mobs);
        PRISTINELOOT.put(mobKey, loot);
    }

    public static void registerCommonConfig(ForgeConfigSpec.Builder COMMON_BUILDER) {
        COMMON_BUILDER.comment("Add custom mob to count for data learning.",
                "IMPORTANT NOTICE:",
                "THIS IS ONLY THE COMMON CONFIG. It does not contain all the values adjustable for DMLReforged.",
                "All modifiers for machines, and most other adjustable values have been moved to dmlreforged-server.toml.",
                "That file is PER WORLD, meaning you have to go into 'saves/<world name>/serverconfig' to adjust it. Those changes will then only apply for THAT WORLD.",
                "You can then take that config file and put it in the 'defaultconfigs' folder to make it apply automatically to all NEW worlds you generate FROM THERE ON.",
                "This may appear confusing to many of you, but it is a new sensible way to handle configuration, because the server configuration is synced when playing multiplayer.",
                "- Credit for this notification: BluSunrize (ImmersiveEngineering)").push("mob_registry");
        COMMON_BUILDER.push("mobs");
        addMobConfig(
                MobKey.BLAZE,
                COMMON_BUILDER.defineList("blaze", MobKey.BLAZE.getMobs(), o -> o instanceof String),
                COMMON_BUILDER.defineList("blaze", MobKey.BLAZE.getLoot(), o -> o instanceof String)
        );
    }

    public static List<? extends String> getMobs(IMobKey mobKey) {
        try {
            return ACCEPTEDMOBS.get(mobKey).get();
        } catch(Exception e) {
            return new ArrayList<>();
        }
    }
}
