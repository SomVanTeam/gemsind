package com.somevanguy.gemsind.content;

import com.somevanguy.gemsind.GemstoneIndustryMod;
import com.somevanguy.gemsind.content.acid_purifier.AcidPurifierMenu;
import com.somevanguy.gemsind.content.alloying_furnace.AlloyingFurnaceMenu;
import com.somevanguy.gemsind.content.centrifuge.CentrifugeMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, GemstoneIndustryMod.MODID);

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }

    public static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static final DeferredHolder<MenuType<?>, MenuType<AcidPurifierMenu>> ACID_PURIFIER_MENU = registerMenuType("acid_purifier_menu", AcidPurifierMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<CentrifugeMenu>> CENTRIFUGE_MENU = registerMenuType("centrifuge_menu", CentrifugeMenu::new);
    //public static final DeferredHolder<MenuType<?>, MenuType<TumblerMenu>> TUMBLER_MENU = registerMenuType("tumbler_menu", TumblerMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<AlloyingFurnaceMenu>> ALLOYING_FURNACE_MENU = registerMenuType("alloying_furnace_menu", AlloyingFurnaceMenu::new);
}
