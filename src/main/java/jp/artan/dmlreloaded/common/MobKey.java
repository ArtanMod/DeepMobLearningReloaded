package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.common.mobmetas.BlazeMeta;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.common.mobmetas.ZombieMeta;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public enum MobKey implements IMobKey {
    BLAZE("blaze", BlazeMeta::new, LivingMatterType.HELLISH, new ArrayList<>(){{
        add("minecraft:blaze");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:blaze_rod", 22));
    }}),
    CREEPER("creeper", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:creeper");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:gunpowder", 64));
        add(new Loot("minecraft:skull", 6));
    }}),
    DRAGON("dragon", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add("minecraft:ender_dragon");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:dragon_breath", 22));
        add(new Loot("minecraft:dragon_egg", 1));
    }}),
    DROWNED("drowned", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    ELDER_GUARDIAN("elder_guardian", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:elder_guardian");
    }}, new ArrayList<>(){{
    }}),
    ENDERMAN("enderman", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add("minecraft:enderman");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:ender_pearl", 6));
        add(new Loot("minecraft:end_crystal", 1));
    }}),
    EVOKER("evoker", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    GHAST("ghast", () -> null, LivingMatterType.HELLISH, new ArrayList<>(){{
        add("minecraft:ghast");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:ghast_tear", 8));
    }}),
    GUARDIAN("guardian", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:guardian");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:prismarine_shard", 32));
        add(new Loot("minecraft:prismarine_crystals", 32));
        add(new Loot("minecraft:fish", 64));
    }}),
    HOGLIN("hoglin", () -> null, LivingMatterType.HELLISH, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    MAGMA_CUBE("magma_cube", () -> null, LivingMatterType.HELLISH, new ArrayList<>(){{
        add("minecraft:magma_cube");
    }}, new ArrayList<>(){{
    }}),
    PHONTOM("phontom", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    PIGLIN("piglin", () -> null, LivingMatterType.HELLISH, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    PILLAGER("pillager", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    RAVAGER("ravager", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    SHULKER("shulker", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:shulker_shell", 18));
        add(new Loot("minecraft:diamond", 2));
    }}),
    SKELETON("skeleton", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:stray");
        add("minecraft:skeleton");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:bone", 64));
        add(new Loot("minecraft:arrow", 64));
        add(new Loot("minecraft:skull", 6));
    }}),
    SLIME("slime", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:slime");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:slime_ball", 32));
    }}),
    SPIDER("spider", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:spider");
        add("minecraft:cave_spider");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:spider_eye", 16));
        add(new Loot("minecraft:string", 64));
        add(new Loot("minecraft:web", 8));
    }}),
    VINDICATOR("vindicator", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    WITCH("witch", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:witch");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:redstone", 32));
        add(new Loot("minecraft:glowstone_dust", 32));
        add(new Loot("minecraft:sugar", 64));
    }}),
    WITHER_SKELETON("wither_skeleton", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add("minecraft:wither_skeleton");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:skull", 18));
        add(new Loot("minecraft:coal", 64));
    }}),
    WITHER("wither", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add("minecraft:wither");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:nether_star", 3));
    }}),
    ZOMBIE("zombie", ZombieMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:zombie");
        add("minecraft:husk");
        add("minecraft:zombie_villager");
        add("minecraft:zombie_pigman");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:rotten_flesh", 64));
        add(new Loot("minecraft:iron_ingot", 16));
        add(new Loot("minecraft:carrot", 32));
        add(new Loot("minecraft:potato", 32));
    }});

    private final String mobKey;
    private final NonNullSupplier<MobMetaData> mobMetaData;
    private final ILivingMatterType livingMatterType;
    private final List<String> mobs;
    private final List<String> loot;

    MobKey(
            String mobKey,
            NonNullSupplier<MobMetaData> mobMetaData,
            ILivingMatterType livingMatterType,
            List<String> mobs,
            List<Loot> loot
    ) {
        this.mobKey = mobKey;
        this.mobMetaData = mobMetaData;
        this.livingMatterType = livingMatterType;
        this.mobs = mobs;
        this.loot = loot.stream().map(Loot::getLootId).toList();
    }

    @Override
    public String getMobKey() {
        return this.mobKey;
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
    public List<String> getMobs() {
        return mobs;
    }

    @Override
    public List<String> getLoot() {
        return loot;
    }

    @Override
    public void addMob(String mob) {
        mobs.add(mob);
    }

    @Override
    public void addLoot(String itemId, int amount) {
        loot.add(new Loot(itemId, amount).getLootId());
    }
}
