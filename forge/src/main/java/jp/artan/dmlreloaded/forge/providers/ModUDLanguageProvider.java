package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUDLanguageProvider;
import jp.artan.artansprojectcoremod.utils.lang.LangUtils;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.data.DataGenerator;

public class ModUDLanguageProvider extends AbstractUDLanguageProvider {
    public ModUDLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void addTranslations() {
        super.addTranslations();

        // ItemGroup
        add(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED, LangUtils.toUpsideDownEnglish("Deep Mob Learning: Reloaded"));
    }
}
