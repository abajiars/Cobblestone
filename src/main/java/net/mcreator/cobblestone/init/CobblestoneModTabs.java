/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cobblestone.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.cobblestone.CobblestoneMod;

@EventBusSubscriber
public class CobblestoneModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CobblestoneMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COBBLESTONES = REGISTRY.register("cobblestones",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.cobblestone.cobblestones")).icon(() -> new ItemStack(Blocks.COBBLESTONE)).displayItems((parameters, tabData) -> {
				tabData.accept(CobblestoneModItems.QUARTZ_DUST.get());
				tabData.accept(CobblestoneModItems.GLASS_DUST.get());
				tabData.accept(CobblestoneModItems.COAL_POWDER.get());
				tabData.accept(CobblestoneModItems.STONE_NUGGET.get());
				tabData.accept(CobblestoneModItems.COPPER_NUGGET.get());
				tabData.accept(CobblestoneModItems.QUARTZ_CRYSTAL.get());
				tabData.accept(CobblestoneModItems.WRENCH.get());
				tabData.accept(CobblestoneModItems.HAMMER.get());
				tabData.accept(CobblestoneModItems.STONE_STICK.get());
				tabData.accept(CobblestoneModItems.STONE_GEAR.get());
				tabData.accept(CobblestoneModBlocks.RAIN_CONNETOR.get().asItem());
				tabData.accept(CobblestoneModBlocks.HAMMER_MACHINE.get().asItem());
				tabData.accept(CobblestoneModBlocks.STONE_HEATER.get().asItem());
				tabData.accept(CobblestoneModBlocks.STONE_MAKING_MACHINE.get().asItem());
				tabData.accept(CobblestoneModBlocks.SLEVE.get().asItem());
				tabData.accept(CobblestoneModItems.STONESCREEN.get());
				tabData.accept(CobblestoneModBlocks.MECHANICAL_HOUSING.get().asItem());
				tabData.accept(CobblestoneModBlocks.THERMAL_POWER_GENERATOR.get().asItem());
				tabData.accept(CobblestoneModBlocks.ENERGY_STRONGE_TANK.get().asItem());
				tabData.accept(CobblestoneModBlocks.ELECTRIC_HAMMER_MACHINE.get().asItem());
				tabData.accept(CobblestoneModBlocks.CHARGING_DEVICE.get().asItem());
				tabData.accept(CobblestoneModBlocks.PIPELINE.get().asItem());
				tabData.accept(CobblestoneModItems.BATTERY.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(CobblestoneModItems.HAMMER.get());
		}
	}
}