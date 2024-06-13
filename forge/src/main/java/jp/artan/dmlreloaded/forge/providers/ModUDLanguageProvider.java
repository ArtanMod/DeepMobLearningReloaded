package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUDLanguageProvider;
import net.minecraft.data.DataGenerator;

public class ModUDLanguageProvider extends AbstractUDLanguageProvider {
    public ModUDLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void addTranslations() {
        super.addTranslations();

        // ItemGroup
    }
}
