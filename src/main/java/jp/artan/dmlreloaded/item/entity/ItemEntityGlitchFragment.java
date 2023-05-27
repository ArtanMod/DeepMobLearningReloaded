package jp.artan.dmlreloaded.item.entity;

import jp.artan.dmlreloaded.init.ItemInit;
import jp.artan.dmlreloaded.item.ItemGlitchIngot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ItemEntityGlitchFragment extends ItemEntity {
    private long progress = 0;

    public ItemEntityGlitchFragment(Level p_149663_, double p_149664_, double p_149665_, double p_149666_, ItemStack p_149667_, double p_149668_, double p_149669_, double p_149670_) {
        super(p_149663_, p_149664_, p_149665_, p_149666_, p_149667_, p_149668_, p_149669_, p_149670_);
        setPickUpDelay(40);
    }

    public ItemEntityGlitchFragment(Level level, double x, double y, double z, ItemStack stack) {
        super(level, x, y, z, stack);
        setPickUpDelay(40);
    }

    public ItemEntityGlitchFragment(EntityType<? extends ItemEntity> type, Level level) {
        super(type, level);
        setPickUpDelay(40);
    }

    @Override
    public void tick() {
        super.tick();

        if(isInWater()) {
            AABB box = new AABB(position().x - 1, position().y - 1, position().z - 1, position().x + 1, position().y + 1, position().z + 1);
            List<ItemEntity> entities = level.getEntitiesOfClass(ItemEntity.class, box);

            progress++;
            boolean isValidEntities = isItemListValid(entities);
            if(!isValidEntities) {
                progress = 0;
            }



            if(!level.isClientSide) {
                if (progress >= 23) {
                    entities.forEach(entityItem -> {
                        if (!(entityItem.getItem().getItem() instanceof ItemGlitchIngot)) {
                            entityItem.getItem().shrink(1);
                        }
                    });

                    entities.forEach(entityItem -> {
                        if (entityItem.getItem().getCount() == 0) {
                            entityItem.discard();
                            progress = 0;
                        }
                    });

                    ItemEntity newItem = new ItemEntity(level, position().x, position().y + 0.6D, position().z, new ItemStack(ItemInit.GLITCH_INGOT.get(), 1));
                    newItem.setDefaultPickUpDelay();
                    level.addFreshEntity(newItem);
                    //level.addParticle(ParticleTypes.LARGE_SMOKE, (double) position().x+ 0.5d,(double) position().y+1,(double) position().z+0.5d, 0d, 0.03d, 0d);
                    //((ServerLevel) level).sendParticles(ParticleTypes.LARGE_SMOKE, position().x, position().y, position().z, 1, 0.5d, 1d, 0.5d, 0d);
                }
            }
        }
    }

    private boolean isItemListValid(List<ItemEntity> list) {
        // Don't check for entityGlitch fragment because if it wasn't here the method would not run
        boolean foundGold = false;
        boolean foundLapis = false;

        for (ItemEntity entityItem : list) {
            if(ItemStack.isSame(entityItem.getItem(), new ItemStack(Items.GOLD_INGOT))) {
                foundGold = true;
            }
            if(ItemStack.isSame(entityItem.getItem(), new ItemStack(Items.LAPIS_LAZULI, entityItem.getItem().getCount()))) {
                foundLapis = true;
            }
        }

        return foundGold && foundLapis;
    }
}

