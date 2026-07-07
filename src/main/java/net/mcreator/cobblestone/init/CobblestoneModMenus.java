/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cobblestone.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.cobblestone.world.inventory.StoneMakingMachineGUIMenu;
import net.mcreator.cobblestone.world.inventory.StoneHeaterGUIMenu;
import net.mcreator.cobblestone.world.inventory.HammerMachineGUIMenu;
import net.mcreator.cobblestone.world.inventory.ESTGUIMenu;
import net.mcreator.cobblestone.network.MenuStateUpdateMessage;
import net.mcreator.cobblestone.CobblestoneMod;

import java.util.Map;

public class CobblestoneModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, CobblestoneMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<HammerMachineGUIMenu>> HAMMER_MACHINE_GUI = REGISTRY.register("hammer_machine_gui", () -> IMenuTypeExtension.create(HammerMachineGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<StoneHeaterGUIMenu>> STONE_HEATER_GUI = REGISTRY.register("stone_heater_gui", () -> IMenuTypeExtension.create(StoneHeaterGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<StoneMakingMachineGUIMenu>> STONE_MAKING_MACHINE_GUI = REGISTRY.register("stone_making_machine_gui", () -> IMenuTypeExtension.create(StoneMakingMachineGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ESTGUIMenu>> ESTGUI = REGISTRY.register("estgui", () -> IMenuTypeExtension.create(ESTGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof CobblestoneModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}