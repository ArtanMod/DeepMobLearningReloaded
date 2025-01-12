package jp.artan.dmlreloaded.events;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.event.events.common.PlayerEvent;
import jp.artan.dmlreloaded.DeepMobLearningReloadedMod;
import jp.artan.dmlreloaded.init.DMLItems;
import jp.artan.dmlreloaded.item.ItemGlitchArmor;
import jp.artan.dmlreloaded.item.ItemGlitchHeart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerHandler {

    public static void register() {
        PlayerEvent.PLAYER_JOIN.register(PlayerHandler::playerLogIn);
        InteractionEvent.RIGHT_CLICK_BLOCK.register(PlayerHandler::playerRightClickedBlock);
        InteractionEvent.LEFT_CLICK_BLOCK.register(PlayerHandler::playerLeftClickedBlock);
    }

    private static void playerLogIn(ServerPlayer player) {
        Abilities cap = player.getAbilities();
        boolean isMayFly = cap.mayfly;
        boolean isFlyEnabledAndFullSet = ItemGlitchArmor.isFlyEnabledAndFullSet(player);
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

    private static EventResult playerRightClickedBlock(Player player, InteractionHand hand, BlockPos blockPos, Direction face) {
        if(!player.isCrouching()) {
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            ItemStack itemStack = player.getItemInHand(hand);
            if(itemStack.getItem() instanceof ItemGlitchHeart && rand.nextInt(0, 10) <= 3) {
                if(player.level().getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN) {
                    // ドロップ処理はサーバー側でのみ実施
                    if(!player.level().isClientSide) {
                        // プレイヤー側にアイテムをドロップ
                        double dropX = blockPos.getX() + 0.5 + face.getStepX();
                        double dropY = blockPos.getY() + 0.5 + face.getStepY();
                        double dropZ = blockPos.getZ() + 0.5 + face.getStepZ();
                        ItemEntity drop = new ItemEntity(player.level(), dropX, dropY, dropZ,
                                new ItemStack(BuiltInRegistries.ITEM.get(DeepMobLearningReloadedMod.getResource("glitch_fragment")), 3),
                                rand.nextDouble(-0.25, 0.25), rand.nextDouble(-0.25, 0.25), rand.nextDouble(-0.25, 0.25));
                        drop.setDefaultPickUpDelay();
                        player.level().addFreshEntity(drop);
                        itemStack.shrink(1);
                    }
                    player.level().playSound(null, blockPos, SoundEvents.ANCIENT_DEBRIS_BREAK,
                            SoundSource.NEUTRAL, 1f, 1.1f);
                    player.level().addParticle(ParticleTypes.POOF, (double) blockPos.getX() + 0.5d,
                            (double) blockPos.getY() + 1, (double) blockPos.getZ() + 0.5d, 0d, 0.03d, 0d);
                    return EventResult.interruptTrue();
                }
            }
        }
        return EventResult.pass();
    }

    private static EventResult playerLeftClickedBlock(Player player, InteractionHand hand, BlockPos blockPos, Direction face) {
        if (!player.isCrouching()) {
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            ItemStack itemStack = player.getItemInHand(hand);
            if (itemStack.getItem() == Items.REDSTONE && rand.nextInt(0, 10) <= 3) {
                if (player.level().getBlockState(blockPos).getBlock() == Blocks.COAL_BLOCK) {
                    // ドロップ処理はサーバー側でのみ実施
                    if(!player.level().isClientSide) {
                        // プレイヤー側にアイテムをドロップ
                        double dropX = blockPos.getX() + 0.5 + face.getStepX();
                        double dropY = blockPos.getY() + 0.5 + face.getStepY();
                        double dropZ = blockPos.getZ() + 0.5 + face.getStepZ();
                        ItemEntity drop = new ItemEntity(player.level(), dropX, dropY, dropZ,
                                new ItemStack(DMLItems.SOOT_COVERED_REDSTONE.get(), 1),
                                rand.nextDouble(-0.25, 0.25), rand.nextDouble(-0.25, 0.25), rand.nextDouble(-0.25, 0.25));
                        drop.setDefaultPickUpDelay();
                        player.level().addFreshEntity(drop);
                        itemStack.shrink(1);
                    }
                    player.level().playSound(null, blockPos, SoundEvents.AMETHYST_CLUSTER_BREAK,
                            SoundSource.NEUTRAL, 1f, 0.1f);
                    player.level().addParticle(ParticleTypes.FLAME,
                            (double) blockPos.getX() + rand.nextDouble(0, 1), (double) blockPos.getY() + 1,
                            (double) blockPos.getZ() + rand.nextDouble(0, 1), 0d, 0.03d, 0d);
                    return EventResult.interruptTrue();
                }
            }
        }
        return EventResult.pass();
    }
}
