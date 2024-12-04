package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.util.MathHelper;
import jp.artan.dmlreloaded.util.TierHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemDataModelUpgrade extends Item {
    private final int nextTier;
    public ItemDataModelUpgrade(Properties properties, int nextTier) {
        super(properties);
        this.nextTier = MathHelper.ensureRange(nextTier, 0, TierHelper.getMaxTier());
    }

    public int getNextTier() {
        return this.nextTier;
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("dmlreloaded.data_model_upgrade.tier", this.nextTier));
        tooltipComponents.add(Component.translatable("dmlreloaded.data_model_upgrade.desc").withStyle(t -> t.withColor(ChatFormatting.DARK_PURPLE)));
    }
}
