package jp.artan.dmlreloaded.block.entity;

import jp.artan.dmlreloaded.DeepMobLearningReloaded;
import jp.artan.dmlreloaded.common.energy.DeepEnergyStorage;
import jp.artan.dmlreloaded.config.EnergyCostConfig;
import jp.artan.dmlreloaded.init.BlockEntityInit;
import jp.artan.dmlreloaded.item.ItemPristineMatter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

public class BlockEntityExtractionChamber extends InventoryBlockEntity{

    public DeepEnergyStorage energyStorage;

    public boolean isCrafting = false;
    private LazyOptional<DeepEnergyStorage> energy;
    public int ticks = 0;
    public int percentDone = 0;
    private String currentPristineMatter = "";
    private ItemStack resultingItem = ItemStack.EMPTY;
    private int resultingIndex;
    private boolean selected;
    public int energyCost = EnergyCostConfig.FECOSTEXTRACTIONCHAMBER.get();
    private static Integer[] bannSlot = {0};

    public BlockEntityExtractionChamber(BlockPos pos, BlockState state) {
        super(BlockEntityInit.ENTITY_EXTRACTION_CHAMBER.get(), pos, state, 17, bannSlot);
        this.energyStorage = createEnergyStorage();
        this.energy = LazyOptional.of(() -> this.energyStorage);
    }

    private DeepEnergyStorage createEnergyStorage() {
        return new DeepEnergyStorage(this, 1000000, 25600 , 0, DeepMobLearningReloaded.DEBUG_MODE ? 1000000 : 0);
    }

    public ItemStack getPristine() {
        return inventory.getStackInSlot(0);
    }

    public int getProgress() {
        return percentDone;
    }

    public int getEnergy() {
        return energyStorage.getEnergyStored();
    }

    public boolean pristineChanged() {
        return !getPristine().isEmpty() && !currentPristineMatter.equals(((ItemPristineMatter) getPristine().getItem()).getMobKey().getId());
    }

    private boolean canStartCraft() {
        return canContinueCraft() && canInsertItem();
    }

    private boolean canContinueCraft() {
        return !resultingItem.isEmpty() && getPristine().getItem() instanceof ItemPristineMatter && hasEnergyForNextTick();
    }

    private boolean canInsertItem() {
        return inventory.canInsertItem(resultingItem);
    }

    private boolean hasEnergyForNextTick() {
        return energyStorage.getEnergyStored() >= energyCost;
    }

    public void tick(Level pLevel, BlockEntityExtractionChamber be) {
        ticks++;
        //System.out.println(!resultingItem.isEmpty());
        if(getPristine().isEmpty()) {
            this.selected = false;
            setResultingItem(ItemStack.EMPTY);
        }
        if(!pLevel.isClientSide) {
            // Used for dev purpose due to not having an in-build generator.
//             energyStorage.receiveEnergy(520, false);
//             energyStorage.setEnergy(520);
            if(pristineChanged()) {
                finishCraft(true);
                this.selected = false;
                currentPristineMatter = ((ItemPristineMatter) getPristine().getItem()).getMobKey().getId();
                setResultingItem(ItemStack.EMPTY);
                update();
                return;
            }

            if (!isCrafting) {
                if (canStartCraft()) {
                    isCrafting = true;
                }
            } else {
                if (!canContinueCraft()) {
                    finishCraft(true);
                    return;
                }

                if(hasEnergyForNextTick()) {
                    this.energyStorage.setEnergy(this.energyStorage.getEnergyStored() - energyCost);
                    percentDone++;
                }

                // Notify while crafting every 5sec, this is done more frequently when the container is open
                if (ticks % (DeepMobLearningReloaded.TICKS_TO_SECOND * 15) == 0) {
                    update();
                }

                if (percentDone == 50) {
                    finishCraft(false);
                }
            }

            // Save to disk every 5 seconds if energy changed
            //doStaggeredDiskSave(100);
        }
    }

    /*private void doStaggeredDiskSave(int divisor) {
        if(ticks % divisor == 0) {
            if(currentEnergy != energyStorage.getEnergyStored()) {
                // Save to disk every 5 seconds if energy changed
                currentEnergy = energyStorage.getEnergyStored();
                setChanged();
            }
        }
    }*/

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setResultingItem(ItemStack stack) {
        this.resultingItem = stack;
    }

    public void setResultingIndex(int i) {
        this.resultingIndex = i;
    }

    public int getResultingIndex() {
        return resultingIndex;
    }

    public void finishCraft(boolean abort) {
        isCrafting = false;
        percentDone = 0;
        if(!abort) {
            ItemStack remainder = inventory.setInFirstAvailableSlot(resultingItem);
            while (!remainder.isEmpty()) {
                remainder = inventory.setInFirstAvailableSlot(remainder);
            }

            getPristine().shrink(1);
        }
        setChanged();
        update();
    }


    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.energy.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("energy", energyStorage.getEnergyStored());
        tag.putInt("craftingProgress", percentDone);
        tag.putInt("index", resultingIndex);
        //tag.put("pageHandler", pageHandler.serializeNBT());
        tag.put("resultingItem", resultingItem.serializeNBT());
        tag.putBoolean("isCrafting", isCrafting);
        tag.putBoolean("selected", selected);
        tag.putString("currentPristine", currentPristineMatter);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        energyStorage.setEnergy(pTag.getInt("energy"));
        percentDone = pTag.getInt("craftingProgress");
        resultingIndex = pTag.getInt("index");
        isCrafting = pTag.getBoolean("isCrafting");
        selected = pTag.getBoolean("selected");
        //pageHandler.deserializeNBT(pTag.getCompound("pageHandler"));
        resultingItem = ItemStack.of(pTag.getCompound("resultingItem"));
        currentPristineMatter = pTag.contains("currentPristine") ? pTag.getString("currentPristine") : "";
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == CapabilityEnergy.ENERGY ? this.energy.cast() : super.getCapability(cap, side);
    }
}
