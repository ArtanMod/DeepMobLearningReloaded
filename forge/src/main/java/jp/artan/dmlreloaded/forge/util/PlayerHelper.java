package jp.artan.dmlreloaded.forge.util;

import jp.artan.dmlreloaded.forge.item.ItemDeepLearner;
import jp.artan.dmlreloaded.forge.plugin.PluginInit;
import jp.artan.dmlreloaded.forge.plugin.curios.CuriosUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class PlayerHelper {

    private boolean isHoldingDeepLearner;
    private Player player;
    private ItemStack stack;

    public PlayerHelper(Player player) {
        this.player = player;
        ItemStack mainHandStack = this.player.getMainHandItem();
        ItemStack offHandStack = this.player.getOffhandItem();

        if(mainHandStack.getItem() instanceof ItemDeepLearner) {
            this.stack = mainHandStack;
            this.isHoldingDeepLearner = true;
        } else if(offHandStack.getItem() instanceof ItemDeepLearner) {
            this.stack = offHandStack;
            this.isHoldingDeepLearner = true;
        } else if(PluginInit.CURIOS_ACTIVE) {
            ItemStack curiosSlotItem = CuriosUtil.getDeepLearnerCurioItemStack(this.player);
            if(curiosSlotItem.isEmpty()) {
                this.isHoldingDeepLearner = false;
                stack = ItemStack.EMPTY;
            } else {
                this.stack = curiosSlotItem;
                this.isHoldingDeepLearner = true;
            }
        } else {
            this.isHoldingDeepLearner = false;
            stack = ItemStack.EMPTY;
        }

    }


    public boolean isHoldingDeepLearner() {
        return isHoldingDeepLearner;
    }

    // Check if isHoldingDeepLearner first if you can't accept an Empty itemstack
    public ItemStack getHeldDeepLearner() {
        return stack;
    }
}

