package jp.artan.dmlreloaded.common.mobmetas;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.item.ItemLivingMatter;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.NonNullSupplier;

public abstract class MobMetaData {
    protected String entityId;
    protected IMobKey key;
    protected int numberOfHearts;
    protected int simulationTickCost;
    protected ItemPristineMatter pristineMatter;
    protected int mobTriviaLine;

    public MobMetaData(
            IMobKey key,
            String entityId,
            int simulationTickCost,
            int numberOfHearts,
            ItemPristineMatter pristineMatter,
            int mobTriviaLine
    ) {
        this.key = key;
        this.entityId = entityId;
        this.simulationTickCost = simulationTickCost;
        this.numberOfHearts = numberOfHearts;
        this.pristineMatter = pristineMatter;
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

    public TranslatableComponent getMobTrivia(int index) {
        return new TranslatableComponent(getMobTriviaLangId(this.getKey(), index));
    }

    public boolean entityLivingMatchesMob(LivingEntity entity) {
        ResourceLocation registryName = entity.getType().getRegistryName();
        if (registryName != null) {
            String name = registryName.toString();
            for (IMobKey.Mob mobRegname : getKey().getMobs()) {
                if (mobRegname.getEntityId().equals(name)) {
                    return true;
                }
            }
        }

        return false;
    }

    // DeepLearnerScreen Function
    public Quaternion getEntityXRotation() {
        return Vector3f.XP.rotationDegrees(180.0F);
    }

    public Quaternion getEntityZRotation() {
        return Vector3f.ZP.rotationDegrees(0.0F);
    }

    public void setPose(PoseStack poseStack, int xPos, int yPos, long gameTime) {
        poseStack.scale(1.2F, 1.2F, -1.2F);
    }

    // Have to implement, different for every Meta
    public abstract LivingEntity getEntity(Level world);

    // Optional fields
    public Entity getExtraEntity(Level world) {
        return null;
    }

    public String getExtraTooltip() {
        return null;
    }
}
