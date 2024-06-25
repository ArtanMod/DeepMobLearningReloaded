package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractItemModelProvider;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends AbstractItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerStandardItem();
        registerDataModel();
        registerPristineMatter();
        registerLivingMatter();
    }

    /**
     * 標準アイテム
     */
    private void registerStandardItem() {
        this.basicItem(DMLItems.SOOT_COVERED_REDSTONE.get());
        this.basicItem(DMLItems.SOOT_COVERED_PLATE.get());
        this.basicItem(DMLItems.GLITCH_FRAGMENT.get());
        this.basicItem(DMLItems.GLITCH_HEART.get());
        this.basicItem(DMLItems.GLITCH_INGOT.get());
        this.basicItem(DMLItems.NETHERITE_GLITCH_INGOT.get());
        this.basicItem(DMLItems.POLYMER_CLAY.get());
//        this.basicItem(DMLItems.GLITCH_SWORD.get());
//        this.basicItem(DMLItems.NETHERITE_GLITCH_SWORD.get());
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
