
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hukuta.itempack.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.hukuta.itempack.block.entity.CustomCraftTableBlockEntity;
import net.hukuta.itempack.HukutaItemPackMod;

public class HukutaItemPackModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			HukutaItemPackMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CUSTOM_CRAFT_TABLE = register("custom_craft_table",
			HukutaItemPackModBlocks.CUSTOM_CRAFT_TABLE, CustomCraftTableBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
