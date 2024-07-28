package jp.artan.dmlreloaded.forge.plugin.curios;

import jp.artan.dmlreloaded.forge.item.ItemDeepLearner;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;


public class CuriosUtil {
    private static final String DEEP_LEARNER_SLOT = "deep_learner";

    public static ItemStack getDeepLearnerCurioItemStack(Player player) {
        try {
            LazyOptional<ICuriosItemHandler> curiosInventory = CuriosApi.getCuriosInventory(player);
            if(curiosInventory.isPresent()) {
                ICuriosItemHandler curiosItemHandler = curiosInventory.orElseThrow(IllegalStateException::new);
                ICurioStacksHandler curioStacksHandler = curiosItemHandler.getStacksHandler(DEEP_LEARNER_SLOT).orElseThrow();
                for(int i = 0; i < curioStacksHandler.getSlots(); i++) {
                    ItemStack stack = curioStacksHandler.getStacks().getStackInSlot(i);
                    if(stack.getItem() instanceof ItemDeepLearner) {
                        return stack;
                    }
                }
            }
            return ItemStack.EMPTY;
        } catch(Exception e) {
            return ItemStack.EMPTY;
        }
    }
}
