package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.common.mobmetas.BlazeMeta;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.common.mobmetas.ZombieMeta;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.ArrayList;
import java.util.List;

public enum MobKey implements IMobKey {
    BLAZE("blaze", BlazeMeta::new, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new Mob("minecraft:blaze"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:blaze_rod", 22));
    }}),
    CREEPER("creeper", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:creeper"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:gunpowder", 64));
        add(new Loot("minecraft:skull", 6));
    }}),
    DRAGON("dragon", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new Mob("minecraft:ender_dragon"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:dragon_breath", 22));
        add(new Loot("minecraft:dragon_egg", 1));
    }}),
    ELDER_GUARDIAN("elder_guardian", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:elder_guardian"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:prismarine_shard", 64));
        add(new Loot("minecraft:prismarine_crystals", 64));
        add(new Loot("minecraft:fish", 64));
        add(new Loot("minecraft:sponge", 8));
    }}),
    ENDERMAN("enderman", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new Mob("minecraft:enderman"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:ender_pearl", 6));
        add(new Loot("minecraft:end_crystal", 1));
    }}),
    EVOKER("evoker", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:evoker"));
        add(new Mob("minecraft:vex"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:emerald", 8));
        add(new Loot("minecraft:totem_of_undying", 1));
    }}),
    GHAST("ghast", () -> null, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new Mob("minecraft:ghast"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:ghast_tear", 8));
    }}),
    GUARDIAN("guardian", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:guardian"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:prismarine_shard", 32));
        add(new Loot("minecraft:prismarine_crystals", 32));
        add(new Loot("minecraft:fish", 64));
    }}),
    HOGLIN("hoglin", () -> null, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new Mob("minecraft:hoglin"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:leather", 32));
        add(new Loot("minecraft:porkchop", 32));
    }}),
    MAGMA_CUBE("magma_cube", () -> null, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new Mob("minecraft:magma_cube"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:magma_cream", 32));
    }}),
    PHONTOM("phontom", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:phontom"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:phantom_membrane", 8));
    }}),
    PIGLIN("piglin", () -> null, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new Mob("minecraft:piglin"));
        add(new Mob("minecraft:piglin_brute"));
        add(new Mob("minecraft:zombie_pigman"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:gold_ingot", 16));
    }}),
    PILLAGER("pillager", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:pillager"));
        add(new Mob("minecraft:vindicator"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:emerald", 8));
        add(new Loot("minecraft:book", 64));
    }}),
    RAVAGER("ravager", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:ravager"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:saddle", 4));
        add(new Loot("minecraft:diamond", 2));
    }}),
    SHULKER("shulker", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new Mob("minecraft:shulker"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:shulker_shell", 18));
        add(new Loot("minecraft:diamond", 2));
    }}),
    SKELETON("skeleton", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:stray"));
        add(new Mob("minecraft:skeleton"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:bone", 64));
        add(new Loot("minecraft:arrow", 64));
        add(new Loot("minecraft:skull", 6));
    }}),
    SLIME("slime", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:slime"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:slime_ball", 32));
    }}),
    SPIDER("spider", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:spider"));
        add(new Mob("minecraft:cave_spider"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:spider_eye", 16));
        add(new Loot("minecraft:string", 64));
        add(new Loot("minecraft:web", 8));
    }}),
    WITCH("witch", () -> null, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:witch"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:redstone", 32));
        add(new Loot("minecraft:glowstone_dust", 32));
        add(new Loot("minecraft:sugar", 64));
    }}),
    WITHER_SKELETON("wither_skeleton", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new Mob("minecraft:wither_skeleton"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:skull", 18));
        add(new Loot("minecraft:coal", 64));
    }}),
    WITHER("wither", () -> null, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new Mob("minecraft:wither"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:nether_star", 3));
        add(new Loot("minecraft:ancient_debris", 1));
    }}),
    ZOMBIE("zombie", ZombieMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new Mob("minecraft:zombie"));
        add(new Mob("minecraft:husk"));
        add(new Mob("minecraft:zombie_villager"));
        add(new Mob("minecraft:drowned"));
        add(new Mob("minecraft:zoglin"));
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:rotten_flesh", 64));
        add(new Loot("minecraft:iron_ingot", 16));
        add(new Loot("minecraft:carrot", 32));
        add(new Loot("minecraft:potato", 32));
    }});

    private final String id;
    private final NonNullSupplier<MobMetaData> mobMetaData;
    private final ILivingMatterType livingMatterType;
    private final List<Mob> mobs;
    private final List<Loot> loot;

    MobKey(
            String id,
            NonNullSupplier<MobMetaData> mobMetaData,
            ILivingMatterType livingMatterType,
            List<Mob> mobs,
            List<Loot> loot
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
    public List<Loot> getLoot() {
        return loot;
    }

    @Override
    public void addMob(String entityId, String langId) {
        mobs.add(new Mob(entityId, langId));
    }

    @Override
    public void addLoot(String itemId, int amount) {
        loot.add(new Loot(itemId, amount));
    }
}
