package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUDLanguageProvider;
import jp.artan.artansprojectcoremod.utils.lang.LangUtils;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import net.minecraft.data.DataGenerator;

public class ModUDLanguageProvider extends AbstractUDLanguageProvider {
    public ModUDLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void addTranslations() {
        super.addTranslations();
        addTranslationsToolTip();

        // ItemGroup
        add(DMLCreativeTab.DEEP_MOB_LEARNING_RELOADED, LangUtils.toUpsideDownEnglish("Deep Mob Learning: Reloaded"));
    }

    /**
     * ToolTip
     */
    private void addTranslationsToolTip() {
        this.add(this.createToolTip("data_model.data.collected"), LangUtils.toUpsideDownEnglish("Data collected: %1$s/%2$s"));
        this.add(this.createToolTip("data_model.data.killmultiplier"), LangUtils.toUpsideDownEnglish("Data per kill: %1$s"));
        this.add(this.createToolTip("data_model.rfcost"), LangUtils.toUpsideDownEnglish("Simulation cost: %1$s RF/t"));
        this.add(this.createToolTip("data_model.tier"), LangUtils.toUpsideDownEnglish("Tier: %1$s"));
        this.add(this.createToolTip("data_model.type_text"), LangUtils.toUpsideDownEnglish("Type: %1$s"));
        this.add(this.createToolTip("gui.deep_learner.collect_data"), LangUtils.toUpsideDownEnglish("Your data models will collect data"));
        this.add(this.createToolTip("gui.deep_learner.hp"), LangUtils.toUpsideDownEnglish("Life points"));
        this.add(this.createToolTip("gui.deep_learner.in_order"), LangUtils.toUpsideDownEnglish("In order to collect data, you must"));
        this.add(this.createToolTip("gui.deep_learner.insert"), LangUtils.toUpsideDownEnglish("Please insert a Data Model!"));
        this.add(this.createToolTip("gui.deep_learner.killing_blow"), LangUtils.toUpsideDownEnglish("deliver the killing blow."));
        this.add(this.createToolTip("gui.deep_learner.max"), LangUtils.toUpsideDownEnglish("Maximum tier achieved"));
        this.add(this.createToolTip("gui.deep_learner.not_found"), LangUtils.toUpsideDownEnglish("No Data Model Found"));
        this.add(this.createToolTip("gui.deep_learner.overlay"), LangUtils.toUpsideDownEnglish("%1$s Model"));
        this.add(this.createToolTip("gui.deep_learner.when_placed"), LangUtils.toUpsideDownEnglish("when they are placed in the deep learner."));
        this.add(this.createToolTip("gui.defeated"), LangUtils.toUpsideDownEnglish("%1$s defeated: %2$s"));
        this.add(this.createToolTip("gui.energy.energystored"), LangUtils.toUpsideDownEnglish("%1$s/%2$s RF"));
        this.add(this.createToolTip("gui.extraction_chamber.opcost"), LangUtils.toUpsideDownEnglish("Operational cost: %1$s RF/t"));
        this.add(this.createToolTip("gui.information"), LangUtils.toUpsideDownEnglish("Information"));
        this.add(this.createToolTip("gui.mob.blaze.trivia.0"), LangUtils.toUpsideDownEnglish("Bring buckets, and watch in despair"));
        this.add(this.createToolTip("gui.mob.blaze.trivia.1"), LangUtils.toUpsideDownEnglish("as it evaporates, and everything is on fire"));
        this.add(this.createToolTip("gui.mob.blaze.trivia.2"), LangUtils.toUpsideDownEnglish("You are on fire"));
        this.add(this.createToolTip("gui.mob.creeper.trivia.0"), LangUtils.toUpsideDownEnglish("Will blow up your base if"));
        this.add(this.createToolTip("gui.mob.creeper.trivia.1"), LangUtils.toUpsideDownEnglish("left unattended."));
        this.add(this.createToolTip("gui.mob.ender_dragon.trivia.0"), LangUtils.toUpsideDownEnglish("Resides in the end, does not harbor treasure"));
        this.add(this.createToolTip("gui.mob.ender_dragon.trivia.1"), LangUtils.toUpsideDownEnglish("Destroy its crystals, break the cycle."));
        this.add(this.createToolTip("gui.mob.enderman.trivia.0"), LangUtils.toUpsideDownEnglish("Friendly unless provoked, dislikes rain."));
        this.add(this.createToolTip("gui.mob.enderman.trivia.1"), LangUtils.toUpsideDownEnglish("Teleports short distances"));
        this.add(this.createToolTip("gui.mob.ghast.trivia.0"), LangUtils.toUpsideDownEnglish("If you hear something that sounds like"));
        this.add(this.createToolTip("gui.mob.ghast.trivia.1"), LangUtils.toUpsideDownEnglish("a crying llama, you're probably hearing a ghast"));
        this.add(this.createToolTip("gui.mob.guardian.trivia.0"), LangUtils.toUpsideDownEnglish("Lurking in the oceans."));
        this.add(this.createToolTip("gui.mob.guardian.trivia.1"), LangUtils.toUpsideDownEnglish("Uses some sort of sonar beam as"));
        this.add(this.createToolTip("gui.mob.guardian.trivia.2"), LangUtils.toUpsideDownEnglish("a means of attack"));
        this.add(this.createToolTip("gui.mob.shulker.trivia.0"), LangUtils.toUpsideDownEnglish("Found in End cities"));
        this.add(this.createToolTip("gui.mob.shulker.trivia.1"), LangUtils.toUpsideDownEnglish("Sneaky little buggers"));
        this.add(this.createToolTip("gui.mob.skeleton.trivia.0"), LangUtils.toUpsideDownEnglish("A formidable archer, which seem to be running"));
        this.add(this.createToolTip("gui.mob.skeleton.trivia.1"), LangUtils.toUpsideDownEnglish("some sort of cheat engine"));
        this.add(this.createToolTip("gui.mob.skeleton.trivia.2"), LangUtils.toUpsideDownEnglish("A shield could prove useful"));
        this.add(this.createToolTip("gui.mob.slime.trivia.0"), LangUtils.toUpsideDownEnglish("The bounce"));
        this.add(this.createToolTip("gui.mob.slime.trivia.1"), LangUtils.toUpsideDownEnglish("bounce his bounce"));
        this.add(this.createToolTip("gui.mob.slime.trivia.2"), LangUtils.toUpsideDownEnglish("squish - \"A slime haiku\""));
        this.add(this.createToolTip("gui.mob.spider.trivia.0"), LangUtils.toUpsideDownEnglish("Nocturnal douchebags, beware"));
        this.add(this.createToolTip("gui.mob.spider.trivia.1"), LangUtils.toUpsideDownEnglish("Drops strands of string for some reason.."));
        this.add(this.createToolTip("gui.mob.witch.trivia.0"), LangUtils.toUpsideDownEnglish("Affinity with potions and concoctions"));
        this.add(this.createToolTip("gui.mob.witch.trivia.1"), LangUtils.toUpsideDownEnglish("Beware!"));
        this.add(this.createToolTip("gui.mob.wither.trivia.0"), LangUtils.toUpsideDownEnglish("Do not approach this enemy. Run!"));
        this.add(this.createToolTip("gui.mob.wither.trivia.1"), LangUtils.toUpsideDownEnglish("I mean it has 3 heads, what could"));
        this.add(this.createToolTip("gui.mob.wither.trivia.2"), LangUtils.toUpsideDownEnglish("possibly go wrong?"));
        this.add(this.createToolTip("gui.mob.wither_skeleton.trivia.0"), LangUtils.toUpsideDownEnglish("Inflicts the wither effect"));
        this.add(this.createToolTip("gui.mob.wither_skeleton.trivia.1"), LangUtils.toUpsideDownEnglish("Bring milk"));
        this.add(this.createToolTip("gui.mob.zombie.trivia.0"), LangUtils.toUpsideDownEnglish("They go moan in the night."));
        this.add(this.createToolTip("gui.mob.zombie.trivia.1"), LangUtils.toUpsideDownEnglish("Does not understand the need for"));
        this.add(this.createToolTip("gui.mob.zombie.trivia.2"), LangUtils.toUpsideDownEnglish("personal space"));
        this.add(this.createToolTip("gui.mob_name"), LangUtils.toUpsideDownEnglish("The %1$s"));
        this.add(this.createToolTip("gui.name"), LangUtils.toUpsideDownEnglish("Name"));
        this.add(this.createToolTip("gui.simulation_chamber.cannot_begin"), LangUtils.toUpsideDownEnglish("Cannot begin simulation"));
        this.add(this.createToolTip("gui.simulation_chamber.collected"), LangUtils.toUpsideDownEnglish("%1$s / %2$s Data collected"));
        this.add(this.createToolTip("gui.simulation_chamber.console.1"), LangUtils.toUpsideDownEnglish("> Launching runtime"));
        this.add(this.createToolTip("gui.simulation_chamber.console.10"), LangUtils.toUpsideDownEnglish("..."));
        this.add(this.createToolTip("gui.simulation_chamber.console.2"), LangUtils.toUpsideDownEnglish("v1.4.7"));
        this.add(this.createToolTip("gui.simulation_chamber.console.3"), LangUtils.toUpsideDownEnglish("> Iteration # %1$s started"));
        this.add(this.createToolTip("gui.simulation_chamber.console.4"), LangUtils.toUpsideDownEnglish("> Loading model from chip memory"));
        this.add(this.createToolTip("gui.simulation_chamber.console.5"), LangUtils.toUpsideDownEnglish("> Assessing threat level"));
        this.add(this.createToolTip("gui.simulation_chamber.console.6"), LangUtils.toUpsideDownEnglish("> Engaged enemy"));
        this.add(this.createToolTip("gui.simulation_chamber.console.7"), LangUtils.toUpsideDownEnglish("> Pristine procurement"));
        this.add(this.createToolTip("gui.simulation_chamber.console.8_failed"), LangUtils.toUpsideDownEnglish("failed"));
        this.add(this.createToolTip("gui.simulation_chamber.console.8_succeeded"), LangUtils.toUpsideDownEnglish("succeeded"));
        this.add(this.createToolTip("gui.simulation_chamber.console.9"), LangUtils.toUpsideDownEnglish("> Processing results"));
        this.add(this.createToolTip("gui.simulation_chamber.drain"), LangUtils.toUpsideDownEnglish("Simulations with current data model drains %1$s RF/t"));
        this.add(this.createToolTip("gui.simulation_chamber.insert"), LangUtils.toUpsideDownEnglish("Please insert a data model"));
        this.add(this.createToolTip("gui.simulation_chamber.iterations"), LangUtils.toUpsideDownEnglish("Iterations: %1$s"));
        this.add(this.createToolTip("gui.simulation_chamber.max_tier"), LangUtils.toUpsideDownEnglish("This data model has reached the max tier."));
        this.add(this.createToolTip("gui.simulation_chamber.missing"), LangUtils.toUpsideDownEnglish("Machine is missing a data model"));
        this.add(this.createToolTip("gui.simulation_chamber.missing_polymer"), LangUtils.toUpsideDownEnglish("Missing polymer medium"));
        this.add(this.createToolTip("gui.simulation_chamber.pristine_chance"), LangUtils.toUpsideDownEnglish("Pristine chance: %1$s%%"));
        this.add(this.createToolTip("gui.simulation_chamber.tier1.1"), LangUtils.toUpsideDownEnglish("Insufficient data in model"));
        this.add(this.createToolTip("gui.simulation_chamber.tier1.2"), LangUtils.toUpsideDownEnglish("please insert a basic model"));
        this.add(this.createToolTip("gui.simulation_chamber.tier1.3"), LangUtils.toUpsideDownEnglish("or better "));
        this.add(this.createToolTip("gui.simulation_chamber.to_begin"), LangUtils.toUpsideDownEnglish("to begin the simulation"));
        this.add(this.createToolTip("holdctrl"), LangUtils.toUpsideDownEnglish("- hold %1$s for more info"));
        this.add(this.createToolTip("holdshift"), LangUtils.toUpsideDownEnglish("- hold %1$s for more info"));
        this.add(this.createToolTip("hover_text.glitch_fragment_1"), LangUtils.toUpsideDownEnglish("Crafted by crushing a %1$s"));
        this.add(this.createToolTip("hover_text.glitch_fragment_2"), LangUtils.toUpsideDownEnglish("against some %1$s (Right click)"));
        this.add(this.createToolTip("hover_text.glitch_fragment_3"), LangUtils.toUpsideDownEnglish("Yields 3 fragments per crushed heart"));
        this.add(this.createToolTip("hover_text.glitch_fragment_4"), LangUtils.toUpsideDownEnglish("Can rarly drop from hostile mobs."));
        this.add(this.createToolTip("hover_text.glitch_heart"), LangUtils.toUpsideDownEnglish("Drops from System Glitches"));
        this.add(this.createToolTip("hover_text.glitch_infused_armor_1"), LangUtils.toUpsideDownEnglish("Bonus while full set is equipped"));
        this.add(this.createToolTip("hover_text.glitch_infused_armor_2"), LangUtils.toUpsideDownEnglish("(Bonuses are disabled during Trials)"));
        this.add(this.createToolTip("hover_text.glitch_infused_armor_3"), LangUtils.toUpsideDownEnglish("  1. Certain probability of drop Pristine Matter"));
        this.add(this.createToolTip("hover_text.glitch_infused_armor_4"), LangUtils.toUpsideDownEnglish("     when a Data Model gains Data."));
        this.add(this.createToolTip("hover_text.glitch_infused_armor_5"), LangUtils.toUpsideDownEnglish("  2. Flight & Immunity against fall damage"));
        this.add(this.createToolTip("hover_text.glitch_infused_sword_1"), LangUtils.toUpsideDownEnglish("Bonus: Quick learner"));
        this.add(this.createToolTip("hover_text.glitch_infused_sword_2"), LangUtils.toUpsideDownEnglish("(Bonuses are disabled during Trials)"));
        this.add(this.createToolTip("hover_text.glitch_infused_sword_3"), LangUtils.toUpsideDownEnglish("The Data gained from the demise of a mob is doubled,"));
        this.add(this.createToolTip("hover_text.glitch_infused_sword_4"), LangUtils.toUpsideDownEnglish("when Data is gained there is also a small chance"));
        this.add(this.createToolTip("hover_text.glitch_infused_sword_5"), LangUtils.toUpsideDownEnglish("that the sword will get a permanent damage increase."));
        this.add(this.createToolTip("hover_text.glitch_infused_sword_6"), LangUtils.toUpsideDownEnglish("Current damage increase: %1$s (Max %2$s)"));
        this.add(this.createToolTip("hover_text.glitchingot_1"), LangUtils.toUpsideDownEnglish("Made by stabilizing %1$s"));
        this.add(this.createToolTip("hover_text.more_info"), LangUtils.toUpsideDownEnglish("more info found in JEI or the Guidebook"));
        this.add(this.createToolTip("hover_text.soot_covered_redstone_1"), LangUtils.toUpsideDownEnglish("Crafted by crushing %1$s against"));
        this.add(this.createToolTip("hover_text.soot_covered_redstone_2"), LangUtils.toUpsideDownEnglish("against some %1$s (Left click)"));
        this.add(this.createToolTip("learning_target"), LangUtils.toUpsideDownEnglish("Learning Target Mobs"));
        this.add(this.createToolTip("living_matter.deeperdarker"), LangUtils.toUpsideDownEnglish("Deeper Darker Matter"));
        this.add(this.createToolTip("living_matter.exp"), LangUtils.toUpsideDownEnglish("Experience per item: %1$s"));
        this.add(this.createToolTip("living_matter.exp_consume"), LangUtils.toUpsideDownEnglish("Can be consumed for expirience %1$s"));
        this.add(this.createToolTip("living_matter.exp_consume_stack"), LangUtils.toUpsideDownEnglish("Hold %1$s to consume entire stack."));
        this.add(this.createToolTip("living_matter.extraterrestrial"), LangUtils.toUpsideDownEnglish("Extraterrestrial"));
        this.add(this.createToolTip("living_matter.hellish"), LangUtils.toUpsideDownEnglish("Hellish"));
        this.add(this.createToolTip("living_matter.overworldian"), LangUtils.toUpsideDownEnglish("Overworldian"));
        this.add(this.createToolTip("messages.sword_levelup"), LangUtils.toUpsideDownEnglish("Your %1$s grows in power!"));
        this.add(this.createToolTip("messages.sword_levelup.max"), LangUtils.toUpsideDownEnglish("Your %1$s has now reached peak performance!"));
        this.add(this.createToolTip("tiers.increase_tier"), LangUtils.toUpsideDownEnglish("%1$s reached the %2$s tier"));
        this.add(this.createToolTip("tiers.tier"), LangUtils.toUpsideDownEnglish("Model Tier: %1$s"));
        this.add(this.createToolTip("tiers.tier_1"), LangUtils.toUpsideDownEnglish("Faulty"));
        this.add(this.createToolTip("tiers.tier_2"), LangUtils.toUpsideDownEnglish("Basic"));
        this.add(this.createToolTip("tiers.tier_3"), LangUtils.toUpsideDownEnglish("Advanced"));
        this.add(this.createToolTip("tiers.tier_4"), LangUtils.toUpsideDownEnglish("Superior"));
        this.add(this.createToolTip("tiers.tier_5"), LangUtils.toUpsideDownEnglish("Self Aware"));
        this.add(this.createToolTip("tiers.tier_next"), LangUtils.toUpsideDownEnglish("Defeat %1$s more to reach %2$s"));
    }

    private String createToolTip(String key) {
        return DeepMobLearningReloadedMod.MOD_ID + "." + key;
    }
}
