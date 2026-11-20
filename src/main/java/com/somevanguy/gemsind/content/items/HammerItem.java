package com.somevanguy.gemsind.content.items;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import java.util.List;

public class HammerItem extends Item {
    public HammerItem(int strength, Properties properties) {
        this(true, strength, properties);
    }

    public final boolean usable;
    private final int strength;

    public int getStrength() {
        return strength; // TODO:recalculate strength with enchants
    }

    public float getProgressGainAgainst(int geodeToughness) {
        return 0.4f;
    }

    public HammerItem(boolean usable, int strength, Properties properties) {
        super(properties.stacksTo(1));
        this.usable = usable;
        this.strength = strength;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (usable) {
            if (Screen.hasShiftDown()) {
                tooltipComponents.add(Component.translatable("item.gemsind.hammer.tooltip"));
            } else {
                tooltipComponents.add(Component.translatable("item.gemsind.gem.holdshifttoexpand"));
            }
        } else {
            if (Screen.hasShiftDown()) {
                tooltipComponents.add(Component.translatable("item.gemsind.hammer.not_usable_tooltip"));
            } else {
                tooltipComponents.add(Component.translatable("item.gemsind.gem.holdshifttoexpand"));
            }
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
