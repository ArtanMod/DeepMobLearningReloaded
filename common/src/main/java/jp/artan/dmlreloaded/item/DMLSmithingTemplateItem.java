package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class DMLSmithingTemplateItem extends SmithingTemplateItem {
    // FIXME: 以下ChatFormattingはSmithingTemplateItemから参照するようにAccessWinderを用いて行えるように修正する
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component GLITCH_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", DeepMobLearningReloadedMod.getResource("glitch_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component GLITCH_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", DeepMobLearningReloadedMod.getResource("smithing_template.glitch_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GLITCH_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", DeepMobLearningReloadedMod.getResource("smithing_template.glitch_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GLITCH_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", DeepMobLearningReloadedMod.getResource("smithing_template.glitch_upgrade.base_slot_description")));
    private static final Component GLITCH_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", DeepMobLearningReloadedMod.getResource("smithing_template.glitch_upgrade.additions_slot_description")));
    // FIXME: 以下すべてはSmithingTemplateItemから参照するようにAccessWinderを用いて行えるように修正する, createNetheriteUpgradeIconList and createNetheriteUpgradeMaterialList
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");

    public DMLSmithingTemplateItem(Component appliesTo, Component ingredients, Component updradeDescription, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additonalSlotEmptyIcons) {
        super(appliesTo, ingredients, updradeDescription, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additonalSlotEmptyIcons);
    }

    public static DMLSmithingTemplateItem createGlitchUpgradeTemplate() {
        return new DMLSmithingTemplateItem(
                GLITCH_UPGRADE_APPLIES_TO,
                GLITCH_UPGRADE_INGREDIENTS,
                GLITCH_UPGRADE,
                GLITCH_UPGRADE_BASE_SLOT_DESCRIPTION,
                GLITCH_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createGlitchUpgradeIconList(),
                createGlitchUpgradeMaterialList()
        );
    }

    private static List<ResourceLocation> createGlitchUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    private static List<ResourceLocation> createGlitchUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
