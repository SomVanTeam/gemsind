package com.somevanguy.gemsind.compat;

import com.somevanguy.gemsind.GemstoneIndustryMod;
import com.somevanguy.gemsind.content.AllBlocks;
import com.somevanguy.gemsind.content.AllRecipes;
import com.somevanguy.gemsind.content.alloying_furnace.AlloyingFurnaceScreen;
import com.somevanguy.gemsind.content.alloying_furnace.AlloyingRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIGemsindPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(GemstoneIndustryMod.MODID, "gemsind_jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        GemstoneIndustryMod.LOGGER.info("registering jei categories");
        registration.addRecipeCategories(new AlloyingRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();

        List<AlloyingRecipe> recipes = manager
                .getAllRecipesFor(AllRecipes.ALLOYING_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(AlloyingRecipeCategory.ALLOYING_TYPE, recipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AlloyingFurnaceScreen.class, 45, 34, 68 - 45, 52- 34, AlloyingRecipeCategory.ALLOYING_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(AllBlocks.ALLOYING_FURNACE.asItem(), AlloyingRecipeCategory.ALLOYING_TYPE);
    }
}
