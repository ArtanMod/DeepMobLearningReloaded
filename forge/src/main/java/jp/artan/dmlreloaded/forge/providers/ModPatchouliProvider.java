package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.RegistratePatchouliProvider;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.init.DMLBlocksForge;
import jp.artan.dmlreloaded.forge.init.DMLItemsForge;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class ModPatchouliProvider extends RegistratePatchouliProvider {
    public ModPatchouliProvider(boolean pRun, String modid, DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(pRun, modid, pGenerator, existingFileHelper);
    }

    @Override
    protected void registerPatchouli(Consumer<RegistratePatchouliProvider.Result> consumer) {
        this.book("book")
                .book().properties(
                        p -> p.setName("Deep Mob Learning", "patchouli.book.landing_text")
                                .setBookTexture(DeepMobLearningReloadedMod.getResource("textures/gui/patchouli/book_gray.png"))
                                .setCrafterTexture(DeepMobLearningReloadedMod.getResource("textures/gui/patchouli/crafting.png"))
                                .setModel(DeepMobLearningReloadedMod.getResource("book"))
                                .setTextColor(0xDDDDDD)
                                .setHeaderColor(0x16EFF7)
                                .setNameplateColor(0x16EFF7)
                                .setLinkColor(0x16EFF7)
                                .setLinkHoverColor(0x00FFC0)
                                .setShowProgress(false)
                                .setSubtitle("patchouli.book.sub_title")
                                .setCreativeTab(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED)
                                .addMacros("$(primary)", "$(#16EFF7)")
                                .addMacros("$(item)", "$(#ff8c00)")
                                .addMacros("$(dml)", "$(l:https://minecraft.curseforge.com/projects/deep-mob-learning)Deep Mob Learning$()")
                                .addMacros("$(dmlbm)", "$(l:https://minecraft.curseforge.com/projects/deep-mob-learning-blood-magic-addon)Deep Mob Learning - BM Addon$()")
                                .setI18n(true)
                ).shapelessRecipe().properties(
                        p -> p.requires(Items.BOOK)
                                .requires(DMLItems.SOOT_COVERED_REDSTONE.get())
                ).build().build()
                .categories()
                .addCategory(
                        "Introduction",
                        "patchouli.category.1.introduction.title",
                        "patchouli.category.1.introduction.text",
                        DMLItemsForge.DEEP_LEARNER
                )
                .entries()
                .addEntry("Introduction", "patchouli.category.1.introduction.entry.1.title", DMLItems.SOOT_COVERED_REDSTONE).properties(p -> {
                    p.addTextPage("patchouli.category.1.introduction.entry.1.page.1.text")
                            .build();
                    p.addSpotlightPage(DMLItems.SOOT_COVERED_REDSTONE)
                            .setTitle("item.dmlreloaded.soot_covered_redstone")
                            .setAnchor("sooted_redstone")
                            .setText("patchouli.category.1.introduction.entry.1.page.2.text")
                            .build();
                    p.addCraftingRecipePage(DMLItems.SOOT_COVERED_PLATE)
                            .setRecipe2(DMLBlocksForge.MACHINE_CASING)
                            .build();
                    return p;
                }).build()
                .addEntry("Data", "patchouli.category.1.introduction.entry.2.title", DMLItemsForge.DEEP_LEARNER).properties(p -> {
                    p.addTextPage("patchouli.category.1.introduction.entry.2.page.1.text")
                            .build();
                    p.addCraftingRecipePage(DMLItemsForge.DEEP_LEARNER)
                            .setText("patchouli.category.1.introduction.entry.2.page.2.text")
                            .build();
                    p.addSpotlightPage(DMLItemsForge.DEEP_LEARNER)
                            .setText("patchouli.category.1.introduction.entry.2.page.3.text")
                            .build();
                    return p;
                }).build()
                .addEntry("Data Models", "patchouli.category.1.introduction.entry.3.title", DMLItems.DATA_MODEL_GUARDIAN).properties(p -> {
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_BLANK)
                            .setText("patchouli.category.1.introduction.entry.3.page.1.text")
                            .build();
                    p.addSpotlightPage(DMLItems.DATA_MODEL_GUARDIAN)
                            .setAnchor("data_models")
                            .setText("patchouli.category.1.introduction.entry.3.page.2.text")
                            .build();
                    p.addTextPage("patchouli.category.1.introduction.entry.3.page.3.text")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_ZOMBIE)
                            .setRecipe2(DMLItems.DATA_MODEL_SKELETON)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.4.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_CREEPER)
                            .setRecipe2(DMLItems.DATA_MODEL_SPIDER)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.5.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_SLIME)
                            .setRecipe2(DMLItems.DATA_MODEL_WITCH)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.6.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_BLAZE)
                            .setRecipe2(DMLItems.DATA_MODEL_GHAST)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.7.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_WITHER_SKELETON)
                            .setRecipe2(DMLItems.DATA_MODEL_ENDERMAN)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.8.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_WITHER)
                            .setRecipe2(DMLItems.DATA_MODEL_ENDER_DRAGON)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.9.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_SHULKER)
                            .setRecipe2(DMLItems.DATA_MODEL_ELDER_GUARDIAN)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.10.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_ELDER_GUARDIAN)
                            .setRecipe2(DMLItems.DATA_MODEL_EVOKER)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.11.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_HOGLIN)
                            .setRecipe2(DMLItems.DATA_MODEL_MAGMA_CUBE)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.12.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_PHANTOM)
                            .setRecipe2(DMLItems.DATA_MODEL_PIGLIN)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.13.title")
                            .build();
                    p.addCraftingRecipePage(DMLItems.DATA_MODEL_RAVAGER)
                            .setTitle("patchouli.category.1.introduction.entry.3.page.14.title")
                            .build();
                    return p;
                }).build()
                .build()
                .build()
                .addCategory(
                        "Machines",
                        "patchouli.category.2.introduction.title",
                        "patchouli.category.2.introduction.text",
                        DMLBlocksForge.SIMULATION_CHAMBER
                )
                .entries()
                .addEntry("Simulation Chamber", "patchouli.category.2.introduction.entry.1.title", DMLBlocksForge.SIMULATION_CHAMBER).properties(p -> {
                    p.addTextPage("patchouli.category.2.introduction.entry.1.page.1.text")
                            .build();
                    p.addCraftingRecipePage(DMLBlocksForge.SIMULATION_CHAMBER)
                            .setAnchor("simulation_chamber")
                            .setText("patchouli.category.2.introduction.entry.1.page.2.text")
                            .build();
                    p.addCraftingRecipePage(DMLItems.POLYMER_CLAY)
                            .setAnchor("simulation_chamber")
                            .setText("patchouli.category.2.introduction.entry.1.page.3.text")
                            .build();
                return p;
                }).build()
                .addEntry("Matter", "patchouli.category.2.introduction.entry.2.title", DMLItems.LIVING_MATTER_HELLISH).properties(p -> {
                    p.addTextPage("patchouli.category.2.introduction.entry.2.page.1.text")
                            .build();
                    p.addSpotlightPage(DMLItems.LIVING_MATTER_HELLISH)
                            .setTitle("patchouli.category.2.introduction.entry.2.page.2.title")
                            .setAnchor("living")
                            .setText("patchouli.category.2.introduction.entry.2.page.2.text")
                            .build();
                    p.addCraftingRecipePage(DeepMobLearningReloadedMod.getResource("soul_sand_from_hellish_living_matter"))
                            .setTitle("patchouli.category.2.introduction.entry.2.page.3.title")
                            .setRecipe2(DeepMobLearningReloadedMod.getResource("ender_pearl_from_extraterrestrial_living_matter"))
                            .setAnchor("living_transmute")
                            .build();
                    p.addSpotlightPage(DMLItems.DATA_MODEL_ZOMBIE)
                            .setTitle("patchouli.category.2.introduction.entry.2.page.4.title")
                            .setAnchor("pristine")
                            .setText("patchouli.category.2.introduction.entry.2.page.4.text")
                            .build();
                    return p;
                }).build()
                .addEntry("Loot Fabricator", "patchouli.category.2.introduction.entry.3.title", DMLBlocksForge.EXTRACTION_CHAMBER).properties(p -> {
                    p.addTextPage("patchouli.category.2.introduction.entry.3.page.1.text")
                            .build();
                    p.addCraftingRecipePage(DMLBlocksForge.EXTRACTION_CHAMBER)
                            .setText("patchouli.category.2.introduction.entry.3.page.2.text")
                            .build();
                    return p;
                }).build()
                .addEntry("Energy", "patchouli.category.2.introduction.entry.4.title", "minecraft:redstone").properties(p -> {
                    p.addSpotlightPage("minecraft:redstone")
                            .setTitle("patchouli.category.2.introduction.entry.4.page.1.title")
                            .setText("patchouli.category.2.introduction.entry.4.page.1.text")
                            .build();
                    p.addTextPage("patchouli.category.2.introduction.entry.4.page.2.text")
                            .setTitle("patchouli.category.2.introduction.entry.4.page.2.title")
                            .build();
                    return p;
                }).build()
                .build()
                .build()
