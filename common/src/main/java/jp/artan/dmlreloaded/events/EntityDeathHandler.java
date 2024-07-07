package jp.artan.dmlreloaded.events;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import jp.artan.dmlreloaded.item.ItemGlitchSword;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class EntityDeathHandler {
    public static void register() {
        EntityEvent.LIVING_DEATH.register(EntityDeathHandler::die);
    }

    private static EventResult die(LivingEntity entity, DamageSource source) {
        if(source.getEntity() instanceof ServerPlayer player) {
            if(player.getMainHandItem().getItem() instanceof ItemGlitchSword) {
                ItemStack sword = player.getItemInHand(InteractionHand.MAIN_HAND);
                if(ItemGlitchSword.canIncreaseDamage(sword)) {
                    ItemGlitchSword.increaseDamage(sword, player);
                }
            }
        }
        return EventResult.pass();
    }
}
