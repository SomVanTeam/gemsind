package com.somevanguy.gemsind.content.centrifuge;

import com.somevanguy.gemsind.content.AllMenus;
import com.somevanguy.gemsind.content.base.BaseTransmutatorMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

public class CentrifugeMenu extends BaseTransmutatorMenu {
    public CentrifugeMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public CentrifugeMenu(int containerId, Inventory inv, BlockEntity be, ContainerData data) {
        super(AllMenus.CENTRIFUGE_MENU.get(), containerId, inv, be, data);
        var itemHandler = this.blockEntity.getItemHandler();
        if (itemHandler != null) {
            addSlot(new SlotItemHandler(itemHandler, 0, 26, 54));
            addSlot(new SlotItemHandler(itemHandler, 1, 98, 35));
            addSlot(new SlotItemHandler(itemHandler, 2, 98, 12));
            addSlot(new SlotItemHandler(itemHandler, 3, 119, 14));
            addSlot(new SlotItemHandler(itemHandler, 4, 121, 35));
            addSlot(new SlotItemHandler(itemHandler, 5, 119, 56));
            addSlot(new SlotItemHandler(itemHandler, 6, 98, 58));
            addSlot(new SlotItemHandler(itemHandler, 7, 77, 56));
            addSlot(new SlotItemHandler(itemHandler, 8, 75, 35));
            addSlot(new SlotItemHandler(itemHandler, 9, 77, 14));
        }
    }

    public boolean isProgressing() {
        return this.data.get(0) > 0;
    }

    public int baseLitHeight() {
        return 14;
    }

    public int getLitHeight() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int litHeight = baseLitHeight();

        return maxProgress != 0 && progress != 0 ? 1+(progress-1) * litHeight / maxProgress : 0;
    }
}
