package jp.artan.dmlreloaded.util;

import jp.artan.dmlreloaded.item.ItemDeepLearner;
import jp.artan.dmlreloaded.plugin.PluginInit;
import jp.artan.dmlreloaded.plugin.curios.CuriosUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.UUID;

public class PlayerHelper {
    public static java.util.List<ServerPlayer> getPlayersInArea(Level world, BlockPos pos, int area, int yStart, int yEnd) {
        BlockPos point1 = new BlockPos(pos.getX() - area, yStart, pos.getZ() - area);
        BlockPos point2 = new BlockPos(pos.getX() + area, yEnd, pos.getZ() + area);
        return world.getEntitiesOfClass(ServerPlayer.class, new AABB(point1, point2), LivingEntity::isAlive);
    }

//    public static void sendMessage(ServerPlayer player, MutableComponent component) {
//        if(player != null) {
//            player.sendMessage(component, player.getUUID());
//        }
//    }

    public static ServerPlayer getPlayerFromUUID(UUID uuid) {
        PlayerList list = ServerLifecycleHooks.getCurrentServer().getPlayerList();
        return list.getPlayer(uuid);
    }

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

