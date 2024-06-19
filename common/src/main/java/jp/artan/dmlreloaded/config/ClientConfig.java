package jp.artan.dmlreloaded.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import jp.artan.artansprojectcoremod.config.ModConfigs;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;

public class ClientConfig extends ModConfigs {
    private static final ClientConfig config = new ClientConfig();

    public static ConfigEntry<Integer> guiOverlayHorizontalSpacing;
    public static ConfigEntry<Integer> guiOverlaySide;
    public static ConfigEntry<Integer> guiOverlayVerticalSpacing;

    protected ClientConfig() {
        super(DeepMobLearningReloadedMod.MOD_ID + "/client.toml");
    }

    @Override
    protected void read(CommentedFileConfig commentedFileConfig) {
        guiOverlayHorizontalSpacing = ModConfigs.defineEntry("guiOverlayHorizontalSpacing", commentedFileConfig, 0)
                .comment("The horizontal spacing between the overlay and the screen edge.");
        guiOverlaySide = ModConfigs.defineEntry("guiOverlaySide", commentedFileConfig, 0)
                .comment("The horizontal spacing between the overlay and the screen edge.");
        guiOverlayVerticalSpacing = ModConfigs.defineEntry("guiOverlayVerticalSpacing", commentedFileConfig, 0, 0, 3)
                .comment("The horizontal spacing between the overlay and the screen edge.");
    }

    public static void init() {
        ClientConfig.config.read();
    }
}
