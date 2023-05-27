package jp.artan.dmlreloaded.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    public static ForgeConfigSpec.IntValue guiOverlayHorizontalSpacing; //0
    public static ForgeConfigSpec.IntValue guiOverlaySide; //topleft
    public static ForgeConfigSpec.IntValue guiOverlayVerticalSpacing; //0

    public static void registerClientConfig(ForgeConfigSpec.Builder CLIENT_BUILDER) {
        CLIENT_BUILDER.comment("Balance the game mechanics").push("client");
        guiOverlayHorizontalSpacing = CLIENT_BUILDER.defineInRange("guiOverlayHorizontalSpacing", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        guiOverlayVerticalSpacing = CLIENT_BUILDER.defineInRange("guiOverlayVerticalSpacing", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        guiOverlaySide = CLIENT_BUILDER.comment("values: topleft = 0/topright = 1/bottomleft = 2/bottomright = 3").defineInRange("guiOverlaySide", 0, 0, 3);
        CLIENT_BUILDER.pop();
    }

}

