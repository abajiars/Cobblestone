/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cobblestone.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.cobblestone.block.entity.*;
import net.mcreator.cobblestone.CobblestoneMod;

@EventBusSubscriber
public class CobblestoneModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CobblestoneMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HammerMachineBlockEntity>> HAMMER_MACHINE = register("hammer_machine", CobblestoneModBlocks.HAMMER_MACHINE, HammerMachineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RainConnetorBlockEntity>> RAIN_CONNETOR = register("rain_connetor", CobblestoneModBlocks.RAIN_CONNETOR, RainConnetorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SleveBlockEntity>> SLEVE = register("sleve", CobblestoneModBlocks.SLEVE, SleveBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StoneHeaterBlockEntity>> STONE_HEATER = register("stone_heater", CobblestoneModBlocks.STONE_HEATER, StoneHeaterBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StoneMakingMachineBlockEntity>> STONE_MAKING_MACHINE = register("stone_making_machine", CobblestoneModBlocks.STONE_MAKING_MACHINE, StoneMakingMachineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ThermalPowerGeneratorBlockEntity>> THERMAL_POWER_GENERATOR = register("thermal_power_generator", CobblestoneModBlocks.THERMAL_POWER_GENERATOR,
			ThermalPowerGeneratorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyStrongeTankBlockEntity>> ENERGY_STRONGE_TANK = register("energy_stronge_tank", CobblestoneModBlocks.ENERGY_STRONGE_TANK, EnergyStrongeTankBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PipelineBlockEntity>> PIPELINE = register("pipeline", CobblestoneModBlocks.PIPELINE, PipelineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElectricHammerMachineBlockEntity>> ELECTRIC_HAMMER_MACHINE = register("electric_hammer_machine", CobblestoneModBlocks.ELECTRIC_HAMMER_MACHINE,
			ElectricHammerMachineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChargingDeviceBlockEntity>> CHARGING_DEVICE = register("charging_device", CobblestoneModBlocks.CHARGING_DEVICE, ChargingDeviceBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MonitorBlockEntity>> MONITOR = register("monitor", CobblestoneModBlocks.MONITOR, MonitorBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HAMMER_MACHINE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RAIN_CONNETOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SLEVE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STONE_HEATER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STONE_MAKING_MACHINE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, THERMAL_POWER_GENERATOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ENERGY_STRONGE_TANK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PIPELINE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ELECTRIC_HAMMER_MACHINE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHARGING_DEVICE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MONITOR.get(), SidedInvWrapper::new);
	}
}