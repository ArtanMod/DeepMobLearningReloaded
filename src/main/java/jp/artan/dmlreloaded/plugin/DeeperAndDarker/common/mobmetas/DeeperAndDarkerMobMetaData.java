package jp.artan.dmlreloaded.plugin.DeeperAndDarker.common.mobmetas;

import jp.artan.dmlreloaded.common.IMobKey;
import jp.artan.dmlreloaded.common.mobmetas.MobMetaData;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public abstract class DeeperAndDarkerMobMetaData extends MobMetaData {
    public DeeperAndDarkerMobMetaData(
            IMobKey key, String entityId,
            int simulationTickCost, int numberOfHearts,
            ItemPristineMatter pristineMatter, ResourceLocation entityName
    ) {
        super(key, entityId, simulationTickCost, numberOfHearts, pristineMatter, Registry.ITEM.get(new ResourceLocation(
                entityName.getNamespace(),
                entityName.getPath() + "_spawn_egg")
        ));
    }
}
