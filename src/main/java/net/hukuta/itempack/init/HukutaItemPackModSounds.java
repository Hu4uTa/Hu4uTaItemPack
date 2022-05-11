
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hukuta.itempack.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HukutaItemPackModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("hukuta_item_pack", "dobichacrafttable"),
				new SoundEvent(new ResourceLocation("hukuta_item_pack", "dobichacrafttable")));
		REGISTRY.put(new ResourceLocation("hukuta_item_pack", "hodbacrafttable"),
				new SoundEvent(new ResourceLocation("hukuta_item_pack", "hodbacrafttable")));
		REGISTRY.put(new ResourceLocation("hukuta_item_pack", "padeniecrafttable"),
				new SoundEvent(new ResourceLocation("hukuta_item_pack", "padeniecrafttable")));
		REGISTRY.put(new ResourceLocation("hukuta_item_pack", "postavilcrafttable"),
				new SoundEvent(new ResourceLocation("hukuta_item_pack", "postavilcrafttable")));
		REGISTRY.put(new ResourceLocation("hukuta_item_pack", "slomalcrafttable"),
				new SoundEvent(new ResourceLocation("hukuta_item_pack", "slomalcrafttable")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
