package jp.artan.dmlreloaded.plugin.DeeperAndDarker.common;

import com.kyanite.deeperdarker.content.DDItems;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.mobmetas.SculkCentipedeMeta;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.mobmetas.ShatteredMeta;
import jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.mobmetas.StalkerMeta;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.ArrayList;
import java.util.List;

public enum DeeperAndDarkerMobKey implements IMobKey {
    SHATTERED("shattered", ShatteredMeta::new, DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER, new ArrayList<>(){{
        add(new DeeperAndDarkerMobKey.DeeperAndDarkerMob("shattered"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(DDItems.SOUL_DUST.get(), 16));
    }}),
//    SCULK_LEECH("sculk_leech", null, DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER, new ArrayList<>(){{
//        add(new DeeperAndDarkerMobKey.DeeperAndDarkerMob("sculk_leech"));
//    }}, new ArrayList<>(){{
//    }}),
//    SCULK_SNAPPER("sculk_snapper", null, DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER, new ArrayList<>(){{
//        add(new DeeperAndDarkerMobKey.DeeperAndDarkerMob("sculk_snapper"));
//    }}, new ArrayList<>(){{
//    }}),
//    SHRIEK_WORM("shriek_worm", null, DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER, new ArrayList<>(){{
//        add(new DeeperAndDarkerMobKey.DeeperAndDarkerMob("shriek_worm"));
//    }}, new ArrayList<>(){{
//    }}),
    SCULK_CENTIPEDE("sculk_centipede", SculkCentipedeMeta::new, DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER, new ArrayList<>(){{
        add(new DeeperAndDarkerMobKey.DeeperAndDarkerMob("sculk_centipede"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(DDItems.SCULK_BONE.get(), 16));
    }}),
    STALKER("stalker", StalkerMeta::new, DeeperAndDarkerLivingMatterType.DEEPER_AND_DARKER, new ArrayList<>(){{
        add(new DeeperAndDarkerMobKey.DeeperAndDarkerMob("stalker"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(DDItems.SOUL_CRYSTAL.get(), 1));
    }});

    private final String id;
    private final NonNullSupplier<MobMetaData> mobMetaData;
    private final ILivingMatterType livingMatterType;
    private final List<Mob> mobs;
    private final List<NonNullSupplier<ItemStack>> loot;

    DeeperAndDarkerMobKey(
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

    public static class DeeperAndDarkerMob extends Mob {
        public DeeperAndDarkerMob(String entityId) {
            super("entity.deeperdarker." + entityId);
        }
    }
}
