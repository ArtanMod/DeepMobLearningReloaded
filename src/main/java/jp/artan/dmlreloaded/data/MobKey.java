package jp.artan.dmlreloaded.data;

public enum MobKey implements IMobKey {
    BLAZE("blaze"),
    CREEPER("creeper"),
    DRAGON("dragon"),
    DROWNED("drowned"),
    ELDER_GUARDIAN("elder_guardian"),
    ENDERMAN("enderman"),
    EVOKER("evoker"),
    GHAST("ghast"),
    GUARDIAN("guardian"),
    HOGLIN("hoglin"),
    MAGMA_CUBE("magma_cube"),
    PHONTOM("phontom"),
    PIGLIN("piglin"),
    PILLAGER("pillager"),
    RAVAGER("ravager"),
    SHULKER("shulker"),
    SKELETON("skeleton"),
    SLIME("slime"),
    SPIDER("spider"),
    VINDICATOR("vindicator"),
    WITCH("witch"),
    WITHER_SKELETON("wither_skeleton"),
    WITHER("wither"),
    ZOMBIE("zombie");

    private final String mobKey;
    MobKey(String mobKey) {
        this.mobKey = mobKey;
    }
    @Override
    public String getMobKey() {
        return null;
    }
}
