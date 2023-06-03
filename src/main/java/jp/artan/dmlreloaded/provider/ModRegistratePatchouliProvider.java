package jp.artan.dmlreloaded.provider;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.builder.PatchouliBuilder;
import jp.artan.dmlreloaded.data.providers.RegistratePatchouliProvider;
import jp.artan.dmlreloaded.init.ItemGroupInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class ModRegistratePatchouliProvider extends RegistratePatchouliProvider {
    public ModRegistratePatchouliProvider(String modid, DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(modid, pGenerator, existingFileHelper);
    }

    @Override
    protected void registerPatchouli(Consumer<PatchouliBuilder.Result> consumer) {
        this.book("book")
                .book().properties(
                        p -> p.setName("Deep Mob Learning")
                                .setLandingText("$(dml) adds new ways to acquire loot that normally drops from mobs, the intent is to remove the need for a big laggy mobfarm.$(br2)The mod is inspired by $(l:https://minecraft.curseforge.com/projects/soul-shards-respawn)Soul shards$() and $(l:https://minecraft.curseforge.com/projects/woot)Woot$().$(br2)This guide was written with $(l:https://minecraft.curseforge.com/projects/patchouli)Patchouli$(), a $(o)neat$() mod by $(l:https://twitter.com/Vazkii)Vazkii$().")
                                .setBookTexture(DeepMobLearningReloaded.getResource("textures/gui/patchouli/book_gray.png"))
                                .setCrafterTexture(DeepMobLearningReloaded.getResource("textures/gui/patchouli/crafting.png"))
                                .setModel(DeepMobLearningReloaded.getResource("book"))
                                .setTextColor(0xDDDDDD)
                                .setHeaderColor(0x16EFF7)
                                .setNameplateColor(0x16EFF7)
                                .setLinkColor(0x16EFF7)
                                .setLinkHoverColor(0x00FFC0)
                                .setHiddenShowProgress()
                                .setSubtitle("A not-so comprehensive Guide")
                                .setCreativeTab(ItemGroupInit.DEEP_MOB_LEARNING_RELOADED)
                                .addMacros("$(primary)", "$(#16EFF7)")
                                .addMacros("$(item)", "$(#ff8c00)")
                                .addMacros("$(dml)", "$(l:https://minecraft.curseforge.com/projects/deep-mob-learning)Deep Mob Learning$()")
                                .addMacros("$(dmlbm)", "$(l:https://minecraft.curseforge.com/projects/deep-mob-learning-blood-magic-addon)Deep Mob Learning - BM Addon$()")
                                .setI18n()
                ).build()
                .save(consumer);
    }
}
