/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cobblestone.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.cobblestone.block.*;
import net.mcreator.cobblestone.CobblestoneMod;

public class CobblestoneModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CobblestoneMod.MODID);
	public static final DeferredBlock<Block> HAMMER_MACHINE;
	public static final DeferredBlock<Block> RAIN_CONNETOR;
	public static final DeferredBlock<Block> SLEVE;
	public static final DeferredBlock<Block> STONE_HEATER;
	public static final DeferredBlock<Block> STONE_MAKING_MACHINE;
	public static final DeferredBlock<Block> MECHANICAL_HOUSING;
	public static final DeferredBlock<Block> THERMAL_POWER_GENERATOR;
	public static final DeferredBlock<Block> ENERGY_STRONGE_TANK;
	public static final DeferredBlock<Block> PIPELINE;
	public static final DeferredBlock<Block> ELECTRIC_HAMMER_MACHINE;
	public static final DeferredBlock<Block> CHARGING_DEVICE;
	static {
		HAMMER_MACHINE = REGISTRY.register("hammer_machine", HammerMachineBlock::new);
		RAIN_CONNETOR = REGISTRY.register("rain_connetor", RainConnetorBlock::new);
		SLEVE = REGISTRY.register("sleve", SleveBlock::new);
		STONE_HEATER = REGISTRY.register("stone_heater", StoneHeaterBlock::new);
		STONE_MAKING_MACHINE = REGISTRY.register("stone_making_machine", StoneMakingMachineBlock::new);
		MECHANICAL_HOUSING = REGISTRY.register("mechanical_housing", MechanicalHousingBlock::new);
		THERMAL_POWER_GENERATOR = REGISTRY.register("thermal_power_generator", ThermalPowerGeneratorBlock::new);
		ENERGY_STRONGE_TANK = REGISTRY.register("energy_stronge_tank", EnergyStrongeTankBlock::new);
		PIPELINE = REGISTRY.register("pipeline", PipelineBlock::new);
		ELECTRIC_HAMMER_MACHINE = REGISTRY.register("electric_hammer_machine", ElectricHammerMachineBlock::new);
		CHARGING_DEVICE = REGISTRY.register("charging_device", ChargingDeviceBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}