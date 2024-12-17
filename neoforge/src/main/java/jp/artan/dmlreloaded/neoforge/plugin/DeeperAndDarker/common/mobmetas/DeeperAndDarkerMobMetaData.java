package jp.artan.dmlreloaded.neoforge.plugin.DeeperAndDarker.common.mobmetas;

import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public abstract class DeeperAndDarkerMobMetaData extends MobMetaData {
    public DeeperAndDarkerMobMetaData(
            IMobKey key, String entityId,
            int simulationTickCost, int numberOfHearts,
            ItemPristineMatter pristineMatter, ResourceLocation entityName
    ) {
        super(key, entityId, simulationTickCost, numberOfHearts, pristineMatter, BuiltInRegistries.ITEM.get(new ResourceLocation(
                entityName.getNamespace(),
                entityName.getPath() + "_spawn_egg")
        ));
    }
}
