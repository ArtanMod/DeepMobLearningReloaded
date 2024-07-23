package jp.artan.dmlreloaded.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import jp.artan.artansprojectcoremod.config.ModConfigs;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;

public class ClientConfig extends ModConfigs {
    private static final ClientConfig config = new ClientConfig();

    public static ConfigEntry<Integer> guiOverlayHorizontalSpacing;
    public static ConfigEntry<Integer> guiOverlaySide;
    public static ConfigEntry<Integer> guiOverlayVerticalSpacing;
    public static ConfigEntry<Boolean> curiosIntegrationDefaultOverlay;

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
        curiosIntegrationDefaultOverlay = ModConfigs.defineEntry("curiosIntegrationDefaultOverlay", commentedFileConfig, true)
                .comment("Whether the overlay should be shown by default when using the Curios integration. Specify false if you want to hide the UI by default, such as when the UI overlaps. If hidden, it can be made visible by pressing Ctrl.");
    }

    public static void init() {
        ClientConfig.config.read();
    }
}
