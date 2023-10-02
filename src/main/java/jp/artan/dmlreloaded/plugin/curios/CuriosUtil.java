package jp.artan.dmlreloaded.plugin.curios;

import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.item.ItemDeepLearner;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;

public class CuriosUtil {

    public static ItemStack getDeepLearnerCurioItemStack(Player player) {
        return getDeepLearner(getDeepLearnerSlotResult(player));
    }

    private static Optional<SlotResult> getDeepLearnerSlotResult(Player player) {
        return CuriosApi.getCuriosHelper().findFirstCurio(player, ItemInit.DEEP_LEARNER.get());
    }

    private static ItemStack getDeepLearner(Optional<SlotResult> slotResult) {
        if(slotResult.isPresent()) {
            ItemStack stack = slotResult.get().stack();
            if(stack.getItem() instanceof ItemDeepLearner) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }
}
