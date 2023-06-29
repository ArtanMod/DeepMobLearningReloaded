package jp.artan.dmlreloaded.plugin.twilight.common;

import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.LivingMatterType;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.plugin.twilight.common.mobmetas.NagaMeta;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.util.NonNullSupplier;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;

import java.util.ArrayList;
import java.util.List;

public enum TwilightMobKey implements IMobKey {
    NAGA("naga", NagaMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("twilightforest:naga", "entity.twilightforest.naga"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(TFBlocks.NAGA_TROPHY.get(), 1));
        add(() -> new ItemStack(TFItems.NAGA_SCALE.get(), 32));
    }}),
    LICH("lich", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("twilightforest:lich"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(TFBlocks.LICH_TROPHY.get(), 1));
        add(() -> new ItemStack(TFItems.TWILIGHT_SCEPTER.get(), 1));
        add(() -> new ItemStack(TFItems.LIFEDRAIN_SCEPTER.get(), 1));
        add(() -> new ItemStack(TFItems.ZOMBIE_SCEPTER.get(), 1));
        add(() -> new ItemStack(TFItems.FORTIFICATION_SCEPTER.get(), 1));
        add(() -> new ItemStack(Items.ENDER_PEARL, 32));
        add(() -> new ItemStack(Items.BONE, 32));
        add(() -> new ItemStack(Items.GOLD_NUGGET, 64));
    }}),
    MINOSHROOM("minoshroom", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("twilightforest:minoshroom"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(TFBlocks.MINOSHROOM_TROPHY.get(), 1));
        add(() -> new ItemStack(TFItems.MEEF_STROGANOFF.get(), 32));
        add(() -> new ItemStack(TFItems.DIAMOND_MINOTAUR_AXE.get(), 1));
    }}),
    HYDRA("hydra", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("twilightforest:hydra"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(TFBlocks.HYDRA_TROPHY.get(), 1));
        add(() -> new ItemStack(TFItems.HYDRA_CHOP.get(), 32));
        add(() -> new ItemStack(TFItems.FIERY_BLOOD.get(), 32));
    }}),
    KNIGHT_PHANTOM("knight_phantom", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("twilightforest:knight_phantom"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY.get(), 1));
        add(() -> new ItemStack(TFItems.PHANTOM_HELMET.get(), 1));
        add(() -> new ItemStack(TFItems.PHANTOM_CHESTPLATE.get(), 1));
        add(() -> new ItemStack(TFItems.KNIGHTMETAL_INGOT.get(), 32));
    }}),
    UR_GHAST("ur_ghast", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("twilightforest:ur_ghast"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(TFBlocks.UR_GHAST_TROPHY.get(), 1));
        add(() -> new ItemStack(TFItems.CARMINITE.get(), 32));
        add(() -> new ItemStack(TFItems.FIERY_TEARS.get(), 32));
        add(() -> new ItemStack(TFItems.CARMINITE.get(), 32));
    }}),
    ALPHA_YETI("alpha_yeti", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("twilightforest:alpha_yeti"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(TFBlocks.ALPHA_YETI_TROPHY.get(), 1));
        add(() -> new ItemStack(TFItems.ICE_BOMB.get(), 32));
        add(() -> new ItemStack(TFItems.ALPHA_YETI_FUR.get(), 32));
    }}),
    SNOW_QUEEN("snow_queen", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("twilightforest:snow_queen"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(TFBlocks.SNOW_QUEEN_TROPHY.get(), 1));
        add(() -> new ItemStack(TFItems.TRIPLE_BOW.get(), 1));
        add(() -> new ItemStack(TFItems.SEEKER_BOW.get(), 1));
        add(() -> new ItemStack(Blocks.PACKED_ICE, 64));
        add(() -> new ItemStack(Items.SNOWBALL, 64));
        add(() -> new ItemStack(TFItems.ICE_BOMB.get(), 32));
    }}),
    GIANT("giant", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("twilightforest:armored_giant"));
        add(new Mob("twilightforest:giant_miner"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(TFItems.GIANT_PICKAXE.get(), 1));
        add(() -> new ItemStack(TFItems.GIANT_SWORD.get(), 1));
    }});

    private final String id;
    private final NonNullSupplier<MobMetaData> mobMetaData;
    private final ILivingMatterType livingMatterType;
    private final List<Mob> mobs;
    private final List<NonNullSupplier<ItemStack>> loot;

    TwilightMobKey(
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
    public void addMob(String entityId, String langId) {
        mobs.add(new Mob(entityId, langId));
    }

    @Override
    public void addLoot(NonNullSupplier<ItemStack> itemStack) {
        loot.add(itemStack);
    }
}