package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.LivingMatterType;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.util.DataModelLevelupHelper;
import jp.artan.dmlreloaded.common.MobKey;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemDataModel extends Item {
    private final MobKey mobKey;

    public ItemDataModel(Properties properties, MobKey mobKey) {
        super(properties);
        this.mobKey = mobKey;
    }

    public MobKey getMobKey() {
        return this.mobKey;
    }

    @Override
    public Component getName(ItemStack itemStack) {
        return new TranslatableComponent(super.getName(itemStack).getString()).withStyle(t -> t.withColor(ChatFormatting.AQUA));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flagIn) {
        if(!Screen.hasShiftDown()) {
            list.add(new TranslatableComponent("dmlreloaded.holdshift", new TextComponent("SHIFT").withStyle(t -> t.withColor(ChatFormatting.WHITE).withItalic(true))).withStyle(t -> t.withColor(ChatFormatting.GRAY)));
        } else {
            list.add(new TranslatableComponent("dmlreloaded.data_model.tier", DataModelHelper.getTierName(stack, false)));
            int tier = DataModelHelper.getTier(stack);
            if(tier != DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
                list.add(new TranslatableComponent("dmlreloaded.data_model.data.collected",
                        new TextComponent(Integer.toString(DataModelHelper.getCurrentTierSimulationCountWithKills(stack))).withStyle(t -> t.withColor(ChatFormatting.GRAY)),
                        new TextComponent(Integer.toString(DataModelHelper.getTierRoof(stack))).withStyle(t -> t.withColor(ChatFormatting.GRAY))));
                list.add(new TranslatableComponent("dmlreloaded.data_model.data.killmultiplier",
                        new TextComponent(Integer.toString(DataModelLevelupHelper.getKillMultiplier(DataModelHelper.getTier(stack)))).withStyle(t -> t.withColor(ChatFormatting.GRAY))));
            }
            list.add(new TranslatableComponent("dmlreloaded.data_model.rfcost", new TextComponent(Integer.toString(DataModelHelper.getSimulationTickCost(stack))).withStyle(t -> t.withColor(ChatFormatting.GRAY))));
            ILivingMatterType livingMatterType = DataModelHelper.getMatterTypeName(stack);
            list.add(new TranslatableComponent("dmlreloaded.data_model.type_text", new TranslatableComponent(livingMatterType.getLangId()).withStyle(t -> t.withColor(livingMatterType.getColor()))));
        }
    }
}
