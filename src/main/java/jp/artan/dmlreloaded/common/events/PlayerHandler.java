package jp.artan.dmlreloaded.common.events;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.config.BalanceConfigs;
import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.item.ItemGlitchArmor;
import jp.artan.dmlreloaded.item.ItemGlitchHeart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.ThreadLocalRandom;

@Mod.EventBusSubscriber(modid = DeepMobLearningReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerHandler {

    @SubscribeEvent
    public static void playerEuqipmentUpdate(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            Abilities cap = player.getAbilities();
            if (!player.level.isClientSide) {
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
    public static void playerLogIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Abilities cap = player.getAbilities();
        if (!player.level.isClientSide) {
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

    @SubscribeEvent
    public static void playerChangeGamemode(PlayerEvent.PlayerChangeGameModeEvent event) {
        Player player = event.getEntity();
        Abilities cap = player.getAbilities();
        if (!player.level.isClientSide) {
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

    @SubscribeEvent
    public static void playerRightClickedBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        if(!player.isCrouching() && BalanceConfigs.isSootedRedstoneCraftingEnabled.get()) {
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            if(event.getItemStack().getItem() instanceof ItemGlitchHeart && rand.nextInt(0, 10) <= 3) {
                BlockPos blockPos = event.getPos();
                if(player.getLevel().getBlockState(event.getPos()).getBlock() == Blocks.OBSIDIAN) {
                    ItemEntity drop = new ItemEntity(player.getLevel(), blockPos.getX(), blockPos.getY(),
                            blockPos.getZ(), new ItemStack(ItemInit.GLITCH_FRAGMENT.get(), 3));
                    drop.setDefaultPickUpDelay();
                    player.getLevel().addFreshEntity(drop);
                    event.getItemStack().shrink(1);
                    player.getLevel().playSound(null, blockPos, SoundEvents.ANCIENT_DEBRIS_BREAK,
                            SoundSource.NEUTRAL, 1f, 1.1f);
                    player.getLevel().addParticle(ParticleTypes.POOF, (double) blockPos.getX() + 0.5d,
                            (double) blockPos.getY() + 1, (double) blockPos.getZ() + 0.5d, 0d, 0.03d, 0d);
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void playerLeftClickedBlock(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        if (!player.isCrouching() && BalanceConfigs.isSootedRedstoneCraftingEnabled.get()) {
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            if (event.getItemStack().getItem() == Items.REDSTONE && rand.nextInt(0, 10) <= 3) {
                BlockPos blockPos = event.getPos();
                if (player.getLevel().getBlockState(event.getPos()).getBlock() == Blocks.COAL_BLOCK) {
                    ItemEntity drop = new ItemEntity(player.getLevel(), blockPos.getX(), blockPos.getY(),
                            blockPos.getZ(), new ItemStack(ItemInit.SOOT_COVERED_REDSTONE.get(), 1));
                    drop.setDefaultPickUpDelay();
                    player.getLevel().addFreshEntity(drop);
                    event.getItemStack().shrink(1);
                    player.getLevel().playSound(null, blockPos, SoundEvents.AMETHYST_CLUSTER_BREAK,
                            SoundSource.NEUTRAL, 1f, 0.1f);
                    player.getLevel().addParticle(ParticleTypes.FLAME,
                            (double) blockPos.getX() + rand.nextDouble(0, 1), (double) blockPos.getY() + 1,
                            (double) blockPos.getZ() + rand.nextDouble(0, 1), 0d, 0.03d, 0d);
                    event.setCanceled(true);
                }
            }
        }
    }
}
