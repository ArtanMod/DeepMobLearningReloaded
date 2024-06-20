package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUSLanguageProvider;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.data.DataGenerator;

public class ModUSLanguageProvider extends AbstractUSLanguageProvider {
    public ModUSLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void addTranslations() {
        super.addTranslations();

        // ItemGroup
        add(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED, "Deep Mob Learning: Reloaded");
    }
}
