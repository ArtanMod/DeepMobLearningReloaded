package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import jp.artan.dmlreloaded.util.RenderInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class MobMetaData {
    protected String entityId;
    protected IMobKey key;
    protected int numberOfHearts;
    protected int simulationTickCost;
    protected ItemPristineMatter pristineMatter;
    protected Item spawnEggItem;
    protected int mobTriviaLine;

    public MobMetaData(
            IMobKey key,
            String entityId,
            int simulationTickCost,
            int numberOfHearts,
            ItemPristineMatter pristineMatter,
            Item spawnEggItem
    ) {
        this(key, entityId, simulationTickCost, numberOfHearts, pristineMatter, spawnEggItem, 0);
    }

    public MobMetaData(
            IMobKey key,
            String entityId,
            int simulationTickCost,
            int numberOfHearts,
            ItemPristineMatter pristineMatter,
            Item spawnEggItem,
            int mobTriviaLine
    ) {
        this.key = key;
        this.entityId = entityId;
        this.simulationTickCost = simulationTickCost;
        this.numberOfHearts = numberOfHearts;
        this.pristineMatter = pristineMatter;
        this.spawnEggItem = spawnEggItem;
        this.mobTriviaLine = mobTriviaLine;
    }

    public int getSimulationTickCost() {
        return this.simulationTickCost;
    }

    public ItemStack getLivingMatterStack(int amount) {
        return new ItemStack(getLivingMatter(), amount);
    }

    public ItemStack getPristineMatterStack(int amount) {
        return new ItemStack(pristineMatter, amount);
    }

    public ItemStack getSpawnEgg() {
        return new ItemStack(spawnEggItem);
    }

    public String getEntityId() {
        return entityId;
    }

    public IMobKey getKey() {
        return key;
    }

    public int getNumberOfHearts() {
        return numberOfHearts;
    }

    public ILivingMatterType getType() {
        return this.getKey().getLivingMatterType();
    }

    public ItemLivingMatter getLivingMatter() {
        return this.getType().getLivingMatter().get();
    }

    public ItemPristineMatter getPristineMatter() {
        return pristineMatter;
    }

    public int getMobTriviaLine() {
        return mobTriviaLine;
    }

    public static String getMobTriviaLangId(IMobKey key, int index) {
        return "dmlreloaded.gui.mob." + key.getId() + ".trivia." + index;
    }

    public MutableComponent getMobTrivia(int index) {
        return Component.translatable(getMobTriviaLangId(this.getKey(), index));
    }

    public boolean entityLivingMatchesMob(LivingEntity entity) {
        String name = entity.getType().getDescriptionId();
        for (IMobKey.Mob mobRegname : getKey().getMobs()) {
            if (mobRegname.getLangId().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // DeepLearnerScreen Function
    public int getOffsetY(LivingEntity livingEntity) {
        return 0;
    }

    public RenderInfo transform(RenderInfo renderInfo, LivingEntity entity) {
        return renderInfo;
    }

    // Have to implement, different for every Meta
    public abstract LivingEntity getEntity(Level world);
}
