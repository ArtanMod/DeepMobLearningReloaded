package jp.artan.dmlreloaded.neoforge.events;

import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.item.ItemGlitchArmor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeepMobLearningReloadedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerHandler {

    @SubscribeEvent
    public static void playerEuqipmentUpdate(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            Abilities cap = player.getAbilities();
            if (!player.level().isClientSide) {
                boolean isMayFly = cap.mayfly;
                boolean isFlyEnabledAndFullSet = ItemGlitchArmor.isFlyEnabledAndFullSet((ServerPlayer) player);
                boolean isSpectator = player.isSpectator();
                boolean isCreative = player.isCreative();

                if (!isMayFly && isFlyEnabledAndFullSet) {
                    cap.mayfly = true;
                    player.onUpdateAbilities();
                }

                if (!isFlyEnabledAndFullSet && isMayFly && !isSpectator && !isCreative) {
                    cap.mayfly = false;
                    cap.flying = false;
                    player.onUpdateAbilities();
                }
            }
        }
    }

    @SubscribeEvent
    public static void playerChangeGamemode(PlayerEvent.PlayerChangeGameModeEvent event) {
        Player player = event.getEntity();
        Abilities cap = player.getAbilities();
        if (!player.level().isClientSide) {
            boolean isMayFly = cap.mayfly;
            boolean isFlyEnabledAndFullSet = ItemGlitchArmor.isFlyEnabledAndFullSet((ServerPlayer) player);
            boolean isSpectator = player.isSpectator();
            boolean isCreative = player.isCreative();

            if (isFlyEnabledAndFullSet) {
                cap.mayfly = true;
                player.onUpdateAbilities();
            }

            if (!isFlyEnabledAndFullSet && isMayFly && !isSpectator && !isCreative) {
                cap.mayfly = false;
                cap.flying = false;
                player.onUpdateAbilities();
            }
        }
    }
}
