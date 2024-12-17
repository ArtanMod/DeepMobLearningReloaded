package jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common;

import com.github.L_Ender.cataclysm.init.ModItems;
import jp.artan.dmlreloaded.util.inject.NonNullSupplier;
import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.neoforge.plugin.Cataclysm.common.mobmetas.*;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public enum CataclysmMobKey implements IMobKey {
    ENDER_GOLEM("ender_golem", EnderGolemMobMetaData::new, CataclysmLivingMatterType.CATACLYSM, new ArrayList<>(){{
        add(new CataclysmMob("ender_golem"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(ModItems.VOID_CORE.get(), 1));
    }}),
    ENDER_GUARDIAN("ender_guardian", EnderGuardianMobMetaData::new, CataclysmLivingMatterType.CATACLYSM, new ArrayList<>(){{
        add(new CataclysmMob("ender_guardian"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(ModItems.GAUNTLET_OF_GUARD.get(), 1));
        add(() -> new ItemStack(ModItems.MUSIC_DISC_ENDER_GUARDIAN.get(), 1));
    }}),
    NETHERITE_MONSTROSITY("netherite_monstrosity", NetheriteMonstrosityMobMetaData::new, CataclysmLivingMatterType.CATACLYSM, new ArrayList<>(){{
        add(new CataclysmMob("netherite_monstrosity"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(ModItems.INFERNAL_FORGE.get(), 1));
        add(() -> new ItemStack(ModItems.MONSTROUS_HORN.get(), 1));
        add(() -> new ItemStack(ModItems.MUSIC_DISC_NETHERITE_MONSTROSITY.get(), 1));
    }}),
    IGNIS("ignis", IgnisMobMetaData::new, CataclysmLivingMatterType.CATACLYSM, new ArrayList<>(){{
        add(new CataclysmMob("ignis"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(ModItems.IGNITIUM_INGOT.get(), 1));
        add(() -> new ItemStack(ModItems.MONSTROUS_HORN.get(), 1));
        add(() -> new ItemStack(ModItems.MUSIC_DISC_IGNIS.get(), 1));
    }}),
    THE_HARBINGER("the_harbinger", TheHarbingerMobMetaData::new, CataclysmLivingMatterType.CATACLYSM, new ArrayList<>(){{
        add(new CataclysmMob("the_harbinger"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(ModItems.WITHERITE_BLCOK.get(), 1));
        add(() -> new ItemStack(ModItems.MUSIC_DISC_THE_HARBINGER.get(), 1));
    }}),
    THE_LEVIATHAN("the_leviathan", TheLevianthanMobMetaData::new, CataclysmLivingMatterType.CATACLYSM, new ArrayList<>(){{
        add(new CataclysmMob("the_leviathan"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(ModItems.TIDAL_CLAWS.get(), 1));
        add(() -> new ItemStack(ModItems.ABYSSAL_SACRIFICE.get(), 1));
        add(() -> new ItemStack(ModItems.MUSIC_DISC_THE_LEVIATHAN.get(), 1));
    }}),
    CORAL_GOLEM("coral_golem", CoralGolemMobMetaData::new, CataclysmLivingMatterType.CATACLYSM, new ArrayList<>(){{
        add(new CataclysmMob("coral_golem"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(ModItems.CRYSTALLIZED_CORAL_FRAGMENTS.get(), 1));
    }}),
    ANCIENT_REMNANT("ancient_remnant", AncientRemnantMobMetaData::new, CataclysmLivingMatterType.CATACLYSM, new ArrayList<>(){{
        add(new CataclysmMob("ancient_remnant"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(ModItems.REMNANT_SKULL.get(), 1));
        add(() -> new ItemStack(ModItems.ANCIENT_METAL_BLOCK.get(), 1));
        add(() -> new ItemStack(ModItems.MUSIC_DISC_ANCIENT_REMNANT.get(), 1));
    }});

    private final String id;
    private final NonNullSupplier<MobMetaData> mobMetaData;
    private final ILivingMatterType livingMatterType;
    private final List<Mob> mobs;
    private final List<NonNullSupplier<ItemStack>> loot;

    CataclysmMobKey(
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

    public static class CataclysmMob extends Mob {
        public CataclysmMob(String entityId) {
            super("entity.cataclysm." + entityId);
        }
    }
}
