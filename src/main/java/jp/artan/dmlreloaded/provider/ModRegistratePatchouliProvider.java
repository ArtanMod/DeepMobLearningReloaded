package jp.artan.dmlreloaded.provider;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.data.providers.RegistratePatchouliProvider;
import jp.artan.dmlreloaded.init.BlockInit;
import jp.artan.dmlreloaded.init.ItemGroupInit;
import jp.artan.dmlreloaded.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class ModRegistratePatchouliProvider extends RegistratePatchouliProvider {
    public ModRegistratePatchouliProvider(String modid, DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(modid, pGenerator, existingFileHelper);
    }

    @Override
    protected void registerPatchouli(Consumer<RegistratePatchouliProvider.Result> consumer) {
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
                                .setShowProgress(false)
                                .setSubtitle("A not-so comprehensive Guide")
                                .setCreativeTab(ItemGroupInit.DEEP_MOB_LEARNING_RELOADED)
                                .addMacros("$(primary)", "$(#16EFF7)")
                                .addMacros("$(item)", "$(#ff8c00)")
                                .addMacros("$(dml)", "$(l:https://minecraft.curseforge.com/projects/deep-mob-learning)Deep Mob Learning$()")
                                .addMacros("$(dmlbm)", "$(l:https://minecraft.curseforge.com/projects/deep-mob-learning-blood-magic-addon)Deep Mob Learning - BM Addon$()")
                                .setI18n(true)
                ).shapelessRecipe().properties(
                        p -> p.requires(Items.BOOK)
                                .requires(ItemInit.SOOT_COVERED_REDSTONE.get())
                ).build().build()
                .categories()
                .addCategory(
                        "Introduction",
                        "This chapter will cover the basics of the $(item)Mod$() so you can start accumulating $(l:0_introduction/1_data)Data$() for your $(l:0_introduction/2_data_models#data_models)Data Models$().",
                        ItemInit.DEEP_LEARNER
                )
                .entries()
                .addEntry("Introduction", ItemInit.SOOT_COVERED_REDSTONE).properties(p -> {
                    p.addTextPage("The design principle of this $(item)Mod$() is to be a simple and$(br)lag-free alternative to gathering mob resources by traditional means.$(br2)The mods mechanics encourage players to explore and engage in combat and benefit from it later on.$(br2)To get started you will need some specialized $(item)Crafting Components$().")
                            .build();
                    p.addSpotlightPage(ItemInit.SOOT_COVERED_REDSTONE)
                            .setTitle("Sooting Redstone")
                            .setAnchor("sooted_redstone")
                            .setText("$(item)Soot-covered Redstone$() can be created by crushing some $(item)Redstone$() against a $(item)Block of Coal$().$(br2)This sooty marvel will be required to craft most things this $(item)Mod$() has to offer.")
                            .build();
                    p.addCraftingRecipePage(ItemInit.SOOT_COVERED_PLATE)
                            .setRecipe2(BlockInit.MACHINE_CASING)
                            .build();
                    return p;
                }).build()
                .addEntry("Data", ItemInit.DEEP_LEARNER).properties(p -> {
                    p.addTextPage("Before you can start reaping the rewards you will need to collect some $(item)Data$() about a mob, the handheld device that makes that possible is called the $(item)Deep Learner$().$(br2)The $(item)Deep Learner$() is a device that can detect whenever you deliver mortal harm to a mob.")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DEEP_LEARNER)
                            .setText("It can turn your encounter with that mob into $(item)Data$() if you have a $(l:0_introduction/2_data_models)Data model$() attached to the $(item)Deep Learner$().$(br2)The $(item)Deep Learner$() Can have 4 attached $(l:0_introduction/2_data_models)Data Models$() at any given time.")
                            .build();
                    p.addSpotlightPage(ItemInit.DEEP_LEARNER)
                            .setText("If you hold the $(item)Deep Learner$() in your $(item)Mainhand$() or $(item)Offhand$() a HUD will be displayed showing you how much more $(item)Data$() you need before you reach the next $(l:0_introduction/2_data_models)Data Model$() $(item)Tier$().")
                            .build();
                    return p;
                }).build()
                .addEntry("Data Models", ItemInit.DataModel.GUARDIAN).properties(p -> {
                    p.addCraftingRecipePage(ItemInit.DataModel.BLANK)
                            .setText("You can craft a $(item)Blank Data Model$() with some of that$(br)$(l:0_introduction/0_introduction#sooted_redstone)Soot-covered Redstone$() you made earlier.")
                            .build();
                    p.addSpotlightPage(ItemInit.DataModel.GUARDIAN)
                            .setAnchor("data_models")
                            .setText("All of the $(item)Data Models$() start at the \\\"$(8)Faulty$()\\\" tier, this tier goes up as the $(item)Data Models$() gather more $(item)Data$().$(br2)As you $(item)Tier$() up you will gain more $(item)Data$() from the mobs you defeat.$(br2)$(item)Data Models$() can be put inside a $(l:1_machines/0_simulation_chamber)Simulation chamber$()")
                            .build();
                    p.addTextPage("$(item)Data Models$() are split into $(item)Types$() depending on their $(item)Habitat$().$(br2)The basic $(item)Habitats$() are: $(a)Overworldian$(), $(c)Hellish$() and $(d)Extraterrestrial$().$(br2)The type of the $(item)Data Model$() will determine what kind of $(l:1_machines/1_matter#living)Living Matter$() and $(l:1_machines/1_matter#pristine)Pristine Matter$() the $(l:1_machines/0_simulation_chamber)Simulation Chamber$() will produce.")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.ZOMBIE)
                            .setRecipe2(ItemInit.DataModel.SKELETON)
                            .setTitle("Zombie / Skeleton")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.CREEPER)
                            .setRecipe2(ItemInit.DataModel.SPIDER)
                            .setTitle("Creeper / Spider")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.SLIME)
                            .setRecipe2(ItemInit.DataModel.WITCH)
                            .setTitle("Slime / Witch")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.BLAZE)
                            .setRecipe2(ItemInit.DataModel.GHAST)
                            .setTitle("Blaze / Ghast")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.WITHER_SKELETON)
                            .setRecipe2(ItemInit.DataModel.ENDERMAN)
                            .setTitle("Wither Skeleton / Enderman")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.WITHER)
                            .setRecipe2(ItemInit.DataModel.DRAGON)
                            .setTitle("Wither / Dragon")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.SHULKER)
                            .setRecipe2(ItemInit.DataModel.GUARDIAN)
                            .setTitle("Shulker / Guardian")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.ELDER_GUARDIAN)
                            .setRecipe2(ItemInit.DataModel.EVOKER)
                            .setTitle("Elder Guardian / Evoker")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.HOGLIN)
                            .setRecipe2(ItemInit.DataModel.MAGMA_CUBE)
                            .setTitle("Hoglin / Magma Cube")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.PHANTOM)
                            .setRecipe2(ItemInit.DataModel.PIGLIN)
                            .setTitle("Phantom / Piglin")
                            .build();
                    p.addCraftingRecipePage(ItemInit.DataModel.RAVAGER)
                            .setTitle("Ravager")
                            .build();
                    return p;
                }).build()
                .build()
                .build()
                .addCategory(
                        "Machines",
                        "This chapter will teach you everything you need to know about the machines$(br)in $(dml)$(br2)All $(item)Machines$() accepts $(item)Inputs$() from the top of the block. The other sides are used to pipe $(item)Outputs$().",
                        BlockInit.SIMULATION_CHAMBER
                )
                .entries()
                .addEntry("Simulation Chamber", BlockInit.SIMULATION_CHAMBER).properties(p -> {
                    p.addTextPage("The $(item)Simulation Chamber$() is a machine that can read the information stored on your $(l:0_introduction/2_data_models)Data Models$() and from that $(l:0_introduction/1_data)Data$() create $(l:1_machines/1_matter)Matter$().$(br2)This process will add more $(l:0_introduction/1_data)Data$() to the $(l:0_introduction/2_data_models)Data Model$() currently being used.$(br2)This process also requires a $(a)Basic$() (or higher) tier$(br)$(l:0_introduction/2_data_models)Data Model$(), $(l:1_machines/3_energy)Energy$() and$(br)$(item)Polymer Clay$().")
                            .build();
                    p.addCraftingRecipePage(BlockInit.SIMULATION_CHAMBER)
                            .setAnchor("simulation_chamber")
                            .setText("The $(item)Simulation Chamber$() is crafted with a $(l:0_introduction/0_introduction#plates_and_casings)Sooted Machine Casing$().$(br2)The operational $(item)Energy$() cost depends on what $(l:0_introduction/2_data_models)Data Model$() is used.")
                            .build();
                    p.addCraftingRecipePage(ItemInit.POLYMER_CLAY)
                            .setAnchor("simulation_chamber")
                            .setText("$(item)Polymer Clay$() is a very soft and adept clay that can take on most shapes.$(br2)In the $(item)Simulation Chamber$() its used as a binding agent to create $(l:1_machines/1_matter)Matter$()")
                            .build();
                return p;
                }).build()
                .addEntry("Matter",ItemInit.LivingMatter.HELLISH).properties(p -> {
                    p.addTextPage("There are two kinds of $(item)Matter$(), $(item)Living$() and $(item)Pristine$().$(br2)You will always get one$(br)$(item)Living Matter$() from running a $(l:1_machines/0_simulation_chamber)Simulation$().$(br2)There is also a chance to produce $(item)Pristine Matter$(), the chance depends on the $(item)Tier$() of the $(l:0_introduction/2_data_models#data_models)Data Model$() currently in the $(l:1_machines/0_simulation_chamber)Simulation Chamber$().")
                            .build();
                    p.addSpotlightPage(ItemInit.LivingMatter.HELLISH)
                            .setTitle("Living Matter")
                            .setAnchor("living")
                            .setText("$(item)Living Matter$() is a versatile matter that can be used to $(item)Transmute$() ingredients local to that $(item)Habitat$(), check $(item)JEI$() to see what recipes are available.$(br2)You can also consume $(item)Living Matter$() to gain $(item)Experience$().")
                            .build();
                    p.addCraftingRecipePage(DeepMobLearningReloaded.getResource("soul_sand_from_hellish_living_matter"))
                            .setTitle("Example Transmutes")
                            .setRecipe2(DeepMobLearningReloaded.getResource("ender_pearl_from_extraterrestrial_living_matter"))
                            .setAnchor("living_transmute")
                            .build();
                    p.addSpotlightPage(ItemInit.PristineMatter.ZOMBIE)
                            .setTitle("Pristine Matter")
                            .setAnchor("pristine")
                            .setText("Secondary output from the $(l:1_machines/0_simulation_chamber)Simulation Chamber$().$(br2)The type of $(item)Pristine Matter$() you will produce depends on the type of the $(l:0_introduction/2_data_models#data_models)Data Model$().$(br2)$(item)Pristine Matter$() will produce mob drops in the$(br)$(l:1_machines/2_loot_fabricator)Loot Fabricator$().")
                            .build();
                    return p;
                }).build()
                .addEntry("Loot Fabricator", BlockInit.EXTRACTION_CHAMBER).properties(p -> {
                    p.addTextPage("The $(item)Loot Fabricator$() is a machine that can well.... $(item)Fabricate Loot$() from the various accessible $(item)Pristine Matters$().$(br2)This process requires $(l:1_machines/3_energy)Energy$() aswell as a selected $(item)Item$() to produce $(item)Loot$().")
                            .build();
                    p.addCraftingRecipePage(BlockInit.EXTRACTION_CHAMBER)
                            .setText("The selected $(item)Item$() will be remembered for automation puposes, it will stay selected until its unselected.")
                            .build();
                    return p;
                }).build()
                .addEntry("Energy", "minecraft:redstone").properties(p -> {
                    p.addSpotlightPage("minecraft:redstone")
                            .setTitle("Energy")
                            .setText("This mod adds no way of producing $(item)Energy$(), so you will need some sort of $(item)Generator$() from another mod to power the $(item)Machines$().")
                            .build();
                    p.addTextPage("Both $(item)Forge Energy (FE)$() and $(item)Redstone Flux (RF)$() will work.$(br2)Below are some example mods that could work to power your $(item)Machines$().$(br2)$(l:https://www.curseforge.com/minecraft/mc-mods/simple-generators)Simple Generators$() (Misc)$(br)$(l:https://www.curseforge.com/minecraft/mc-mods/mekanism-generators)Mekanism Generators$() (Reactors)$(br)$(l:https://minecraft.curseforge.com/projects/advanced-generators)Advanced Generators$()")
                            .setTitle("Power Units")
                            .build();
                    return p;
                }).build()
                .build()
                .build()
                .build()
                .getTemplates()
                .addTemplate("fluid_infusion").properties(p -> {
                    p.addHeaderComponent("#title").setX(-1).setY(-1).build();
                    p.addSeparatorComponent().setX(-1).setY(-1).build();
                    p.addItemComponent("#input1").setFramed(true).setX(27).setY(30).build();
                    p.addItemComponent("#input2").setFramed(true).setX(50).setY(30).build();
                    p.addItemComponent("#input3").setFramed(true).setX(73).setY(30).build();
                    p.addImageComponent("dmlreloaded:textures/gui/patchouli/arrow_down.png", 16, 16).setX(50).setY(50).setTextureWidth(16).setTextureHeight(16).build();
                    p.addImageComponent("#fluid", 16, 16).setX(50).setY(65).setTextureWidth(16).setTextureHeight(16).build();
                    p.addTooltipComponent().addTooltip("#fluidTooltip").setX(49).setY(64).setHeight(16).setWidth(16).build();
                    p.addImageComponent("dmlreloaded:textures/gui/patchouli/arrow_down.png", 16, 16).setX(50).setY(84).setTextureWidth(16).setTextureHeight(16).build();
                    p.addItemComponent("#output").setX(50).setY(102).setFramed(true).setLinkRecipe(true).build();
                    return p;
                }).build()
                .build()
                .save(consumer);
    }
}
