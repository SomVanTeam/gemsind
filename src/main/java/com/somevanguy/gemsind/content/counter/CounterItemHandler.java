package com.somevanguy.gemsind.content.counter;

import com.somevanguy.gemsind.content.base.BaseItemHandler;
import com.somevanguy.gemsind.content.items.GeodeItem;
import com.somevanguy.gemsind.content.items.HammerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class CounterItemHandler extends BaseItemHandler {
    public CounterItemHandler(BlockEntity blockEntity) {
        super(blockEntity, 1);
    }

    @Override
    public int getSlotLimit(int slot) {
        return 1;
    }

    record Automation(ItemStackHandler mainHandler) implements IItemHandler {
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
        public ItemStack extractItem(int slot, int amount, boolean b) {
            var stack = getStackInSlot(slot);
            if (stack.getItem() instanceof GeodeItem || stack.getItem() instanceof HammerItem) {
                return ItemStack.EMPTY;
            }
            return mainHandler.extractItem(slot, amount, b);
        }

        @Override
        public int getSlotLimit(int i) {
            return 1;
        }

        @Override
        public boolean isItemValid(int i, ItemStack itemStack) {
            return mainHandler.isItemValid(i, itemStack);
        }
    }
}
