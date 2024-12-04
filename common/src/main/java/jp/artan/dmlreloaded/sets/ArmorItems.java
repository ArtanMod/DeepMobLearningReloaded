package jp.artan.dmlreloaded.sets;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.ArmorItem;

public class ArmorItems<T extends ArmorItem> {

    public final RegistrySupplier<T> Helmet;
    public final RegistrySupplier<T> Chestplate;
    public final RegistrySupplier<T> Leggings;
    public final RegistrySupplier<T> Boots;

    public ArmorItems(
            RegistrySupplier<T> helmet,
            RegistrySupplier<T> chestplate,
            RegistrySupplier<T> leggings,
            RegistrySupplier<T> boots
    ) {
        this.Helmet = helmet;
        this.Chestplate = chestplate;
        this.Leggings = leggings;
        this.Boots = boots;
    }
}
