package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.List;

public interface IMobKey {
    String getId();
    NonNullSupplier<MobMetaData> getMobMetaData();
    ILivingMatterType getLivingMatterType();
    List<String> getMobs();
    List<String> getLoot();
    void addMob(String mob);
    void addLoot(String itemId, int amount);

    class Loot {
        private final String itemId;
        private final int amount;
        public Loot(String itemId, int amount) {
            this.itemId = itemId;
            this.amount = amount;
        }

        public String getLootId() {
            return this.itemId + "," + this.amount;
        }
    }
}
