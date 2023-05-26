package jp.artan.dmlreloaded.common;

import java.util.HashSet;
import java.util.List;

public interface IMobKey {
    String getMobKey();
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
