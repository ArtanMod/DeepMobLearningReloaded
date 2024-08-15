package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractItemModelProvider;
import jp.artan.dmlreloaded.forge.init.DMLItemsForge;
import jp.artan.dmlreloaded.forge.plugin.DeeperAndDarker.init.DMLIntegrationDADItems;
import jp.artan.dmlreloaded.forge.plugin.PluginInit;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends AbstractItemModelProvider {
    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerStandardItem();
        registerDataModelUpgrade();
        registerDataModel();
        registerPristineMatter();
        registerLivingMatter();

        if(PluginInit.DEEP_AND_DARKER_ACTIVE) {
            registerPluginDeeperAndDarker();
        }
    }

    private void registerPluginDeeperAndDarker() {
        this.basicItem(DMLIntegrationDADItems.SHATTERED.get());
        this.basicItem(DMLIntegrationDADItems.SCULK_CENTIPEDE.get());
        this.basicItem(DMLIntegrationDADItems.STALKER.get());
        this.basicItem(DMLIntegrationDADItems.PRISTINE_MATTER_SHATTERED.get());
        this.basicItem(DMLIntegrationDADItems.PRISTINE_MATTER_SCULK_CENTIPEDE.get());
        this.basicItem(DMLIntegrationDADItems.PRISTINE_MATTER_STALKER.get());
        this.basicItem(DMLIntegrationDADItems.LIVING_MATTER_DEEPER_AND_DARKER.get());
    }

    /**
     * 標準アイテム
     */
    private void registerStandardItem() {
        this.basicItem(DMLItems.SOOT_COVERED_REDSTONE.get());
        this.basicItem(DMLItems.SOOT_COVERED_PLATE.get());
        this.basicItem(DMLItemsForge.GLITCH_FRAGMENT.get());
        this.basicItem(DMLItems.GLITCH_HEART.get());
        this.basicItem(DMLItems.GLITCH_INGOT.get());
        this.basicItem(DMLItems.NETHERITE_GLITCH_INGOT.get());
        this.basicItem(DMLItems.POLYMER_CLAY.get());
        this.basicArmorItems(DMLItems.GLITCH_ARMOR);
        this.basicArmorItems(DMLItems.NETHERITE_GLITCH_ARMOR);
        this.basicItem(DMLItems.GLITCH_UPGRADE_SMITHING_TEMPLATE.get());
        this.basicItem(DMLItemsForge.GLITCH_SWORD.get());
        this.basicItem(DMLItemsForge.NETHERITE_GLITCH_SWORD.get());
        this.basicItem(DMLItemsForge.DEEP_LEARNER.get());
        this.basicItem(DMLItemsForge.NETHERITE_DEEP_LEARNER.get());
    }

    /**
     * アップグレードデータモデル
     */
    private void registerDataModelUpgrade() {
        this.basicItem(DMLItems.DATA_MODEL_UPGRADE_TIER1.get());
        this.basicItem(DMLItems.DATA_MODEL_UPGRADE_TIER2.get());
        this.basicItem(DMLItems.DATA_MODEL_UPGRADE_TIER3.get());
        this.basicItem(DMLItems.DATA_MODEL_UPGRADE_TIER4.get());
    }

    /**
     * データモデル
     */
    private void registerDataModel() {
        this.basicItem(DMLItems.DATA_MODEL_BLANK.get());
        this.basicItem(DMLItems.DATA_MODEL_BLAZE.get());
        this.basicItem(DMLItems.DATA_MODEL_CREEPER.get());
        this.basicItem(DMLItems.DATA_MODEL_ENDER_DRAGON.get());
        this.basicItem(DMLItems.DATA_MODEL_ELDER_GUARDIAN.get());
        this.basicItem(DMLItems.DATA_MODEL_ENDERMAN.get());
        this.basicItem(DMLItems.DATA_MODEL_EVOKER.get());
        this.basicItem(DMLItems.DATA_MODEL_GHAST.get());
        this.basicItem(DMLItems.DATA_MODEL_GUARDIAN.get());
        this.basicItem(DMLItems.DATA_MODEL_HOGLIN.get());
        this.basicItem(DMLItems.DATA_MODEL_MAGMA_CUBE.get());
        this.basicItem(DMLItems.DATA_MODEL_PHANTOM.get());
        this.basicItem(DMLItems.DATA_MODEL_PIGLIN.get());
        this.basicItem(DMLItems.DATA_MODEL_RAVAGER.get());
        this.basicItem(DMLItems.DATA_MODEL_SHULKER.get());
        this.basicItem(DMLItems.DATA_MODEL_SKELETON.get());
        this.basicItem(DMLItems.DATA_MODEL_SLIME.get());
        this.basicItem(DMLItems.DATA_MODEL_SPIDER.get());
        this.basicItem(DMLItems.DATA_MODEL_WARDEN.get());
        this.basicItem(DMLItems.DATA_MODEL_WITCH.get());
        this.basicItem(DMLItems.DATA_MODEL_WITHER_SKELETON.get());
        this.basicItem(DMLItems.DATA_MODEL_WITHER.get());
        this.basicItem(DMLItems.DATA_MODEL_ZOMBIE.get());
    }

    /**
     * マター
     */
    private void registerPristineMatter() {
        this.basicItem(DMLItems.PRISTINE_MATTER_BLAZE.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_CREEPER.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_ENDER_DRAGON.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_ELDER_GUARDIAN.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_ENDERMAN.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_EVOKER.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_GHAST.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_GUARDIAN.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_HOGLIN.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_MAGMA_CUBE.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_PHANTOM.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_PIGLIN.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_RAVAGER.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_SHULKER.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_SKELETON.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_SLIME.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_SPIDER.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_WARDEN.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_WITCH.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_WITHER_SKELETON.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_WITHER.get());
        this.basicItem(DMLItems.PRISTINE_MATTER_ZOMBIE.get());
    }

    /**
     * 環境マター
     */
    private void registerLivingMatter() {
        this.basicItem(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get());
        this.basicItem(DMLItems.LIVING_MATTER_HELLISH.get());
        this.basicItem(DMLItems.LIVING_MATTER_OVERWORLDIAN.get());
    }
}
