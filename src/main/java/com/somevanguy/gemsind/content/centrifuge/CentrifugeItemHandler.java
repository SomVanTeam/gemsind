package com.somevanguy.gemsind.content.centrifuge;

import com.somevanguy.gemsind.content.base.BaseItemHandler;
import com.somevanguy.gemsind.content.AllDataComponents;
import com.somevanguy.gemsind.content.AllTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public class CentrifugeItemHandler extends BaseItemHandler {
    public static final int FUEL_SLOT = 0;

    public static boolean isGemSlot(int i) {
        return i > 0 && i <= 9;
    }

    public CentrifugeItemHandler(BlockEntity blockEntity, int slotCount) {
        super(blockEntity, slotCount);
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        boolean is_gem = stack.is(AllTags.Items.GEMSTONE);
        boolean is_fuel = stack.getBurnTime(null) > 0;
        Boolean used = stack.getOrDefault(AllDataComponents.CENTRIFUGE_USED, false);
        return (slot != FUEL_SLOT && is_gem && !is_fuel && !used) || (slot == FUEL_SLOT && is_fuel);
    }

    @Override
    public int getSlotLimit(int slot) {
        if (slot != 0) {
            return 1;
        }
        return super.getSlotLimit(slot);
    }

    // for hoppers
    record Automation(CentrifugeItemHandler mainHandler) implements IItemHandler {
        @Override
        public int getSlots() {
            return mainHandler.getSlots();
        }

        @Override
        public ItemStack getStackInSlot(int i) {
            return mainHandler.getStackInSlot(i);
        }

        @Override
        public ItemStack insertItem(int i, ItemStack itemStack, boolean b) {
            return mainHandler.insertItem(i, itemStack, b);
        }

        @Override
        public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
            ItemStack stack = getStackInSlot(slot);
            Boolean used = stack.getOrDefault(AllDataComponents.CENTRIFUGE_USED, false);
            if (isGemSlot(slot) && !used) {
                // do not extract if its not been used
                return ItemStack.EMPTY;
            }
            if (slot == FUEL_SLOT && stack.getBurnTime(null) > 0) {
                // do not extract fuel however spent fuel (or non fuel) can be extracted
                return ItemStack.EMPTY;
            }
            return mainHandler.extractItem(slot, amount, simulate);
        }

        @Override
        public int getSlotLimit(int i) {
            return mainHandler.getSlotLimit(i);
        }

        @Override
        public boolean isItemValid(int i, ItemStack itemStack) {
            return mainHandler.isItemValid(i, itemStack);
        }
    }
}
