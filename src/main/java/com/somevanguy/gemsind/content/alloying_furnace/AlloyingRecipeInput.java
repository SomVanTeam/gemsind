package com.somevanguy.gemsind.content.alloying_furnace;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

// inventory of an existing alloying furnace
public record AlloyingRecipeInput(NonNullList<ItemStack> elementGivers, int fluxCount) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return elementGivers.get(i);
    }

    @Override
    public int size() {
        return elementGivers.size();
    }
}
