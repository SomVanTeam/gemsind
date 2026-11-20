package com.somevanguy.gemsind.content.centrifuge;

import com.somevanguy.gemsind.GemstoneIndustryMod;
import com.somevanguy.gemsind.content.base.BaseTransmutatorScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CentrifugeScreen extends BaseTransmutatorScreen<CentrifugeMenu> {
    public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath(GemstoneIndustryMod.MODID, "textures/gui/centrifuge.png");
    public static final ResourceLocation LIT = ResourceLocation.withDefaultNamespace("textures/gui/sprites/container/furnace/lit_progress.png");

    public CentrifugeScreen(CentrifugeMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(BACKGROUND, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        if (menu.isProgressing()) {
            int litHeight = this.menu.getLitHeight();
            guiGraphics.blit(LIT, x + 26, y + 36 + menu.baseLitHeight() - litHeight, 0, menu.baseLitHeight() - litHeight, 14, litHeight, 14, 14);
        }
    }
}
