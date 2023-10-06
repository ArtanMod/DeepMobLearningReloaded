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
        ItemStack deepLearner = getDeepLearner(getDeepLearnerSlotResult(player));
        if(deepLearner.isEmpty()) {
            deepLearner = getDeepLearner(getNetheriteDeepLearnerSlotResult(player));
        }
        return deepLearner;
    }

    private static Optional<SlotResult> getDeepLearnerSlotResult(Player player) {
        return CuriosApi.getCuriosHelper().findFirstCurio(player, ItemInit.DEEP_LEARNER.get());
    }

    private static Optional<SlotResult> getNetheriteDeepLearnerSlotResult(Player player) {
        return CuriosApi.getCuriosHelper().findFirstCurio(player, ItemInit.NETHERITE_DEEP_LEARNER.get());
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
