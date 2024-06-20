package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractUSLanguageProvider;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
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
        this.add(this.createToolTip("gui.deep_learner.collect_data"), "Your data models will collect data");
        this.add(this.createToolTip("gui.deep_learner.hp"), "Life points");
        this.add(this.createToolTip("gui.deep_learner.in_order"), "In order to collect data, you must");
        this.add(this.createToolTip("gui.deep_learner.insert"), "Please insert a Data Model!");
        this.add(this.createToolTip("gui.deep_learner.killing_blow"), "deliver the killing blow.");
        this.add(this.createToolTip("gui.deep_learner.max"), "Maximum tier achieved");
        this.add(this.createToolTip("gui.deep_learner.not_found"), "No Data Model Found");
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

    private String createToolTip(String key) {
        return DeepMobLearningReloadedMod.MOD_ID + "." + key;
    }
}
