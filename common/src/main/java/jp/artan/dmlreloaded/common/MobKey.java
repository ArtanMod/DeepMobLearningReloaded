package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.common.mobmetas.*;
import jp.artan.artansprojectcoremod.utils.inject.NonNullSupplier;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public enum MobKey implements IMobKey {
    ZOMBIE("zombie", ZombieMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("zombie"));
        add(new VanillaMob("husk"));
        add(new VanillaMob("zombie_villager"));
        add(new VanillaMob("drowned"));
        add(new VanillaMob("zoglin"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.ROTTEN_FLESH, 64));
        add(() -> new ItemStack(Items.IRON_INGOT, 16));
        add(() -> new ItemStack(Items.CARROT, 32));
        add(() -> new ItemStack(Items.POTATO, 32));
    }});


    private final String id;
    private final NonNullSupplier<MobMetaData> mobMetaData;
    private final ILivingMatterType livingMatterType;
    private final List<Mob> mobs;
    private final List<NonNullSupplier<ItemStack>> loot;

    MobKey(
            String id,
            NonNullSupplier<MobMetaData> mobMetaData,
            ILivingMatterType livingMatterType,
            List<Mob> mobs,
            List<NonNullSupplier<ItemStack>> loot
    ) {
        this.id = id;
        this.mobMetaData = mobMetaData;
        this.livingMatterType = livingMatterType;
        this.mobs = mobs;
        this.loot = loot;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public NonNullSupplier<MobMetaData> getMobMetaData() {
        return this.mobMetaData;
    }

    @Override
    public ILivingMatterType getLivingMatterType() {
        return livingMatterType;
    }

    @Override
    public List<Mob> getMobs() {
        return mobs;
    }

    @Override
    public List<NonNullSupplier<ItemStack>> getLoot() {
        return loot;
    }

    @Override
    public void addMob(String mobLangId) {
        mobs.add(new Mob(mobLangId));
    }

    @Override
    public void addLoot(NonNullSupplier<ItemStack> itemStack) {
        loot.add(itemStack);
    }

    public static class VanillaMob extends Mob {
        public VanillaMob(String entityId) {
            super("entity.minecraft." + entityId);
        }
    }
}
