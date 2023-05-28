package jp.artan.dmlreloaded.common.mobmetas;

import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.config.EnergyCostConfig;
import jp.artan.dmlreloaded.config.MobConfig;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class MobMetaData {
    protected String name;
    private String pluralName;
    protected IMobKey key;
    protected int numberOfHearts;
    protected int interfaceScale;
    protected int interfaceOffsetX;
    protected int interfaceOffsetY;
    protected ItemLivingMatter livingMatter;
    protected ItemPristineMatter pristineMatter;
    protected int mobTriviaLine;

    public MobMetaData(
            IMobKey key,
            String name,
            String pluralName,
            int numberOfHearts,
            int interfaceScale,
            int interfaceOffsetX,
            int interfaceOffsetY,
            ItemLivingMatter livingMatter,
            ItemPristineMatter pristineMatter,
            int mobTriviaLine
    ) {
        this.key = key;
        this.name = name;
        this.pluralName = pluralName;
        this.numberOfHearts = numberOfHearts;
        this.interfaceScale = interfaceScale;
        this.interfaceOffsetX = interfaceOffsetX;
        this.interfaceOffsetY = interfaceOffsetY;
        this.livingMatter = livingMatter;
        this.pristineMatter = pristineMatter;
        this.mobTriviaLine = mobTriviaLine;
    }

    public int getSimulationTickCost() {
        int cost = EnergyCostConfig.getCost(getKey());
        return cost;
    }
    public ItemStack getLivingMatterStack(int amount) {
        return new ItemStack(livingMatter, amount);
    }

    public ItemStack getPristineMatterStack(int amount) {
        return new ItemStack(pristineMatter, amount);
    }

    public String getName() {
        return name;
    }

    public String getPluralName() {
        return pluralName;
    }

    public IMobKey getKey() {
        return key;
    }

    public int getNumberOfHearts() {
        return numberOfHearts;
    }

    public int getInterfaceScale() {
        return interfaceScale;
    }

    public int getInterfaceOffsetX() {
        return interfaceOffsetX;
    }

    public int getInterfaceOffsetY() {
        return interfaceOffsetY;
    }

    public ILivingMatterType getType() {
        return livingMatter.getType();
    }

    public ItemLivingMatter getLivingMatter() {
        return livingMatter;
    }

    public ItemPristineMatter getPristineMatter() {
        return pristineMatter;
    }

    public int getMobTriviaLine() {
        return mobTriviaLine;
    }

    public static String getMobTriviaLangId(IMobKey key, int index) {
        return "dmlreloaded.gui.mob." + key.getMobKey() + ".trivia." + index;
    }

    public TranslatableComponent getMobTrivia(int index) {
        return new TranslatableComponent(getMobTriviaLangId(this.getKey(), index));
    }

    public boolean entityLivingMatchesMob(LivingEntity entity) {
        ResourceLocation registryName = entity.getType().getRegistryName();
        if (registryName != null) {
            String name = registryName.toString();
            for (String mobRegname : MobConfig.getMobs(getKey())) {
                if (mobRegname.equals(name)) {
                    return true;
                }
            }
        }

        return false;
    }


    // Have to implement, different for every Meta
    public abstract LivingEntity getEntity(Level world);

    // Optional fields
    public Entity getExtraEntity(Level world) {
        return null;
    }

    public int getExtraInterfaceOffsetX() {
        return 0;
    }

    public int getExtraInterfaceOffsetY() {
        return 0;
    }

    public String getExtraTooltip() {
        return null;
    }
}
