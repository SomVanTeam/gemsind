package com.somevanguy.gemsind.content.alloying_furnace;

import com.somevanguy.gemsind.GemstoneIndustryMod;
import com.somevanguy.gemsind.content.base.BaseTransmutatorScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AlloyingFurnaceScreen extends BaseTransmutatorScreen<AlloyingFurnaceMenu> {
    public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath(GemstoneIndustryMod.MODID, "textures/gui/alloying_furnace.png");
    public static final ResourceLocation BURN = ResourceLocation.withDefaultNamespace("textures/gui/sprites/container/furnace/burn_progress.png");

    public AlloyingFurnaceScreen(AlloyingFurnaceMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(BACKGROUND, x, y, 0, 0, imageWidth, imageHeight, 256, 256);
        //if (menu.isProgressing()) {
            int burnWidth = this.menu.getBurnWidth();
            guiGraphics.blit(BURN, x + 46 + menu.baseBurnWidth() - burnWidth, y + 36, 0, 9, burnWidth, 16, 24, 16);
        //}
    }
}
