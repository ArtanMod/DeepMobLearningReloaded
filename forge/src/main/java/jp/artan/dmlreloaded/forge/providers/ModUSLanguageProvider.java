package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUSLanguageProvider;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.forge.plugin.PluginInit;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.data.DataGenerator;

public class ModUSLanguageProvider extends AbstractUSLanguageProvider {
    public ModUSLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void addTranslations() {
        super.addTranslations();
        addTranslationsToolTip();
        addTranslationsCurios();
        addPatchouliLang();
        addTranslationJEI();

        // ItemGroup
        add(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED, "Deep Mob Learning: Reloaded");
    }

    /**
     * ToolTip
     */
    private void addTranslationsToolTip() {
        this.add(this.createToolTip("data_model.data.collected"), "Data collected: %1$s/%2$s");
        this.add(this.createToolTip("data_model.data.killmultiplier"), "Data per kill: %1$s");
        this.add(this.createToolTip("data_model.rfcost"), "Simulation cost: %1$s RF/t");
        this.add(this.createToolTip("data_model.tier"), "Tier: %1$s");
        this.add(this.createToolTip("data_model.type_text"), "Type: %1$s");
        this.add(this.createToolTip("data_model_upgrade.desc"), "Creative only");
        this.add(this.createToolTip("data_model_upgrade.tier"), "Can be upgraded to data model grade%1$s.");
        this.add(this.createToolTip("deep_learner.data_model_slots"), "Data model stored in data model.");
        this.add(this.createToolTip("deep_learner.data_model_slots_empty"), "Nothing stored.");
        this.add(this.createToolTip("gui.deep_learner.collect_data"), "Your data models will collect data");
        this.add(this.createToolTip("gui.deep_learner.hp"), "Life points");
        this.add(this.createToolTip("gui.deep_learner.in_order"), "In order to collect data, you must");
        this.add(this.createToolTip("gui.deep_learner.insert"), "Please insert a Data Model!");
        this.add(this.createToolTip("gui.deep_learner.killing_blow"), "deliver the killing blow.");
        this.add(this.createToolTip("gui.deep_learner.max"), "Maximum tier achieved");
        this.add(this.createToolTip("gui.deep_learner.not_found"), "No data model stored");
        this.add(this.createToolTip("gui.deep_learner.overlay"), "%1$s Model");
        this.add(this.createToolTip("gui.deep_learner.when_placed"), "when they are placed in the deep learner.");
        this.add(this.createToolTip("gui.defeated"), "%1$s defeated: %2$s");
        this.add(this.createToolTip("gui.energy.energystored"), "%1$s/%2$s RF");
        this.add(this.createToolTip("gui.extraction_chamber.opcost"), "Operational cost: %1$s RF/t");
        this.add(this.createToolTip("gui.information"), "Information");
        this.add(this.createToolTip("gui.mob.blaze.trivia.0"), "Bring buckets, and watch in despair");
        this.add(this.createToolTip("gui.mob.blaze.trivia.1"), "as it evaporates, and everything is on fire");
        this.add(this.createToolTip("gui.mob.blaze.trivia.2"), "You are on fire");
        this.add(this.createToolTip("gui.mob.creeper.trivia.0"), "Will blow up your base if");
        this.add(this.createToolTip("gui.mob.creeper.trivia.1"), "left unattended.");
        this.add(this.createToolTip("gui.mob.ender_dragon.trivia.0"), "Resides in the end, does not harbor treasure");
        this.add(this.createToolTip("gui.mob.ender_dragon.trivia.1"), "Destroy its crystals, break the cycle.");
        this.add(this.createToolTip("gui.mob.enderman.trivia.0"), "Friendly unless provoked, dislikes rain.");
        this.add(this.createToolTip("gui.mob.enderman.trivia.1"), "Teleports short distances");
        this.add(this.createToolTip("gui.mob.ghast.trivia.0"), "If you hear something that sounds like");
        this.add(this.createToolTip("gui.mob.ghast.trivia.1"), "a crying llama, you're probably hearing a ghast");
        this.add(this.createToolTip("gui.mob.guardian.trivia.0"), "Lurking in the oceans.");
        this.add(this.createToolTip("gui.mob.guardian.trivia.1"), "Uses some sort of sonar beam as");
        this.add(this.createToolTip("gui.mob.guardian.trivia.2"), "a means of attack");
        this.add(this.createToolTip("gui.mob.shulker.trivia.0"), "Found in End cities");
        this.add(this.createToolTip("gui.mob.shulker.trivia.1"), "Sneaky little buggers");
        this.add(this.createToolTip("gui.mob.skeleton.trivia.0"), "A formidable archer, which seem to be running");
        this.add(this.createToolTip("gui.mob.skeleton.trivia.1"), "some sort of cheat engine");
        this.add(this.createToolTip("gui.mob.skeleton.trivia.2"), "A shield could prove useful");
        this.add(this.createToolTip("gui.mob.slime.trivia.0"), "The bounce");
        this.add(this.createToolTip("gui.mob.slime.trivia.1"), "bounce his bounce");
        this.add(this.createToolTip("gui.mob.slime.trivia.2"), "squish - \"A slime haiku\"");
        this.add(this.createToolTip("gui.mob.spider.trivia.0"), "Nocturnal douchebags, beware");
        this.add(this.createToolTip("gui.mob.spider.trivia.1"), "Drops strands of string for some reason..");
        this.add(this.createToolTip("gui.mob.witch.trivia.0"), "Affinity with potions and concoctions");
        this.add(this.createToolTip("gui.mob.witch.trivia.1"), "Beware!");
        this.add(this.createToolTip("gui.mob.wither.trivia.0"), "Do not approach this enemy. Run!");
        this.add(this.createToolTip("gui.mob.wither.trivia.1"), "I mean it has 3 heads, what could");
        this.add(this.createToolTip("gui.mob.wither.trivia.2"), "possibly go wrong?");
        this.add(this.createToolTip("gui.mob.wither_skeleton.trivia.0"), "Inflicts the wither effect");
        this.add(this.createToolTip("gui.mob.wither_skeleton.trivia.1"), "Bring milk");
        this.add(this.createToolTip("gui.mob.zombie.trivia.0"), "They go moan in the night.");
        this.add(this.createToolTip("gui.mob.zombie.trivia.1"), "Does not understand the need for");
        this.add(this.createToolTip("gui.mob.zombie.trivia.2"), "personal space");
        this.add(this.createToolTip("gui.mob_name"), "The %1$s");
        this.add(this.createToolTip("gui.name"), "Name");
        this.add(this.createToolTip("gui.simulation_chamber.cannot_begin"), "Cannot begin simulation");
        this.add(this.createToolTip("gui.simulation_chamber.collected"), "%1$s / %2$s Data collected");
        this.add(this.createToolTip("gui.simulation_chamber.console.1"), "> Launching runtime");
        this.add(this.createToolTip("gui.simulation_chamber.console.10"), "...");
        this.add(this.createToolTip("gui.simulation_chamber.console.2"), "v1.4.7");
        this.add(this.createToolTip("gui.simulation_chamber.console.3"), "> Iteration # %1$s started");
        this.add(this.createToolTip("gui.simulation_chamber.console.4"), "> Loading model from chip memory");
        this.add(this.createToolTip("gui.simulation_chamber.console.5"), "> Assessing threat level");
        this.add(this.createToolTip("gui.simulation_chamber.console.6"), "> Engaged enemy");
        this.add(this.createToolTip("gui.simulation_chamber.console.7"), "> Pristine procurement");
        this.add(this.createToolTip("gui.simulation_chamber.console.8_failed"), "failed");
        this.add(this.createToolTip("gui.simulation_chamber.console.8_succeeded"), "succeeded");
        this.add(this.createToolTip("gui.simulation_chamber.console.9"), "> Processing results");
        this.add(this.createToolTip("gui.simulation_chamber.drain"), "Simulations with current data model drains %1$s RF/t");
        this.add(this.createToolTip("gui.simulation_chamber.insert"), "Please insert a data model");
        this.add(this.createToolTip("gui.simulation_chamber.iterations"), "Iterations: %1$s");
        this.add(this.createToolTip("gui.simulation_chamber.max_tier"), "This data model has reached the max tier.");
        this.add(this.createToolTip("gui.simulation_chamber.missing"), "Machine is missing a data model");
        this.add(this.createToolTip("gui.simulation_chamber.missing_polymer"), "Missing polymer medium");
        this.add(this.createToolTip("gui.simulation_chamber.pristine_chance"), "Pristine chance: %1$s%%");
        this.add(this.createToolTip("gui.simulation_chamber.tier1.1"), "Insufficient data in model");
        this.add(this.createToolTip("gui.simulation_chamber.tier1.2"), "please insert a basic model");
        this.add(this.createToolTip("gui.simulation_chamber.tier1.3"), "or better ");
        this.add(this.createToolTip("gui.simulation_chamber.to_begin"), "to begin the simulation");
        this.add(this.createToolTip("holdctrl"), "- hold %1$s for more info");
        this.add(this.createToolTip("holdshift"), "- hold %1$s for more info");
        this.add(this.createToolTip("hover_text.glitch_fragment_1"), "Crafted by crushing a %1$s");
        this.add(this.createToolTip("hover_text.glitch_fragment_2"), "against some %1$s (Right click)");
        this.add(this.createToolTip("hover_text.glitch_fragment_3"), "Yields 3 fragments per crushed heart");
        this.add(this.createToolTip("hover_text.glitch_fragment_4"), "Can rarly drop from hostile mobs.");
        this.add(this.createToolTip("hover_text.glitch_heart"), "Drops from System Glitches");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_1"), "Bonus while full set is equipped");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_2"), "(Bonuses are disabled during Trials)");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_3"), "  1. Certain probability of drop Pristine Matter");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_4"), "     when a Data Model gains Data.");
        this.add(this.createToolTip("hover_text.glitch_infused_armor_5"), "  2. Flight & Immunity against fall damage");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_1"), "Bonus: Quick learner");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_2"), "(Bonuses are disabled during Trials)");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_3"), "The Data gained from the demise of a mob is doubled,");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_4"), "when Data is gained there is also a small chance");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_5"), "that the sword will get a permanent damage increase.");
        this.add(this.createToolTip("hover_text.glitch_infused_sword_6"), "Current damage increase: %1$s (Max %2$s)");
        this.add(this.createToolTip("hover_text.glitchingot_1"), "Made by stabilizing %1$s");
        this.add(this.createToolTip("hover_text.more_info"), "more info found in JEI or the Guidebook");
        this.add(this.createToolTip("hover_text.soot_covered_redstone_1"), "Crafted by crushing %1$s against");
        this.add(this.createToolTip("hover_text.soot_covered_redstone_2"), "against some %1$s (Left click)");
        this.add(this.createToolTip("learning_target"), "Learning Target Mobs");
        this.add(this.createToolTip("living_matter.deeperdarker"), "Deeper Darker Matter");
        this.add(this.createToolTip("living_matter.exp"), "Experience per item: %1$s");
        this.add(this.createToolTip("living_matter.exp_consume"), "Can be consumed for expirience %1$s");
        this.add(this.createToolTip("living_matter.exp_consume_stack"), "Hold %1$s to consume entire stack.");
        this.add(this.createToolTip("living_matter.extraterrestrial"), "Extraterrestrial");
        this.add(this.createToolTip("living_matter.hellish"), "Hellish");
        this.add(this.createToolTip("living_matter.overworldian"), "Overworldian");
        this.add(this.createToolTip("messages.sword_levelup"), "Your %1$s grows in power!");
        this.add(this.createToolTip("messages.sword_levelup.max"), "Your %1$s has now reached peak performance!");
        this.add(this.createToolTip("tiers.increase_tier"), "%1$s reached the %2$s tier");
        this.add(this.createToolTip("tiers.tier"), "Model Tier: %1$s");
        this.add(this.createToolTip("tiers.tier_1"), "Faulty");
        this.add(this.createToolTip("tiers.tier_2"), "Basic");
        this.add(this.createToolTip("tiers.tier_3"), "Advanced");
        this.add(this.createToolTip("tiers.tier_4"), "Superior");
        this.add(this.createToolTip("tiers.tier_5"), "Self Aware");
        this.add(this.createToolTip("tiers.tier_next"), "Defeat %1$s more to reach %2$s");
    }

    /**
     * Curios
     */
    private void addTranslationsCurios() {
        this.add("curios.identifier.deep_learner", "Deep Learner");
    }

    /**
     * JEI
     */
    private void addTranslationJEI() {
        this.add("jei.dmlreloaded.glitch_ingot", "TLDR: Drop some fragments, lapis and gold ingots into a body of water and hope for the best\\n\\nYou've found that lapis is a good stabilization agent for Unstable glitch fragments.\\nAfter the fragments are stable, they desperately seek out a material to latch on to, you think that gold might be strong enough as a host.\\n\\nThe entire process is delicate, it needs to be performed in water or the materials wont bind properly.");
    }

    private void addPatchouliLang() {
        {
            this.add("patchouli.book.landing_text", "$(dml) adds new ways to acquire loot that normally drops from mobs, the intent is to remove the need for a big laggy mobfarm.$(br2)The mod is inspired by $(l:https://minecraft.curseforge.com/projects/soul-shards-respawn)Soul shards$() and $(l:https://minecraft.curseforge.com/projects/woot)Woot$().$(br2)This guide was written with $(l:https://minecraft.curseforge.com/projects/patchouli)Patchouli$(), a $(o)neat$() mod by $(l:https://twitter.com/Vazkii)Vazkii$().");
            this.add("patchouli.book.sub_title", "A not-so comprehensive Guide");
            {
                this.add("patchouli.category.1.introduction.title", "Introduction");
                this.add("patchouli.category.1.introduction.text", "This chapter will cover the basics of the $(item)Mod$() so you can start accumulating $(l:0_introduction/1_data)Data$() for your $(l:0_introduction/2_data_models#data_models)Data Models$().");
                {
                    this.add("patchouli.category.1.introduction.entry.1.title", "Introduction");
                    this.add("patchouli.category.1.introduction.entry.1.page.1.text", "The design principle of this $(item)Mod$() is to be a simple and$(br)lag-free alternative to gathering mob resources by traditional means.$(br2)The mods mechanics encourage players to explore and engage in combat and benefit from it later on.$(br2)To get started you will need some specialized $(item)Crafting Components$().");
                    this.add("patchouli.category.1.introduction.entry.1.page.2.text", "$(item)Soot-covered Redstone$() can be created by crushing some $(item)Redstone$() against a $(item)Block of Coal$().$(br2)This sooty marvel will be required to craft most things this $(item)Mod$() has to offer.");
                }
                {
                    this.add("patchouli.category.1.introduction.entry.2.title", "Data");
                    this.add("patchouli.category.1.introduction.entry.2.page.1.text", "Before you can start reaping the rewards you will need to collect some $(item)Data$() about a mob, the handheld device that makes that possible is called the $(item)Deep Learner$().$(br2)The $(item)Deep Learner$() is a device that can detect whenever you deliver mortal harm to a mob.");
                    this.add("patchouli.category.1.introduction.entry.2.page.2.text", "It can turn your encounter with that mob into $(item)Data$() if you have a $(l:0_introduction/2_data_models)Data model$() attached to the $(item)Deep Learner$().$(br2)The $(item)Deep Learner$() Can have 4 attached $(l:0_introduction/2_data_models)Data Models$() at any given time.");
                    this.add("patchouli.category.1.introduction.entry.2.page.3.text", "If you hold the $(item)Deep Learner$() in your $(item)Mainhand$() or $(item)Offhand$() a HUD will be displayed showing you how much more $(item)Data$() you need before you reach the next $(l:0_introduction/2_data_models)Data Model$() $(item)Tier$().");
                }
                {
                    this.add("patchouli.category.1.introduction.entry.3.title", "Data Models");
                    this.add("patchouli.category.1.introduction.entry.3.page.1.text", "You can craft a $(item)Blank Data Model$() with some of that$(br)$(l:0_introduction/0_introduction#sooted_redstone)Soot-covered Redstone$() you made earlier.");
                    this.add("patchouli.category.1.introduction.entry.3.page.2.text", "All of the $(item)Data Models$() start at the \\\"$(8)Faulty$()\\\" tier, this tier goes up as the $(item)Data Models$() gather more $(item)Data$().$(br2)As you $(item)Tier$() up you will gain more $(item)Data$() from the mobs you defeat.$(br2)$(item)Data Models$() can be put inside a $(l:1_machines/0_simulation_chamber)Simulation chamber$()");
                    this.add("patchouli.category.1.introduction.entry.3.page.3.text", "$(item)Data Models$() are split into $(item)Types$() depending on their $(item)Habitat$().$(br2)The basic $(item)Habitats$() are: $(a)Overworldian$(), $(c)Hellish$() and $(d)Extraterrestrial$().$(br2)The type of the $(item)Data Model$() will determine what kind of $(l:1_machines/1_matter#living)Living Matter$() and $(l:1_machines/1_matter#pristine)Pristine Matter$() the $(l:1_machines/0_simulation_chamber)Simulation Chamber$() will produce.");
                    this.add("patchouli.category.1.introduction.entry.3.page.4.title", "Zombie / Skeleton");
                    this.add("patchouli.category.1.introduction.entry.3.page.5.title", "Creeper / Spider");
                    this.add("patchouli.category.1.introduction.entry.3.page.6.title", "Slime / Witch");
                    this.add("patchouli.category.1.introduction.entry.3.page.7.title", "Blaze / Ghast");
                    this.add("patchouli.category.1.introduction.entry.3.page.8.title", "Wither Skeleton / Enderman");
                    this.add("patchouli.category.1.introduction.entry.3.page.9.title", "Wither / Ender Dragon");
                    this.add("patchouli.category.1.introduction.entry.3.page.10.title", "Shulker / Guardian");
                    this.add("patchouli.category.1.introduction.entry.3.page.11.title", "Elder Guardian / Evoker");
                    this.add("patchouli.category.1.introduction.entry.3.page.12.title", "Hoglin / Magma Cube");
                    this.add("patchouli.category.1.introduction.entry.3.page.13.title", "Phantom / Piglin");
                    this.add("patchouli.category.1.introduction.entry.3.page.14.title", "Ravager");
                }
            }
            {
                this.add("patchouli.category.2.introduction.title", "Machines");
                this.add("patchouli.category.2.introduction.text", "This chapter will teach you everything you need to know about the machines$(br)in $(dml)$(br2)All $(item)Machines$() accepts $(item)Inputs$() from the top of the block. The other sides are used to pipe $(item)Outputs$().");

                {
                    this.add("patchouli.category.2.introduction.entry.1.title", "Simulation Chamber");
                    this.add("patchouli.category.2.introduction.entry.1.page.1.text", "The $(item)Simulation Chamber$() is a machine that can read the information stored on your $(l:0_introduction/2_data_models)Data Models$() and from that $(l:0_introduction/1_data)Data$() create $(l:1_machines/1_matter)Matter$().$(br2)This process will add more $(l:0_introduction/1_data)Data$() to the $(l:0_introduction/2_data_models)Data Model$() currently being used.$(br2)This process also requires a $(a)Basic$() (or higher) tier$(br)$(l:0_introduction/2_data_models)Data Model$(), $(l:1_machines/3_energy)Energy$() and$(br)$(item)Polymer Clay$().");
                    this.add("patchouli.category.2.introduction.entry.1.page.2.text", "The $(item)Simulation Chamber$() is crafted with a $(l:0_introduction/0_introduction#plates_and_casings)Sooted Machine Casing$().$(br2)The operational $(item)Energy$() cost depends on what $(l:0_introduction/2_data_models)Data Model$() is used.");
                    this.add("patchouli.category.2.introduction.entry.1.page.3.text", "$(item)Polymer Clay$() is a very soft and adept clay that can take on most shapes.$(br2)In the $(item)Simulation Chamber$() its used as a binding agent to create $(l:1_machines/1_matter)Matter$()");
                }
                {
                    this.add("patchouli.category.2.introduction.entry.2.title", "Matter");
                    this.add("patchouli.category.2.introduction.entry.2.page.1.text", "There are two kinds of $(item)Matter$(), $(item)Living$() and $(item)Pristine$().$(br2)You will always get one$(br2)$(item)Living Matter$() from running a $(l:1_machines/0_simulation_chamber)Simulation$().$(br2)There is also a chance to produce $(item)Pristine Matter$(), the chance depends on the $(item)Tier$() of the $(l:0_introduction/2_data_models#data_models)Data Model$() currently in the $(l:1_machines/0_simulation_chamber)Simulation Chamber$().");
                    this.add("patchouli.category.2.introduction.entry.2.page.2.title", "Living Matter");
                    this.add("patchouli.category.2.introduction.entry.2.page.2.text", "$(item)Living Matter$() is a versatile matter that can be used to $(item)Transmute$() ingredients local to that $(item)Habitat$(), check $(item)JEI$() to see what recipes are available.$(br2)You can also consume $(item)Living Matter$() to gain $(item)Experience$().");
                    this.add("patchouli.category.2.introduction.entry.2.page.3.title", "Example Transmutes");
                    this.add("patchouli.category.2.introduction.entry.2.page.4.title", "Pristine Matter");
                    this.add("patchouli.category.2.introduction.entry.2.page.4.text", "Secondary output from the $(l:1_machines/0_simulation_chamber)Simulation Chamber$().$(br2)The type of $(item)Pristine Matter$() you will produce depends on the type of the $(l:0_introduction/2_data_models#data_models)Data Model$().$(br2)$(item)Pristine Matter$() will produce mob drops in the$(br)$(l:1_machines/2_loot_fabricator)Loot Fabricator$().");
                }
                {
                    this.add("patchouli.category.2.introduction.entry.3.title", "Loot Fabricator");
                    this.add("patchouli.category.2.introduction.entry.3.page.1.text", "The $(item)Loot Fabricator$() is a machine that can well.... $(item)Fabricate Loot$() from the various accessible $(item)Pristine Matters$().$(br2)This process requires $(l:1_machines/3_energy)Energy$() aswell as a selected $(item)Item$() to produce $(item)Loot$().");
                    this.add("patchouli.category.2.introduction.entry.3.page.2.text", "The selected $(item)Item$() will be remembered for automation puposes, it will stay selected until its unselected.");
                }
                {
                    this.add("patchouli.category.2.introduction.entry.4.title", "Energy");
                    this.add("patchouli.category.2.introduction.entry.4.page.1.title", "Energy");
                    this.add("patchouli.category.2.introduction.entry.4.page.1.text", "This mod adds no way of producing $(item)Energy$(), so you will need some sort of $(item)Generator$() from another mod to power the $(item)Machines$().");
                    this.add("patchouli.category.2.introduction.entry.4.page.2.title", "Power Units");
                    this.add("patchouli.category.2.introduction.entry.4.page.2.text", "Both $(item)Forge Energy (FE)$() and $(item)Redstone Flux (RF)$() will work.$(br2)Below are some example mods that could work to power your $(item)Machines$().$(br2)$(l:https://www.curseforge.com/minecraft/mc-mods/simple-generators)Simple Generators$() (Misc)$(br)$(l:https://www.curseforge.com/minecraft/mc-mods/mekanism-generators)Mekanism Generators$() (Reactors)$(br)$(l:https://minecraft.curseforge.com/projects/advanced-generators)Advanced Generators$()");
                }
            }
//            {
//                this.add("patchouli.category.3.title", "Mod Collaboration");
//                this.add("patchouli.category.3.description", "DeepMobLearningReloaded works with several mods. there are different levels of mod linkage. $(br2)Level1 is a linkage that adds mobs to the existing data model as mobs to be defeated or monster drops that can be produced with pristine matter. $(br2)Level2 is a linkage that adds data models and pristine matter for mobs that are added by the target mod.");
//                {
//                    this.add("patchouli.category.3.entry.1.title", "Twilight Forest");
//                    this.add("patchouli.category.3.entry.1.page.1.text", "Collaboration Level2$(br2)In the Twilight Forest, data models for seven new boss monsters will be added.");
//                    this.add("patchouli.category.3.entry.1.page.2.title", "Naga / Lich");
//                    this.add("patchouli.category.3.entry.1.page.3.title", "Minoshroom / Hydra");
//                    this.add("patchouli.category.3.entry.1.page.4.title", "Knight Phantom / Ur Ghast");
//                    this.add("patchouli.category.3.entry.1.page.5.title", "Alpha Yeti");
//                }
//                {
//                    this.add("patchouli.category.3.entry.2.title", "DeeperAndDarker");
//                    this.add("patchouli.category.3.entry.2.page.1.text", "Collaboration Level2$(br2)In the DeeperAndDarker, data models for 3 new boss monsters will be added.");
//                    this.add("patchouli.category.3.entry.2.page.2.title", "Shattered / Sculk Centipede");
//                    this.add("patchouli.category.3.entry.2.page.3.title", "Stalker");
//                }
//            }
        }
    }

    private String createToolTip(String key) {
        return DeepMobLearningReloadedMod.MOD_ID + "." + key;
    }
}
