package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.List;

public interface IMobKey {
    String getId();
    NonNullSupplier<MobMetaData> getMobMetaData();
    ILivingMatterType getLivingMatterType();
    List<Mob> getMobs();
    List<NonNullSupplier<ItemStack>> getLoot();
    void addMob(String mobLangId);
    void addLoot(NonNullSupplier<ItemStack> itemStack);

    class Mob {
        private final String mobLangId;

        public Mob(String mobLangId) {
            this.mobLangId = mobLangId;
        }

        public String getLangId() {
            return this.mobLangId;
        }
    }
}
