package jp.artan.dmlreloaded.common;

import jp.artan.dmlreloaded.common.mobmetas.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.ArrayList;
import java.util.List;

public enum MobKey implements IMobKey {
    BLAZE("blaze", BlazeMeta::new, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new VanillaMob("minecraft:blaze"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.BLAZE_ROD, 22));
    }}),
    CREEPER("creeper", CreeperMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:creeper"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.GUNPOWDER, 64));
        add(() -> new ItemStack(Items.CREEPER_HEAD, 6));
    }}),
    DRAGON("dragon", DragonMeta::new, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new VanillaMob("minecraft:ender_dragon"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.DRAGON_BREATH, 22));
        add(() -> new ItemStack(Items.DRAGON_EGG, 1));
    }}),
    ELDER_GUARDIAN("elder_guardian", ElderGuardianMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:elder_guardian"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.PRISMARINE_SHARD, 32));
        add(() -> new ItemStack(Items.PRISMARINE_CRYSTALS, 32));
        add(() -> new ItemStack(Items.COD, 64));
        add(() -> new ItemStack(Items.SPONGE, 4));
    }}),
    ENDERMAN("enderman", EndermanMeta::new, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new VanillaMob("minecraft:enderman"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.ENDER_PEARL, 6));
        add(() -> new ItemStack(Items.END_CRYSTAL, 1));
    }}),
    EVOKER("evoker", EvokerMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:evoker"));
        add(new VanillaMob("minecraft:vex"));
        add(new VanillaMob("minecraft:pillager"));
        add(new VanillaMob("minecraft:vindicator"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.EMERALD, 8));
        add(() -> new ItemStack(Items.TOTEM_OF_UNDYING, 1));
        add(() -> new ItemStack(Items.BOOK, 64));
    }}),
    GHAST("ghast", GhastMeta::new, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new VanillaMob("minecraft:ghast"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.GHAST_TEAR, 8));
    }}),
    GUARDIAN("guardian", GuardianMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:guardian"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.PRISMARINE_SHARD, 32));
        add(() -> new ItemStack(Items.PRISMARINE_CRYSTALS, 32));
        add(() -> new ItemStack(Items.COD, 64));
    }}),
    HOGLIN("hoglin", HoglinMeta::new, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new VanillaMob("minecraft:hoglin"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.LEATHER, 32));
        add(() -> new ItemStack(Items.PORKCHOP, 32));
    }}),
    MAGMA_CUBE("magma_cube", MagmaCubeMeta::new, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new VanillaMob("minecraft:magma_cube"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.MAGMA_CREAM, 32));
    }}),
    PHANTOM("phantom", PhantomMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:phantom"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.PHANTOM_MEMBRANE, 8));
    }}),
    PIGLIN("piglin", PiglinMeta::new, LivingMatterType.HELLISH, new ArrayList<>(){{
        add(new VanillaMob("minecraft:piglin"));
        add(new VanillaMob("minecraft:piglin_brute"));
        add(new VanillaMob("minecraft:zombie_pigman"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.GOLD_INGOT, 16));
    }}),

    RAVAGER("ravager", RavagerMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:ravager"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.SADDLE, 64));
        add(() -> new ItemStack(Items.DIAMOND, 8));
    }}),
    SHULKER("shulker", ShulkerMeta::new, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new VanillaMob("minecraft:shulker"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.SHULKER_SHELL, 18));
        add(() -> new ItemStack(Items.DIAMOND, 2));
    }}),
    SKELETON("skeleton", SkeletonMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:stray"));
        add(new VanillaMob("minecraft:skeleton"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.BONE, 64));
        add(() -> new ItemStack(Items.ARROW, 64));
        add(() -> new ItemStack(Blocks.SKELETON_SKULL, 6));
    }}),
    SLIME("slime", SlimeMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:slime"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.SLIME_BALL, 32));
    }}),
    SPIDER("spider", SpiderMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:spider"));
        add(new VanillaMob("minecraft:cave_spider"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.SPIDER_EYE, 16));
        add(() -> new ItemStack(Items.STRING, 64));
        add(() -> new ItemStack(Blocks.COBWEB, 8));
    }}),
    WITCH("witch", WitchMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:witch"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.REDSTONE, 32));
        add(() -> new ItemStack(Items.GLOWSTONE_DUST, 32));
        add(() -> new ItemStack(Items.SUGAR, 64));
    }}),
    WITHER_SKELETON("wither_skeleton", WitherSkeletonMeta::new, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new VanillaMob("minecraft:wither_skeleton"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Blocks.WITHER_SKELETON_SKULL, 18));
        add(() -> new ItemStack(Items.COAL, 64));
    }}),
    WITHER("wither", WitherMeta::new, LivingMatterType.EXTRATERRESTRIAL, new ArrayList<>(){{
        add(new VanillaMob("minecraft:wither"));
    }}, new ArrayList<>(){{
        add(() -> new ItemStack(Items.NETHER_STAR, 3));
        add(() -> new ItemStack(Blocks.ANCIENT_DEBRIS, 1));
    }}),
    ZOMBIE("zombie", ZombieMeta::new, LivingMatterType.OVERWORLDIAN, new ArrayList<>(){{
        add(new VanillaMob("minecraft:zombie"));
        add(new VanillaMob("minecraft:husk"));
        add(new VanillaMob("minecraft:zombie_villager"));
        add(new VanillaMob("minecraft:drowned"));
        add(new VanillaMob("minecraft:zoglin"));
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
    public void addMob(String entityId, String langId) {
        mobs.add(new Mob(entityId, langId));
    }

    @Override
    public void addLoot(NonNullSupplier<ItemStack> itemStack) {
        loot.add(itemStack);
    }

    public static class VanillaMob extends Mob {
        public VanillaMob(String entityId) {
            super(entityId, entityId.replace("minecraft:", "entity.minecraft."));
        }
    }
}
