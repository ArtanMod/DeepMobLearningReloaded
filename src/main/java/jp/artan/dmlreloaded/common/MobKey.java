package jp.artan.dmlreloaded.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public enum MobKey implements IMobKey {
    BLAZE("blaze", LivingMatterType.HELLISH, new ArrayList<>(){{
        add("minecraft:blaze");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:blaze_rod", 22));
    }}),
    CREEPER("creeper", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:creeper");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:gunpowder", 64));
        add(new Loot("minecraft:skull", 6));
    }}),
    DRAGON("dragon", LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add("minecraft:ender_dragon");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:dragon_breath", 22));
        add(new Loot("minecraft:dragon_egg", 1));
    }}),
    DROWNED("drowned", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    ELDER_GUARDIAN("elder_guardian", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:elder_guardian");
    }}, new ArrayList<>(){{
    }}),
    ENDERMAN("enderman", LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add("minecraft:enderman");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:ender_pearl", 6));
        add(new Loot("minecraft:end_crystal", 1));
    }}),
    EVOKER("evoker", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    GHAST("ghast", LivingMatterType.HELLISH, new ArrayList<>(){{
        add("minecraft:ghast");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:ghast_tear", 8));
    }}),
    GUARDIAN("guardian", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:guardian");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:prismarine_shard", 32));
        add(new Loot("minecraft:prismarine_crystals", 32));
        add(new Loot("minecraft:fish", 64));
    }}),
    HOGLIN("hoglin", LivingMatterType.HELLISH, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    MAGMA_CUBE("magma_cube", LivingMatterType.HELLISH, new ArrayList<>(){{
        add("minecraft:magma_cube");
    }}, new ArrayList<>(){{
    }}),
    PHONTOM("phontom", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    PIGLIN("piglin", LivingMatterType.HELLISH, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    PILLAGER("pillager", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    RAVAGER("ravager", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    SHULKER("shulker", LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:shulker_shell", 18));
        add(new Loot("minecraft:diamond", 2));
    }}),
    SKELETON("skeleton", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:stray");
        add("minecraft:skeleton");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:bone", 64));
        add(new Loot("minecraft:arrow", 64));
        add(new Loot("minecraft:skull", 6));
    }}),
    SLIME("slime", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:slime");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:slime_ball", 32));
    }}),
    SPIDER("spider", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:spider");
        add("minecraft:cave_spider");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:spider_eye", 16));
        add(new Loot("minecraft:string", 64));
        add(new Loot("minecraft:web", 8));
    }}),
    VINDICATOR("vindicator", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
    }}, new ArrayList<>(){{
    }}),
    WITCH("witch", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:witch");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:redstone", 32));
        add(new Loot("minecraft:glowstone_dust", 32));
        add(new Loot("minecraft:sugar", 64));
    }}),
    WITHER_SKELETON("wither_skeleton", LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add("minecraft:wither_skeleton");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:skull", 18));
        add(new Loot("minecraft:coal", 64));
    }}),
    WITHER("wither", LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add("minecraft:wither");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:nether_star", 3));
    }}),
    ZOMBIE("zombie", LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add("minecraft:husk");
        add("minecraft:zombie");
        add("minecraft:zombie_villager");
        add("minecraft:zombie_pigman");
    }}, new ArrayList<>(){{
        add(new Loot("minecraft:rotten_flesh", 64));
        add(new Loot("minecraft:iron_ingot", 16));
        add(new Loot("minecraft:carrot", 32));
        add(new Loot("minecraft:potato", 32));
    }});

    private final String mobKey;
    private final ILivingMatterType livingMatterType;
    private final List<String> mobs;
    private final List<Loot> loot;

    MobKey(
            String mobKey,
            ILivingMatterType livingMatterType,
            List<String> mobs,
            List<Loot> loot
    ) {
        this.mobKey = mobKey;
        this.livingMatterType = livingMatterType;
        this.mobs = mobs;
        this.loot = loot;
    }

    @Override
    public String getMobKey() {
        return null;
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
    public List<Loot> getLoot() {
        return loot;
    }

    @Override
    public void addMob(String mob) {
        mobs.add(mob);
    }

    @Override
    public void addLoot(String itemId, int amount) {
        loot.add(new Loot(itemId, amount));
    }
}
