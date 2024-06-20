package jp.artan.dmlreloaded.forge.providers;

import jp.artan.artansprojectcoremod.forge.providers.AbstractJPLanguageProvider;
import jp.artan.dmlreloaded.init.DMLCreativeTab;
import jp.artan.dmlreloaded.init.DMLItems;
import net.minecraft.data.DataGenerator;

public class ModJPLanguageProvider extends AbstractJPLanguageProvider {
    public ModJPLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void addTranslations() {
        addTranslationsStandardItem();
        addTranslationsDataModel();
        addTranslationsPristineMatter();
        addTranslationsLivingMatter();
    }

    /**
     * 標準アイテム
     */
    private void addTranslationsStandardItem() {
        this.add(DMLItems.SOOT_COVERED_REDSTONE.get(), "煤で覆われたレッドストーン");
        this.add(DMLItems.SOOT_COVERED_PLATE.get(), "煤で覆われたプレート");
        this.add(DMLItems.GLITCH_FRAGMENT.get(), "不安定なグリッチの断片");
        this.add(DMLItems.GLITCH_HEART.get(), "破損したグリッチの心臓");
        this.add(DMLItems.GLITCH_INGOT.get(), "グリッチが染み込んだインゴット");
        this.add(DMLItems.NETHERITE_GLITCH_INGOT.get(), "ネザライトグリッチが染み込んだインゴット");
//        this.add(DMLItems.DEEP_LEARNER.get(), "深層学習装置");
//        this.add(DMLItems.NETHERITE_DEEP_LEARNER.get(), "ネザライト深層学習装置");
        this.add(DMLItems.POLYMER_CLAY.get(), "ポリマー粘土");
//        this.add(DMLItems.GLITCH_SWORD.get(), "グリッチが染み込んだ剣");
//        this.add(DMLItems.NETHERITE_GLITCH_SWORD.get(), "ネザライトグリッチが染み込んだ剣");
    }

    /**
     * データモデル
     */
    private void addTranslationsDataModel() {
        this.add(DMLItems.DATA_MODEL_BLANK.get(), "空のデータモデル");
//        this.add(DMLItems.DATA_MODEL_BLAZE.get(), "ブレイズのデータモデル");
//        this.add(DMLItems.DATA_MODEL_CREEPER.get(), "クリーパーのデータモデル");
//        this.add(DMLItems.DATA_MODEL_ENDER_DRAGON.get(), "エルダーガーディアンのデータモデル");
//        this.add(DMLItems.DATA_MODEL_ELDER_GUARDIAN.get(), "エンダードラゴンのデータモデル");
//        this.add(DMLItems.DATA_MODEL_ENDERMAN.get(), "エンダーマンのデータモデル");
//        this.add(DMLItems.DATA_MODEL_EVOKER.get(), "エヴォーカーのデータモデル");
//        this.add(DMLItems.DATA_MODEL_GHAST.get(), "ガストのデータモデル");
//        this.add(DMLItems.DATA_MODEL_GUARDIAN.get(), "ガーディアンのデータモデル");
//        this.add(DMLItems.DATA_MODEL_HOGLIN.get(), "ホグリンのデータモデル");
//        this.add(DMLItems.DATA_MODEL_MAGMA_CUBE.get(), "マグマキューブのデータモデル");
//        this.add(DMLItems.DATA_MODEL_PHANTOM.get(), "ファントムのデータモデル");
//        this.add(DMLItems.DATA_MODEL_PIGLIN.get(), "ピグリンのデータモデル");
//        this.add(DMLItems.DATA_MODEL_RAVAGER.get(), "ラヴェジャーのデータモデル");
//        this.add(DMLItems.DATA_MODEL_SHULKER.get(), "シュルカーのデータモデル");
//        this.add(DMLItems.DATA_MODEL_SKELETON.get(), "スケルトンのデータモデル");
//        this.add(DMLItems.DATA_MODEL_SLIME.get(), "スライムのデータモデル");
//        this.add(DMLItems.DATA_MODEL_SPIDER.get(), "クモのデータモデル");
//        this.add(DMLItems.DATA_MODEL_WARDEN.get(), "ウォーデンのデータモデル");
//        this.add(DMLItems.DATA_MODEL_WITCH.get(), "ウィッチのデータモデル");
//        this.add(DMLItems.DATA_MODEL_WITHER_SKELETON.get(), "ウィザースケルトンのデータモデル");
//        this.add(DMLItems.DATA_MODEL_WITHER.get(), "ウィザーのデータモデル");
        this.add(DMLItems.DATA_MODEL_ZOMBIE.get(), "ゾンビのデータモデル");
    }

