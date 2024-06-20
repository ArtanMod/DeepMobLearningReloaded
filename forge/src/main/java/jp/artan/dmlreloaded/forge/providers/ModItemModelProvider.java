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
        this.basicItem(DMLItems.DATA_MODEL_ZOMBIE.get());

    }

    /**
     * マター
     */
    private void registerPristineMatter() {
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
