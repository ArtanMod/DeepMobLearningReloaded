package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public interface IMobKey {
    String getId();
    NonNullSupplier<MobMetaData> getMobMetaData();
    ILivingMatterType getLivingMatterType();
    List<String> getMobs();
    List<Loot> getLoot();
    void addMob(String mob);
    void addLoot(String itemId, int amount);

    class Loot {
        private final String itemId;
        private final int amount;
        public Loot(String itemId, int amount) {
            this.itemId = itemId;
            this.amount = amount;
        }

        public ItemStack getItemStack() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(this.itemId)), this.amount);
        }
    }
}
