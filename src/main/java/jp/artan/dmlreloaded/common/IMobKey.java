package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.List;

public interface IMobKey {
    String getId();
    NonNullSupplier<MobMetaData> getMobMetaData();
    ILivingMatterType getLivingMatterType();
    List<Mob> getMobs();
    List<NonNullSupplier<ItemStack>> getLoot();
    void addMob(String entityId, String langId);
    void addLoot(NonNullSupplier<ItemStack> itemStack);

    class Mob {
        private final String entityId;
        private final String langId;

        public Mob(String entityId, String langId) {
            this.entityId = entityId;
            this.langId = langId;
        }

        public String getEntityId() {
            return this.entityId;
        }

        public String getLangId() {
            return this.langId;
        }
    }

    class Loot {
        private final NonNullSupplier<ItemLike> item;
        private final int amount;

        public Loot(NonNullSupplier<ItemLike> item, int amount) {
            this.item = item;
            this.amount = amount;
        }

        public ItemStack getItemStack() {
            return new ItemStack(this.item.get(), this.amount);
        }
    }
}
