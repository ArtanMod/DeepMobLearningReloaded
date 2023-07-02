package jp.artan.dmlreloaded.item;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.LivingMatterType;
import jp.artan.dmlreloaded.util.DataModelHelper;
import jp.artan.dmlreloaded.util.DataModelLevelupHelper;
import jp.artan.dmlreloaded.common.MobKey;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemDataModel extends Item {
    private final IMobKey mobKey;

    public ItemDataModel(Properties properties, IMobKey mobKey) {
        super(properties);
        this.mobKey = mobKey;
    }

    public IMobKey getMobKey() {
        return this.mobKey;
    }

    @Override
    public Component getName(ItemStack itemStack) {
        return Component.translatable(super.getName(itemStack).getString()).withStyle(t->t.withColor(ChatFormatting.AQUA));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flagIn) {
        if(Screen.hasShiftDown()) {
            list.add(Component.translatable("dmlreloaded.data_model.tier", DataModelHelper.getTierName(stack, false)));
            int tier = DataModelHelper.getTier(stack);
            if(tier != DeepMobLearningReloaded.DATA_MODEL_MAXIMUM_TIER) {
                list.add(Component.translatable("dmlreloaded.data_model.data.collected",
                        Component.literal(Integer.toString(DataModelHelper.getCurrentTierSimulationCountWithKills(stack))).withStyle(t -> t.withColor(ChatFormatting.GRAY)),
                        Component.literal(Integer.toString(DataModelHelper.getTierRoof(stack))).withStyle(t -> t.withColor(ChatFormatting.GRAY))));
                list.add(Component.translatable("dmlreloaded.data_model.data.killmultiplier",
                        Component.literal(Integer.toString(DataModelLevelupHelper.getKillMultiplier(DataModelHelper.getTier(stack)))).withStyle(t -> t.withColor(ChatFormatting.GRAY))));
            }
            list.add(Component.translatable("dmlreloaded.data_model.rfcost", Component.literal(Integer.toString(DataModelHelper.getSimulationTickCost(stack))).withStyle(t -> t.withColor(ChatFormatting.GRAY))));
            ILivingMatterType livingMatterType = DataModelHelper.getMatterTypeName(stack);
            list.add(Component.translatable("dmlreloaded.data_model.type_text", Component.translatable(livingMatterType.getLangId()).withStyle(t -> t.withColor(livingMatterType.getColor()))));
        } else if(Screen.hasControlDown()) {
            List<IMobKey.Mob> mobs = this.getMobKey().getMobs();
            list.add(Component.translatable("dmlreloaded.learning_target"));
            for(int i = 0; i < mobs.size(); i++) {
                String mob = mobs.get(i).getMobLangId();
                list.add(Component.translatable("%1$s. %2$s", i + 1, Component.translatable(mob)));
            }
        } else {
            list.add(Component.translatable("dmlreloaded.holdshift", Component.literal("SHIFT").withStyle(t -> t.withColor(ChatFormatting.WHITE).withItalic(true))).withStyle(t -> t.withColor(ChatFormatting.GRAY)));
            list.add(Component.translatable("dmlreloaded.holdctrl", Component.literal("CTRL").withStyle(t -> t.withColor(ChatFormatting.WHITE).withItalic(true))).withStyle(t -> t.withColor(ChatFormatting.GRAY)));
        }
    }
}