//                .addCategory(
//                        "Collaboration",
//                        "patchouli.category.3.title",
//                        "patchouli.category.3.description",
//                        ItemInit.GLITCH_HEART
//                )
//                .properties(p -> p.setFlag("mod:twilightforest"))
//                .entries()
//                .addEntry("Twilight Forest", "patchouli.category.3.entry.1.title", TwilightItemInit.DataModel.NAGA).properties(p -> {
//                    p.addTextPage("patchouli.category.3.entry.1.page.1.text")
//                            .build();
//                    p.addCraftingRecipePage(TwilightItemInit.DataModel.NAGA)
//                            .setRecipe2(TwilightItemInit.DataModel.LICH)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.3.entry.1.page.2.title")
//                            .build();
//                    p.addCraftingRecipePage(TwilightItemInit.DataModel.MINOSHROOM)
//                            .setRecipe2(TwilightItemInit.DataModel.HYDRA)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.3.entry.1.page.3.title")
//                            .build();
//                    p.addCraftingRecipePage(TwilightItemInit.DataModel.KNIGHT_PHANTOM)
//                            .setRecipe2(TwilightItemInit.DataModel.UR_GHAST)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.3.entry.1.page.4.title")
//                            .build();
//                    p.addCraftingRecipePage(TwilightItemInit.DataModel.ALPHA_YETI)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.3.entry.1.page.5.title")
//                            .build();
//                    return p;
//                }).build()
//                .addEntry("DeeperAndDarker", "patchouli.category.3.entry.2.title", DeeperAndDarkerItemInit.DataModel.STALKER).properties(p -> {
//                    p.setFlag("mod:deeperdarker");
//                    p.addTextPage("patchouli.category.3.entry.2.page.1.text")
//                            .build();
//                    p.addCraftingRecipePage(DeeperAndDarkerItemInit.DataModel.SHATTERED)
//                            .setRecipe2(DeeperAndDarkerItemInit.DataModel.SCULK_CENTIPEDE)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.3.entry.2.page.2.title")
//                            .build();
//                    p.addCraftingRecipePage(DeeperAndDarkerItemInit.DataModel.STALKER)
//                            .setFlag("mod:twilightforest")
//                            .setTitle("patchouli.category.3.entry.2.page.3.title")
//                            .build();
//                    return p;
//                }).build()
//                .build()
//                .build()
                .build()
                .getTemplates()
                .build()
                .save(consumer);
    }
}
