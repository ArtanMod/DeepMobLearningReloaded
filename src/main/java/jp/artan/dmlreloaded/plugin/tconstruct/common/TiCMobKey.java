package jp.artan.dmlreloaded.plugin.tconstruct.common;

import jp.artan.dmlreloaded.common.ILivingMatterType;
import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.LivingMatterType;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.plugin.tconstruct.common.mobmetas.TinkerSlimeMeta;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.util.NonNullSupplier;
import slimeknights.tconstruct.shared.TinkerCommons;
import slimeknights.tconstruct.shared.block.SlimeType;

import java.util.ArrayList;
import java.util.List;

public enum TiCMobKey implements IMobKey {
    SLIME("tinker_slime", TinkerSlimeMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("tconstruct:earth_slime", "entity.tconstruct.earth_slime"));
        add(new Mob("tconstruct:sky_slime", "entity.tconstruct.sky_slime"));
        add(new Mob("tconstruct:ender_slime", "entity.tconstruct.ender_slime"));
        add(new Mob("tconstruct:terracube", "entity.tconstruct.terracube"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.SLIME_BALL, 32));
        add(() -> new ItemStack(Items.CLAY_BALL, 32));
        add(() -> new ItemStack(TinkerCommons.slimeball.get(SlimeType.SKY), 32));
        add(() -> new ItemStack(TinkerCommons.slimeball.get(SlimeType.ENDER), 32));
    }});

    private final String id;
    private final NonNullSupplier<MobMetaData> mobMetaData;
    private final ILivingMatterType livingMatterType;
    private final List<Mob> mobs;
    private final List<NonNullSupplier<ItemStack>> loot;

    TiCMobKey(
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
