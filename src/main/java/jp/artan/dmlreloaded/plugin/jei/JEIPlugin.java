package jp.artan.dmlreloaded.plugin.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return DeepMobLearningReloadedRecipeCategoryUid.pluginUid;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
    }
}