    /**
     * マター
     */
    private void addTranslationsPristineMatter() {
//        this.add(DMLItems.PRISTINE_MATTER_BLAZE.get(), "綺麗なブレイズのマター");
//        this.add(DMLItems.PRISTINE_MATTER_CREEPER.get(), "綺麗なクリーパーのマター");
//        this.add(DMLItems.PRISTINE_MATTER_ENDER_DRAGON.get(), "綺麗なエルダーガーディアンのマター");
//        this.add(DMLItems.PRISTINE_MATTER_ELDER_GUARDIAN.get(), "綺麗なエンダードラゴンのマター");
//        this.add(DMLItems.PRISTINE_MATTER_ENDERMAN.get(), "綺麗なエンダーマンのマター");
//        this.add(DMLItems.PRISTINE_MATTER_EVOKER.get(), "綺麗なエヴォーカーのマター");
//        this.add(DMLItems.PRISTINE_MATTER_GHAST.get(), "綺麗なガストのマター");
//        this.add(DMLItems.PRISTINE_MATTER_GUARDIAN.get(), "綺麗なガーディアンのマター");
//        this.add(DMLItems.PRISTINE_MATTER_HOGLIN.get(), "綺麗なホグリンのマター");
//        this.add(DMLItems.PRISTINE_MATTER_MAGMA_CUBE.get(), "綺麗なマグマキューブのマター");
//        this.add(DMLItems.PRISTINE_MATTER_PHANTOM.get(), "綺麗なファントムのマター");
//        this.add(DMLItems.PRISTINE_MATTER_PIGLIN.get(), "綺麗なピグリンのマター");
//        this.add(DMLItems.PRISTINE_MATTER_RAVAGER.get(), "綺麗なラヴェジャーのマター");
//        this.add(DMLItems.PRISTINE_MATTER_SHULKER.get(), "綺麗なシュルカーのマター");
//        this.add(DMLItems.PRISTINE_MATTER_SKELETON.get(), "綺麗なスケルトンのマター");
//        this.add(DMLItems.PRISTINE_MATTER_SLIME.get(), "綺麗なスライムのマター");
//        this.add(DMLItems.PRISTINE_MATTER_SPIDER.get(), "綺麗なクモのマター");
//        this.add(DMLItems.PRISTINE_MATTER_WARDEN.get(), "綺麗なウォーデンのマター");
//        this.add(DMLItems.PRISTINE_MATTER_WITCH.get(), "綺麗なウィッチのマター");
//        this.add(DMLItems.PRISTINE_MATTER_WITHER_SKELETON.get(), "綺麗なウィザースケルトンのマター");
//        this.add(DMLItems.PRISTINE_MATTER_WITHER.get(), "綺麗なウィザーのマター");
        this.add(DMLItems.PRISTINE_MATTER_ZOMBIE.get(), "綺麗なゾンビマター");
    }

    /**
     * 環境マター
     */
    private void addTranslationsLivingMatter() {
        this.add(DMLItems.LIVING_MATTER_EXTRATERRESTRIAL.get(), "Extraterrestrialマター");
        this.add(DMLItems.LIVING_MATTER_HELLISH.get(), "Hellishマター");
        this.add(DMLItems.LIVING_MATTER_OVERWORLDIAN.get(), "Overworldianマター");
    }
}
