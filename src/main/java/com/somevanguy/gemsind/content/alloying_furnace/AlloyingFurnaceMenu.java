package com.somevanguy.gemsind.content.alloying_furnace;

import com.somevanguy.gemsind.content.AllMenus;
import com.somevanguy.gemsind.content.base.BaseTransmutatorMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

public class AlloyingFurnaceMenu extends BaseTransmutatorMenu {
    public AlloyingFurnaceMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public AlloyingFurnaceMenu(int containerId, Inventory inv, BlockEntity blockEntity, ContainerData data) {
        super(AllMenus.ALLOYING_FURNACE_MENU.get(), containerId, inv, blockEntity, data);
        var itemHandler = this.blockEntity.getItemHandler();
        if (itemHandler != null) {
            addSlot(new SlotItemHandler(itemHandler, 0, 26, 54));
            addSlot(new SlotItemHandler(itemHandler, 1, 26, 18));

            addSlot(new SlotItemHandler(itemHandler, 2, 71, 18));
            addSlot(new SlotItemHandler(itemHandler, 3, 89, 18));
            addSlot(new SlotItemHandler(itemHandler, 4, 107, 18));
            addSlot(new SlotItemHandler(itemHandler, 5, 125, 18));

            addSlot(new SlotItemHandler(itemHandler, 6, 71, 54));
            addSlot(new SlotItemHandler(itemHandler, 7, 89, 54));
            addSlot(new SlotItemHandler(itemHandler, 8, 107, 54));
            addSlot(new SlotItemHandler(itemHandler, 9, 125, 54));
        }
    }

    public boolean isProgressing() {
        return this.data.get(0) > 0;
    }

    public int baseBurnWidth() {
        return 24;
    }

    public int getBurnWidth() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int burnWidth = baseBurnWidth();

        return maxProgress != 0 && progress != 0 ? 1+(progress-1) * burnWidth / maxProgress : 0;
    }

    public int baseLitHeight() {
        return 14;
    }

    public int getLitHeight() {
        int progress = this.data.get(2);
        int maxProgress = this.data.get(3);
        int litHeight = baseLitHeight();

        return maxProgress != 0 && progress != 0 ? 1+(progress-1) * litHeight / maxProgress : 0;
    }
}
