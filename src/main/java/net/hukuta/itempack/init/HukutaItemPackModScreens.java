
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hukuta.itempack.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.hukuta.itempack.client.gui.CustomCraftTableGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HukutaItemPackModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(HukutaItemPackModMenus.CUSTOM_CRAFT_TABLE_GUI, CustomCraftTableGUIScreen::new);
		});
	}
}
