/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cobblestone.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.cobblestone.item.*;
import net.mcreator.cobblestone.CobblestoneMod;

public class CobblestoneModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CobblestoneMod.MODID);
	public static final DeferredItem<Item> HAMMER;
	public static final DeferredItem<Item> STONE_STICK;
	public static final DeferredItem<Item> STONE_GEAR;
	public static final DeferredItem<Item> HAMMER_MACHINE;
	public static final DeferredItem<Item> RAIN_CONNETOR;
	public static final DeferredItem<Item> SLEVE;
	public static final DeferredItem<Item> STONESCREEN;
	public static final DeferredItem<Item> STONE_NUGGET;
	public static final DeferredItem<Item> STONE_HEATER;
	public static final DeferredItem<Item> GLASS_DUST;
	public static final DeferredItem<Item> QUARTZ_DUST;
	public static final DeferredItem<Item> STONE_MAKING_MACHINE;
	public static final DeferredItem<Item> MECHANICAL_HOUSING;
	public static final DeferredItem<Item> WRENCH;
	public static final DeferredItem<Item> THERMAL_POWER_GENERATOR;
	public static final DeferredItem<Item> ENERGY_STRONGE_TANK;
	public static final DeferredItem<Item> PIPELINE;
	static {
		HAMMER = REGISTRY.register("hammer", HammerItem::new);
		STONE_STICK = REGISTRY.register("stone_stick", StoneStickItem::new);
		STONE_GEAR = REGISTRY.register("stone_gear", StoneGearItem::new);
		HAMMER_MACHINE = block(CobblestoneModBlocks.HAMMER_MACHINE);
		RAIN_CONNETOR = block(CobblestoneModBlocks.RAIN_CONNETOR);
		SLEVE = block(CobblestoneModBlocks.SLEVE);
		STONESCREEN = REGISTRY.register("stonescreen", StonescreenItem::new);
		STONE_NUGGET = REGISTRY.register("stone_nugget", StoneNuggetItem::new);
		STONE_HEATER = block(CobblestoneModBlocks.STONE_HEATER);
		GLASS_DUST = REGISTRY.register("glass_dust", GlassDustItem::new);
		QUARTZ_DUST = REGISTRY.register("quartz_dust", QuartzDustItem::new);
		STONE_MAKING_MACHINE = block(CobblestoneModBlocks.STONE_MAKING_MACHINE);
		MECHANICAL_HOUSING = block(CobblestoneModBlocks.MECHANICAL_HOUSING);
		WRENCH = REGISTRY.register("wrench", WrenchItem::new);
		THERMAL_POWER_GENERATOR = block(CobblestoneModBlocks.THERMAL_POWER_GENERATOR);
		ENERGY_STRONGE_TANK = block(CobblestoneModBlocks.ENERGY_STRONGE_TANK);
		PIPELINE = block(CobblestoneModBlocks.PIPELINE);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}